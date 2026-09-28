package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;

/* loaded from: classes3.dex */
public class PropertyChangeRegistry extends CallbackRegistry<Observable.OnPropertyChangedCallback, Observable, Void> {

    /* renamed from: f, reason: collision with root package name */
    public static final CallbackRegistry.NotifierCallback f3375f = new AnonymousClass1();

    /* renamed from: androidx.databinding.PropertyChangeRegistry$1, reason: invalid class name */
    public class AnonymousClass1 extends CallbackRegistry.NotifierCallback<Observable.OnPropertyChangedCallback, Observable, Void> {
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public final void a(Object obj, ObservableList observableList, int i2, Object obj2) {
            ((Observable.OnPropertyChangedCallback) obj).b(i2);
        }
    }

    public PropertyChangeRegistry() {
        super(f3375f);
    }
}
