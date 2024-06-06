package com.example.appsemoc5

import androidx.lifecycle.LiveData

class SemocRepository(private val apiService: SemocApiService, private val db: AppDatabase) {
    val palestras: LiveData<List<Palestra>> = db.palestraDao().getAll()
    val minicursos: LiveData<List<Minicurso>> = db.minicursoDao().getAll()
    val pessoas: LiveData<List<Pessoa>> = db.pessoaDao().getAll()

    suspend fun fetchAndStoreData() {
        val palestras = apiService.getPalestras()
        db.palestraDao().insertAll(*palestras.toTypedArray())

        val minicursos = apiService.getMinicursos()
        db.minicursoDao().insertAll(*minicursos.toTypedArray())

        val pessoas = apiService.getPessoas()
        db.pessoaDao().insertAll(*pessoas.toTypedArray())
    }
}
