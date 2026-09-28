package com.google.maps.android.collections;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.maps.zzr;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.maps.android.collections.MapObjectManager;

/* loaded from: classes4.dex */
public class GroundOverlayManager extends MapObjectManager<GroundOverlay, Collection> implements GoogleMap.OnGroundOverlayClickListener {

    public class Collection extends MapObjectManager.Collection {

        /* renamed from: c, reason: collision with root package name */
        public GoogleMap.OnGroundOverlayClickListener f45508c;

        public Collection() {
            super();
        }

        public final GroundOverlay h(GroundOverlayOptions groundOverlayOptions) {
            GoogleMap googleMap = GroundOverlayManager.this.f45510a;
            googleMap.getClass();
            try {
                Preconditions.checkNotNull(groundOverlayOptions, "GroundOverlayOptions must not be null.");
                zzr zzrVarG3 = googleMap.f38395a.G3(groundOverlayOptions);
                GroundOverlay groundOverlay = zzrVarG3 != null ? new GroundOverlay(zzrVarG3) : null;
                a(groundOverlay);
                return groundOverlay;
            } catch (RemoteException e2) {
                throw new RuntimeRemoteException(e2);
            }
        }

        public final void i(GoogleMap.OnGroundOverlayClickListener onGroundOverlayClickListener) {
            this.f45508c = onGroundOverlayClickListener;
        }
    }

    public GroundOverlayManager(GoogleMap googleMap) {
        super(googleMap);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnGroundOverlayClickListener
    public final void d(GroundOverlay groundOverlay) {
        GoogleMap.OnGroundOverlayClickListener onGroundOverlayClickListener;
        Collection collection = (Collection) this.f45511b.get(groundOverlay);
        if (collection == null || (onGroundOverlayClickListener = collection.f45508c) == null) {
            return;
        }
        onGroundOverlayClickListener.d(groundOverlay);
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void h(Object obj) {
        GroundOverlay groundOverlay = (GroundOverlay) obj;
        groundOverlay.getClass();
        try {
            groundOverlay.f38460a.zzn();
        } catch (RemoteException e2) {
            throw new RuntimeRemoteException(e2);
        }
    }

    @Override // com.google.maps.android.collections.MapObjectManager
    public final void i() {
        GoogleMap googleMap = this.f45510a;
        if (googleMap != null) {
            googleMap.w(this);
        }
    }

    public final Collection j() {
        return new Collection();
    }
}
