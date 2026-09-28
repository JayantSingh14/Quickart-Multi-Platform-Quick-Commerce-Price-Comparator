package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class LineView extends RenderableView {

    /* renamed from: a, reason: collision with root package name */
    public SVGLength f45764a;

    /* renamed from: b, reason: collision with root package name */
    public SVGLength f45765b;

    /* renamed from: c, reason: collision with root package name */
    public SVGLength f45766c;

    /* renamed from: d, reason: collision with root package name */
    public SVGLength f45767d;

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double dRelativeOnWidth = relativeOnWidth(this.f45764a);
        double dRelativeOnHeight = relativeOnHeight(this.f45765b);
        double dRelativeOnWidth2 = relativeOnWidth(this.f45766c);
        double dRelativeOnHeight2 = relativeOnHeight(this.f45767d);
        path.moveTo((float) dRelativeOnWidth, (float) dRelativeOnHeight);
        path.lineTo((float) dRelativeOnWidth2, (float) dRelativeOnHeight2);
        ArrayList<PathElement> arrayList = new ArrayList<>();
        this.elements = arrayList;
        arrayList.add(new PathElement(ElementType.f45652b, new Point[]{new Point(dRelativeOnWidth, dRelativeOnHeight)}));
        this.elements.add(new PathElement(ElementType.f45653c, new Point[]{new Point(dRelativeOnWidth2, dRelativeOnHeight2)}));
        return path;
    }
}
