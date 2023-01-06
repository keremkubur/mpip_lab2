package mk.ukim.finki.mpip.mpip_lab2.api

import mk.ukim.finki.mpip.mpip_lab2.model.Movie

class FakeAPI {

    private val movies: MutableList<Movie>  = mutableListOf(
        Movie(1, "Avatar",
            "Jake Sully lives with his newfound family formed on the extrasolar moon Pandora. Once a familiar threat returns to finish what was previously started, Jake must work with Neytiri and the army of the Na'vi race to protect their home.",
            "James Cameron", mutableListOf("Sam Worthington", "Zoe Saldana")),
        Movie(2, "The Godfather",
            "The aging patriarch of an organized crime dynasty in postwar New York City transfers control of his clandestine empire to his reluctant youngest son.",
            "Mario Puzo", mutableListOf("Marlon Brando", "Al Pacino")),
        Movie(3, "The Dark Knight",
            "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice.",
            "Christopher Nolan", mutableListOf("Christian Bale", "Heath Ledger")),
    )

    fun getAllMovies(): MutableList<Movie> {
        return movies;
    }

    fun addMovie(movie: Movie) : MutableList<Movie> {
        movies.add(movie)
        return movies
    }

}