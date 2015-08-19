package com.example.jonas.weatherman;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Jonas on 19/08/2015.
 */
public class ItemView extends View {

    public ItemView(Context context) {
        super(context);
    }

    public ItemView(Context context, AttributeSet ats, int defaultStyle){
        super(context, ats, defaultStyle);
    }

    public ItemView(Context context, AttributeSet ats){
        super(context, ats);
    }

    @Override
    protected void onDraw(Canvas canvas){
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();

        int px = width /2;
        int py = height / 2;

        Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);

        String displayText = "aap";

        float textWidth = mTextPaint.measureText(displayText);

        canvas.drawText(displayText, px - textWidth / 2, py, mTextPaint );
    }
}
