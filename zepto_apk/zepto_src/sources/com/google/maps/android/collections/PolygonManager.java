package com.google.maps.android.collections;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.maps.android.collections.MapObjectManager;

/* loaded from: classes4.dex */
public class PolygonManager extends MapObjectManager<Polygon, Collection> implements GoogleMap.OnPolygonClickListener {

    public class Collection extends MapObjectManager.Collection {

        /* renamed from: c, reason: collision with root package name */
        public GoogleMap.OnPolygonClickListener f45520c;

        public Collection() {
            super();
        }

        public final Polygon h(PolygonOptions polygonOptions) {
            GoogleMap googleMap = PolygonManager.this.f45510a;
            googleMap.getClass();
            try {
                Preconditions.checkNotNull(polygonOptions, "PolygonOptions must not be null");
                Polygon polygon = new Polygon(googleMap.f38395a.B4(polygonOptions));
                a(polygon);
                return polygon;
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void i(GoogleMap.OnPolygonClickListener onPolygonClickListener) {
            this.f45520c = onPolygonClickListener;
        }
    }

    public PolygonManager(GoogleMap googleMap) {
        super(googleMap);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
    public final void e(Polygon polygon) {
        GoogleMap.OnPolygonClickListener onPolygonClickListener;
        Collection collection = (Collection) this.f45511b.get(polygon);
        if (collection == null || (onPolygonClickListener = collection.f45520c) == null) {
            return;
        }
        onPolygonClickListener.e(polygon);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void h(Object obj) {
        Polygon polygon = (Polygon) obj;
        polygon.getClass();
        try {
            polygon.f38511a.zzo();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void i() {
        GoogleMap googleMap = this.f45510a;
        if (googleMap != null) {
            googleMap.H(this);
        }
    }

    public final Collection j() {
        return new Collection();
    }
}
