package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbsv;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public final class zzen {

    /* renamed from: a, reason: collision with root package name */
    public final zzbsv f21196a;

    /* renamed from: b, reason: collision with root package name */
    public final zzq f21197b;

    /* renamed from: c, reason: collision with root package name */
    public final VideoController f21198c;

    /* renamed from: d, reason: collision with root package name */
    public final zzbc f21199d;

    /* renamed from: e, reason: collision with root package name */
    public zza f21200e;

    /* renamed from: f, reason: collision with root package name */
    public AdListener f21201f;

    /* renamed from: g, reason: collision with root package name */
    public AdSize[] f21202g;

    /* renamed from: h, reason: collision with root package name */
    public AppEventListener f21203h;

    /* renamed from: i, reason: collision with root package name */
    public zzbx f21204i;

    /* renamed from: j, reason: collision with root package name */
    public VideoOptions f21205j;

    /* renamed from: k, reason: collision with root package name */
    public String f21206k;

    /* renamed from: l, reason: collision with root package name */
    public final BaseAdView f21207l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f21208m;
    public OnPaidEventListener n;
    public final AtomicLong o;

    public zzen(BaseAdView baseAdView, AttributeSet attributeSet, boolean z, int i2) {
        zzr zzrVar;
        zzq zzqVar = zzq.f21280a;
        this.f21196a = new zzbsv();
        this.f21198c = new VideoController();
        this.f21199d = new zzel(this);
        this.o = new AtomicLong();
        this.f21207l = baseAdView;
        this.f21197b = zzqVar;
        this.f21204i = null;
        new AtomicBoolean(false);
        if (attributeSet != null) {
            Context context = baseAdView.getContext();
            try {
                zzz zzzVar = new zzz(context, attributeSet);
                AdSize[] adSizeArr = zzzVar.f21307a;
                if (!z && adSizeArr.length != 1) {
                    throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
                }
                this.f21202g = adSizeArr;
                this.f21206k = zzzVar.f21308b;
                if (baseAdView.isInEditMode()) {
                    com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbb.f21141g.f21142a;
                    AdSize adSize = this.f21202g[0];
                    if (adSize.equals(AdSize.p)) {
                        zzrVar = new zzr("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false);
                    } else {
                        zzrVar = new zzr(context, adSize);
                        zzrVar.f21290j = false;
                    }
                    zzfVar.getClass();
                    com.google.android.gms.ads.internal.util.client.zzf.h(baseAdView, zzrVar, "Ads by Google", -16777216, -1);
                }
            } catch (IllegalArgumentException e2) {
                com.google.android.gms.ads.internal.util.client.zzf zzfVar2 = zzbb.f21141g.f21142a;
                zzr zzrVar2 = new zzr(context, AdSize.f20998h);
                String message = e2.getMessage();
                String message2 = e2.getMessage();
                zzfVar2.getClass();
                if (message2 != null) {
                    com.google.android.gms.ads.internal.util.client.zzo.f(message2);
                }
                com.google.android.gms.ads.internal.util.client.zzf.h(baseAdView, zzrVar2, message, -65536, -16777216);
            }
        }
    }

    public static zzr a(Context context, AdSize[] adSizeArr) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.p)) {
                return new zzr("invalid", 0, 0, false, 0, 0, null, false, false, false, true, false, false, false, false);
            }
        }
        zzr zzrVar = new zzr(context, adSizeArr);
        zzrVar.f21290j = false;
        return zzrVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00d5 A[Catch: RemoteException -> 0x00d3, TRY_LEAVE, TryCatch #0 {RemoteException -> 0x00d3, blocks: (B:28:0x00a2, B:30:0x00a8, B:32:0x00b6, B:34:0x00c8, B:37:0x00d5), top: B:54:0x00a2, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(com.google.android.gms.ads.internal.client.zzek r13) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzen.b(com.google.android.gms.ads.internal.client.zzek):void");
    }

    public final void c(zza zzaVar) {
        try {
            this.f21200e = zzaVar;
            zzbx zzbxVar = this.f21204i;
            if (zzbxVar != null) {
                zzbxVar.o8(zzaVar != null ? new zzb(zzaVar) : null);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public final void d(AdSize... adSizeArr) {
        BaseAdView baseAdView = this.f21207l;
        this.f21202g = adSizeArr;
        try {
            zzbx zzbxVar = this.f21204i;
            if (zzbxVar != null) {
                zzbxVar.w4(a(baseAdView.getContext(), this.f21202g));
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
        baseAdView.requestLayout();
    }

    public final void e(AppEventListener appEventListener) {
        try {
            this.f21203h = appEventListener;
            zzbx zzbxVar = this.f21204i;
            if (zzbxVar != null) {
                zzbxVar.J6(appEventListener != null ? new zzbcz(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            com.google.android.gms.ads.internal.util.client.zzo.i("#007 Could not call remote method.", e2);
        }
    }
}
