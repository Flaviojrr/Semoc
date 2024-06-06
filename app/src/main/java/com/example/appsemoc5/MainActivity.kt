package com.example.appsemoc5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: SemocViewModel
    lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(SemocViewModel::class.java)
        viewModel.fetchAndStoreData()

        setupNavigation()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "semoc-database"
        ).build()
    }

    private fun setupNavigation() {
    }
}
