package com.example.appsemoc5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PessoasFragment : Fragment() {
    private lateinit var viewModel: SemocViewModel
    private lateinit var adapter: PessoasAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_pessoas, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view_pessoas)
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter = PessoasAdapter()
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(requireActivity()).get(SemocViewModel::class.java)
        viewModel.pessoas.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        return view
    }
}
