package com.google.android.gms.internal.ads;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes4.dex */
public final class zziea implements Map.Entry, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f34808a;

    public zziea(Map.Entry delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f34808a = delegate;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f34808a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f34808a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
