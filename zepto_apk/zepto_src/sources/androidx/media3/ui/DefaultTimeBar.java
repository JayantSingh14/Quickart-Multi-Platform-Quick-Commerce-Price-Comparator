package androidx.media3.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.ui.TimeBar;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import org.xbill.DNS.KEYRecord;

@UnstableApi
/* loaded from: classes3.dex */
public class DefaultTimeBar extends View implements TimeBar {
    public static final /* synthetic */ int B0 = 0;
    public int A;
    public boolean[] A0;
    public long B;
    public int C;
    public Rect D;
    public final ValueAnimator E;
    public float F;
    public boolean G;
    public boolean H;
    public long I;
    public long J;
    public long K;
    public long L;
    public int M;
    public long[] Q;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f10836a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f10837b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f10838c;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f10839d;

    /* renamed from: e, reason: collision with root package name */
    public final Paint f10840e;

    /* renamed from: f, reason: collision with root package name */
    public final Paint f10841f;

    /* renamed from: g, reason: collision with root package name */
    public final Paint f10842g;

    /* renamed from: h, reason: collision with root package name */
    public final Paint f10843h;

    /* renamed from: i, reason: collision with root package name */
    public final Paint f10844i;

    /* renamed from: j, reason: collision with root package name */
    public final Paint f10845j;

    /* renamed from: k, reason: collision with root package name */
    public final Drawable f10846k;

    /* renamed from: l, reason: collision with root package name */
    public final int f10847l;

    /* renamed from: m, reason: collision with root package name */
    public final int f10848m;
    public final int n;
    public final int o;
    public final int p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final StringBuilder u;
    public final Formatter v;
    public final a w;
    public final CopyOnWriteArraySet x;
    public final Point y;
    public final float z;

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public static int c(float f2, int i2) {
        return (int) ((i2 * f2) + 0.5f);
    }

    private long getPositionIncrement() {
        long j2 = this.B;
        if (j2 != -9223372036854775807L) {
            return j2;
        }
        long j3 = this.J;
        if (j3 == -9223372036854775807L) {
            return 0L;
        }
        return j3 / this.A;
    }

    private String getProgressText() {
        return Util.E(this.u, this.v, this.K);
    }

    private long getScrubberPosition() {
        if (this.f10837b.width() <= 0 || this.J == -9223372036854775807L) {
            return 0L;
        }
        return (this.f10839d.width() * this.J) / r0.width();
    }

    @Override // androidx.media3.ui.TimeBar
    public final void a(TimeBar.OnScrubListener onScrubListener) {
        this.x.add(onScrubListener);
    }

    @Override // androidx.media3.ui.TimeBar
    public final void b(long[] jArr, boolean[] zArr, int i2) {
        Assertions.a(i2 == 0 || !(jArr == null || zArr == null));
        this.M = i2;
        this.Q = jArr;
        this.A0 = zArr;
        g();
    }

    public final boolean d(long j2) {
        long j3 = this.J;
        if (j3 <= 0) {
            return false;
        }
        long j4 = this.H ? this.I : this.K;
        long jL = Util.l(j4 + j2, 0L, j3);
        if (jL == j4) {
            return false;
        }
        if (this.H) {
            h(jL);
        } else {
            e(jL);
        }
        g();
        return true;
    }

    @Override // android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f10846k;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    public final void e(long j2) {
        this.I = j2;
        this.H = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((TimeBar.OnScrubListener) it.next()).h(j2);
        }
    }

    public final void f(boolean z) {
        removeCallbacks(this.w);
        this.H = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((TimeBar.OnScrubListener) it.next()).B(this.I, z);
        }
    }

    public final void g() {
        Rect rect = this.f10838c;
        Rect rect2 = this.f10837b;
        rect.set(rect2);
        Rect rect3 = this.f10839d;
        rect3.set(rect2);
        long j2 = this.H ? this.I : this.K;
        if (this.J > 0) {
            rect.right = Math.min(rect2.left + ((int) ((rect2.width() * this.L) / this.J)), rect2.right);
            rect3.right = Math.min(rect2.left + ((int) ((rect2.width() * j2) / this.J)), rect2.right);
        } else {
            int i2 = rect2.left;
            rect.right = i2;
            rect3.right = i2;
        }
        invalidate(this.f10836a);
    }

    @Override // androidx.media3.ui.TimeBar
    public long getPreferredUpdateDelay() {
        int iWidth = (int) (this.f10837b.width() / this.z);
        if (iWidth == 0) {
            return Long.MAX_VALUE;
        }
        long j2 = this.J;
        if (j2 == 0 || j2 == -9223372036854775807L) {
            return Long.MAX_VALUE;
        }
        return j2 / iWidth;
    }

    public final void h(long j2) {
        if (this.I == j2) {
            return;
        }
        this.I = j2;
        Iterator it = this.x.iterator();
        while (it.hasNext()) {
            ((TimeBar.OnScrubListener) it.next()).z(j2);
        }
    }

    @Override // android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f10846k;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        canvas.save();
        Rect rect = this.f10837b;
        int iHeight = rect.height();
        int iCenterY = rect.centerY() - (iHeight / 2);
        int i2 = iCenterY + iHeight;
        long j2 = this.J;
        Paint paint = this.f10842g;
        Rect rect2 = this.f10839d;
        if (j2 <= 0) {
            canvas2 = canvas;
            canvas2.drawRect(rect.left, iCenterY, rect.right, i2, paint);
        } else {
            Rect rect3 = this.f10838c;
            int i3 = rect3.left;
            int i4 = rect3.right;
            int iMax = Math.max(Math.max(rect.left, i4), rect2.right);
            int i5 = rect.right;
            if (iMax < i5) {
                canvas.drawRect(iMax, iCenterY, i5, i2, paint);
            }
            int iMax2 = Math.max(i3, rect2.right);
            if (i4 > iMax2) {
                canvas.drawRect(iMax2, iCenterY, i4, i2, this.f10841f);
            }
            if (rect2.width() > 0) {
                canvas.drawRect(rect2.left, iCenterY, rect2.right, i2, this.f10840e);
            }
            if (this.M != 0) {
                long[] jArr = this.Q;
                jArr.getClass();
                boolean[] zArr = this.A0;
                zArr.getClass();
                int i6 = this.o;
                int i7 = i6 / 2;
                int i8 = 0;
                int i9 = 0;
                while (i9 < this.M) {
                    int i10 = i9;
                    canvas.drawRect(Math.min(rect.width() - i6, Math.max(i8, ((int) ((rect.width() * Util.l(jArr[i9], 0L, this.J)) / this.J)) - i7)) + rect.left, iCenterY, r3 + i6, i2, zArr[i9] ? this.f10844i : this.f10843h);
                    i9 = i10 + 1;
                    i8 = i8;
                }
            }
            canvas2 = canvas;
        }
        if (this.J > 0) {
            int iK = Util.k(rect2.right, rect2.left, rect.right);
            int iCenterY2 = rect2.centerY();
            Drawable drawable = this.f10846k;
            if (drawable == null) {
                canvas2.drawCircle(iK, iCenterY2, (int) ((((this.H || isFocused()) ? this.r : isEnabled() ? this.p : this.q) * this.F) / 2.0f), this.f10845j);
            } else {
                int intrinsicWidth = ((int) (drawable.getIntrinsicWidth() * this.F)) / 2;
                int intrinsicHeight = ((int) (drawable.getIntrinsicHeight() * this.F)) / 2;
                drawable.setBounds(iK - intrinsicWidth, iCenterY2 - intrinsicHeight, iK + intrinsicWidth, iCenterY2 + intrinsicHeight);
                drawable.draw(canvas2);
            }
        }
        canvas2.restore();
    }

    @Override // android.view.View
    public final void onFocusChanged(boolean z, int i2, Rect rect) {
        super.onFocusChanged(z, i2, rect);
        if (!this.H || z) {
            return;
        }
        f(false);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.J <= 0) {
            return;
        }
        if (Util.f5744a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(KEYRecord.Flags.FLAG2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0025  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L2e
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L25
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L25;
                default: goto L12;
            }
        L12:
            goto L2e
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.d(r0)
            if (r0 == 0) goto L2e
            androidx.media3.ui.a r5 = r4.w
            r4.removeCallbacks(r5)
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L25:
            boolean r0 = r4.H
            if (r0 == 0) goto L2e
            r5 = 0
            r4.f(r5)
            return r3
        L2e:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingBottom;
        int paddingBottom2;
        Rect rect;
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i6 - getPaddingRight();
        int i8 = this.G ? 0 : this.s;
        int i9 = this.n;
        int i10 = this.f10847l;
        int i11 = this.f10848m;
        if (i9 == 1) {
            paddingBottom = (i7 - getPaddingBottom()) - i11;
            paddingBottom2 = ((i7 - getPaddingBottom()) - i10) - Math.max(i8 - (i10 / 2), 0);
        } else {
            paddingBottom = (i7 - i11) / 2;
            paddingBottom2 = (i7 - i10) / 2;
        }
        Rect rect2 = this.f10836a;
        rect2.set(paddingLeft, paddingBottom, paddingRight, i11 + paddingBottom);
        this.f10837b.set(rect2.left + i8, paddingBottom2, rect2.right - i8, i10 + paddingBottom2);
        if (Util.f5744a >= 29 && ((rect = this.D) == null || rect.width() != i6 || this.D.height() != i7)) {
            Rect rect3 = new Rect(0, 0, i6, i7);
            this.D = rect3;
            setSystemGestureExclusionRects(Collections.singletonList(rect3));
        }
        g();
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int i4 = this.f10848m;
        if (mode == 0) {
            size = i4;
        } else if (mode != 1073741824) {
            size = Math.min(i4, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i2), size);
        Drawable drawable = this.f10846k;
        if (drawable != null && drawable.isStateful() && drawable.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        Drawable drawable = this.f10846k;
        if (drawable == null || Util.f5744a < 23 || !drawable.setLayoutDirection(i2)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.isEnabled()
            r1 = 0
            if (r0 == 0) goto La1
            long r2 = r9.J
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L11
            goto La1
        L11:
            android.graphics.Point r0 = r9.y
            float r2 = r10.getX()
            int r2 = (int) r2
            float r3 = r10.getY()
            int r3 = (int) r3
            r0.set(r2, r3)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r10.getAction()
            android.graphics.Rect r4 = r9.f10839d
            android.graphics.Rect r5 = r9.f10837b
            r6 = 1
            if (r3 == 0) goto L7d
            r7 = 3
            if (r3 == r6) goto L6e
            r8 = 2
            if (r3 == r8) goto L38
            if (r3 == r7) goto L6e
            goto La1
        L38:
            boolean r10 = r9.H
            if (r10 == 0) goto La1
            int r10 = r9.t
            if (r0 >= r10) goto L52
            int r10 = r9.C
            int r2 = r2 - r10
            int r2 = r2 / r7
            int r2 = r2 + r10
            float r10 = (float) r2
            int r10 = (int) r10
            int r0 = r5.left
            int r1 = r5.right
            int r10 = androidx.media3.common.util.Util.k(r10, r0, r1)
            r4.right = r10
            goto L60
        L52:
            r9.C = r2
            float r10 = (float) r2
            int r10 = (int) r10
            int r0 = r5.left
            int r1 = r5.right
            int r10 = androidx.media3.common.util.Util.k(r10, r0, r1)
            r4.right = r10
        L60:
            long r0 = r9.getScrubberPosition()
            r9.h(r0)
            r9.g()
            r9.invalidate()
            return r6
        L6e:
            boolean r0 = r9.H
            if (r0 == 0) goto La1
            int r10 = r10.getAction()
            if (r10 != r7) goto L79
            r1 = r6
        L79:
            r9.f(r1)
            return r6
        L7d:
            float r10 = (float) r2
            float r0 = (float) r0
            int r10 = (int) r10
            int r0 = (int) r0
            android.graphics.Rect r2 = r9.f10836a
            boolean r0 = r2.contains(r10, r0)
            if (r0 == 0) goto La1
            int r0 = r5.left
            int r1 = r5.right
            int r10 = androidx.media3.common.util.Util.k(r10, r0, r1)
            r4.right = r10
            long r0 = r9.getScrubberPosition()
            r9.e(r0)
            r9.g()
            r9.invalidate()
            return r6
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.DefaultTimeBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (super.performAccessibilityAction(i2, bundle)) {
            return true;
        }
        if (this.J <= 0) {
            return false;
        }
        if (i2 == 8192) {
            if (d(-getPositionIncrement())) {
                f(false);
            }
        } else {
            if (i2 != 4096) {
                return false;
            }
            if (d(getPositionIncrement())) {
                f(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(@ColorInt int i2) {
        this.f10843h.setColor(i2);
        invalidate(this.f10836a);
    }

    public void setBufferedColor(@ColorInt int i2) {
        this.f10841f.setColor(i2);
        invalidate(this.f10836a);
    }

    @Override // androidx.media3.ui.TimeBar
    public void setBufferedPosition(long j2) {
        if (this.L == j2) {
            return;
        }
        this.L = j2;
        g();
    }

    @Override // androidx.media3.ui.TimeBar
    public void setDuration(long j2) {
        if (this.J == j2) {
            return;
        }
        this.J = j2;
        if (this.H && j2 == -9223372036854775807L) {
            f(true);
        }
        g();
    }

    @Override // android.view.View, androidx.media3.ui.TimeBar
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!this.H || z) {
            return;
        }
        f(true);
    }

    public void setKeyCountIncrement(int i2) {
        Assertions.a(i2 > 0);
        this.A = i2;
        this.B = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j2) {
        Assertions.a(j2 > 0);
        this.A = -1;
        this.B = j2;
    }

    public void setPlayedAdMarkerColor(@ColorInt int i2) {
        this.f10844i.setColor(i2);
        invalidate(this.f10836a);
    }

    public void setPlayedColor(@ColorInt int i2) {
        this.f10840e.setColor(i2);
        invalidate(this.f10836a);
    }

    @Override // androidx.media3.ui.TimeBar
    public void setPosition(long j2) {
        if (this.K == j2) {
            return;
        }
        this.K = j2;
        setContentDescription(getProgressText());
        g();
    }

    public void setScrubberColor(@ColorInt int i2) {
        this.f10845j.setColor(i2);
        invalidate(this.f10836a);
    }

    public void setUnplayedColor(@ColorInt int i2) {
        this.f10842g.setColor(i2);
        invalidate(this.f10836a);
    }

    public DefaultTimeBar(Context context, @Nullable AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet, i2);
        this.f10836a = new Rect();
        this.f10837b = new Rect();
        this.f10838c = new Rect();
        this.f10839d = new Rect();
        Paint paint = new Paint();
        this.f10840e = paint;
        Paint paint2 = new Paint();
        this.f10841f = paint2;
        Paint paint3 = new Paint();
        this.f10842g = paint3;
        Paint paint4 = new Paint();
        this.f10843h = paint4;
        Paint paint5 = new Paint();
        this.f10844i = paint5;
        Paint paint6 = new Paint();
        this.f10845j = paint6;
        paint6.setAntiAlias(true);
        this.x = new CopyOnWriteArraySet();
        this.y = new Point();
        float f2 = context.getResources().getDisplayMetrics().density;
        this.z = f2;
        this.t = c(f2, -50);
        int iC = c(f2, 4);
        int iC2 = c(f2, 26);
        int iC3 = c(f2, 4);
        int iC4 = c(f2, 12);
        int iC5 = c(f2, 0);
        int iC6 = c(f2, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.DefaultTimeBar, i2, i3);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.DefaultTimeBar_scrubber_drawable);
                this.f10846k = drawable;
                if (drawable != null) {
                    int i4 = Util.f5744a;
                    if (i4 >= 23) {
                        int layoutDirection = getLayoutDirection();
                        if (i4 < 23 || drawable.setLayoutDirection(layoutDirection)) {
                        }
                    }
                    iC2 = Math.max(drawable.getMinimumHeight(), iC2);
                }
                this.f10847l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_bar_height, iC);
                this.f10848m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_touch_target_height, iC2);
                this.n = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_bar_gravity, 0);
                this.o = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_ad_marker_width, iC3);
                this.p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_enabled_size, iC4);
                this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_disabled_size, iC5);
                this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.DefaultTimeBar_scrubber_dragged_size, iC6);
                int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_color, -1);
                int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_scrubber_color, -1);
                int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_buffered_color, -855638017);
                int i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_unplayed_color, 872415231);
                int i9 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_ad_marker_color, -1291845888);
                int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.DefaultTimeBar_played_ad_marker_color, 872414976);
                paint.setColor(i5);
                paint6.setColor(i6);
                paint2.setColor(i7);
                paint3.setColor(i8);
                paint4.setColor(i9);
                paint5.setColor(i10);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.f10847l = iC;
            this.f10848m = iC2;
            this.n = 0;
            this.o = iC3;
            this.p = iC4;
            this.q = iC5;
            this.r = iC6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f10846k = null;
        }
        StringBuilder sb = new StringBuilder();
        this.u = sb;
        this.v = new Formatter(sb, Locale.getDefault());
        this.w = new a(0, this);
        Drawable drawable2 = this.f10846k;
        if (drawable2 != null) {
            this.s = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.s = (Math.max(this.q, Math.max(this.p, this.r)) + 1) / 2;
        }
        this.F = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.E = valueAnimator;
        valueAnimator.addUpdateListener(new g(this, 4));
        this.J = -9223372036854775807L;
        this.B = -9223372036854775807L;
        this.A = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }
}
