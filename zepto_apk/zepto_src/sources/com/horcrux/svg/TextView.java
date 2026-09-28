package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.uimanager.ThemedReactContext;
import com.horcrux.svg.TextProperties;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class TextView extends GroupView {

    /* renamed from: f, reason: collision with root package name */
    public SVGLength f45915f;

    /* renamed from: g, reason: collision with root package name */
    public SVGLength f45916g;

    /* renamed from: h, reason: collision with root package name */
    public String f45917h;

    /* renamed from: i, reason: collision with root package name */
    public TextProperties.TextLengthAdjust f45918i;

    /* renamed from: j, reason: collision with root package name */
    public TextProperties.AlignmentBaseline f45919j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f45920k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f45921l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f45922m;
    public ArrayList n;
    public ArrayList o;
    public double p;

    public TextView(ThemedReactContext themedReactContext) {
        super(themedReactContext);
        this.f45915f = null;
        this.f45916g = null;
        this.f45917h = null;
        this.f45918i = TextProperties.TextLengthAdjust.f45907a;
        this.p = Double.NaN;
    }

    @Override // com.horcrux.svg.VirtualView
    public void clearCache() {
        this.p = Double.NaN;
        super.clearCache();
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public void draw(Canvas canvas, Paint paint, float f2) {
        p(canvas);
        clip(canvas, paint);
        q(canvas, paint);
        o();
        j(canvas, paint, f2);
        n();
    }

    @Override // com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = this.mPath;
        if (path != null) {
            return path;
        }
        p(canvas);
        return q(canvas, paint);
    }

    @Override // com.horcrux.svg.VirtualView, android.view.View
    public void invalidate() {
        if (this.mPath == null) {
            return;
        }
        super.invalidate();
        ViewParent parent = getParent();
        TextView textView = this;
        while (parent instanceof TextView) {
            textView = (TextView) parent;
            parent = textView.getParent();
        }
        textView.clearChildCache();
    }

    @Override // com.horcrux.svg.GroupView
    public final Path l(Canvas canvas, Paint paint) {
        return getPath(canvas, paint);
    }

    @Override // com.horcrux.svg.GroupView
    public void o() {
        m().n(((this instanceof TextPathView) || (this instanceof TSpanView)) ? false : true, this, this.f45748a, this.f45920k, this.f45921l, this.n, this.o, this.f45922m);
    }

    public final Path q(Canvas canvas, Paint paint) {
        Path path = this.mPath;
        if (path != null) {
            return path;
        }
        o();
        this.mPath = super.getPath(canvas, paint);
        n();
        return this.mPath;
    }

    public double r(Paint paint) {
        if (!Double.isNaN(this.p)) {
            return this.p;
        }
        double dR = 0.0d;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof TextView) {
                dR += ((TextView) childAt).r(paint);
            }
        }
        this.p = dR;
        return dR;
    }

    public void s(String str) {
        this.f45919j = TextProperties.AlignmentBaseline.a(str);
        invalidate();
    }
}
