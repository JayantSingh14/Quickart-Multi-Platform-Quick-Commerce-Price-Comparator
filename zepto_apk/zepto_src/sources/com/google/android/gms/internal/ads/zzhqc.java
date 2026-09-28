package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhqc extends zziar implements zzicd {
    private static final zzhqc zzb;
    private static volatile zzick zzc;
    private int zza;

    static {
        zzhqc zzhqcVar = new zzhqc();
        zzb = zzhqcVar;
        zziar.x(zzhqc.class, zzhqcVar);
    }

    public static zzhqb D() {
        return (zzhqb) zzb.u();
    }

    public static zzhqc E() {
        return zzb;
    }

    public final zzhor C() {
        zzhor zzhorVarA = zzhor.a(this.zza);
        return zzhorVarA == null ? zzhor.UNRECOGNIZED : zzhorVarA;
    }

    public final /* synthetic */ void F(zzhor zzhorVar) {
        this.zza = zzhorVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhqc();
        }
        if (iOrdinal == 4) {
            return new zzhqb(zzb);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzc;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhqc.class) {
            try {
                zziamVar = zzc;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzb);
                    zzc = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
