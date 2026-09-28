package com.google.android.gms.ads.interstitial;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbqi;
import com.google.android.gms.internal.ads.zzbxv;

/* loaded from: classes4.dex */
public abstract class InterstitialAd {
    public static void b(final Context context, final String str, final AdRequest adRequest, final InterstitialAdLoadCallback interstitialAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkNotNull(interstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbgk.a(context);
        if (((Boolean) zzbii.f25163i.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.oc)).booleanValue()) {
                zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.interstitial.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        InterstitialAdLoadCallback interstitialAdLoadCallback2 = interstitialAdLoadCallback;
                        AdRequest adRequest2 = adRequest;
                        Context context2 = context;
                        try {
                            new zzbqi(context2, str).f(adRequest2.f20997a, interstitialAdLoadCallback2);
                        } catch (IllegalStateException e2) {
                            zzbxv.c(context2).a("InterstitialAd.load", e2);
                        }
                    }
                });
                return;
            }
        }
        new zzbqi(context, str).f(adRequest.f20997a, interstitialAdLoadCallback);
    }

    public abstract ResponseInfo a();

    public abstract void c(FullScreenContentCallback fullScreenContentCallback);

    public abstract void d(boolean z);

    public abstract void e(Activity activity);
}
