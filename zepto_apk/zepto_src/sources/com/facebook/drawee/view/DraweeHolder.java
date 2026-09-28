package com.facebook.drawee.view;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.common.internal.Objects;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RootDrawable;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class DraweeHolder<DH extends DraweeHierarchy> implements VisibilityCallback {

    /* renamed from: d, reason: collision with root package name */
    public DraweeHierarchy f17450d;

    /* renamed from: f, reason: collision with root package name */
    public final DraweeEventTracker f17452f;

    /* renamed from: a, reason: collision with root package name */
    public boolean f17447a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17448b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17449c = true;

    /* renamed from: e, reason: collision with root package name */
    public DraweeController f17451e = null;

    public DraweeHolder(GenericDraweeHierarchy genericDraweeHierarchy) {
        this.f17452f = DraweeEventTracker.f17231c ? new DraweeEventTracker() : DraweeEventTracker.f17230b;
        if (genericDraweeHierarchy != null) {
            n(genericDraweeHierarchy);
        }
    }

    public static DraweeHolder c(GenericDraweeHierarchy genericDraweeHierarchy) {
        return new DraweeHolder(genericDraweeHierarchy);
    }

    public final void a() {
        if (this.f17447a) {
            return;
        }
        this.f17452f.a(DraweeEventTracker.Event.f17239g);
        this.f17447a = true;
        DraweeController draweeController = this.f17451e;
        if (draweeController == null || draweeController.e() == null) {
            return;
        }
        this.f17451e.b();
    }

    public final void b() {
        if (this.f17448b && this.f17449c) {
            a();
            return;
        }
        if (this.f17447a) {
            this.f17452f.a(DraweeEventTracker.Event.f17240h);
            this.f17447a = false;
            if (g()) {
                this.f17451e.d();
            }
        }
    }

    public final DraweeController d() {
        return this.f17451e;
    }

    public final DraweeHierarchy e() {
        DraweeHierarchy draweeHierarchy = this.f17450d;
        draweeHierarchy.getClass();
        return draweeHierarchy;
    }

    public final Drawable f() {
        DraweeHierarchy draweeHierarchy = this.f17450d;
        if (draweeHierarchy == null) {
            return null;
        }
        return draweeHierarchy.c();
    }

    public final boolean g() {
        DraweeController draweeController = this.f17451e;
        return draweeController != null && draweeController.e() == this.f17450d;
    }

    public final void h() {
        this.f17452f.a(DraweeEventTracker.Event.o);
        this.f17448b = true;
        b();
    }

    public final void i() {
        this.f17452f.a(DraweeEventTracker.Event.p);
        this.f17448b = false;
        b();
    }

    public final boolean j(MotionEvent motionEvent) {
        if (g()) {
            return this.f17451e.a(motionEvent);
        }
        return false;
    }

    public final void k(boolean z) {
        if (this.f17449c == z) {
            return;
        }
        this.f17452f.a(z ? DraweeEventTracker.Event.q : DraweeEventTracker.Event.r);
        this.f17449c = z;
        b();
    }

    public final void l() {
        m(null);
    }

    public final void m(DraweeController draweeController) {
        boolean z = this.f17447a;
        DraweeEventTracker draweeEventTracker = this.f17452f;
        if (z && z) {
            draweeEventTracker.a(DraweeEventTracker.Event.f17240h);
            this.f17447a = false;
            if (g()) {
                this.f17451e.d();
            }
        }
        if (g()) {
            draweeEventTracker.a(DraweeEventTracker.Event.f17236d);
            this.f17451e.c(null);
        }
        this.f17451e = draweeController;
        if (draweeController != null) {
            draweeEventTracker.a(DraweeEventTracker.Event.f17235c);
            this.f17451e.c(this.f17450d);
        } else {
            draweeEventTracker.a(DraweeEventTracker.Event.f17237e);
        }
        if (z) {
            a();
        }
    }

    public final void n(DraweeHierarchy draweeHierarchy) {
        this.f17452f.a(DraweeEventTracker.Event.f17233a);
        boolean zG = g();
        Object objF = f();
        if (objF != null) {
            ((VisibilityAwareDrawable) objF).j(null);
        }
        draweeHierarchy.getClass();
        this.f17450d = draweeHierarchy;
        RootDrawable rootDrawableC = draweeHierarchy.c();
        k(rootDrawableC == null || rootDrawableC.isVisible());
        Object objF2 = f();
        if (objF2 != null) {
            ((VisibilityAwareDrawable) objF2).j(this);
        }
        if (zG) {
            this.f17451e.c(draweeHierarchy);
        }
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelperB = Objects.b(this);
        toStringHelperB.b("controllerAttached", this.f17447a);
        toStringHelperB.b("holderAttached", this.f17448b);
        toStringHelperB.b("drawableVisible", this.f17449c);
        toStringHelperB.c(this.f17452f.f17232a.toString(), "events");
        return toStringHelperB.toString();
    }
}
