package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzics implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f34735a;

    /* renamed from: b, reason: collision with root package name */
    public zzhzi f34736b;

    public zzics(zzhzl zzhzlVar) {
        if (!(zzhzlVar instanceof zzict)) {
            this.f34735a = null;
            this.f34736b = (zzhzi) zzhzlVar;
            return;
        }
        zzict zzictVar = (zzict) zzhzlVar;
        ArrayDeque arrayDeque = new ArrayDeque(zzictVar.f34742g);
        this.f34735a = arrayDeque;
        arrayDeque.push(zzictVar);
        zzhzl zzhzlVar2 = zzictVar.f34739d;
        while (zzhzlVar2 instanceof zzict) {
            zzict zzictVar2 = (zzict) zzhzlVar2;
            this.f34735a.push(zzictVar2);
            zzhzlVar2 = zzictVar2.f34739d;
        }
        this.f34736b = (zzhzi) zzhzlVar2;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final zzhzi next() {
        zzhzi zzhziVar;
        zzhzi zzhziVar2 = this.f34736b;
        if (zzhziVar2 == null) {
            throw new NoSuchElementException();
        }
        do {
            ArrayDeque arrayDeque = this.f34735a;
            zzhziVar = null;
            if (arrayDeque == null || arrayDeque.isEmpty()) {
                break;
            }
            zzhzl zzhzlVar = ((zzict) arrayDeque.pop()).f34740e;
            while (zzhzlVar instanceof zzict) {
                zzict zzictVar = (zzict) zzhzlVar;
                arrayDeque.push(zzictVar);
                zzhzlVar = zzictVar.f34739d;
            }
            zzhziVar = (zzhzi) zzhzlVar;
        } while (zzhziVar.i() == 0);
        this.f34736b = zzhziVar;
        return zzhziVar2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f34736b != null;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
