package com.google.ads.interactivemedia.v3.internal;

import androidx.annotation.VisibleForTesting;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class zzdc {
    private JSONObject zza;
    private final zzdl zzb;

    public zzdc(zzdl zzdlVar) {
        this.zzb = zzdlVar;
    }

    @VisibleForTesting
    public final JSONObject zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.zzb(new zzdm(this));
    }

    public final void zzc(JSONObject jSONObject, HashSet hashSet, long j2) {
        this.zzb.zzb(new zzdn(this, hashSet, jSONObject, j2));
    }

    public final void zzd(JSONObject jSONObject, HashSet hashSet, long j2) {
        this.zzb.zzb(new zzdo(this, hashSet, jSONObject, j2));
    }

    @VisibleForTesting
    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
