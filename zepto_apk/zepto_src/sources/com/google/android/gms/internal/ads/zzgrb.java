package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public abstract class zzgrb extends zzgvr {

    /* renamed from: a, reason: collision with root package name */
    public Object f33096a;

    /* renamed from: b, reason: collision with root package name */
    public int f33097b = 2;

    public abstract Object a();

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zzgqa.f(this.f33097b != 4);
        int i2 = this.f33097b;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        if (i3 == 0) {
            return true;
        }
        if (i3 != 2) {
            this.f33097b = 4;
            this.f33096a = a();
            if (this.f33097b != 3) {
                this.f33097b = 1;
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
        this.f33097b = 2;
        Object obj = this.f33096a;
        this.f33096a = null;
        return obj;
    }
}
