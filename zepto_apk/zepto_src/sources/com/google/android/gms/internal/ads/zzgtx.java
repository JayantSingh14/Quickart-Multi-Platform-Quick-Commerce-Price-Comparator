package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzgtx extends zzgux implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final zzauo f33215a;

    public zzgtx(zzauo zzauoVar) {
        this.f33215a = zzauoVar;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Iterator it = ((Iterable) obj).iterator();
        Iterator it2 = ((Iterable) obj2).iterator();
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return 1;
            }
            int iCompare = this.f33215a.compare(it.next(), it2.next());
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return it2.hasNext() ? -1 : 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgtx) {
            return this.f33215a.equals(((zzgtx) obj).f33215a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f33215a.hashCode() ^ 2075626741;
    }

    public final String toString() {
        return this.f33215a.toString().concat(".lexicographical()");
    }
}
