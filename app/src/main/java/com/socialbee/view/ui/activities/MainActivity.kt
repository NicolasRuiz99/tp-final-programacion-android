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
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'Lakemont 6306',\n" +
                "                'image' : 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYB4-k6JYBKTsUp9p_tyUksjuTVQUUDYBI7w&usqp=CAU',\n" +
                "                'latitude' : -32.472663,\n" +
                "                'longitude' : -58.247599,\n" +
                "                'name' : 'Blue Ridge Honey Company',\n" +
                "                'website' : 'http://www.blueridgehoneycompany.com',\n" +
                "                'phone' : '7067826722'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'Hall Rd 9340',\n" +
                "                'image' : 'https://cdn.shopify.com/s/files/1/0866/3986/products/IMG_0150_1024x1024.jpg?v=1557506053',\n" +
                "                'latitude' : -32.4773196,\n" +
                "                'longitude' : -58.2482894,\n" +
                "                'name' : 'Bee-Haven Honey Farm',\n" +
                "                'website' : 'https://beehavenfl.com',\n" +
                "                'phone' : '8638255245'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'U.S. Hwy 190 8060',\n" +
                "                'image' : 'https://cdn11.bigcommerce.com/s-y1vw8ho6/images/stencil/700x280/whf_1502309375__39332.original.png',\n" +
                "                'latitude' : -32.47528,\n" +
                "                'longitude' : -58.277428,\n" +
                "                'name' : 'Walker Honey Farm',\n" +
                "                'website' : 'https://www.walkerhoneyfarm.com',\n" +
                "                'phone' : '2549832899'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'SW 114th St 9800',\n" +
                "                'image' : 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcREwdNkRhRvY2y2jx5Ch-VKO3Ma-_hqk0egUw&usqp=CAU',\n" +
                "                'latitude' : -32.495037,\n" +
                "                'longitude' : -58.264539,\n" +
                "                'name' : 'Bee My Honey LLC',\n" +
                "                'website' : 'https://www.beemyhoney.buzz/index.html',\n" +
                "                'phone' : '3053232363'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'Bear Creek Rd 12751',\n" +
                "                'image' : 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFPRgt8JKkBNQ3vZxPQXg1Fhja01wNbZm8yA&usqp=CAU',\n" +
                "                'latitude' : -32.464047,\n" +
                "                'longitude' : -58.237304,\n" +
                "                'name' : 'Hewetts Honey Farm',\n" +
                "                'website' : 'https://www.hewettshoney.com',\n" +
                "                'phone' : '2053440166'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'ND-56 5427',\n" +
                "                'image' : 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQG2Y2OUjNWfbxiVdUBwfbEz7ztVJ_DVQt7Rg&usqp=CAU',\n" +
                "                'latitude' : -32.465625,\n" +
                "                'longitude' : -58.242095,\n" +
                "                'name' : 'Miller Honey Farms',\n" +
                "                'website' : 'https://www.millerhoneyfarms.com',\n" +
                "                'phone' : '7014853350'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'US-8 3279',\n" +
                "                'image' : 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTb0GCow3cMx7T7IE1fJ_ElLNHm5nYlQ9uTEg&usqp=CAU',\n" +
                "                'latitude' : -32.470346,\n" +
                "                'longitude' : -58.246989,\n" +
                "                'name' : 'Hansen Honey Farm',\n" +
                "                'website' : 'https://hansenhoneyfarm.com',\n" +
                "                'phone' : '7153690383'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'Old Alabama Rd #111 3000',\n" +
                "                'image' : 'https://i5.walmartimages.com/asr/7510a516-3098-4855-b4e9-d1df19e45d6f.ecd7e689a9e0659bdd92aa4e62320656.jpeg?odnWidth=612&odnHeight=612&odnBg=ffffff',\n" +
                "                'latitude' : -32.465012,\n" +
                "                'longitude' : -58.253908,\n" +
                "                'name' : 'Georgia Honey Farm',\n" +
                "                'website' : 'https://georgiahoneyfarm.com',\n" +
                "                'phone' : '4702687941'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'SE Ebbtide Ave 5219',\n" +
                "                'image' : 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQEvlmf-vF0tzCkOvwNYEvJ1TRqNi5Nbzf1yw&usqp=CAU',\n" +
                "                'latitude' : -32.470881,\n" +
                "                'longitude' : -58.263240,\n" +
                "                'name' : 'Hani Honey Company',\n" +
                "                'website' : 'https://hanihoneycompany.com',\n" +
                "                'phone' : '7722145165'\n" +
                "            },\n" +
                "            {\n" +
                "                'description' : 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut metus justo, fringilla nec sem eleifend, ornare eleifend risus. Nunc vel laoreet metus, ut pulvinar libero. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Curabitur varius eros ut urna tempus, in lacinia tellus commodo. Maecenas in enim magna.',\n" +
                "                'address' : 'Dickerson Rd 1206 South',\n" +
                "                'image' : 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTkfVYNeU2e9AHN2g1apXiagkuVLatP7E8Zkg&usqp=CAU',\n" +
                "                'latitude' : -32.493870,\n" +
                "                'longitude' : -58.249428,\n" +
                "                'name' : 'Johnsons Honey Farm',\n" +
                "                'website' : 'https://franklinfarmersmarket.com/farmer/johnsons-honey-farm',\n" +
                "                'phone' : '6158597253'\n" +
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