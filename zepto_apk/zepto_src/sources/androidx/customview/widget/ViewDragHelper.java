package androidx.customview.widget;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.Arrays;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class ViewDragHelper {
    public static final Interpolator x = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public int f3340a;

    /* renamed from: b, reason: collision with root package name */
    public int f3341b;

    /* renamed from: d, reason: collision with root package name */
    public float[] f3343d;

    /* renamed from: e, reason: collision with root package name */
    public float[] f3344e;

    /* renamed from: f, reason: collision with root package name */
    public float[] f3345f;

    /* renamed from: g, reason: collision with root package name */
    public float[] f3346g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f3347h;

    /* renamed from: i, reason: collision with root package name */
    public int[] f3348i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f3349j;

    /* renamed from: k, reason: collision with root package name */
    public int f3350k;

    /* renamed from: l, reason: collision with root package name */
    public VelocityTracker f3351l;

    /* renamed from: m, reason: collision with root package name */
    public final float f3352m;
    public float n;
    public int o;
    public final int p;
    public int q;
    public final OverScroller r;
    public final Callback s;
    public View t;
    public boolean u;
    public final ViewGroup v;

    /* renamed from: c, reason: collision with root package name */
    public int f3342c = -1;
    public final Runnable w = new Runnable() { // from class: androidx.customview.widget.ViewDragHelper.2
        @Override // java.lang.Runnable
        public final void run() {
            ViewDragHelper.this.u(0);
        }
    };

    /* renamed from: androidx.customview.widget.ViewDragHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    }

    public ViewDragHelper(Context context, ViewGroup viewGroup, Callback callback) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.v = viewGroup;
        this.s = callback;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i2 = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.p = i2;
        this.o = i2;
        this.f3341b = viewConfiguration.getScaledTouchSlop();
        this.f3352m = viewConfiguration.getScaledMaximumFlingVelocity();
        this.n = viewConfiguration.getScaledMinimumFlingVelocity();
        this.r = new OverScroller(context, x);
    }

    public static ViewDragHelper i(DrawerLayout drawerLayout, Callback callback) {
        ViewDragHelper viewDragHelper = new ViewDragHelper(drawerLayout.getContext(), drawerLayout, callback);
        viewDragHelper.f3341b = (int) (1.0f * viewDragHelper.f3341b);
        return viewDragHelper;
    }

    public final boolean A(View view, int i2, int i3) {
        this.t = view;
        this.f3342c = -1;
        boolean zK = k(i2, i3, 0, 0);
        if (!zK && this.f3340a == 0 && this.t != null) {
            this.t = null;
        }
        return zK;
    }

    public final boolean B(int i2, View view) {
        if (view == this.t && this.f3342c == i2) {
            return true;
        }
        if (view == null || !this.s.k(i2, view)) {
            return false;
        }
        this.f3342c = i2;
        b(i2, view);
        return true;
    }

    public final void a() {
        this.f3342c = -1;
        float[] fArr = this.f3343d;
        if (fArr != null) {
            Arrays.fill(fArr, 0.0f);
            Arrays.fill(this.f3344e, 0.0f);
            Arrays.fill(this.f3345f, 0.0f);
            Arrays.fill(this.f3346g, 0.0f);
            Arrays.fill(this.f3347h, 0);
            Arrays.fill(this.f3348i, 0);
            Arrays.fill(this.f3349j, 0);
            this.f3350k = 0;
        }
        VelocityTracker velocityTracker = this.f3351l;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3351l = null;
        }
    }

    public final void b(int i2, View view) {
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.v;
        if (parent != viewGroup) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + viewGroup + ")");
        }
        this.t = view;
        this.f3342c = i2;
        this.s.g(i2, view);
        u(1);
    }

    public final boolean c(float f2, int i2, float f3, int i3) {
        float fAbs = Math.abs(f2);
        float fAbs2 = Math.abs(f3);
        if ((this.f3347h[i2] & i3) != i3 || (this.q & i3) == 0 || (this.f3349j[i2] & i3) == i3 || (this.f3348i[i2] & i3) == i3) {
            return false;
        }
        float f4 = this.f3341b;
        if (fAbs <= f4 && fAbs2 <= f4) {
            return false;
        }
        if (fAbs < fAbs2 * 0.5f) {
            this.s.getClass();
        }
        return (this.f3348i[i2] & i3) == 0 && fAbs > ((float) this.f3341b);
    }

    public final boolean d() {
        int length = this.f3343d.length;
        for (int i2 = 0; i2 < length; i2++) {
            if ((this.f3350k & (1 << i2)) != 0) {
                float f2 = this.f3345f[i2] - this.f3343d[i2];
                float f3 = this.f3346g[i2] - this.f3344e[i2];
                float f4 = (f3 * f3) + (f2 * f2);
                int i3 = this.f3341b;
                if (f4 > i3 * i3) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0044 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(android.view.View r4, float r5, float r6) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L4
            goto L45
        L4:
            androidx.customview.widget.ViewDragHelper$Callback r1 = r3.s
            int r4 = r1.c(r4)
            r2 = 1
            if (r4 <= 0) goto Lf
            r4 = r2
            goto L10
        Lf:
            r4 = r0
        L10:
            int r1 = r1.d()
            if (r1 <= 0) goto L18
            r1 = r2
            goto L19
        L18:
            r1 = r0
        L19:
            if (r4 == 0) goto L29
            if (r1 == 0) goto L29
            float r5 = r5 * r5
            float r6 = r6 * r6
            float r6 = r6 + r5
            int r4 = r3.f3341b
            int r4 = r4 * r4
            float r4 = (float) r4
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 <= 0) goto L45
            goto L44
        L29:
            if (r4 == 0) goto L37
            float r4 = java.lang.Math.abs(r5)
            int r5 = r3.f3341b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L45
            goto L44
        L37:
            if (r1 == 0) goto L45
            float r4 = java.lang.Math.abs(r6)
            int r5 = r3.f3341b
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L45
        L44:
            return r2
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.e(android.view.View, float, float):boolean");
    }

    public final void f(int i2) {
        float[] fArr = this.f3343d;
        if (fArr != null) {
            int i3 = this.f3350k;
            int i4 = 1 << i2;
            if ((i3 & i4) != 0) {
                fArr[i2] = 0.0f;
                this.f3344e[i2] = 0.0f;
                this.f3345f[i2] = 0.0f;
                this.f3346g[i2] = 0.0f;
                this.f3347h[i2] = 0;
                this.f3348i[i2] = 0;
                this.f3349j[i2] = 0;
                this.f3350k = (~i4) & i3;
            }
        }
    }

    public final int g(int i2, int i3, int i4) {
        if (i2 == 0) {
            return 0;
        }
        float width = this.v.getWidth() / 2;
        float fSin = (((float) Math.sin((Math.min(1.0f, Math.abs(i2) / r0) - 0.5f) * 0.47123894f)) * width) + width;
        int iAbs = Math.abs(i3);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fSin / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f), 600);
    }

    public final boolean h() {
        if (this.f3340a == 2) {
            OverScroller overScroller = this.r;
            boolean zComputeScrollOffset = overScroller.computeScrollOffset();
            int currX = overScroller.getCurrX();
            int currY = overScroller.getCurrY();
            int left = currX - this.t.getLeft();
            int top = currY - this.t.getTop();
            if (left != 0) {
                View view = this.t;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                view.offsetLeftAndRight(left);
            }
            if (top != 0) {
                View view2 = this.t;
                WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                view2.offsetTopAndBottom(top);
            }
            if (left != 0 || top != 0) {
                this.s.i(this.t, currX, currY);
            }
            if (zComputeScrollOffset && currX == overScroller.getFinalX() && currY == overScroller.getFinalY()) {
                overScroller.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.v.post(this.w);
            }
        }
        return this.f3340a == 2;
    }

    public final View j(int i2, int i3) {
        ViewGroup viewGroup = this.v;
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            this.s.getClass();
            View childAt = viewGroup.getChildAt(childCount);
            if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean k(int i2, int i3, int i4, int i5) {
        float f2;
        float f3;
        float f4;
        float f5;
        int left = this.t.getLeft();
        int top = this.t.getTop();
        int i6 = i2 - left;
        int i7 = i3 - top;
        OverScroller overScroller = this.r;
        if (i6 == 0 && i7 == 0) {
            overScroller.abortAnimation();
            u(0);
            return false;
        }
        View view = this.t;
        int i8 = (int) this.n;
        int i9 = (int) this.f3352m;
        int iAbs = Math.abs(i4);
        if (iAbs < i8) {
            i4 = 0;
        } else if (iAbs > i9) {
            i4 = i4 > 0 ? i9 : -i9;
        }
        int i10 = (int) this.n;
        int iAbs2 = Math.abs(i5);
        if (iAbs2 < i10) {
            i5 = 0;
        } else if (iAbs2 > i9) {
            i5 = i5 > 0 ? i9 : -i9;
        }
        int iAbs3 = Math.abs(i6);
        int iAbs4 = Math.abs(i7);
        int iAbs5 = Math.abs(i4);
        int iAbs6 = Math.abs(i5);
        int i11 = iAbs5 + iAbs6;
        int i12 = iAbs3 + iAbs4;
        if (i4 != 0) {
            f2 = iAbs5;
            f3 = i11;
        } else {
            f2 = iAbs3;
            f3 = i12;
        }
        float f6 = f2 / f3;
        if (i5 != 0) {
            f4 = iAbs6;
            f5 = i11;
        } else {
            f4 = iAbs4;
            f5 = i12;
        }
        float f7 = f4 / f5;
        Callback callback = this.s;
        overScroller.startScroll(left, top, i6, i7, (int) ((g(i7, i5, callback.d()) * f7) + (g(i6, i4, callback.c(view)) * f6)));
        u(2);
        return true;
    }

    public final int l() {
        return this.p;
    }

    public final int m() {
        return this.f3341b;
    }

    public final int n() {
        return this.f3340a;
    }

    public final boolean o(int i2) {
        if ((this.f3350k & (1 << i2)) != 0) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i2 + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public final void p(MotionEvent motionEvent) {
        int i2;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            a();
        }
        if (this.f3351l == null) {
            this.f3351l = VelocityTracker.obtain();
        }
        this.f3351l.addMovement(motionEvent);
        int i3 = 0;
        Callback callback = this.s;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewJ = j((int) x2, (int) y);
            s(pointerId, x2, y);
            B(pointerId, viewJ);
            if ((this.f3347h[pointerId] & this.q) != 0) {
                callback.f();
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f3340a == 1) {
                q();
            }
            a();
            return;
        }
        if (actionMasked == 2) {
            if (this.f3340a != 1) {
                int pointerCount = motionEvent.getPointerCount();
                while (i3 < pointerCount) {
                    int pointerId2 = motionEvent.getPointerId(i3);
                    if (o(pointerId2)) {
                        float x3 = motionEvent.getX(i3);
                        float y2 = motionEvent.getY(i3);
                        float f2 = x3 - this.f3343d[pointerId2];
                        float f3 = y2 - this.f3344e[pointerId2];
                        r(pointerId2, f2, f3);
                        if (this.f3340a != 1) {
                            View viewJ2 = j((int) x3, (int) y2);
                            if (e(viewJ2, f2, f3) && B(pointerId2, viewJ2)) {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    i3++;
                }
                t(motionEvent);
                return;
            }
            if (o(this.f3342c)) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f3342c);
                float x4 = motionEvent.getX(iFindPointerIndex);
                float y3 = motionEvent.getY(iFindPointerIndex);
                float[] fArr = this.f3345f;
                int i4 = this.f3342c;
                int i5 = (int) (x4 - fArr[i4]);
                int i6 = (int) (y3 - this.f3346g[i4]);
                int left = this.t.getLeft() + i5;
                int top = this.t.getTop() + i6;
                int left2 = this.t.getLeft();
                int top2 = this.t.getTop();
                if (i5 != 0) {
                    left = callback.a(left, this.t);
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    this.t.offsetLeftAndRight(left - left2);
                }
                if (i6 != 0) {
                    top = callback.b(top, this.t);
                    WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                    this.t.offsetTopAndBottom(top - top2);
                }
                if (i5 != 0 || i6 != 0) {
                    callback.i(this.t, left, top);
                }
                t(motionEvent);
                return;
            }
            return;
        }
        if (actionMasked == 3) {
            if (this.f3340a == 1) {
                this.u = true;
                callback.j(this.t, 0.0f, 0.0f);
                this.u = false;
                if (this.f3340a == 1) {
                    u(0);
                }
            }
            a();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x5 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            s(pointerId3, x5, y4);
            if (this.f3340a == 0) {
                B(pointerId3, j((int) x5, (int) y4));
                if ((this.f3347h[pointerId3] & this.q) != 0) {
                    callback.f();
                    return;
                }
                return;
            }
            int i7 = (int) x5;
            int i8 = (int) y4;
            View view = this.t;
            if (view != null && i7 >= view.getLeft() && i7 < view.getRight() && i8 >= view.getTop() && i8 < view.getBottom()) {
                B(pointerId3, this.t);
                return;
            }
            return;
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f3340a == 1 && pointerId4 == this.f3342c) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i3 >= pointerCount2) {
                    i2 = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i3);
                if (pointerId5 != this.f3342c) {
                    View viewJ3 = j((int) motionEvent.getX(i3), (int) motionEvent.getY(i3));
                    View view2 = this.t;
                    if (viewJ3 == view2 && B(pointerId5, view2)) {
                        i2 = this.f3342c;
                        break;
                    }
                }
                i3++;
            }
            if (i2 == -1) {
                q();
            }
        }
        f(pointerId4);
    }

    public final void q() {
        VelocityTracker velocityTracker = this.f3351l;
        float f2 = this.f3352m;
        velocityTracker.computeCurrentVelocity(1000, f2);
        float xVelocity = this.f3351l.getXVelocity(this.f3342c);
        float f3 = this.n;
        float fAbs = Math.abs(xVelocity);
        if (fAbs < f3) {
            xVelocity = 0.0f;
        } else if (fAbs > f2) {
            xVelocity = xVelocity > 0.0f ? f2 : -f2;
        }
        float yVelocity = this.f3351l.getYVelocity(this.f3342c);
        float f4 = this.n;
        float fAbs2 = Math.abs(yVelocity);
        if (fAbs2 < f4) {
            f2 = 0.0f;
        } else if (fAbs2 <= f2) {
            f2 = yVelocity;
        } else if (yVelocity <= 0.0f) {
            f2 = -f2;
        }
        this.u = true;
        this.s.j(this.t, xVelocity, f2);
        this.u = false;
        if (this.f3340a == 1) {
            u(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r4v3, types: [androidx.customview.widget.ViewDragHelper$Callback] */
    public final void r(int i2, float f2, float f3) {
        boolean zC = c(f2, i2, f3, 1);
        boolean z = zC;
        if (c(f3, i2, f2, 4)) {
            z = (zC ? 1 : 0) | 4;
        }
        boolean z2 = z;
        if (c(f2, i2, f3, 2)) {
            z2 = (z ? 1 : 0) | 2;
        }
        ?? r0 = z2;
        if (c(f3, i2, f2, 8)) {
            r0 = (z2 ? 1 : 0) | 8;
        }
        if (r0 != 0) {
            int[] iArr = this.f3348i;
            iArr[i2] = iArr[i2] | r0;
            this.s.e(r0, i2);
        }
    }

    public final void s(int i2, float f2, float f3) {
        float[] fArr = this.f3343d;
        if (fArr == null || fArr.length <= i2) {
            int i3 = i2 + 1;
            float[] fArr2 = new float[i3];
            float[] fArr3 = new float[i3];
            float[] fArr4 = new float[i3];
            float[] fArr5 = new float[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f3344e;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f3345f;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f3346g;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f3347h;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f3348i;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f3349j;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f3343d = fArr2;
            this.f3344e = fArr3;
            this.f3345f = fArr4;
            this.f3346g = fArr5;
            this.f3347h = iArr;
            this.f3348i = iArr2;
            this.f3349j = iArr3;
        }
        float[] fArr9 = this.f3343d;
        this.f3345f[i2] = f2;
        fArr9[i2] = f2;
        float[] fArr10 = this.f3344e;
        this.f3346g[i2] = f3;
        fArr10[i2] = f3;
        int[] iArr7 = this.f3347h;
        int i4 = (int) f2;
        int i5 = (int) f3;
        ViewGroup viewGroup = this.v;
        int i6 = i4 < viewGroup.getLeft() + this.o ? 1 : 0;
        if (i5 < viewGroup.getTop() + this.o) {
            i6 |= 4;
        }
        if (i4 > viewGroup.getRight() - this.o) {
            i6 |= 2;
        }
        if (i5 > viewGroup.getBottom() - this.o) {
            i6 |= 8;
        }
        iArr7[i2] = i6;
        this.f3350k = (1 << i2) | this.f3350k;
    }

    public final void t(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i2 = 0; i2 < pointerCount; i2++) {
            int pointerId = motionEvent.getPointerId(i2);
            if (o(pointerId)) {
                float x2 = motionEvent.getX(i2);
                float y = motionEvent.getY(i2);
                this.f3345f[pointerId] = x2;
                this.f3346g[pointerId] = y;
            }
        }
    }

    public final void u(int i2) {
        this.v.removeCallbacks(this.w);
        if (this.f3340a != i2) {
            this.f3340a = i2;
            this.s.h(i2);
            if (this.f3340a == 0) {
                this.t = null;
            }
        }
    }

    public final void v(int i2) {
        this.o = i2;
    }

    public final void w(int i2) {
        this.q = i2;
    }

    public final void x(float f2) {
        this.n = f2;
    }

    public final boolean y(int i2, int i3) {
        if (this.u) {
            return k(i2, i3, (int) this.f3351l.getXVelocity(this.f3342c), (int) this.f3351l.getYVelocity(this.f3342c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean z(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.customview.widget.ViewDragHelper.z(android.view.MotionEvent):boolean");
    }

    public static abstract class Callback {
        public int a(int i2, View view) {
            return 0;
        }

        public int b(int i2, View view) {
            return 0;
        }

        public int c(View view) {
            return 0;
        }

        public int d() {
            return 0;
        }

        public void e(int i2, int i3) {
        }

        public void h(int i2) {
        }

        public void j(View view, float f2, float f3) {
        }

        public abstract boolean k(int i2, View view);

        public void f() {
        }

        public void g(int i2, View view) {
        }

        public void i(View view, int i2, int i3) {
        }
    }
}
