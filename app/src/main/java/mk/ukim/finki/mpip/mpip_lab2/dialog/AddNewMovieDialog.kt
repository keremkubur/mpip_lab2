package mk.ukim.finki.mpip.mpip_lab2.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import mk.ukim.finki.mpip.mpip_lab2.R
import kotlin.random.Random

class AddNewMovieDialog: AppCompatDialogFragment() {

    private lateinit var listener: AddMovieDialogListener;

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val layoutInflater = activity?.layoutInflater

        val view = layoutInflater?.inflate(R.layout.new_movie_dialog, null)

        val title: EditText? = view?.findViewById(R.id.mNewTitle)
        val actors: EditText? = view?.findViewById(R.id.mNewActors)
        val director: EditText? = view?.findViewById(R.id.mNewDirector)
        val description: EditText? = view?.findViewById(R.id.mNewDescription)

        val index = Random.nextInt(10,10000)

        builder.setView(view)
            .setTitle("Add A New Movie")
            .setPositiveButton("Confirm") { _, _ ->
                val titleValue: String = title?.text.toString()
                val actorsValue: String = actors?.text.toString()
                val directorValue: String = director?.text.toString()
                val descriptionValue: String = description?.text.toString()

                listener.addMovie(titleValue, actorsValue, directorValue, index, descriptionValue)
            }
            .setNegativeButton("Cancel") { _, _ ->

            }

        return builder.create()
    }

    fun setAddMovieDialogListener(listener: AddMovieDialogListener) {
        this.listener = listener
    }

    interface AddMovieDialogListener {
        fun addMovie(title: String, actors: String, director: String, id: Int, description: String)
    }
}