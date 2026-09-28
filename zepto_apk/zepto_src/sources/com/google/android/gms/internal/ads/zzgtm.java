package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class zzgtm extends zzgsx {

    /* renamed from: d, reason: collision with root package name */
    public Object[] f33201d;

    /* renamed from: e, reason: collision with root package name */
    public int f33202e;

    public zzgtm() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzgsx, com.google.android.gms.internal.ads.zzgsy
    public final /* bridge */ /* synthetic */ zzgsy a(Object obj) {
        f(obj);
        return this;
    }

    public final void f(Object obj) {
        obj.getClass();
        if (this.f33201d != null) {
            int iO = zzgtn.o(this.f33172b);
            Object[] objArr = this.f33201d;
            if (iO <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iA = zzgsw.a(iHashCode);
                while (true) {
                    int i2 = iA & length;
                    Object[] objArr2 = this.f33201d;
                    Object obj2 = objArr2[i2];
                    if (obj2 == null) {
                        objArr2[i2] = obj;
                        this.f33202e += iHashCode;
                        c(obj);
                        return;
                    } else if (obj2.equals(obj)) {
                        return;
                    } else {
                        iA = i2 + 1;
                    }
                }
            }
        }
        this.f33201d = null;
        c(obj);
    }

    public final void g(Iterable iterable) {
        iterable.getClass();
        if (this.f33201d == null) {
            d(iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            f(it.next());
        }
    }

    public final zzgtn h() {
        zzgtn zzgtnVarT;
        int i2 = this.f33172b;
        if (i2 == 0) {
            return zzgve.f33249j;
        }
        if (i2 == 1) {
            Object obj = this.f33171a[0];
            Objects.requireNonNull(obj);
            return new zzgvo(obj);
        }
        if (this.f33201d == null || zzgtn.o(i2) != this.f33201d.length) {
            zzgtnVarT = zzgtn.t(this.f33172b, this.f33171a);
            this.f33172b = zzgtnVarT.size();
        } else {
            int i3 = this.f33172b;
            Object[] objArrCopyOf = this.f33171a;
            int length = objArrCopyOf.length;
            if (i3 < (length >> 1) + (length >> 2)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i3);
            }
            zzgtnVarT = new zzgve(objArrCopyOf, this.f33202e, this.f33201d, r6.length - 1, this.f33172b);
        }
        this.f33173c = true;
        this.f33201d = null;
        return zzgtnVarT;
    }
}
