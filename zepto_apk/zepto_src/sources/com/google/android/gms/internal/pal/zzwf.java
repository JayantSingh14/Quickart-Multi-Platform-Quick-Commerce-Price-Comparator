package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzwf extends zzacz implements zzaeg {
    private static final zzwf zzb;
    private String zze = "";
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zzwf zzwfVar = new zzwf();
        zzb = zzwfVar;
        zzacz.h(zzwf.class, zzwfVar);
    }

    public static zzwe p() {
        return (zzwe) zzb.k();
    }

    public static /* synthetic */ void q(zzwf zzwfVar, String str) {
        str.getClass();
        zzwfVar.zze = str;
    }

    public static void t(zzwf zzwfVar, int i2) {
        if (i2 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        zzwfVar.zzf = i2 - 2;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i3 == 3) {
            return new zzwf();
        }
        if (i3 == 4) {
            return new zzwe(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
