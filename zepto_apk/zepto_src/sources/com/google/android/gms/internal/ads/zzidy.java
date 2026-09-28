package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes4.dex */
public final class zzidy implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f34795a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f34796b;

    public zzidy(Iterator it) {
        this.f34796b = it;
        this.f34795a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f34795a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new zziea((Map.Entry) this.f34796b.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
