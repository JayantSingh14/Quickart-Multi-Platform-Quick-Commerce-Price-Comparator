package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbc;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.client.zzbx;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.ads.internal.client.zzen;
import com.google.android.gms.ads.internal.client.zzfs;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbii;
import com.google.android.gms.internal.ads.zzbxv;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public abstract class BaseAdView extends ViewGroup {

    /* renamed from: a, reason: collision with root package name */
    public final zzen f21016a;

    public BaseAdView(Context context) {
        super(context);
        this.f21016a = new zzen(this, null, false, 0);
    }

    public final void a() {
        zzbgk.a(getContext());
        if (((Boolean) zzbii.f25159e.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.lc)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.zzg
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = this.f21991a;
                        try {
                            zzen zzenVar = baseAdView.f21016a;
                            zzenVar.getClass();
                            try {
                                zzbx zzbxVar = zzenVar.f21204i;
                                if (zzbxVar != null) {
                                    zzbxVar.zzc();
                                }
                            } catch (RemoteException e2) {
                                zzo.i("#007 Could not call remote method.", e2);
                            }
                        } catch (IllegalStateException e3) {
                            zzbxv.c(baseAdView.getContext()).a("BaseAdView.destroy", e3);
                        }
                    }
                });
                return;
            }
        }
        zzen zzenVar = this.f21016a;
        zzenVar.getClass();
        try {
            zzbx zzbxVar = zzenVar.f21204i;
            if (zzbxVar != null) {
                zzbxVar.zzc();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public final void b(final AdRequest adRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbgk.a(getContext());
        if (((Boolean) zzbii.f25160f.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.oc)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.zzd
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        AdRequest adRequest2 = adRequest;
                        BaseAdView baseAdView = this.f21987a;
                        try {
                            baseAdView.f21016a.b(adRequest2.f20997a);
                        } catch (IllegalStateException e2) {
                            zzbxv.c(baseAdView.getContext()).a("BaseAdView.loadAd", e2);
                        }
                    }
                });
                return;
            }
        }
        this.f21016a.b(adRequest.f20997a);
    }

    public final void c() {
        zzbgk.a(getContext());
        if (((Boolean) zzbii.f25161g.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.mc)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.zze
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = this.f21989a;
                        try {
                            zzen zzenVar = baseAdView.f21016a;
                            zzenVar.getClass();
                            try {
                                zzbx zzbxVar = zzenVar.f21204i;
                                if (zzbxVar != null) {
                                    zzbxVar.zzf();
                                }
                            } catch (RemoteException e2) {
                                zzo.i("#007 Could not call remote method.", e2);
                            }
                        } catch (IllegalStateException e3) {
                            zzbxv.c(baseAdView.getContext()).a("BaseAdView.pause", e3);
                        }
                    }
                });
                return;
            }
        }
        zzen zzenVar = this.f21016a;
        zzenVar.getClass();
        try {
            zzbx zzbxVar = zzenVar.f21204i;
            if (zzbxVar != null) {
                zzbxVar.zzf();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public final void d() {
        zzbgk.a(getContext());
        if (((Boolean) zzbii.f25162h.c()).booleanValue()) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.kc)).booleanValue()) {
                com.google.android.gms.ads.internal.util.client.zzb.f21408b.execute(new Runnable() { // from class: com.google.android.gms.ads.zzf
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = this.f21990a;
                        try {
                            zzen zzenVar = baseAdView.f21016a;
                            zzenVar.getClass();
                            try {
                                zzbx zzbxVar = zzenVar.f21204i;
                                if (zzbxVar != null) {
                                    zzbxVar.zzg();
                                }
                            } catch (RemoteException e2) {
                                zzo.i("#007 Could not call remote method.", e2);
                            }
                        } catch (IllegalStateException e3) {
                            zzbxv.c(baseAdView.getContext()).a("BaseAdView.resume", e3);
                        }
                    }
                });
                return;
            }
        }
        zzen zzenVar = this.f21016a;
        zzenVar.getClass();
        try {
            zzbx zzbxVar = zzenVar.f21204i;
            if (zzbxVar != null) {
                zzbxVar.zzg();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    @NonNull
    public AdListener getAdListener() {
        return this.f21016a.f21201f;
    }

    @Nullable
    public AdSize getAdSize() {
        zzr zzrVarZzn;
        zzen zzenVar = this.f21016a;
        zzenVar.getClass();
        try {
            zzbx zzbxVar = zzenVar.f21204i;
            if (zzbxVar != null && (zzrVarZzn = zzbxVar.zzn()) != null) {
                return new AdSize(zzrVarZzn.f21285e, zzrVarZzn.f21282b, zzrVarZzn.f21281a);
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
        AdSize[] adSizeArr = zzenVar.f21202g;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    @NonNull
    public String getAdUnitId() {
        zzbx zzbxVar;
        zzen zzenVar = this.f21016a;
        if (zzenVar.f21206k == null && (zzbxVar = zzenVar.f21204i) != null) {
            try {
                zzenVar.f21206k = zzbxVar.c();
            } catch (RemoteException e2) {
                zzo.i("#007 Could not call remote method.", e2);
            }
        }
        return zzenVar.f21206k;
    }

    @Nullable
    public OnPaidEventListener getOnPaidEventListener() {
        return this.f21016a.n;
    }

    public long getPlacementId() {
        zzen zzenVar = this.f21016a;
        AtomicLong atomicLong = zzenVar.o;
        if (atomicLong.get() != 0) {
            return atomicLong.get();
        }
        try {
            zzbx zzbxVar = zzenVar.f21204i;
            if (zzbxVar != null) {
                atomicLong.set(zzbxVar.L());
                return atomicLong.get();
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
        return 0L;
    }

    @Nullable
    public ResponseInfo getResponseInfo() {
        zzbx zzbxVar;
        zzen zzenVar = this.f21016a;
        zzenVar.getClass();
        try {
            zzbxVar = zzenVar.f21204i;
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
        zzea zzeaVarF = zzbxVar != null ? zzbxVar.f() : null;
        if (zzeaVarF != null) {
            return new ResponseInfo(zzeaVarF);
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i6 = ((i4 - i2) - measuredWidth) / 2;
        int i7 = ((i5 - i3) - measuredHeight) / 2;
        childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        AdSize adSize;
        int measuredHeight;
        int iB;
        int iB2;
        int measuredWidth = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e2) {
                zzo.d("Unable to retrieve ad size.", e2);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int i4 = adSize.f21004a;
                if (i4 == -3) {
                    iB = -1;
                } else if (i4 != -1) {
                    com.google.android.gms.ads.internal.util.client.zzf zzfVar = zzbb.f21141g.f21142a;
                    iB = com.google.android.gms.ads.internal.util.client.zzf.b(i4, context);
                } else {
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    Parcelable.Creator<zzr> creator = zzr.CREATOR;
                    iB = displayMetrics.widthPixels;
                }
                int i5 = adSize.f21005b;
                if (i5 == -4 || i5 == -3) {
                    iB2 = -1;
                } else if (i5 != -2) {
                    com.google.android.gms.ads.internal.util.client.zzf zzfVar2 = zzbb.f21141g.f21142a;
                    iB2 = com.google.android.gms.ads.internal.util.client.zzf.b(i5, context);
                } else {
                    DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
                    Parcelable.Creator<zzr> creator2 = zzr.CREATOR;
                    float f2 = displayMetrics2.heightPixels;
                    float f3 = displayMetrics2.density;
                    int i6 = (int) (f2 / f3);
                    iB2 = (int) ((i6 <= 400 ? 32 : i6 <= 720 ? 50 : 90) * f3);
                }
                measuredHeight = iB2;
                measuredWidth = iB;
            } else {
                measuredHeight = 0;
            }
        } else {
            measureChild(childAt, i2, i3);
            measuredWidth = childAt.getMeasuredWidth();
            measuredHeight = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i2), View.resolveSize(Math.max(measuredHeight, getSuggestedMinimumHeight()), i3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(@NonNull AdListener adListener) {
        zzen zzenVar = this.f21016a;
        zzenVar.f21201f = adListener;
        zzbc zzbcVar = zzenVar.f21199d;
        synchronized (zzbcVar.f21148a) {
            zzbcVar.f21149b = adListener;
        }
        if (adListener == 0) {
            zzenVar.c(null);
            return;
        }
        if (adListener instanceof com.google.android.gms.ads.internal.client.zza) {
            zzenVar.c((com.google.android.gms.ads.internal.client.zza) adListener);
        }
        if (adListener instanceof AppEventListener) {
            zzenVar.e((AppEventListener) adListener);
        }
    }

    public void setAdSize(@NonNull AdSize adSize) {
        AdSize[] adSizeArr = {adSize};
        zzen zzenVar = this.f21016a;
        if (zzenVar.f21202g != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zzenVar.d(adSizeArr);
    }

    public void setAdUnitId(@NonNull String str) {
        zzen zzenVar = this.f21016a;
        if (zzenVar.f21206k != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        zzenVar.f21206k = str;
    }

    public void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        zzen zzenVar = this.f21016a;
        zzenVar.getClass();
        try {
            zzenVar.n = onPaidEventListener;
            zzbx zzbxVar = zzenVar.f21204i;
            if (zzbxVar != null) {
                zzbxVar.xa(new zzfs(onPaidEventListener));
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public void setPlacementId(long j2) {
        zzen zzenVar = this.f21016a;
        zzenVar.o.set(j2);
        try {
            zzbx zzbxVar = zzenVar.f21204i;
            if (zzbxVar != null) {
                zzbxVar.j2(j2);
            }
        } catch (RemoteException e2) {
            zzo.i("#007 Could not call remote method.", e2);
        }
    }

    public BaseAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21016a = new zzen(this, attributeSet, false, 0);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2);
        this.f21016a = new zzen(this, attributeSet, false, 0);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i2, Object obj) {
        super(context, attributeSet, i2);
        this.f21016a = new zzen(this, attributeSet, true, 0);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        this.f21016a = new zzen(this, attributeSet, true, 0);
    }
}
