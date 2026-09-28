package com.google.ads.interactivemedia.v3.impl;

import android.os.Handler;
import android.os.Looper;
import com.google.ads.interactivemedia.v3.api.player.VideoProgressUpdate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
abstract class zzbp {
    private final List zzb = new ArrayList(1);
    private final Handler zza = new Handler(Looper.getMainLooper());

    public zzbp(long j2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        List list = this.zzb;
        VideoProgressUpdate videoProgressUpdateZza = zza();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbo) it.next()).zza(videoProgressUpdateZza);
        }
        this.zza.postDelayed(new Runnable() { // from class: com.google.ads.interactivemedia.v3.impl.zzbn
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzg();
            }
        }, 200L);
    }

    public abstract VideoProgressUpdate zza();

    public final void zzc(zzbo zzboVar) {
        this.zzb.add(zzboVar);
    }

    public final void zzd(zzbo zzboVar) {
        this.zzb.remove(zzboVar);
    }

    public final void zze() {
        this.zza.removeCallbacksAndMessages(null);
        zzg();
    }

    public final void zzf() {
        this.zza.removeCallbacksAndMessages(null);
    }
}
