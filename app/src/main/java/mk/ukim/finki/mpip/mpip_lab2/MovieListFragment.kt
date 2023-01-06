package mk.ukim.finki.mpip.mpip_lab2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import mk.ukim.finki.mpip.mpip_lab2.adapter.MovieRecyclerViewAdapter
import mk.ukim.finki.mpip.mpip_lab2.api.FakeAPI
import mk.ukim.finki.mpip.mpip_lab2.dialog.AddNewMovieDialog
import mk.ukim.finki.mpip.mpip_lab2.model.Movie
import androidx.navigation.fragment.findNavController

class MovieListFragment : Fragment(), AddNewMovieDialog.AddMovieDialogListener {

    private lateinit var data: MutableList<Movie>
    private val service = FakeAPI()
    private lateinit var adapter : MovieRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        data = service.getAllMovies()

        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.movieRecyclerView);
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovieRecyclerViewAdapter(view.context, data){ position ->
            onMovieClick(
                position
            )
        }

        recyclerView.adapter = adapter

        val dialogButton = view.findViewById<Button>(R.id.addMovie)
        dialogButton.setOnClickListener{
            openDialog()
        }

        return view
    }

    private fun onMovieClick(position: Int){
        val action = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(data[position])
        findNavController().navigate(action)
    }

    private fun openDialog() {
        val dialogInstance = AddNewMovieDialog()
        dialogInstance.setAddMovieDialogListener(this)
        fragmentManager?.let { dialogInstance.show(it, "Add A Movie") }
    }

    override fun addMovie(
        title: String,
        actors: String,
        director: String,
        id: Int,
        description: String
    ) {
        val actorsList: MutableList<String>  = actors.split(";") as MutableList<String>
        val movie = Movie(id.toLong(), title, description, director, actorsList)
        service.addMovie(movie)
        adapter.notifyItemChanged(0)
    }
}