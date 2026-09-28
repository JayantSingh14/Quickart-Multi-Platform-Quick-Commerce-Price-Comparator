package com.google.android.gms.maps;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzcb;
import com.google.android.gms.maps.model.RuntimeRemoteException;

@VisibleForTesting
/* loaded from: classes4.dex */
final class zzav implements MapLifecycleDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f38615a;

    /* renamed from: b, reason: collision with root package name */
    public final IMapFragmentDelegate f38616b;

    public zzav(SupportMapFragment supportMapFragment, IMapFragmentDelegate iMapFragmentDelegate) {
        this.f38616b = (IMapFragmentDelegate) Preconditions.checkNotNull(iMapFragmentDelegate);
        this.f38615a = (Fragment) Preconditions.checkNotNull(supportMapFragment);
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void T() {
        try {
            this.f38616b.T();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void U(Activity activity, Bundle bundle, Bundle bundle2) {
        GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
        try {
            Bundle bundle3 = new Bundle();
            zzcb.b(bundle2, bundle3);
            this.f38616b.V1(new ObjectWrapper(activity), googleMapOptions, bundle3);
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
            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitAll().build());
            try {
                IObjectWrapper iObjectWrapperB1 = this.f38616b.b1(new ObjectWrapper(layoutInflater), new ObjectWrapper(viewGroup), bundle2);
                StrictMode.setThreadPolicy(threadPolicy);
                zzcb.b(bundle2, bundle);
                return (View) ObjectWrapper.z0(iObjectWrapperB1);
            } catch (Throwable th) {
                StrictMode.setThreadPolicy(threadPolicy);
                throw th;
            }
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    public final void a(OnMapReadyCallback onMapReadyCallback) {
        try {
            this.f38616b.W0(new zzau(onMapReadyCallback));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void e() {
        try {
            this.f38616b.e();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void i() {
        try {
            this.f38616b.i();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void n(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            Bundle arguments = this.f38615a.getArguments();
            if (arguments != null && arguments.containsKey("MapOptions")) {
                zzcb.c(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
            }
            this.f38616b.n(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onDestroy() {
        try {
            this.f38616b.onDestroy();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onLowMemory() {
        try {
            this.f38616b.onLowMemory();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onPause() {
        try {
            this.f38616b.onPause();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void onResume() {
        try {
            this.f38616b.onResume();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.android.gms.dynamic.LifecycleDelegate
    public final void s(Bundle bundle) {
        try {
            Bundle bundle2 = new Bundle();
            zzcb.b(bundle, bundle2);
            this.f38616b.s(bundle2);
            zzcb.b(bundle2, bundle);
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
