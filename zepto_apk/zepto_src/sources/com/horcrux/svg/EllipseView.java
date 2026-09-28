package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class EllipseView extends RenderableView {

    /* renamed from: a, reason: collision with root package name */
    public SVGLength f45656a;

    /* renamed from: b, reason: collision with root package name */
    public SVGLength f45657b;

    /* renamed from: c, reason: collision with root package name */
    public SVGLength f45658c;

    /* renamed from: d, reason: collision with root package name */
    public SVGLength f45659d;

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double dRelativeOnWidth = relativeOnWidth(this.f45656a);
        double dRelativeOnHeight = relativeOnHeight(this.f45657b);
        double dRelativeOnWidth2 = relativeOnWidth(this.f45658c);
        double dRelativeOnHeight2 = relativeOnHeight(this.f45659d);
        double d2 = dRelativeOnWidth - dRelativeOnWidth2;
        double d3 = dRelativeOnHeight - dRelativeOnHeight2;
        double d4 = dRelativeOnWidth + dRelativeOnWidth2;
        double d5 = dRelativeOnHeight + dRelativeOnHeight2;
        path.addOval(new RectF((float) d2, (float) d3, (float) d4, (float) d5), Path.Direction.CW);
        ArrayList<PathElement> arrayList = new ArrayList<>();
        this.elements = arrayList;
        arrayList.add(new PathElement(ElementType.f45652b, new Point[]{new Point(dRelativeOnWidth, d3)}));
        ArrayList<PathElement> arrayList2 = this.elements;
        ElementType elementType = ElementType.f45653c;
        arrayList2.add(new PathElement(elementType, new Point[]{new Point(dRelativeOnWidth, d3), new Point(d4, dRelativeOnHeight)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(d4, dRelativeOnHeight), new Point(dRelativeOnWidth, d5)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(dRelativeOnWidth, d5), new Point(d2, dRelativeOnHeight)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(d2, dRelativeOnHeight), new Point(dRelativeOnWidth, d3)}));
        return path;
    }
}
