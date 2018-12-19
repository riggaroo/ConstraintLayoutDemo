package za.co.riggaroo.constraintlayoutdemo

import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
import com.google.android.material.shape.CornerTreatment
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.RoundedCornerTreatment
import com.google.android.material.shape.ShapePathModel
import kotlinx.android.synthetic.main.activity_swipe_recycler_view.*
import kotlinx.android.synthetic.main.list_item_email.view.*

class RecyclerViewSwipeMotionActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe_recycler_view)

        val shapePathModel = ShapePathModel().apply {
            val margin = applicationContext.dipToPixels(36f)
            val corner = RoundedCornerTreatment(margin)
            val noCorner = CornerTreatment()
            setCornerTreatments(corner, corner, noCorner, noCorner)
            topEdge = BottomAppBarTopEdgeTreatment(margin, margin, margin)
        }

        val backgroundDrawable = MaterialShapeDrawable(shapePathModel).apply {
            setTint(ContextCompat.getColor(this@RecyclerViewSwipeMotionActivity, R.color.white))
            isShadowEnabled = true
        }
        background_view.background = backgroundDrawable

        val listItems = listOf(Email("Rebecca Franks", "It's the holidays!"),
            Email("Rebecca Franks", "It's the holidays!"),
            Email("Rebecca Franks", "It's the holidays!"),
            Email("Rebecca Franks", "It's the holidays!"),
            Email("Rebecca Franks", "It's the holidays!"),
            Email("Rebecca Franks", "It's the holidays!"),
            Email("Rebecca Franks", "It's the holidays!"),
            Email("Rebecca Franks", "It's the holidays!"),
            Email("Rebecca Franks", "It's the holidays!"),
            Email("Rebecca Franks", "It's the holidays!"))

        val emailAdapter = EmailAdapter()

        recyclerViewEmails.adapter = emailAdapter
        recyclerViewEmails.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)

        emailAdapter.submitList(listItems)
    }

    fun Context.dipToPixels(dipValue: Float) =
        TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, resources.displayMetrics)

    data class Email(val name: String, val subject: String)


    class EmailAdapter: ListAdapter<Email, EmailViewHolder>(DIFFER){
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
            return EmailViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_email, parent, false))
        }

        override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
            holder.bind(getItem(position))
        }

        companion object {
            val DIFFER = object : DiffUtil.ItemCallback<Email>() {
                override fun areItemsTheSame(oldItem: Email, newItem: Email): Boolean {
                    return oldItem == newItem
                }

                override fun areContentsTheSame(oldItem: Email, newItem: Email): Boolean {
                    return oldItem == newItem
                }
            }
        }
    }

    class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(email : Email){
            itemView.textViewEmailName.text = email.name
            itemView.textViewSubject.text = email.subject
        }
    }
}