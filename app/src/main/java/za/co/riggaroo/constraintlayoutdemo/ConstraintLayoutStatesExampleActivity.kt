package za.co.riggaroo.constraintlayoutdemo

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.HandlerCompat.postDelayed
import kotlinx.android.synthetic.main.activity_cl_states_end.*

class ConstraintLayoutStatesExampleActivity : AppCompatActivity() {

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cl_states_start)
        stateConstraintLayout.loadLayoutDescription(R.xml.constraint_layout_states_example)
        var changed = false
        buttonBakeCake.setOnClickListener {
            stateConstraintLayout.setState(R.id.loading, 0, 0)
            postDelayed(handler,  {
                stateConstraintLayout.setState(if (changed) R.id.start else R.id.end,0, 0)
                changed = !changed
            },null ,3000L)
        }
    }
}