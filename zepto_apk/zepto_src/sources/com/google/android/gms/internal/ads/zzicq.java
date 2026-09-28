package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzicq extends zzhze {

    /* renamed from: a, reason: collision with root package name */
    public final zzics f34733a;

    /* renamed from: b, reason: collision with root package name */
    public zzhzg f34734b;

    public zzicq(zzict zzictVar) {
        Objects.requireNonNull(zzictVar);
        this.f34733a = new zzics(zzictVar);
        this.f34734b = a();
    }

    public final zzhzg a() {
        zzics zzicsVar = this.f34733a;
        if (zzicsVar.hasNext()) {
            return new zzhzd(zzicsVar.next());
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f34734b != null;
    }

    @Override // com.google.android.gms.internal.ads.zzhzg
    public final byte zza() {
        zzhzg zzhzgVar = this.f34734b;
        if (zzhzgVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = zzhzgVar.zza();
        if (!this.f34734b.hasNext()) {
            this.f34734b = a();
        }
        return bZza;
    }
}
