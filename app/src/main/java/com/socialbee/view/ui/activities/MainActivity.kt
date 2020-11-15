package com.socialbee.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.firebase.firestore.FirebaseFirestore
import com.socialbee.R
import com.socialbee.model.Producer
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBar(findViewById(R.id.toolbarMain))
        configNav()

        /*
        val jsonProducers = JSONArray("[\n" +
                "            {\n" +
                "                'description' : 'Mariano Ledesma, farmacéutico, apasionado por los estilos IPA, con tonos ácidos.',\n" +
                "                'address' : 5,\n" +
                "                'image' : 'https://instagram.faep8-1.fna.fbcdn.net/v/t51.2885-15/e35/41793745_901841086677387_8516599375872769580_n.jpg',\n" +
                "                'latitude' : -32.4773196,\n" +
                "                'longitude' : -58.2482894,\n" +
                "                'name' : 'Mariano Ledesma',\n" +
                "                'website' : 'meledesma',\n" +
                "                'phone' : 'CEO LAGASH'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Mariano Ledesma, farmacéutico, apasionado por los estilos IPA, con tonos ácidos.',\n" +
                "                'address' : 5,\n" +
                "                'image' : 'https://instagram.faep8-1.fna.fbcdn.net/v/t51.2885-15/e35/41793745_901841086677387_8516599375872769580_n.jpg',\n" +
                "                'latitude' : -32.4773196,\n" +
                "                'longitude' : -58.2482894,\n" +
                "                'name' : 'Mariano Ledesma',\n" +
                "                'website' : 'meledesma',\n" +
                "                'phone' : 'CEO LAGASH'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Mariano Ledesma, farmacéutico, apasionado por los estilos IPA, con tonos ácidos.',\n" +
                "                'address' : 5,\n" +
                "                'image' : 'https://instagram.faep8-1.fna.fbcdn.net/v/t51.2885-15/e35/41793745_901841086677387_8516599375872769580_n.jpg',\n" +
                "                'latitude' : -32.4773196,\n" +
                "                'longitude' : -58.2482894,\n" +
                "                'name' : 'Mariano Ledesma',\n" +
                "                'website' : 'meledesma',\n" +
                "                'phone' : 'CEO LAGASH'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Mariano Ledesma, farmacéutico, apasionado por los estilos IPA, con tonos ácidos.',\n" +
                "                'address' : 5,\n" +
                "                'image' : 'https://instagram.faep8-1.fna.fbcdn.net/v/t51.2885-15/e35/41793745_901841086677387_8516599375872769580_n.jpg',\n" +
                "                'latitude' : -32.4773196,\n" +
                "                'longitude' : -58.2482894,\n" +
                "                'name' : 'Mariano Ledesma',\n" +
                "                'website' : 'meledesma',\n" +
                "                'phone' : 'CEO LAGASH'\n" +
                "            },\n" +
                "        ]")


        val firebaseFirestore = FirebaseFirestore.getInstance()

        for (i in 0 until (jsonProducers.length()-1)){
            val aux = jsonProducers.get(i) as JSONObject
            var producer = Producer()
            producer.name = aux.getString("name")
            producer.description = aux.getString("description")
            producer.image = aux.getString("image")
            producer.phone = aux.getString("phone")
            producer.website = aux.getString("website")
            producer.address = aux.getString("address")
            producer.latitude = aux.getDouble("latitude")
            producer.longitude = aux.getDouble("longitude")
            firebaseFirestore.collection("producers").document().set(producer)
        }
        */

}

private fun configNav(){
NavigationUI.setupWithNavController(bnvMenu, Navigation.findNavController(this,R.id.fragContent))
}
}