package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
class CircleView extends RenderableView {

    /* renamed from: a, reason: collision with root package name */
    public SVGLength f45648a;

    /* renamed from: b, reason: collision with root package name */
    public SVGLength f45649b;

    /* renamed from: c, reason: collision with root package name */
    public SVGLength f45650c;

    @Override // com.horcrux.svg.RenderableView, com.horcrux.svg.VirtualView
    public final Path getPath(Canvas canvas, Paint paint) {
        Path path = new Path();
        double dRelativeOnWidth = relativeOnWidth(this.f45648a);
        double dRelativeOnHeight = relativeOnHeight(this.f45649b);
        double dRelativeOnOther = relativeOnOther(this.f45650c);
        path.addCircle((float) dRelativeOnWidth, (float) dRelativeOnHeight, (float) dRelativeOnOther, Path.Direction.CW);
        ArrayList<PathElement> arrayList = new ArrayList<>();
        this.elements = arrayList;
        double d2 = dRelativeOnHeight - dRelativeOnOther;
        arrayList.add(new PathElement(ElementType.f45652b, new Point[]{new Point(dRelativeOnWidth, d2)}));
        ArrayList<PathElement> arrayList2 = this.elements;
        ElementType elementType = ElementType.f45653c;
        double d3 = dRelativeOnWidth + dRelativeOnOther;
        arrayList2.add(new PathElement(elementType, new Point[]{new Point(dRelativeOnWidth, d2), new Point(d3, dRelativeOnHeight)}));
        double d4 = dRelativeOnHeight + dRelativeOnOther;
        this.elements.add(new PathElement(elementType, new Point[]{new Point(d3, dRelativeOnHeight), new Point(dRelativeOnWidth, d4)}));
        ArrayList<PathElement> arrayList3 = this.elements;
        Point point = new Point(dRelativeOnWidth, d4);
        double d5 = dRelativeOnWidth - dRelativeOnOther;
        arrayList3.add(new PathElement(elementType, new Point[]{point, new Point(d5, dRelativeOnHeight)}));
        this.elements.add(new PathElement(elementType, new Point[]{new Point(d5, dRelativeOnHeight), new Point(dRelativeOnWidth, d2)}));
        return path;
    }
}
