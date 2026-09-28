package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
public final class zzk extends zzdh implements zzep {
    private static final zzk zzb;
    private int zzd;
    private String zze = "";
    private boolean zzf;

    static {
        zzk zzkVar = new zzk();
        zzb = zzkVar;
        zzdh.i(zzk.class, zzkVar);
    }

    public static zzj k() {
        return (zzj) zzb.e();
    }

    public static /* synthetic */ void l(zzk zzkVar, String str) {
        str.getClass();
        zzkVar.zzd |= 1;
        zzkVar.zze = str;
    }

    public static /* synthetic */ void m(zzk zzkVar, boolean z) {
        zzkVar.zzd |= 2;
        zzkVar.zzf = z;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzdh
    public final Object d(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzex(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzk();
        }
        if (i3 == 4) {
            return new zzj(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
