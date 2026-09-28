package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.util.Log;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.NoTransition;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    public static final boolean z = Log.isLoggable("Request", 2);

    /* renamed from: a, reason: collision with root package name */
    public final String f16457a;

    /* renamed from: b, reason: collision with root package name */
    public final StateVerifier f16458b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f16459c;

    /* renamed from: d, reason: collision with root package name */
    public final GlideContext f16460d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f16461e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f16462f;

    /* renamed from: g, reason: collision with root package name */
    public final RequestBuilder f16463g;

    /* renamed from: h, reason: collision with root package name */
    public final int f16464h;

    /* renamed from: i, reason: collision with root package name */
    public final int f16465i;

    /* renamed from: j, reason: collision with root package name */
    public final Priority f16466j;

    /* renamed from: k, reason: collision with root package name */
    public final Target f16467k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f16468l;

    /* renamed from: m, reason: collision with root package name */
    public final NoTransition.NoAnimationFactory f16469m;
    public final Executor n;
    public Resource o;
    public Engine.LoadStatus p;
    public long q;
    public volatile Engine r;
    public Status s;
    public Drawable t;
    public Drawable u;
    public Drawable v;
    public int w;
    public int x;
    public boolean y;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Status {

        /* renamed from: a, reason: collision with root package name */
        public static final Status f16470a;

        /* renamed from: b, reason: collision with root package name */
        public static final Status f16471b;

        /* renamed from: c, reason: collision with root package name */
        public static final Status f16472c;

        /* renamed from: d, reason: collision with root package name */
        public static final Status f16473d;

        /* renamed from: e, reason: collision with root package name */
        public static final Status f16474e;

        /* renamed from: f, reason: collision with root package name */
        public static final Status f16475f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ Status[] f16476g;

        static {
            Status status = new Status("PENDING", 0);
            f16470a = status;
            Status status2 = new Status("RUNNING", 1);
            f16471b = status2;
            Status status3 = new Status("WAITING_FOR_SIZE", 2);
            f16472c = status3;
            Status status4 = new Status("COMPLETE", 3);
            f16473d = status4;
            Status status5 = new Status("FAILED", 4);
            f16474e = status5;
            Status status6 = new Status("CLEARED", 5);
            f16475f = status6;
            f16476g = new Status[]{status, status2, status3, status4, status5, status6};
        }

        public static Status valueOf(String str) {
            return (Status) Enum.valueOf(Status.class, str);
        }

        public static Status[] values() {
            return (Status[]) f16476g.clone();
        }
    }

    public SingleRequest(Context context, GlideContext glideContext, Object obj, Object obj2, Class cls, RequestBuilder requestBuilder, int i2, int i3, Priority priority, Target target, ArrayList arrayList, Engine engine, NoTransition.NoAnimationFactory noAnimationFactory, Executor executor) {
        this.f16457a = z ? String.valueOf(hashCode()) : null;
        this.f16458b = StateVerifier.a();
        this.f16459c = obj;
        this.f16460d = glideContext;
        this.f16461e = obj2;
        this.f16462f = cls;
        this.f16463g = requestBuilder;
        this.f16464h = i2;
        this.f16465i = i3;
        this.f16466j = priority;
        this.f16467k = target;
        this.f16468l = arrayList;
        this.r = engine;
        this.f16469m = noAnimationFactory;
        this.n = executor;
        this.s = Status.f16470a;
        glideContext.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.target.SizeReadyCallback
    public final void a(int i2, int i3) throws Throwable {
        SingleRequest<R> singleRequest = this;
        int iRound = i2;
        singleRequest.f16458b.b();
        Object obj = singleRequest.f16459c;
        synchronized (obj) {
            try {
                try {
                    boolean z2 = z;
                    if (z2) {
                        singleRequest.g("Got onSizeReady in " + LogTime.a(singleRequest.q));
                    }
                    if (singleRequest.s == Status.f16472c) {
                        Status status = Status.f16471b;
                        singleRequest.s = status;
                        singleRequest.f16463g.getClass();
                        if (iRound != Integer.MIN_VALUE) {
                            iRound = Math.round(iRound * 1.0f);
                        }
                        singleRequest.w = iRound;
                        singleRequest.x = i3 == Integer.MIN_VALUE ? i3 : Math.round(1.0f * i3);
                        if (z2) {
                            singleRequest.g("finished setup for calling load in " + LogTime.a(singleRequest.q));
                        }
                        Engine engine = singleRequest.r;
                        GlideContext glideContext = singleRequest.f16460d;
                        Object obj2 = singleRequest.f16461e;
                        RequestBuilder requestBuilder = singleRequest.f16463g;
                        Key key = requestBuilder.f16448h;
                        try {
                            int i4 = singleRequest.w;
                            int i5 = singleRequest.x;
                            Class cls = requestBuilder.f16453m;
                            try {
                                Class cls2 = singleRequest.f16462f;
                                Priority priority = singleRequest.f16466j;
                                DiskCacheStrategy diskCacheStrategy = requestBuilder.f16442b;
                                try {
                                    CachedHashCodeArrayMap cachedHashCodeArrayMap = requestBuilder.f16452l;
                                    boolean z3 = requestBuilder.f16449i;
                                    boolean z4 = requestBuilder.p;
                                    try {
                                        Options options = requestBuilder.f16451k;
                                        boolean z5 = requestBuilder.f16445e;
                                        boolean z6 = requestBuilder.q;
                                        Executor executor = singleRequest.n;
                                        singleRequest = obj;
                                        try {
                                            singleRequest.p = engine.a(glideContext, obj2, key, i4, i5, cls, cls2, priority, diskCacheStrategy, cachedHashCodeArrayMap, z3, z4, options, z5, z6, singleRequest, executor);
                                            if (singleRequest.s != status) {
                                                singleRequest.p = null;
                                            }
                                            if (z2) {
                                                singleRequest.g("finished onSizeReady in " + LogTime.a(singleRequest.q));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        singleRequest = obj;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    singleRequest = obj;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                singleRequest = obj;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            singleRequest = obj;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                singleRequest = obj;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean b() {
        boolean z2;
        synchronized (this.f16459c) {
            z2 = this.s == Status.f16475f;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean c() {
        boolean z2;
        synchronized (this.f16459c) {
            z2 = this.s == Status.f16473d;
        }
        return z2;
    }

    @Override // com.bumptech.glide.request.Request
    public final void clear() {
        synchronized (this.f16459c) {
            try {
                if (this.y) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f16458b.b();
                Status status = this.s;
                Status status2 = Status.f16475f;
                if (status == status2) {
                    return;
                }
                if (this.y) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f16458b.b();
                this.f16467k.a(this);
                Engine.LoadStatus loadStatus = this.p;
                Resource resource = null;
                if (loadStatus != null) {
                    loadStatus.a();
                    this.p = null;
                }
                Resource resource2 = this.o;
                if (resource2 != null) {
                    this.o = null;
                    resource = resource2;
                }
                this.f16467k.f(f());
                this.s = status2;
                if (resource != null) {
                    this.r.getClass();
                    Engine.g(resource);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final void d() {
        synchronized (this.f16459c) {
            try {
                if (this.y) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f16458b.b();
                int i2 = LogTime.f16520b;
                this.q = SystemClock.elapsedRealtimeNanos();
                if (this.f16461e == null) {
                    if (Util.h(this.f16464h, this.f16465i)) {
                        this.w = this.f16464h;
                        this.x = this.f16465i;
                    }
                    if (this.v == null) {
                        this.f16463g.getClass();
                        this.v = null;
                    }
                    h(new GlideException("Received null model"), this.v == null ? 5 : 3);
                    return;
                }
                Status status = this.s;
                Status status2 = Status.f16471b;
                if (status == status2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (status == Status.f16473d) {
                    i(this.o, DataSource.f15792e);
                    return;
                }
                Status status3 = Status.f16472c;
                this.s = status3;
                if (Util.h(this.f16464h, this.f16465i)) {
                    a(this.f16464h, this.f16465i);
                } else {
                    this.f16467k.c(this);
                }
                Status status4 = this.s;
                if (status4 == status2 || status4 == status3) {
                    Target target = this.f16467k;
                    f();
                    target.k();
                }
                if (z) {
                    g("finished run method in " + LogTime.a(this.q));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Object e() {
        this.f16458b.b();
        return this.f16459c;
    }

    public final Drawable f() {
        if (this.u == null) {
            this.u = this.f16463g.f16444d;
        }
        return this.u;
    }

    public final void g(String str) {
        StringBuilder sbX = b.x(str, " this: ");
        sbX.append(this.f16457a);
        Log.v("Request", sbX.toString());
    }

    public final void h(GlideException glideException, int i2) {
        Drawable drawable;
        this.f16458b.b();
        synchronized (this.f16459c) {
            try {
                glideException.getClass();
                int i3 = this.f16460d.f15677g;
                if (i3 <= i2) {
                    Log.w("Glide", "Load failed for " + this.f16461e + " with size [" + this.w + "x" + this.x + "]", glideException);
                    if (i3 <= 4) {
                        glideException.d();
                    }
                }
                this.p = null;
                this.s = Status.f16474e;
                this.y = true;
                try {
                    ArrayList arrayList = this.f16468l;
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        if (it.hasNext()) {
                            ((RequestListener) it.next()).h(glideException);
                            throw null;
                        }
                    }
                    if (this.f16461e == null) {
                        if (this.v == null) {
                            this.f16463g.getClass();
                            this.v = null;
                        }
                        drawable = this.v;
                    } else {
                        drawable = null;
                    }
                    if (drawable == null) {
                        if (this.t == null) {
                            this.f16463g.getClass();
                            this.t = null;
                        }
                        drawable = this.t;
                    }
                    if (drawable == null) {
                        f();
                    }
                    this.f16467k.d();
                    this.y = false;
                } catch (Throwable th) {
                    this.y = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void i(Resource resource, DataSource dataSource) {
        this.f16458b.b();
        Resource resource2 = null;
        try {
            synchronized (this.f16459c) {
                try {
                    this.p = null;
                    if (resource == null) {
                        h(new GlideException("Expected to receive a Resource<R> with an object of " + this.f16462f + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = resource.get();
                    if (obj != null && this.f16462f.isAssignableFrom(obj.getClass())) {
                        j(resource, obj, dataSource);
                        return;
                    }
                    try {
                        this.o = null;
                        StringBuilder sb = new StringBuilder("Expected to receive an object of ");
                        sb.append(this.f16462f);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append("{");
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(resource);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        h(new GlideException(sb.toString()), 5);
                        this.r.getClass();
                        Engine.g(resource);
                    } catch (Throwable th) {
                        resource2 = resource;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (resource2 != null) {
                this.r.getClass();
                Engine.g(resource2);
            }
            throw th3;
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final boolean isRunning() {
        boolean z2;
        synchronized (this.f16459c) {
            try {
                Status status = this.s;
                z2 = status == Status.f16471b || status == Status.f16472c;
            } finally {
            }
        }
        return z2;
    }

    public final void j(Resource resource, Object obj, DataSource dataSource) {
        this.s = Status.f16473d;
        this.o = resource;
        if (this.f16460d.f15677g <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + dataSource + " for " + this.f16461e + " with size [" + this.w + "x" + this.x + "] in " + LogTime.a(this.q) + " ms");
        }
        this.y = true;
        try {
            ArrayList arrayList = this.f16468l;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    ((RequestListener) it.next()).b(obj);
                    throw null;
                }
            }
            this.f16469m.getClass();
            this.f16467k.g(obj, NoTransition.f16500a);
            this.y = false;
        } catch (Throwable th) {
            this.y = false;
            throw th;
        }
    }

    @Override // com.bumptech.glide.request.Request
    public final void pause() {
        synchronized (this.f16459c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
