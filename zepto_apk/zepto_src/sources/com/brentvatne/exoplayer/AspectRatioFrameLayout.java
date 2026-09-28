package com.brentvatne.exoplayer;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public float f15511a;

    /* renamed from: b, reason: collision with root package name */
    public int f15512b;

    @Metadata
    public static final class Companion {
    }

    public final int getResizeMode() {
        return this.f15512b;
    }

    public final float getVideoAspectRatio() {
        return this.f15511a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        float f2;
        float f3;
        float f4;
        super.onMeasure(i2, i3);
        if (this.f15511a == 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f5 = measuredWidth;
        float f6 = measuredHeight;
        float f7 = (this.f15511a / (f5 / f6)) - 1;
        if (Math.abs(f7) <= 0.01f) {
            return;
        }
        int i4 = this.f15512b;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 == 4) {
                        int i5 = (int) (this.f15511a * f6);
                        if (i5 < measuredWidth) {
                            float f8 = i5;
                            float f9 = f5 / f8;
                            measuredWidth = (int) (f8 * f9);
                            f3 = f9 * f6;
                            measuredHeight = (int) f3;
                        } else {
                            measuredWidth = i5;
                        }
                    } else if (f7 > 0.0f) {
                        f2 = this.f15511a;
                    } else {
                        f4 = this.f15511a;
                    }
                }
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
            f4 = this.f15511a;
            measuredWidth = (int) (f6 * f4);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
        f2 = this.f15511a;
        f3 = f5 / f2;
        measuredHeight = (int) f3;
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public final void setResizeMode(int i2) {
        if (i2 != this.f15512b) {
            this.f15512b = i2;
            requestLayout();
        }
    }

    public final void setVideoAspectRatio(float f2) {
        if (f2 == this.f15511a) {
            return;
        }
        this.f15511a = f2;
        requestLayout();
    }
}
