package com.google.android.gms.ads.rewardedinterstitial;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbxv;
import com.google.android.gms.internal.ads.zzcaz;

/* loaded from: classes4.dex */
public abstract class RewardedInterstitialAd {
    public static void b(final Context context, final String str, final AdRequest adRequest, final RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedInterstitialAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbgk.a(context);
        if (((Boolean) zzbii.f25165k.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.oc)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.rewardedinterstitial.zzb
                    @Override // java.lang.Runnable
                    public final void run() {
                        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback2 = rewardedInterstitialAdLoadCallback;
                        AdRequest adRequest2 = adRequest;
                        Context context2 = context;
                        try {
                            new zzcaz(context2, str).d(adRequest2.f20997a, rewardedInterstitialAdLoadCallback2);
                        } catch (IllegalStateException e2) {
                            zzbxv.c(context2).a("RewardedInterstitialAd.load", e2);
                        }
                    }
                });
                return;
            }
        }
        new zzcaz(context, str).d(adRequest.f20997a, rewardedInterstitialAdLoadCallback);
    }

    public abstract ResponseInfo a();

    public abstract void c(Activity activity);
}
