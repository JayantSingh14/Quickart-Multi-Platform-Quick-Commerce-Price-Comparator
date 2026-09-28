package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
abstract class zzgpi implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public Object f33052a;

    /* renamed from: b, reason: collision with root package name */
    public int f33053b;

    public abstract String a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzgqa.f(this.f33053b != 4);
        int i2 = this.f33053b;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        if (i3 == 0) {
            return true;
        }
        if (i3 != 2) {
            this.f33053b = 4;
            this.f33052a = a();
            if (this.f33053b != 3) {
                this.f33053b = 1;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f33053b = 2;
        Object obj = this.f33052a;
        this.f33052a = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
