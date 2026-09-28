package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public class PagerTabStrip extends PagerTitleStrip {
    public boolean A;
    public final int B;
    public boolean C;
    public float D;
    public float E;
    public final int F;
    public int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final Paint w;
    public final Rect x;
    public int y;
    public boolean z;

    public PagerTabStrip(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.w = paint;
        this.x = new Rect();
        this.y = 255;
        this.z = false;
        this.A = false;
        int i2 = this.n;
        this.q = i2;
        paint.setColor(i2);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.r = (int) ((3.0f * f2) + 0.5f);
        this.s = (int) ((6.0f * f2) + 0.5f);
        this.t = (int) (64.0f * f2);
        this.v = (int) ((16.0f * f2) + 0.5f);
        this.B = (int) ((1.0f * f2) + 0.5f);
        this.u = (int) ((f2 * 32.0f) + 0.5f);
        this.F = ViewConfiguration.get(context).getScaledTouchSlop();
        setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
        setTextSpacing(getTextSpacing());
        setWillNotDraw(false);
        this.f12327b.setFocusable(true);
        this.f12327b.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                PagerTabStrip.this.f12326a.setCurrentItem(r2.getCurrentItem() - 1);
            }
        });
        this.f12329d.setFocusable(true);
        this.f12329d.setOnClickListener(new View.OnClickListener() { // from class: androidx.viewpager.widget.PagerTabStrip.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws Resources.NotFoundException {
                ViewPager viewPager = PagerTabStrip.this.f12326a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
            }
        });
        if (getBackground() == null) {
            this.z = true;
        }
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public final void c(float f2, int i2, boolean z) {
        int height = getHeight();
        TextView textView = this.f12328c;
        int left = textView.getLeft();
        int i3 = this.v;
        int right = textView.getRight() + i3;
        int i4 = height - this.r;
        Rect rect = this.x;
        rect.set(left - i3, i4, right, height);
        super.c(f2, i2, z);
        this.y = (int) (Math.abs(f2 - 0.5f) * 2.0f * 255.0f);
        rect.union(textView.getLeft() - i3, i4, textView.getRight() + i3, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.z;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public int getMinHeight() {
        return Math.max(super.getMinHeight(), this.u);
    }

    @ColorInt
    public int getTabIndicatorColor() {
        return this.q;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        TextView textView = this.f12328c;
        int left = textView.getLeft();
        int i2 = this.v;
        int i3 = left - i2;
        int right = textView.getRight() + i2;
        int i4 = height - this.r;
        Paint paint = this.w;
        paint.setColor((this.y << 24) | (this.q & 16777215));
        float f2 = height;
        canvas.drawRect(i3, i4, right, f2, paint);
        if (this.z) {
            paint.setColor((this.q & 16777215) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.B, getWidth() - getPaddingRight(), f2, paint);
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) throws Resources.NotFoundException {
        int action = motionEvent.getAction();
        if (action != 0 && this.C) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (action == 0) {
            this.D = x;
            this.E = y;
            this.C = false;
            return true;
        }
        if (action == 1) {
            int left = this.f12328c.getLeft();
            int i2 = this.v;
            if (x < left - i2) {
                ViewPager viewPager = this.f12326a;
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                return true;
            }
            if (x > r5.getRight() + i2) {
                ViewPager viewPager2 = this.f12326a;
                viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
            }
        } else if (action == 2) {
            float fAbs = Math.abs(x - this.D);
            float f2 = this.F;
            if (fAbs > f2 || Math.abs(y - this.E) > f2) {
                this.C = true;
                return true;
            }
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i2) {
        super.setBackgroundColor(i2);
        if (this.A) {
            return;
        }
        this.z = (i2 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.A) {
            return;
        }
        this.z = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i2) {
        super.setBackgroundResource(i2);
        if (this.A) {
            return;
        }
        this.z = i2 == 0;
    }

    public void setDrawFullUnderline(boolean z) {
        this.z = z;
        this.A = true;
        invalidate();
    }

    @Override // android.view.View
    public final void setPadding(int i2, int i3, int i4, int i5) {
        int i6 = this.s;
        if (i5 < i6) {
            i5 = i6;
        }
        super.setPadding(i2, i3, i4, i5);
    }

    public void setTabIndicatorColor(@ColorInt int i2) {
        this.q = i2;
        this.w.setColor(i2);
        invalidate();
    }

    public void setTabIndicatorColorResource(@ColorRes int i2) {
        setTabIndicatorColor(getContext().getColor(i2));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i2) {
        int i3 = this.t;
        if (i2 < i3) {
            i2 = i3;
        }
        super.setTextSpacing(i2);
    }
}
