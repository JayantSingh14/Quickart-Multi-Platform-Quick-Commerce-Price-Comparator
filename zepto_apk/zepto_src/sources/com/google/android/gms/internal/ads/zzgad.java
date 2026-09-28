package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgad extends zziar implements zzicd {
    private static volatile zzick zzA;
    private static final zzgad zzz;
    private int zza;
    private int zzb;
    private boolean zze;
    private zzgav zzf;
    private boolean zzg;
    private zzgax zzj;
    private boolean zzv;
    private boolean zzw;
    private boolean zzy;
    private boolean zzc = true;
    private String zzd = "unknown_host";
    private long zzh = 100;
    private long zzi = 2000;
    private long zzk = 200;
    private long zzl = 200;
    private long zzm = 20000;
    private String zzn = "";
    private String zzo = "";
    private long zzp = 500;
    private long zzu = 3000;
    private boolean zzx = true;

    static {
        zzgad zzgadVar = new zzgad();
        zzz = zzgadVar;
        zziar.x(zzgad.class, zzgadVar);
    }

    public static zzgac a0() {
        return (zzgac) zzz.u();
    }

    public final /* synthetic */ void C(zzgax zzgaxVar) {
        this.zzj = zzgaxVar;
        this.zza |= 256;
    }

    public final /* synthetic */ void D(long j2) {
        this.zza |= 32768;
        this.zzu = j2;
    }

    public final /* synthetic */ void E(boolean z) {
        this.zza |= 65536;
        this.zzv = z;
    }

    public final int F() {
        int i2;
        int i3 = this.zzb;
        if (i3 != 0) {
            i2 = 2;
            if (i3 != 1) {
                i2 = i3 != 2 ? i3 != 3 ? 0 : 4 : 3;
            }
        } else {
            i2 = 1;
        }
        if (i2 == 0) {
            return 1;
        }
        return i2;
    }

    public final /* synthetic */ void G(int i2) {
        this.zzb = i2 - 1;
        this.zza |= 1;
    }

    public final boolean H() {
        return this.zzc;
    }

    public final String I() {
        return this.zzd;
    }

    public final boolean J() {
        return this.zze;
    }

    public final zzgav K() {
        zzgav zzgavVar = this.zzf;
        return zzgavVar == null ? zzgav.H() : zzgavVar;
    }

    public final boolean L() {
        return this.zzg;
    }

    public final long M() {
        return this.zzh;
    }

    public final long N() {
        return this.zzi;
    }

    public final zzgax O() {
        zzgax zzgaxVar = this.zzj;
        return zzgaxVar == null ? zzgax.K() : zzgaxVar;
    }

    public final long P() {
        return this.zzk;
    }

    public final long Q() {
        return this.zzl;
    }

    public final long R() {
        return this.zzm;
    }

    public final String S() {
        return this.zzn;
    }

    public final String T() {
        return this.zzo;
    }

    public final long U() {
        return this.zzp;
    }

    public final long V() {
        return this.zzu;
    }

    public final boolean W() {
        return this.zzv;
    }

    public final boolean X() {
        return this.zzw;
    }

    public final boolean Y() {
        return this.zzx;
    }

    public final boolean Z() {
        return this.zzy;
    }

    public final /* synthetic */ void b0(boolean z) {
        this.zza |= 2;
        this.zzc = z;
    }

    public final /* synthetic */ void c0(String str) {
        str.getClass();
        this.zza |= 4;
        this.zzd = str;
    }

    public final /* synthetic */ void d0(zzgav zzgavVar) {
        this.zzf = zzgavVar;
        this.zza |= 16;
    }

    public final /* synthetic */ void e0(long j2) {
        this.zza |= 64;
        this.zzh = j2;
    }

    public final /* synthetic */ void f0(long j2) {
        this.zza |= 128;
        this.zzi = j2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzz, "\u0004\u0014\u0000\u0001\u0001\u0015\u0014\u0000\u0000\u0000\u0001᠌\u0000\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဉ\u0004\u0006ဇ\u0005\u0007ဂ\u0007\bဉ\b\tဇ\u0001\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဈ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဇ\u0010\u0012ဂ\u0006\u0013ဇ\u0011\u0014ဇ\u0012\u0015ဇ\u0013", new Object[]{"zza", "zzb", zzgae.f32150a, "zzd", "zze", "zzf", "zzg", "zzi", "zzj", "zzc", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzh", "zzw", "zzx", "zzy"});
        }
        if (iOrdinal == 3) {
            return new zzgad();
        }
        if (iOrdinal == 4) {
            return new zzgac(zzz);
        }
        if (iOrdinal == 5) {
            return zzz;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzA;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzgad.class) {
            try {
                zziamVar = zzA;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzz);
                    zzA = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
