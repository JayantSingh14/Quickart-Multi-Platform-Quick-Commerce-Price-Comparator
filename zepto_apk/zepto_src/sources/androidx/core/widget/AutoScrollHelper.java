package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.core.view.ViewCompat;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    public static final int q = ViewConfiguration.getTapTimeout();

    /* renamed from: a, reason: collision with root package name */
    public final ClampedScroller f3248a;

    /* renamed from: b, reason: collision with root package name */
    public final AccelerateInterpolator f3249b;

    /* renamed from: c, reason: collision with root package name */
    public final ListView f3250c;

    /* renamed from: d, reason: collision with root package name */
    public Runnable f3251d;

    /* renamed from: e, reason: collision with root package name */
    public final float[] f3252e;

    /* renamed from: f, reason: collision with root package name */
    public final float[] f3253f;

    /* renamed from: g, reason: collision with root package name */
    public final int f3254g;

    /* renamed from: h, reason: collision with root package name */
    public final int f3255h;

    /* renamed from: i, reason: collision with root package name */
    public final float[] f3256i;

    /* renamed from: j, reason: collision with root package name */
    public final float[] f3257j;

    /* renamed from: k, reason: collision with root package name */
    public final float[] f3258k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3259l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3260m;
    public boolean n;
    public boolean o;
    public boolean p;

    public static class ClampedScroller {

        /* renamed from: a, reason: collision with root package name */
        public int f3261a;

        /* renamed from: b, reason: collision with root package name */
        public int f3262b;

        /* renamed from: c, reason: collision with root package name */
        public float f3263c;

        /* renamed from: d, reason: collision with root package name */
        public float f3264d;

        /* renamed from: e, reason: collision with root package name */
        public long f3265e;

        /* renamed from: f, reason: collision with root package name */
        public long f3266f;

        /* renamed from: g, reason: collision with root package name */
        public long f3267g;

        /* renamed from: h, reason: collision with root package name */
        public float f3268h;

        /* renamed from: i, reason: collision with root package name */
        public int f3269i;

        public final float a(long j2) {
            if (j2 < this.f3265e) {
                return 0.0f;
            }
            long j3 = this.f3267g;
            if (j3 < 0 || j2 < j3) {
                return AutoScrollHelper.c((j2 - r0) / this.f3261a, 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f3268h;
            return (AutoScrollHelper.c((j2 - j3) / this.f3269i, 0.0f, 1.0f) * f2) + (1.0f - f2);
        }
    }

    public class ScrollAnimationRunnable implements Runnable {
        public ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.o) {
                boolean z = autoScrollHelper.f3260m;
                ClampedScroller clampedScroller = autoScrollHelper.f3248a;
                if (z) {
                    autoScrollHelper.f3260m = false;
                    long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    clampedScroller.f3265e = jCurrentAnimationTimeMillis;
                    clampedScroller.f3267g = -1L;
                    clampedScroller.f3266f = jCurrentAnimationTimeMillis;
                    clampedScroller.f3268h = 0.5f;
                }
                if ((clampedScroller.f3267g > 0 && AnimationUtils.currentAnimationTimeMillis() > clampedScroller.f3267g + clampedScroller.f3269i) || !autoScrollHelper.g()) {
                    autoScrollHelper.o = false;
                    return;
                }
                boolean z2 = autoScrollHelper.n;
                ListView listView = autoScrollHelper.f3250c;
                if (z2) {
                    autoScrollHelper.n = false;
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    listView.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (clampedScroller.f3266f == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                long jCurrentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                float fA = clampedScroller.a(jCurrentAnimationTimeMillis2);
                long j2 = jCurrentAnimationTimeMillis2 - clampedScroller.f3266f;
                clampedScroller.f3266f = jCurrentAnimationTimeMillis2;
                autoScrollHelper.f((int) (j2 * ((fA * 4.0f) + ((-4.0f) * fA * fA)) * clampedScroller.f3264d));
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                listView.postOnAnimation(this);
            }
        }
    }

    public AutoScrollHelper(ListView listView) {
        ClampedScroller clampedScroller = new ClampedScroller();
        clampedScroller.f3265e = Long.MIN_VALUE;
        clampedScroller.f3267g = -1L;
        clampedScroller.f3266f = 0L;
        this.f3248a = clampedScroller;
        this.f3249b = new AccelerateInterpolator();
        float[] fArr = {0.0f, 0.0f};
        this.f3252e = fArr;
        float[] fArr2 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f3253f = fArr2;
        float[] fArr3 = {0.0f, 0.0f};
        this.f3256i = fArr3;
        float[] fArr4 = {0.0f, 0.0f};
        this.f3257j = fArr4;
        float[] fArr5 = {Float.MAX_VALUE, Float.MAX_VALUE};
        this.f3258k = fArr5;
        this.f3250c = listView;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float f3 = ((int) ((1575.0f * f2) + 0.5f)) / 1000.0f;
        fArr5[0] = f3;
        fArr5[1] = f3;
        float f4 = ((int) ((f2 * 315.0f) + 0.5f)) / 1000.0f;
        fArr4[0] = f4;
        fArr4[1] = f4;
        this.f3254g = 1;
        fArr2[0] = Float.MAX_VALUE;
        fArr2[1] = Float.MAX_VALUE;
        fArr[0] = 0.2f;
        fArr[1] = 0.2f;
        fArr3[0] = 0.001f;
        fArr3[1] = 0.001f;
        this.f3255h = q;
        clampedScroller.f3261a = 500;
        clampedScroller.f3262b = 500;
    }

    public static float c(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    public abstract boolean a(int i2);

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float b(float r4, float r5, float r6, int r7) {
        /*
            r3 = this;
            float[] r0 = r3.f3252e
            r0 = r0[r7]
            float[] r1 = r3.f3253f
            r1 = r1[r7]
            float r0 = r0 * r5
            r2 = 0
            float r0 = c(r0, r2, r1)
            float r1 = r3.d(r4, r0)
            float r5 = r5 - r4
            float r4 = r3.d(r5, r0)
            float r4 = r4 - r1
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            android.view.animation.AccelerateInterpolator r0 = r3.f3249b
            if (r5 >= 0) goto L25
            float r4 = -r4
            float r4 = r0.getInterpolation(r4)
            float r4 = -r4
            goto L2d
        L25:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 <= 0) goto L36
            float r4 = r0.getInterpolation(r4)
        L2d:
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            r0 = 1065353216(0x3f800000, float:1.0)
            float r4 = c(r4, r5, r0)
            goto L37
        L36:
            r4 = r2
        L37:
            int r5 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r5 != 0) goto L3c
            return r2
        L3c:
            float[] r0 = r3.f3256i
            r0 = r0[r7]
            float[] r1 = r3.f3257j
            r1 = r1[r7]
            float[] r2 = r3.f3258k
            r7 = r2[r7]
            float r0 = r0 * r6
            if (r5 <= 0) goto L51
            float r4 = r4 * r0
            float r4 = c(r4, r1, r7)
            return r4
        L51:
            float r4 = -r4
            float r4 = r4 * r0
            float r4 = c(r4, r1, r7)
            float r4 = -r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.b(float, float, float, int):float");
    }

    public final float d(float f2, float f3) {
        if (f3 != 0.0f) {
            int i2 = this.f3254g;
            if (i2 == 0 || i2 == 1) {
                if (f2 < f3) {
                    if (f2 >= 0.0f) {
                        return 1.0f - (f2 / f3);
                    }
                    if (this.o && i2 == 1) {
                        return 1.0f;
                    }
                }
            } else if (i2 == 2 && f2 < 0.0f) {
                return f2 / (-f3);
            }
        }
        return 0.0f;
    }

    public final void e() {
        int i2 = 0;
        if (this.f3260m) {
            this.o = false;
            return;
        }
        ClampedScroller clampedScroller = this.f3248a;
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = (int) (jCurrentAnimationTimeMillis - clampedScroller.f3265e);
        int i4 = clampedScroller.f3262b;
        if (i3 > i4) {
            i2 = i4;
        } else if (i3 >= 0) {
            i2 = i3;
        }
        clampedScroller.f3269i = i2;
        clampedScroller.f3268h = clampedScroller.a(jCurrentAnimationTimeMillis);
        clampedScroller.f3267g = jCurrentAnimationTimeMillis;
    }

    public abstract void f(int i2);

    public final boolean g() {
        ClampedScroller clampedScroller = this.f3248a;
        float f2 = clampedScroller.f3264d;
        int iAbs = (int) (f2 / Math.abs(f2));
        Math.abs(clampedScroller.f3263c);
        return iAbs != 0 && a(iAbs);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0014, code lost:
    
        if (r0 != 3) goto L30;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
        /*
            r7 = this;
            boolean r0 = r7.p
            r1 = 0
            if (r0 != 0) goto L7
            goto L7e
        L7:
            int r0 = r9.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1b
            if (r0 == r2) goto L17
            r3 = 2
            if (r0 == r3) goto L1f
            r8 = 3
            if (r0 == r8) goto L17
            goto L7e
        L17:
            r7.e()
            return r1
        L1b:
            r7.n = r2
            r7.f3259l = r1
        L1f:
            float r0 = r9.getX()
            int r3 = r8.getWidth()
            float r3 = (float) r3
            android.widget.ListView r4 = r7.f3250c
            int r5 = r4.getWidth()
            float r5 = (float) r5
            float r0 = r7.b(r0, r3, r5, r1)
            float r9 = r9.getY()
            int r8 = r8.getHeight()
            float r8 = (float) r8
            int r3 = r4.getHeight()
            float r3 = (float) r3
            float r8 = r7.b(r9, r8, r3, r2)
            androidx.core.widget.AutoScrollHelper$ClampedScroller r9 = r7.f3248a
            r9.f3263c = r0
            r9.f3264d = r8
            boolean r8 = r7.o
            if (r8 != 0) goto L7e
            boolean r8 = r7.g()
            if (r8 == 0) goto L7e
            java.lang.Runnable r8 = r7.f3251d
            if (r8 != 0) goto L60
            androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable r8 = new androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable
            r8.<init>()
            r7.f3251d = r8
        L60:
            r7.o = r2
            r7.f3260m = r2
            boolean r8 = r7.f3259l
            if (r8 != 0) goto L75
            int r8 = r7.f3255h
            if (r8 <= 0) goto L75
            java.lang.Runnable r9 = r7.f3251d
            long r5 = (long) r8
            java.util.WeakHashMap r8 = androidx.core.view.ViewCompat.f3080a
            r4.postOnAnimationDelayed(r9, r5)
            goto L7c
        L75:
            java.lang.Runnable r8 = r7.f3251d
            androidx.core.widget.AutoScrollHelper$ScrollAnimationRunnable r8 = (androidx.core.widget.AutoScrollHelper.ScrollAnimationRunnable) r8
            r8.run()
        L7c:
            r7.f3259l = r2
        L7e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }
}
