package com.example.countrydata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrydata.databinding.ActivityMainBinding
import com.example.countrydata.model.Example
import com.friendlist.country.NameAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    companion object{

        var data = ArrayList<Example>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var apiInterface = Apiclient.getRetrofit().create(ApiInterface::class.java)

        apiInterface.getPosts().enqueue(object : Callback<List<Example>>{
            override fun onResponse(
                call: Call<List<Example>>,
                response: Response<List<Example>>
            ) {
                data = response.body() as ArrayList<Example>
                binding.recyleview.layoutManager=LinearLayoutManager(this@MainActivity)
                var Datalist=response.body()
                val adapter = NameAdapter(Datalist!!)
                binding.recyleview.adapter = adapter

            }

            override fun onFailure(call: Call<List<Example>>, t: Throwable) {
                Log.e(TAG, "onFailure: ++++++++++++++++ "+t.message )
            }

        })
    }

}