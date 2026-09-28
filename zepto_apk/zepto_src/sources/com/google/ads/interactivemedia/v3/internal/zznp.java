package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
final class zznp implements zzmr {
    private final Object zza;
    private final zznq zzb;
    private final zzob zzc;
    private final zzmo zzd;

    public zznp(@NonNull Object obj, @NonNull zznq zznqVar, @NonNull zzob zzobVar, @NonNull zzmo zzmoVar) {
        this.zza = obj;
        this.zzb = zznqVar;
        this.zzc = zzobVar;
        this.zzd = zzmoVar;
    }

    @Nullable
    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzbo zzboVarZza = zzbp.zza();
        zzboVarZza.zzc(5);
        zzboVarZza.zza(zzabn.zzs(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzbp) zzboVarZza.zzan()).zzav(), 11);
    }

    @Nullable
    private final synchronized byte[] zzj(Map map, Map map2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e2) {
            this.zzd.zzc(2007, System.currentTimeMillis() - jCurrentTimeMillis, e2);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zza, null, map2);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmr
    @Nullable
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map mapZza;
        mapZza = this.zzc.zza();
        mapZza.put("f", "c");
        mapZza.put("ctx", context);
        mapZza.put("cs", str2);
        mapZza.put("aid", null);
        mapZza.put("view", view);
        mapZza.put("act", activity);
        return zzi(zzj(null, mapZza));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmr
    @Nullable
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map mapZzc;
        mapZzc = this.zzc.zzc();
        mapZzc.put("f", "v");
        mapZzc.put("ctx", context);
        mapZzc.put("aid", null);
        mapZzc.put("view", view);
        mapZzc.put("act", activity);
        return zzi(zzj(null, mapZzc));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmr
    @Nullable
    public final synchronized String zzc(Context context, String str) {
        Map mapZzb;
        mapZzb = this.zzc.zzb();
        mapZzb.put("f", "q");
        mapZzb.put("ctx", context);
        mapZzb.put("aid", null);
        return zzi(zzj(null, mapZzb));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzmr
    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zznz {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            map.put("t", new Throwable());
            map.put("aid", null);
            map.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", Map.class).invoke(this.zza, map);
            this.zzd.zzd(3003, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e2) {
            throw new zznz(2005, e2);
        }
    }

    public final synchronized int zze() throws zznz {
        try {
        } catch (Exception e2) {
            throw new zznz(2006, e2);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", null).invoke(this.zza, null)).intValue();
    }

    public final zznq zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zznz {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod("close", null).invoke(this.zza, null);
            this.zzd.zzd(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e2) {
            throw new zznz(2003, e2);
        }
    }

    public final synchronized boolean zzh() throws zznz {
        try {
        } catch (Exception e2) {
            throw new zznz(2001, e2);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod("init", null).invoke(this.zza, null)).booleanValue();
    }
}
