package com.google.maps.android.collections;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.maps.android.collections.MapObjectManager;

/* loaded from: classes4.dex */
public class CircleManager extends MapObjectManager<Circle, Collection> implements GoogleMap.OnCircleClickListener {

    public class Collection extends MapObjectManager.Collection {
        public Collection() {
            super();
        }

        public final Circle h(CircleOptions circleOptions) {
            GoogleMap googleMap = CircleManager.this.f45510a;
            googleMap.getClass();
            try {
                Preconditions.checkNotNull(circleOptions, "CircleOptions must not be null.");
                Circle circle = new Circle(googleMap.f38395a.h2(circleOptions));
                a(circle);
                return circle;
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }
    }

    public CircleManager(GoogleMap googleMap) {
        super(googleMap);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void h(Object obj) {
        Circle circle = (Circle) obj;
        circle.getClass();
        try {
            circle.f38446a.zzn();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void i() {
        GoogleMap googleMap = this.f45510a;
        if (googleMap != null) {
            googleMap.v(this);
        }
    }

    public final Collection j() {
        return new Collection();
    }

    public final void k(Circle circle) {
    }
}
