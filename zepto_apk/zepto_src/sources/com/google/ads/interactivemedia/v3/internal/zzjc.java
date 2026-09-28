package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* loaded from: classes3.dex */
public final class zzjc extends zzjv {
    private final Map zzi;
    private final View zzj;
    private final Context zzk;

    public zzjc(zzih zzihVar, String str, String str2, zzaf zzafVar, int i2, int i3, Map map, View view, Context context) {
        super(zzihVar, "SKSJAjN3UKeguXyEasCGg04d/yJuUN8XZYgactMp4rfMtHcIJcD0mydl5RKvI49M", "lnMUlT0qopStslq/RfZHkyvg0xAUTVuMPsMot4SEaYA=", zzafVar, i2, 85);
        this.zzi = map;
        this.zzj = view;
        this.zzk = context;
    }

    private final long zzc(int i2) {
        Map map = this.zzi;
        Integer numValueOf = Integer.valueOf(i2);
        if (map.containsKey(numValueOf)) {
            return ((Long) this.zzi.get(numValueOf)).longValue();
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzjv
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = {zzc(1), zzc(2)};
        Context contextZzb = this.zzk;
        if (contextZzb == null) {
            contextZzb = this.zzb.zzb();
        }
        long[] jArr2 = (long[]) this.zzf.invoke(null, jArr, contextZzb, this.zzj);
        long j2 = jArr2[0];
        this.zzi.put(1, Long.valueOf(jArr2[1]));
        long j3 = jArr2[2];
        this.zzi.put(2, Long.valueOf(jArr2[3]));
        synchronized (this.zze) {
            this.zze.zzv(j2);
            this.zze.zzu(j3);
        }
    }
}
