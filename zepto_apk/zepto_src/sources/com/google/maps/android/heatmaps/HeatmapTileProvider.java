package com.google.maps.android.heatmaps;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.media.a;
import androidx.collection.LongSparseArray;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.projection.Point;
import com.google.maps.android.quadtree.PointQuadTree;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class HeatmapTileProvider implements TileProvider {

    /* renamed from: k, reason: collision with root package name */
    public static final Gradient f45604k = new Gradient(new int[]{Color.rgb(102, 225, 0), Color.rgb(255, 0, 0)}, new float[]{0.2f, 1.0f}, 1000);

    /* renamed from: b, reason: collision with root package name */
    public PointQuadTree f45605b;

    /* renamed from: c, reason: collision with root package name */
    public Collection f45606c;

    /* renamed from: d, reason: collision with root package name */
    public Bounds f45607d;

    /* renamed from: e, reason: collision with root package name */
    public int f45608e;

    /* renamed from: f, reason: collision with root package name */
    public Gradient f45609f;

    /* renamed from: g, reason: collision with root package name */
    public int[] f45610g;

    /* renamed from: h, reason: collision with root package name */
    public double[] f45611h;

    /* renamed from: i, reason: collision with root package name */
    public double f45612i;

    /* renamed from: j, reason: collision with root package name */
    public double[] f45613j;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public Collection f45614a;

        /* renamed from: b, reason: collision with root package name */
        public int f45615b = 20;

        /* renamed from: c, reason: collision with root package name */
        public Gradient f45616c = HeatmapTileProvider.f45604k;

        /* renamed from: d, reason: collision with root package name */
        public double f45617d = 0.7d;

        public final HeatmapTileProvider a() {
            if (this.f45614a == null) {
                throw new IllegalStateException("No input data: you must use either .data or .weightedData before building");
            }
            HeatmapTileProvider heatmapTileProvider = new HeatmapTileProvider();
            heatmapTileProvider.f45606c = this.f45614a;
            int i2 = this.f45615b;
            heatmapTileProvider.f45608e = i2;
            heatmapTileProvider.f45609f = this.f45616c;
            heatmapTileProvider.f45612i = this.f45617d;
            heatmapTileProvider.f45611h = HeatmapTileProvider.b(i2, i2 / 3.0d);
            heatmapTileProvider.d(heatmapTileProvider.f45609f);
            heatmapTileProvider.g(heatmapTileProvider.f45606c);
            return heatmapTileProvider;
        }

        public final void b(Gradient gradient) {
            this.f45616c = gradient;
        }

        public final void c(double d2) {
            this.f45617d = d2;
            if (d2 < 0.0d || d2 > 1.0d) {
                throw new IllegalArgumentException("Opacity must be in range [0, 1]");
            }
        }

        public final void d(int i2) {
            this.f45615b = i2;
            if (i2 < 10 || i2 > 50) {
                throw new IllegalArgumentException("Radius not within bounds.");
            }
        }

        public final void e(Collection collection) {
            this.f45614a = collection;
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("No input points.");
            }
        }
    }

    public static double[] b(int i2, double d2) {
        double[] dArr = new double[(i2 * 2) + 1];
        for (int i3 = -i2; i3 <= i2; i3++) {
            dArr[i3 + i2] = Math.exp(((-i3) * i3) / ((2.0d * d2) * d2));
        }
        return dArr;
    }

    @Override // com.google.android.gms.maps.model.TileProvider
    public final Tile a(int i2, int i3, int i4) {
        double d2;
        int i5;
        double dPow = 1.0d / Math.pow(2.0d, i4);
        double d3 = (this.f45608e * dPow) / 512.0d;
        int i6 = 2;
        double d4 = ((d3 * 2.0d) + dPow) / ((r10 * 2) + 512);
        double d5 = (i2 * dPow) - d3;
        boolean z = true;
        double d6 = ((i2 + 1) * dPow) + d3;
        double d7 = (i3 * dPow) - d3;
        double d8 = ((i3 + 1) * dPow) + d3;
        ArrayList<WeightedLatLng> arrayList = new ArrayList();
        if (d5 < 0.0d) {
            arrayList = this.f45605b.b(new Bounds(d5 + 1.0d, 1.0d, d7, d8));
            d2 = -1.0d;
        } else if (d6 > 1.0d) {
            arrayList = this.f45605b.b(new Bounds(0.0d, d6 - 1.0d, d7, d8));
            d2 = 1.0d;
        } else {
            d2 = 0.0d;
        }
        Bounds bounds = new Bounds(d5, d6, d7, d8);
        Bounds bounds2 = this.f45607d;
        if (bounds.b(new Bounds(bounds2.f45590a - d3, bounds2.f45592c + d3, bounds2.f45591b - d3, bounds2.f45593d + d3))) {
            ArrayList arrayListB = this.f45605b.b(bounds);
            if (!arrayListB.isEmpty()) {
                int i7 = (this.f45608e * 2) + 512;
                int[] iArr = {i7, i7};
                int i8 = 0;
                Class cls = Double.TYPE;
                double[][] dArr = (double[][]) Array.newInstance((Class<?>) cls, iArr);
                Iterator it = arrayListB.iterator();
                while (it.hasNext()) {
                    WeightedLatLng weightedLatLng = (WeightedLatLng) it.next();
                    Point point = weightedLatLng.f45619a;
                    boolean z2 = z;
                    double d9 = d2;
                    int i9 = (int) ((point.f45596a - d5) / d4);
                    int i10 = (int) ((point.f45597b - d7) / d4);
                    double[] dArr2 = dArr[i9];
                    dArr2[i10] = dArr2[i10] + weightedLatLng.f45620b;
                    z = z2;
                    d2 = d9;
                }
                boolean z3 = z;
                double d10 = d2;
                for (WeightedLatLng weightedLatLng2 : arrayList) {
                    Point point2 = weightedLatLng2.f45619a;
                    int i11 = (int) (((point2.f45596a + d10) - d5) / d4);
                    int i12 = (int) ((point2.f45597b - d7) / d4);
                    double[] dArr3 = dArr[i11];
                    dArr3[i12] = dArr3[i12] + weightedLatLng2.f45620b;
                    i8 = i8;
                }
                int i13 = i8;
                double[] dArr4 = this.f45611h;
                int iFloor = (int) Math.floor(dArr4.length / 2.0d);
                int length = dArr.length;
                int i14 = length - (iFloor * 2);
                int i15 = iFloor + i14;
                int i16 = i15 - 1;
                int[] iArr2 = new int[2];
                iArr2[z3 ? 1 : 0] = length;
                iArr2[i13] = length;
                double[][] dArr5 = (double[][]) Array.newInstance((Class<?>) cls, iArr2);
                int i17 = i13;
                while (i17 < length) {
                    int i18 = i13;
                    while (i18 < length) {
                        double d11 = dArr[i17][i18];
                        if (d11 != 0.0d) {
                            i5 = i13;
                            int i19 = i17 + iFloor;
                            if (i16 < i19) {
                                i19 = i16;
                            }
                            int i20 = i19 + 1;
                            int i21 = i17 - iFloor;
                            for (int i22 = iFloor > i21 ? iFloor : i21; i22 < i20; i22++) {
                                double[] dArr6 = dArr5[i22];
                                dArr6[i18] = (dArr4[i22 - i21] * d11) + dArr6[i18];
                            }
                        } else {
                            i5 = i13;
                        }
                        i18++;
                        i13 = i5;
                    }
                    i17++;
                    i6 = 2;
                }
                int i23 = i13;
                int[] iArr3 = new int[i6];
                iArr3[z3 ? 1 : 0] = i14;
                iArr3[i23] = i14;
                double[][] dArr7 = (double[][]) Array.newInstance((Class<?>) cls, iArr3);
                for (int i24 = iFloor; i24 < i15; i24++) {
                    for (int i25 = i23; i25 < length; i25++) {
                        double d12 = dArr5[i24][i25];
                        if (d12 != 0.0d) {
                            int i26 = i25 + iFloor;
                            if (i16 < i26) {
                                i26 = i16;
                            }
                            int i27 = i26 + 1;
                            int i28 = i25 - iFloor;
                            for (int i29 = iFloor > i28 ? iFloor : i28; i29 < i27; i29++) {
                                double[] dArr8 = dArr7[i24 - iFloor];
                                int i30 = i29 - iFloor;
                                dArr8[i30] = (dArr4[i29 - i28] * d12) + dArr8[i30];
                            }
                        }
                    }
                }
                int[] iArr4 = this.f45610g;
                double d13 = this.f45613j[i4];
                int i31 = iArr4[iArr4.length - 1];
                double length2 = (iArr4.length - 1) / d13;
                int length3 = dArr7.length;
                int[] iArr5 = new int[length3 * length3];
                for (int i32 = i23; i32 < length3; i32++) {
                    for (int i33 = i23; i33 < length3; i33++) {
                        double d14 = dArr7[i33][i32];
                        int i34 = (i32 * length3) + i33;
                        int i35 = (int) (d14 * length2);
                        if (d14 == 0.0d) {
                            iArr5[i34] = i23;
                        } else if (i35 < iArr4.length) {
                            iArr5[i34] = iArr4[i35];
                        } else {
                            iArr5[i34] = i31;
                        }
                    }
                }
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(length3, length3, Bitmap.Config.ARGB_8888);
                bitmapCreateBitmap.setPixels(iArr5, 0, length3, 0, 0, length3, length3);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                return new Tile(512, byteArrayOutputStream.toByteArray(), 512);
            }
        }
        return TileProvider.f38570a;
    }

    public final double[] c(int i2) {
        int i3;
        int i4 = 22;
        double[] dArr = new double[22];
        int i5 = 5;
        while (true) {
            if (i5 >= 11) {
                break;
            }
            Collection<WeightedLatLng> collection = this.f45606c;
            Bounds bounds = this.f45607d;
            int iPow = (int) (Math.pow(2.0d, i5 - 3) * 1280.0d);
            double d2 = bounds.f45590a;
            double d3 = bounds.f45592c - d2;
            double d4 = bounds.f45593d;
            double d5 = bounds.f45591b;
            double d6 = d4 - d5;
            if (d3 <= d6) {
                d3 = d6;
            }
            double d7 = ((int) ((iPow / (i2 * 2)) + 0.5d)) / d3;
            LongSparseArray longSparseArray = new LongSparseArray();
            double d8 = 0.0d;
            for (WeightedLatLng weightedLatLng : collection) {
                Point point = weightedLatLng.f45619a;
                double[] dArr2 = dArr;
                int i6 = (int) ((point.f45596a - d2) * d7);
                int i7 = i5;
                int i8 = (int) ((point.f45597b - d5) * d7);
                long j2 = i6;
                LongSparseArray longSparseArray2 = (LongSparseArray) longSparseArray.c(j2);
                if (longSparseArray2 == null) {
                    longSparseArray2 = new LongSparseArray();
                    longSparseArray.g(j2, longSparseArray2);
                }
                long j3 = i8;
                Double dValueOf = (Double) longSparseArray2.c(j3);
                if (dValueOf == null) {
                    dValueOf = Double.valueOf(0.0d);
                }
                double dDoubleValue = dValueOf.doubleValue() + weightedLatLng.f45620b;
                longSparseArray2.g(j3, Double.valueOf(dDoubleValue));
                if (dDoubleValue > d8) {
                    d8 = dDoubleValue;
                }
                dArr = dArr2;
                i5 = i7;
            }
            double[] dArr3 = dArr;
            int i9 = i5;
            dArr3[i9] = d8;
            if (i9 == 5) {
                for (int i10 = 0; i10 < i9; i10++) {
                    dArr3[i10] = dArr3[i9];
                }
            }
            i5 = i9 + 1;
            dArr = dArr3;
            i4 = 22;
        }
        double[] dArr4 = dArr;
        int i11 = i4;
        for (i3 = 11; i3 < i11; i3++) {
            dArr4[i3] = dArr4[10];
        }
        return dArr4;
    }

    public final void d(Gradient gradient) {
        this.f45609f = gradient;
        double d2 = this.f45612i;
        gradient.getClass();
        HashMap map = new HashMap();
        float[] fArr = gradient.f45600c;
        int i2 = 0;
        float f2 = fArr[0];
        int[] iArr = gradient.f45599b;
        int i3 = gradient.f45598a;
        if (f2 != 0.0f) {
            map.put(0, new Gradient.ColorInterval(i3 * fArr[0], Color.argb(0, Color.red(iArr[0]), Color.green(iArr[0]), Color.blue(iArr[0])), iArr[0]));
        }
        for (int i4 = 1; i4 < iArr.length; i4++) {
            float f3 = i3;
            int i5 = i4 - 1;
            map.put(Integer.valueOf((int) (fArr[i5] * f3)), new Gradient.ColorInterval(f3 * (fArr[i4] - fArr[i5]), iArr[i5], iArr[i4]));
        }
        if (fArr[fArr.length - 1] != 1.0f) {
            int length = fArr.length - 1;
            float f4 = i3;
            Integer numValueOf = Integer.valueOf((int) (fArr[length] * f4));
            int i6 = iArr[length];
            map.put(numValueOf, new Gradient.ColorInterval((1.0f - fArr[length]) * f4, i6, i6));
        }
        int[] iArr2 = new int[i3];
        Gradient.ColorInterval colorInterval = (Gradient.ColorInterval) map.get(0);
        int i7 = 0;
        int i8 = 0;
        while (i7 < i3) {
            if (map.containsKey(Integer.valueOf(i7))) {
                colorInterval = (Gradient.ColorInterval) map.get(Integer.valueOf(i7));
                i8 = i7;
            }
            float f5 = (i7 - i8) / colorInterval.f45603c;
            int i9 = colorInterval.f45602b;
            int iAlpha = Color.alpha(i9);
            int i10 = colorInterval.f45601a;
            int iAlpha2 = (int) (((iAlpha - Color.alpha(i10)) * f5) + Color.alpha(i10));
            float[] fArr2 = new float[3];
            int i11 = i2;
            Color.RGBToHSV(Color.red(i10), Color.green(i10), Color.blue(i10), fArr2);
            float[] fArr3 = new float[3];
            Color.RGBToHSV(Color.red(i9), Color.green(i9), Color.blue(i9), fArr3);
            float f6 = fArr2[i11];
            float f7 = fArr3[i11];
            if (f6 - f7 > 180.0f) {
                fArr3[i11] = f7 + 360.0f;
            } else if (f7 - f6 > 180.0f) {
                fArr2[i11] = f6 + 360.0f;
            }
            float[] fArr4 = new float[3];
            int i12 = i11;
            for (int i13 = 3; i12 < i13; i13 = 3) {
                float f8 = fArr3[i12];
                double d3 = d2;
                float f9 = fArr2[i12];
                fArr4[i12] = a.a(f8, f9, f5, f9);
                i12++;
                d2 = d3;
            }
            iArr2[i7] = Color.HSVToColor(iAlpha2, fArr4);
            i7++;
            i2 = i11;
            d2 = d2;
        }
        double d4 = d2;
        int i14 = i2;
        if (d4 != 1.0d) {
            for (int i15 = i14; i15 < i3; i15++) {
                int i16 = iArr2[i15];
                iArr2[i15] = Color.argb((int) (Color.alpha(i16) * d4), Color.red(i16), Color.green(i16), Color.blue(i16));
            }
        }
        this.f45610g = iArr2;
    }

    public final void e(double d2) {
        this.f45612i = d2;
        d(this.f45609f);
    }

    public final void f(int i2) {
        this.f45608e = i2;
        this.f45611h = b(i2, i2 / 3.0d);
        this.f45613j = c(this.f45608e);
    }

    public final void g(Collection collection) {
        this.f45606c = collection;
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("No input points.");
        }
        Iterator it = this.f45606c.iterator();
        Point point = ((WeightedLatLng) it.next()).f45619a;
        double d2 = point.f45596a;
        double d3 = d2;
        double d4 = point.f45597b;
        double d5 = d4;
        while (it.hasNext()) {
            Point point2 = ((WeightedLatLng) it.next()).f45619a;
            double d6 = point2.f45596a;
            if (d6 < d2) {
                d2 = d6;
            }
            if (d6 > d3) {
                d3 = d6;
            }
            double d7 = point2.f45597b;
            if (d7 < d4) {
                d4 = d7;
            }
            if (d7 > d5) {
                d5 = d7;
            }
        }
        Bounds bounds = new Bounds(d2, d3, d4, d5);
        this.f45607d = bounds;
        this.f45605b = new PointQuadTree(bounds, 0);
        for (WeightedLatLng weightedLatLng : this.f45606c) {
            PointQuadTree pointQuadTree = this.f45605b;
            pointQuadTree.getClass();
            Point point3 = weightedLatLng.f45619a;
            if (pointQuadTree.f45622a.a(point3.f45596a, point3.f45597b)) {
                pointQuadTree.a(point3.f45596a, point3.f45597b, weightedLatLng);
            }
        }
        this.f45613j = c(this.f45608e);
    }
}
