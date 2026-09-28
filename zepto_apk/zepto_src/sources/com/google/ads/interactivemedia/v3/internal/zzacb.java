package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzacb {
    static final zzacb zza = new zzacb(true);
    private static volatile boolean zzb = false;
    private static volatile zzacb zzc;
    private final Map zzd;

    public zzacb() {
        this.zzd = new HashMap();
    }

    public static zzacb zza() {
        return zza;
    }

    public static zzacb zzb() {
        zzacb zzacbVar = zzc;
        if (zzacbVar != null) {
            return zzacbVar;
        }
        synchronized (zzacb.class) {
            try {
                zzacb zzacbVar2 = zzc;
                if (zzacbVar2 != null) {
                    return zzacbVar2;
                }
                zzacb zzacbVarZzb = zzacj.zzb(zzacb.class);
                zzc = zzacbVarZzb;
                return zzacbVarZzb;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final zzaco zzc(zzadz zzadzVar, int i2) {
        return (zzaco) this.zzd.get(new zzaca(zzadzVar, i2));
    }

    public zzacb(boolean z) {
        this.zzd = Collections.EMPTY_MAP;
    }
}
