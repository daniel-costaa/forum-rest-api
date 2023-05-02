package com.daniel.forum.mapper

import com.daniel.forum.dto.NovoTopicoDto
import com.daniel.forum.model.Topico
import com.daniel.forum.service.CursoService
import com.daniel.forum.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService,
) : Mapper<NovoTopicoDto, Topico> {
    override fun map(t: NovoTopicoDto): Topico? {
        val curso = cursoService.buscarPorId(t.idCurso)
        val usuario = usuarioService.buscarPorId(t.idAutor)

        return if(curso != null && usuario != null) {
             Topico(
                titulo = t.titulo,
                mensagem = t.mensagem,
                curso = curso,
                autor = usuario
            )
        } else {
            null
        }
    }
}