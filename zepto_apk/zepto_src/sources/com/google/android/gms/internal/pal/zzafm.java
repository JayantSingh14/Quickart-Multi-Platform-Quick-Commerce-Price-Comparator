package com.google.android.gms.internal.pal;

import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzafm implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f37495a;

    public zzafm(zzafn zzafnVar) {
        this.f37495a = zzafnVar.f37496a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f37495a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f37495a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
