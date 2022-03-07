package parra.daniel.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_movie_details)

        val bundle = intent.extras
        var ns = 0
        var id = -1
        var title = ""

        if (bundle != null) {

            ns = bundle.getInt("numberSeats")
            id = bundle.getInt("pos")
            title = bundle.getString("title")!!

            iv_movie_image.setImageResource(bundle.getInt("header"))
            tv_movie_title.setText(bundle.getString("title"))
            tv_movie_desc.setText(bundle.getString("description"))
            tv_seats_left.setText("${ns} seats available.")
        }

        if (ns == 0) {
            btn_buy_tickets.isEnabled = false
        } else {
            btn_buy_tickets.setOnClickListener() {
                val intent: Intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)

                this.startActivity(intent)

            }
        }

    }
}