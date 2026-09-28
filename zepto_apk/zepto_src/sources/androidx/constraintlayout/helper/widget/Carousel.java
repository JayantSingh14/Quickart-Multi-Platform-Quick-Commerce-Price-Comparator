package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Carousel extends MotionHelper {
    public int A;
    public int B;
    public float C;
    public int D;
    public final int E;
    public final Runnable F;
    public Adapter n;
    public final ArrayList o;
    public int p;
    public int q;
    public MotionLayout r;
    public int s;
    public boolean t;
    public int u;
    public int v;
    public int w;
    public int x;
    public float y;
    public int z;

    public interface Adapter {
        void a();

        void b();

        int c();
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = null;
        this.o = new ArrayList();
        this.p = 0;
        this.q = 0;
        this.s = -1;
        this.t = false;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = 0.9f;
        this.z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                Carousel carousel = Carousel.this;
                carousel.r.setProgress(0.0f);
                carousel.u();
                carousel.n.b();
                float velocity = carousel.r.getVelocity();
                if (carousel.B != 2 || velocity <= carousel.C || carousel.q >= carousel.n.c() - 1) {
                    return;
                }
                final float f2 = velocity * carousel.y;
                int i2 = carousel.q;
                if (i2 != 0 || carousel.p <= i2) {
                    if (i2 != carousel.n.c() - 1 || carousel.p >= carousel.q) {
                        carousel.r.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                Carousel.this.r.G(5, 1.0f, f2);
                            }
                        });
                    }
                }
            }
        };
        t(context, attributeSet);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public final void a(int i2) {
        int i3 = this.q;
        this.p = i3;
        if (i2 == this.x) {
            this.q = i3 + 1;
        } else if (i2 == this.w) {
            this.q = i3 - 1;
        }
        if (this.t) {
            if (this.q >= this.n.c()) {
                this.q = 0;
            }
            if (this.q < 0) {
                this.q = this.n.c() - 1;
            }
        } else {
            if (this.q >= this.n.c()) {
                this.q = this.n.c() - 1;
            }
            if (this.q < 0) {
                this.q = 0;
            }
        }
        if (this.p != this.q) {
            this.r.post(this.F);
        }
    }

    public int getCount() {
        Adapter adapter = this.n;
        if (adapter != null) {
            return adapter.c();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.q;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() throws Exception {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            ArrayList arrayList = this.o;
            arrayList.clear();
            for (int i2 = 0; i2 < this.f2389b; i2++) {
                int i3 = this.f2388a[i2];
                View viewC = motionLayout.c(i3);
                if (this.s == i3) {
                    this.z = i2;
                }
                arrayList.add(viewC);
            }
            this.r = motionLayout;
            if (this.B == 2) {
                MotionScene.Transition transitionX = motionLayout.x(this.v);
                if (transitionX != null) {
                    transitionX.a();
                }
                MotionScene.Transition transitionX2 = this.r.x(this.u);
                if (transitionX2 != null) {
                    transitionX2.a();
                }
            }
            u();
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.o.clear();
    }

    public final void s(int i2, boolean z) {
        MotionLayout motionLayout;
        MotionScene.Transition transitionX;
        if (i2 == -1 || (motionLayout = this.r) == null || (transitionX = motionLayout.x(i2)) == null || z == (!transitionX.o)) {
            return;
        }
        transitionX.o = !z;
    }

    public void setAdapter(Adapter adapter) {
        this.n = adapter;
    }

    public void setInfinite(boolean z) {
        this.t = z;
    }

    public final void t(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.s = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.u = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.v = typedArrayObtainStyledAttributes.getResourceId(index, this.v);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.A = typedArrayObtainStyledAttributes.getInt(index, this.A);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.w = typedArrayObtainStyledAttributes.getResourceId(index, this.w);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.x = typedArrayObtainStyledAttributes.getResourceId(index, this.x);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.y = typedArrayObtainStyledAttributes.getFloat(index, this.y);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.B = typedArrayObtainStyledAttributes.getInt(index, this.B);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.C = typedArrayObtainStyledAttributes.getFloat(index, this.C);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.t = typedArrayObtainStyledAttributes.getBoolean(index, this.t);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public final void u() throws Exception {
        Adapter adapter = this.n;
        if (adapter == null || this.r == null || adapter.c() == 0) {
            return;
        }
        ArrayList arrayList = this.o;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) arrayList.get(i2);
            int i3 = (this.q + i2) - this.z;
            if (this.t) {
                if (i3 < 0) {
                    int i4 = this.A;
                    if (i4 != 4) {
                        v(i4, view);
                    } else {
                        v(0, view);
                    }
                    if (i3 % this.n.c() == 0) {
                        this.n.a();
                    } else {
                        Adapter adapter2 = this.n;
                        adapter2.c();
                        int iC = i3 % this.n.c();
                        adapter2.a();
                    }
                } else if (i3 >= this.n.c()) {
                    if (i3 != this.n.c() && i3 > this.n.c()) {
                        int iC2 = i3 % this.n.c();
                    }
                    int i5 = this.A;
                    if (i5 != 4) {
                        v(i5, view);
                    } else {
                        v(0, view);
                    }
                    this.n.a();
                } else {
                    v(0, view);
                    this.n.a();
                }
            } else if (i3 < 0) {
                v(this.A, view);
            } else if (i3 >= this.n.c()) {
                v(this.A, view);
            } else {
                v(0, view);
                this.n.a();
            }
        }
        int i6 = this.D;
        if (i6 != -1 && i6 != this.q) {
            this.r.post(new a(this, 0));
        } else if (i6 == this.q) {
            this.D = -1;
        }
        if (this.u == -1 || this.v == -1) {
            Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
            return;
        }
        if (this.t) {
            return;
        }
        int iC3 = this.n.c();
        if (this.q == 0) {
            s(this.u, false);
        } else {
            s(this.u, true);
            this.r.setTransition(this.u);
        }
        if (this.q == iC3 - 1) {
            s(this.v, false);
        } else {
            s(this.v, true);
            this.r.setTransition(this.v);
        }
    }

    public final void v(int i2, View view) {
        ConstraintSet.Constraint constraintJ;
        MotionLayout motionLayout = this.r;
        if (motionLayout == null) {
            return;
        }
        for (int i3 : motionLayout.getConstraintSetIds()) {
            MotionScene motionScene = this.r.q;
            ConstraintSet constraintSetB = motionScene == null ? null : motionScene.b(i3);
            if (constraintSetB != null && (constraintJ = constraintSetB.j(view.getId())) != null) {
                constraintJ.f2461c.f2507c = 1;
                view.setVisibility(i2);
            }
        }
    }

    public Carousel(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = null;
        this.o = new ArrayList();
        this.p = 0;
        this.q = 0;
        this.s = -1;
        this.t = false;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = 0.9f;
        this.z = 0;
        this.A = 4;
        this.B = 1;
        this.C = 2.0f;
        this.D = -1;
        this.E = 200;
        this.F = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public final void run() throws Exception {
                Carousel carousel = Carousel.this;
                carousel.r.setProgress(0.0f);
                carousel.u();
                carousel.n.b();
                float velocity = carousel.r.getVelocity();
                if (carousel.B != 2 || velocity <= carousel.C || carousel.q >= carousel.n.c() - 1) {
                    return;
                }
                final float f2 = velocity * carousel.y;
                int i22 = carousel.q;
                if (i22 != 0 || carousel.p <= i22) {
                    if (i22 != carousel.n.c() - 1 || carousel.p >= carousel.q) {
                        carousel.r.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                Carousel.this.r.G(5, 1.0f, f2);
                            }
                        });
                    }
                }
            }
        };
        t(context, attributeSet);
    }
}
