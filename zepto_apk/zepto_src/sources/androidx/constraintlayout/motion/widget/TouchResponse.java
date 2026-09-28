package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;

/* loaded from: classes3.dex */
class TouchResponse {
    public static final float[][] E = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public static final float[][] F = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    public final float A;
    public final float B;
    public final int C;
    public final int D;

    /* renamed from: a, reason: collision with root package name */
    public final int f2253a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2254b;

    /* renamed from: c, reason: collision with root package name */
    public int f2255c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2256d;

    /* renamed from: e, reason: collision with root package name */
    public final int f2257e;

    /* renamed from: f, reason: collision with root package name */
    public final int f2258f;

    /* renamed from: g, reason: collision with root package name */
    public float f2259g;

    /* renamed from: h, reason: collision with root package name */
    public float f2260h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2261i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f2262j;

    /* renamed from: k, reason: collision with root package name */
    public float f2263k;

    /* renamed from: l, reason: collision with root package name */
    public float f2264l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2265m = false;
    public final float[] n = new float[2];
    public final int[] o = new int[2];
    public float p;
    public float q;
    public final MotionLayout r;
    public final float s;
    public final float t;
    public final boolean u;
    public final float v;
    public final int w;
    public final float x;
    public final float y;
    public final float z;

    /* renamed from: androidx.constraintlayout.motion.widget.TouchResponse$1, reason: invalid class name */
    class AnonymousClass1 implements View.OnTouchListener {
        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    public TouchResponse(Context context, MotionLayout motionLayout, XmlResourceParser xmlResourceParser) {
        this.f2253a = 0;
        this.f2254b = 0;
        this.f2255c = 0;
        this.f2256d = -1;
        this.f2257e = -1;
        this.f2258f = -1;
        this.f2259g = 0.5f;
        this.f2260h = 0.5f;
        this.f2261i = -1;
        this.f2262j = false;
        this.f2263k = 0.0f;
        this.f2264l = 1.0f;
        this.s = 4.0f;
        this.t = 1.2f;
        this.u = true;
        this.v = 1.0f;
        this.w = 0;
        this.x = 10.0f;
        this.y = 10.0f;
        this.z = 1.0f;
        this.A = Float.NaN;
        this.B = Float.NaN;
        this.C = 0;
        this.D = 0;
        this.r = motionLayout;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R.styleable.OnSwipe);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.f2256d = typedArrayObtainStyledAttributes.getResourceId(index, this.f2256d);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i3 = typedArrayObtainStyledAttributes.getInt(index, this.f2253a);
                this.f2253a = i3;
                float[] fArr = E[i3];
                this.f2260h = fArr[0];
                this.f2259g = fArr[1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i4 = typedArrayObtainStyledAttributes.getInt(index, this.f2254b);
                this.f2254b = i4;
                if (i4 < 6) {
                    float[] fArr2 = F[i4];
                    this.f2263k = fArr2[0];
                    this.f2264l = fArr2[1];
                } else {
                    this.f2264l = Float.NaN;
                    this.f2263k = Float.NaN;
                    this.f2262j = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.s = typedArrayObtainStyledAttributes.getFloat(index, this.s);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.t = typedArrayObtainStyledAttributes.getFloat(index, this.t);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.u = typedArrayObtainStyledAttributes.getBoolean(index, this.u);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.v = typedArrayObtainStyledAttributes.getFloat(index, this.v);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.x = typedArrayObtainStyledAttributes.getFloat(index, this.x);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.f2257e = typedArrayObtainStyledAttributes.getResourceId(index, this.f2257e);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.f2255c = typedArrayObtainStyledAttributes.getInt(index, this.f2255c);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.w = typedArrayObtainStyledAttributes.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f2258f = typedArrayObtainStyledAttributes.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.f2261i = typedArrayObtainStyledAttributes.getResourceId(index, this.f2261i);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.y = typedArrayObtainStyledAttributes.getFloat(index, this.y);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.z = typedArrayObtainStyledAttributes.getFloat(index, this.z);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.A = typedArrayObtainStyledAttributes.getFloat(index, this.A);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.B = typedArrayObtainStyledAttributes.getFloat(index, this.B);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.C = typedArrayObtainStyledAttributes.getInt(index, this.C);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.D = typedArrayObtainStyledAttributes.getInt(index, this.D);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final RectF a(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i2 = this.f2258f;
        if (i2 == -1 || (viewFindViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    public final RectF b(ViewGroup viewGroup, RectF rectF) {
        View viewFindViewById;
        int i2 = this.f2257e;
        if (i2 == -1 || (viewFindViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set(viewFindViewById.getLeft(), viewFindViewById.getTop(), viewFindViewById.getRight(), viewFindViewById.getBottom());
        return rectF;
    }

    public final void c(boolean z) {
        float[][] fArr = E;
        float[][] fArr2 = F;
        if (z) {
            fArr2[4] = fArr2[3];
            fArr2[5] = fArr2[2];
            fArr[5] = fArr[2];
            fArr[6] = fArr[1];
        } else {
            fArr2[4] = fArr2[2];
            fArr2[5] = fArr2[3];
            fArr[5] = fArr[1];
            fArr[6] = fArr[2];
        }
        float[] fArr3 = fArr[this.f2253a];
        this.f2260h = fArr3[0];
        this.f2259g = fArr3[1];
        int i2 = this.f2254b;
        if (i2 >= 6) {
            return;
        }
        float[] fArr4 = fArr2[i2];
        this.f2263k = fArr4[0];
        this.f2264l = fArr4[1];
    }

    public final String toString() {
        if (Float.isNaN(this.f2263k)) {
            return "rotation";
        }
        return this.f2263k + " , " + this.f2264l;
    }

    /* renamed from: androidx.constraintlayout.motion.widget.TouchResponse$2, reason: invalid class name */
    class AnonymousClass2 implements NestedScrollView.OnScrollChangeListener {
        @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
        public final void a(NestedScrollView nestedScrollView) {
        }
    }
}
