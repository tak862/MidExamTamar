package com.example.midexamtamar

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieRecyclerView(val movies: MutableList<Model>) :
    RecyclerView.Adapter<MovieRecyclerView.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText: TextView = itemView.findViewById(R.id.textView)
        val releaseDateText: TextView = itemView.findViewById(R.id.textView3)
        val countryText: TextView = itemView.findViewById(R.id.textView2)
        val imageView: ImageView = itemView.findViewById(R.id.imageView2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.nameText.text = movie.name
        holder.releaseDateText.text = "Release: ${movie.releaseData}"
        holder.countryText.text = "Country: ${movie.country}"
        Picasso.get()
            .load(movie.imageUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error_image)
            .into(holder.imageView)


        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, AboutActivity::class.java)
            intent.putExtra("name", movie.name)
            intent.putExtra("description", movie.description)
            context.startActivity(intent)
        }
    }

    fun removeItem(position: Int) {
        movies.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int = movies.size
}

