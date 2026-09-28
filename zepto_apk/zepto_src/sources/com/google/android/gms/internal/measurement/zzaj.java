package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzaj implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f36764a;

    public zzaj(Iterator it) {
        this.f36764a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f36764a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return new zzas((String) this.f36764a.next());
    }
}
