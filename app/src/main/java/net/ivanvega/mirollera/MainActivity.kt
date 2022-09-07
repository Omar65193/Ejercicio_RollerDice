package net.ivanvega.mirollera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var boton: Button
    lateinit var lbl: TextView
    lateinit var img: ImageView

    lateinit var lbl2: TextView
    lateinit var img2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_roller)


        lbl = findViewById(R.id.lblSaludo)
        boton = findViewById(R.id.btnRoller)
        img = findViewById(R.id.imgRoller)

        lbl2 = findViewById(R.id.lblSaludo2)
        img2 = findViewById(R.id.imgRoller2)


        img.setImageDrawable(resources.getDrawable(R.drawable.dice_3))
        img2.setImageDrawable(resources.getDrawable(R.drawable.dice_3))

        boton.setOnClickListener {
            val imagen = getRandomDiceImage(lbl)
            val imagen2 = getRandomDiceImage(lbl2)

            img.setImageResource(imagen)
            img2.setImageResource(imagen2)

        }
    }

    private fun getRandomDiceImage (lbl : TextView) : Int {
        val al = (1..6).random()

        Toast.makeText(
            applicationContext,
            "Boton presionado aleatorio " + al,
            Toast.LENGTH_SHORT
        ).show()

        val idImagenAl = when (al){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        lbl.text = al.toString()
        return idImagenAl
    }

}