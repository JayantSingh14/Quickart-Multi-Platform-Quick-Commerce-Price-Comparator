package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzfxs extends zziar implements zzicd {
    private static final zzfxs zzn;
    private static volatile zzick zzo;
    private int zza;
    private String zzb = "";
    private long zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private zzibc zzk;
    private zzibc zzl;
    private zzibc zzm;

    static {
        zzfxs zzfxsVar = new zzfxs();
        zzn = zzfxsVar;
        zziar.x(zzfxs.class, zzfxsVar);
    }

    public zzfxs() {
        zzibq zzibqVar = zzibq.f34690e;
        this.zzk = zzibqVar;
        this.zzl = zzibqVar;
        this.zzm = zzibqVar;
    }

    public static zzfxs T() {
        return zzn;
    }

    public final void C(long j2) {
        zzibc zzibcVar = this.zzl;
        if (!zzibcVar.zza()) {
            int size = zzibcVar.size();
            this.zzl = zzibcVar.zzh(size + size);
        }
        this.zzl.h(j2);
    }

    public final void D(long j2) {
        zzibc zzibcVar = this.zzm;
        if (!zzibcVar.zza()) {
            int size = zzibcVar.size();
            this.zzm = zzibcVar.zzh(size + size);
        }
        this.zzm.h(j2);
    }

    public final void E() {
        this.zzm = zzibq.f34690e;
    }

    public final String F() {
        return this.zzb;
    }

    public final long G() {
        return this.zzc;
    }

    public final int H() {
        return this.zzd;
    }

    public final boolean I() {
        return this.zze;
    }

    public final boolean J() {
        return this.zzf;
    }

    public final long K() {
        return this.zzg;
    }

    public final long L() {
        return this.zzh;
    }

    public final long M() {
        return this.zzi;
    }

    public final boolean N() {
        return (this.zza & 64) != 0;
    }

    public final zzibc O() {
        return this.zzk;
    }

    public final int P() {
        return this.zzk.size();
    }

    public final int Q() {
        return this.zzl.size();
    }

    public final zzibc R() {
        return this.zzm;
    }

    public final int S() {
        return this.zzm.size();
    }

    public final /* synthetic */ void U(String str) {
        str.getClass();
        this.zzb = str;
    }

    public final /* synthetic */ void V(long j2) {
        this.zza |= 1;
        this.zzc = j2;
    }

    public final /* synthetic */ void W(int i2) {
        this.zza |= 2;
        this.zzd = i2;
    }

    public final /* synthetic */ void X() {
        this.zza |= 4;
        this.zze = true;
    }

    public final /* synthetic */ void Y(boolean z) {
        this.zza |= 8;
        this.zzf = true;
    }

    public final /* synthetic */ void Z(long j2) {
        this.zza |= 16;
        this.zzg = j2;
    }

    public final /* synthetic */ void a0(long j2) {
        this.zzh = j2;
    }

    public final /* synthetic */ void b0(long j2) {
        this.zza |= 32;
        this.zzi = j2;
    }

    public final /* synthetic */ void c0(long j2) {
        this.zza |= 64;
        this.zzj = j2;
    }

    public final void d0(long j2) {
        zzibc zzibcVar = this.zzk;
        if (!zzibcVar.zza()) {
            int size = zzibcVar.size();
            this.zzk = zzibcVar.zzh(size + size);
        }
        this.zzk.h(j2);
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzn, "\u0004\f\u0000\u0001\u0001\f\f\u0000\u0003\u0000\u0001Ȉ\u0002ဂ\u0000\u0003င\u0001\u0004ဇ\u0002\u0005ဇ\u0003\u0006ဂ\u0004\u0007\u0002\bဂ\u0005\tဂ\u0006\n%\u000b%\f%", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (iOrdinal == 3) {
            return new zzfxs();
        }
        if (iOrdinal == 4) {
            return new zzfxr(zzn);
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
        synchronized (zzfxs.class) {
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
