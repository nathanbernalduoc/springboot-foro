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

import com.nathan.springboot_foro.dto.ComentarioDto;
import com.nathan.springboot_foro.service.ComentarioService;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping
    public CollectionModel<EntityModel<ComentarioDto>> getAllComentarios() {

        List<ComentarioDto> comentarios = comentarioService.getAllComentario();
        List<EntityModel<ComentarioDto>> comentarioResource = 
            comentarios.stream().map(
                comentario -> EntityModel.of(
                    comentario,
                    WebMvcLinkBuilder.linkTo(
                        WebMvcLinkBuilder.methodOn(
                            this.getClass()
                        ).getComentarioById(comentario.getComentarioId())
                    ).withSelfRel()
                )
            )
            .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllComentarios());
        CollectionModel<EntityModel<ComentarioDto>> resources = CollectionModel.of(comentarioResource, linkTo.withRel("comentarios"));

        return resources;
    }

    @GetMapping("/{id}")
    public EntityModel<ComentarioDto> getComentarioById(@PathVariable Long id) {
        Optional<ComentarioDto> comentario = comentarioService.getComentarioById(id);

        if (comentario.isPresent()) {
            return EntityModel.of(comentario.get(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getComentarioById(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllComentarios()).withRel("all-comentarios"));
        } else {
            throw new ComentarioNotFoundExcepcion("El comentario no ha sido encontrado");
        }

    }

    @PostMapping
    public EntityModel<ComentarioDto> createComentario(@RequestBody ComentarioDto comentario) {
        ComentarioDto createdComentario = comentarioService.createComentario(comentario);

        return EntityModel.of(createdComentario,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getComentarioById(createdComentario.getComentarioId())).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllComentarios()).withRel("all-comentarios"));

    }

    @PutMapping({"/{id}"})
    public EntityModel<ComentarioDto> setComentario(@PathVariable Long id, @RequestBody ComentarioDto comentario) {
        ComentarioDto updatedComentario = comentarioService.updateComentario(id, comentario);
        return EntityModel.of(updatedComentario,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getComentarioById(id)).withSelfRel(),
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllComentarios()).withRel("all-comentarios"));
    }

    @DeleteMapping({"/{id}"})
    public void deleteComentario(@PathVariable Long id) {
        comentarioService.deleteComentario(id);
    }

}
