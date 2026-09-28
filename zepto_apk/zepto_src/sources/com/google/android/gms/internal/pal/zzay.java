package com.google.android.gms.internal.pal;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes4.dex */
public final class zzay extends zzbg {

    /* renamed from: e, reason: collision with root package name */
    public final com.google.android.gms.internal.appset.zzr f37529e;

    public zzay(Handler handler, ExecutorService executorService, Context context) {
        com.google.android.gms.internal.appset.zzr zzrVar;
        try {
            zzrVar = new com.google.android.gms.internal.appset.zzr(context);
        } catch (NoClassDefFoundError | NoSuchMethodError e2) {
            Log.e("NonceGenerator", "Failed to contact the App Set SDK.", e2);
            zzrVar = null;
        }
        super(handler, executorService, zzagc.b(2L));
        this.f37529e = zzrVar;
    }

    @Override // com.google.android.gms.internal.pal.zzbg
    public final zzil a() {
        com.google.android.gms.internal.appset.zzr zzrVar = this.f37529e;
        zzif zzifVar = zzif.f37811a;
        if (zzrVar != null) {
            try {
                AppSetIdInfo appSetIdInfo = (AppSetIdInfo) Tasks.b(zzrVar.a(), com.google.ads.interactivemedia.pal.zzat.zzd.f37520a, TimeUnit.MILLISECONDS);
                appSetIdInfo.getClass();
                return new zziq(appSetIdInfo);
            } catch (InterruptedException | NoClassDefFoundError | NoSuchMethodError | ExecutionException | TimeoutException e2) {
                Log.e("NonceGenerator", "Failed to get the App Set ID.", e2);
            }
        }
        return zzifVar;
    }
}
