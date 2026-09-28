package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzawo extends zziar implements zzicd {
    private static final zzawo zzj;
    private static volatile zzick zzk;
    private int zza;
    private long zzb = -1;
    private long zzc = -1;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;

    static {
        zzawo zzawoVar = new zzawo();
        zzj = zzawoVar;
        zziar.x(zzawo.class, zzawoVar);
    }

    public static zzawn C() {
        return (zzawn) zzj.u();
    }

    public final /* synthetic */ void D(long j2) {
        this.zza |= 1;
        this.zzb = j2;
    }

    public final /* synthetic */ void E(long j2) {
        this.zza |= 4;
        this.zzd = j2;
    }

    public final /* synthetic */ void F(long j2) {
        this.zza |= 8;
        this.zze = j2;
    }

    public final /* synthetic */ void G(long j2) {
        this.zza |= 16;
        this.zzf = j2;
    }

    public final /* synthetic */ void H(long j2) {
        this.zza |= 32;
        this.zzg = j2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzj, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzawo();
        }
        if (iOrdinal == 4) {
            return new zzawn(zzj);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzk;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzawo.class) {
            try {
                zziamVar = zzk;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzj);
                    zzk = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
