package com.google.android.gms.internal.atv_ads_framework;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzft implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f36207a;

    public zzft(zzfu zzfuVar) {
        this.f36207a = zzfuVar.f36208a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f36207a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f36207a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
