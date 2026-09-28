package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzf extends zzacz implements zzaeg {
    private static final zzf zzb;
    private int zze;
    private long zzg;
    private long zzk;
    private long zzl;
    private long zzn;
    private int zzr;
    private String zzf = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzm = "";
    private String zzo = "";
    private String zzp = "";
    private zzadf zzq = zzaeo.f37460d;

    static {
        zzf zzfVar = new zzf();
        zzb = zzfVar;
        zzacz.h(zzf.class, zzfVar);
    }

    public static zzb p() {
        return (zzb) zzb.k();
    }

    public static /* synthetic */ void q(zzf zzfVar, long j2) {
        zzfVar.zze |= 2;
        zzfVar.zzg = j2;
    }

    public static /* synthetic */ void r(zzf zzfVar, String str) {
        str.getClass();
        zzfVar.zze |= 4;
        zzfVar.zzh = str;
    }

    public static /* synthetic */ void s(zzf zzfVar, String str) {
        zzfVar.zze |= 8;
        zzfVar.zzi = str;
    }

    public static /* synthetic */ void t(zzf zzfVar, String str) {
        zzfVar.zze |= 16;
        zzfVar.zzj = str;
    }

    public static /* synthetic */ void u(zzf zzfVar, String str) {
        str.getClass();
        zzfVar.zze |= 1;
        zzfVar.zzf = str;
    }

    @Override // com.google.android.gms.internal.pal.zzacz
    public final Object o(int i2) {
        int i3 = i2 - 1;
        if (i3 == 0) {
            return (byte) 1;
        }
        if (i3 == 2) {
            return new zzaep(zzb, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzd.class, "zzr", zze.f37666a});
        }
        if (i3 == 3) {
            return new zzf();
        }
        if (i3 == 4) {
            return new zzb(zzb);
        }
        if (i3 != 5) {
            return null;
        }
        return zzb;
    }
}
