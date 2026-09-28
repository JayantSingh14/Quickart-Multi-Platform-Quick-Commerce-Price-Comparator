package androidx.databinding;

import android.view.Choreographer;
import android.view.View;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;
import androidx.databinding.ObservableList;
import androidx.databinding.ObservableMap;
import androidx.databinding.library.R;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.viewbinding.ViewBinding;
import java.lang.ref.ReferenceQueue;

/* loaded from: classes3.dex */
public abstract class ViewDataBinding extends BaseObservable implements ViewBinding {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3376a = 0;

    /* renamed from: androidx.databinding.ViewDataBinding$1, reason: invalid class name */
    public class AnonymousClass1 implements CreateWeakListener {
    }

    /* renamed from: androidx.databinding.ViewDataBinding$2, reason: invalid class name */
    public class AnonymousClass2 implements CreateWeakListener {
    }

    /* renamed from: androidx.databinding.ViewDataBinding$3, reason: invalid class name */
    public class AnonymousClass3 implements CreateWeakListener {
    }

    /* renamed from: androidx.databinding.ViewDataBinding$4, reason: invalid class name */
    public class AnonymousClass4 implements CreateWeakListener {
    }

    /* renamed from: androidx.databinding.ViewDataBinding$5, reason: invalid class name */
    public class AnonymousClass5 extends CallbackRegistry.NotifierCallback<OnRebindCallback, ViewDataBinding, Void> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public final void a(Object obj, ObservableList observableList, int i2, Object obj2) {
            OnRebindCallback onRebindCallback = (OnRebindCallback) obj;
            if (i2 == 1) {
                onRebindCallback.getClass();
            } else if (i2 == 2) {
                onRebindCallback.getClass();
            } else {
                if (i2 != 3) {
                    return;
                }
                onRebindCallback.getClass();
            }
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$6, reason: invalid class name */
    public class AnonymousClass6 implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
            int i2 = ViewDataBinding.f3376a;
            (view != null ? (ViewDataBinding) view.getTag(R.id.dataBinding) : null).getClass();
            throw null;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$7, reason: invalid class name */
    public class AnonymousClass7 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            synchronized (this) {
                throw null;
            }
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$8, reason: invalid class name */
    class AnonymousClass8 implements Choreographer.FrameCallback {
        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j2) {
            int i2 = ViewDataBinding.f3376a;
            throw null;
        }
    }

    public static class IncludedLayouts {
    }

    public static class LiveDataListener implements Observer, ObservableReference<LiveData<?>> {
        @Override // androidx.lifecycle.Observer
        public final void a(Object obj) {
            throw null;
        }
    }

    public static class OnStartListener implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void onStart() {
            throw null;
        }
    }

    public static abstract class PropertyChangedInverseListener extends Observable.OnPropertyChangedCallback implements InverseBindingListener {
        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public final void b(int i2) {
            if (i2 == 0 || i2 == 0) {
                a();
            }
        }
    }

    public static class WeakListListener extends ObservableList.OnListChangedCallback implements ObservableReference<ObservableList> {
        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void a() {
            throw null;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void b() {
            throw null;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void c() {
            throw null;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void d() {
            throw null;
        }

        @Override // androidx.databinding.ObservableList.OnListChangedCallback
        public final void e() {
            throw null;
        }
    }

    public static class WeakMapListener extends ObservableMap.OnMapChangedCallback implements ObservableReference<ObservableMap> {
        @Override // androidx.databinding.ObservableMap.OnMapChangedCallback
        public final void a() {
            throw null;
        }
    }

    public static class WeakPropertyListener extends Observable.OnPropertyChangedCallback implements ObservableReference<Observable> {
        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
        public final void b(int i2) {
            throw null;
        }
    }

    static {
        new AnonymousClass5();
        new ReferenceQueue();
    }
}
