package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzar implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f36773a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzas f36774b;

    public zzar(zzas zzasVar) {
        this.f36774b = zzasVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f36773a < this.f36774b.f36775a.length();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        zzas zzasVar = this.f36774b;
        String str = zzasVar.f36775a;
        int i2 = this.f36773a;
        if (i2 >= str.length()) {
            throw new NoSuchElementException();
        }
        this.f36773a = i2 + 1;
        return new zzas(String.valueOf(zzasVar.f36775a.charAt(i2)));
    }
}
