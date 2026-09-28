package com.google.maps.android.data;

import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.Observable;

/* loaded from: classes4.dex */
public abstract class Style extends Observable {

    /* renamed from: a, reason: collision with root package name */
    public MarkerOptions f45548a = new MarkerOptions();

    /* renamed from: b, reason: collision with root package name */
    public PolylineOptions f45549b;

    /* renamed from: c, reason: collision with root package name */
    public PolygonOptions f45550c;

    public Style() {
        PolylineOptions polylineOptions = new PolylineOptions();
        this.f45549b = polylineOptions;
        polylineOptions.f38530g = true;
        PolygonOptions polygonOptions = new PolygonOptions();
        this.f45550c = polygonOptions;
        polygonOptions.f38520i = true;
    }
}
