package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzavc extends zziar implements zzicd {
    private static final zzavc zzo;
    private static volatile zzick zzp;
    private int zza;
    private long zzc;
    private long zzg;
    private long zzh;
    private long zzj;
    private int zzn;
    private String zzb = "";
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzi = "";
    private String zzk = "";
    private String zzl = "";
    private zzibd zzm = zzicn.f34726e;

    static {
        zzavc zzavcVar = new zzavc();
        zzo = zzavcVar;
        zziar.x(zzavc.class, zzavcVar);
    }

    public static zzauy C() {
        return (zzauy) zzo.u();
    }

    public final /* synthetic */ void D(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzb = str;
    }

    public final /* synthetic */ void E(long j2) {
        this.zza |= 2;
        this.zzc = j2;
    }

    public final /* synthetic */ void F(String str) {
        str.getClass();
        this.zza |= 4;
        this.zzd = str;
    }

    public final /* synthetic */ void G(String str) {
        this.zza |= 8;
        this.zze = str;
    }

    public final /* synthetic */ void H(String str) {
        this.zza |= 16;
        this.zzf = str;
    }

    public final /* synthetic */ void I(String str) {
        this.zza |= 1024;
        this.zzl = str;
    }

    public final /* synthetic */ void J(int i2) {
        this.zzn = i2 - 1;
        this.zza |= 2048;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzo, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzava.class, "zzn", zzavb.f24415a});
        }
        if (iOrdinal == 3) {
            return new zzavc();
        }
        if (iOrdinal == 4) {
            return new zzauy(zzo);
        }
        if (iOrdinal == 5) {
            return zzo;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzp;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzavc.class) {
            try {
                zziamVar = zzp;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzo);
                    zzp = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
