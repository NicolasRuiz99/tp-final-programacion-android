package com.socialbee.view.adapter

import com.socialbee.model.Producer

interface ProducersListener {
    fun onProducerClicked (conference: Producer,position: Int){

    }
}