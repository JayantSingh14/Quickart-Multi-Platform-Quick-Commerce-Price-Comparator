package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzibk implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f34685a;

    public zzibk(Iterator it) {
        this.f34685a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f34685a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.f34685a.next();
        return entry.getValue() instanceof zzibl ? new zzibj(entry) : entry;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f34685a.remove();
    }
}
