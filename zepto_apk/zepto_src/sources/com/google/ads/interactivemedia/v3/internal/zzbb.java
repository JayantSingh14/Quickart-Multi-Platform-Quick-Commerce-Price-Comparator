package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzbb extends zzacq implements zzaea {
    private static final zzbb zzb;
    private int zzd;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private long zzl = -1;

    static {
        zzbb zzbbVar = new zzbb();
        zzb = zzbbVar;
        zzacq.zzaL(zzbb.class, zzbbVar);
    }

    private zzbb() {
    }

    public static zzba zza() {
        return (zzba) zzb.zzay();
    }

    public static /* synthetic */ void zzc(zzbb zzbbVar, long j2) {
        zzbbVar.zzd |= 1;
        zzbbVar.zze = j2;
    }

    public static /* synthetic */ void zzd(zzbb zzbbVar, long j2) {
        zzbbVar.zzd |= 4;
        zzbbVar.zzg = j2;
    }

    public static /* synthetic */ void zze(zzbb zzbbVar, long j2) {
        zzbbVar.zzd |= 8;
        zzbbVar.zzh = j2;
    }

    public static /* synthetic */ void zzf(zzbb zzbbVar, long j2) {
        zzbbVar.zzd |= 16;
        zzbbVar.zzi = j2;
    }

    public static /* synthetic */ void zzg(zzbb zzbbVar, long j2) {
        zzbbVar.zzd |= 32;
        zzbbVar.zzj = j2;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzacq
    public final Object zzj(int i2, Object obj, Object obj2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return zzacq.zzaI(zzb, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i3 == 3) {
            return new zzbb();
        }
        zzae zzaeVar = null;
        if (i3 == 4) {
            return new zzba(zzaeVar);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
