package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.ConnectivityMonitor;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.manager.TargetTracker;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Util;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes3.dex */
public class RequestManager implements ComponentCallbacks2, LifecycleListener, ModelTypes<RequestBuilder<Drawable>> {

    /* renamed from: l, reason: collision with root package name */
    public static final RequestOptions f15700l;

    /* renamed from: a, reason: collision with root package name */
    public final Glide f15701a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f15702b;

    /* renamed from: c, reason: collision with root package name */
    public final Lifecycle f15703c;

    /* renamed from: d, reason: collision with root package name */
    public final RequestTracker f15704d;

    /* renamed from: e, reason: collision with root package name */
    public final RequestManagerTreeNode f15705e;

    /* renamed from: f, reason: collision with root package name */
    public final TargetTracker f15706f;

    /* renamed from: g, reason: collision with root package name */
    public final Runnable f15707g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f15708h;

    /* renamed from: i, reason: collision with root package name */
    public final ConnectivityMonitor f15709i;

    /* renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList f15710j;

    /* renamed from: k, reason: collision with root package name */
    public final RequestOptions f15711k;

    public class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {

        /* renamed from: a, reason: collision with root package name */
        public final RequestTracker f15713a;

        public RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.f15713a = requestTracker;
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public final void a(boolean z) {
            if (z) {
                synchronized (RequestManager.this) {
                    RequestTracker requestTracker = this.f15713a;
                    Iterator it = Util.d(requestTracker.f16419a).iterator();
                    while (it.hasNext()) {
                        Request request = (Request) it.next();
                        if (!request.c() && !request.b()) {
                            request.clear();
                            if (requestTracker.f16421c) {
                                requestTracker.f16420b.add(request);
                            } else {
                                request.d();
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        RequestOptions requestOptions = (RequestOptions) new RequestOptions().c(Bitmap.class);
        requestOptions.n = true;
        f15700l = requestOptions;
        ((RequestOptions) new RequestOptions().c(GifDrawable.class)).n = true;
    }

    public RequestManager(Glide glide, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, Context context) {
        RequestOptions requestOptions;
        RequestTracker requestTracker = new RequestTracker();
        DefaultConnectivityMonitorFactory defaultConnectivityMonitorFactory = glide.f15654g;
        this.f15706f = new TargetTracker();
        Runnable runnable = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            @Override // java.lang.Runnable
            public final void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.f15703c.b(requestManager);
            }
        };
        this.f15707g = runnable;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f15708h = handler;
        this.f15701a = glide;
        this.f15703c = lifecycle;
        this.f15705e = requestManagerTreeNode;
        this.f15704d = requestTracker;
        this.f15702b = context;
        ConnectivityMonitor connectivityMonitorA = defaultConnectivityMonitorFactory.a(context.getApplicationContext(), new RequestManagerConnectivityListener(requestTracker));
        this.f15709i = connectivityMonitorA;
        char[] cArr = Util.f16528a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            lifecycle.b(this);
        } else {
            handler.post(runnable);
        }
        lifecycle.b(connectivityMonitorA);
        this.f15710j = new CopyOnWriteArrayList(glide.f15650c.f15674d);
        GlideContext glideContext = glide.f15650c;
        synchronized (glideContext) {
            try {
                if (glideContext.f15678h == null) {
                    ((GlideBuilder.AnonymousClass1) glideContext.f15673c).getClass();
                    RequestOptions requestOptions2 = new RequestOptions();
                    requestOptions2.n = true;
                    glideContext.f15678h = requestOptions2;
                }
                requestOptions = glideContext.f15678h;
            } finally {
            }
        }
        synchronized (this) {
            RequestOptions requestOptions3 = (RequestOptions) requestOptions.clone();
            if (requestOptions3.n && !requestOptions3.o) {
                throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            }
            requestOptions3.o = true;
            requestOptions3.n = true;
            this.f15711k = requestOptions3;
        }
        synchronized (glide.f15655h) {
            try {
                if (glide.f15655h.contains(this)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                glide.f15655h.add(this);
            } finally {
            }
        }
    }

    public final void b(Target target) {
        if (target == null) {
            return;
        }
        boolean zM = m(target);
        Request request = target.getRequest();
        if (zM) {
            return;
        }
        Glide glide = this.f15701a;
        synchronized (glide.f15655h) {
            try {
                Iterator it = glide.f15655h.iterator();
                while (it.hasNext()) {
                    if (((RequestManager) it.next()).m(target)) {
                        return;
                    }
                }
                if (request != null) {
                    target.j(null);
                    request.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final synchronized void e() {
        h();
        this.f15706f.e();
    }

    public final synchronized void h() {
        RequestTracker requestTracker = this.f15704d;
        requestTracker.f16421c = true;
        Iterator it = Util.d(requestTracker.f16419a).iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            if (request.isRunning()) {
                request.pause();
                requestTracker.f16420b.add(request);
            }
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final synchronized void i() {
        l();
        this.f15706f.i();
    }

    public final synchronized void l() {
        RequestTracker requestTracker = this.f15704d;
        requestTracker.f16421c = false;
        Iterator it = Util.d(requestTracker.f16419a).iterator();
        while (it.hasNext()) {
            Request request = (Request) it.next();
            if (!request.c() && !request.isRunning()) {
                request.d();
            }
        }
        requestTracker.f16420b.clear();
    }

    public final synchronized boolean m(Target target) {
        Request request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f15704d.a(request)) {
            return false;
        }
        this.f15706f.f16423a.remove(target);
        target.j(null);
        return true;
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final synchronized void onDestroy() {
        try {
            this.f15706f.onDestroy();
            Iterator it = Util.d(this.f15706f.f16423a).iterator();
            while (it.hasNext()) {
                b((Target) it.next());
            }
            this.f15706f.f16423a.clear();
            RequestTracker requestTracker = this.f15704d;
            Iterator it2 = Util.d(requestTracker.f16419a).iterator();
            while (it2.hasNext()) {
                requestTracker.a((Request) it2.next());
            }
            requestTracker.f16420b.clear();
            this.f15703c.a(this);
            this.f15703c.a(this.f15709i);
            this.f15708h.removeCallbacks(this.f15707g);
            Glide glide = this.f15701a;
            synchronized (glide.f15655h) {
                if (!glide.f15655h.contains(this)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                glide.f15655h.remove(this);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f15704d + ", treeNode=" + this.f15705e + "}";
    }

    public static class ClearTarget extends CustomViewTarget<View, Object> {
        @Override // com.bumptech.glide.request.target.CustomViewTarget
        public final void b(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void g(Object obj, Transition transition) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public final void d() {
        }
    }
}
