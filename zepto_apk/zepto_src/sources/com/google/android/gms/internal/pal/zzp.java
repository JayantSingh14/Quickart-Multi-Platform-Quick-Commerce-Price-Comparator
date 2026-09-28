package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzp extends zzacz implements zzaeg {
    private static final zzp zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzp zzpVar = new zzp();
        zzb = zzpVar;
        zzacz.h(zzp.class, zzpVar);
    }

    public static zzp p() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i3 == 3) {
            return new zzp();
        }
        if (i3 == 4) {
            return new zzo(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final String q() {
        return this.zzf;
    }

    public final String r() {
        return this.zzk;
    }
}
