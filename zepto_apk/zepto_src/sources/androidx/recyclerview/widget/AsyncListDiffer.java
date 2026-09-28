package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class AsyncListDiffer<T> {

    /* renamed from: h, reason: collision with root package name */
    public static final Executor f11354h = new MainThreadExecutor();

    /* renamed from: a, reason: collision with root package name */
    public final AdapterListUpdateCallback f11355a;

    /* renamed from: b, reason: collision with root package name */
    public final AsyncDifferConfig f11356b;

    /* renamed from: e, reason: collision with root package name */
    public List f11359e;

    /* renamed from: g, reason: collision with root package name */
    public int f11361g;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList f11358d = new CopyOnWriteArrayList();

    /* renamed from: f, reason: collision with root package name */
    public List f11360f = Collections.EMPTY_LIST;

    /* renamed from: c, reason: collision with root package name */
    public final Executor f11357c = f11354h;

    public interface ListListener<T> {
        void a();
    }

    public static class MainThreadExecutor implements Executor {

        /* renamed from: a, reason: collision with root package name */
        public final Handler f11369a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f11369a.post(runnable);
        }
    }

    public AsyncListDiffer(AdapterListUpdateCallback adapterListUpdateCallback, AsyncDifferConfig asyncDifferConfig) {
        this.f11355a = adapterListUpdateCallback;
        this.f11356b = asyncDifferConfig;
    }

    public final void a(List list) {
        Iterator it = this.f11358d.iterator();
        while (it.hasNext()) {
            ((ListListener) it.next()).a();
        }
    }
}
