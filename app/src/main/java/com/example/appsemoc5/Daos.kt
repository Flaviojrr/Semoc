package com.example.appsemoc5

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PalestraDao {
    @Query("SELECT * FROM Palestra")
    fun getAll(): LiveData<List<Palestra>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg palestras: Palestra)
}

@Dao
interface MinicursoDao {
    @Query("SELECT * FROM Minicurso")
    fun getAll(): LiveData<List<Minicurso>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg minicursos: Minicurso)
}

@Dao
interface PessoaDao {
    @Query("SELECT * FROM Pessoa")
    fun getAll(): LiveData<List<Pessoa>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg pessoas: Pessoa)
}
