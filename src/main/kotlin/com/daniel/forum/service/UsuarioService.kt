package com.daniel.forum.service

import com.daniel.forum.model.Usuario
import org.springframework.stereotype.Service

@Service
class UsuarioService(val usuarios: MutableList<Usuario> = mutableListOf()) {
    init {
        val usuario1 = Usuario(1, "User 1", "email1")
        val usuario2 = Usuario(2, "User 2", "email2")

        usuarios.addAll(listOf(usuario1, usuario2))
    }

    fun buscarPorId(id: Long): Usuario? = usuarios.find { it.id == id }
}