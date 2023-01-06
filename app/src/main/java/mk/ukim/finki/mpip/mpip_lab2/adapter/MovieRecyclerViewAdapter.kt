package mk.ukim.finki.mpip.mpip_lab2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.mpip.mpip_lab2.R
import mk.ukim.finki.mpip.mpip_lab2.model.Movie

class MovieRecyclerViewAdapter(val context: Context, private val movies: MutableList<Movie>, private val onMovieClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<MovieRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View, private val onMovieClick: (position: Int) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener{
        val id: TextView = view.findViewById(R.id.mId)
        val title: TextView = view.findViewById(R.id.mName)
        val director: TextView = view.findViewById(R.id.mDirector)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = absoluteAdapterPosition
            onMovieClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view) { position ->
            onMovieClick(
                position
            )
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = movies[position]

        holder.id.text = "${currentMovie.id}"
        holder.title.text = "${currentMovie.name}"
        holder.director.text = "${currentMovie.director}"
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}