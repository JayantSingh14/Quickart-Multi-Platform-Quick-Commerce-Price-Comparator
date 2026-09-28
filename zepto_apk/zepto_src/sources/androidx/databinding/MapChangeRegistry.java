package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableMap;

/* loaded from: classes3.dex */
public class MapChangeRegistry extends CallbackRegistry<ObservableMap.OnMapChangedCallback, ObservableMap, Object> {

    /* renamed from: f, reason: collision with root package name */
    public static final CallbackRegistry.NotifierCallback f3361f = new AnonymousClass1();

    /* renamed from: androidx.databinding.MapChangeRegistry$1, reason: invalid class name */
    public class AnonymousClass1 extends CallbackRegistry.NotifierCallback<ObservableMap.OnMapChangedCallback, ObservableMap, Object> {
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public final void a(Object obj, ObservableList observableList, int i2, Object obj2) {
            ((ObservableMap.OnMapChangedCallback) obj).a();
            throw null;
        }
    }

    public MapChangeRegistry() {
        super(f3361f);
    }
}
