package com.google.ads.interactivemedia.v3.internal;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
final class zzib implements zzob {
    private final zzmq zza;
    private final zznf zzb;
    private final zzio zzc;
    private final zzia zzd;
    private final zzhk zze;
    private final zziq zzf;
    private final zzii zzg;
    private final zzhz zzh;

    public zzib(@NonNull zzmq zzmqVar, @NonNull zznf zznfVar, @NonNull zzio zzioVar, @NonNull zzia zziaVar, @Nullable zzhk zzhkVar, @Nullable zziq zziqVar, @Nullable zzii zziiVar, @Nullable zzhz zzhzVar) {
        this.zza = zzmqVar;
        this.zzb = zznfVar;
        this.zzc = zzioVar;
        this.zzd = zziaVar;
        this.zze = zzhkVar;
        this.zzf = zziqVar;
        this.zzg = zziiVar;
        this.zzh = zzhzVar;
    }

    private final Map zze() {
        HashMap map = new HashMap();
        zzmq zzmqVar = this.zza;
        zzbc zzbcVarZzb = this.zzb.zzb();
        map.put("v", zzmqVar.zzb());
        map.put("gms", Boolean.valueOf(this.zza.zzc()));
        map.put("int", zzbcVarZzb.zzg());
        map.put("up", Boolean.valueOf(this.zzd.zza()));
        map.put("t", new Throwable());
        zzii zziiVar = this.zzg;
        if (zziiVar != null) {
            map.put("tcq", Long.valueOf(zziiVar.zzc()));
            map.put("tpq", Long.valueOf(this.zzg.zzg()));
            map.put("tcv", Long.valueOf(this.zzg.zzd()));
            map.put("tpv", Long.valueOf(this.zzg.zzh()));
            map.put("tchv", Long.valueOf(this.zzg.zzb()));
            map.put("tphv", Long.valueOf(this.zzg.zzf()));
            map.put("tcc", Long.valueOf(this.zzg.zza()));
            map.put("tpc", Long.valueOf(this.zzg.zze()));
        }
        return map;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzob
    public final Map zza() {
        zzio zzioVar = this.zzc;
        Map mapZze = zze();
        mapZze.put("lts", Long.valueOf(zzioVar.zza()));
        return mapZze;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzob
    public final Map zzb() {
        Map mapZze = zze();
        zzbc zzbcVarZza = this.zzb.zza();
        mapZze.put("gai", Boolean.valueOf(this.zza.zzd()));
        mapZze.put("did", zzbcVarZza.zzf());
        mapZze.put("dst", Integer.valueOf(zzbcVarZza.zzal() - 1));
        mapZze.put("doo", Boolean.valueOf(zzbcVarZza.zzai()));
        zzhk zzhkVar = this.zze;
        if (zzhkVar != null) {
            mapZze.put("nt", Long.valueOf(zzhkVar.zza()));
        }
        zziq zziqVar = this.zzf;
        if (zziqVar != null) {
            mapZze.put("vs", Long.valueOf(zziqVar.zzc()));
            mapZze.put("vf", Long.valueOf(this.zzf.zzb()));
        }
        return mapZze;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzob
    public final Map zzc() {
        zzhz zzhzVar = this.zzh;
        Map mapZze = zze();
        if (zzhzVar != null) {
            mapZze.put("vst", zzhzVar.zza());
        }
        return mapZze;
    }

    public final void zzd(View view) {
        this.zzc.zzd(view);
    }
}
