package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzhzd extends zzhze {

    /* renamed from: a, reason: collision with root package name */
    public int f34545a;

    /* renamed from: b, reason: collision with root package name */
    public final int f34546b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzhzl f34547c;

    public zzhzd(zzhzl zzhzlVar) {
        Objects.requireNonNull(zzhzlVar);
        this.f34547c = zzhzlVar;
        this.f34545a = 0;
        this.f34546b = zzhzlVar.i();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f34545a < this.f34546b;
    }

    @Override // com.google.android.gms.internal.ads.zzhzg
    public final byte zza() {
        int i2 = this.f34545a;
        if (i2 >= this.f34546b) {
            throw new NoSuchElementException();
        }
        this.f34545a = i2 + 1;
        return this.f34547c.g(i2);
    }
}
