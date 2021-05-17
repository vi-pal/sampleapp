package com.example.sampleapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.sampleapp.base.BaseFragment
import com.example.sampleapp.databinding.FragmentEmployeeBinding
import com.example.sampleapp.presentation.adapters.EmployeeAdapter
import com.example.sampleapp.presentation.viewmodels.EmployeeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmployeeFragment : BaseFragment<FragmentEmployeeBinding>() {

    override val viewModel: EmployeeViewModel by viewModel()
    override lateinit var binding: FragmentEmployeeBinding

    private val adapter: EmployeeAdapter = EmployeeAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEmployeeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun initViews() {
        viewModel.requestEmployees()
        initAdapter()
    }

    override fun initData() {

    }

    private fun initAdapter() {
        adapter.onItemClick = {
            // Not implemented yet
            Toast.makeText(requireContext(), it.name, Toast.LENGTH_SHORT).show()
        }
        binding.rvEmployee.adapter = adapter
    }

    override fun subscribeUi() {
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), it.toString(), Toast.LENGTH_SHORT).show()
        })
        viewModel.isSuccess.observe(viewLifecycleOwner, Observer {
            if(it) {
                Toast.makeText(requireContext(), "Loaded successfully", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(requireContext(), "Not loaded", Toast.LENGTH_SHORT).show()
        })
        viewModel.employees.observe(viewLifecycleOwner, Observer {
            adapter.update(it)
        })
    }
}