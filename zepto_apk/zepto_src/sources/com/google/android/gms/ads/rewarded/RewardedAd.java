package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbxv;
import com.google.android.gms.internal.ads.zzcao;

/* loaded from: classes4.dex */
public abstract class RewardedAd {
    public static void b(final Context context, final String str, final AdRequest adRequest, final RewardedAdLoadCallback rewardedAdLoadCallback) {
        Preconditions.checkNotNull(context, "Context cannot be null.");
        Preconditions.checkNotNull(str, "AdUnitId cannot be null.");
        Preconditions.checkNotNull(adRequest, "AdRequest cannot be null.");
        Preconditions.checkNotNull(rewardedAdLoadCallback, "LoadCallback cannot be null.");
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbgk.a(context);
        if (((Boolean) zzbii.f25165k.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.oc)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.rewarded.zzc
                    @Override // java.lang.Runnable
                    public final void run() {
                        RewardedAdLoadCallback rewardedAdLoadCallback2 = rewardedAdLoadCallback;
                        AdRequest adRequest2 = adRequest;
                        Context context2 = context;
                        try {
                            new zzcao(context2, str).d(adRequest2.f20997a, rewardedAdLoadCallback2);
                        } catch (IllegalStateException e2) {
                            zzbxv.c(context2).a("RewardedAd.load", e2);
                        }
                    }
                });
                return;
            }
        }
        zzo.a("Loading on UI thread");
        new zzcao(context, str).d(adRequest.f20997a, rewardedAdLoadCallback);
    }

    public abstract ResponseInfo a();

    public abstract void c(Activity activity);
}
