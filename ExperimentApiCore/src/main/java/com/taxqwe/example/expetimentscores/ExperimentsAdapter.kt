package com.taxqwe.example.expetimentscores

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.taxqwe.example.expetimentscores.databinding.ExperimentItemBinding

class ExperimentsAdapter(private val experiments: List<ExperimentItem>) : RecyclerView.Adapter<ExperimentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExperimentViewHolder {
        return ExperimentViewHolder(
            ExperimentItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ).root
        )
    }

    override fun onBindViewHolder(holder: ExperimentViewHolder, position: Int) {
        ExperimentItemBinding.bind(holder.itemView).apply {
            doExperiment.text = experiments[position].shortDescription
            doExperiment.setOnClickListener { experiments[position].experiment.invoke() }

        }
    }

    override fun getItemCount() = experiments.size

}

class ExperimentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)