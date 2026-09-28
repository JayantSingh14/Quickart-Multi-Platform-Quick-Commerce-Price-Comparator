package com.google.android.gms.maps;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;

/* loaded from: classes4.dex */
public class StreetViewPanorama {

    /* renamed from: a, reason: collision with root package name */
    public final IStreetViewPanoramaDelegate f38418a;

    public interface OnStreetViewPanoramaCameraChangeListener {
    }

    public interface OnStreetViewPanoramaChangeListener {
    }

    public interface OnStreetViewPanoramaClickListener {
    }

    public interface OnStreetViewPanoramaLongClickListener {
    }

    public StreetViewPanorama(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) {
        this.f38418a = (IStreetViewPanoramaDelegate) Preconditions.checkNotNull(iStreetViewPanoramaDelegate, "delegate");
    }
}
