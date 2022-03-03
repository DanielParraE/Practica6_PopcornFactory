package parra.daniel.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seat_selection.*

class SeatSelection : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)

        val bundle = intent.extras
        var posMovie = -1

        if (bundle != null) {
            tv_title_seats.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
        }

        btn_confirm.setOnClickListener() {
            // TODO: Agregar logica para reservar el lugar seleccionado por el usuario.
            // TODO: Hacer una nueva actividad donde se vea el resumen de la compra (que se agregue el nombre del cliente y su asiento seleccionado).

            Toast.makeText(this, "Enjoy the movie! :D", Toast.LENGTH_LONG).show()

        }

        row1.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (checkedId > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)

            }
        }

        row2.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)

            }
        }

        row3.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)

            }
        }

        row4.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()

                row4.check(checkedId)

            }
        }

    }
}