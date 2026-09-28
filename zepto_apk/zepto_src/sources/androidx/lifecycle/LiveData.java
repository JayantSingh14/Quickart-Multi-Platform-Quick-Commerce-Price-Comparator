package androidx.lifecycle;

import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class LiveData<T> {

    /* renamed from: k, reason: collision with root package name */
    public static final Object f4830k = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final Object f4831a;

    /* renamed from: b, reason: collision with root package name */
    public final SafeIterableMap f4832b;

    /* renamed from: c, reason: collision with root package name */
    public int f4833c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4834d;

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f4835e;

    /* renamed from: f, reason: collision with root package name */
    public volatile Object f4836f;

    /* renamed from: g, reason: collision with root package name */
    public int f4837g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4838h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4839i;

    /* renamed from: j, reason: collision with root package name */
    public final Runnable f4840j;

    /* loaded from: classes3.dex */
    public class AlwaysActiveObserver extends LiveData<T>.ObserverWrapper {
        public AlwaysActiveObserver(LiveData liveData, Observer observer) {
            super(observer);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final boolean e() {
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class LifecycleBoundObserver extends LiveData<T>.ObserverWrapper implements LifecycleEventObserver {

        /* renamed from: e, reason: collision with root package name */
        public final LifecycleOwner f4842e;

        public LifecycleBoundObserver(LifecycleOwner lifecycleOwner, Observer observer) {
            super(observer);
            this.f4842e = lifecycleOwner;
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            LifecycleOwner lifecycleOwner2 = this.f4842e;
            Lifecycle.State stateB = lifecycleOwner2.getLifecycle().b();
            if (stateB == Lifecycle.State.f4805a) {
                LiveData.this.j(this.f4844a);
                return;
            }
            Lifecycle.State state = null;
            while (state != stateB) {
                b(e());
                state = stateB;
                stateB = lifecycleOwner2.getLifecycle().b();
            }
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final void c() {
            this.f4842e.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final boolean d(LifecycleOwner lifecycleOwner) {
            return this.f4842e == lifecycleOwner;
        }

        @Override // androidx.lifecycle.LiveData.ObserverWrapper
        public final boolean e() {
            return this.f4842e.getLifecycle().b().a(Lifecycle.State.f4808d);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class ObserverWrapper {

        /* renamed from: a, reason: collision with root package name */
        public final Observer f4844a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f4845b;

        /* renamed from: c, reason: collision with root package name */
        public int f4846c = -1;

        public ObserverWrapper(Observer observer) {
            this.f4844a = observer;
        }

        public final void b(boolean z) {
            if (z == this.f4845b) {
                return;
            }
            this.f4845b = z;
            int i2 = z ? 1 : -1;
            LiveData liveData = LiveData.this;
            int i3 = liveData.f4833c;
            liveData.f4833c = i2 + i3;
            if (!liveData.f4834d) {
                liveData.f4834d = true;
                while (true) {
                    try {
                        int i4 = liveData.f4833c;
                        if (i3 == i4) {
                            break;
                        }
                        boolean z2 = i3 == 0 && i4 > 0;
                        boolean z3 = i3 > 0 && i4 == 0;
                        if (z2) {
                            liveData.g();
                        } else if (z3) {
                            liveData.h();
                        }
                        i3 = i4;
                    } catch (Throwable th) {
                        liveData.f4834d = false;
                        throw th;
                    }
                }
                liveData.f4834d = false;
            }
            if (this.f4845b) {
                liveData.c(this);
            }
        }

        public void c() {
        }

        public boolean d(LifecycleOwner lifecycleOwner) {
            return false;
        }

        public abstract boolean e();
    }

    public LiveData(Object obj) {
        this.f4831a = new Object();
        this.f4832b = new SafeIterableMap();
        this.f4833c = 0;
        this.f4836f = f4830k;
        this.f4840j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            @Override // java.lang.Runnable
            public final void run() {
                Object obj2;
                synchronized (LiveData.this.f4831a) {
                    obj2 = LiveData.this.f4836f;
                    LiveData.this.f4836f = LiveData.f4830k;
                }
                LiveData.this.k(obj2);
            }
        };
        this.f4835e = obj;
        this.f4837g = 0;
    }

    public static void a(String str) {
        ArchTaskExecutor.a().f1276a.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(android.support.v4.media.b.D("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(ObserverWrapper observerWrapper) {
        if (observerWrapper.f4845b) {
            if (!observerWrapper.e()) {
                observerWrapper.b(false);
                return;
            }
            int i2 = observerWrapper.f4846c;
            int i3 = this.f4837g;
            if (i2 >= i3) {
                return;
            }
            observerWrapper.f4846c = i3;
            observerWrapper.f4844a.a(this.f4835e);
        }
    }

    public final void c(ObserverWrapper observerWrapper) {
        if (this.f4838h) {
            this.f4839i = true;
            return;
        }
        this.f4838h = true;
        do {
            this.f4839i = false;
            if (observerWrapper != null) {
                b(observerWrapper);
                observerWrapper = null;
            } else {
                SafeIterableMap safeIterableMap = this.f4832b;
                safeIterableMap.getClass();
                SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = new SafeIterableMap.IteratorWithAdditions();
                safeIterableMap.f1285c.put(iteratorWithAdditions, Boolean.FALSE);
                while (iteratorWithAdditions.hasNext()) {
                    b((ObserverWrapper) ((Map.Entry) iteratorWithAdditions.next()).getValue());
                    if (this.f4839i) {
                        break;
                    }
                }
            }
        } while (this.f4839i);
        this.f4838h = false;
    }

    public final Object d() {
        Object obj = this.f4835e;
        if (obj != f4830k) {
            return obj;
        }
        return null;
    }

    public final void e(LifecycleOwner lifecycleOwner, Observer observer) {
        a("observe");
        if (lifecycleOwner.getLifecycle().b() == Lifecycle.State.f4805a) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(lifecycleOwner, observer);
        ObserverWrapper observerWrapper = (ObserverWrapper) this.f4832b.d(observer, lifecycleBoundObserver);
        if (observerWrapper != null && !observerWrapper.d(lifecycleOwner)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (observerWrapper != null) {
            return;
        }
        lifecycleOwner.getLifecycle().a(lifecycleBoundObserver);
    }

    public final void f(Observer observer) {
        a("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(this, observer);
        ObserverWrapper observerWrapper = (ObserverWrapper) this.f4832b.d(observer, alwaysActiveObserver);
        if (observerWrapper instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (observerWrapper != null) {
            return;
        }
        alwaysActiveObserver.b(true);
    }

    public void g() {
    }

    public void h() {
    }

    public void i(Object obj) {
        boolean z;
        synchronized (this.f4831a) {
            z = this.f4836f == f4830k;
            this.f4836f = obj;
        }
        if (z) {
            ArchTaskExecutor.a().b(this.f4840j);
        }
    }

    public void j(Observer observer) {
        a("removeObserver");
        ObserverWrapper observerWrapper = (ObserverWrapper) this.f4832b.f(observer);
        if (observerWrapper == null) {
            return;
        }
        observerWrapper.c();
        observerWrapper.b(false);
    }

    public void k(Object obj) {
        a("setValue");
        this.f4837g++;
        this.f4835e = obj;
        c(null);
    }

    public LiveData() {
        this.f4831a = new Object();
        this.f4832b = new SafeIterableMap();
        this.f4833c = 0;
        Object obj = f4830k;
        this.f4836f = obj;
        this.f4840j = new Runnable() { // from class: androidx.lifecycle.LiveData.1
            @Override // java.lang.Runnable
            public final void run() {
                Object obj2;
                synchronized (LiveData.this.f4831a) {
                    obj2 = LiveData.this.f4836f;
                    LiveData.this.f4836f = LiveData.f4830k;
                }
                LiveData.this.k(obj2);
            }
        };
        this.f4835e = obj;
        this.f4837g = -1;
    }
}
