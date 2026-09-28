package com.horcrux.svg;

import android.graphics.Paint;
import android.graphics.Path;
import java.util.ArrayList;

/* loaded from: classes4.dex */
class GlyphPathBag {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f45745a;

    /* renamed from: b, reason: collision with root package name */
    public final int[][] f45746b;

    /* renamed from: c, reason: collision with root package name */
    public final Paint f45747c;

    public GlyphPathBag(Paint paint) {
        ArrayList arrayList = new ArrayList();
        this.f45745a = arrayList;
        this.f45746b = new int[256][];
        this.f45747c = paint;
        arrayList.add(new Path());
    }

    public final Path a(String str, char c2) {
        Path path;
        int i2 = c2 >> '\b';
        int[][] iArr = this.f45746b;
        int[] iArr2 = iArr[i2];
        int i3 = iArr2 == null ? 0 : iArr2[c2 & 255];
        ArrayList arrayList = this.f45745a;
        if (i3 != 0) {
            path = (Path) arrayList.get(i3);
        } else {
            Path path2 = new Path();
            this.f45747c.getTextPath(str, 0, 1, 0.0f, 0.0f, path2);
            int[] iArr3 = iArr[i2];
            if (iArr3 == null) {
                iArr3 = new int[256];
                iArr[i2] = iArr3;
            }
            iArr3[c2 & 255] = arrayList.size();
            arrayList.add(path2);
            path = path2;
        }
        Path path3 = new Path();
        path3.addPath(path);
        return path3;
    }
}
