package com.bhoghem.suitsuit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
import com.bhoghem.suitsuit.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var playMode: Int? = null
    private var player2Choice: Int? = null
    private var player1Choice: Int? = null
    private var flag: Int = -1
    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindViews()
        setContentView(binding.root)
        supportActionBar?.hide()

        //val textView: TextView = findViewById(R.id.)
        //bindViews()
        start()
        onResetClick()

    }

    private fun onResetClick() {
        setBgUserShape(-1)
        setBgCompShape(-1)
        player1Choice = null
        player2Choice = null
        binding.icRefresh.setImageResource(R.drawable.refresh)
    }

    private fun bindViews() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    private fun setBgUserShape(userShape: Int) {
        when (PlayerShape.fromInt(userShape)) {
            PlayerShape.ROCK -> {
                binding.flChoice2.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.purple_200
                    )
                )

                binding.flChoice1.setBackgroundColor(0)
                binding.flChoice3.setBackgroundColor(0)
            }
            PlayerShape.PAPER -> {
                binding.flChoice3.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.purple_200
                    )
                )
                binding.flChoice1.setBackgroundColor(0)
                binding.flChoice2.setBackgroundColor(2)
            }
            PlayerShape.SCISSOR -> {
                binding.flChoice1.setBackgroundColor(
                    ContextCompat.getColor(
                        this,
                        R.color.purple_200
                    )
                )
                binding.flChoice2.setBackgroundColor(0)
                binding.flChoice3.setBackgroundColor(0)
            }
            else -> {
                binding.flChoice2.setBackgroundColor(0)
                binding.flChoice3.setBackgroundColor(0)
                binding.flChoice1.setBackgroundColor(0)
            }
        }
    }

    private fun setBgCompShape(compShape: Int) {
        when (PlayerShape.fromInt(compShape)) {
            PlayerShape.ROCK -> {
                binding.rock2.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                binding.papper2.setBackgroundColor(0)
                binding.scissor2.setBackgroundColor(0)
            }
            PlayerShape.PAPER -> {
                binding.papper2.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                binding.scissor2.setBackgroundColor(0)
                binding.rock2.setBackgroundColor(2)
            }
            PlayerShape.SCISSOR -> {
                binding.scissor2.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
                binding.rock2.setBackgroundColor(0)
                binding.papper2.setBackgroundColor(0)
            }
            else -> {
                binding.rock2.setBackgroundColor(0)
                binding.papper2.setBackgroundColor(0)
                binding.scissor2.setBackgroundColor(0)
            }
        }
    }


    private fun start() {

        if (playMode == 0) {
            flag = 0
            onPlayerOneClick()
            onPlayerTwoClick()
        } else {
            flag = 1
            onPlayerOneClick()
        }
    }

    private fun onPlayerTwoClick() {
        binding.rock2.setOnClickListener {
            println("click batu 2...")
            player2Choice = 0
            startGame(player1Choice, player2Choice)
        }
        binding.papper2.setOnClickListener {
            println("click kertas 2...")
            player2Choice = 1
            startGame(player1Choice, player2Choice)
        }
        binding.scissor2.setOnClickListener {
            println("click gunting 2...")
            player2Choice = 2
            startGame(player1Choice, player2Choice)
        }
    }


    private fun onPlayerOneClick() {
        var random = 0
        binding.flChoice2.setOnClickListener {
            println("click batu 1...")
            player1Choice = 0
            setBgUserShape(0)

            if (playMode != 0) {
                random = Random.nextInt(0,3)
                setBgCompShape(random)
                startGame(player1Choice, random)
            }
        }
        binding.flChoice3.setOnClickListener {
            println("click kertas 1...")
            player1Choice = 1
            setBgUserShape(1)
            if (playMode != 0) {
                random = Random.nextInt(0,3)
                setBgCompShape(random)
                startGame(player1Choice, random)
            }
        }
        binding.flChoice1.setOnClickListener {
            println("click gunting 1...")
            player1Choice = 2
            setBgUserShape(2)
            if (playMode != 0) {
                random = Random.nextInt(0,3)
                setBgCompShape(random)
                startGame(player1Choice, random)
            }
        }

    }

    private fun startGame(playerOneChoice: Int?, playerTwoChoice: Int?) {
        if (playerOneChoice != null) {
            if ((playerOneChoice.plus(1)).mod(3) == playerTwoChoice) {
                Log.d(TAG, "setClickEvent Computer won")
                binding.middle.setImageResource(R.drawable.ic_p2win)

            } else if (playerOneChoice.equals(playerTwoChoice)) {
                Log.d(TAG, "setClickEvent draw")
                binding.middle.setImageResource(R.drawable.ic_draw)

            } else {
                Log.d(TAG, "setClickEvent User won")
                binding.middle.setImageResource(R.drawable.ic_p1win)

            }

        }


    }
}