package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbbo extends zziar implements zzicd {
    private static final zzbbo zzc;
    private static volatile zzick zzd;
    private int zza;
    private zzbbu zzb;

    static {
        zzbbo zzbboVar = new zzbbo();
        zzc = zzbboVar;
        zziar.x(zzbbo.class, zzbboVar);
    }

    public static zzbbo D(byte[] bArr, zziab zziabVar) {
        zziar zziarVarA = zziar.A(zzc, bArr, bArr.length, zziabVar);
        zziar.B(zziarVarA);
        return (zzbbo) zziarVarA;
    }

    public final zzbbu C() {
        zzbbu zzbbuVar = this.zzb;
        return zzbbuVar == null ? zzbbu.G() : zzbbuVar;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzc, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzbbo();
        }
        if (iOrdinal == 4) {
            return new zzbbn(zzc);
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
        synchronized (zzbbo.class) {
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
