package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.R;

/* loaded from: classes3.dex */
public class MotionButton extends AppCompatButton {

    /* renamed from: d, reason: collision with root package name */
    public float f2344d;

    /* renamed from: e, reason: collision with root package name */
    public float f2345e;

    /* renamed from: f, reason: collision with root package name */
    public Path f2346f;

    /* renamed from: g, reason: collision with root package name */
    public ViewOutlineProvider f2347g;

    /* renamed from: h, reason: collision with root package name */
    public RectF f2348h;

    public MotionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2344d = 0.0f;
        this.f2345e = Float.NaN;
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_round) {
                    setRound(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(typedArrayObtainStyledAttributes.getFloat(index, 0.0f));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public float getRound() {
        return this.f2345e;
    }

    public float getRoundPercent() {
        return this.f2344d;
    }

    @RequiresApi
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f2345e = f2;
            float f3 = this.f2344d;
            this.f2344d = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.f2345e != f2;
        this.f2345e = f2;
        if (f2 != 0.0f) {
            if (this.f2346f == null) {
                this.f2346f = new Path();
            }
            if (this.f2348h == null) {
                this.f2348h = new RectF();
            }
            if (this.f2347g == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.2
                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view, Outline outline) {
                        MotionButton motionButton = MotionButton.this;
                        outline.setRoundRect(0, 0, motionButton.getWidth(), motionButton.getHeight(), motionButton.f2345e);
                    }
                };
                this.f2347g = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            this.f2348h.set(0.0f, 0.0f, getWidth(), getHeight());
            this.f2346f.reset();
            Path path = this.f2346f;
            RectF rectF = this.f2348h;
            float f4 = this.f2345e;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @RequiresApi
    public void setRoundPercent(float f2) {
        boolean z = this.f2344d != f2;
        this.f2344d = f2;
        if (f2 != 0.0f) {
            if (this.f2346f == null) {
                this.f2346f = new Path();
            }
            if (this.f2348h == null) {
                this.f2348h = new RectF();
            }
            if (this.f2347g == null) {
                ViewOutlineProvider viewOutlineProvider = new ViewOutlineProvider() { // from class: androidx.constraintlayout.utils.widget.MotionButton.1
                    @Override // android.view.ViewOutlineProvider
                    public final void getOutline(View view, Outline outline) {
                        MotionButton motionButton = MotionButton.this;
                        outline.setRoundRect(0, 0, motionButton.getWidth(), motionButton.getHeight(), (Math.min(r3, r4) * motionButton.f2344d) / 2.0f);
                    }
                };
                this.f2347g = viewOutlineProvider;
                setOutlineProvider(viewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float fMin = (Math.min(width, height) * this.f2344d) / 2.0f;
            this.f2348h.set(0.0f, 0.0f, width, height);
            this.f2346f.reset();
            this.f2346f.addRoundRect(this.f2348h, fMin, fMin, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public MotionButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2344d = 0.0f;
        this.f2345e = Float.NaN;
        a(context, attributeSet);
    }
}
