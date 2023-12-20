package com.example.puzzel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.INVISIBLE
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import java.util.Random
import kotlin.random.Random.Default

class MainActivity : AppCompatActivity() {
    lateinit var iv_card1:ImageView
    lateinit var iv_card2:ImageView
    lateinit var iv_player1:TextView
    lateinit var iv_player2:TextView
    lateinit var iv_war:TextView
    lateinit var b_deal:Button

    lateinit var random: Random

    var player1 = 0
    var player2 = 0

    var cardsArray = intArrayOf(
        R.drawable.karta103,
        R.drawable.karta10l,
        R.drawable.karta23,

        R.drawable.kartajl,
        R.drawable.kartajo,
        R.drawable.karta7l,
        R.drawable.kartas9,
        R.drawable.kartaqs,
        R.drawable.kartaq3,
        R.drawable.kartaqk,
        R.drawable.kartakl,
        R.drawable.kartakk,
        R.drawable.kartakj,
        R.drawable.kartak3,
        R.drawable.karta8l,
        R.drawable.karta10l,
        R.drawable.karta23



    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        random = Random()
        iv_card2 = findViewById(R.id.iv_card2)
        iv_card1 = findViewById(R.id.iv_card1)

        iv_card1.setImageResource(R.drawable.karta7l)
        iv_card2.setImageResource(R.drawable.karta7l)
        iv_player2 =findViewById(R.id.iv_player2)
        iv_player1 =findViewById(R.id.iv_player1)

        iv_war = findViewById(R.id.iv_war)
        iv_war.visibility = INVISIBLE


        b_deal = findViewById(R.id.b_deal)
        b_deal.setOnClickListener(  View.OnClickListener { iv_war.visibility = INVISIBLE

            val card1 = random.nextInt(cardsArray.size)
            val card2 = random.nextInt(cardsArray.size)
            setCardImage(card1, iv_card1)
            setCardImage(card2, iv_card2)
            if (card1 > card2) {
                player1++
                iv_player1.text = "Player 1: $player1"
            } else if (card1 < card2) {
                player2++
               iv_player2.text = "Player 2: $player2"
            } else {
                //show war label
                iv_war.visibility = View.VISIBLE
            }
        })
    }
    private fun setCardImage(number: Int,image: ImageView){

        image.setImageResource(cardsArray[number])
    }
}