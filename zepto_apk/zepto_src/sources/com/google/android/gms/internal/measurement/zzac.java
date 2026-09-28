package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzac implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterator f36752a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Iterator f36753b;

    public zzac(zzae zzaeVar, Iterator it, Iterator it2) {
        this.f36752a = it;
        this.f36753b = it2;
        Objects.requireNonNull(zzaeVar);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f36752a.hasNext()) {
            return true;
        }
        return this.f36753b.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.f36752a;
        if (it.hasNext()) {
            return new zzas(((Integer) it.next()).toString());
        }
        Iterator it2 = this.f36753b;
        if (it2.hasNext()) {
            return new zzas((String) it2.next());
        }
        throw new NoSuchElementException();
    }
}
