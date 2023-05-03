package com.daniel.forum.controller

import com.daniel.forum.dto.AtualizaTopicoDto
import com.daniel.forum.dto.NovoTopicoDto
import com.daniel.forum.model.Topico
import com.daniel.forum.service.TopicoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.util.*

@RestController
@RequestMapping("/topicos")
class TopicoController(private val service: TopicoService) {
    @GetMapping
    fun listar(): List<Topico> = service.listar()

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): Topico? {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastrar(@RequestBody @Valid dto: NovoTopicoDto, uriBuilder: UriComponentsBuilder): ResponseEntity<Topico>? {
        return service.cadastrar(dto)?.let {
            val uri = uriBuilder.path("/topicos/${it.id}").build().toUri()
            ResponseEntity.created(uri).body(it)
        } ?: ResponseEntity.badRequest().build()
    }

    @PutMapping
    fun atualizar(@RequestBody @Valid dto: AtualizaTopicoDto): ResponseEntity<Topico> {
        return service.atualizar(dto)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.badRequest().build()
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}