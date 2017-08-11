package za.co.riggaroo.constraintlayoutdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * @author rebeccafranks
 * @since 2017/08/09.
 */

public class RatingView extends FrameLayout {


    public RatingView(@NonNull Context context) {
        super(context);
        init(null);
    }

    public RatingView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public RatingView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public RatingView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    public void init(AttributeSet attributeSet) {
        TypedArray attributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.MovieRatingView, 0, 0);
        float ratingText;
        try {
            ratingText = attributes.getFloat(R.styleable.MovieRatingView_rating, 0F);
        } finally {
            attributes.recycle();
        }
        inflate(getContext(), R.layout.rating_badge, this);

        TextView ratingTextView = findViewById(R.id.text_view_rating_text);
        ratingTextView.setText(Float.toString(ratingText));

    }
}
