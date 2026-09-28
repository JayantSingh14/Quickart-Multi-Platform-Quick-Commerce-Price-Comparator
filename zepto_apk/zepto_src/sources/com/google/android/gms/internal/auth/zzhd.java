package com.google.android.gms.internal.auth;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzhd implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f36421a;

    public zzhd(zzhe zzheVar) {
        this.f36421a = zzheVar.f36422a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f36421a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f36421a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
