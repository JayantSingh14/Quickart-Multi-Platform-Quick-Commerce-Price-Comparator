package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;

/* loaded from: classes3.dex */
public class MotionTelltales extends MockView {

    /* renamed from: l, reason: collision with root package name */
    public final Paint f2366l;

    /* renamed from: m, reason: collision with root package name */
    public MotionLayout f2367m;
    public final float[] n;
    public final Matrix o;
    public int p;
    public int q;
    public float r;

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2366l = new Paint();
        this.n = new float[2];
        this.o = new Matrix();
        this.p = 0;
        this.q = -65281;
        this.r = 0.25f;
        b(context, attributeSet);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionTelltales);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionTelltales_telltales_tailColor) {
                    this.q = typedArrayObtainStyledAttributes.getColor(index, this.q);
                } else if (index == R.styleable.MotionTelltales_telltales_velocityMode) {
                    this.p = typedArrayObtainStyledAttributes.getInt(index, this.p);
                } else if (index == R.styleable.MotionTelltales_telltales_tailScale) {
                    this.r = typedArrayObtainStyledAttributes.getFloat(index, this.r);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        int i3 = this.q;
        Paint paint = this.f2366l;
        paint.setColor(i3);
        paint.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = getMatrix();
        Matrix matrix2 = this.o;
        matrix.invert(matrix2);
        if (this.f2367m == null) {
            ViewParent parent = getParent();
            if (parent instanceof MotionLayout) {
                this.f2367m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float[] fArr = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        for (int i2 = 0; i2 < 5; i2++) {
            float f2 = fArr[i2];
            for (int i3 = 0; i3 < 5; i3++) {
                float f3 = fArr[i3];
                this.f2367m.y(this, f3, f2, this.n, this.p);
                float[] fArr2 = this.n;
                matrix2.mapVectors(fArr2);
                float f4 = width * f3;
                float f5 = height * f2;
                float f6 = fArr2[0];
                float f7 = this.r;
                float f8 = f5 - (fArr2[1] * f7);
                matrix2.mapVectors(fArr2);
                canvas.drawLine(f4, f5, f4 - (f6 * f7), f8, this.f2366l);
            }
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f2338f = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2366l = new Paint();
        this.n = new float[2];
        this.o = new Matrix();
        this.p = 0;
        this.q = -65281;
        this.r = 0.25f;
        b(context, attributeSet);
    }
}
