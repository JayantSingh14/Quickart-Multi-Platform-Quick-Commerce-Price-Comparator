package androidx.lifecycle;

import android.os.Looper;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata
/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f4816b;

    /* renamed from: c, reason: collision with root package name */
    public FastSafeIterableMap f4817c;

    /* renamed from: d, reason: collision with root package name */
    public Lifecycle.State f4818d;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f4819e;

    /* renamed from: f, reason: collision with root package name */
    public int f4820f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4821g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4822h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f4823i;

    /* renamed from: j, reason: collision with root package name */
    public final MutableStateFlow f4824j;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class ObserverWithState {

        /* renamed from: a, reason: collision with root package name */
        public Lifecycle.State f4825a;

        /* renamed from: b, reason: collision with root package name */
        public LifecycleEventObserver f4826b;

        public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Lifecycle.State stateA = event.a();
            Lifecycle.State state1 = this.f4825a;
            Intrinsics.checkNotNullParameter(state1, "state1");
            if (stateA.compareTo(state1) < 0) {
                state1 = stateA;
            }
            this.f4825a = state1;
            this.f4826b.a(lifecycleOwner, event);
            this.f4825a = stateA;
        }
    }

    public LifecycleRegistry(LifecycleOwner provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f4816b = true;
        this.f4817c = new FastSafeIterableMap();
        Lifecycle.State state = Lifecycle.State.f4806b;
        this.f4818d = state;
        this.f4823i = new ArrayList();
        this.f4819e = new WeakReference(provider);
        this.f4824j = StateFlowKt.a(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void a(LifecycleObserver object) {
        LifecycleEventObserver reflectiveGenericLifecycleObserver;
        LifecycleOwner lifecycleOwner;
        ArrayList arrayList = this.f4823i;
        Intrinsics.checkNotNullParameter(object, "observer");
        e("addObserver");
        Lifecycle.State state = this.f4818d;
        Lifecycle.State initialState = Lifecycle.State.f4805a;
        if (state != initialState) {
            initialState = Lifecycle.State.f4806b;
        }
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        ObserverWithState observerWithState = new ObserverWithState();
        Intrinsics.c(object);
        HashMap map = Lifecycling.f4828a;
        Intrinsics.checkNotNullParameter(object, "object");
        boolean z = object instanceof LifecycleEventObserver;
        boolean z2 = object instanceof DefaultLifecycleObserver;
        if (z && z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, (LifecycleEventObserver) object);
        } else if (z2) {
            reflectiveGenericLifecycleObserver = new DefaultLifecycleObserverAdapter((DefaultLifecycleObserver) object, null);
        } else if (z) {
            reflectiveGenericLifecycleObserver = (LifecycleEventObserver) object;
        } else {
            Class<?> cls = object.getClass();
            if (Lifecycling.c(cls) == 2) {
                Object obj = Lifecycling.f4829b.get(cls);
                Intrinsics.c(obj);
                List list = (List) obj;
                if (list.size() == 1) {
                    reflectiveGenericLifecycleObserver = new SingleGeneratedAdapterObserver(Lifecycling.a((Constructor) list.get(0), object));
                } else {
                    int size = list.size();
                    GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        generatedAdapterArr[i2] = Lifecycling.a((Constructor) list.get(i2), object);
                    }
                    reflectiveGenericLifecycleObserver = new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
                }
            } else {
                reflectiveGenericLifecycleObserver = new ReflectiveGenericLifecycleObserver(object);
            }
        }
        observerWithState.f4826b = reflectiveGenericLifecycleObserver;
        observerWithState.f4825a = initialState;
        if (((ObserverWithState) this.f4817c.d(object, observerWithState)) == null && (lifecycleOwner = (LifecycleOwner) this.f4819e.get()) != null) {
            boolean z3 = this.f4820f != 0 || this.f4821g;
            Lifecycle.State stateD = d(object);
            this.f4820f++;
            while (observerWithState.f4825a.compareTo(stateD) < 0 && this.f4817c.f1282e.containsKey(object)) {
                arrayList.add(observerWithState.f4825a);
                Lifecycle.Event.Companion companion = Lifecycle.Event.Companion;
                Lifecycle.State state2 = observerWithState.f4825a;
                companion.getClass();
                Intrinsics.checkNotNullParameter(state2, "state");
                int iOrdinal = state2.ordinal();
                Lifecycle.Event event = iOrdinal != 1 ? iOrdinal != 2 ? iOrdinal != 3 ? null : Lifecycle.Event.ON_RESUME : Lifecycle.Event.ON_START : Lifecycle.Event.ON_CREATE;
                if (event == null) {
                    throw new IllegalStateException("no event up from " + observerWithState.f4825a);
                }
                observerWithState.a(lifecycleOwner, event);
                arrayList.remove(arrayList.size() - 1);
                stateD = d(object);
            }
            if (!z3) {
                i();
            }
            this.f4820f--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public final Lifecycle.State b() {
        return this.f4818d;
    }

    @Override // androidx.lifecycle.Lifecycle
    public final void c(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        e("removeObserver");
        this.f4817c.f(observer);
    }

    public final Lifecycle.State d(LifecycleObserver lifecycleObserver) {
        ObserverWithState observerWithState;
        Map.Entry entryG = this.f4817c.g(lifecycleObserver);
        Lifecycle.State state1 = (entryG == null || (observerWithState = (ObserverWithState) entryG.getValue()) == null) ? null : observerWithState.f4825a;
        ArrayList arrayList = this.f4823i;
        Lifecycle.State state = arrayList.isEmpty() ? null : (Lifecycle.State) android.support.v4.media.b.c(1, arrayList);
        Lifecycle.State state12 = this.f4818d;
        Intrinsics.checkNotNullParameter(state12, "state1");
        if (state1 == null || state1.compareTo(state12) >= 0) {
            state1 = state12;
        }
        Intrinsics.checkNotNullParameter(state1, "state1");
        return (state == null || state.compareTo(state1) >= 0) ? state1 : state;
    }

    public final void e(String str) {
        if (this.f4816b) {
            ArchTaskExecutor.a().f1276a.getClass();
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                throw new IllegalStateException(android.support.v4.media.b.D("Method ", str, " must be called on the main thread").toString());
            }
        }
    }

    public final void f(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        e("handleLifecycleEvent");
        g(event.a());
    }

    public final void g(Lifecycle.State state) {
        Lifecycle.State state2 = this.f4818d;
        if (state2 == state) {
            return;
        }
        Lifecycle.State state3 = Lifecycle.State.f4806b;
        Lifecycle.State state4 = Lifecycle.State.f4805a;
        if (state2 == state3 && state == state4) {
            throw new IllegalStateException(("State must be at least CREATED to move to " + state + ", but was " + this.f4818d + " in component " + this.f4819e.get()).toString());
        }
        this.f4818d = state;
        if (this.f4821g || this.f4820f != 0) {
            this.f4822h = true;
            return;
        }
        this.f4821g = true;
        i();
        this.f4821g = false;
        if (this.f4818d == state4) {
            this.f4817c = new FastSafeIterableMap();
        }
    }

    public final void h() {
        Lifecycle.State state = Lifecycle.State.f4807c;
        Intrinsics.checkNotNullParameter(state, "state");
        e("setCurrentState");
        g(state);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0034, code lost:
    
        r8.f4822h = false;
        r8.f4824j.setValue(r8.f4818d);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.LifecycleRegistry.i():void");
    }
}
