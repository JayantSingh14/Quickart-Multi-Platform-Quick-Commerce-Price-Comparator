package com.facebook.drawee.controller;

import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.MotionEvent;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Objects;
import com.facebook.common.logging.FLog;
import com.facebook.common.logging.FLogDefaultLoggingDelegate;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.debug.DebugControllerOverlayDrawable;
import com.facebook.drawee.drawable.ScaleTypeDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.gestures.GestureDetector;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.interfaces.SettableDraweeHierarchy;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.fresco.ui.common.ForwardingControllerListener2;
import com.facebook.fresco.ui.common.OnFadeListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Map;
import javax.annotation.concurrent.NotThreadSafe;
import kotlin.jvm.internal.Intrinsics;

@NotThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public abstract class AbstractDraweeController<T, INFO> implements DraweeController, DeferredReleaser.Releasable, GestureDetector.ClickListener {
    public static final Map q = ImmutableMap.a("component_tag", "drawee");
    public static final Map r = ImmutableMap.b("origin", "memory_bitmap", "origin_sub", "shortcut");
    public static final Class s = AbstractDraweeController.class;

    /* renamed from: a, reason: collision with root package name */
    public final DraweeEventTracker f17246a;

    /* renamed from: b, reason: collision with root package name */
    public final DeferredReleaser f17247b;

    /* renamed from: c, reason: collision with root package name */
    public final UiThreadImmediateExecutorService f17248c;

    /* renamed from: d, reason: collision with root package name */
    public ControllerListener f17249d;

    /* renamed from: e, reason: collision with root package name */
    public final ForwardingControllerListener2 f17250e;

    /* renamed from: f, reason: collision with root package name */
    public SettableDraweeHierarchy f17251f;

    /* renamed from: g, reason: collision with root package name */
    public DebugControllerOverlayDrawable f17252g;

    /* renamed from: h, reason: collision with root package name */
    public String f17253h;

    /* renamed from: i, reason: collision with root package name */
    public Object f17254i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f17255j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f17256k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f17257l;

    /* renamed from: m, reason: collision with root package name */
    public DataSource f17258m;
    public Object n;
    public boolean o;
    public Drawable p;

    /* renamed from: com.facebook.drawee.controller.AbstractDraweeController$1, reason: invalid class name */
    class AnonymousClass1 implements OnFadeListener {
    }

    public static class InternalForwardingListener<INFO> extends ForwardingControllerListener<INFO> {
    }

    public AbstractDraweeController(DeferredReleaser deferredReleaser, UiThreadImmediateExecutorService uiThreadImmediateExecutorService) {
        this.f17246a = DraweeEventTracker.f17231c ? new DraweeEventTracker() : DraweeEventTracker.f17230b;
        this.f17250e = new ForwardingControllerListener2();
        this.o = true;
        this.f17247b = deferredReleaser;
        this.f17248c = uiThreadImmediateExecutorService;
        p(null, null);
    }

    public abstract void A(Object obj);

    public final void B(String str, Object obj, DataSource dataSource) {
        ImageInfo imageInfoM = m(obj);
        ControllerListener controllerListenerJ = j();
        Object obj2 = this.p;
        controllerListenerJ.l(str, imageInfoM, obj2 instanceof Animatable ? (Animatable) obj2 : null);
        this.f17250e.r(str, imageInfoM, t(dataSource != null ? dataSource.getExtras() : null, u(imageInfoM)));
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public final boolean a(MotionEvent motionEvent) {
        boolean zA = FLog.f17086a.a(2);
        Class cls = s;
        if (!zA) {
            return false;
        }
        FLog.k(cls, "controller %x %s: onTouchEvent %s", Integer.valueOf(System.identityHashCode(this)), this.f17253h, motionEvent);
        return false;
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public final void b() {
        FrescoSystrace.a();
        if (FLog.f17086a.a(2)) {
            FLog.k(s, "controller %x %s: onAttach: %s", Integer.valueOf(System.identityHashCode(this)), this.f17253h, this.f17256k ? "request already submitted" : "request needs submit");
        }
        this.f17246a.a(DraweeEventTracker.Event.f17239g);
        this.f17251f.getClass();
        this.f17247b.a(this);
        this.f17255j = true;
        if (!this.f17256k) {
            FrescoSystrace.a();
            Object objI = i();
            DraweeEventTracker draweeEventTracker = this.f17246a;
            if (objI != null) {
                FrescoSystrace.a();
                this.f17258m = null;
                this.f17256k = true;
                this.f17257l = false;
                draweeEventTracker.a(DraweeEventTracker.Event.s);
                DataSource dataSource = this.f17258m;
                ImageInfo imageInfoM = m(objI);
                j().n(this.f17254i, this.f17253h);
                String str = this.f17253h;
                Object obj = this.f17254i;
                n();
                this.f17250e.e(str, obj, t(dataSource != null ? dataSource.getExtras() : null, u(imageInfoM)));
                w(objI);
                x(this.f17253h, this.f17258m, objI, 1.0f, true, true, true);
                FrescoSystrace.a();
                FrescoSystrace.a();
            } else {
                draweeEventTracker.a(DraweeEventTracker.Event.f17242j);
                this.f17251f.b(0.0f, true);
                this.f17256k = true;
                this.f17257l = false;
                DataSource dataSourceK = k();
                this.f17258m = dataSourceK;
                j().n(this.f17254i, this.f17253h);
                String str2 = this.f17253h;
                Object obj2 = this.f17254i;
                n();
                this.f17250e.e(str2, obj2, t(dataSourceK == null ? null : dataSourceK.getExtras(), u(null)));
                if (FLog.f17086a.a(2)) {
                    FLog.k(s, "controller %x %s: submitRequest: dataSource: %x", Integer.valueOf(System.identityHashCode(this)), this.f17253h, Integer.valueOf(System.identityHashCode(this.f17258m)));
                }
                final String str3 = this.f17253h;
                final boolean zC = this.f17258m.c();
                this.f17258m.g(new BaseDataSubscriber<Object>() { // from class: com.facebook.drawee.controller.AbstractDraweeController.2
                    @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
                    public final void d(DataSource dataSource2) {
                        boolean zB = dataSource2.b();
                        float fE = dataSource2.e();
                        Map map = AbstractDraweeController.q;
                        AbstractDraweeController abstractDraweeController = AbstractDraweeController.this;
                        if (!abstractDraweeController.q(str3, dataSource2)) {
                            abstractDraweeController.r("ignore_old_datasource @ onProgress", null);
                            dataSource2.close();
                        } else {
                            if (zB) {
                                return;
                            }
                            abstractDraweeController.f17251f.b(fE, false);
                        }
                    }

                    @Override // com.facebook.datasource.BaseDataSubscriber
                    public final void e(DataSource dataSource2) {
                        Throwable thD = dataSource2.d();
                        Map map = AbstractDraweeController.q;
                        AbstractDraweeController.this.v(str3, dataSource2, thD, true);
                    }

                    @Override // com.facebook.datasource.BaseDataSubscriber
                    public final void f(DataSource dataSource2) {
                        boolean zB = dataSource2.b();
                        boolean zF = dataSource2.f();
                        float fE = dataSource2.e();
                        Object objA = dataSource2.a();
                        if (objA != null) {
                            Map map = AbstractDraweeController.q;
                            AbstractDraweeController.this.x(str3, dataSource2, objA, fE, zB, zC, zF);
                            return;
                        }
                        if (zB) {
                            NullPointerException nullPointerException = new NullPointerException();
                            Map map2 = AbstractDraweeController.q;
                            AbstractDraweeController.this.v(str3, dataSource2, nullPointerException, true);
                        }
                    }
                }, this.f17248c);
                FrescoSystrace.a();
            }
        }
        FrescoSystrace.a();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public void c(DraweeHierarchy draweeHierarchy) {
        if (FLog.f17086a.a(2)) {
            FLog.k(s, "controller %x %s: setHierarchy: %s", Integer.valueOf(System.identityHashCode(this)), this.f17253h, draweeHierarchy);
        }
        this.f17246a.a(draweeHierarchy != null ? DraweeEventTracker.Event.f17233a : DraweeEventTracker.Event.f17234b);
        if (this.f17256k) {
            this.f17247b.a(this);
            release();
        }
        SettableDraweeHierarchy settableDraweeHierarchy = this.f17251f;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.a(null);
            this.f17251f = null;
        }
        if (draweeHierarchy != null) {
            if (!(draweeHierarchy instanceof SettableDraweeHierarchy)) {
                throw new IllegalArgumentException();
            }
            SettableDraweeHierarchy settableDraweeHierarchy2 = (SettableDraweeHierarchy) draweeHierarchy;
            this.f17251f = settableDraweeHierarchy2;
            settableDraweeHierarchy2.a(this.f17252g);
        }
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public final void d() {
        FrescoSystrace.a();
        if (FLog.f17086a.a(2)) {
            FLog.j(s, "controller %x %s: onDetach", Integer.valueOf(System.identityHashCode(this)), this.f17253h);
        }
        this.f17246a.a(DraweeEventTracker.Event.f17240h);
        this.f17255j = false;
        this.f17247b.c(this);
        FrescoSystrace.a();
    }

    @Override // com.facebook.drawee.interfaces.DraweeController
    public final SettableDraweeHierarchy e() {
        return this.f17251f;
    }

    public final void f(ControllerListener controllerListener) {
        controllerListener.getClass();
        ControllerListener controllerListener2 = this.f17249d;
        if (controllerListener2 instanceof InternalForwardingListener) {
            ((InternalForwardingListener) controllerListener2).b(controllerListener);
            return;
        }
        if (controllerListener2 == null) {
            this.f17249d = controllerListener;
            return;
        }
        FrescoSystrace.a();
        InternalForwardingListener internalForwardingListener = new InternalForwardingListener();
        internalForwardingListener.b(controllerListener2);
        internalForwardingListener.b(controllerListener);
        FrescoSystrace.a();
        this.f17249d = internalForwardingListener;
    }

    public final void g(ControllerListener2 listener) {
        ForwardingControllerListener2 forwardingControllerListener2 = this.f17250e;
        synchronized (forwardingControllerListener2) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            forwardingControllerListener2.f17467a.add(listener);
        }
    }

    public abstract Drawable h(Object obj);

    public Object i() {
        return null;
    }

    public final ControllerListener j() {
        ControllerListener controllerListener = this.f17249d;
        return controllerListener == null ? BaseControllerListener.f17279a : controllerListener;
    }

    public abstract DataSource k();

    public int l(Object obj) {
        return System.identityHashCode(obj);
    }

    public abstract ImageInfo m(Object obj);

    public Uri n() {
        return null;
    }

    public final SettableDraweeHierarchy o() {
        SettableDraweeHierarchy settableDraweeHierarchy = this.f17251f;
        if (settableDraweeHierarchy != null) {
            return settableDraweeHierarchy;
        }
        throw new IllegalStateException("mSettableDraweeHierarchy is null; Caller context: " + this.f17254i);
    }

    public final synchronized void p(Object obj, String str) {
        DeferredReleaser deferredReleaser;
        try {
            FrescoSystrace.a();
            this.f17246a.a(DraweeEventTracker.Event.f17238f);
            if (!this.o && (deferredReleaser = this.f17247b) != null) {
                deferredReleaser.a(this);
            }
            this.f17255j = false;
            z();
            ControllerListener controllerListener = this.f17249d;
            if (controllerListener instanceof InternalForwardingListener) {
                InternalForwardingListener internalForwardingListener = (InternalForwardingListener) controllerListener;
                synchronized (internalForwardingListener) {
                    internalForwardingListener.f17280a.clear();
                }
            } else {
                this.f17249d = null;
            }
            SettableDraweeHierarchy settableDraweeHierarchy = this.f17251f;
            if (settableDraweeHierarchy != null) {
                settableDraweeHierarchy.reset();
                this.f17251f.a(null);
                this.f17251f = null;
            }
            this.f17252g = null;
            if (FLog.f17086a.a(2)) {
                FLog.k(s, "controller %x %s -> %s: initialize", Integer.valueOf(System.identityHashCode(this)), this.f17253h, str);
            }
            this.f17253h = str;
            this.f17254i = obj;
            FrescoSystrace.a();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final boolean q(String str, DataSource dataSource) {
        if (dataSource == null && this.f17258m == null) {
            return true;
        }
        return str.equals(this.f17253h) && dataSource == this.f17258m && this.f17256k;
    }

    public final void r(String str, Throwable th) {
        if (FLog.f17086a.a(2)) {
            Integer numValueOf = Integer.valueOf(System.identityHashCode(this));
            String str2 = this.f17253h;
            if (FLog.f17086a.a(2)) {
                FLogDefaultLoggingDelegate.b(2, s.getSimpleName(), String.format(null, "controller %x %s: %s: failure: %s", numValueOf, str2, str, th));
            }
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser.Releasable
    public final void release() {
        this.f17246a.a(DraweeEventTracker.Event.f17241i);
        SettableDraweeHierarchy settableDraweeHierarchy = this.f17251f;
        if (settableDraweeHierarchy != null) {
            settableDraweeHierarchy.reset();
        }
        z();
    }

    public final void s(Object obj, String str) {
        if (FLog.f17086a.a(2)) {
            Object[] objArr = {Integer.valueOf(System.identityHashCode(this)), this.f17253h, str, obj != null ? obj.getClass().getSimpleName() : "<null>", Integer.valueOf(l(obj))};
            if (FLog.f17086a.a(2)) {
                FLogDefaultLoggingDelegate.b(2, s.getSimpleName(), String.format(null, "controller %x %s: %s: image: %s %x", objArr));
            }
        }
    }

    public final ControllerListener2.Extras t(Map map, Map map2) {
        SettableDraweeHierarchy settableDraweeHierarchy = this.f17251f;
        if (settableDraweeHierarchy instanceof GenericDraweeHierarchy) {
            GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) settableDraweeHierarchy;
            String.valueOf(!(genericDraweeHierarchy.j(2) instanceof ScaleTypeDrawable) ? null : genericDraweeHierarchy.l(2).f17377d);
            if (genericDraweeHierarchy.j(2) instanceof ScaleTypeDrawable) {
                genericDraweeHierarchy.l(2).getClass();
            }
        }
        SettableDraweeHierarchy settableDraweeHierarchy2 = this.f17251f;
        Rect bounds = settableDraweeHierarchy2 != null ? settableDraweeHierarchy2.getBounds() : null;
        Object obj = this.f17254i;
        Map componentAttribution = q;
        Intrinsics.checkNotNullParameter(componentAttribution, "componentAttribution");
        Map shortcutAttribution = r;
        Intrinsics.checkNotNullParameter(shortcutAttribution, "shortcutAttribution");
        ControllerListener2.Extras extras = new ControllerListener2.Extras();
        if (bounds != null) {
            bounds.width();
            bounds.height();
        }
        extras.f17466e = obj;
        extras.f17464c = map;
        extras.f17465d = map2;
        extras.f17463b = shortcutAttribution;
        extras.f17462a = componentAttribution;
        return extras;
    }

    public String toString() {
        Objects.ToStringHelper toStringHelperB = Objects.b(this);
        toStringHelperB.b("isAttached", this.f17255j);
        toStringHelperB.b("isRequestSubmitted", this.f17256k);
        toStringHelperB.b("hasFetchFailed", this.f17257l);
        toStringHelperB.c(String.valueOf(l(this.n)), "fetchedImage");
        toStringHelperB.c(this.f17246a.f17232a.toString(), "events");
        return toStringHelperB.toString();
    }

    public abstract Map u(Object obj);

    public final void v(String str, DataSource dataSource, Throwable th, boolean z) {
        FrescoSystrace.a();
        if (!q(str, dataSource)) {
            r("ignore_old_datasource @ onFailure", th);
            dataSource.close();
            FrescoSystrace.a();
            return;
        }
        this.f17246a.a(z ? DraweeEventTracker.Event.f17245m : DraweeEventTracker.Event.n);
        ForwardingControllerListener2 forwardingControllerListener2 = this.f17250e;
        if (z) {
            r("final_failed @ onFailure", th);
            this.f17258m = null;
            this.f17257l = true;
            SettableDraweeHierarchy settableDraweeHierarchy = this.f17251f;
            if (settableDraweeHierarchy != null) {
                settableDraweeHierarchy.e();
            }
            ControllerListener2.Extras extrasT = t(dataSource == null ? null : dataSource.getExtras(), u(null));
            j().e(this.f17253h, th);
            forwardingControllerListener2.l(this.f17253h, th, extrasT);
        } else {
            r("intermediate_failed @ onFailure", th);
            j().q(this.f17253h, th);
            forwardingControllerListener2.b(this.f17253h);
        }
        FrescoSystrace.a();
    }

    public final void x(String str, DataSource dataSource, Object obj, float f2, boolean z, boolean z2, boolean z3) {
        try {
            FrescoSystrace.a();
            if (!q(str, dataSource)) {
                s(obj, "ignore_old_datasource @ onNewResult");
                A(obj);
                dataSource.close();
                FrescoSystrace.a();
                return;
            }
            this.f17246a.a(z ? DraweeEventTracker.Event.f17243k : DraweeEventTracker.Event.f17244l);
            try {
                Drawable drawableH = h(obj);
                Object obj2 = this.n;
                Drawable drawable = this.p;
                this.n = obj;
                this.p = drawableH;
                try {
                    if (z) {
                        s(obj, "set_final_result @ onNewResult");
                        this.f17258m = null;
                        o().d(drawableH, 1.0f, z2);
                        B(str, obj, dataSource);
                    } else if (z3) {
                        s(obj, "set_temporary_result @ onNewResult");
                        o().d(drawableH, 1.0f, z2);
                        B(str, obj, dataSource);
                    } else {
                        s(obj, "set_intermediate_result @ onNewResult");
                        o().d(drawableH, f2, z2);
                        ImageInfo imageInfoM = m(obj);
                        j().a(imageInfoM, str);
                        this.f17250e.a(imageInfoM, str);
                    }
                    if (drawable != null && drawable != drawableH) {
                        y(drawable);
                    }
                    if (obj2 != null && obj2 != obj) {
                        s(obj2, "release_previous_result @ onNewResult");
                        A(obj2);
                    }
                    FrescoSystrace.a();
                } catch (Throwable th) {
                    if (drawable != null && drawable != drawableH) {
                        y(drawable);
                    }
                    if (obj2 != null && obj2 != obj) {
                        s(obj2, "release_previous_result @ onNewResult");
                        A(obj2);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                s(obj, "drawable_failed @ onNewResult");
                A(obj);
                v(str, dataSource, e2, z);
                FrescoSystrace.a();
            }
        } catch (Throwable th2) {
            FrescoSystrace.a();
            throw th2;
        }
    }

    public abstract void y(Drawable drawable);

    public final void z() {
        Map extras;
        boolean z = this.f17256k;
        this.f17256k = false;
        this.f17257l = false;
        DataSource dataSource = this.f17258m;
        Map map = null;
        if (dataSource != null) {
            extras = dataSource.getExtras();
            this.f17258m.close();
            this.f17258m = null;
        } else {
            extras = null;
        }
        Drawable drawable = this.p;
        if (drawable != null) {
            y(drawable);
        }
        this.p = null;
        Object obj = this.n;
        if (obj != null) {
            Map mapU = u(m(obj));
            s(this.n, "release");
            A(this.n);
            this.n = null;
            map = mapU;
        }
        if (z) {
            j().f(this.f17253h);
            this.f17250e.c(this.f17253h, t(extras, map));
        }
    }

    public void w(Object obj) {
    }
}
