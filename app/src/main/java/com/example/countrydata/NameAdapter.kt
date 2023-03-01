package com.friendlist.country

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countrydata.MainActivity2
import com.example.countrydata.R
import com.example.countrydata.model.Example
import java.util.ArrayList


class NameAdapter(var mList: List<Example>) :
    RecyclerView.Adapter<NameAdapter.ViewHolder>() {

        var dataList = mList
    lateinit var context: Context


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

        val imageView: ImageView = itemView.findViewById(R.id.flage)
        val textView: TextView = itemView.findViewById(R.id.text)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(dataList[position]) {

            val ItemsViewModel = mList[position]

            Glide.with(context).load(ItemsViewModel.flags?.png).into(holder.imageView)
            holder.textView.text = ItemsViewModel.name

            holder.itemView.setOnClickListener {

                var intent = Intent(context, MainActivity2::class.java)
                intent.putExtra("region", ItemsViewModel.region)
                intent.putExtra("name", ItemsViewModel.name)
                intent.putExtra("capital", ItemsViewModel.capital)
                intent.putExtra("area",ItemsViewModel.area)
                intent.putExtra("population", ItemsViewModel.population)
                intent.putExtra("currencies", listOf(currencies).toString())
                intent.putExtra("pos",position)
intent.putStringArrayListExtra("timezone", ItemsViewModel.timezones as ArrayList<String>?)
                context.startActivity(intent)
            }

        }
    }

    override fun getItemCount(): Int {

        return mList.size
    }
}


