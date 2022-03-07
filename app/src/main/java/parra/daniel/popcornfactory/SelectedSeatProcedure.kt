package parra.daniel.popcornfactory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_selected_seat_procedure.*

class SelectedSeatProcedure : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_selected_seat_procedure)

        var bundle = intent.extras
        var seatNumber = -1

        if (bundle != null) {
            seatNumber = bundle.getInt("seatNumber")
        }

        tv_selected_seat.setText("Selected seat: ${seatNumber}")
        btn_buy_ticket_final.setOnClickListener() {

            if (et_name.text.isNotEmpty() && et_name.text.isNotBlank()){
                var intent: Intent = Intent()

                intent.putExtra("seatReserved", seatNumber)

                Toast.makeText(this, "Enjoy the movie! :D", Toast.LENGTH_LONG).show()

                setResult(RESULT_OK, intent)

                finish()
            } else {
                Toast.makeText(this, "Please enter your name.", Toast.LENGTH_LONG).show()
            }
        }

    }
}