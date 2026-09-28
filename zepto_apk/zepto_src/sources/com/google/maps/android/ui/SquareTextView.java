package com.google.maps.android.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class SquareTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public int f45627a;

    /* renamed from: b, reason: collision with root package name */
    public int f45628b;

    public SquareTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f45627a = 0;
        this.f45628b = 0;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        canvas.translate(this.f45628b / 2, this.f45627a / 2);
        super.draw(canvas);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int iMax = Math.max(measuredWidth, measuredHeight);
        if (measuredWidth > measuredHeight) {
            this.f45627a = measuredWidth - measuredHeight;
            this.f45628b = 0;
        } else {
            this.f45627a = 0;
            this.f45628b = measuredHeight - measuredWidth;
        }
        setMeasuredDimension(iMax, iMax);
    }

    public SquareTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f45627a = 0;
        this.f45628b = 0;
    }
}
