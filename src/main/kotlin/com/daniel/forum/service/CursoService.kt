package com.daniel.forum.service

import com.daniel.forum.model.Curso
import org.springframework.stereotype.Service

@Service
class CursoService(val cursos: MutableList<Curso> = mutableListOf()) {
    init {
        val curso1 = Curso(1, "Curso 1", "Categoria 1")
        val curso2 = Curso(2, "Curso 2", "Categoria 2")

        cursos.addAll(listOf(curso1, curso2))
    }

    fun buscarPorId(id: Long): Curso? = cursos.find { it.id == id }
}