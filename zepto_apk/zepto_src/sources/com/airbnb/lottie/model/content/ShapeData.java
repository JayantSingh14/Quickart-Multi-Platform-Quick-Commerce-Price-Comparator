package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeData {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f14579a;

    /* renamed from: b, reason: collision with root package name */
    public PointF f14580b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f14581c;

    public ShapeData(PointF pointF, boolean z, List list) {
        this.f14580b = pointF;
        this.f14581c = z;
        this.f14579a = new ArrayList(list);
    }

    public final void a(float f2, float f3) {
        if (this.f14580b == null) {
            this.f14580b = new PointF();
        }
        this.f14580b.set(f2, f3);
    }

    public final String toString() {
        return "ShapeData{numCurves=" + this.f14579a.size() + "closed=" + this.f14581c + '}';
    }

    public ShapeData() {
        this.f14579a = new ArrayList();
    }
}
