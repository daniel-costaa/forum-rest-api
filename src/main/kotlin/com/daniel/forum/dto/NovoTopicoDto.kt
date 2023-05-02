package com.daniel.forum.dto

import jakarta.validation.constraints.NotEmpty


data class NovoTopicoDto(
    @field:NotEmpty
    val titulo: String,
    @field:NotEmpty
    val mensagem: String,
    val idCurso: Long,
    val idAutor: Long
)
