package mk.ukim.finki.mpip.mpip_lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import mk.ukim.finki.mpip.mpip_lab2.model.Movie
import androidx.navigation.fragment.findNavController

class MovieDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)

        val title = view.findViewById<TextView>(R.id.movieTitle)
        val id = view.findViewById<TextView>(R.id.movieId)
        val director = view.findViewById<TextView>(R.id.movieDirector)
        val description = view.findViewById<TextView>(R.id.movieDescrpition)

        val movie: Movie = MovieDetailsFragmentArgs.fromBundle(requireArguments()).movie

        title.text = movie.name
        id.text = "ID: ${movie.id}"
        director.text = "Director: ${movie.director}"
        description.text = "${movie.description}"

        val listView = view.findViewById<ListView>(R.id.movieActors)

        listView.adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, movie.actors!!)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.buttonBack).setOnClickListener(){
            findNavController().navigate(R.id.action_movieDetailsFragment_to_movieListFragment)
        }
    }

}