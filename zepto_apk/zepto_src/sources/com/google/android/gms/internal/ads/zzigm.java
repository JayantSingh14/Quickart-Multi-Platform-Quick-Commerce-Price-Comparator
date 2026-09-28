package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzigm extends zziar implements zzicd {
    private static final zzigm zzj;
    private static volatile zzick zzk;
    private int zza;
    private long zzc;
    private boolean zzd;
    private int zze;
    private boolean zzh;
    private boolean zzi;
    private String zzb = "";
    private String zzf = "";
    private String zzg = "";

    static {
        zzigm zzigmVar = new zzigm();
        zzj = zzigmVar;
        zziar.x(zzigm.class, zzigmVar);
    }

    public static zzigl C() {
        return (zzigl) zzj.u();
    }

    public final /* synthetic */ void D(String str) {
        this.zza |= 1;
        this.zzb = str;
    }

    public final /* synthetic */ void E(long j2) {
        this.zza |= 2;
        this.zzc = j2;
    }

    public final /* synthetic */ void F(boolean z) {
        this.zza |= 4;
        this.zzd = z;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzj, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006\bဇ\u0007", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", zzign.f34823a, "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzigm();
        }
        if (iOrdinal == 4) {
            return new zzigl(zzj);
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
        synchronized (zzigm.class) {
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
