package com.google.android.gms.internal.ads;

import com.reactnativecommunity.clipboard.ClipboardModule;

/* loaded from: classes4.dex */
public final class zzigf extends zziar implements zzicd {
    private static final zzigf zzf;
    private static volatile zzick zzg;
    private int zza;
    private int zzb;
    private String zzc = "";
    private zzhzl zzd;
    private zzhzl zze;

    static {
        zzigf zzigfVar = new zzigf();
        zzf = zzigfVar;
        zziar.x(zzigf.class, zzigfVar);
    }

    public zzigf() {
        zzhzl zzhzlVar = zzhzl.f34557b;
        this.zzd = zzhzlVar;
        this.zze = zzhzlVar;
    }

    public static zzigd C() {
        return (zzigd) zzf.u();
    }

    public final /* synthetic */ void D(String str) {
        this.zza |= 2;
        this.zzc = ClipboardModule.MIMETYPE_PNG;
    }

    public final /* synthetic */ void E(zzhzl zzhzlVar) {
        zzhzlVar.getClass();
        this.zza |= 4;
        this.zzd = zzhzlVar;
    }

    public final /* synthetic */ void F(int i2) {
        this.zzb = 1;
        this.zza = 1 | this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zza", "zzb", zzige.f34820a, "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzigf();
        }
        if (iOrdinal == 4) {
            return new zzigd(zzf);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzg;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzigf.class) {
            try {
                zziamVar = zzg;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzf);
                    zzg = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
