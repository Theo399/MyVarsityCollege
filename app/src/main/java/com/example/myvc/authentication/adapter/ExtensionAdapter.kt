package com.example.myvc.authentication.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myvc.R
import com.example.myvc.authentication.database.Extension

class ExtensionAdapter(private var extensions: List<Extension>, context: Context) :
    RecyclerView.Adapter<ExtensionAdapter.ExtensionViewHolder>() {

    class ExtensionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val fullName: TextView = itemView.findViewById(R.id.fullName)
        val campus: TextView = itemView.findViewById(R.id.campus)
        val delivery: TextView = itemView.findViewById(R.id.delivery)
        val registration: TextView = itemView.findViewById(R.id.registration)
        val qualification: TextView = itemView.findViewById(R.id.qualification)
        val reason: TextView = itemView.findViewById(R.id.reason)
        val previous: TextView = itemView.findViewById(R.id.previous)
        val assessment1: TextView = itemView.findViewById(R.id.assessment1)
        val missed: TextView = itemView.findViewById(R.id.missed)
        val assessment2: TextView = itemView.findViewById(R.id.assessment2)
        val replacement: TextView = itemView.findViewById(R.id.replacement)
        val module: TextView = itemView.findViewById(R.id.module)
        val status: TextView = itemView.findViewById(R.id.status)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExtensionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.extension_item, parent, false)
        return ExtensionViewHolder(view)
    }

    override fun getItemCount(): Int = extensions.size

    override fun onBindViewHolder(holder: ExtensionViewHolder, position: Int) {
        val extension = extensions[position]
        holder.fullName.text = extension.fullName
        holder.campus.text = extension.campus
        holder.delivery.text = extension.delivery
        holder.registration.text = extension.registration
        holder.qualification.text = extension.qualification
        holder.reason.text = extension.reason
        holder.previous.text = extension.previous
        holder.assessment1.text = extension.assessment1
        holder.missed.text = extension.missed
        holder.assessment2.text = extension.assessment2
        holder.replacement.text = extension.replacement
        holder.module.text = extension.module
        holder.status.text = extension.status
    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshExtension(newE: List<Extension>) {
        extensions = newE
        notifyDataSetChanged()
    }
}