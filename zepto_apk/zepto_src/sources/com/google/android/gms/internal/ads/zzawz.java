package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzawz extends zziar implements zzicd {
    private static final zzawz zzh;
    private static volatile zzick zzi;
    private int zza;
    private long zzd;
    private long zzf;
    private long zzg;
    private String zzb = "";
    private String zzc = "";
    private String zze = "D";

    static {
        zzawz zzawzVar = new zzawz();
        zzh = zzawzVar;
        zziar.x(zzawz.class, zzawzVar);
    }

    public static zzawy C() {
        return (zzawy) zzh.u();
    }

    public final /* synthetic */ void D(String str) {
        this.zza |= 1;
        this.zzb = str;
    }

    public final /* synthetic */ void E(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    public final /* synthetic */ void F(long j2) {
        this.zza |= 4;
        this.zzd = j2;
    }

    public final /* synthetic */ void G(String str) {
        str.getClass();
        this.zza |= 8;
        this.zze = str;
    }

    public final /* synthetic */ void H(long j2) {
        this.zza |= 16;
        this.zzf = j2;
    }

    public final /* synthetic */ void I(long j2) {
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
            return new zzico(zzh, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဈ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzawz();
        }
        if (iOrdinal == 4) {
            return new zzawy(zzh);
        }
        if (iOrdinal == 5) {
            return zzh;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzi;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzawz.class) {
            try {
                zziamVar = zzi;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzh);
                    zzi = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
