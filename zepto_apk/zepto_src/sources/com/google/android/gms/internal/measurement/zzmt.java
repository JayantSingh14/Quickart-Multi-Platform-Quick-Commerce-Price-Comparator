package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzmt implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f37126a;

    public zzmt(Iterator it) {
        this.f37126a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f37126a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f37126a.next();
        return entry.getValue() instanceof zzmu ? new zzms(entry) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f37126a.remove();
    }
}
