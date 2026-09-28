package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzi extends zzacz implements zzaeg {
    private static final zzi zzb;
    private int zze;
    private zzk zzf;
    private zzp zzg;

    static {
        zzi zziVar = new zzi();
        zzb = zziVar;
        zzacz.h(zzi.class, zziVar);
    }

    public static zzi p(byte[] bArr, zzacm zzacmVar) {
        return (zzi) zzacz.n(zzb, bArr, zzacmVar);
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i3 == 3) {
            return new zzi();
        }
        if (i3 == 4) {
            return new zzh(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzk q() {
        zzk zzkVar = this.zzf;
        return zzkVar == null ? zzk.p() : zzkVar;
    }

    public final zzp r() {
        zzp zzpVar = this.zzg;
        return zzpVar == null ? zzp.p() : zzpVar;
    }

    public final boolean s() {
        return (this.zze & 1) != 0;
    }

    public final boolean t() {
        return (this.zze & 2) != 0;
    }
}
