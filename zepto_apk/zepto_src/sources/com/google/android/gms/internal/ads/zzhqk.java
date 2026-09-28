package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhqk extends zziar implements zzicd {
    private static final zzhqk zzd;
    private static volatile zzick zze;
    private int zza;
    private int zzb;
    private int zzc;

    static {
        zzhqk zzhqkVar = new zzhqk();
        zzd = zzhqkVar;
        zziar.x(zzhqk.class, zzhqkVar);
    }

    public static zzhqj F() {
        return (zzhqj) zzd.u();
    }

    public static zzhqk G() {
        return zzd;
    }

    public final zzhor C() {
        zzhor zzhorVarA = zzhor.a(this.zza);
        return zzhorVarA == null ? zzhor.UNRECOGNIZED : zzhorVarA;
    }

    public final zzhor D() {
        zzhor zzhorVarA = zzhor.a(this.zzb);
        return zzhorVarA == null ? zzhor.UNRECOGNIZED : zzhorVarA;
    }

    public final int E() {
        return this.zzc;
    }

    public final /* synthetic */ void H(zzhor zzhorVar) {
        this.zza = zzhorVar.zza();
    }

    public final /* synthetic */ void I(zzhor zzhorVar) {
        this.zzb = zzhorVar.zza();
    }

    public final /* synthetic */ void J(int i2) {
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\u0004", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhqk();
        }
        if (iOrdinal == 4) {
            return new zzhqj(zzd);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zze;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhqk.class) {
            try {
                zziamVar = zze;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzd);
                    zze = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
