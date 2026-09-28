package com.google.android.gms.internal.ads;

import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzawm extends zziar implements zzicd {
    private static final zzawm zzA;
    private static volatile zzick zzB;
    private int zza;
    private long zzu;
    private long zzv;
    private long zzb = -1;
    private long zzc = -1;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private int zzh = 1000;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private int zzl = 1000;
    private long zzm = -1;
    private long zzn = -1;
    private long zzo = -1;
    private long zzp = -1;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;
    private long zzz = -1;

    static {
        zzawm zzawmVar = new zzawm();
        zzA = zzawmVar;
        zziar.x(zzawm.class, zzawmVar);
    }

    public static zzawl C() {
        return (zzawl) zzA.u();
    }

    public final /* synthetic */ void D(long j2) {
        this.zza |= 1;
        this.zzb = j2;
    }

    public final /* synthetic */ void E(long j2) {
        this.zza |= 2;
        this.zzc = j2;
    }

    public final /* synthetic */ void F(long j2) {
        this.zza |= 4;
        this.zzd = j2;
    }

    public final /* synthetic */ void G(long j2) {
        this.zza |= 8;
        this.zze = j2;
    }

    public final /* synthetic */ void H() {
        this.zza &= -9;
        this.zze = -1L;
    }

    public final /* synthetic */ void I(long j2) {
        this.zza |= 16;
        this.zzf = j2;
    }

    public final /* synthetic */ void J(long j2) {
        this.zza |= 32;
        this.zzg = j2;
    }

    public final /* synthetic */ void K(long j2) {
        this.zza |= 128;
        this.zzi = j2;
    }

    public final /* synthetic */ void L(long j2) {
        this.zza |= 256;
        this.zzj = j2;
    }

    public final /* synthetic */ void M(long j2) {
        this.zza |= 512;
        this.zzk = j2;
    }

    public final /* synthetic */ void N(long j2) {
        this.zza |= 2048;
        this.zzm = j2;
    }

    public final /* synthetic */ void O(long j2) {
        this.zza |= 4096;
        this.zzn = j2;
    }

    public final /* synthetic */ void P(long j2) {
        this.zza |= KEYRecord.Flags.FLAG2;
        this.zzo = j2;
    }

    public final /* synthetic */ void Q(long j2) {
        this.zza |= 16384;
        this.zzp = j2;
    }

    public final /* synthetic */ void R(long j2) {
        this.zza |= 32768;
        this.zzu = j2;
    }

    public final /* synthetic */ void S(long j2) {
        this.zza |= 65536;
        this.zzv = j2;
    }

    public final /* synthetic */ void T(long j2) {
        this.zza |= 131072;
        this.zzw = j2;
    }

    public final /* synthetic */ void U(long j2) {
        this.zza |= 262144;
        this.zzx = j2;
    }

    public final /* synthetic */ void V(int i2) {
        this.zzh = i2 - 1;
        this.zza |= 64;
    }

    public final /* synthetic */ void W(int i2) {
        this.zzl = i2 - 1;
        this.zza |= 1024;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zziax zziaxVar = zzawx.f24427a;
            return new zzico(zzA, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000b᠌\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", zziaxVar, "zzi", "zzj", "zzk", "zzl", zziaxVar, "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz"});
        }
        if (iOrdinal == 3) {
            return new zzawm();
        }
        if (iOrdinal == 4) {
            return new zzawl(zzA);
        }
        if (iOrdinal == 5) {
            return zzA;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzB;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzawm.class) {
            try {
                zziamVar = zzB;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzA);
                    zzB = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
