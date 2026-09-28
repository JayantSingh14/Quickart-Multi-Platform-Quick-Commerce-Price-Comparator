package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* loaded from: classes4.dex */
public final class zzbvr implements MediationInterstitialAdapter {

    /* renamed from: a, reason: collision with root package name */
    public Activity f25603a;

    /* renamed from: b, reason: collision with root package name */
    public MediationInterstitialListener f25604b;

    /* renamed from: c, reason: collision with root package name */
    public Uri f25605c;

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void onDestroy() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void onPause() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter, com.google.android.gms.ads.mediation.MediationNativeAdapter
    public final void onResume() {
        com.google.android.gms.ads.internal.util.client.zzo.a("Resuming AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.f25604b = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Listener not set for mediation. Returning.");
            return;
        }
        if (!(context instanceof Activity)) {
            com.google.android.gms.ads.internal.util.client.zzo.f("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.f25604b.c();
            return;
        }
        if (!zzbhl.a(context)) {
            com.google.android.gms.ads.internal.util.client.zzo.f("Default browser does not support custom tabs. Bailing out.");
            this.f25604b.c();
            return;
        }
        String string = bundle.getString("tab_url");
        if (TextUtils.isEmpty(string)) {
            com.google.android.gms.ads.internal.util.client.zzo.f("The tab_url retrieved from mediation metadata is empty. Bailing out.");
            this.f25604b.c();
        } else {
            this.f25603a = (Activity) context;
            this.f25605c = Uri.parse(string);
            this.f25604b.p();
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        CustomTabsIntent customTabsIntentA = new CustomTabsIntent.Builder().a();
        customTabsIntentA.f1341a.setData(this.f25605c);
        com.google.android.gms.ads.internal.util.zzs.f21608l.post(new zzbvq(this, new AdOverlayInfoParcel(new com.google.android.gms.ads.internal.overlay.zzc(customTabsIntentA.f1341a, null), null, new zzbvp(this), null, new VersionInfoParcel(0, 0, false, false), null, null, "")));
        com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
        zzccz zzcczVar = zztVar.f21684h.f25943m;
        zzcczVar.getClass();
        long jCurrentTimeMillis = zztVar.f21687k.currentTimeMillis();
        synchronized (zzcczVar.f25920a) {
            try {
                if (zzcczVar.f25922c == 3) {
                    if (zzcczVar.f25921b + ((Long) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.F6)).longValue() <= jCurrentTimeMillis) {
                        zzcczVar.f25922c = 1;
                    }
                }
            } finally {
            }
        }
        long jCurrentTimeMillis2 = zztVar.f21687k.currentTimeMillis();
        synchronized (zzcczVar.f25920a) {
            try {
                if (zzcczVar.f25922c != 2) {
                    return;
                }
                zzcczVar.f25922c = 3;
                if (zzcczVar.f25922c == 3) {
                    zzcczVar.f25921b = jCurrentTimeMillis2;
                }
            } finally {
            }
        }
    }
}
