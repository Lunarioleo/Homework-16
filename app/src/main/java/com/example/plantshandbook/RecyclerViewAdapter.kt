package com.example.plantshandbook


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class RecyclerViewAdapter( var items: ArrayList<Character>): RecyclerView.Adapter<RecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val listItemView = LayoutInflater.from(parent.context).inflate(R.layout.plant_item, parent, false)
        return RecyclerViewHolder(listItemView)
    }

    override fun getItemCount(): Int  = items.count()



    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.title.text = items[position].name
        Picasso.get()
            .load(items[position].images.lg)
            .into(holder.image)


    }
}
class RecyclerViewHolder( item: View): RecyclerView.ViewHolder(item){
    val image = item.findViewById<ImageView>(R.id.img)
    val title = item.findViewById<TextView>(R.id.text)

}