package com.google.ads.interactivemedia.v3.impl;

import android.content.Context;
import android.os.RemoteException;
import com.google.ads.interactivemedia.v3.impl.data.zzci;
import com.google.ads.interactivemedia.v3.impl.data.zzcj;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.ads.interactivemedia.v3.internal.zzma;
import com.google.ads.interactivemedia.v3.internal.zzmb;
import com.google.ads.interactivemedia.v3.internal.zzmh;
import com.google.ads.interactivemedia.v3.internal.zzoj;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
final class zzbj implements zzbi {
    private final zzma zza;
    private final com.google.ads.interactivemedia.v3.impl.data.zzbv zzb;

    public zzbj(Context context, com.google.ads.interactivemedia.v3.impl.data.zzbv zzbvVar) {
        this.zza = new zzmh(context);
        this.zzb = zzbvVar;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.zzbi
    public final zzck zza(zzcj zzcjVar) {
        Task taskDoRead;
        try {
            zzci zzciVarRequestType = zzcjVar.requestType();
            zzci zzciVar = zzci.GET;
            final int i2 = zzciVarRequestType == zzciVar ? 0 : 1;
            final String strUrl = zzcjVar.url();
            final String strContent = zzcjVar.content();
            if (strUrl != null && (zzciVarRequestType == zzciVar || strContent != null)) {
                zzma zzmaVar = this.zza;
                if (this.zzb.isLimitedAdTracking()) {
                    taskDoRead = Tasks.d(new zzmb(8));
                } else {
                    final zzmh zzmhVar = (zzmh) zzmaVar;
                    taskDoRead = ((zzmh) zzmaVar).doRead(TaskApiCall.builder().setFeatures(zzoj.zzb).setAutoResolveMissingFeatures(false).run(new RemoteCall() { // from class: com.google.ads.interactivemedia.v3.internal.zzmc
                        @Override // com.google.android.gms.common.api.internal.RemoteCall
                        public final void accept(Object obj, Object obj2) throws RemoteException {
                            ((zzlv) ((zzmi) obj).getService()).zze(new zzlw(strUrl, i2, strContent), new zzmg(zzmhVar, (TaskCompletionSource) obj2));
                        }
                    }).build());
                }
                return zzck.forResponse(zzcjVar.id(), (String) Tasks.b(taskDoRead, zzcjVar.connectionTimeoutMs() + zzcjVar.readTimeoutMs(), TimeUnit.MILLISECONDS));
            }
            return zzck.forError(zzcjVar.id(), 100);
        } catch (InterruptedException | TimeoutException unused) {
            return zzck.forError(zzcjVar.id(), 101);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof zzmb) {
                return zzck.forError(zzcjVar.id(), ((zzmb) cause).zza());
            }
            return cause instanceof ApiException ? zzck.forError(zzcjVar.id(), 102) : zzck.forError(zzcjVar.id(), 100);
        }
    }
}
