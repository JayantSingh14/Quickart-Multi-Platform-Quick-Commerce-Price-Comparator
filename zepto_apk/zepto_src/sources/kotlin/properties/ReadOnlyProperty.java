package kotlin.properties;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: classes.dex */
public interface ReadOnlyProperty<T, V> {
    Object a(Object obj, KProperty kProperty);
}
