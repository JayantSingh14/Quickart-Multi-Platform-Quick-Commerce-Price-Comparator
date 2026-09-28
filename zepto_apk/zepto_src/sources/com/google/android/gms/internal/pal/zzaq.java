package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzaq extends zzacz implements zzaeg {
    private static final zzaq zzb;
    private int zze;
    private long zzf;
    private String zzg = "";
    private zzaby zzh = zzaby.f37363b;

    static {
        zzaq zzaqVar = new zzaq();
        zzb = zzaqVar;
        zzacz.h(zzaq.class, zzaqVar);
    }

    public static zzaq q() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new zzaq();
        }
        if (i3 == 4) {
            return new zzap(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final long p() {
        return this.zzf;
    }

    public final boolean r() {
        return (this.zze & 1) != 0;
    }
}
