package com.facebook.common.closeables;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: classes3.dex */
public class AutoCleanupDelegate<T> implements ReadWriteProperty<Object, T> {
    @Override // kotlin.properties.ReadOnlyProperty
    public final Object a(Object obj, KProperty property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return null;
    }
}
