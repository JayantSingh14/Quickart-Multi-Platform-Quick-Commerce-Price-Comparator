package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.ConnectionResult;
import java.util.ArrayList;
import java.util.WeakHashMap;

@VisibleForTesting
/* loaded from: classes3.dex */
class FastScroller extends RecyclerView.ItemDecoration implements RecyclerView.OnItemTouchListener {
    public static final int[] C = {R.attr.state_pressed};
    public static final int[] D = new int[0];
    public int A;
    public final Runnable B;

    /* renamed from: a, reason: collision with root package name */
    public final int f11455a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11456b;

    /* renamed from: c, reason: collision with root package name */
    public final StateListDrawable f11457c;

    /* renamed from: d, reason: collision with root package name */
    public final Drawable f11458d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11459e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11460f;

    /* renamed from: g, reason: collision with root package name */
    public final StateListDrawable f11461g;

    /* renamed from: h, reason: collision with root package name */
    public final Drawable f11462h;

    /* renamed from: i, reason: collision with root package name */
    public final int f11463i;

    /* renamed from: j, reason: collision with root package name */
    public final int f11464j;

    /* renamed from: k, reason: collision with root package name */
    public int f11465k;

    /* renamed from: l, reason: collision with root package name */
    public int f11466l;

    /* renamed from: m, reason: collision with root package name */
    public float f11467m;
    public int n;
    public int o;
    public float p;
    public final RecyclerView s;
    public final ValueAnimator z;
    public int q = 0;
    public int r = 0;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];

    public class AnimatorListener extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public boolean f11470a = false;

        public AnimatorListener() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator animator) {
            this.f11470a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            if (this.f11470a) {
                this.f11470a = false;
                return;
            }
            FastScroller fastScroller = FastScroller.this;
            if (((Float) fastScroller.z.getAnimatedValue()).floatValue() == 0.0f) {
                fastScroller.A = 0;
                fastScroller.l(0);
            } else {
                fastScroller.A = 2;
                fastScroller.s.invalidate();
            }
        }
    }

    public class AnimatorUpdater implements ValueAnimator.AnimatorUpdateListener {
        public AnimatorUpdater() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller fastScroller = FastScroller.this;
            fastScroller.f11457c.setAlpha(iFloatValue);
            fastScroller.f11458d.setAlpha(iFloatValue);
            fastScroller.s.invalidate();
        }
    }

    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = valueAnimatorOfFloat;
        this.A = 0;
        Runnable runnable = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
            @Override // java.lang.Runnable
            public final void run() {
                FastScroller fastScroller = FastScroller.this;
                int i5 = fastScroller.A;
                ValueAnimator valueAnimator = fastScroller.z;
                if (i5 == 1) {
                    valueAnimator.cancel();
                } else if (i5 != 2) {
                    return;
                }
                fastScroller.A = 3;
                valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
                valueAnimator.setDuration(500);
                valueAnimator.start();
            }
        };
        this.B = runnable;
        RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.FastScroller.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public final void b(RecyclerView recyclerView2, int i5, int i6) {
                int iComputeHorizontalScrollOffset = recyclerView2.computeHorizontalScrollOffset();
                int iComputeVerticalScrollOffset = recyclerView2.computeVerticalScrollOffset();
                FastScroller fastScroller = FastScroller.this;
                int iComputeVerticalScrollRange = fastScroller.s.computeVerticalScrollRange();
                int i7 = fastScroller.r;
                int i8 = iComputeVerticalScrollRange - i7;
                int i9 = fastScroller.f11455a;
                fastScroller.t = i8 > 0 && i7 >= i9;
                int iComputeHorizontalScrollRange = fastScroller.s.computeHorizontalScrollRange();
                int i10 = fastScroller.q;
                boolean z = iComputeHorizontalScrollRange - i10 > 0 && i10 >= i9;
                fastScroller.u = z;
                boolean z2 = fastScroller.t;
                if (!z2 && !z) {
                    if (fastScroller.v != 0) {
                        fastScroller.l(0);
                        return;
                    }
                    return;
                }
                if (z2) {
                    float f2 = i7;
                    fastScroller.f11466l = (int) ((((f2 / 2.0f) + iComputeVerticalScrollOffset) * f2) / iComputeVerticalScrollRange);
                    fastScroller.f11465k = Math.min(i7, (i7 * i7) / iComputeVerticalScrollRange);
                }
                if (fastScroller.u) {
                    float f3 = iComputeHorizontalScrollOffset;
                    float f4 = i10;
                    fastScroller.o = (int) ((((f4 / 2.0f) + f3) * f4) / iComputeHorizontalScrollRange);
                    fastScroller.n = Math.min(i10, (i10 * i10) / iComputeHorizontalScrollRange);
                }
                int i11 = fastScroller.v;
                if (i11 == 0 || i11 == 1) {
                    fastScroller.l(1);
                }
            }
        };
        this.f11457c = stateListDrawable;
        this.f11458d = drawable;
        this.f11461g = stateListDrawable2;
        this.f11462h = drawable2;
        this.f11459e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f11460f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f11463i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f11464j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f11455a = i3;
        this.f11456b = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new AnimatorListener());
        valueAnimatorOfFloat.addUpdateListener(new AnimatorUpdater());
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView2.n;
            if (layoutManager != null) {
                layoutManager.c("Cannot remove item decoration during a scroll  or layout");
            }
            ArrayList arrayList = recyclerView2.q;
            arrayList.remove(this);
            if (arrayList.isEmpty()) {
                recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2);
            }
            recyclerView2.U();
            recyclerView2.requestLayout();
            RecyclerView recyclerView3 = this.s;
            recyclerView3.r.remove(this);
            if (recyclerView3.s == this) {
                recyclerView3.s = null;
            }
            ArrayList arrayList2 = this.s.T0;
            if (arrayList2 != null) {
                arrayList2.remove(onScrollListener);
            }
            this.s.removeCallbacks(runnable);
        }
        this.s = recyclerView;
        recyclerView.i(this);
        this.s.r.add(this);
        this.s.k(onScrollListener);
    }

    public static int k(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 != 0) {
            int i6 = i2 - i4;
            int i7 = (int) (((f3 - f2) / i5) * i6);
            int i8 = i3 + i7;
            if (i8 < i6 && i8 >= 0) {
                return i7;
            }
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void a(MotionEvent motionEvent) {
        if (this.v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zJ = j(motionEvent.getX(), motionEvent.getY());
            boolean zI = i(motionEvent.getX(), motionEvent.getY());
            if (zJ || zI) {
                if (zI) {
                    this.w = 1;
                    this.p = (int) motionEvent.getX();
                } else if (zJ) {
                    this.w = 2;
                    this.f11467m = (int) motionEvent.getY();
                }
                l(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.v == 2) {
            this.f11467m = 0.0f;
            this.p = 0.0f;
            l(1);
            this.w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.v == 2) {
            m();
            int i2 = this.w;
            int i3 = this.f11456b;
            if (i2 == 1) {
                float x = motionEvent.getX();
                int[] iArr = this.y;
                iArr[0] = i3;
                int i4 = this.q - i3;
                iArr[1] = i4;
                float fMax = Math.max(i3, Math.min(i4, x));
                if (Math.abs(this.o - fMax) >= 2.0f) {
                    int iK = k(this.p, fMax, iArr, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
                    if (iK != 0) {
                        this.s.scrollBy(iK, 0);
                    }
                    this.p = fMax;
                }
            }
            if (this.w == 2) {
                float y = motionEvent.getY();
                int[] iArr2 = this.x;
                iArr2[0] = i3;
                int i5 = this.r - i3;
                iArr2[1] = i5;
                float fMax2 = Math.max(i3, Math.min(i5, y));
                if (Math.abs(this.f11466l - fMax2) < 2.0f) {
                    return;
                }
                int iK2 = k(this.f11467m, fMax2, iArr2, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
                if (iK2 != 0) {
                    this.s.scrollBy(0, iK2);
                }
                this.f11467m = fMax2;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final void d(boolean z) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
    public final boolean e(MotionEvent motionEvent) {
        int i2 = this.v;
        if (i2 != 1) {
            return i2 == 2;
        }
        boolean zJ = j(motionEvent.getX(), motionEvent.getY());
        boolean zI = i(motionEvent.getX(), motionEvent.getY());
        if (motionEvent.getAction() != 0) {
            return false;
        }
        if (!zJ && !zI) {
            return false;
        }
        if (zI) {
            this.w = 1;
            this.p = (int) motionEvent.getX();
        } else if (zJ) {
            this.w = 2;
            this.f11467m = (int) motionEvent.getY();
        }
        l(2);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void h(Canvas canvas, RecyclerView recyclerView) {
        int i2 = this.q;
        RecyclerView recyclerView2 = this.s;
        if (i2 != recyclerView2.getWidth() || this.r != recyclerView2.getHeight()) {
            this.q = recyclerView2.getWidth();
            this.r = recyclerView2.getHeight();
            l(0);
            return;
        }
        if (this.A != 0) {
            if (this.t) {
                int i3 = this.q;
                int i4 = this.f11459e;
                int i5 = i3 - i4;
                int i6 = this.f11466l;
                int i7 = this.f11465k;
                int i8 = i6 - (i7 / 2);
                StateListDrawable stateListDrawable = this.f11457c;
                stateListDrawable.setBounds(0, 0, i4, i7);
                int i9 = this.r;
                int i10 = this.f11460f;
                Drawable drawable = this.f11458d;
                drawable.setBounds(0, 0, i10, i9);
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                if (recyclerView2.getLayoutDirection() == 1) {
                    drawable.draw(canvas);
                    canvas.translate(i4, i8);
                    canvas.scale(-1.0f, 1.0f);
                    stateListDrawable.draw(canvas);
                    canvas.scale(-1.0f, 1.0f);
                    canvas.translate(-i4, -i8);
                } else {
                    canvas.translate(i5, 0.0f);
                    drawable.draw(canvas);
                    canvas.translate(0.0f, i8);
                    stateListDrawable.draw(canvas);
                    canvas.translate(-i5, -i8);
                }
            }
            if (this.u) {
                int i11 = this.r;
                int i12 = this.f11463i;
                int i13 = i11 - i12;
                int i14 = this.o;
                int i15 = this.n;
                int i16 = i14 - (i15 / 2);
                StateListDrawable stateListDrawable2 = this.f11461g;
                stateListDrawable2.setBounds(0, 0, i15, i12);
                int i17 = this.q;
                int i18 = this.f11464j;
                Drawable drawable2 = this.f11462h;
                drawable2.setBounds(0, 0, i17, i18);
                canvas.translate(0.0f, i13);
                drawable2.draw(canvas);
                canvas.translate(i16, 0.0f);
                stateListDrawable2.draw(canvas);
                canvas.translate(-i16, -i13);
            }
        }
    }

    public final boolean i(float f2, float f3) {
        if (f3 < this.r - this.f11463i) {
            return false;
        }
        int i2 = this.o;
        int i3 = this.n;
        return f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) ((i3 / 2) + i2));
    }

    public final boolean j(float f2, float f3) {
        RecyclerView recyclerView = this.s;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        boolean z = recyclerView.getLayoutDirection() == 1;
        int i2 = this.f11459e;
        if (!z ? f2 >= this.q - i2 : f2 <= i2) {
            int i3 = this.f11466l;
            int i4 = this.f11465k / 2;
            if (f3 >= i3 - i4 && f3 <= i4 + i3) {
                return true;
            }
        }
        return false;
    }

    public final void l(int i2) {
        Runnable runnable = this.B;
        StateListDrawable stateListDrawable = this.f11457c;
        if (i2 == 2 && this.v != 2) {
            stateListDrawable.setState(C);
            this.s.removeCallbacks(runnable);
        }
        if (i2 == 0) {
            this.s.invalidate();
        } else {
            m();
        }
        if (this.v == 2 && i2 != 2) {
            stateListDrawable.setState(D);
            this.s.removeCallbacks(runnable);
            this.s.postDelayed(runnable, 1200);
        } else if (i2 == 1) {
            this.s.removeCallbacks(runnable);
            this.s.postDelayed(runnable, ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED);
        }
        this.v = i2;
    }

    public final void m() {
        int i2 = this.A;
        ValueAnimator valueAnimator = this.z;
        if (i2 != 0) {
            if (i2 != 3) {
                return;
            } else {
                valueAnimator.cancel();
            }
        }
        this.A = 1;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        valueAnimator.setDuration(500L);
        valueAnimator.setStartDelay(0L);
        valueAnimator.start();
    }
}
