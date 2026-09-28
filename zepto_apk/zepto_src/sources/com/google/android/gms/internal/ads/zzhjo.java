package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzhjo implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f33894a;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f33895b;

    public /* synthetic */ zzhjo(Iterator it, Iterator it2) {
        this.f33894a = it;
        this.f33895b = it2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f33894a.hasNext() || this.f33895b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        Iterator it = this.f33894a;
        return it.hasNext() ? it.next() : this.f33895b.next();
    }
}
