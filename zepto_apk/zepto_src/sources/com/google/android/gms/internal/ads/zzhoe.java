package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhoe extends zziar implements zzicd {
    private static final zzhoe zzd;
    private static volatile zzick zze;
    private int zza;
    private int zzb;
    private int zzc;

    static {
        zzhoe zzhoeVar = new zzhoe();
        zzd = zzhoeVar;
        zziar.x(zzhoe.class, zzhoeVar);
    }

    public static zzhod D() {
        return (zzhod) zzd.u();
    }

    public static zzhoe E() {
        return zzd;
    }

    public final zzhor C() {
        zzhor zzhorVarA = zzhor.a(this.zza);
        return zzhorVarA == null ? zzhor.UNRECOGNIZED : zzhorVarA;
    }

    public final /* synthetic */ void F(zzhor zzhorVar) {
        this.zza = zzhorVar.zza();
    }

    public final int G() {
        int i2 = this.zzb;
        int i3 = i2 != 0 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 != 5 ? 0 : 7 : 6 : 5 : 4 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final int H() {
        int i2 = this.zzc;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? 0 : 4 : 3 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final void I(int i2) {
        if (i2 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        this.zzb = i2 - 2;
    }

    public final void J(int i2) {
        if (i2 == 1) {
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        this.zzc = i2 - 2;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\f", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhoe();
        }
        if (iOrdinal == 4) {
            return new zzhod(zzd);
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
        synchronized (zzhoe.class) {
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
