package com.example.appsemoc5

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Palestra::class, Minicurso::class, Pessoa::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun palestraDao(): PalestraDao
    abstract fun minicursoDao(): MinicursoDao
    abstract fun pessoaDao(): PessoaDao
}
