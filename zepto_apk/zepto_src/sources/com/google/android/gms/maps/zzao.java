package com.google.android.gms.maps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IStreetViewPanoramaFragmentDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzao implements StreetViewLifecycleDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f38600a;

    /* renamed from: b, reason: collision with root package name */
    public final IStreetViewPanoramaFragmentDelegate f38601b;

    public zzao(StreetViewPanoramaFragment streetViewPanoramaFragment, IStreetViewPanoramaFragmentDelegate iStreetViewPanoramaFragmentDelegate) {
        this.f38601b = (IStreetViewPanoramaFragmentDelegate) Preconditions.checkNotNull(iStreetViewPanoramaFragmentDelegate);
        this.f38600a = (Fragment) Preconditions.checkNotNull(streetViewPanoramaFragment);
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void T() {
        try {
            this.f38601b.T();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void U(Activity activity, Bundle bundle, Bundle bundle2) {
        try {
            Bundle bundle3 = new Bundle();
            zzcb.b(bundle2, bundle3);
            this.f38601b.X4(new ObjectWrapper(activity), bundle3);
            zzcb.b(bundle3, bundle2);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final View V(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            IObjectWrapper iObjectWrapperB1 = this.f38601b.b1(new ObjectWrapper(layoutInflater), new ObjectWrapper(viewGroup), bundle2);
            zzcb.b(bundle2, bundle);
            return (View) ObjectWrapper.z0(iObjectWrapperB1);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        try {
            this.f38601b.l1(new zzan(onStreetViewPanoramaReadyCallback));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void e() {
        try {
            this.f38601b.e();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void i() {
        try {
            this.f38601b.i();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void n(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            Bundle arguments = this.f38600a.getArguments();
            if (arguments != null && arguments.containsKey("StreetViewPanoramaOptions")) {
                zzcb.c(bundle2, "StreetViewPanoramaOptions", arguments.getParcelable("StreetViewPanoramaOptions"));
            }
            this.f38601b.n(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onDestroy() {
        try {
            this.f38601b.onDestroy();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onLowMemory() {
        try {
            this.f38601b.onLowMemory();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onPause() {
        try {
            this.f38601b.onPause();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onResume() {
        try {
            this.f38601b.onResume();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void s(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f38601b.s(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
