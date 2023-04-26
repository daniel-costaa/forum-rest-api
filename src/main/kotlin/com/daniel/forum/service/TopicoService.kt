package com.daniel.forum.service

import com.daniel.forum.dto.NovoTopicoDto
import com.daniel.forum.model.Topico
import org.springframework.stereotype.Service

@Service
class TopicoService(
    private val topicos: MutableList<Topico> = mutableListOf(),
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
) {
    fun listar(): List<Topico> = topicos

    fun buscarPorId(id: Long): Topico? {
        return topicos.find { it.id == id }
    }

    fun cadastrar(dto: NovoTopicoDto) {
        val curso = cursoService.buscarPorId(dto.idCurso)
        val usuario = usuarioService.buscarPorId(dto.idAutor)

        if(curso != null && usuario != null) {
            val novoTopico = Topico(
                id = (topicos.size + 1).toLong(),
                titulo = dto.titulo,
                mensagem = dto.mensagem,
                curso = curso,
                autor = usuario
            )
            topicos.add(novoTopico)
        }
    }
}