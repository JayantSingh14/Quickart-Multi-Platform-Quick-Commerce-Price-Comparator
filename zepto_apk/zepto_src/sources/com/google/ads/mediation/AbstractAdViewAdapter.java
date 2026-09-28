package com.google.ads.mediation;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbt;
import com.google.android.gms.ads.internal.client.zzed;
import com.google.android.gms.ads.internal.client.zzej;
import com.google.android.gms.ads.internal.client.zzg;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.internal.ads.zzbjn;
import com.google.android.gms.internal.ads.zzbly;
import com.google.android.gms.internal.ads.zzbmb;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter, OnImmersiveModeUpdatedListener, com.google.android.gms.ads.mediation.zza {

    @NonNull
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    private AdLoader adLoader;

    @NonNull
    protected AdView mAdView;

    @NonNull
    protected InterstitialAd mInterstitialAd;

    public AdRequest buildAdRequest(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Set setG = mediationAdRequest.g();
        zzej zzejVar = builder.f20979a;
        if (setG != null) {
            Iterator it = setG.iterator();
            while (it.hasNext()) {
                zzejVar.f21167a.add((String) it.next());
            }
        }
        if (mediationAdRequest.d()) {
            zzf zzfVar = zzbb.f21141g.f21142a;
            zzejVar.f21170d.add(zzf.c(context));
        }
        if (mediationAdRequest.b() != -1) {
            zzejVar.f21177k = mediationAdRequest.b() != 1 ? 0 : 1;
        }
        zzejVar.f21178l = mediationAdRequest.c();
        builder.c(buildExtrasBundle(bundle, bundle2));
        return new AdRequest(builder);
    }

    public abstract Bundle buildExtrasBundle(Bundle bundle, Bundle bundle2);

    @NonNull
    public String getAdUnitId(@NonNull Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    @NonNull
    public View getBannerView() {
        return this.mAdView;
    }

    @VisibleForTesting
    public InterstitialAd getInterstitialAd() {
        return this.mInterstitialAd;
    }

    @Override // com.google.android.gms.ads.mediation.zza
    @Nullable
    public zzed getVideoController() {
        zzed zzedVar;
        AdView adView = this.mAdView;
        if (adView == null) {
            return null;
        }
        VideoController videoController = adView.f21016a.f21198c;
        synchronized (videoController.f21030a) {
            zzedVar = videoController.f21031b;
        }
        return zzedVar;
    }

    @VisibleForTesting
    public AdLoader.Builder newAdLoader(Context context, String str) {
        return new AdLoader.Builder(context, str);
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, com.google.android.gms.ads.mediation.MediationAdapter, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onDestroy() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.a();
            this.mAdView = null;
        }
        if (this.mInterstitialAd != null) {
            this.mInterstitialAd = null;
        }
        if (this.adLoader != null) {
            this.adLoader = null;
        }
    }

    @Override // com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener
    public void onImmersiveModeUpdated(boolean z) {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.d(z);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, com.google.android.gms.ads.mediation.MediationAdapter, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onPause() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.c();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter, com.google.android.gms.ads.mediation.MediationAdapter, com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void onResume() {
        AdView adView = this.mAdView;
        if (adView != null) {
            adView.d();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAdapter
    public void requestBannerAd(@NonNull Context context, @NonNull MediationBannerListener mediationBannerListener, @NonNull Bundle bundle, @NonNull AdSize adSize, @NonNull MediationAdRequest mediationAdRequest, @NonNull Bundle bundle2) {
        AdView adView = new AdView(context);
        this.mAdView = adView;
        adView.setAdSize(new AdSize(adSize.f21004a, adSize.f21005b));
        this.mAdView.setAdUnitId(getAdUnitId(bundle));
        this.mAdView.setAdListener(new zzb(this, mediationBannerListener));
        this.mAdView.b(buildAdRequest(context, mediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void requestInterstitialAd(@NonNull Context context, @NonNull MediationInterstitialListener mediationInterstitialListener, @NonNull Bundle bundle, @NonNull MediationAdRequest mediationAdRequest, @NonNull Bundle bundle2) {
        InterstitialAd.b(context, getAdUnitId(bundle), buildAdRequest(context, mediationAdRequest, bundle2, bundle), new zzc(this, mediationInterstitialListener));
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeAdapter
    public void requestNativeAd(@NonNull Context context, @NonNull MediationNativeListener mediationNativeListener, @NonNull Bundle bundle, @NonNull NativeMediationAdRequest nativeMediationAdRequest, @NonNull Bundle bundle2) {
        zze zzeVar = new zze(this, mediationNativeListener);
        AdLoader.Builder builderNewAdLoader = newAdLoader(context, bundle.getString(AD_UNIT_ID_PARAMETER));
        builderNewAdLoader.getClass();
        zzbt zzbtVar = builderNewAdLoader.f20996b;
        try {
            zzbtVar.S8(new zzg(zzeVar));
        } catch (RemoteException e2) {
            zzo.g("Failed to set AdListener.", e2);
        }
        try {
            zzbtVar.P8(new zzbjn(nativeMediationAdRequest.e()));
        } catch (RemoteException e3) {
            zzo.g("Failed to specify native ad options", e3);
        }
        builderNewAdLoader.b(nativeMediationAdRequest.a());
        if (nativeMediationAdRequest.f()) {
            try {
                zzbtVar.ob(new zzbmb(zzeVar));
            } catch (RemoteException e4) {
                zzo.g("Failed to add google native ad listener", e4);
            }
        }
        if (nativeMediationAdRequest.zza()) {
            for (String str : nativeMediationAdRequest.zzb().keySet()) {
                zzbly zzblyVar = new zzbly(zzeVar, true != ((Boolean) nativeMediationAdRequest.zzb().get(str)).booleanValue() ? null : zzeVar);
                try {
                    zzbtVar.i3(str, zzblyVar.a(), zzblyVar.b());
                } catch (RemoteException e5) {
                    zzo.g("Failed to add custom template ad listener", e5);
                }
            }
        }
        AdLoader adLoaderA = builderNewAdLoader.a();
        this.adLoader = adLoaderA;
        adLoaderA.a(buildAdRequest(context, nativeMediationAdRequest, bundle2, bundle));
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public void showInterstitial() {
        InterstitialAd interstitialAd = this.mInterstitialAd;
        if (interstitialAd != null) {
            interstitialAd.e(null);
        }
    }
}
