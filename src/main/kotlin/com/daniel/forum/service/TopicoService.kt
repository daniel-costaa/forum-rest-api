package com.daniel.forum.service

import com.daniel.forum.dto.NovoTopicoDto
import com.daniel.forum.mapper.TopicoMapper
import com.daniel.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicos: MutableList<Topico> = mutableListOf(),
    private val topicoMapper: TopicoMapper,
) {
    fun listar(): List<Topico> = topicos

    fun buscarPorId(id: Long): Topico? {
        return topicos.find { it.id == id }
    }

    fun cadastrar(dto: NovoTopicoDto) {
        topicoMapper.map(dto)?.let { topico ->
            topico.id = topicos.size.toLong() + 1
            topicos.add(topico)
        }
    }
}