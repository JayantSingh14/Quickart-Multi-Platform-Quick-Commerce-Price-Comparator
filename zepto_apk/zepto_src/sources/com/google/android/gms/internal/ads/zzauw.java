package com.google.android.gms.internal.ads;

import android.os.Build;

/* loaded from: classes4.dex */
public final class zzauw extends zziar implements zzicd {
    private static final zzauw zzn;
    private static volatile zzick zzo;
    private int zza;
    private long zzc;
    private int zzg;
    private long zzi;
    private long zzl;
    private long zzm;
    private zzibd zzb = zzicn.f34726e;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzh = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzauw zzauwVar = new zzauw();
        zzn = zzauwVar;
        zziar.x(zzauw.class, zzauwVar);
    }

    public static zzauv C() {
        return (zzauv) zzn.u();
    }

    public final void D(zzavo zzavoVar) {
        zzibd zzibdVar = this.zzb;
        if (!zzibdVar.zza()) {
            int size = zzibdVar.size();
            this.zzb = zzibdVar.zzh(size + size);
        }
        this.zzb.add(zzavoVar);
    }

    public final void E() {
        this.zzb = zzicn.f34726e;
    }

    public final /* synthetic */ void F(long j2) {
        this.zza |= 1;
        this.zzc = j2;
    }

    public final /* synthetic */ void G(String str) {
        String str2 = Build.MODEL;
        str2.getClass();
        this.zza |= 2;
        this.zzd = str2;
    }

    public final /* synthetic */ void H(String str) {
        str.getClass();
        this.zza |= 4;
        this.zze = str;
    }

    public final /* synthetic */ void I(String str) {
        str.getClass();
        this.zza |= 8;
        this.zzf = str;
    }

    public final /* synthetic */ void J(String str) {
        str.getClass();
        this.zza |= 32;
        this.zzh = str;
    }

    public final /* synthetic */ void K(long j2) {
        this.zza |= 64;
        this.zzi = j2;
    }

    public final /* synthetic */ void L(String str) {
        str.getClass();
        this.zza |= 128;
        this.zzj = str;
    }

    public final /* synthetic */ void M(String str) {
        str.getClass();
        this.zza |= 256;
        this.zzk = str;
    }

    public final /* synthetic */ void N(long j2) {
        this.zza |= 512;
        this.zzl = j2;
    }

    public final /* synthetic */ void O(long j2) {
        this.zza |= 1024;
        this.zzm = j2;
    }

    public final /* synthetic */ void P(int i2) {
        this.zzg = i2 - 1;
        this.zza |= 16;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzn, "\u0004\f\u0000\u0001\b?\f\u0000\u0001\u0000\b\u001b\u0015ဂ\u0000\u0016ဈ\u0001\u0017ဈ\u0002\u0018ဈ\u0003\u0019᠌\u0004(ဈ\u0005)ဂ\u0006<ဈ\u0007=ဈ\b>ဂ\t?ဂ\n", new Object[]{"zza", "zzb", zzavo.class, "zzc", "zzd", "zze", "zzf", "zzg", zzavm.f24417a, "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (iOrdinal == 3) {
            return new zzauw();
        }
        if (iOrdinal == 4) {
            return new zzauv(zzn);
        }
        if (iOrdinal == 5) {
            return zzn;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzo;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzauw.class) {
            try {
                zziamVar = zzo;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzn);
                    zzo = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
