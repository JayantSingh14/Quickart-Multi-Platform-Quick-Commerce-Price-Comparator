package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhpi extends zziar implements zzicd {
    private static final zzhpi zzf;
    private static volatile zzick zzg;
    private int zza;
    private zzhpa zzb;
    private int zzc;
    private int zzd;
    private int zze;

    static {
        zzhpi zzhpiVar = new zzhpi();
        zzf = zzhpiVar;
        zziar.x(zzhpi.class, zzhpiVar);
    }

    public static zzhph G() {
        return (zzhph) zzf.u();
    }

    public final boolean C() {
        return (this.zza & 1) != 0;
    }

    public final zzhpa D() {
        zzhpa zzhpaVar = this.zzb;
        return zzhpaVar == null ? zzhpa.G() : zzhpaVar;
    }

    public final int E() {
        return this.zzd;
    }

    public final zzhpw F() {
        zzhpw zzhpwVarA = zzhpw.a(this.zze);
        return zzhpwVarA == null ? zzhpw.UNRECOGNIZED : zzhpwVarA;
    }

    public final /* synthetic */ void H(zzhpa zzhpaVar) {
        this.zzb = zzhpaVar;
        this.zza |= 1;
    }

    public final /* synthetic */ void I(int i2) {
        this.zzd = i2;
    }

    public final /* synthetic */ void J(zzhpw zzhpwVar) {
        this.zze = zzhpwVar.zza();
    }

    public final int K() {
        int i2 = this.zzc;
        int i3 = i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? 0 : 5 : 4 : 3 : 2;
        if (i3 == 0) {
            return 1;
        }
        return i3;
    }

    public final void L(int i2) {
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
            return new zzico(zzf, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhpi();
        }
        if (iOrdinal == 4) {
            return new zzhph(zzf);
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
        synchronized (zzhpi.class) {
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
