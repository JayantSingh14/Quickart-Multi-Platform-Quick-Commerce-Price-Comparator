package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbvl extends zzbux {

    /* renamed from: b, reason: collision with root package name */
    public final RtbAdapter f25596b;

    public zzbvl(RtbAdapter rtbAdapter) {
        this.f25596b = rtbAdapter;
    }

    public static final void Yb(String str) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.f("Server parameters: ".concat(String.valueOf(str)));
        try {
            new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle = new Bundle();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            }
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            throw new RemoteException();
        }
    }

    public static final void Zb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (zzmVar.f21259f) {
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        com.google.android.gms.ads.internal.util.client.zzf.r();
    }

    public static final void ac(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) throws JSONException {
        String str2 = zzmVar.u;
        try {
            new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0057  */
    @Override // com.google.android.gms.internal.ads.zzbuy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A3(com.google.android.gms.dynamic.IObjectWrapper r3, java.lang.String r4, android.os.Bundle r5, android.os.Bundle r6, com.google.android.gms.ads.internal.client.zzr r7, com.google.android.gms.internal.ads.zzbvb r8) throws android.os.RemoteException {
        /*
            r2 = this;
            com.google.android.gms.internal.ads.zzbvj r5 = new com.google.android.gms.internal.ads.zzbvj     // Catch: java.lang.Throwable -> L77
            r5.<init>(r2, r8)     // Catch: java.lang.Throwable -> L77
            com.google.android.gms.ads.mediation.rtb.RtbAdapter r6 = r2.f25596b     // Catch: java.lang.Throwable -> L77
            com.google.android.gms.ads.mediation.MediationConfiguration r8 = new com.google.android.gms.ads.mediation.MediationConfiguration     // Catch: java.lang.Throwable -> L77
            int r0 = r4.hashCode()     // Catch: java.lang.Throwable -> L77
            switch(r0) {
                case -1396342996: goto L4d;
                case -1052618729: goto L43;
                case -239580146: goto L39;
                case 604727084: goto L2f;
                case 1167692200: goto L25;
                case 1778294298: goto L1b;
                case 1911491517: goto L11;
                default: goto L10;
            }
        L10:
            goto L57
        L11:
            java.lang.String r0 = "rewarded_interstitial"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L57
            r4 = 3
            goto L58
        L1b:
            java.lang.String r0 = "app_open_ad"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L57
            r4 = 6
            goto L58
        L25:
            java.lang.String r0 = "app_open"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L57
            r4 = 5
            goto L58
        L2f:
            java.lang.String r0 = "interstitial"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L57
            r4 = 1
            goto L58
        L39:
            java.lang.String r0 = "rewarded"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L57
            r4 = 2
            goto L58
        L43:
            java.lang.String r0 = "native"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L57
            r4 = 4
            goto L58
        L4d:
            java.lang.String r0 = "banner"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L57
            r4 = 0
            goto L58
        L57:
            r4 = -1
        L58:
            switch(r4) {
                case 0: goto L79;
                case 1: goto L79;
                case 2: goto L79;
                case 3: goto L79;
                case 4: goto L79;
                case 5: goto L79;
                case 6: goto L5c;
                default: goto L5b;
            }
        L5b:
            goto L6f
        L5c:
            com.google.android.gms.internal.ads.zzbgb r4 = com.google.android.gms.internal.ads.zzbgk.Wc     // Catch: java.lang.Throwable -> L77
            com.google.android.gms.ads.internal.client.zzbd r0 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L77
            com.google.android.gms.internal.ads.zzbgi r0 = r0.f21153c     // Catch: java.lang.Throwable -> L77
            java.lang.Object r4 = r0.a(r4)     // Catch: java.lang.Throwable -> L77
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.Throwable -> L77
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Throwable -> L77
            if (r4 == 0) goto L6f
            goto L79
        L6f:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L77
            java.lang.String r5 = "Internal Error"
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L77
            throw r4     // Catch: java.lang.Throwable -> L77
        L77:
            r4 = move-exception
            goto L9e
        L79:
            r8.<init>()     // Catch: java.lang.Throwable -> L77
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L77
            r4.<init>()     // Catch: java.lang.Throwable -> L77
            r4.add(r8)     // Catch: java.lang.Throwable -> L77
            com.google.android.gms.ads.mediation.rtb.RtbSignalData r4 = new com.google.android.gms.ads.mediation.rtb.RtbSignalData     // Catch: java.lang.Throwable -> L77
            java.lang.Object r8 = com.google.android.gms.dynamic.ObjectWrapper.z0(r3)     // Catch: java.lang.Throwable -> L77
            android.content.Context r8 = (android.content.Context) r8     // Catch: java.lang.Throwable -> L77
            int r8 = r7.f21285e     // Catch: java.lang.Throwable -> L77
            int r0 = r7.f21282b     // Catch: java.lang.Throwable -> L77
            java.lang.String r7 = r7.f21281a     // Catch: java.lang.Throwable -> L77
            com.google.android.gms.ads.AdSize r1 = new com.google.android.gms.ads.AdSize     // Catch: java.lang.Throwable -> L77
            r1.<init>(r8, r0, r7)     // Catch: java.lang.Throwable -> L77
            r4.<init>()     // Catch: java.lang.Throwable -> L77
            r6.collectSignals(r4, r5)     // Catch: java.lang.Throwable -> L77
            return
        L9e:
            java.lang.String r5 = "Error generating signals for RTB"
            com.google.android.gms.ads.internal.util.client.zzo.d(r5, r4)
            java.lang.String r5 = "adapter.collectSignals"
            com.google.android.gms.internal.ads.zzbsw.a(r3, r4, r5)
            android.os.RemoteException r3 = new android.os.RemoteException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbvl.A3(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, android.os.Bundle, android.os.Bundle, com.google.android.gms.ads.internal.client.zzr, com.google.android.gms.internal.ads.zzbvb):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void B1(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbus zzbusVar, zzbtf zzbtfVar, zzbjn zzbjnVar) throws RemoteException {
        RtbAdapter rtbAdapter = this.f25596b;
        try {
            zzbvg zzbvgVar = new zzbvg(this, zzbusVar, zzbtfVar);
            Yb(str2);
            Xb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str2);
            rtbAdapter.loadRtbNativeAdMapper(new MediationNativeAdConfiguration(), zzbvgVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Adapter failed to render native ad.", th);
            zzbsw.a(iObjectWrapper, th, "adapter.loadRtbNativeAdMapper");
            String message = th.getMessage();
            if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                throw new RemoteException();
            }
            try {
                zzbvh zzbvhVar = new zzbvh(this, zzbusVar, zzbtfVar);
                Yb(str2);
                Xb(zzmVar);
                Zb(zzmVar);
                ac(zzmVar, str2);
                rtbAdapter.loadRtbNativeAd(new MediationNativeAdConfiguration(), zzbvhVar);
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzo.d("Adapter failed to render native ad.", th2);
                zzbsw.a(iObjectWrapper, th2, "adapter.loadRtbNativeAd");
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final boolean G0(ObjectWrapper objectWrapper) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final boolean O0(ObjectWrapper objectWrapper) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void Pa(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbuv zzbuvVar, zzbtf zzbtfVar) throws RemoteException {
        try {
            zzbvk zzbvkVar = new zzbvk(this, zzbuvVar, zzbtfVar);
            RtbAdapter rtbAdapter = this.f25596b;
            Yb(str2);
            Xb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str2);
            rtbAdapter.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration(), zzbvkVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Adapter failed to render rewarded interstitial ad.", th);
            zzbsw.a(iObjectWrapper, th, "adapter.loadRtbRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final boolean S(IObjectWrapper iObjectWrapper) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void S3(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbum zzbumVar, zzbtf zzbtfVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        try {
            zzbvd zzbvdVar = new zzbvd(this, zzbumVar, zzbtfVar);
            RtbAdapter rtbAdapter = this.f25596b;
            Yb(str2);
            Xb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str2);
            new AdSize(zzrVar.f21285e, zzrVar.f21282b, zzrVar.f21281a);
            rtbAdapter.loadRtbBannerAd(new MediationBannerAdConfiguration(), zzbvdVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Adapter failed to render banner ad.", th);
            zzbsw.a(iObjectWrapper, th, "adapter.loadRtbBannerAd");
            throw new RemoteException();
        }
    }

    public final void Xb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Bundle bundle = zzmVar.f21266m;
        if (bundle == null || bundle.getBundle(this.f25596b.getClass().getName()) == null) {
            new Bundle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void f3(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbup zzbupVar, zzbtf zzbtfVar) throws RemoteException {
        try {
            zzbvf zzbvfVar = new zzbvf(this, zzbupVar, zzbtfVar);
            RtbAdapter rtbAdapter = this.f25596b;
            Yb(str2);
            Xb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str2);
            rtbAdapter.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration(), zzbvfVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Adapter failed to render interstitial ad.", th);
            zzbsw.a(iObjectWrapper, th, "adapter.loadRtbInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void k8(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbum zzbumVar, zzbtf zzbtfVar, com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        try {
            zzbve zzbveVar = new zzbve(this, zzbumVar, zzbtfVar);
            RtbAdapter rtbAdapter = this.f25596b;
            Yb(str2);
            Xb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str2);
            new AdSize(zzrVar.f21285e, zzrVar.f21282b, zzrVar.f21281a);
            zzbveVar.a(new AdError(7, rtbAdapter.getClass().getSimpleName().concat(" does not support interscroller ads."), "com.google.android.gms.ads", null));
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Adapter failed to render interscroller ad.", th);
            zzbsw.a(iObjectWrapper, th, "adapter.loadRtbInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void n3(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbuv zzbuvVar, zzbtf zzbtfVar) throws RemoteException {
        try {
            zzbvk zzbvkVar = new zzbvk(this, zzbuvVar, zzbtfVar);
            RtbAdapter rtbAdapter = this.f25596b;
            Yb(str2);
            Xb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str2);
            rtbAdapter.loadRtbRewardedAd(new MediationRewardedAdConfiguration(), zzbvkVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Adapter failed to render rewarded ad.", th);
            zzbsw.a(iObjectWrapper, th, "adapter.loadRtbRewardedAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void u5(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, ObjectWrapper objectWrapper, zzbus zzbusVar, zzbtf zzbtfVar) throws RemoteException {
        B1(str, str2, zzmVar, objectWrapper, zzbusVar, zzbtfVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void z4(String str, String str2, com.google.android.gms.ads.internal.client.zzm zzmVar, IObjectWrapper iObjectWrapper, zzbuj zzbujVar, zzbtf zzbtfVar) throws RemoteException {
        try {
            zzbvi zzbviVar = new zzbvi(this, zzbujVar, zzbtfVar);
            RtbAdapter rtbAdapter = this.f25596b;
            Yb(str2);
            Xb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str2);
            rtbAdapter.loadRtbAppOpenAd(new MediationAppOpenAdConfiguration(), zzbviVar);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("Adapter failed to render app open ad.", th);
            zzbsw.a(iObjectWrapper, th, "adapter.loadRtbAppOpenAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final zzbvn zzf() {
        this.f25596b.getVersionInfo().getClass();
        return new zzbvn(0, 0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final zzbvn zzg() {
        this.f25596b.getSDKVersionInfo().getClass();
        return new zzbvn(0, 0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final com.google.android.gms.ads.internal.client.zzed zzh() {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25596b;
        if (mediationExtrasReceiver instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) mediationExtrasReceiver).getVideoController();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final void zzo(String str) {
    }
}
