package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzd extends zzacz implements zzaeg {
    private static final zzd zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzd zzdVar = new zzd();
        zzb = zzdVar;
        zzacz.h(zzd.class, zzdVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzd();
        }
        if (i3 == 4) {
            return new zzc(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
