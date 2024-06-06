package com.example.appsemoc5

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import kotlinx.coroutines.launch

class SemocViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SemocRepository

    val palestras: LiveData<List<Palestra>>
    val minicursos: LiveData<List<Minicurso>>
    val pessoas: LiveData<List<Pessoa>>

    init {
        val db = Room.databaseBuilder(application, AppDatabase::class.java, "semoc-database").build()
        repository = SemocRepository(RetrofitInstance.api, db)
        palestras = repository.palestras
        minicursos = repository.minicursos
        pessoas = repository.pessoas
    }

    fun fetchAndStoreData() {
        viewModelScope.launch {
            repository.fetchAndStoreData()
        }
    }
}
