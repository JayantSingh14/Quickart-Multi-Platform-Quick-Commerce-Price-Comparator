package androidx.databinding;

import java.util.Map;

/* loaded from: classes3.dex */
public interface ObservableMap<K, V> extends Map<K, V> {

    public static abstract class OnMapChangedCallback<T extends ObservableMap<K, V>, K, V> {
        public abstract void a();
    }
}
