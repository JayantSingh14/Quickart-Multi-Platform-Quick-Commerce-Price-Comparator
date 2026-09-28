package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.horcrux.svg.TextProperties;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class TextPathView extends TextView {
    public String q;
    public TextProperties.TextPathSide r;
    public TextProperties.TextPathMidLine s;
    public SVGLength t;

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final void draw(Canvas canvas, Paint paint, float f2) {
        j(canvas, paint, f2);
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView, com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final Path getPath(Canvas canvas, Paint paint) {
        return q(canvas, paint);
    }

    @Override // com.horcrux.svg.GroupView
    public final void n() {
    }

    @Override // com.horcrux.svg.TextView, com.horcrux.svg.GroupView
    public final void o() {
    }

    @Override // com.horcrux.svg.TextView
    public final void s(String str) {
        TextProperties.TextPathMethod.valueOf(str);
        invalidate();
    }
}
