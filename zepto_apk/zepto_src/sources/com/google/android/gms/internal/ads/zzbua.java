package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class zzbua extends zzbtb {

    /* renamed from: a, reason: collision with root package name */
    public final MediationExtrasReceiver f25559a;

    /* renamed from: b, reason: collision with root package name */
    public zzbuc f25560b;

    /* renamed from: c, reason: collision with root package name */
    public zzbzx f25561c;

    /* renamed from: d, reason: collision with root package name */
    public IObjectWrapper f25562d;

    public zzbua(Adapter adapter) {
        this.f25559a = adapter;
    }

    public static final boolean Zb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        if (zzmVar.f21259f) {
            return true;
        }
        com.google.android.gms.ads.internal.util.client.zzf zzfVar = com.google.android.gms.ads.internal.client.zzbb.f21141g.f21142a;
        return com.google.android.gms.ads.internal.util.client.zzf.r();
    }

    public static final String ac(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) {
        String str2 = zzmVar.u;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void A1(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbtf zzbtfVar) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (!(mediationExtrasReceiver instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting rewarded ad from adapter.");
        try {
            zzbty zzbtyVar = new zzbty(this, zzbtfVar);
            Xb(str, zzmVar, null);
            Yb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str);
            ((Adapter) mediationExtrasReceiver).loadRewardedAd(new MediationRewardedAdConfiguration(), zzbtyVar);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            zzbsw.a(iObjectWrapper, e2, "adapter.loadRewardedAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void D2(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if ((mediationExtrasReceiver instanceof Adapter) || (mediationExtrasReceiver instanceof MediationInterstitialAdapter)) {
            if (mediationExtrasReceiver instanceof MediationInterstitialAdapter) {
                zzh();
                return;
            } else {
                com.google.android.gms.ads.internal.util.client.zzo.a("Show interstitial ad from adapter.");
                com.google.android.gms.ads.internal.util.client.zzo.c("Can not show null mediation interstitial ad.");
                throw new RemoteException();
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = mediationExtrasReceiver.getClass().getCanonicalName();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(length + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
        android.support.v4.media.b.B(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
        sb.append(canonicalName3);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void E8(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbtf zzbtfVar, zzbjn zzbjnVar, ArrayList arrayList) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        boolean z = mediationExtrasReceiver instanceof MediationNativeAdapter;
        if (!z && !(mediationExtrasReceiver instanceof Adapter)) {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = mediationExtrasReceiver.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
            android.support.v4.media.b.B(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            sb.append(canonicalName3);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting native ad from adapter.");
        if (z) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) mediationExtrasReceiver;
                List list = zzmVar.f21258e;
                HashSet hashSet = list != null ? new HashSet(list) : null;
                long j2 = zzmVar.f21255b;
                if (j2 != -1) {
                    new Date(j2);
                }
                boolean zZb = Zb(zzmVar);
                int i2 = zzmVar.f21260g;
                boolean z2 = zzmVar.r;
                ac(zzmVar, str);
                zzbuf zzbufVar = new zzbuf(hashSet, zZb, i2, zzbjnVar, arrayList, z2);
                Bundle bundle = zzmVar.f21266m;
                Bundle bundle2 = bundle != null ? bundle.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                this.f25560b = new zzbuc(zzbtfVar);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.z0(iObjectWrapper), this.f25560b, Xb(str, zzmVar, str2), zzbufVar, bundle2);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                zzbsw.a(iObjectWrapper, th, "adapter.requestNativeAd");
                throw new RemoteException();
            }
        }
        if (mediationExtrasReceiver instanceof Adapter) {
            try {
                zzbtx zzbtxVar = new zzbtx(this, zzbtfVar);
                Xb(str, zzmVar, str2);
                Yb(zzmVar);
                Zb(zzmVar);
                ac(zzmVar, str);
                ((Adapter) mediationExtrasReceiver).loadNativeAdMapper(new MediationNativeAdConfiguration(), zzbtxVar);
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th2);
                zzbsw.a(iObjectWrapper, th2, "adapter.loadNativeAdMapper");
                String message = th2.getMessage();
                if (TextUtils.isEmpty(message) || !message.equals("Method is not found")) {
                    throw new RemoteException();
                }
                try {
                    zzbtw zzbtwVar = new zzbtw(this, zzbtfVar);
                    Xb(str, zzmVar, str2);
                    Yb(zzmVar);
                    Zb(zzmVar);
                    ac(zzmVar, str);
                    ((Adapter) mediationExtrasReceiver).loadNativeAd(new MediationNativeAdConfiguration(), zzbtwVar);
                } catch (Throwable th3) {
                    com.google.android.gms.ads.internal.util.client.zzo.d("", th3);
                    zzbsw.a(iObjectWrapper, th3, "adapter.loadNativeAd");
                    throw new RemoteException();
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void K2(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbtf zzbtfVar) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (!(mediationExtrasReceiver instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting interscroller ad from adapter.");
        try {
            Adapter adapter = (Adapter) mediationExtrasReceiver;
            zzbts zzbtsVar = new zzbts(this, zzbtfVar, adapter);
            Xb(str, zzmVar, str2);
            Yb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str);
            int i2 = zzrVar.f21285e;
            int i3 = zzrVar.f21282b;
            AdSize adSize = new AdSize(i2, i3);
            adSize.f21009f = true;
            adSize.f21010g = i3;
            zzbtsVar.a(new AdError(7, adapter.getClass().getSimpleName().concat(" does not support interscroller ads."), "com.google.android.gms.ads", null));
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            zzbsw.a(iObjectWrapper, e2, "adapter.loadInterscrollerAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbti O() {
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0070  */
    @Override // com.google.android.gms.internal.ads.zzbtc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O2(com.google.android.gms.dynamic.IObjectWrapper r7, com.google.android.gms.internal.ads.zzbpq r8, java.util.ArrayList r9) throws android.os.RemoteException {
        /*
            r6 = this;
            com.google.android.gms.ads.mediation.MediationExtrasReceiver r0 = r6.f25559a
            boolean r1 = r0 instanceof com.google.android.gms.ads.mediation.Adapter
            if (r1 == 0) goto Lb2
            com.google.android.gms.internal.ads.zzbtt r1 = new com.google.android.gms.internal.ads.zzbtt
            r1.<init>(r6, r8)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r9 = r9.iterator()
        L14:
            boolean r2 = r9.hasNext()
            if (r2 == 0) goto La6
            java.lang.Object r2 = r9.next()
            com.google.android.gms.internal.ads.zzbpw r2 = (com.google.android.gms.internal.ads.zzbpw) r2
            java.lang.String r2 = r2.f25418a
            int r3 = r2.hashCode()
            switch(r3) {
                case -1396342996: goto L66;
                case -1052618729: goto L5c;
                case -239580146: goto L52;
                case 604727084: goto L48;
                case 1167692200: goto L3e;
                case 1778294298: goto L34;
                case 1911491517: goto L2a;
                default: goto L29;
            }
        L29:
            goto L70
        L2a:
            java.lang.String r3 = "rewarded_interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L70
            r2 = 3
            goto L71
        L34:
            java.lang.String r3 = "app_open_ad"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L70
            r2 = 6
            goto L71
        L3e:
            java.lang.String r3 = "app_open"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L70
            r2 = 5
            goto L71
        L48:
            java.lang.String r3 = "interstitial"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L70
            r2 = 1
            goto L71
        L52:
            java.lang.String r3 = "rewarded"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L70
            r2 = 2
            goto L71
        L5c:
            java.lang.String r3 = "native"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L70
            r2 = 4
            goto L71
        L66:
            java.lang.String r3 = "banner"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L70
            r2 = 0
            goto L71
        L70:
            r2 = -1
        L71:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.APP_OPEN_AD
            r4 = 0
            switch(r2) {
                case 0: goto L98;
                case 1: goto L95;
                case 2: goto L92;
                case 3: goto L8f;
                case 4: goto L8c;
                case 5: goto L9a;
                case 6: goto L79;
                default: goto L77;
            }
        L77:
            r3 = r4
            goto L9a
        L79:
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.Wc
            com.google.android.gms.ads.internal.client.zzbd r5 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r5 = r5.f21153c
            java.lang.Object r2 = r5.a(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L77
            goto L9a
        L8c:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.NATIVE
            goto L9a
        L8f:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.REWARDED_INTERSTITIAL
            goto L9a
        L92:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.REWARDED
            goto L9a
        L95:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.INTERSTITIAL
            goto L9a
        L98:
            com.google.android.gms.ads.AdFormat r3 = com.google.android.gms.ads.AdFormat.BANNER
        L9a:
            if (r3 == 0) goto L14
            com.google.android.gms.ads.mediation.MediationConfiguration r2 = new com.google.android.gms.ads.mediation.MediationConfiguration
            r2.<init>()
            r8.add(r2)
            goto L14
        La6:
            com.google.android.gms.ads.mediation.Adapter r0 = (com.google.android.gms.ads.mediation.Adapter) r0
            java.lang.Object r7 = com.google.android.gms.dynamic.ObjectWrapper.z0(r7)
            android.content.Context r7 = (android.content.Context) r7
            r0.initialize(r7, r1, r8)
            return
        Lb2:
            android.os.RemoteException r7 = new android.os.RemoteException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbua.O2(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzbpq, java.util.ArrayList):void");
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void R0(IObjectWrapper iObjectWrapper) {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof OnContextChangedListener) {
            ((OnContextChangedListener) mediationExtrasReceiver).a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbvn U() {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (!(mediationExtrasReceiver instanceof Adapter)) {
            return null;
        }
        ((Adapter) mediationExtrasReceiver).getSDKVersionInfo().getClass();
        return new zzbvn(0, 0, 0);
    }

    public final Bundle Xb(String str, com.google.android.gms.ads.internal.client.zzm zzmVar, String str2) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.a("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                bundle = bundle2;
            }
            if (this.f25559a instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzmVar != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzmVar.f21260g);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", th);
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void Y8(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzo.a("Show rewarded ad from adapter.");
            com.google.android.gms.ads.internal.util.client.zzo.c("Can not show null mediation rewarded ad.");
            throw new RemoteException();
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    public final void Yb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        Bundle bundle = zzmVar.f21266m;
        if (bundle == null || bundle.getBundle(this.f25559a.getClass().getName()) == null) {
            new Bundle();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void a4(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbtf zzbtfVar) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        boolean z = mediationExtrasReceiver instanceof MediationInterstitialAdapter;
        if (!z && !(mediationExtrasReceiver instanceof Adapter)) {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = mediationExtrasReceiver.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
            android.support.v4.media.b.B(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            sb.append(canonicalName3);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting interstitial ad from adapter.");
        if (!z) {
            if (mediationExtrasReceiver instanceof Adapter) {
                try {
                    zzbtv zzbtvVar = new zzbtv(this, zzbtfVar);
                    Xb(str, zzmVar, str2);
                    Yb(zzmVar);
                    Zb(zzmVar);
                    ac(zzmVar, str);
                    ((Adapter) mediationExtrasReceiver).loadInterstitialAd(new MediationInterstitialAdConfiguration(), zzbtvVar);
                    return;
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                    zzbsw.a(iObjectWrapper, th, "adapter.loadInterstitialAd");
                    throw new RemoteException();
                }
            }
            return;
        }
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) mediationExtrasReceiver;
            List list = zzmVar.f21258e;
            HashSet hashSet = list != null ? new HashSet(list) : null;
            long j2 = zzmVar.f21255b;
            if (j2 != -1) {
                new Date(j2);
            }
            boolean zZb = Zb(zzmVar);
            int i2 = zzmVar.f21260g;
            boolean z2 = zzmVar.r;
            ac(zzmVar, str);
            zzbtr zzbtrVar = new zzbtr(hashSet, zZb, i2, z2);
            Bundle bundle = zzmVar.f21266m;
            mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.z0(iObjectWrapper), new zzbuc(zzbtfVar), Xb(str, zzmVar, str2), zzbtrVar, bundle != null ? bundle.getBundle(mediationInterstitialAdapter.getClass().getName()) : null);
        } catch (Throwable th2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", th2);
            zzbsw.a(iObjectWrapper, th2, "adapter.requestInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void b4(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, String str2, zzbtf zzbtfVar) throws RemoteException {
        AdSize adSize;
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        boolean z = mediationExtrasReceiver instanceof MediationBannerAdapter;
        if (!z && !(mediationExtrasReceiver instanceof Adapter)) {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = mediationExtrasReceiver.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
            android.support.v4.media.b.B(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
            sb.append(canonicalName3);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting banner ad from adapter.");
        boolean z2 = zzrVar.n;
        int i2 = zzrVar.f21282b;
        int i3 = zzrVar.f21285e;
        if (z2) {
            AdSize adSize2 = new AdSize(i3, i2);
            adSize2.f21007d = true;
            adSize2.f21008e = i2;
            adSize = adSize2;
        } else {
            adSize = new AdSize(i3, i2, zzrVar.f21281a);
        }
        if (!z) {
            if (mediationExtrasReceiver instanceof Adapter) {
                try {
                    zzbtu zzbtuVar = new zzbtu(this, zzbtfVar);
                    Xb(str, zzmVar, str2);
                    Yb(zzmVar);
                    Zb(zzmVar);
                    ac(zzmVar, str);
                    ((Adapter) mediationExtrasReceiver).loadBannerAd(new MediationBannerAdConfiguration(), zzbtuVar);
                    return;
                } catch (Throwable th) {
                    com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                    zzbsw.a(iObjectWrapper, th, "adapter.loadBannerAd");
                    throw new RemoteException();
                }
            }
            return;
        }
        try {
            MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) mediationExtrasReceiver;
            List list = zzmVar.f21258e;
            HashSet hashSet = list != null ? new HashSet(list) : null;
            long j2 = zzmVar.f21255b;
            if (j2 != -1) {
                new Date(j2);
            }
            boolean zZb = Zb(zzmVar);
            int i4 = zzmVar.f21260g;
            boolean z3 = zzmVar.r;
            ac(zzmVar, str);
            zzbtr zzbtrVar = new zzbtr(hashSet, zZb, i4, z3);
            Bundle bundle = zzmVar.f21266m;
            mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.z0(iObjectWrapper), new zzbuc(zzbtfVar), Xb(str, zzmVar, str2), adSize, zzbtrVar, bundle != null ? bundle.getBundle(mediationBannerAdapter.getClass().getName()) : null);
        } catch (Throwable th2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", th2);
            zzbsw.a(iObjectWrapper, th2, "adapter.requestBannerAd");
            throw new RemoteException();
        }
    }

    public final void bc(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof Adapter) {
            A1(this.f25562d, zzmVar, str, new zzbud((Adapter) mediationExtrasReceiver, this.f25561c));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void cb(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbtf zzbtfVar) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (!(mediationExtrasReceiver instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting rewarded interstitial ad from adapter.");
        try {
            zzbty zzbtyVar = new zzbty(this, zzbtfVar);
            Xb(str, zzmVar, null);
            Yb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str);
            ((Adapter) mediationExtrasReceiver).loadRewardedInterstitialAd(new MediationRewardedAdConfiguration(), zzbtyVar);
        } catch (Exception e2) {
            zzbsw.a(iObjectWrapper, e2, "adapter.loadRewardedInterstitialAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbtl e0() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void e1() throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzo.c("Can not show null mediated rewarded ad.");
            throw new RemoteException();
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void g4(IObjectWrapper iObjectWrapper, zzbzx zzbzxVar, List list) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzo.f("Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void i8(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, zzbzx zzbzxVar, String str) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if ((mediationExtrasReceiver instanceof Adapter) || Objects.equals(mediationExtrasReceiver.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            this.f25562d = iObjectWrapper;
            this.f25561c = zzbzxVar;
            zzbzxVar.y7(new ObjectWrapper(mediationExtrasReceiver));
            return;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void l7(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzm zzmVar, String str, zzbtf zzbtfVar) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (!(mediationExtrasReceiver instanceof Adapter)) {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
            throw new RemoteException();
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Requesting app open ad from adapter.");
        try {
            zzbtz zzbtzVar = new zzbtz(this, zzbtfVar);
            Xb(str, zzmVar, null);
            Yb(zzmVar);
            Zb(zzmVar);
            ac(zzmVar, str);
            ((Adapter) mediationExtrasReceiver).loadAppOpenAd(new MediationAppOpenAdConfiguration(), zzbtzVar);
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            zzbsw.a(iObjectWrapper, e2, "adapter.loadAppOpenAd");
            throw new RemoteException();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbvn m() {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (!(mediationExtrasReceiver instanceof Adapter)) {
            return null;
        }
        ((Adapter) mediationExtrasReceiver).getVersionInfo().getClass();
        return new zzbvn(0, 0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void n4(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof Adapter) {
            com.google.android.gms.ads.internal.util.client.zzo.a("Show app open ad from adapter.");
            com.google.android.gms.ads.internal.util.client.zzo.c("Can not show null mediation app open ad.");
            throw new RemoteException();
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void r7(com.google.android.gms.ads.internal.client.zzm zzmVar, String str) throws RemoteException {
        bc(zzmVar, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final com.google.android.gms.ads.internal.client.zzed t() {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) mediationExtrasReceiver).getVideoController();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbto v() {
        UnifiedNativeAdMapper unifiedNativeAdMapper;
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (!(mediationExtrasReceiver instanceof MediationNativeAdapter)) {
            boolean z = mediationExtrasReceiver instanceof Adapter;
            return null;
        }
        zzbuc zzbucVar = this.f25560b;
        if (zzbucVar == null || (unifiedNativeAdMapper = zzbucVar.f25564b) == null) {
            return null;
        }
        return new zzbug(unifiedNativeAdMapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void w0(boolean z) {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof OnImmersiveModeUpdatedListener) {
            try {
                ((OnImmersiveModeUpdatedListener) mediationExtrasReceiver).onImmersiveModeUpdated(z);
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                return;
            }
        }
        String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
        String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final boolean y() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final zzbtk zzO() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final IObjectWrapper zzf() throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof MediationBannerAdapter) {
            try {
                return new ObjectWrapper(((MediationBannerAdapter) mediationExtrasReceiver).getBannerView());
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
        if (mediationExtrasReceiver instanceof Adapter) {
            return new ObjectWrapper(null);
        }
        String canonicalName = MediationBannerAdapter.class.getCanonicalName();
        String canonicalName2 = Adapter.class.getCanonicalName();
        String canonicalName3 = mediationExtrasReceiver.getClass().getCanonicalName();
        int length = String.valueOf(canonicalName).length();
        StringBuilder sb = new StringBuilder(length + 4 + String.valueOf(canonicalName2).length() + 22 + String.valueOf(canonicalName3).length());
        android.support.v4.media.b.B(sb, canonicalName, " or ", canonicalName2, " #009 Class mismatch: ");
        sb.append(canonicalName3);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzh() throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof MediationInterstitialAdapter) {
            com.google.android.gms.ads.internal.util.client.zzo.a("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) mediationExtrasReceiver).showInterstitial();
                return;
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
        String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
        String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzi() throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof MediationAdapter) {
            try {
                ((MediationAdapter) mediationExtrasReceiver).onDestroy();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzl() throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof MediationAdapter) {
            try {
                ((MediationAdapter) mediationExtrasReceiver).onPause();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final void zzm() throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if (mediationExtrasReceiver instanceof MediationAdapter) {
            try {
                ((MediationAdapter) mediationExtrasReceiver).onResume();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzo.d("", th);
                throw new RemoteException();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtc
    public final boolean zzq() throws RemoteException {
        MediationExtrasReceiver mediationExtrasReceiver = this.f25559a;
        if ((mediationExtrasReceiver instanceof Adapter) || Objects.equals(mediationExtrasReceiver.getClass().getCanonicalName(), "com.google.ads.mediation.admob.AdMobAdapter")) {
            return this.f25561c != null;
        }
        String canonicalName = Adapter.class.getCanonicalName();
        String canonicalName2 = mediationExtrasReceiver.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        com.google.android.gms.ads.internal.util.client.zzo.f(sb.toString());
        throw new RemoteException();
    }

    public zzbua(MediationAdapter mediationAdapter) {
        this.f25559a = mediationAdapter;
    }
}
