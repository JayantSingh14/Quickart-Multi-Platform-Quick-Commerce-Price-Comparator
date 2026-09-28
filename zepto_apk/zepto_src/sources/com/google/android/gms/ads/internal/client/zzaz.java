package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.OutOfContextTestingActivity;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.internal.ads.zzbkc;
import com.google.android.gms.internal.ads.zzblu;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbsv;
import com.google.android.gms.internal.ads.zzbsz;
import com.google.android.gms.internal.ads.zzbwr;
import com.google.android.gms.internal.ads.zzbwv;
import com.google.android.gms.internal.ads.zzbwy;
import com.google.android.gms.internal.ads.zzbxx;
import com.google.android.gms.internal.ads.zzcaf;
import com.google.android.gms.internal.ads.zzccj;

/* loaded from: classes4.dex */
public final class zzaz {

    /* renamed from: a, reason: collision with root package name */
    public final zzk f21132a;

    /* renamed from: b, reason: collision with root package name */
    public final zzi f21133b;

    /* renamed from: c, reason: collision with root package name */
    public final zzff f21134c;

    /* renamed from: d, reason: collision with root package name */
    public final zzblu f21135d;

    /* renamed from: e, reason: collision with root package name */
    public final zzbwv f21136e;

    /* renamed from: f, reason: collision with root package name */
    public zzbxx f21137f;

    /* renamed from: g, reason: collision with root package name */
    public final zzl f21138g;

    public zzaz(zzk zzkVar, zzi zziVar, zzff zzffVar, zzblu zzbluVar, zzbwv zzbwvVar, zzblv zzblvVar, zzl zzlVar) {
        this.f21132a = zzkVar;
        this.f21133b = zziVar;
        this.f21134c = zzffVar;
        this.f21135d = zzbluVar;
        this.f21136e = zzbwvVar;
        this.f21138g = zzlVar;
    }

    public static void k(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzbb zzbbVar = zzbb.f21141g;
        zzbbVar.f21142a.k(context, zzbbVar.f21145d.f21400a, bundle);
    }

    public final zzbx a(Context context, zzr zzrVar, String str, zzbsz zzbszVar) {
        return (zzbx) new zzam(this, context, zzrVar, str, zzbszVar).d(context, false);
    }

    public final zzbx b(Context context, zzr zzrVar, String str, zzbsv zzbsvVar) {
        return (zzbx) new zzao(this, context, zzrVar, str, zzbsvVar).d(context, false);
    }

    public final zzbt c(Context context, String str, zzbsv zzbsvVar) {
        return (zzbt) new zzaq(this, context, str, zzbsvVar).d(context, false);
    }

    public final zzck d(ReactApplicationContext reactApplicationContext, zzbsv zzbsvVar) {
        return (zzck) new zzas(this, reactApplicationContext, zzbsvVar).d(reactApplicationContext, false);
    }

    public final zzbkc e(Context context, NativeAdView nativeAdView, FrameLayout frameLayout) {
        return (zzbkc) new zzaw(this, nativeAdView, frameLayout, context).d(context, false);
    }

    public final zzcaf f(Context context, String str, zzbsv zzbsvVar) {
        return (zzcaf) new zzaa(this, context, str, zzbsvVar).d(context, false);
    }

    public final zzbwy g(AdActivity adActivity) {
        zzac zzacVar = new zzac(this, adActivity);
        Intent intent = adActivity.getIntent();
        boolean booleanExtra = false;
        if (intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            booleanExtra = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        } else {
            com.google.android.gms.ads.internal.util.client.zzo.c("useClientJar flag not found in activity intent extras.");
        }
        return (zzbwy) zzacVar.d(adActivity, booleanExtra);
    }

    public final zzdw h(OutOfContextTestingActivity outOfContextTestingActivity, zzbsv zzbsvVar) {
        return (zzdw) new zzae(this, outOfContextTestingActivity, zzbsvVar).d(outOfContextTestingActivity, false);
    }

    public final zzccj i(Context context, zzbsv zzbsvVar) {
        return (zzccj) new zzag(this, context, zzbsvVar).d(context, false);
    }

    public final zzbwr j(Context context, zzbsv zzbsvVar) {
        return (zzbwr) new zzai(this, context, zzbsvVar).d(context, false);
    }
}
