package com.google.ads.interactivemedia.v3.internal;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class zzdl {
    private final BlockingQueue zza;
    private final ThreadPoolExecutor zzb;
    private final ArrayDeque zzc = new ArrayDeque();
    private zzdk zzd = null;

    public zzdl() {
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        this.zza = linkedBlockingQueue;
        this.zzb = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

    private final void zzc() {
        zzdk zzdkVar = (zzdk) this.zzc.poll();
        this.zzd = zzdkVar;
        if (zzdkVar != null) {
            zzdkVar.executeOnExecutor(this.zzb, new Object[0]);
        }
    }

    public final void zza(zzdk zzdkVar) {
        this.zzd = null;
        zzc();
    }

    public final void zzb(zzdk zzdkVar) {
        zzdkVar.zzb(this);
        this.zzc.add(zzdkVar);
        if (this.zzd == null) {
            zzc();
        }
    }
}
