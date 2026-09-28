package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzgtf {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f33187a;

    /* renamed from: b, reason: collision with root package name */
    public int f33188b;

    /* renamed from: c, reason: collision with root package name */
    public zzgte f33189c;

    public zzgtf() {
        this(4);
    }

    public final void a(Object obj, Object obj2) {
        int i2 = this.f33188b + 1;
        Object[] objArr = this.f33187a;
        int length = objArr.length;
        int i3 = i2 + i2;
        if (i3 > length) {
            this.f33187a = Arrays.copyOf(objArr, zzgsy.b(length, i3));
        }
        zzgrz.a(obj, obj2);
        Object[] objArr2 = this.f33187a;
        int i4 = this.f33188b;
        int i5 = i4 + i4;
        objArr2[i5] = obj;
        objArr2[i5 + 1] = obj2;
        this.f33188b = i4 + 1;
    }

    public final void b(Set set) {
        if (set != null) {
            int size = set.size() + this.f33188b;
            Object[] objArr = this.f33187a;
            int length = objArr.length;
            int i2 = size + size;
            if (i2 > length) {
                this.f33187a = Arrays.copyOf(objArr, zzgsy.b(length, i2));
            }
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            a(entry.getKey(), entry.getValue());
        }
    }

    public final zzgtg c() {
        return d(true);
    }

    public final zzgtg d(boolean z) {
        zzgte zzgteVar;
        zzgte zzgteVar2;
        if (z && (zzgteVar2 = this.f33189c) != null) {
            throw zzgteVar2.a();
        }
        zzgvd zzgvdVarE = zzgvd.e(this.f33188b, this.f33187a, this);
        if (!z || (zzgteVar = this.f33189c) == null) {
            return zzgvdVarE;
        }
        throw zzgteVar.a();
    }

    public zzgtf(int i2) {
        this.f33187a = new Object[i2 + i2];
        this.f33188b = 0;
    }
}
