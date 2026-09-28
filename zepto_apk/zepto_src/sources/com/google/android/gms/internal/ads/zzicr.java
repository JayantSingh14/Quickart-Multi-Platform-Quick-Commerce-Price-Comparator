package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzicr {
    public static final void a(zzhzl zzhzlVar, ArrayDeque arrayDeque) {
        if (!zzhzlVar.n()) {
            if (!(zzhzlVar instanceof zzict)) {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found ".concat(String.valueOf(zzhzlVar.getClass())));
            }
            zzict zzictVar = (zzict) zzhzlVar;
            a(zzictVar.f34739d, arrayDeque);
            a(zzictVar.f34740e, arrayDeque);
            return;
        }
        int iBinarySearch = Arrays.binarySearch(zzict.f34737h, zzhzlVar.i());
        if (iBinarySearch < 0) {
            iBinarySearch = (-(iBinarySearch + 1)) - 1;
        }
        int iA = zzict.A(iBinarySearch + 1);
        if (arrayDeque.isEmpty() || ((zzhzl) arrayDeque.peek()).i() >= iA) {
            arrayDeque.push(zzhzlVar);
            return;
        }
        int iA2 = zzict.A(iBinarySearch);
        zzhzl zzictVar2 = (zzhzl) arrayDeque.pop();
        while (!arrayDeque.isEmpty() && ((zzhzl) arrayDeque.peek()).i() < iA2) {
            zzictVar2 = new zzict((zzhzl) arrayDeque.pop(), zzictVar2);
        }
        zzict zzictVar3 = new zzict(zzictVar2, zzhzlVar);
        while (!arrayDeque.isEmpty()) {
            int iBinarySearch2 = Arrays.binarySearch(zzict.f34737h, zzictVar3.f34738c);
            if (iBinarySearch2 < 0) {
                iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
            }
            if (((zzhzl) arrayDeque.peek()).i() >= zzict.A(iBinarySearch2 + 1)) {
                break;
            } else {
                zzictVar3 = new zzict((zzhzl) arrayDeque.pop(), zzictVar3);
            }
        }
        arrayDeque.push(zzictVar3);
    }
}
