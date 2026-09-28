package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.DeferredLifecycleHelper;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.OnDelegateCreatedListener;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.zzcc;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzai extends DeferredLifecycleHelper {

    /* renamed from: e, reason: collision with root package name */
    public final MapView f38594e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f38595f;

    /* renamed from: g, reason: collision with root package name */
    public OnDelegateCreatedListener f38596g;

    /* renamed from: h, reason: collision with root package name */
    public final GoogleMapOptions f38597h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f38598i = new ArrayList();

    public zzai(MapView mapView, Context context, GoogleMapOptions googleMapOptions) {
        this.f38594e = mapView;
        this.f38595f = context;
        this.f38597h = googleMapOptions;
    }

    @Override // com.google.android.gms.dynamic.DeferredLifecycleHelper
    public final void a(OnDelegateCreatedListener onDelegateCreatedListener) {
        this.f38596g = onDelegateCreatedListener;
        Context context = this.f38595f;
        if (this.f22295a == null) {
            try {
                try {
                    MapsInitializer.b(context);
                    IMapViewDelegate iMapViewDelegateE8 = zzcc.a(context, null).e8(new ObjectWrapper(context), this.f38597h);
                    if (iMapViewDelegateE8 == null) {
                        return;
                    }
                    this.f38596g.a(new zzah(this.f38594e, iMapViewDelegateE8));
                    ArrayList arrayList = this.f38598i;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        OnMapReadyCallback onMapReadyCallback = (OnMapReadyCallback) it.next();
                        zzah zzahVar = (zzah) this.f22295a;
                        zzahVar.getClass();
                        try {
                            zzahVar.f38592b.W0(new zzag(onMapReadyCallback));
                        } catch (RemoteException e2) {
                            throw new RuntimeRemoteException(e2);
                        }
                    }
                    arrayList.clear();
                } catch (GooglePlayServicesNotAvailableException unused) {
                }
            } catch (RemoteException e3) {
                throw new RuntimeRemoteException(e3);
            }
        }
    }

    public final void n(com.rnmaps.maps.MapView mapView) {
        LifecycleDelegate lifecycleDelegate = this.f22295a;
        if (lifecycleDelegate == null) {
            this.f38598i.add(mapView);
            return;
        }
        try {
            ((zzah) lifecycleDelegate).f38592b.W0(new zzag(mapView));
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }
}
