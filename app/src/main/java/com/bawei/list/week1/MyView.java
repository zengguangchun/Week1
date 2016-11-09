package com.bawei.list.week1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by asus on 2016/11/7.
 */
public class MyView extends View {
    private Paint paint;
    private Paint paint1;
    private Context context;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.paint = new Paint();
        this.paint1 = new Paint();
        this.paint.setTextSize(10);
        this.paint.setColor(0xffff0000);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setAntiAlias(true);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth() / 2;
        int cR = dip2px(context, 50);
        int cW = dip2px(context, 3);
        //绘制圆
        this.paint.setARGB(255, 45, 23, 40);
        this.paint.setStrokeWidth(3);//设置圆环宽度
        canvas.drawCircle(center, center, cR + 1 + cW / 2, this.paint);//圆环宽度为中间圆
        canvas.drawText("下一步", center, center, this.paint1);
    }

    public static int dip2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
