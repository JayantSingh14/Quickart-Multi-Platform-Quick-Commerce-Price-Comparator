package com.google.android.gms.internal.ads;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes4.dex */
public final class zzidx implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f34794a;

    public zzidx(Iterator delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f34794a = delegate;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f34794a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f34794a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
