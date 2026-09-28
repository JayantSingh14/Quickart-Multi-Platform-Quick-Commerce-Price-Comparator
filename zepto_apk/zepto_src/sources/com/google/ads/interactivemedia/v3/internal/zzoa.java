package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class zzoa {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzob zzc;
    private final zzmo zzd;
    private final zzmj zze;

    @Nullable
    private zznp zzf;
    private final Object zzg = new Object();

    public zzoa(@NonNull Context context, @NonNull zzob zzobVar, @NonNull zzmo zzmoVar, @NonNull zzmj zzmjVar) {
        this.zzb = context;
        this.zzc = zzobVar;
        this.zzd = zzmoVar;
        this.zze = zzmjVar;
    }

    private final synchronized Class zzd(@NonNull zznq zznqVar) throws zznz {
        try {
            String strZzk = zznqVar.zza().zzk();
            HashMap map = zza;
            Class cls = (Class) map.get(strZzk);
            if (cls != null) {
                return cls;
            }
            try {
                if (!this.zze.zza(zznqVar.zzc())) {
                    throw new zznz(2026, "VM did not pass signature verification");
                }
                try {
                    File fileZzb = zznqVar.zzb();
                    if (!fileZzb.exists()) {
                        fileZzb.mkdirs();
                    }
                    Class<?> clsLoadClass = new DexClassLoader(zznqVar.zzc().getAbsolutePath(), fileZzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                    map.put(strZzk, clsLoadClass);
                    return clsLoadClass;
                } catch (ClassNotFoundException e2) {
                    e = e2;
                    throw new zznz(2008, e);
                } catch (IllegalArgumentException e3) {
                    e = e3;
                    throw new zznz(2008, e);
                } catch (SecurityException e4) {
                    e = e4;
                    throw new zznz(2008, e);
                }
            } catch (GeneralSecurityException e5) {
                throw new zznz(2026, e5);
            }
        } finally {
        }
    }

    @Nullable
    public final zzmr zza() {
        zznp zznpVar;
        synchronized (this.zzg) {
            zznpVar = this.zzf;
        }
        return zznpVar;
    }

    @Nullable
    public final zznq zzb() {
        synchronized (this.zzg) {
            try {
                zznp zznpVar = this.zzf;
                if (zznpVar == null) {
                    return null;
                }
                return zznpVar.zzf();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean zzc(@NonNull zznq zznqVar) throws IllegalAccessException, InstantiationException, zznz, IllegalArgumentException, InvocationTargetException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zznp zznpVar = new zznp(zzd(zznqVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zznqVar.zze(), null, new Bundle(), 2), zznqVar, this.zzc, this.zzd);
                if (!zznpVar.zzh()) {
                    throw new zznz(4000, "init failed");
                }
                int iZze = zznpVar.zze();
                if (iZze != 0) {
                    throw new zznz(4001, "ci: " + iZze);
                }
                synchronized (this.zzg) {
                    zznp zznpVar2 = this.zzf;
                    if (zznpVar2 != null) {
                        try {
                            zznpVar2.zzg();
                        } catch (zznz e2) {
                            this.zzd.zzc(e2.zza(), -1L, e2);
                        }
                        this.zzf = zznpVar;
                    } else {
                        this.zzf = zznpVar;
                    }
                }
                this.zzd.zzd(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e3) {
                throw new zznz(2004, e3);
            }
        } catch (zznz e4) {
            this.zzd.zzc(e4.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e4);
            return false;
        } catch (Exception e5) {
            this.zzd.zzc(4010, System.currentTimeMillis() - jCurrentTimeMillis, e5);
            return false;
        }
    }
}
