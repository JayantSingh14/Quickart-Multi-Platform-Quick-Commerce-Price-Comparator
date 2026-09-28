package com.google.android.gms.internal.pal;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes4.dex */
public final class zzgm {

    /* renamed from: a, reason: collision with root package name */
    public final String f37777a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f37778b;

    public zzgm(String str, Boolean bool) {
        this.f37777a = str;
        this.f37778b = bool;
    }

    public final Object a() {
        zzgp zzgpVar = (zzgp) zzgr.f37780a.get();
        Boolean bool = this.f37778b;
        if (zzgpVar != null) {
            return zzgpVar.zza(this.f37777a, bool.booleanValue());
        }
        AtomicReference atomicReference = zzgr.f37781b;
        if (((zzgq) atomicReference.get()) != null) {
            ((zzgq) atomicReference.get()).zza();
        }
        return bool;
    }
}
