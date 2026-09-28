package com.google.ads.interactivemedia.v3.internal;

import java.sql.Date;
import java.sql.Timestamp;

/* loaded from: classes3.dex */
public final class zzaan {
    public static final boolean zza;
    public static final zzxd zzb;
    public static final zzxd zzc;
    public static final zzuv zzd;
    public static final zzuv zze;
    public static final zzuv zzf;

    static {
        boolean z;
        zzuv zzuvVar;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        zza = z;
        if (z) {
            zzb = new zzaal(Date.class);
            zzc = new zzaam(Timestamp.class);
            zzd = zzaae.zza;
            zze = zzaah.zza;
            zzuvVar = zzaak.zza;
        } else {
            zzuvVar = null;
            zzb = null;
            zzc = null;
            zzd = null;
            zze = null;
        }
        zzf = zzuvVar;
    }
}
