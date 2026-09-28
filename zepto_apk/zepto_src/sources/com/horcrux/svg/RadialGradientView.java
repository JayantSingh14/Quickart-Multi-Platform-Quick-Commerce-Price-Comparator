package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.Brush;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class RadialGradientView extends DefinitionView {

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f45835j = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public SVGLength f45836a;

    /* renamed from: b, reason: collision with root package name */
    public SVGLength f45837b;

    /* renamed from: c, reason: collision with root package name */
    public SVGLength f45838c;

    /* renamed from: d, reason: collision with root package name */
    public SVGLength f45839d;

    /* renamed from: e, reason: collision with root package name */
    public SVGLength f45840e;

    /* renamed from: f, reason: collision with root package name */
    public SVGLength f45841f;

    /* renamed from: g, reason: collision with root package name */
    public ReadableArray f45842g;

    /* renamed from: h, reason: collision with root package name */
    public Brush.BrushUnits f45843h;

    /* renamed from: i, reason: collision with root package name */
    public Matrix f45844i;

    @Override // com.horcrux.svg.VirtualView
    public final void saveDefinition() {
        if (this.mName != null) {
            Brush brush = new Brush(Brush.BrushType.f45642b, new SVGLength[]{this.f45836a, this.f45837b, this.f45838c, this.f45839d, this.f45840e, this.f45841f}, this.f45843h);
            brush.c(this.f45842g);
            Matrix matrix = this.f45844i;
            if (matrix != null) {
                brush.d(matrix);
            }
            SvgView svgView = getSvgView();
            if (this.f45843h == Brush.BrushUnits.f45646b) {
                brush.f(svgView.getCanvasBounds());
            }
            svgView.defineBrush(brush, this.mName);
        }
    }
}
