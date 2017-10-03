package za.co.riggaroo.constraintlayoutdemo

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.widget.Button

/**
 * @author rebeccafranks
 * @since 2017/09/30.
 */
class CupcakeActivity : AppCompatActivity() {

    private var isLargeLayout = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val constraintSet1 = ConstraintSet()
        val constraintSet2 = ConstraintSet()

        constraintSet2.clone(this, R.layout.animation_example_2_transition)
        setContentView(R.layout.animation_example_2)

        val constraintLayout = findViewById<ConstraintLayout>(R.id.constraint_layout)
        constraintSet1.clone(constraintLayout)

        val bakeButton = findViewById<Button>(R.id.button_bake)

        bakeButton.setOnClickListener {

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