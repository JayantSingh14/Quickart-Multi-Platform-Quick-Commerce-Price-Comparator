package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzcaz extends RewardedInterstitialAd {

    /* renamed from: a, reason: collision with root package name */
    public final zzcaf f25802a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f25803b;

    /* renamed from: c, reason: collision with root package name */
    public final zzcax f25804c;

    /* renamed from: d, reason: collision with root package name */
    public final long f25805d = System.currentTimeMillis();

    public zzcaz(Context context, String str) {
        new AtomicLong();
        this.f25803b = context.getApplicationContext();
        this.f25802a = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21143b.f(context, str, new zzbsv());
        this.f25804c = new zzcax();
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final ResponseInfo a() {
        com.google.android.gms.ads.internal.client.zzea zzeaVarZzm = null;
        try {
            zzcaf zzcafVar = this.f25802a;
            if (zzcafVar != null) {
                zzeaVarZzm = zzcafVar.zzm();
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
        return new ResponseInfo(zzeaVarZzm);
    }

    @Override // com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd
    public final void c(Activity activity) {
        zzebe zzebeVar = zzebe.f28994a;
        zzcax zzcaxVar = this.f25804c;
        zzcaxVar.f25799a = zzebeVar;
        try {
            zzcaf zzcafVar = this.f25802a;
            if (zzcafVar != null) {
                zzcafVar.q5(zzcaxVar);
                zzcafVar.N(new ObjectWrapper(activity));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public final void d(com.google.android.gms.ads.internal.client.zzek zzekVar, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzcaf zzcafVar = this.f25802a;
            if (zzcafVar != null) {
                zzekVar.n = this.f25805d;
                zzcafVar.a5(com.google.android.gms.ads.internal.client.zzq.a(this.f25803b, zzekVar), new zzcay(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }
}
