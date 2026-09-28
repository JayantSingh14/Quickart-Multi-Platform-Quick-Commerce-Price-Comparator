package com.google.android.gms.internal.ads;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzfxw extends zziar implements zzicd {
    private static final zzfxw zzb;
    private static volatile zzick zzc;
    private zzibw zza = zzibw.f34700b;

    static {
        zzfxw zzfxwVar = new zzfxw();
        zzb = zzfxwVar;
        zziar.x(zzfxw.class, zzfxwVar);
    }

    public static zzfxw E(FileInputStream fileInputStream) throws zzibg {
        zzfxw zzfxwVar = zzb;
        zzhzo zzhzoVar = new zzhzo(fileInputStream);
        zziab zziabVar = zziab.f34620b;
        int i2 = zzhyy.f34536a;
        zziar zziarVarP = zziar.p(zzfxwVar, zzhzoVar, zziab.f34621c);
        zziar.B(zziarVarP);
        return (zzfxw) zziarVarP;
    }

    public static zzfxw F() {
        return zzb;
    }

    public final int C() {
        return this.zza.size();
    }

    public final Map D() {
        return Collections.unmodifiableMap(this.zza);
    }

    public final zzibw G() {
        zzibw zzibwVar = this.zza;
        if (!zzibwVar.f34701a) {
            this.zza = zzibwVar.a();
        }
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zziar
    public final Object y(zziaq zziaqVar, zziar zziarVar) {
        zzick zziamVar;
        int iOrdinal = zziaqVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return new zzico(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"zza", zzfxv.f31991a});
        }
        if (iOrdinal == 3) {
            return new zzfxw();
        }
        if (iOrdinal == 4) {
            return new zzfxu(zzb);
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
        synchronized (zzfxw.class) {
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
