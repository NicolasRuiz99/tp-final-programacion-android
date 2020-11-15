package com.socialbee.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.socialbee.R
import com.socialbee.model.Producer
import com.socialbee.view.adapter.ProducersAdapter
import com.socialbee.view.adapter.ProducersListener
import com.socialbee.viewmodel.ProducerViewModel
import kotlinx.android.synthetic.main.fragment_producers.*

class ProducersFragment : Fragment(), ProducersListener {

    private lateinit var producersAdapter: ProducersAdapter
    private lateinit var viewModel: ProducerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_producers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ProducerViewModel::class.java)
        viewModel.refresh()

        producersAdapter = ProducersAdapter(this)

        rvProducer.apply {
            layoutManager = GridLayoutManager(context,2)
            adapter = producersAdapter
        }

        observerViewModel()
    }

    fun observerViewModel(){
        viewModel.listProducers.observe(viewLifecycleOwner, Observer<List<Producer>>{speakers ->
            speakers.let{
                producersAdapter.updateData((speakers))
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if(it != null)
                rlBaseProducers.visibility = View.INVISIBLE
        })
    }

    override fun onProducerClicked(producer: Producer, position: Int) {
        var bundle = bundleOf("producer" to producer)
        findNavController().navigate(R.id.producersDetailDialogFragment,bundle)
    }
}