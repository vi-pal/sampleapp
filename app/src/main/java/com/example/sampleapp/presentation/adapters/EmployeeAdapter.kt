package com.example.sampleapp.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.data.Employee
import com.example.sampleapp.databinding.ItemEmployeeBinding

class EmployeeAdapter(
    private var employees: List<Employee>
) : RecyclerView.Adapter<EmployeeAdapter.ViewHolder>() {

    var onItemClick: ((Employee) -> Unit)? = null

    inner class ViewHolder(val binding: ItemEmployeeBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEmployeeBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvName.text = employees[position].name
        holder.binding.tvSalary.text = employees[position].salary.toString()
        holder.binding.clItem.setOnClickListener {
            onItemClick?.invoke(employees[position])
        }
    }

    override fun getItemCount() = employees.size

    fun update(employees: List<Employee>) {
        this.employees = employees
        notifyDataSetChanged()
    }
}