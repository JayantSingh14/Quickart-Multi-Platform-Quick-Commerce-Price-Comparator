package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzas extends zzacz implements zzaeg {
    private static final zzas zzb;
    private int zze;
    private String zzf = "";

    static {
        zzas zzasVar = new zzas();
        zzb = zzasVar;
        zzacz.h(zzas.class, zzasVar);
    }

    public static zzar p() {
        return (zzar) zzb.k();
    }

    public static /* synthetic */ void q(zzas zzasVar, String str) {
        str.getClass();
        zzasVar.zze |= 1;
        zzasVar.zzf = str;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zze", "zzf"});
        }
        if (i3 == 3) {
            return new zzas();
        }
        if (i3 == 4) {
            return new zzar(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
