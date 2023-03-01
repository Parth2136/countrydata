package com.example.countrydata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.countrydata.databinding.ActivityMain2Binding
import com.example.countrydata.databinding.ActivityMainBinding
import com.example.countrydata.model.Example

class MainActivity2 : AppCompatActivity() {

    lateinit var s:List<Example>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var pos = intent.getIntExtra("pos",0)
        var num = intent.getStringExtra("name")
        var cap = intent.getStringExtra("capital")
        var reg = intent.getStringExtra("region")
        var are = intent.getDoubleExtra("area",0.0)
        var time = intent.getStringArrayListExtra("timezone")
        var pop = intent.getIntExtra("population",0)
        Glide.with(applicationContext).load(MainActivity.data.get(pos).flags?.png).into(binding.imageV)

        binding.txtCap.text = "capital :- " + cap.toString()
        binding.txtName.text="Name :-  "+(num).toString()
        binding.txtReg.text="Region :- "+(reg).toString()
        binding.txtPop.text ="Population :- "+ pop.toInt().toString()
        binding.txtAre.text = "Area :- "+are?.toInt().toString()
        binding.txtTime.text ="Time :- "+time.toString()

    }
}