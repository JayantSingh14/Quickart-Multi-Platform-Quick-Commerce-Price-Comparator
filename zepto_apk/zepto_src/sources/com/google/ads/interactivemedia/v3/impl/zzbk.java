package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.google.ads.interactivemedia.v3.impl.JavaScriptMessage;
import com.google.ads.interactivemedia.v3.impl.data.zzcj;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.ads.interactivemedia.v3.internal.zzeo;
import com.google.ads.interactivemedia.v3.internal.zzsr;
import com.google.ads.interactivemedia.v3.internal.zztb;
import com.google.ads.interactivemedia.v3.internal.zztg;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
final class zzbk {
    private final zzbi zza;
    private final zzba zzb;
    private final zztb zzc;

    @VisibleForTesting
    public zzbk(Context context, zzba zzbaVar, ExecutorService executorService, zzbi zzbiVar) {
        this.zzc = zztg.zza(executorService);
        this.zza = zzbiVar;
        this.zzb = zzbaVar;
    }

    public final /* synthetic */ zzck zzb(zzcj zzcjVar) throws Exception {
        return this.zza.zza(zzcjVar);
    }

    public final void zzc(JavaScriptMessage.MsgType msgType, String str, final zzcj zzcjVar) {
        JavaScriptMessage.MsgType msgType2 = JavaScriptMessage.MsgType.activate;
        if (msgType.ordinal() != 35) {
            zzeo.zzc("Unexpected network request of type".concat(String.valueOf(msgType)));
        } else {
            zzsr.zzc(this.zzc.zza(new Callable() { // from class: com.google.ads.interactivemedia.v3.impl.zzbe
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.zzb(zzcjVar);
                }
            }), new zzbf(this, str), this.zzc);
        }
    }
}
