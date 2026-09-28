package com.google.android.gms.internal.pal;

import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzac extends zzacz implements zzaeg {
    private static final zzac zzb;
    private int zze;
    private long zzu;
    private long zzv;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private int zzl = 1000;
    private long zzm = -1;
    private long zzn = -1;
    private long zzo = -1;
    private int zzp = 1000;
    private long zzq = -1;
    private long zzr = -1;
    private long zzs = -1;
    private long zzt = -1;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;
    private long zzz = -1;

    static {
        zzac zzacVar = new zzac();
        zzb = zzacVar;
        zzacz.h(zzac.class, zzacVar);
    }

    public static /* synthetic */ void A(zzac zzacVar, long j2) {
        zzacVar.zze |= 2048;
        zzacVar.zzq = j2;
    }

    public static /* synthetic */ void C(zzac zzacVar, long j2) {
        zzacVar.zze |= 4096;
        zzacVar.zzr = j2;
    }

    public static /* synthetic */ void D(zzac zzacVar, long j2) {
        zzacVar.zze |= KEYRecord.Flags.FLAG2;
        zzacVar.zzs = j2;
    }

    public static /* synthetic */ void E(zzac zzacVar, long j2) {
        zzacVar.zze |= 16384;
        zzacVar.zzt = j2;
    }

    public static /* synthetic */ void G(zzac zzacVar, long j2) {
        zzacVar.zze |= 32768;
        zzacVar.zzu = j2;
    }

    public static /* synthetic */ void H(zzac zzacVar, long j2) {
        zzacVar.zze |= 65536;
        zzacVar.zzv = j2;
    }

    public static /* synthetic */ void I(zzac zzacVar, long j2) {
        zzacVar.zze |= 131072;
        zzacVar.zzw = j2;
    }

    public static /* synthetic */ void J(zzac zzacVar, long j2) {
        zzacVar.zze |= 262144;
        zzacVar.zzx = j2;
    }

    public static /* synthetic */ void K(zzac zzacVar, int i2) {
        zzacVar.zzl = i2 - 1;
        zzacVar.zze |= 64;
    }

    public static /* synthetic */ void L(zzac zzacVar, int i2) {
        zzacVar.zzp = i2 - 1;
        zzacVar.zze |= 1024;
    }

    public static zzab p() {
        return (zzab) zzb.k();
    }

    public static /* synthetic */ void q(zzac zzacVar, long j2) {
        zzacVar.zze |= 1;
        zzacVar.zzf = j2;
    }

    public static /* synthetic */ void r(zzac zzacVar, long j2) {
        zzacVar.zze |= 2;
        zzacVar.zzg = j2;
    }

    public static /* synthetic */ void s(zzac zzacVar, long j2) {
        zzacVar.zze |= 4;
        zzacVar.zzh = j2;
    }

    public static /* synthetic */ void t(zzac zzacVar, long j2) {
        zzacVar.zze |= 8;
        zzacVar.zzi = j2;
    }

    public static /* synthetic */ void u(zzac zzacVar) {
        zzacVar.zze &= -9;
        zzacVar.zzi = -1L;
    }

    public static /* synthetic */ void v(zzac zzacVar, long j2) {
        zzacVar.zze |= 16;
        zzacVar.zzj = j2;
    }

    public static /* synthetic */ void w(zzac zzacVar, long j2) {
        zzacVar.zze |= 32;
        zzacVar.zzk = j2;
    }

    public static /* synthetic */ void x(zzac zzacVar, long j2) {
        zzacVar.zze |= 128;
        zzacVar.zzm = j2;
    }

    public static /* synthetic */ void y(zzac zzacVar, long j2) {
        zzacVar.zze |= 256;
        zzacVar.zzn = j2;
    }

    public static /* synthetic */ void z(zzac zzacVar, long j2) {
        zzacVar.zze |= 512;
        zzacVar.zzo = j2;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            zzadd zzaddVar = zzan.f37523a;
            return new zzaep(zzb, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzaddVar, "zzm", "zzn", "zzo", "zzp", zzaddVar, "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz"});
        }
        if (i3 == 3) {
            return new zzac();
        }
        if (i3 == 4) {
            return new zzab(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
