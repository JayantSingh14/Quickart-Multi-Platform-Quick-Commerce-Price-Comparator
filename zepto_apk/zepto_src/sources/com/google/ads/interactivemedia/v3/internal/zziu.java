package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class zziu extends zzjv {
    private static final zzjw zzi = new zzjw();
    private final Context zzj;

    public zziu(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3, Context context) {
        super(zzihVar, "LYoHKR17UvbUNibqKPKJklawQJNaw1zk7CnhZAC68YBTzC7x4MYQVXp9Sihs98Ok", "ngqbGKXcQCvq0ft27xRzOzNoEVN+ei+Vq2+CNx9QQMc=", zzafVar, i2, 29);
        this.zzj = context;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzn("E");
        AtomicReference atomicReferenceZza = zzi.zza(this.zzj.getPackageName());
        if (atomicReferenceZza.get() == null) {
            synchronized (atomicReferenceZza) {
                try {
                    if (atomicReferenceZza.get() == null) {
                        atomicReferenceZza.set((String) this.zzf.invoke(null, this.zzj));
                    }
                } finally {
                }
            }
        }
        String str = (String) atomicReferenceZza.get();
        synchronized (this.zze) {
            this.zze.zzn(zzfo.zza(str.getBytes(), true));
        }
    }
}
