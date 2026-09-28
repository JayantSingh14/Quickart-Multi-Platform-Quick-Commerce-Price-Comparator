package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzah extends zzacz implements zzaeg {
    private static final zzah zzb;
    private int zze;
    private long zzf;
    private int zzg;
    private boolean zzh;
    private zzade zzi = zzada.f37407d;
    private long zzj;

    static {
        zzah zzahVar = new zzah();
        zzb = zzahVar;
        zzacz.h(zzah.class, zzahVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i3 == 3) {
            return new zzah();
        }
        if (i3 == 4) {
            return new zzag(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
