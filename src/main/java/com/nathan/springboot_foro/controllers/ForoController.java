package com.nathan.springboot_foro.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nathan.springboot_foro.dto.ForoDto;
import com.nathan.springboot_foro.service.ForoService;

@RestController
@RequestMapping("/foros")
public class ForoController {

    @Autowired
    private ForoService foroService;

    @GetMapping
    public CollectionModel<EntityModel<ForoDto>> getAllForos() {

        List<ForoDto> foros = foroService.getAllForo();
        List<EntityModel<ForoDto>> foroResource = 
            foros.stream().map(
                foro -> EntityModel.of(
                    foro,
                    WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(
                            this.getClass()
                        ).getForoById(foro.getForoId())
                    ).withSelfRel()
                )
            )
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllForos());
        CollectionModel<EntityModel<ForoDto>> resources = CollectionModel.of(foroResource, linkTo.withRel("foros"));

        return resources;
    }

    @GetMapping("/{id}")
    public EntityModel<ForoDto> getForoById(@PathVariable Long id) {
        Optional<ForoDto> foro = foroService.getForoById(id);

        if (foro.isPresent()) {
            return EntityModel.of(foro.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getForoById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllForos()).withRel("all-foros"));
        } else {
            throw new ForoNotFoundExcepcion("El foro no ha sido encontrado");
        }

    }

    @PostMapping
    public EntityModel<ForoDto> createForo(@RequestBody ForoDto foro) {
        ForoDto createdForo = foroService.createForo(foro);

        return EntityModel.of(createdForo,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getForoById(createdForo.getForoId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllForos()).withRel("all-foros"));

    }

    @PutMapping({"/{id}"})
    public EntityModel<ForoDto> setForo(@PathVariable Long id, @RequestBody ForoDto foro) {
        ForoDto updatedForo = foroService.updateForo(id, foro);
        return EntityModel.of(updatedForo,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getForoById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllForos()).withRel("all-foros"));
    }

    @DeleteMapping({"/{id}"})
    public void deleteForo(@PathVariable Long id) {
        foroService.deleteForo(id);
    }

}
