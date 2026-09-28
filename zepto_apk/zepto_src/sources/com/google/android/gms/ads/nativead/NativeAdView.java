package com.google.android.gms.ads.nativead;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzaz;
import com.google.android.gms.ads.internal.client.zzbb;
import com.google.android.gms.ads.internal.client.zzbd;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgk;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzbkc;

/* loaded from: classes4.dex */
public final class NativeAdView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final FrameLayout f21739a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbkc f21740b;

    public NativeAdView(Context context) {
        super(context);
        this.f21739a = c(context);
        this.f21740b = d();
    }

    public final View a(String str) {
        zzbkc zzbkcVar = this.f21740b;
        if (zzbkcVar == null) {
            return null;
        }
        try {
            IObjectWrapper iObjectWrapperO = zzbkcVar.o(str);
            if (iObjectWrapperO != null) {
                return (View) ObjectWrapper.z0(iObjectWrapperO);
            }
            return null;
        } catch (RemoteException e2) {
            zzo.d("Unable to call getAssetView on delegate", e2);
            return null;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        super.bringChildToFront(this.f21739a);
    }

    public final void b(View view, String str) {
        zzbkc zzbkcVar = this.f21740b;
        if (zzbkcVar == null) {
            return;
        }
        try {
            zzbkcVar.P6(new ObjectWrapper(view), str);
        } catch (RemoteException e2) {
            zzo.d("Unable to call setAssetView on delegate", e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.f21739a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final FrameLayout c(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    public final zzbkc d() {
        if (isInEditMode()) {
            return null;
        }
        zzaz zzazVar = zzbb.f21141g.f21143b;
        FrameLayout frameLayout = this.f21739a;
        return zzazVar.e(frameLayout.getContext(), this, frameLayout);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzbkc zzbkcVar = this.f21740b;
        if (zzbkcVar != null) {
            if (((Boolean) zzbd.f21150e.f21153c.a(zzbgk.Gc)).booleanValue()) {
                try {
                    zzbkcVar.U2(new ObjectWrapper(motionEvent));
                } catch (RemoteException e2) {
                    zzo.d("Unable to call handleTouchEvent on delegate", e2);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public AdChoicesView getAdChoicesView() {
        View viewA = a("3011");
        if (viewA instanceof AdChoicesView) {
            return (AdChoicesView) viewA;
        }
        return null;
    }

    @Nullable
    public final View getAdvertiserView() {
        return a("3005");
    }

    @Nullable
    public final View getBodyView() {
        return a("3004");
    }

    @Nullable
    public final View getCallToActionView() {
        return a("3002");
    }

    @Nullable
    public final View getHeadlineView() {
        return a("3001");
    }

    @Nullable
    public final View getIconView() {
        return a("3003");
    }

    @Nullable
    public final View getImageView() {
        return a("3008");
    }

    @Nullable
    public final MediaView getMediaView() {
        View viewA = a("3010");
        if (viewA instanceof MediaView) {
            return (MediaView) viewA;
        }
        if (viewA == null) {
            return null;
        }
        zzo.a("View is not an instance of MediaView");
        return null;
    }

    @Nullable
    public final View getPriceView() {
        return a("3007");
    }

    @Nullable
    public final View getStarRatingView() {
        return a("3009");
    }

    @Nullable
    public final View getStoreView() {
        return a("3006");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        zzbkc zzbkcVar = this.f21740b;
        if (zzbkcVar == null) {
            return;
        }
        try {
            zzbkcVar.v0(new ObjectWrapper(view), i2);
        } catch (RemoteException e2) {
            zzo.d("Unable to call onVisibilityChanged on delegate", e2);
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        addView(this.f21739a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.f21739a == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(@Nullable AdChoicesView adChoicesView) {
        b(adChoicesView, "3011");
    }

    public final void setAdvertiserView(@Nullable View view) {
        b(view, "3005");
    }

    public final void setBodyView(@Nullable View view) {
        b(view, "3004");
    }

    public final void setCallToActionView(@Nullable View view) {
        b(view, "3002");
    }

    public final void setClickConfirmingView(@Nullable View view) {
        zzbkc zzbkcVar = this.f21740b;
        if (zzbkcVar == null) {
            return;
        }
        try {
            zzbkcVar.Z(new ObjectWrapper(view));
        } catch (RemoteException e2) {
            zzo.d("Unable to call setClickConfirmingView on delegate", e2);
        }
    }

    public final void setHeadlineView(@Nullable View view) {
        b(view, "3001");
    }

    public final void setIconView(@Nullable View view) {
        b(view, "3003");
    }

    public final void setImageView(@Nullable View view) {
        b(view, "3008");
    }

    public final void setMediaView(@Nullable MediaView mediaView) {
        b(mediaView, "3010");
        if (mediaView == null) {
            return;
        }
        zzb zzbVar = new zzb(this);
        synchronized (mediaView) {
            mediaView.f21716c = zzbVar;
            if (mediaView.f21715b) {
                zzbVar.a(mediaView.f21714a);
            }
        }
        zzbjm zzbjmVar = new zzbjm() { // from class: com.google.android.gms.ads.nativead.zza
            @Override // com.google.android.gms.internal.ads.zzbjm
            public final void a(ImageView.ScaleType scaleType) {
                zzbkc zzbkcVar = this.f21741a.f21740b;
                if (zzbkcVar == null || scaleType == null) {
                    return;
                }
                try {
                    zzbkcVar.ha(new ObjectWrapper(scaleType));
                } catch (RemoteException e2) {
                    zzo.d("Unable to call setMediaViewImageScaleType on delegate", e2);
                }
            }
        };
        synchronized (mediaView) {
            mediaView.f21719f = zzbjmVar;
            if (mediaView.f21718e) {
                zzbjmVar.a(mediaView.f21717d);
            }
        }
    }

    public void setNativeAd(@NonNull NativeAd nativeAd) {
        zzbkc zzbkcVar = this.f21740b;
        if (zzbkcVar == null) {
            return;
        }
        try {
            zzbkcVar.H0(nativeAd.d());
        } catch (RemoteException e2) {
            zzo.d("Unable to call setNativeAd on delegate", e2);
        }
    }

    public final void setPriceView(@Nullable View view) {
        b(view, "3007");
    }

    public final void setStarRatingView(@Nullable View view) {
        b(view, "3009");
    }

    public final void setStoreView(@Nullable View view) {
        b(view, "3006");
    }

    public NativeAdView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21739a = c(context);
        this.f21740b = d();
    }

    public NativeAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f21739a = c(context);
        this.f21740b = d();
    }
}
