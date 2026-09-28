package com.google.maps.android.data;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class MultiGeometry implements Geometry {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f45529a;

    @Override // com.google.maps.android.data.Geometry
    public final String a() {
        return "MultiGeometry";
    }

    @Override // com.google.maps.android.data.Geometry
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public List d() {
        return this.f45529a;
    }

    public String toString() {
        return "MultiGeometry{" + "\n ".concat("Geometries=") + d() + "\n}\n";
    }
}
