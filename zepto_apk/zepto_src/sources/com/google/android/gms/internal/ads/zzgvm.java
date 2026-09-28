package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class zzgvm extends AbstractSet {
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract zzgvr iterator();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public abstract int d();

    @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        int size;
        if (obj != this) {
            if (obj instanceof Set) {
                Set set = (Set) obj;
                boolean z = set instanceof zzgvm;
                int iD = z ? ((zzgvm) set).d() : set.size();
                if (iD >= 0) {
                    if (z) {
                        ((zzgvm) set).getClass();
                        size = 0;
                    } else {
                        size = set.size();
                    }
                    if (d() >= size) {
                        zzgvr it = iterator();
                        int i2 = 0;
                        while (true) {
                            zzgrb zzgrbVar = (zzgrb) it;
                            if (zzgrbVar.hasNext()) {
                                try {
                                    if (!set.contains(zzgrbVar.next())) {
                                        break;
                                    }
                                    i2++;
                                } catch (ClassCastException | NullPointerException unused) {
                                }
                            } else if (i2 != iD) {
                                if (i2 >= size) {
                                    Iterator it2 = set.iterator();
                                    int i3 = 0;
                                    while (it2.hasNext()) {
                                        it2.next();
                                        i3++;
                                        if (i3 > i2) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException();
    }
}
