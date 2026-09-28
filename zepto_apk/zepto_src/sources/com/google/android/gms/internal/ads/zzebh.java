package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzebh extends com.google.android.gms.ads.internal.client.zzdv {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f28998a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Context f28999b;

    /* renamed from: c, reason: collision with root package name */
    public final WeakReference f29000c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeav f29001d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgyw f29002e;

    /* renamed from: f, reason: collision with root package name */
    public zzeak f29003f;

    public zzebh(Context context, WeakReference weakReference, zzeav zzeavVar, zzgyw zzgywVar) {
        this.f28999b = context;
        this.f29000c = weakReference;
        this.f29001d = zzeavVar;
        this.f29002e = zzgywVar;
    }

    public static String bc(Object obj) {
        ResponseInfo responseInfoC;
        com.google.android.gms.ads.internal.client.zzea zzeaVar;
        if (obj instanceof LoadAdError) {
            responseInfoC = ((LoadAdError) obj).f21017e;
        } else if (obj instanceof AppOpenAd) {
            responseInfoC = ((AppOpenAd) obj).a();
        } else if (obj instanceof InterstitialAd) {
            responseInfoC = ((InterstitialAd) obj).a();
        } else if (obj instanceof RewardedAd) {
            responseInfoC = ((RewardedAd) obj).a();
        } else if (obj instanceof RewardedInterstitialAd) {
            responseInfoC = ((RewardedInterstitialAd) obj).a();
        } else if (obj instanceof AdView) {
            responseInfoC = ((AdView) obj).getResponseInfo();
        } else {
            if (!(obj instanceof NativeAd)) {
                return "";
            }
            responseInfoC = ((NativeAd) obj).c();
        }
        if (responseInfoC == null || (zzeaVar = responseInfoC.f21027a) == null) {
            return "";
        }
        try {
            return zzeaVar.zzj();
        } catch (RemoteException unused) {
            return "";
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdw
    public final void R4(String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        Context context = (Context) ObjectWrapper.z0(iObjectWrapper);
        ViewGroup viewGroup = (ViewGroup) ObjectWrapper.z0(iObjectWrapper2);
        if (context == null || viewGroup == null) {
            return;
        }
        HashMap map = this.f28998a;
        Object obj = map.get(str);
        if (obj != null) {
            map.remove(str);
        }
        if (obj instanceof AdView) {
            AdView adView = (AdView) obj;
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setTag("layout");
            zzebj.b(linearLayout, -1, -1);
            linearLayout.setGravity(17);
            linearLayout.addView(adView);
            adView.setTag("ad_view");
            viewGroup.addView(linearLayout);
            return;
        }
        if (obj instanceof NativeAd) {
            NativeAd nativeAd = (NativeAd) obj;
            NativeAdView nativeAdView = new NativeAdView(context);
            nativeAdView.setTag("ad_view_tag");
            zzebj.b(nativeAdView, -1, -1);
            viewGroup.addView(nativeAdView);
            LinearLayout linearLayout2 = new LinearLayout(context);
            linearLayout2.setTag("layout_tag");
            linearLayout2.setOrientation(1);
            zzebj.b(linearLayout2, -1, -1);
            linearLayout2.setBackgroundColor(-1);
            nativeAdView.addView(linearLayout2);
            Resources resourcesC = com.google.android.gms.ads.internal.zzt.C.f21684h.c();
            linearLayout2.addView(zzebj.a(context, resourcesC == null ? "Headline" : resourcesC.getString(R.string.native_headline), android.R.style.TextAppearance.Small, -9210245, 0.0f, "headline_header_tag"));
            String strB = nativeAd.b();
            if (strB == null) {
                strB = "";
            }
            View viewA = zzebj.a(context, strB, android.R.style.TextAppearance.Medium, -16777216, 12.0f, "headline_tag");
            nativeAdView.setHeadlineView(viewA);
            linearLayout2.addView(viewA);
            linearLayout2.addView(zzebj.a(context, resourcesC == null ? "Body" : resourcesC.getString(R.string.native_body), android.R.style.TextAppearance.Small, -9210245, 0.0f, "body_header_tag"));
            String strA = nativeAd.a();
            if (strA == null) {
                strA = "";
            }
            View viewA2 = zzebj.a(context, strA, android.R.style.TextAppearance.Medium, -16777216, 12.0f, "body_tag");
            nativeAdView.setBodyView(viewA2);
            linearLayout2.addView(viewA2);
            linearLayout2.addView(zzebj.a(context, resourcesC == null ? "Media View" : resourcesC.getString(R.string.native_media_view), android.R.style.TextAppearance.Small, -9210245, 0.0f, "media_view_header_tag"));
            MediaView mediaView = new MediaView(context);
            mediaView.setTag("media_view_tag");
            nativeAdView.setMediaView(mediaView);
            linearLayout2.addView(mediaView);
            nativeAdView.setNativeAd(nativeAd);
        }
    }

    public final synchronized void Xb(Object obj, String str) {
        this.f28998a.put(str, obj);
        Yb(bc(obj));
    }

    public final synchronized void Yb(String str) {
        try {
            zzcdt zzcdtVarD = this.f29003f.d(str);
            zzebc zzebcVar = new zzebc(this);
            zzcdtVarD.q(new zzgyk(zzcdtVarD, zzebcVar), this.f29002e);
        } catch (NullPointerException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("OutOfContextTester.setAdAsOutOfContext", e2);
            this.f29001d.c();
        }
    }

    public final synchronized void Zb(String str) {
        try {
            zzcdt zzcdtVarD = this.f29003f.d(str);
            zzebd zzebdVar = new zzebd(this);
            zzcdtVarD.q(new zzgyk(zzcdtVarD, zzebdVar), this.f29002e);
        } catch (NullPointerException e2) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.d("OutOfContextTester.setAdAsShown", e2);
            this.f29001d.c();
        }
    }

    public final Context ac() {
        Context context = (Context) this.f29000c.get();
        return context == null ? this.f28999b : context;
    }
}
