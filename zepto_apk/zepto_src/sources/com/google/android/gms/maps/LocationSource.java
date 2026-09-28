package com.google.android.gms.maps;

import android.location.Location;

/* loaded from: classes4.dex */
public interface LocationSource {

    public interface OnLocationChangedListener {
        void onLocationChanged(Location location);
    }

    void a(OnLocationChangedListener onLocationChangedListener);

    void deactivate();
}
