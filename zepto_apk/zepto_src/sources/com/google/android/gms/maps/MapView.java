package com.google.android.gms.maps;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public class MapView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final zzai f38411a;

    public MapView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38411a = new zzai(this, context, GoogleMapOptions.r(context, attributeSet));
        setClickable(true);
    }

    public final void d(com.rnmaps.maps.MapView mapView) {
        Preconditions.checkMainThread("getMapAsync() must be called on the main thread");
        Preconditions.checkNotNull(mapView, "callback must not be null.");
        this.f38411a.n(mapView);
    }

    public MapView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f38411a = new zzai(this, context, GoogleMapOptions.r(context, attributeSet));
        setClickable(true);
    }

    public MapView(Context context, GoogleMapOptions googleMapOptions) {
        super(context);
        this.f38411a = new zzai(this, context, googleMapOptions);
        setClickable(true);
    }
}
