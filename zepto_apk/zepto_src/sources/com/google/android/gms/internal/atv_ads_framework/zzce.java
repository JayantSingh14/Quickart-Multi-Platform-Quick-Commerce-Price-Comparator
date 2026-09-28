package com.google.android.gms.internal.atv_ads_framework;

import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
final class zzce extends zzcg {

    /* renamed from: a, reason: collision with root package name */
    public int f36090a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f36091b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzcn f36092c;

    public zzce(zzcn zzcnVar) {
        this.f36092c = zzcnVar;
        this.f36091b = zzcnVar.f();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f36090a < this.f36091b;
    }

    public final byte zza() {
        int i2 = this.f36090a;
        if (i2 >= this.f36091b) {
            throw new NoSuchElementException();
        }
        this.f36090a = i2 + 1;
        return this.f36092c.d(i2);
    }
}
