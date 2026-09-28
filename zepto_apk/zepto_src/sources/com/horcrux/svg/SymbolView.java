package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class SymbolView extends GroupView {

    /* renamed from: f, reason: collision with root package name */
    public float f45867f;

    /* renamed from: g, reason: collision with root package name */
    public float f45868g;

    /* renamed from: h, reason: collision with root package name */
    public float f45869h;

    /* renamed from: i, reason: collision with root package name */
    public float f45870i;

    /* renamed from: j, reason: collision with root package name */
    public String f45871j;

    /* renamed from: k, reason: collision with root package name */
    public int f45872k;

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final void draw(Canvas canvas, Paint paint, float f2) {
        saveDefinition();
    }

    public final void q(Canvas canvas, Paint paint, float f2, float f3, float f4) {
        if (this.f45871j != null) {
            float f5 = this.f45867f;
            float f6 = this.mScale;
            float f7 = this.f45868g;
            canvas.concat(ViewBox.a(new RectF(f5 * f6, f7 * f6, (f5 + this.f45869h) * f6, (f7 + this.f45870i) * f6), new RectF(0.0f, 0.0f, f3, f4), this.f45871j, this.f45872k));
            super.draw(canvas, paint, f2);
        }
    }
}
