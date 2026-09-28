package androidx.datastore;

import android.content.Context;
import androidx.datastore.core.DataStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: classes3.dex */
public final class DataStoreSingletonDelegate<T> implements ReadOnlyProperty<Context, DataStore<T>> {
    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        Context thisRef = (Context) obj;
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter(property, "property");
        throw null;
    }
}
