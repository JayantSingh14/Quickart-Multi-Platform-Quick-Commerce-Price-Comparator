package kotlin.properties;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: classes3.dex */
final class NotNullVar<T> implements ReadWriteProperty<Object, T> {
    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }

    public final String toString() {
        return e.l(')', "NotNullProperty(", "value not initialized yet");
    }
}
