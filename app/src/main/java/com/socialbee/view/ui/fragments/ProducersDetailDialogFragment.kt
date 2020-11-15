package com.socialbee.view.ui.fragments

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.socialbee.R
import com.socialbee.model.Producer
import kotlinx.android.synthetic.main.fragment_producers_detail_dialog.*

class ProducersDetailDialogFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setStyle(STYLE_NORMAL,R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_producers_detail_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarProducer.navigationIcon = ContextCompat.getDrawable(view.context,R.drawable.ic_close_white)
        toolbarProducer.setTitleTextColor(Color.WHITE)
        toolbarProducer.setNavigationOnClickListener{
            dismiss()
        }

        val producer = arguments?.getSerializable("producer") as Producer
        toolbarProducer.title = producer.name
        tvDetailProducerName.text = producer.name
        tvDetailProducerAddress.text = producer.address
        tvDetailProducerDescription.text = producer.description

        Glide.with(this)
            .load(producer.image)
            .apply(RequestOptions.circleCropTransform())
            .into(ivDetailProducerImage)

        ivDetailProducerPhone.setOnClickListener{
            val intent = Intent(Intent(Intent.ACTION_DIAL).apply{
                data = Uri.parse("tel:${producer.phone}")
            })
            startActivity(intent)
        }

        ivDetailProducerWebsite.setOnClickListener{
            val intent = Intent(Intent(Intent.ACTION_VIEW))
            intent.data = Uri.parse(producer.website)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT)

    }

}