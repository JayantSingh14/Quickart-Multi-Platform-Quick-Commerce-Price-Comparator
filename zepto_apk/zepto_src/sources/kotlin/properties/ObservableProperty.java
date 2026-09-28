package kotlin.properties;

import com.facebook.react.uimanager.style.BorderStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: classes3.dex */
public abstract class ObservableProperty<V> implements ReadWriteProperty<Object, V> {

    /* renamed from: a, reason: collision with root package name */
    public BorderStyle f53814a;

    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.f53814a;
    }

    public void b(KProperty property, BorderStyle borderStyle, BorderStyle borderStyle2) {
        Intrinsics.checkNotNullParameter(property, "property");
    }

    public boolean c(KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return true;
    }

    public final String toString() {
        return "ObservableProperty(value=" + this.f53814a + ')';
    }
}
