package com.example.appsemoc5

import androidx.room.PrimaryKey

data class Palestra(
    @PrimaryKey val id: Int,
    val titulo: String,
    val descricao: String,
    val palestranteId: Int,
    val horario: String
)

data class Minicurso(
    @PrimaryKey val id: Int,
    val titulo: String,
    val descricao: String,
    val instrutorId: Int,
    val horario: String
)

data class Pessoa(
    @PrimaryKey val id: Int,
    val nome: String,
    val biografia: String,
    val fotoUrl: String
)

