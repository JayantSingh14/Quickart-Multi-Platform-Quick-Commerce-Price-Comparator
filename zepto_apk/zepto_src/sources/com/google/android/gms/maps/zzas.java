package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzas implements StreetViewLifecycleDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f38607a;

    /* renamed from: b, reason: collision with root package name */
    public final IStreetViewPanoramaViewDelegate f38608b;

    /* renamed from: c, reason: collision with root package name */
    public View f38609c;

    public zzas(StreetViewPanoramaView streetViewPanoramaView, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
        this.f38608b = (IStreetViewPanoramaViewDelegate) Preconditions.checkNotNull(iStreetViewPanoramaViewDelegate);
        this.f38607a = (ViewGroup) Preconditions.checkNotNull(streetViewPanoramaView);
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void T() {
        throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void U(Activity activity, Bundle bundle, Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }

    public final void a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        try {
            this.f38608b.l1(new zzar(onStreetViewPanoramaReadyCallback));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void e() {
        try {
            this.f38608b.e();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void i() {
        try {
            this.f38608b.i();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void n(Bundle bundle) {
        ViewGroup viewGroup = this.f38607a;
        IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate = this.f38608b;
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            iStreetViewPanoramaViewDelegate.n(bundle2);
            zzcb.b(bundle2, bundle);
            this.f38609c = (View) ObjectWrapper.z0(iStreetViewPanoramaViewDelegate.getView());
            viewGroup.removeAllViews();
            viewGroup.addView(this.f38609c);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onDestroy() {
        try {
            this.f38608b.onDestroy();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onLowMemory() {
        try {
            this.f38608b.onLowMemory();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onPause() {
        try {
            this.f38608b.onPause();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onResume() {
        try {
            this.f38608b.onResume();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void s(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f38608b.s(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
