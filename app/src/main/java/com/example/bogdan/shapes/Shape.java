package com.example.bogdan.shapes;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Bogdan on 17.02.2015.
 */
public class Shape extends View {
    String shapeType;
    public Shape(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs,
                R.styleable.Shape);
        shapeType = a.getString(R.styleable.Shape_shapeType);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = this.getWidth();
        int height = this.getHeight();
        /*canvas.drawColor(Color.YELLOW);*/
        Paint p = new Paint();
        p.setColor(Color.RED);
        p.setStrokeWidth(10);
        float x = (width / 2);
        float y = (height / 2);
        int rad;
        if (width > height) {
            rad = ((height - 50) / 2);
        } else rad = ((width - 50) / 2);
        switch (shapeType) {
            case "Circle":
                canvas.drawCircle(x, y, rad, p);
                break;
            case "Rectangle":
                float l = (x - rad);
                float t = (y - rad);
                float r = (x + rad);
                float b = (y + rad);
                canvas.drawRect(l, t, r, b, p);
                break;
            case "Triangle":
                Path path = new Path();
                path.moveTo(x - rad, y + rad);
                path.lineTo(x, y - rad);
                path.lineTo(x + rad, y + rad);
                canvas.drawPath(path, p);
                break;
            default:
                canvas.drawPoint(x, y, p);
        }
        super.onDraw(canvas);
    }
}
