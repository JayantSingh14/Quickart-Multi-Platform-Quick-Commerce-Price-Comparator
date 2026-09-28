package com.google.android.gms.ads.admanager;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.client.zzga;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbxv;

/* loaded from: classes4.dex */
public final class AdManagerAdView extends BaseAdView {
    public AdManagerAdView(Context context) {
        super(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final void e(final AdManagerAdRequest adManagerAdRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbgk.a(getContext());
        if (((Boolean) zzbii.f25160f.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.oc)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.admanager.zza
                    @Override // java.lang.Runnable
                    public final void run() {
                        AdManagerAdRequest adManagerAdRequest2 = adManagerAdRequest;
                        AdManagerAdView adManagerAdView = this.f21038a;
                        adManagerAdView.getClass();
                        try {
                            adManagerAdView.f21016a.b(adManagerAdRequest2.f20997a);
                        } catch (IllegalStateException e2) {
                            zzbxv.c(adManagerAdView.getContext()).a("AdManagerAdView.loadAd", e2);
                        }
                    }
                });
                return;
            }
        }
        this.f21016a.b(adManagerAdRequest.f20997a);
    }

    @Nullable
    public AdSize[] getAdSizes() {
        return this.f21016a.f21202g;
    }

    @Nullable
    public AppEventListener getAppEventListener() {
        return this.f21016a.f21203h;
    }

    @NonNull
    public VideoController getVideoController() {
        return this.f21016a.f21198c;
    }

    @Nullable
    public VideoOptions getVideoOptions() {
        return this.f21016a.f21205j;
    }

    public void setAdSizes(@NonNull AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.f21016a.d(adSizeArr);
    }

    public void setAppEventListener(@Nullable AppEventListener appEventListener) {
        this.f21016a.e(appEventListener);
    }

    public void setManualImpressionsEnabled(boolean z) {
        zzen zzenVar = this.f21016a;
        zzenVar.f21208m = z;
        try {
            zzbx zzbxVar = zzenVar.f21204i;
            if (zzbxVar != null) {
                zzbxVar.C0(z);
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public void setVideoOptions(@NonNull VideoOptions videoOptions) {
        zzen zzenVar = this.f21016a;
        zzenVar.f21205j = videoOptions;
        try {
            zzbx zzbxVar = zzenVar.f21204i;
            if (zzbxVar != null) {
                zzbxVar.eb(videoOptions == null ? null : new zzga(videoOptions));
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public AdManagerAdView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public AdManagerAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2, (Object) null);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }
}
