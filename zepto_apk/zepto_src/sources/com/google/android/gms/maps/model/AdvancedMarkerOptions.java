package com.google.android.gms.maps.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes4.dex */
public class AdvancedMarkerOptions extends MarkerOptions {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface CollisionBehavior {
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void A(boolean z) {
        this.f38494i = z;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void W1(BitmapDescriptor bitmapDescriptor) {
        this.f38489d = bitmapDescriptor;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void X1(float f2, float f3) {
        this.f38496k = f2;
        this.f38497l = f3;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void b(float f2) {
        this.f38498m = f2;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void b2(float f2) {
        this.f38495j = f2;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void c2(String str) {
        this.f38488c = str;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void d2(String str) {
        this.f38487b = str;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void e2(float f2) {
        this.n = f2;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void r(float f2, float f3) {
        this.f38490e = f2;
        this.f38491f = f3;
    }

    @Override // com.google.android.gms.maps.model.MarkerOptions
    public final void s(boolean z) {
        this.f38492g = z;
    }
}
