package com.rnmaps.maps;

import android.graphics.Bitmap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.ThemedReactContext;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.collections.GroundOverlayManager;

/* loaded from: classes.dex */
public class MapOverlay extends MapFeature implements ImageReadable {

    /* renamed from: a, reason: collision with root package name */
    public GroundOverlayOptions f46556a;

    /* renamed from: b, reason: collision with root package name */
    public GroundOverlay f46557b;

    /* renamed from: c, reason: collision with root package name */
    public LatLngBounds f46558c;

    /* renamed from: d, reason: collision with root package name */
    public float f46559d;

    /* renamed from: e, reason: collision with root package name */
    public BitmapDescriptor f46560e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f46561f;

    /* renamed from: g, reason: collision with root package name */
    public float f46562g;

    /* renamed from: h, reason: collision with root package name */
    public float f46563h;

    /* renamed from: i, reason: collision with root package name */
    public final ImageReader f46564i;

    /* renamed from: j, reason: collision with root package name */
    public GroundOverlayManager.Collection f46565j;

    public MapOverlay(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f46564i = new ImageReader(themedReactContext, getResources(), this);
    }

    private GroundOverlay getGroundOverlay() {
        GroundOverlayOptions groundOverlayOptions;
        GroundOverlay groundOverlay = this.f46557b;
        if (groundOverlay != null) {
            return groundOverlay;
        }
        if (this.f46565j == null || (groundOverlayOptions = getGroundOverlayOptions()) == null) {
            return null;
        }
        return this.f46565j.h(groundOverlayOptions);
    }

    @Override // com.rnmaps.maps.MapFeature
    public Object getFeature() {
        return this.f46557b;
    }

    public GroundOverlayOptions getGroundOverlayOptions() {
        GroundOverlayOptions groundOverlayOptions = this.f46556a;
        if (groundOverlayOptions == null) {
            if (groundOverlayOptions == null) {
                groundOverlayOptions = new GroundOverlayOptions();
                BitmapDescriptor bitmapDescriptor = this.f46560e;
                if (bitmapDescriptor != null) {
                    groundOverlayOptions.r(bitmapDescriptor);
                } else {
                    groundOverlayOptions.r(BitmapDescriptorFactory.a());
                    groundOverlayOptions.N();
                }
                groundOverlayOptions.s(this.f46558c);
                groundOverlayOptions.Z(this.f46562g);
                groundOverlayOptions.b(this.f46559d);
                groundOverlayOptions.A(this.f46563h);
            }
            this.f46556a = groundOverlayOptions;
        }
        return this.f46556a;
    }

    @Override // com.rnmaps.maps.MapFeature
    public final void j(Object obj) {
        GroundOverlay groundOverlay = this.f46557b;
        if (groundOverlay != null) {
            ((GroundOverlayManager.Collection) obj).c(groundOverlay);
            this.f46557b = null;
            this.f46556a = null;
        }
        this.f46565j = null;
    }

    public final void k() {
        GroundOverlay groundOverlay = getGroundOverlay();
        this.f46557b = groundOverlay;
        if (groundOverlay != null) {
            groundOverlay.f(true);
            this.f46557b.c(this.f46560e);
            this.f46557b.e(this.f46563h);
            this.f46557b.b(this.f46561f);
        }
    }

    public void setBearing(float f2) {
        this.f46559d = f2;
        GroundOverlay groundOverlay = this.f46557b;
        if (groundOverlay != null) {
            groundOverlay.a(f2);
        }
    }

    public void setBounds(ReadableArray readableArray) {
        LatLngBounds latLngBounds = new LatLngBounds(new LatLng(readableArray.getArray(0).getDouble(0), readableArray.getArray(0).getDouble(1)), new LatLng(readableArray.getArray(1).getDouble(0), readableArray.getArray(1).getDouble(1)));
        this.f46558c = latLngBounds;
        GroundOverlay groundOverlay = this.f46557b;
        if (groundOverlay != null) {
            groundOverlay.d(latLngBounds);
        }
    }

    @Override // com.rnmaps.maps.ImageReadable
    public void setIconBitmap(Bitmap bitmap) {
    }

    @Override // com.rnmaps.maps.ImageReadable
    public void setIconBitmapDescriptor(BitmapDescriptor bitmapDescriptor) {
        this.f46560e = bitmapDescriptor;
    }

    public void setImage(String str) throws NumberFormatException {
        this.f46564i.a(str);
    }

    public void setTappable(boolean z) {
        this.f46561f = z;
        GroundOverlay groundOverlay = this.f46557b;
        if (groundOverlay != null) {
            groundOverlay.b(z);
        }
    }

    public void setTransparency(float f2) {
        this.f46563h = f2;
        GroundOverlay groundOverlay = this.f46557b;
        if (groundOverlay != null) {
            groundOverlay.e(f2);
        }
    }

    public void setZIndex(float f2) {
        this.f46562g = f2;
        GroundOverlay groundOverlay = this.f46557b;
        if (groundOverlay != null) {
            groundOverlay.g(f2);
        }
    }
}
