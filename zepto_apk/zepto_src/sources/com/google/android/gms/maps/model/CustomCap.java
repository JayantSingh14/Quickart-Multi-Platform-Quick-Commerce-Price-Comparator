package com.google.android.gms.maps.model;

import android.support.v4.media.b;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes4.dex */
public final class CustomCap extends Cap {

    /* renamed from: d, reason: collision with root package name */
    public final BitmapDescriptor f38456d;

    /* renamed from: e, reason: collision with root package name */
    public final float f38457e;

    /* JADX WARN: Illegal instructions before constructor call */
    public CustomCap(BitmapDescriptor bitmapDescriptor, float f2) {
        BitmapDescriptor bitmapDescriptor2 = (BitmapDescriptor) Preconditions.checkNotNull(bitmapDescriptor, "bitmapDescriptor must not be null");
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("refWidth must be positive");
        }
        super(3, bitmapDescriptor2, Float.valueOf(f2));
        this.f38456d = bitmapDescriptor;
        this.f38457e = f2;
    }

    @Override // com.google.android.gms.maps.model.Cap
    public final String toString() {
        StringBuilder sbY = b.y("[CustomCap: bitmapDescriptor=", String.valueOf(this.f38456d), " refWidth=");
        sbY.append(this.f38457e);
        sbY.append("]");
        return sbY.toString();
    }
}
