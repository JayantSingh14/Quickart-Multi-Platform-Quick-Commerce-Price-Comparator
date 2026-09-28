package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhox extends zziar implements zzicd {
    private static final zzhox zzc;
    private static volatile zzick zzd;
    private int zza;
    private int zzb;

    static {
        zzhox zzhoxVar = new zzhox();
        zzc = zzhoxVar;
        zziar.x(zzhox.class, zzhoxVar);
    }

    public static zzhow E() {
        return (zzhow) zzc.u();
    }

    public static zzhox F() {
        return zzc;
    }

    public final zzhor C() {
        zzhor zzhorVarA = zzhor.a(this.zza);
        return zzhorVarA == null ? zzhor.UNRECOGNIZED : zzhorVarA;
    }

    public final int D() {
        return this.zzb;
    }

    public final /* synthetic */ void G(zzhor zzhorVar) {
        this.zza = zzhorVar.zza();
    }

    public final /* synthetic */ void H(int i2) {
        this.zzb = i2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhox();
        }
        if (iOrdinal == 4) {
            return new zzhow(zzc);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzick zzickVar = zzd;
        if (zzickVar != null) {
            return zzickVar;
        }
        synchronized (zzhox.class) {
            try {
                zziamVar = zzd;
                if (zziamVar == null) {
                    zziamVar = new zziam(zzc);
                    zzd = zziamVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zziamVar;
    }
}
