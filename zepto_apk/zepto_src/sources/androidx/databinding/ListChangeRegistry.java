package androidx.databinding;

import androidx.core.util.Pools;
import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableList;

/* loaded from: classes3.dex */
public class ListChangeRegistry extends CallbackRegistry<ObservableList.OnListChangedCallback, ObservableList, ListChanges> {

    /* renamed from: f, reason: collision with root package name */
    public static final Pools.SynchronizedPool f3359f = new Pools.SynchronizedPool(10);

    /* renamed from: g, reason: collision with root package name */
    public static final CallbackRegistry.NotifierCallback f3360g = new AnonymousClass1();

    /* renamed from: androidx.databinding.ListChangeRegistry$1, reason: invalid class name */
    public class AnonymousClass1 extends CallbackRegistry.NotifierCallback<ObservableList.OnListChangedCallback, ObservableList, ListChanges> {
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public final void a(Object obj, ObservableList observableList, int i2, Object obj2) {
            ObservableList.OnListChangedCallback onListChangedCallback = (ObservableList.OnListChangedCallback) obj;
            if (i2 == 1) {
                onListChangedCallback.b();
                throw null;
            }
            if (i2 == 2) {
                onListChangedCallback.c();
                throw null;
            }
            if (i2 == 3) {
                onListChangedCallback.d();
                throw null;
            }
            if (i2 != 4) {
                onListChangedCallback.a();
                throw null;
            }
            onListChangedCallback.e();
            throw null;
        }
    }

    public static class ListChanges {
    }

    public ListChangeRegistry() {
        super(f3360g);
    }

    public static ListChanges e(int i2, int i3) {
        ListChanges listChanges = (ListChanges) f3359f.b();
        return listChanges == null ? new ListChanges() : listChanges;
    }

    public final synchronized void f(ObservableArrayList observableArrayList, int i2, ListChanges listChanges) {
        super.a(i2, observableArrayList, listChanges);
        f3359f.a(listChanges);
    }
}
