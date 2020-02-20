package za.co.riggaroo.constraintlayoutdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_motion_layout_barrier.*

class MotionLayoutBarrierActivity : AppCompatActivity() {

    private lateinit var motionLayoutVM : MotionLayoutViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_motion_layout_barrier)
        motionLayoutVM = ViewModelProviders.of(this)[MotionLayoutViewModel::class.java]
        motionLayoutVM.currentState.observe(this, Observer{
            root.transitionToState(it)
        })

        addTextPaletteButton.setOnClickListener {
            root.transitionToState(R.id.focusState_Font)
            motionLayoutVM.currentState.value = R.id.focusState_Font
        }
        focusFontControl.setOnClickListener {
            root.transitionToState(R.id.overviewState)
            motionLayoutVM.currentState.value = R.id.overviewState
        }
        focusStyleControl.setOnClickListener {
            root.transitionToState(R.id.overviewState)
            motionLayoutVM.currentState.value = R.id.overviewState
        }
        backButton.setOnClickListener {
            root.transitionToState(R.id.overviewState)
            motionLayoutVM.currentState.value = R.id.overviewState
        }
    }
}

class MotionLayoutViewModel : ViewModel(){

    var currentState = MutableLiveData<Int>()

    init {
        currentState.value = R.id.overviewState
    }
}