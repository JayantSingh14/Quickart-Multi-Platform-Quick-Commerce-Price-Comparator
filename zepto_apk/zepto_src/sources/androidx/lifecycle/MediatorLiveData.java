package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class MediatorLiveData<T> extends MutableLiveData<T> {

    /* renamed from: l, reason: collision with root package name */
    public final SafeIterableMap f4851l;

    public static class Source<V> implements Observer<V> {

        /* renamed from: a, reason: collision with root package name */
        public final LiveData f4852a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f4853b;

        /* renamed from: c, reason: collision with root package name */
        public int f4854c = -1;

        public Source(LiveData liveData, Observer observer) {
            this.f4852a = liveData;
            this.f4853b = observer;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.Observer, java.lang.Object] */
        @Override // androidx.lifecycle.Observer
        public final void a(Object obj) {
            int i2 = this.f4854c;
            int i3 = this.f4852a.f4837g;
            if (i2 != i3) {
                this.f4854c = i3;
                this.f4853b.a(obj);
            }
        }
    }

    public MediatorLiveData(Object obj) {
        super(obj);
        this.f4851l = new SafeIterableMap();
    }

    @Override // androidx.lifecycle.LiveData
    public void g() {
        Iterator it = this.f4851l.iterator();
        while (it.hasNext()) {
            Source source = (Source) ((Map.Entry) it.next()).getValue();
            source.f4852a.f(source);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void h() {
        Iterator it = this.f4851l.iterator();
        while (it.hasNext()) {
            Source source = (Source) ((Map.Entry) it.next()).getValue();
            source.f4852a.j(source);
        }
    }

    public final void l(LiveData liveData, Observer observer) {
        if (liveData == null) {
            throw new NullPointerException("source cannot be null");
        }
        Source source = new Source(liveData, observer);
        Source source2 = (Source) this.f4851l.d(liveData, source);
        if (source2 != null && source2.f4853b != observer) {
            throw new IllegalArgumentException("This source was already added with the different observer");
        }
        if (source2 == null && this.f4833c > 0) {
            liveData.f(source);
        }
    }

    public MediatorLiveData() {
        this.f4851l = new SafeIterableMap();
    }
}
