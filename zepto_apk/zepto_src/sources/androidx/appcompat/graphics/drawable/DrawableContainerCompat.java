package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import androidx.annotation.RequiresApi;
import androidx.appcompat.graphics.drawable.StateListDrawableCompat;
import androidx.core.graphics.drawable.DrawableCompat;

/* loaded from: classes3.dex */
public class DrawableContainerCompat extends Drawable implements Drawable.Callback {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f424m = 0;

    /* renamed from: a, reason: collision with root package name */
    public DrawableContainerState f425a;

    /* renamed from: b, reason: collision with root package name */
    public Rect f426b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f427c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f428d;

    /* renamed from: f, reason: collision with root package name */
    public boolean f430f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f432h;

    /* renamed from: i, reason: collision with root package name */
    public Runnable f433i;

    /* renamed from: j, reason: collision with root package name */
    public long f434j;

    /* renamed from: k, reason: collision with root package name */
    public long f435k;

    /* renamed from: l, reason: collision with root package name */
    public BlockInvalidateCallback f436l;

    /* renamed from: e, reason: collision with root package name */
    public int f429e = 255;

    /* renamed from: g, reason: collision with root package name */
    public int f431g = -1;

    @RequiresApi
    public static class Api21Impl {
    }

    public static class BlockInvalidateCallback implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        public Drawable.Callback f438a;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Drawable.Callback callback = this.f438a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f438a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    public static abstract class DrawableContainerState extends Drawable.ConstantState {
        public final int A;
        public boolean B;
        public ColorFilter C;
        public boolean D;
        public ColorStateList E;
        public PorterDuff.Mode F;
        public boolean G;
        public boolean H;

        /* renamed from: a, reason: collision with root package name */
        public final StateListDrawableCompat f439a;

        /* renamed from: b, reason: collision with root package name */
        public Resources f440b;

        /* renamed from: c, reason: collision with root package name */
        public int f441c;

        /* renamed from: d, reason: collision with root package name */
        public int f442d;

        /* renamed from: e, reason: collision with root package name */
        public int f443e;

        /* renamed from: f, reason: collision with root package name */
        public SparseArray f444f;

        /* renamed from: g, reason: collision with root package name */
        public final Drawable[] f445g;

        /* renamed from: h, reason: collision with root package name */
        public final int f446h;

        /* renamed from: i, reason: collision with root package name */
        public final boolean f447i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f448j;

        /* renamed from: k, reason: collision with root package name */
        public Rect f449k;

        /* renamed from: l, reason: collision with root package name */
        public final boolean f450l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f451m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public int y;
        public final int z;

        public DrawableContainerState(StateListDrawableCompat.StateListState stateListState, StateListDrawableCompat stateListDrawableCompat, Resources resources) {
            this.f447i = false;
            this.f450l = false;
            this.x = true;
            this.z = 0;
            this.A = 0;
            this.f439a = stateListDrawableCompat;
            this.f440b = resources != null ? resources : stateListState != null ? stateListState.f440b : null;
            int i2 = stateListState != null ? stateListState.f441c : 0;
            int i3 = DrawableContainerCompat.f424m;
            i2 = resources != null ? resources.getDisplayMetrics().densityDpi : i2;
            i2 = i2 == 0 ? 160 : i2;
            this.f441c = i2;
            if (stateListState == null) {
                this.f445g = new Drawable[10];
                this.f446h = 0;
                return;
            }
            this.f442d = stateListState.f442d;
            this.f443e = stateListState.f443e;
            this.v = true;
            this.w = true;
            this.f447i = stateListState.f447i;
            this.f450l = stateListState.f450l;
            this.x = stateListState.x;
            this.y = stateListState.y;
            this.z = stateListState.z;
            this.A = stateListState.A;
            this.B = stateListState.B;
            this.C = stateListState.C;
            this.D = stateListState.D;
            this.E = stateListState.E;
            this.F = stateListState.F;
            this.G = stateListState.G;
            this.H = stateListState.H;
            if (stateListState.f441c == i2) {
                if (stateListState.f448j) {
                    this.f449k = stateListState.f449k != null ? new Rect(stateListState.f449k) : null;
                    this.f448j = true;
                }
                if (stateListState.f451m) {
                    this.n = stateListState.n;
                    this.o = stateListState.o;
                    this.p = stateListState.p;
                    this.q = stateListState.q;
                    this.f451m = true;
                }
            }
            if (stateListState.r) {
                this.s = stateListState.s;
                this.r = true;
            }
            if (stateListState.t) {
                this.u = stateListState.u;
                this.t = true;
            }
            Drawable[] drawableArr = stateListState.f445g;
            this.f445g = new Drawable[drawableArr.length];
            this.f446h = stateListState.f446h;
            SparseArray sparseArray = stateListState.f444f;
            if (sparseArray != null) {
                this.f444f = sparseArray.clone();
            } else {
                this.f444f = new SparseArray(this.f446h);
            }
            int i4 = this.f446h;
            for (int i5 = 0; i5 < i4; i5++) {
                Drawable drawable = drawableArr[i5];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f444f.put(i5, constantState);
                    } else {
                        this.f445g[i5] = drawableArr[i5];
                    }
                }
            }
        }

        public final void a() {
            this.f451m = true;
            b();
            int i2 = this.f446h;
            Drawable[] drawableArr = this.f445g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        public final void b() {
            SparseArray sparseArray = this.f444f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int iKeyAt = this.f444f.keyAt(i2);
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f444f.valueAt(i2);
                    Drawable[] drawableArr = this.f445g;
                    Drawable drawableNewDrawable = constantState.newDrawable(this.f440b);
                    drawableNewDrawable.setLayoutDirection(this.y);
                    Drawable drawableMutate = drawableNewDrawable.mutate();
                    drawableMutate.setCallback(this.f439a);
                    drawableArr[iKeyAt] = drawableMutate;
                }
                this.f444f = null;
            }
        }

        public final Drawable c(int i2) {
            int iIndexOfKey;
            Drawable drawable = this.f445g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f444f;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable drawableNewDrawable = ((Drawable.ConstantState) this.f444f.valueAt(iIndexOfKey)).newDrawable(this.f440b);
            drawableNewDrawable.setLayoutDirection(this.y);
            Drawable drawableMutate = drawableNewDrawable.mutate();
            drawableMutate.setCallback(this.f439a);
            this.f445g[i2] = drawableMutate;
            this.f444f.removeAt(iIndexOfKey);
            if (this.f444f.size() == 0) {
                this.f444f = null;
            }
            return drawableMutate;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final boolean canApplyTheme() {
            int i2 = this.f446h;
            Drawable[] drawableArr = this.f445g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f444f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public void d() {
            int i2 = this.f446h;
            Drawable[] drawableArr = this.f445g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    drawable.mutate();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public final int getChangingConfigurations() {
            return this.f442d | this.f443e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f430f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f427c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L36
            long r9 = r13.f434j
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L38
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f429e
            r3.setAlpha(r9)
            r13.f434j = r6
            goto L38
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r13.f425a
            int r10 = r10.z
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.f429e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L39
        L36:
            r13.f434j = r6
        L38:
            r3 = r8
        L39:
            android.graphics.drawable.Drawable r9 = r13.f428d
            if (r9 == 0) goto L61
            long r10 = r13.f435k
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L63
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L50
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f428d = r0
            r13.f435k = r6
            goto L63
        L50:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r4 = r13.f425a
            int r4 = r4.A
            int r3 = r3 / r4
            int r4 = r13.f429e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L64
        L61:
            r13.f435k = r6
        L63:
            r0 = r3
        L64:
            if (r14 == 0) goto L70
            if (r0 == 0) goto L70
            java.lang.Runnable r14 = r13.f433i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        DrawableContainerState drawableContainerState = this.f425a;
        if (theme == null) {
            drawableContainerState.getClass();
            return;
        }
        drawableContainerState.b();
        int i2 = drawableContainerState.f446h;
        Drawable[] drawableArr = drawableContainerState.f445g;
        for (int i3 = 0; i3 < i2; i3++) {
            Drawable drawable = drawableArr[i3];
            if (drawable != null && drawable.canApplyTheme()) {
                drawableArr[i3].applyTheme(theme);
                drawableContainerState.f443e |= drawableArr[i3].getChangingConfigurations();
            }
        }
        Resources resources = theme.getResources();
        if (resources != null) {
            drawableContainerState.f440b = resources;
            int i4 = resources.getDisplayMetrics().densityDpi;
            if (i4 == 0) {
                i4 = 160;
            }
            int i5 = drawableContainerState.f441c;
            drawableContainerState.f441c = i4;
            if (i5 != i4) {
                drawableContainerState.f451m = false;
                drawableContainerState.f448j = false;
            }
        }
    }

    public DrawableContainerState b() {
        return this.f425a;
    }

    public final void c(Drawable drawable) {
        if (this.f436l == null) {
            this.f436l = new BlockInvalidateCallback();
        }
        BlockInvalidateCallback blockInvalidateCallback = this.f436l;
        blockInvalidateCallback.f438a = drawable.getCallback();
        drawable.setCallback(blockInvalidateCallback);
        try {
            if (this.f425a.z <= 0 && this.f430f) {
                drawable.setAlpha(this.f429e);
            }
            DrawableContainerState drawableContainerState = this.f425a;
            if (drawableContainerState.D) {
                drawable.setColorFilter(drawableContainerState.C);
            } else {
                if (drawableContainerState.G) {
                    drawable.setTintList(drawableContainerState.E);
                }
                DrawableContainerState drawableContainerState2 = this.f425a;
                if (drawableContainerState2.H) {
                    drawable.setTintMode(drawableContainerState2.F);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f425a.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setAutoMirrored(this.f425a.B);
            Rect rect = this.f426b;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
            BlockInvalidateCallback blockInvalidateCallback2 = this.f436l;
            Drawable.Callback callback = blockInvalidateCallback2.f438a;
            blockInvalidateCallback2.f438a = null;
            drawable.setCallback(callback);
        } catch (Throwable th) {
            BlockInvalidateCallback blockInvalidateCallback3 = this.f436l;
            Drawable.Callback callback2 = blockInvalidateCallback3.f438a;
            blockInvalidateCallback3.f438a = null;
            drawable.setCallback(callback2);
            throw th;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean canApplyTheme() {
        return this.f425a.canApplyTheme();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(int r10) {
        /*
            r9 = this;
            int r0 = r9.f431g
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f425a
            int r0 = r0.A
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f428d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f427c
            if (r0 == 0) goto L29
            r9.f428d = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f425a
            int r0 = r0.A
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f435k = r0
            goto L35
        L29:
            r9.f428d = r4
            r9.f435k = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f427c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r0 = r9.f425a
            int r1 = r0.f446h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.c(r10)
            r9.f427c = r0
            r9.f431g = r10
            if (r0 == 0) goto L5a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$DrawableContainerState r10 = r9.f425a
            int r10 = r10.z
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f434j = r2
        L51:
            r9.c(r0)
            goto L5a
        L55:
            r9.f427c = r4
            r10 = -1
            r9.f431g = r10
        L5a:
            long r0 = r9.f434j
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L67
            long r1 = r9.f435k
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L7c
        L67:
            java.lang.Runnable r10 = r9.f433i
            if (r10 != 0) goto L76
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$1 r10 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$1
            r1 = r9
            androidx.appcompat.graphics.drawable.StateListDrawableCompat r1 = (androidx.appcompat.graphics.drawable.StateListDrawableCompat) r1
            r10.<init>()
            r9.f433i = r10
            goto L79
        L76:
            r9.unscheduleSelf(r10)
        L79:
            r9.a(r0)
        L7c:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.d(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Drawable drawable = this.f427c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f428d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public void e(DrawableContainerState drawableContainerState) {
        this.f425a = drawableContainerState;
        int i2 = this.f431g;
        if (i2 >= 0) {
            Drawable drawableC = drawableContainerState.c(i2);
            this.f427c = drawableC;
            if (drawableC != null) {
                c(drawableC);
            }
        }
        this.f428d = null;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.f429e;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f425a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        boolean z;
        DrawableContainerState drawableContainerState = this.f425a;
        if (!drawableContainerState.v) {
            drawableContainerState.b();
            drawableContainerState.v = true;
            int i2 = drawableContainerState.f446h;
            Drawable[] drawableArr = drawableContainerState.f445g;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    drawableContainerState.w = true;
                    z = true;
                    break;
                }
                if (drawableArr[i3].getConstantState() == null) {
                    drawableContainerState.w = false;
                    z = false;
                    break;
                }
                i3++;
            }
        } else {
            z = drawableContainerState.w;
        }
        if (!z) {
            return null;
        }
        this.f425a.f442d = getChangingConfigurations();
        return this.f425a;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.f427c;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f426b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        DrawableContainerState drawableContainerState = this.f425a;
        if (drawableContainerState.f450l) {
            if (!drawableContainerState.f451m) {
                drawableContainerState.a();
            }
            return drawableContainerState.o;
        }
        Drawable drawable = this.f427c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        DrawableContainerState drawableContainerState = this.f425a;
        if (drawableContainerState.f450l) {
            if (!drawableContainerState.f451m) {
                drawableContainerState.a();
            }
            return drawableContainerState.n;
        }
        Drawable drawable = this.f427c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        DrawableContainerState drawableContainerState = this.f425a;
        if (drawableContainerState.f450l) {
            if (!drawableContainerState.f451m) {
                drawableContainerState.a();
            }
            return drawableContainerState.q;
        }
        Drawable drawable = this.f427c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        DrawableContainerState drawableContainerState = this.f425a;
        if (drawableContainerState.f450l) {
            if (!drawableContainerState.f451m) {
                drawableContainerState.a();
            }
            return drawableContainerState.p;
        }
        Drawable drawable = this.f427c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        Drawable drawable = this.f427c;
        if (drawable != null && drawable.isVisible()) {
            DrawableContainerState drawableContainerState = this.f425a;
            if (drawableContainerState.r) {
                return drawableContainerState.s;
            }
            drawableContainerState.b();
            int i2 = drawableContainerState.f446h;
            Drawable[] drawableArr = drawableContainerState.f445g;
            opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            drawableContainerState.s = opacity;
            drawableContainerState.r = true;
        }
        return opacity;
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Drawable drawable = this.f427c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        DrawableContainerState drawableContainerState = this.f425a;
        boolean padding = false;
        Rect rect2 = null;
        if (!drawableContainerState.f447i) {
            Rect rect3 = drawableContainerState.f449k;
            if (rect3 != null || drawableContainerState.f448j) {
                rect2 = rect3;
            } else {
                drawableContainerState.b();
                Rect rect4 = new Rect();
                int i2 = drawableContainerState.f446h;
                Drawable[] drawableArr = drawableContainerState.f445g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i4 = rect4.left;
                        if (i4 > rect2.left) {
                            rect2.left = i4;
                        }
                        int i5 = rect4.top;
                        if (i5 > rect2.top) {
                            rect2.top = i5;
                        }
                        int i6 = rect4.right;
                        if (i6 > rect2.right) {
                            rect2.right = i6;
                        }
                        int i7 = rect4.bottom;
                        if (i7 > rect2.bottom) {
                            rect2.bottom = i7;
                        }
                    }
                }
                drawableContainerState.f448j = true;
                drawableContainerState.f449k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            if ((rect2.left | rect2.top | rect2.bottom | rect2.right) != 0) {
                padding = true;
            }
        } else {
            Drawable drawable = this.f427c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.f425a.B && getLayoutDirection() == 1) {
            int i8 = rect.left;
            rect.left = rect.right;
            rect.right = i8;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        DrawableContainerState drawableContainerState = this.f425a;
        if (drawableContainerState != null) {
            drawableContainerState.r = false;
            drawableContainerState.t = false;
        }
        if (drawable != this.f427c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.f425a.B;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        DrawableContainerState drawableContainerState = this.f425a;
        if (drawableContainerState.t) {
            return drawableContainerState.u;
        }
        drawableContainerState.b();
        int i2 = drawableContainerState.f446h;
        Drawable[] drawableArr = drawableContainerState.f445g;
        boolean z = false;
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            if (drawableArr[i3].isStateful()) {
                z = true;
                break;
            }
            i3++;
        }
        drawableContainerState.u = z;
        drawableContainerState.t = true;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f428d;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f428d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f427c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f430f) {
                this.f427c.setAlpha(this.f429e);
            }
        }
        if (this.f435k != 0) {
            this.f435k = 0L;
            z = true;
        }
        if (this.f434j != 0) {
            this.f434j = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f432h && super.mutate() == this) {
            DrawableContainerState drawableContainerStateB = b();
            drawableContainerStateB.d();
            e(drawableContainerStateB);
            this.f432h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f428d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f427c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i2) {
        DrawableContainerState drawableContainerState = this.f425a;
        int i3 = this.f431g;
        int i4 = drawableContainerState.f446h;
        Drawable[] drawableArr = drawableContainerState.f445g;
        boolean z = false;
        for (int i5 = 0; i5 < i4; i5++) {
            Drawable drawable = drawableArr[i5];
            if (drawable != null) {
                boolean layoutDirection = drawable.setLayoutDirection(i2);
                if (i5 == i3) {
                    z = layoutDirection;
                }
            }
        }
        drawableContainerState.y = i2;
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i2) {
        Drawable drawable = this.f428d;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f427c;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f428d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f427c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable != this.f427c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i2) {
        if (this.f430f && this.f429e == i2) {
            return;
        }
        this.f430f = true;
        this.f429e = i2;
        Drawable drawable = this.f427c;
        if (drawable != null) {
            if (this.f434j == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        DrawableContainerState drawableContainerState = this.f425a;
        if (drawableContainerState.B != z) {
            drawableContainerState.B = z;
            Drawable drawable = this.f427c;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        DrawableContainerState drawableContainerState = this.f425a;
        drawableContainerState.D = true;
        if (drawableContainerState.C != colorFilter) {
            drawableContainerState.C = colorFilter;
            Drawable drawable = this.f427c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        DrawableContainerState drawableContainerState = this.f425a;
        if (drawableContainerState.x != z) {
            drawableContainerState.x = z;
            Drawable drawable = this.f427c;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f2, float f3) {
        Drawable drawable = this.f427c;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f426b;
        if (rect == null) {
            this.f426b = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f427c;
        if (drawable != null) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i2) {
        setTintList(ColorStateList.valueOf(i2));
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        DrawableContainerState drawableContainerState = this.f425a;
        drawableContainerState.G = true;
        if (drawableContainerState.E != colorStateList) {
            drawableContainerState.E = colorStateList;
            DrawableCompat.m(this.f427c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        DrawableContainerState drawableContainerState = this.f425a;
        drawableContainerState.H = true;
        if (drawableContainerState.F != mode) {
            drawableContainerState.F = mode;
            DrawableCompat.n(this.f427c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f428d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f427c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f427c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
