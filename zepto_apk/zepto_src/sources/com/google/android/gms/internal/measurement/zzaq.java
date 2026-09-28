package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzaq implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public int f36771a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzas f36772b;

    public zzaq(zzas zzasVar) {
        Objects.requireNonNull(zzasVar);
        this.f36772b = zzasVar;
        this.f36771a = 0;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f36771a < this.f36772b.f36775a.length();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        String str = this.f36772b.f36775a;
        int i2 = this.f36771a;
        if (i2 >= str.length()) {
            throw new NoSuchElementException();
        }
        this.f36771a = i2 + 1;
        return new zzas(String.valueOf(i2));
    }
}
