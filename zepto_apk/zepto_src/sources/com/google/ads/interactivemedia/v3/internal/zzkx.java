package com.google.ads.interactivemedia.v3.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class zzkx {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    public /* synthetic */ zzkx(int i2, String str, Object obj, Object obj2, zzkw zzkwVar) {
        this.zza = i2;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        zzkq.zza().zzb(this);
    }

    public static zzkx zze(int i2, String str, float f2, float f3) {
        return new zzku(1, str, Float.valueOf(f2), Float.valueOf(f3));
    }

    public static zzkx zzf(int i2, String str, int i3, int i4) {
        return new zzks(1, str, Integer.valueOf(i3), Integer.valueOf(i4));
    }

    public static zzkx zzg(int i2, String str, long j2, long j3) {
        return new zzkt(1, str, Long.valueOf(j2), Long.valueOf(j3));
    }

    public static zzkx zzh(int i2, String str, Boolean bool, Boolean bool2) {
        return new zzkr(i2, str, bool, bool2);
    }

    public static zzkx zzi(int i2, String str, String str2, String str3) {
        return new zzkv(1, str, str2, str3);
    }

    public static zzkx zzj(int i2, String str) {
        zzkx zzkxVarZzi = zzi(1, "gads:sdk_core_constants:experiment_id", null, null);
        zzkq.zza().zza(zzkxVarZzi);
        return zzkxVarZzi;
    }

    public abstract Object zza(JSONObject jSONObject);

    public abstract Object zzb(Bundle bundle);

    public abstract Object zzc(SharedPreferences sharedPreferences);

    public final int zzd() {
        return this.zza;
    }

    public final Object zzk() {
        return zzkq.zzc().zzd() ? this.zzd : this.zzc;
    }

    public final String zzl() {
        return this.zzb;
    }
}
