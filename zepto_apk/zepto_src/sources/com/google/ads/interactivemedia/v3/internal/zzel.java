package com.google.ads.interactivemedia.v3.internal;

import android.os.Build;
import com.google.ads.interactivemedia.v3.api.AdErrorEvent;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public final class zzel {
    private final Queue zza;
    private final com.google.ads.interactivemedia.v3.impl.zzba zzb;
    private final zzec zzc;
    private int zzd;
    private final zzfj zze;

    public zzel(com.google.ads.interactivemedia.v3.impl.zzba zzbaVar, zzec zzecVar) {
        zzfj zzfjVar = new zzfj();
        this.zza = new ConcurrentLinkedQueue();
        this.zzd = 1;
        this.zze = zzfjVar;
        this.zzb = zzbaVar;
        this.zzc = zzecVar;
    }

    private final void zzi(com.google.ads.interactivemedia.v3.impl.data.zzca zzcaVar) {
        JavaScriptMessage javaScriptMessage = new JavaScriptMessage(JavaScriptMessage.MsgChannel.adsLoader, JavaScriptMessage.MsgType.nativeInstrumentation, "*", zzcaVar);
        int i2 = this.zzd;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        if (i3 != 0) {
            if (i3 != 1) {
                return;
            }
            this.zzb.zzp(javaScriptMessage);
        } else if (this.zza.size() > 6) {
            this.zzd = 3;
        } else {
            this.zza.add(javaScriptMessage);
        }
    }

    public final void zza() {
        this.zzc.zzc();
    }

    public final void zzb(String str) {
        zzoy zzoyVarZza = this.zzc.zza(str);
        if (zzoyVarZza.zzd()) {
            Object objZza = zzoyVarZza.zza();
            com.google.ads.interactivemedia.v3.impl.data.zzbm zzbmVarBuilder = com.google.ads.interactivemedia.v3.impl.data.zzbn.builder();
            zzbmVarBuilder.model(Build.MODEL);
            zzbmVarBuilder.manufacturer(Build.MANUFACTURER);
            zzbmVarBuilder.sdkVersion("3.33.0");
            zzbmVarBuilder.androidVersion(Build.VERSION.RELEASE);
            zzeb zzebVar = (zzeb) objZza;
            zzbmVarBuilder.requestCounter(zzebVar.zzb.intValue());
            com.google.ads.interactivemedia.v3.impl.data.zzcc zzccVarCreate = com.google.ads.interactivemedia.v3.impl.data.zzcc.create(zzbmVarBuilder.build(), zzqf.zzk(zzebVar.zza), zzqf.zzk(this.zzc.zzb()));
            zzi(com.google.ads.interactivemedia.v3.impl.data.zzca.create(System.currentTimeMillis(), com.google.ads.interactivemedia.v3.impl.data.zzbx.EVENT_TIMESTAMP_TRACKER, com.google.ads.interactivemedia.v3.impl.data.zzbz.FLUSH_EVENT_TIMESTAMPS_INFO, zzccVarCreate));
            this.zzc.zzd(str);
        }
    }

    public final void zzc(AdErrorEvent adErrorEvent) {
        zzi(com.google.ads.interactivemedia.v3.impl.data.zzca.create(System.currentTimeMillis(), adErrorEvent));
    }

    public final void zzd(com.google.ads.interactivemedia.v3.impl.data.zzbx zzbxVar, com.google.ads.interactivemedia.v3.impl.data.zzbz zzbzVar, Exception exc) {
        zzi(com.google.ads.interactivemedia.v3.impl.data.zzca.create(System.currentTimeMillis(), zzbxVar, zzbzVar, exc));
    }

    public final void zze(zzta zztaVar, final com.google.ads.interactivemedia.v3.impl.data.zzby zzbyVar, zztb zztbVar, final String str) {
        final zzec zzecVar = this.zzc;
        zztaVar.zzm(new Runnable() { // from class: com.google.ads.interactivemedia.v3.internal.zzdz
            @Override // java.lang.Runnable
            public final void run() {
                zzecVar.zzf(zzbyVar, str);
            }
        }, zztbVar);
    }

    public final void zzf(com.google.ads.interactivemedia.v3.impl.data.zzby zzbyVar) {
        this.zzc.zze(zzbyVar);
    }

    public final void zzg(com.google.ads.interactivemedia.v3.impl.data.zzby zzbyVar, String str) {
        this.zzc.zzf(zzbyVar, str);
    }

    public final void zzh(boolean z) {
        if (!z) {
            this.zzd = 3;
            this.zza.clear();
            return;
        }
        this.zzd = 2;
        JavaScriptMessage javaScriptMessage = (JavaScriptMessage) this.zza.poll();
        while (javaScriptMessage != null) {
            this.zzb.zzp(javaScriptMessage);
            javaScriptMessage = (JavaScriptMessage) this.zza.poll();
        }
    }
}
