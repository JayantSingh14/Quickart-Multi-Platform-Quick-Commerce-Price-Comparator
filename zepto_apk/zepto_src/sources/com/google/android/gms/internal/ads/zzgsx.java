package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes4.dex */
class zzgsx extends zzgsy {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f33171a;

    /* renamed from: b, reason: collision with root package name */
    public int f33172b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f33173c;

    public zzgsx(int i2) {
        zzgrz.b(i2, "initialCapacity");
        this.f33171a = new Object[i2];
        this.f33172b = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgsy
    public /* bridge */ /* synthetic */ zzgsy a(Object obj) {
        throw null;
    }

    public final void c(Object obj) {
        obj.getClass();
        e(1);
        Object[] objArr = this.f33171a;
        int i2 = this.f33172b;
        this.f33172b = i2 + 1;
        objArr[i2] = obj;
    }

    public final void d(Iterable iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            e(collection.size());
            if (collection instanceof zzgsz) {
                this.f33172b = ((zzgsz) collection).k(this.f33172b, this.f33171a);
                return;
            }
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    public final void e(int i2) {
        int length = this.f33171a.length;
        int iB = zzgsy.b(length, this.f33172b + i2);
        if (iB > length || this.f33173c) {
            this.f33171a = Arrays.copyOf(this.f33171a, iB);
            this.f33173c = false;
        }
    }
}
