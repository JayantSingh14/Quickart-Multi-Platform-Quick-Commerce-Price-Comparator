package com.google.maps.android.quadtree;

import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.quadtree.PointQuadTree.Item;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes4.dex */
public class PointQuadTree<T extends Item> {

    /* renamed from: a, reason: collision with root package name */
    public final Bounds f45622a;

    /* renamed from: b, reason: collision with root package name */
    public final int f45623b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashSet f45624c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f45625d;

    public interface Item {
        Point a();
    }

    public PointQuadTree(double d2, double d3, double d4, double d5, int i2) {
        this(new Bounds(d2, d3, d4, d5), i2);
    }

    public final void a(double d2, double d3, Item item) {
        int i2;
        PointQuadTree<T> pointQuadTree = this;
        ArrayList arrayList = pointQuadTree.f45625d;
        Bounds bounds = pointQuadTree.f45622a;
        if (arrayList != null) {
            double d4 = bounds.f45595f;
            double d5 = bounds.f45594e;
            if (d3 < d4) {
                if (d2 < d5) {
                    ((PointQuadTree) arrayList.get(0)).a(d2, d3, item);
                    return;
                } else {
                    ((PointQuadTree) arrayList.get(1)).a(d2, d3, item);
                    return;
                }
            }
            if (d2 < d5) {
                ((PointQuadTree) arrayList.get(2)).a(d2, d3, item);
                return;
            } else {
                ((PointQuadTree) arrayList.get(3)).a(d2, d3, item);
                return;
            }
        }
        if (pointQuadTree.f45624c == null) {
            pointQuadTree.f45624c = new LinkedHashSet();
        }
        pointQuadTree.f45624c.add(item);
        if (pointQuadTree.f45624c.size() <= 50 || (i2 = pointQuadTree.f45623b) >= 40) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(4);
        pointQuadTree.f45625d = arrayList2;
        int i3 = i2 + 1;
        arrayList2.add(new PointQuadTree(bounds.f45590a, bounds.f45594e, bounds.f45591b, bounds.f45595f, i3));
        pointQuadTree.f45625d.add(new PointQuadTree(bounds.f45594e, bounds.f45592c, bounds.f45591b, bounds.f45595f, i3));
        pointQuadTree.f45625d.add(new PointQuadTree(bounds.f45590a, bounds.f45594e, bounds.f45595f, bounds.f45593d, i3));
        pointQuadTree.f45625d.add(new PointQuadTree(bounds.f45594e, bounds.f45592c, bounds.f45595f, bounds.f45593d, i3));
        LinkedHashSet<Item> linkedHashSet = pointQuadTree.f45624c;
        pointQuadTree.f45624c = null;
        for (Item item2 : linkedHashSet) {
            pointQuadTree.a(item2.a().f45596a, item2.a().f45597b, item2);
            pointQuadTree = this;
        }
    }

    public final ArrayList b(Bounds bounds) {
        ArrayList arrayList = new ArrayList();
        c(bounds, arrayList);
        return arrayList;
    }

    public final void c(Bounds bounds, ArrayList arrayList) {
        Bounds bounds2 = this.f45622a;
        if (bounds2.b(bounds)) {
            ArrayList arrayList2 = this.f45625d;
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((PointQuadTree) it.next()).c(bounds, arrayList);
                }
                return;
            }
            LinkedHashSet<Item> linkedHashSet = this.f45624c;
            if (linkedHashSet != null) {
                if (bounds2.f45590a >= bounds.f45590a && bounds2.f45592c <= bounds.f45592c && bounds2.f45591b >= bounds.f45591b && bounds2.f45593d <= bounds.f45593d) {
                    arrayList.addAll(linkedHashSet);
                    return;
                }
                for (Item item : linkedHashSet) {
                    Point pointA = item.a();
                    if (bounds.a(pointA.f45596a, pointA.f45597b)) {
                        arrayList.add(item);
                    }
                }
            }
        }
    }

    public PointQuadTree(Bounds bounds, int i2) {
        this.f45625d = null;
        this.f45622a = bounds;
        this.f45623b = i2;
    }
}
