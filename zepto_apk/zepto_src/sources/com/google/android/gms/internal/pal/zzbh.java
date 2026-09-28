package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public final class zzbh extends zzbg {

    /* renamed from: e, reason: collision with root package name */
    public final zzhc f37540e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.ads.interactivemedia.pal.zzx f37541f;

    public zzbh(Handler handler, ExecutorService executorService, Context context, com.google.ads.interactivemedia.pal.zzx zzxVar) {
        zzhc zzhcVar = new zzhc(context, zzhc.f37786a, null, GoogleApi.Settings.DEFAULT_SETTINGS);
        super(handler, executorService, zzagc.b(2L));
        this.f37540e = zzhcVar;
        this.f37541f = zzxVar;
    }

    @Override // com.google.android.gms.internal.pal.zzbg
    public final zzil a() {
        zzif zzifVar = zzif.f37811a;
        com.google.ads.interactivemedia.pal.zzx zzxVar = this.f37541f;
        final Bundle bundle = new Bundle();
        try {
            final zzhc zzhcVar = this.f37540e;
            String str = (String) Tasks.b(zzhcVar.doRead(TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(zzie.f37809a).run(new RemoteCall(zzhcVar, bundle) { // from class: com.google.android.gms.internal.pal.zzgz

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Bundle f37784a;

                {
                    this.f37784a = bundle;
                }

                @Override // com.google.android.gms.common.api.internal.RemoteCall
                public final void accept(Object obj, Object obj2) {
                    ((zzgw) ((zzhd) obj).getService()).ia(this.f37784a, new zzhb((TaskCompletionSource) obj2));
                }
            }).build()), 5L, TimeUnit.SECONDS);
            str.getClass();
            return new zziq(str);
        } catch (InterruptedException | TimeoutException unused) {
            zzxVar.zza(2);
            return zzifVar;
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof zzgy) {
                Log.d("NonceGenerator", "SignalSdk Error code: " + ((zzgy) cause).f37783a);
                zzxVar.zza(3);
            }
            return zzifVar;
        }
    }
}
