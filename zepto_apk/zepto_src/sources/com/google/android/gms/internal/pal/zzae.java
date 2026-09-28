package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzae extends zzacz implements zzaeg {
    private static final zzae zzb;
    private int zze;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private long zzl = -1;
    private long zzm = -1;

    static {
        zzae zzaeVar = new zzae();
        zzb = zzaeVar;
        zzacz.h(zzae.class, zzaeVar);
    }

    public static zzad p() {
        return (zzad) zzb.k();
    }

    public static /* synthetic */ void q(zzae zzaeVar, long j2) {
        zzaeVar.zze |= 1;
        zzaeVar.zzf = j2;
    }

    public static /* synthetic */ void r(zzae zzaeVar, long j2) {
        zzaeVar.zze |= 4;
        zzaeVar.zzh = j2;
    }

    public static /* synthetic */ void s(zzae zzaeVar, long j2) {
        zzaeVar.zze |= 8;
        zzaeVar.zzi = j2;
    }

    public static /* synthetic */ void t(zzae zzaeVar, long j2) {
        zzaeVar.zze |= 16;
        zzaeVar.zzj = j2;
    }

    public static /* synthetic */ void u(zzae zzaeVar, long j2) {
        zzaeVar.zze |= 32;
        zzaeVar.zzk = j2;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i3 == 3) {
            return new zzae();
        }
        if (i3 == 4) {
            return new zzad(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
