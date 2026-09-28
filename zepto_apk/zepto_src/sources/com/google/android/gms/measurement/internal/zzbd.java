package com.google.android.gms.measurement.internal;

import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzbd implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f38767a;

    public zzbd(zzbe zzbeVar) {
        Objects.requireNonNull(zzbeVar);
        this.f38767a = zzbeVar.f38768a.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f38767a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f38767a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
