package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes3.dex */
public final class zzir extends zzjv {
    private final Activity zzi;
    private final View zzj;

    public zzir(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3, View view, Activity activity) {
        super(zzihVar, "GC4CZUnPsyUcm5NrWw7C8gSktjb/gtBCDrSKBLlqImuOnQy7zHyo6XlIzkH3EMVH", "Kx8fghNUQq+sA+EfmK6qh0KjuKvw753ECuaCFV8szVM=", zzafVar, i2, 62);
        this.zzj = view;
        this.zzi = activity;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzj == null) {
            return;
        }
        Boolean bool = (Boolean) zzkq.zzc().zza(zzlg.zzcx);
        boolean zBooleanValue = bool.booleanValue();
        Object[] objArr = (Object[]) this.zzf.invoke(null, this.zzj, this.zzi, bool);
        synchronized (this.zze) {
            try {
                this.zze.zzc(((Long) objArr[0]).longValue());
                this.zze.zze(((Long) objArr[1]).longValue());
                if (zBooleanValue) {
                    this.zze.zzd((String) objArr[2]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
