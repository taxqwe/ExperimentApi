package com.taxqwe.example.expetimentscores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taxqwe.example.expetimentscores.databinding.ExperimentsFragmentBinding

abstract class ExperimentsFragment : Fragment() {

    private var _binding: ExperimentsFragmentBinding? = null

    private val binding get() = _binding!!

    private val adapter by lazy {createAdapter()}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ExperimentsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    abstract fun provideListOfExperiments() : List<ExperimentItem>

    private fun createAdapter(): ExperimentsAdapter {
        return ExperimentsAdapter(provideListOfExperiments())
    }
}