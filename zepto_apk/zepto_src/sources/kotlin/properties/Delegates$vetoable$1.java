package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: classes3.dex */
public final class Delegates$vetoable$1 extends ObservableProperty<Object> {
    @Override // kotlin.properties.ObservableProperty
    public final boolean c(KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        throw null;
    }
}
