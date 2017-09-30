package za.co.riggaroo.constraintlayoutdemo

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

/**
 * @author rebeccafranks
 * @since 2017/09/30.
 */
class OptionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
        val buttonMovie = findViewById<Button>(R.id.button_movie)
        buttonMovie.setOnClickListener { startActivity(Intent(this, MovieActivity::class.java)) }
        val cupcakeDemo = findViewById<Button>(R.id.button_cupcake)
        cupcakeDemo.setOnClickListener { startActivity(Intent(this, CupcakeActivity::class.java)) }
    }
}

