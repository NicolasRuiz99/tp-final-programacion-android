package com.socialbee.view.ui.fragments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.socialbee.R
import com.socialbee.model.Producer
import com.socialbee.viewmodel.ProducerViewModel

class MapFragment : Fragment(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private lateinit var viewModel: ProducerViewModel
    private var initial_location = LatLng(-32.4773196,-58.2482894)
    private lateinit var producers: List<Producer>

    override fun onCreateView (
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_map, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        viewModel = ViewModelProviders.of(this).get(ProducerViewModel::class.java)
        viewModel.refresh()
    }

    override fun onMapReady(googleMap: GoogleMap?) {

        val bitmapDraw = context?.applicationContext?.let{
            ContextCompat.getDrawable(it, R.drawable.map_icon) as BitmapDrawable
        }
        val smallMarker = bitmapDraw?.bitmap?.let { Bitmap.createScaledBitmap(it, 70, 100, false) }
        val markerIcon = BitmapDescriptorFactory.fromBitmap(smallMarker)

        val zoom = 12f
        val centerMap = initial_location

        viewModel.listProducers.observe(viewLifecycleOwner, Observer<List<Producer>>{ producers ->
            producers.let {
                this.producers = producers
                producers.forEach{
                    producer ->
                    val location = LatLng(producer.latitude, producer.longitude)
                    googleMap?.addMarker(MarkerOptions()
                        .position(location)
                        .title(producer.name)
                        .icon(markerIcon)
                    )
                }


                googleMap?.setOnMarkerClickListener(this)
            }
        })

        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(centerMap,zoom))

        googleMap?.setMapStyle(MapStyleOptions.loadRawResourceStyle(context,R.raw.custom_map))

    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        var selectedProducer = Producer()
        producers.forEach{
            producer ->
            if (producer.name == p0?.title) {
                selectedProducer = producer
            }
        }
        var bundle = bundleOf("producer" to selectedProducer)
        findNavController().navigate(R.id.producersDetailDialogFragment, bundle)

        return true
    }
}