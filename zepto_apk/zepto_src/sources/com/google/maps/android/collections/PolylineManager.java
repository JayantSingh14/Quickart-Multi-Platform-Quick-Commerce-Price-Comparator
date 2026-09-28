package com.google.maps.android.collections;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.maps.android.collections.MapObjectManager;

/* loaded from: classes4.dex */
public class PolylineManager extends MapObjectManager<Polyline, Collection> implements GoogleMap.OnPolylineClickListener {

    public class Collection extends MapObjectManager.Collection {

        /* renamed from: c, reason: collision with root package name */
        public GoogleMap.OnPolylineClickListener f45522c;

        public Collection() {
            super();
        }

        public final Polyline h(PolylineOptions polylineOptions) {
            GoogleMap googleMap = PolylineManager.this.f45510a;
            googleMap.getClass();
            try {
                Preconditions.checkNotNull(polylineOptions, "PolylineOptions must not be null");
                Polyline polyline = new Polyline(googleMap.f38395a.db(polylineOptions));
                a(polyline);
                return polyline;
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void i(GoogleMap.OnPolylineClickListener onPolylineClickListener) {
            this.f45522c = onPolylineClickListener;
        }
    }

    public PolylineManager(GoogleMap googleMap) {
        super(googleMap);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
    public final void b(Polyline polyline) {
        GoogleMap.OnPolylineClickListener onPolylineClickListener;
        Collection collection = (Collection) this.f45511b.get(polyline);
        if (collection == null || (onPolylineClickListener = collection.f45522c) == null) {
            return;
        }
        onPolylineClickListener.b(polyline);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void h(Object obj) {
        Polyline polyline = (Polyline) obj;
        polyline.getClass();
        try {
            polyline.f38523a.zzp();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void i() {
        GoogleMap googleMap = this.f45510a;
        if (googleMap != null) {
            googleMap.I(this);
        }
    }

    public final Collection j() {
        return new Collection();
    }
}
