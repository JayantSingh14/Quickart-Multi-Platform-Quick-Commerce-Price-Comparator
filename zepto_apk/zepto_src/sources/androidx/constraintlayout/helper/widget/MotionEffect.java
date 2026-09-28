package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.widget.R;

/* loaded from: classes3.dex */
public class MotionEffect extends MotionHelper {
    public float n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean s;
    public int t;
    public int u;

    public MotionEffect(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = 0.1f;
        this.o = 49;
        this.p = 50;
        this.q = 0;
        this.r = 0;
        this.s = true;
        this.t = -1;
        this.u = -1;
        s(context, attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0186, code lost:
    
        if (r14 == 0.0f) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x019c, code lost:
    
        if (r14 == 0.0f) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01ad, code lost:
    
        if (r15 == 0.0f) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01e8  */
    @Override // androidx.constraintlayout.motion.widget.MotionHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(androidx.constraintlayout.motion.widget.MotionLayout r24, java.util.HashMap r25) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.MotionEffect.r(androidx.constraintlayout.motion.widget.MotionLayout, java.util.HashMap):void");
    }

    public final void s(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MotionEffect);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MotionEffect_motionEffect_start) {
                    int i3 = typedArrayObtainStyledAttributes.getInt(index, this.o);
                    this.o = i3;
                    this.o = Math.max(Math.min(i3, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_end) {
                    int i4 = typedArrayObtainStyledAttributes.getInt(index, this.p);
                    this.p = i4;
                    this.p = Math.max(Math.min(i4, 99), 0);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationX) {
                    this.q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.q);
                } else if (index == R.styleable.MotionEffect_motionEffect_translationY) {
                    this.r = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.r);
                } else if (index == R.styleable.MotionEffect_motionEffect_alpha) {
                    this.n = typedArrayObtainStyledAttributes.getFloat(index, this.n);
                } else if (index == R.styleable.MotionEffect_motionEffect_move) {
                    this.u = typedArrayObtainStyledAttributes.getInt(index, this.u);
                } else if (index == R.styleable.MotionEffect_motionEffect_strict) {
                    this.s = typedArrayObtainStyledAttributes.getBoolean(index, this.s);
                } else if (index == R.styleable.MotionEffect_motionEffect_viewTransition) {
                    this.t = typedArrayObtainStyledAttributes.getResourceId(index, this.t);
                }
            }
            int i5 = this.o;
            int i6 = this.p;
            if (i5 == i6) {
                if (i5 > 0) {
                    this.o = i5 - 1;
                } else {
                    this.p = i6 + 1;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public MotionEffect(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = 0.1f;
        this.o = 49;
        this.p = 50;
        this.q = 0;
        this.r = 0;
        this.s = true;
        this.t = -1;
        this.u = -1;
        s(context, attributeSet);
    }
}
