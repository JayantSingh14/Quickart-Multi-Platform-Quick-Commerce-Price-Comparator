package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.Brush;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class LinearGradientView extends DefinitionView {

    /* renamed from: h, reason: collision with root package name */
    public static final float[] f45768h = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public SVGLength f45769a;

    /* renamed from: b, reason: collision with root package name */
    public SVGLength f45770b;

    /* renamed from: c, reason: collision with root package name */
    public SVGLength f45771c;

    /* renamed from: d, reason: collision with root package name */
    public SVGLength f45772d;

    /* renamed from: e, reason: collision with root package name */
    public ReadableArray f45773e;

    /* renamed from: f, reason: collision with root package name */
    public Brush.BrushUnits f45774f;

    /* renamed from: g, reason: collision with root package name */
    public Matrix f45775g;

    @Override // com.horcrux.svg.VirtualView
    public final void saveDefinition() {
        if (this.mName != null) {
            Brush brush = new Brush(Brush.BrushType.f45641a, new SVGLength[]{this.f45769a, this.f45770b, this.f45771c, this.f45772d}, this.f45774f);
            brush.c(this.f45773e);
            Matrix matrix = this.f45775g;
            if (matrix != null) {
                brush.d(matrix);
            }
            SvgView svgView = getSvgView();
            if (this.f45774f == Brush.BrushUnits.f45646b) {
                brush.f(svgView.getCanvasBounds());
            }
            svgView.defineBrush(brush, this.mName);
        }
    }
}
