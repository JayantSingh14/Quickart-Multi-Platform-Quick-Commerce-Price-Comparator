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
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzah implements MapLifecycleDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f38591a;

    /* renamed from: b, reason: collision with root package name */
    public final IMapViewDelegate f38592b;

    /* renamed from: c, reason: collision with root package name */
    public View f38593c;

    public zzah(MapView mapView, IMapViewDelegate iMapViewDelegate) {
        this.f38592b = (IMapViewDelegate) Preconditions.checkNotNull(iMapViewDelegate);
        this.f38591a = (ViewGroup) Preconditions.checkNotNull(mapView);
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void T() {
        throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void U(Activity activity, Bundle bundle, Bundle bundle2) {
        throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void e() {
        try {
            this.f38592b.e();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void i() {
        try {
            this.f38592b.i();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void n(Bundle bundle) {
        ViewGroup viewGroup = this.f38591a;
        IMapViewDelegate iMapViewDelegate = this.f38592b;
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            iMapViewDelegate.n(bundle2);
            zzcb.b(bundle2, bundle);
            this.f38593c = (View) ObjectWrapper.z0(iMapViewDelegate.getView());
            viewGroup.removeAllViews();
            viewGroup.addView(this.f38593c);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onDestroy() {
        try {
            this.f38592b.onDestroy();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onLowMemory() {
        try {
            this.f38592b.onLowMemory();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onPause() {
        try {
            this.f38592b.onPause();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onResume() {
        try {
            this.f38592b.onResume();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void s(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f38592b.s(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
