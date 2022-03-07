package parra.daniel.popcornfactory

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_seat_selection.*

class SeatSelection : AppCompatActivity() {

    private var selectedSeat: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_seat_selection)

        val bundle = intent.extras
        var posMovie = -1
        selectedSeat = -1

        if (bundle != null) {
            tv_title_seats.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
        }

        btn_confirm.setOnClickListener() {
            // TODO: Agregar logica para reservar el lugar seleccionado por el usuario.
            // TODO: Hacer una nueva actividad donde se vea el resumen de la compra (que se agregue el nombre del cliente y su asiento seleccionado).

            if (selectedSeat == -1) {
                Toast.makeText(this, "Please select a seat.", Toast.LENGTH_LONG).show()
            } else {
                val intent: Intent = Intent(this, SelectedSeatProcedure::class.java)

                intent.putExtra("seatNumber", selectedSeat)

                this.startActivityForResult(intent, 1)
            }

        }

        row1.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (checkedId > -1) {
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
                selectedSeat = checkedId
            }
        }

        row2.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
                selectedSeat = checkedId
            }
        }

        row3.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
                selectedSeat = checkedId
            }
        }

        row4.setOnCheckedChangeListener { radioGroup, checkedId ->
            if (checkedId > -1) {
                row1.clearCheck()
                row2.clearCheck()
                row3.clearCheck()

                row4.check(checkedId)
                selectedSeat = checkedId
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // If you have multiple activities returning results then you should include unique request codes for each
        if (requestCode == 1) {

            // The result code from the activity started using startActivityForResults
            if (resultCode == Activity.RESULT_OK) {
                if (data != null) {
                    var bundle = data.extras

                    if (bundle != null) {
                        var seat = bundle.getInt("seatReserved")

                        if (seat <= 5) {
                            row1.getChildAt(seat - 1).setBackgroundResource(R.drawable.radio_disabled)
                            row1.getChildAt(seat - 1).isEnabled = false
                        } else if (seat <= 10) {
                            row2.getChildAt(seat - 6).setBackgroundResource(R.drawable.radio_disabled)
                            row2.getChildAt(seat - 6).isEnabled = false
                        } else if (seat <= 15) {
                            row3.getChildAt(seat - 11).setBackgroundResource(R.drawable.radio_disabled)
                            row3.getChildAt(seat - 11).isEnabled = false
                        } else {
                            row4.getChildAt(seat - 16).setBackgroundResource(R.drawable.radio_disabled)
                            row4.getChildAt(seat - 16).isEnabled = false
                        }
                    }
                    row1.clearCheck()
                    row2.clearCheck()
                    row3.clearCheck()
                    row4.clearCheck()
                    selectedSeat = -1
                }
            }
        }
    }

}