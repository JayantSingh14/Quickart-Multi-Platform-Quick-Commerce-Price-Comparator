package com.google.android.material.circularreveal;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class CircularRevealHelper {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f40237a;

    /* renamed from: b, reason: collision with root package name */
    public final View f40238b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f40239c;

    /* renamed from: d, reason: collision with root package name */
    public CircularRevealWidget.RevealInfo f40240d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f40241e;

    public interface Delegate {
        void c(Canvas canvas);

        boolean d();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CircularRevealHelper(Delegate delegate) {
        this.f40237a = (ViewGroup) delegate;
        View view = (View) delegate;
        this.f40238b = view;
        view.setWillNotDraw(false);
        new Path();
        new Paint(7);
        Paint paint = new Paint(1);
        this.f40239c = paint;
        paint.setColor(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.ViewGroup, com.google.android.material.circularreveal.CircularRevealHelper$Delegate] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.graphics.Canvas r8) {
        /*
            r7 = this;
            com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo r0 = r7.f40240d
            if (r0 == 0) goto L10
            float r0 = r0.f40250c
            r1 = 2139095039(0x7f7fffff, float:3.4028235E38)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto Le
            goto L10
        Le:
            r0 = 0
            goto L11
        L10:
            r0 = 1
        L11:
            android.graphics.Paint r6 = r7.f40239c
            android.view.ViewGroup r1 = r7.f40237a
            android.view.View r2 = r7.f40238b
            if (r0 != 0) goto L39
            r1.c(r8)
            int r0 = r6.getColor()
            int r0 = android.graphics.Color.alpha(r0)
            if (r0 == 0) goto L37
            int r0 = r2.getWidth()
            float r4 = (float) r0
            int r0 = r2.getHeight()
            float r5 = (float) r0
            r2 = 0
            r3 = 0
            r1 = r8
            r1.drawRect(r2, r3, r4, r5, r6)
            goto L56
        L37:
            r1 = r8
            goto L56
        L39:
            r1.c(r8)
            int r0 = r6.getColor()
            int r0 = android.graphics.Color.alpha(r0)
            if (r0 == 0) goto L37
            int r0 = r2.getWidth()
            float r4 = (float) r0
            int r0 = r2.getHeight()
            float r5 = (float) r0
            r2 = 0
            r3 = 0
            r1 = r8
            r1.drawRect(r2, r3, r4, r5, r6)
        L56:
            android.graphics.drawable.Drawable r8 = r7.f40241e
            if (r8 == 0) goto L87
            com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo r0 = r7.f40240d
            if (r0 == 0) goto L87
            android.graphics.Rect r8 = r8.getBounds()
            com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo r0 = r7.f40240d
            float r0 = r0.f40248a
            int r2 = r8.width()
            float r2 = (float) r2
            r3 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r3
            float r0 = r0 - r2
            com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo r2 = r7.f40240d
            float r2 = r2.f40249b
            int r8 = r8.height()
            float r8 = (float) r8
            float r8 = r8 / r3
            float r2 = r2 - r8
            r1.translate(r0, r2)
            android.graphics.drawable.Drawable r8 = r7.f40241e
            r8.draw(r1)
            float r8 = -r0
            float r0 = -r2
            r1.translate(r8, r0)
        L87:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.circularreveal.CircularRevealHelper.a(android.graphics.Canvas):void");
    }

    public final CircularRevealWidget.RevealInfo b() {
        CircularRevealWidget.RevealInfo revealInfo = this.f40240d;
        if (revealInfo == null) {
            return null;
        }
        CircularRevealWidget.RevealInfo revealInfo2 = new CircularRevealWidget.RevealInfo(revealInfo);
        if (revealInfo2.f40250c == Float.MAX_VALUE) {
            float f2 = revealInfo2.f40248a;
            float f3 = revealInfo2.f40249b;
            View view = this.f40238b;
            revealInfo2.f40250c = MathUtils.b(f2, f3, view.getWidth(), view.getHeight());
        }
        return revealInfo2;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [android.view.ViewGroup, com.google.android.material.circularreveal.CircularRevealHelper$Delegate] */
    public final boolean c() {
        if (this.f40237a.d()) {
            CircularRevealWidget.RevealInfo revealInfo = this.f40240d;
            if (revealInfo == null || revealInfo.f40250c == Float.MAX_VALUE) {
                return true;
            }
        }
        return false;
    }

    public final void d(Drawable drawable) {
        this.f40241e = drawable;
        this.f40238b.invalidate();
    }

    public final void e(int i2) {
        this.f40239c.setColor(i2);
        this.f40238b.invalidate();
    }

    public final void f(CircularRevealWidget.RevealInfo revealInfo) {
        View view = this.f40238b;
        if (revealInfo == null) {
            this.f40240d = null;
        } else {
            CircularRevealWidget.RevealInfo revealInfo2 = this.f40240d;
            if (revealInfo2 == null) {
                this.f40240d = new CircularRevealWidget.RevealInfo(revealInfo);
            } else {
                float f2 = revealInfo.f40248a;
                float f3 = revealInfo.f40249b;
                float f4 = revealInfo.f40250c;
                revealInfo2.f40248a = f2;
                revealInfo2.f40249b = f3;
                revealInfo2.f40250c = f4;
            }
            if (revealInfo.f40250c + 1.0E-4f >= MathUtils.b(revealInfo.f40248a, revealInfo.f40249b, view.getWidth(), view.getHeight())) {
                this.f40240d.f40250c = Float.MAX_VALUE;
            }
        }
        view.invalidate();
    }
}
