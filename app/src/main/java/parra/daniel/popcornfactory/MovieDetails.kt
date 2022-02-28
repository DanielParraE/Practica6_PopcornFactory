package parra.daniel.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val bundle = intent.extras

        if (bundle != null) {
            iv_movie_image.setImageResource(bundle.getInt("header"))
            tv_movie_title.setText(bundle.getString("title"))
            tv_movie_desc.setText(bundle.getString("description"))
        }

    }
}