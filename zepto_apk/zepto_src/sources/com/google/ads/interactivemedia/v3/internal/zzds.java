package com.google.ads.interactivemedia.v3.internal;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public final class zzds {
    private final zzma zza;
    private final zzel zzb;
    private final int zzc;

    public zzds(zzdr zzdrVar) {
        this.zza = new zzmh(zzdrVar.zza);
        this.zzb = zzdrVar.zzc;
        this.zzc = zzdrVar.zzb;
    }

    @WorkerThread
    public final String zza(@Nullable com.google.ads.interactivemedia.v3.impl.zzal zzalVar, String str) {
        if (this.zzc <= 0) {
            zzeo.zzc("AdsIdentityTokenLoader: invalid parameter for gksTimeoutMs");
            return "";
        }
        this.zzb.zzg(com.google.ads.interactivemedia.v3.impl.data.zzby.EVENT_NATIVE_SIGNAL_ADS_IDENTITY_TOKEN_START, str);
        try {
            final Bundle bundle = new Bundle();
            if (zzalVar != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("x-afma-token-requester-type", zzalVar.toString());
                bundle.putBundle("extra_headers", bundle2);
            }
            zzma zzmaVar = this.zza;
            final zzmh zzmhVar = (zzmh) zzmaVar;
            return (String) Tasks.b(((zzmh) zzmaVar).doRead(TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(zzoj.zza).run(new RemoteCall() { // from class: com.google.ads.interactivemedia.v3.internal.zzmd
                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) throws RemoteException {
                    ((zzlv) ((zzmi) obj).getService()).zzf(bundle, new zzmf(zzmhVar, (TaskCompletionSource) obj2));
                }
            }).build()), this.zzc, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            e = e2;
            this.zzb.zzd(com.google.ads.interactivemedia.v3.impl.data.zzbx.ADS_IDENTITY_TOKEN_LOADER, com.google.ads.interactivemedia.v3.impl.data.zzbz.GET_ADSIDENTITY_TOKEN, e);
            this.zzb.zzg(com.google.ads.interactivemedia.v3.impl.data.zzby.EVENT_NATIVE_SIGNAL_ADS_IDENTITY_TOKEN_READY, str);
            return "";
        } catch (ExecutionException e3) {
            e = e3;
            this.zzb.zzd(com.google.ads.interactivemedia.v3.impl.data.zzbx.ADS_IDENTITY_TOKEN_LOADER, com.google.ads.interactivemedia.v3.impl.data.zzbz.GET_ADSIDENTITY_TOKEN, e);
            this.zzb.zzg(com.google.ads.interactivemedia.v3.impl.data.zzby.EVENT_NATIVE_SIGNAL_ADS_IDENTITY_TOKEN_READY, str);
            return "";
        } catch (TimeoutException e4) {
            e = e4;
            this.zzb.zzd(com.google.ads.interactivemedia.v3.impl.data.zzbx.ADS_IDENTITY_TOKEN_LOADER, com.google.ads.interactivemedia.v3.impl.data.zzbz.GET_ADSIDENTITY_TOKEN, e);
            this.zzb.zzg(com.google.ads.interactivemedia.v3.impl.data.zzby.EVENT_NATIVE_SIGNAL_ADS_IDENTITY_TOKEN_READY, str);
            return "";
        }
    }
}
