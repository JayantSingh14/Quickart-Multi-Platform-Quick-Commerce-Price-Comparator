package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class zzbuc implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {

    /* renamed from: a, reason: collision with root package name */
    public final zzbtf f25563a;

    /* renamed from: b, reason: collision with root package name */
    public UnifiedNativeAdMapper f25564b;

    /* renamed from: c, reason: collision with root package name */
    public zzbkt f25565c;

    public zzbuc(zzbtf zzbtfVar) {
        this.f25563a = zzbtfVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void a(String str, String str2) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAppEvent.");
        try {
            this.f25563a.V5(str, str2);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void b(AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        int i2 = adError.f20981a;
        int length = String.valueOf(i2).length();
        String str = adError.f20982b;
        int length2 = String.valueOf(str).length();
        String str2 = adError.f20983c;
        StringBuilder sb = new StringBuilder(length + 71 + length2 + 15 + String.valueOf(str2).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(i2);
        sb.append(". ErrorMessage: ");
        sb.append(str);
        sb.append(". ErrorDomain: ");
        sb.append(str2);
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.f25563a.H1(adError.a());
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void c() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb = new StringBuilder(String.valueOf(0).length() + 44);
        sb.append("Adapter called onAdFailedToLoad with error 0.");
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.f25563a.zzg(0);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void d() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdOpened.");
        try {
            this.f25563a.zzi();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void e() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.f25564b;
        if (this.f25565c == null) {
            if (unifiedNativeAdMapper == null) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", null);
                return;
            } else if (!unifiedNativeAdMapper.f21706m) {
                com.google.android.gms.ads.internal.util.client.zzo.a("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdImpression.");
        try {
            this.f25563a.zzk();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void f(AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        int i2 = adError.f20981a;
        int length = String.valueOf(i2).length();
        String str = adError.f20982b;
        int length2 = String.valueOf(str).length();
        String str2 = adError.f20983c;
        StringBuilder sb = new StringBuilder(length + 71 + length2 + 15 + String.valueOf(str2).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(i2);
        sb.append(". ErrorMessage: ");
        sb.append(str);
        sb.append(". ErrorDomain: ");
        sb.append(str2);
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.f25563a.H1(adError.a());
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void g() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdOpened.");
        try {
            this.f25563a.zzi();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void h() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClicked.");
        try {
            this.f25563a.zze();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void i() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdOpened.");
        try {
            this.f25563a.zzi();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void j(AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        int i2 = adError.f20981a;
        int length = String.valueOf(i2).length();
        String str = adError.f20982b;
        int length2 = String.valueOf(str).length();
        String str2 = adError.f20983c;
        StringBuilder sb = new StringBuilder(length + 71 + length2 + 15 + String.valueOf(str2).length());
        sb.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb.append(i2);
        sb.append(". ErrorMessage: ");
        sb.append(str);
        sb.append(". ErrorDomain: ");
        sb.append(str2);
        com.google.android.gms.ads.internal.util.client.zzo.a(sb.toString());
        try {
            this.f25563a.H1(adError.a());
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void k() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClosed.");
        try {
            this.f25563a.zzf();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void l() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClosed.");
        try {
            this.f25563a.zzf();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void m() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLoaded.");
        try {
            this.f25563a.zzj();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerListener
    public final void n() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClosed.");
        try {
            this.f25563a.zzf();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void o(zzbkt zzbktVar, String str) {
        try {
            this.f25563a.d2(zzbktVar.f25285a, str);
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialListener
    public final void p() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLoaded.");
        try {
            this.f25563a.zzj();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void q() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.f25564b;
        if (this.f25565c == null) {
            if (unifiedNativeAdMapper == null) {
                com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", null);
                return;
            } else if (!unifiedNativeAdMapper.n) {
                com.google.android.gms.ads.internal.util.client.zzo.a("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdClicked.");
        try {
            this.f25563a.zze();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void r(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLoaded.");
        this.f25564b = unifiedNativeAdMapper;
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            new VideoController().a(new zzbtp());
        }
        try {
            this.f25563a.zzj();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationNativeListener
    public final void s(zzbkt zzbktVar) {
        String strZzh;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        try {
            strZzh = zzbktVar.f25285a.zzh();
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.d("", e2);
            strZzh = null;
        }
        com.google.android.gms.ads.internal.util.client.zzo.a("Adapter called onAdLoaded with template id ".concat(String.valueOf(strZzh)));
        this.f25565c = zzbktVar;
        try {
            this.f25563a.zzj();
        } catch (RemoteException e3) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e3);
        }
    }
}
