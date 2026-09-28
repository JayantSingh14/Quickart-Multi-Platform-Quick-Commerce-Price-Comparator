package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.horcrux.svg.Brush;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class PatternView extends GroupView {
    public static final float[] s = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: f, reason: collision with root package name */
    public SVGLength f45809f;

    /* renamed from: g, reason: collision with root package name */
    public SVGLength f45810g;

    /* renamed from: h, reason: collision with root package name */
    public SVGLength f45811h;

    /* renamed from: i, reason: collision with root package name */
    public SVGLength f45812i;

    /* renamed from: j, reason: collision with root package name */
    public Brush.BrushUnits f45813j;

    /* renamed from: k, reason: collision with root package name */
    public Brush.BrushUnits f45814k;

    /* renamed from: l, reason: collision with root package name */
    public float f45815l;

    /* renamed from: m, reason: collision with root package name */
    public float f45816m;
    public float n;
    public float o;
    public String p;
    public int q;
    public Matrix r;

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.VirtualView
    public final void saveDefinition() {
        if (this.mName != null) {
            Brush brush = new Brush(Brush.BrushType.f45643c, new SVGLength[]{this.f45809f, this.f45810g, this.f45811h, this.f45812i}, this.f45813j);
            brush.b(this.f45814k);
            brush.e(this);
            Matrix matrix = this.r;
            if (matrix != null) {
                brush.d(matrix);
            }
            SvgView svgView = getSvgView();
            Brush.BrushUnits brushUnits = this.f45813j;
            Brush.BrushUnits brushUnits2 = Brush.BrushUnits.f45646b;
            if (brushUnits == brushUnits2 || this.f45814k == brushUnits2) {
                brush.f(svgView.getCanvasBounds());
            }
            svgView.defineBrush(brush, this.mName);
        }
    }
}
