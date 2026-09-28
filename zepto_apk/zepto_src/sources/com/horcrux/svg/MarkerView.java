package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class MarkerView extends GroupView {

    /* renamed from: f, reason: collision with root package name */
    public SVGLength f45776f;

    /* renamed from: g, reason: collision with root package name */
    public SVGLength f45777g;

    /* renamed from: h, reason: collision with root package name */
    public SVGLength f45778h;

    /* renamed from: i, reason: collision with root package name */
    public SVGLength f45779i;

    /* renamed from: j, reason: collision with root package name */
    public String f45780j;

    /* renamed from: k, reason: collision with root package name */
    public String f45781k;

    /* renamed from: l, reason: collision with root package name */
    public float f45782l;

    /* renamed from: m, reason: collision with root package name */
    public float f45783m;
    public float n;
    public float o;
    public String p;
    public int q;
    public Matrix r;

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.VirtualView
    public final void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMarker(this, this.mName);
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof VirtualView) {
                    ((VirtualView) childAt).saveDefinition();
                }
            }
        }
    }
}
