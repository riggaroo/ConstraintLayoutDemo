package za.co.riggaroo.constraintlayoutdemo

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.utils.widget.ImageFilterView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.imagefilterview.*

class ImageFilterViewActivity : AppCompatActivity() {

    private lateinit var imageFilterView : ImageFilterView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.imagefilterview)
        imageFilterView = findViewById(R.id.imageFilterView)
        Glide.with(this)
            .asBitmap()
            .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE))
            .load("https://source.unsplash.com/1600x900/?lego")
            .into(imageFilterView)

        setupSeekBars()
    }

    private fun setupSeekBars() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, p2: Boolean) {
                val percentage = (progress / 100.0f)
                imageFilterView.saturation = (percentage) + 1
            }

            override fun onStartTrackingTouch(seekbar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekbar: SeekBar?) {

            }
        })
        seekBarContrast.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                val percentage = (progress / 100.0f)
                imageFilterView.contrast = (percentage) + 1
            }

            override fun onStartTrackingTouch(seekbar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekbar: SeekBar?) {

            }
        })
        seekBarWarmth.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, p2: Boolean) {
                val percentage = (progress / 100.0f)
                imageFilterView.warmth = (percentage) + 1
            }

            override fun onStartTrackingTouch(seekbar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekbar: SeekBar?) {

            }
        })
    }
}