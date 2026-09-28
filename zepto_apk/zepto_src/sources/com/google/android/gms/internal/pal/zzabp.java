package com.google.android.gms.internal.pal;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzabp extends zzabr {

    /* renamed from: a, reason: collision with root package name */
    public int f37358a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f37359b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzaby f37360c;

    public zzabp(zzaby zzabyVar) {
        this.f37360c = zzabyVar;
        this.f37359b = zzabyVar.f();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f37358a < this.f37359b;
    }

    public final byte zza() {
        int i2 = this.f37358a;
        if (i2 >= this.f37359b) {
            throw new NoSuchElementException();
        }
        this.f37358a = i2 + 1;
        return this.f37360c.d(i2);
    }
}
