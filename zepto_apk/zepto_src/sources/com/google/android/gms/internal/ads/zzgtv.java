package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzgtv extends zzgvr {

    /* renamed from: a, reason: collision with root package name */
    public final Object f33213a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f33214b;

    public zzgtv(Object obj) {
        this.f33213a = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f33214b;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f33214b) {
            throw new NoSuchElementException();
        }
        this.f33214b = true;
        return this.f33213a;
    }
}
