package za.co.riggaroo.constraintlayoutdemo

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.widget.ImageView

class MovieActivity : AppCompatActivity() {

    private var isLargeLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val constraintSet1 = ConstraintSet()
        val constraintSet2 = ConstraintSet()

        constraintSet2.clone(this, R.layout.activity_movie_rental_large)
        setContentView(R.layout.activity_movie_rental)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint_layout)
        constraintSet1.clone(constraintLayout)

        val posterImageView = findViewById<ImageView>(R.id.imageview_poster)

        posterImageView.setOnClickListener {

            TransitionManager.beginDelayedTransition(constraintLayout)
            if (isLargeLayout) {
                constraintSet1.applyTo(constraintLayout)
            } else {
                constraintSet2.applyTo(constraintLayout)
            }
            isLargeLayout = !isLargeLayout
        }
    }
}
