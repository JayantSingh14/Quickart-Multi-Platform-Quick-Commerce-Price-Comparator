package com.google.ads.interactivemedia.v3.internal;

import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
final class zzaem extends zzabf {
    final zzaeq zza;
    zzabh zzb = zzb();
    final /* synthetic */ zzaes zzc;

    public zzaem(zzaes zzaesVar) {
        this.zzc = zzaesVar;
        this.zza = new zzaeq(zzaesVar, null);
    }

    private final zzabh zzb() {
        zzaeq zzaeqVar = this.zza;
        if (zzaeqVar.hasNext()) {
            return zzaeqVar.next().iterator();
        }
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb != null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzabh
    public final byte zza() {
        zzabh zzabhVar = this.zzb;
        if (zzabhVar == null) {
            throw new NoSuchElementException();
        }
        byte bZza = zzabhVar.zza();
        if (!this.zzb.hasNext()) {
            this.zzb = zzb();
        }
        return bZza;
    }
}
