package com.horcrux.svg;

import com.facebook.react.bridge.ReadableMap;
import java.util.ArrayList;

/* loaded from: classes4.dex */
class GlyphContext {
    public double[] A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public final float M;
    public final float N;
    public final float O;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f45732a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f45733b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f45734c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f45735d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f45736e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f45737f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f45738g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f45739h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f45740i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f45741j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f45742k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f45743l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f45744m;
    public final ArrayList n;
    public final ArrayList o;
    public final ArrayList p;
    public double q;
    public FontData r;
    public double s;
    public double t;
    public double u;
    public double v;
    public SVGLength[] w;
    public SVGLength[] x;
    public SVGLength[] y;
    public SVGLength[] z;

    public GlyphContext(float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        this.f45732a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f45733b = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.f45734c = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        this.f45735d = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        this.f45736e = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        this.f45737f = arrayList6;
        ArrayList arrayList7 = new ArrayList();
        this.f45738g = arrayList7;
        ArrayList arrayList8 = new ArrayList();
        this.f45739h = arrayList8;
        ArrayList arrayList9 = new ArrayList();
        this.f45740i = arrayList9;
        ArrayList arrayList10 = new ArrayList();
        this.f45741j = arrayList10;
        ArrayList arrayList11 = new ArrayList();
        this.f45742k = arrayList11;
        this.f45743l = new ArrayList();
        this.f45744m = new ArrayList();
        this.n = new ArrayList();
        this.o = new ArrayList();
        this.p = new ArrayList();
        this.q = 12.0d;
        this.r = FontData.p;
        SVGLength[] sVGLengthArr = new SVGLength[0];
        this.w = sVGLengthArr;
        this.x = new SVGLength[0];
        this.y = new SVGLength[0];
        this.z = new SVGLength[0];
        this.A = new double[]{0.0d};
        this.G = -1;
        this.H = -1;
        this.I = -1;
        this.J = -1;
        this.K = -1;
        this.M = f2;
        this.N = f3;
        this.O = f4;
        arrayList2.add(sVGLengthArr);
        arrayList3.add(this.x);
        arrayList4.add(this.y);
        arrayList5.add(this.z);
        arrayList6.add(this.A);
        arrayList7.add(Integer.valueOf(this.G));
        arrayList8.add(Integer.valueOf(this.H));
        arrayList9.add(Integer.valueOf(this.I));
        arrayList10.add(Integer.valueOf(this.J));
        arrayList11.add(Integer.valueOf(this.K));
        arrayList.add(this.r);
        o();
    }

    public static SVGLength[] d(ArrayList arrayList) {
        int size = arrayList.size();
        SVGLength[] sVGLengthArr = new SVGLength[size];
        for (int i2 = 0; i2 < size; i2++) {
            sVGLengthArr[i2] = (SVGLength) arrayList.get(i2);
        }
        return sVGLengthArr;
    }

    public static void f(int i2, ArrayList arrayList) {
        while (i2 >= 0) {
            arrayList.set(i2, Integer.valueOf(((Integer) arrayList.get(i2)).intValue() + 1));
            i2--;
        }
    }

    public final FontData a() {
        return this.r;
    }

    public final double b() {
        return this.q;
    }

    public final float c() {
        return this.O;
    }

    public final float e() {
        return this.N;
    }

    public final double g() {
        f(this.D, this.f45740i);
        int i2 = this.I + 1;
        SVGLength[] sVGLengthArr = this.y;
        if (i2 < sVGLengthArr.length) {
            this.I = i2;
            this.u += PropHelper.b(sVGLengthArr[i2], this.N, this.M, this.q);
        }
        return this.u;
    }

    public final double h() {
        f(this.E, this.f45741j);
        int i2 = this.J + 1;
        SVGLength[] sVGLengthArr = this.z;
        if (i2 < sVGLengthArr.length) {
            this.J = i2;
            this.v += PropHelper.b(sVGLengthArr[i2], this.O, this.M, this.q);
        }
        return this.v;
    }

    public final double i() {
        f(this.F, this.f45742k);
        int iMin = Math.min(this.K + 1, this.A.length - 1);
        this.K = iMin;
        return this.A[iMin];
    }

    public final double j(double d2) {
        f(this.B, this.f45738g);
        int i2 = this.G + 1;
        SVGLength[] sVGLengthArr = this.w;
        if (i2 < sVGLengthArr.length) {
            this.u = 0.0d;
            this.G = i2;
            this.s = PropHelper.b(sVGLengthArr[i2], this.N, this.M, this.q);
        }
        double d3 = this.s + d2;
        this.s = d3;
        return d3;
    }

    public final double k() {
        f(this.C, this.f45739h);
        int i2 = this.H + 1;
        SVGLength[] sVGLengthArr = this.x;
        if (i2 < sVGLengthArr.length) {
            this.v = 0.0d;
            this.H = i2;
            this.t = PropHelper.b(sVGLengthArr[i2], this.O, this.M, this.q);
        }
        return this.t;
    }

    public final void l() {
        ArrayList arrayList = this.f45732a;
        arrayList.remove(this.L);
        ArrayList arrayList2 = this.f45743l;
        arrayList2.remove(this.L);
        ArrayList arrayList3 = this.f45744m;
        arrayList3.remove(this.L);
        ArrayList arrayList4 = this.n;
        arrayList4.remove(this.L);
        ArrayList arrayList5 = this.o;
        arrayList5.remove(this.L);
        ArrayList arrayList6 = this.p;
        arrayList6.remove(this.L);
        int i2 = this.L - 1;
        this.L = i2;
        int i3 = this.B;
        int i4 = this.C;
        int i5 = this.D;
        int i6 = this.E;
        int i7 = this.F;
        this.r = (FontData) arrayList.get(i2);
        this.B = ((Integer) arrayList2.get(this.L)).intValue();
        this.C = ((Integer) arrayList3.get(this.L)).intValue();
        this.D = ((Integer) arrayList4.get(this.L)).intValue();
        this.E = ((Integer) arrayList5.get(this.L)).intValue();
        this.F = ((Integer) arrayList6.get(this.L)).intValue();
        if (i3 != this.B) {
            ArrayList arrayList7 = this.f45733b;
            arrayList7.remove(i3);
            this.w = (SVGLength[]) arrayList7.get(this.B);
            this.G = ((Integer) this.f45738g.get(this.B)).intValue();
        }
        if (i4 != this.C) {
            ArrayList arrayList8 = this.f45734c;
            arrayList8.remove(i4);
            this.x = (SVGLength[]) arrayList8.get(this.C);
            this.H = ((Integer) this.f45739h.get(this.C)).intValue();
        }
        if (i5 != this.D) {
            ArrayList arrayList9 = this.f45735d;
            arrayList9.remove(i5);
            this.y = (SVGLength[]) arrayList9.get(this.D);
            this.I = ((Integer) this.f45740i.get(this.D)).intValue();
        }
        if (i6 != this.E) {
            ArrayList arrayList10 = this.f45736e;
            arrayList10.remove(i6);
            this.z = (SVGLength[]) arrayList10.get(this.E);
            this.J = ((Integer) this.f45741j.get(this.E)).intValue();
        }
        if (i7 != this.F) {
            ArrayList arrayList11 = this.f45737f;
            arrayList11.remove(i7);
            this.A = (double[]) arrayList11.get(this.F);
            this.K = ((Integer) this.f45742k.get(this.F)).intValue();
        }
    }

    public final void m(GroupView groupView, ReadableMap readableMap) {
        p(groupView, readableMap);
        o();
    }

    public final void n(boolean z, TextView textView, ReadableMap readableMap, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        if (z) {
            this.F = 0;
            this.E = 0;
            this.D = 0;
            this.C = 0;
            this.B = 0;
            this.K = -1;
            this.J = -1;
            this.I = -1;
            this.H = -1;
            this.G = -1;
            this.v = 0.0d;
            this.u = 0.0d;
            this.t = 0.0d;
            this.s = 0.0d;
        }
        p(textView, readableMap);
        if (arrayList != null && arrayList.size() != 0) {
            this.B++;
            this.G = -1;
            this.f45738g.add(-1);
            SVGLength[] sVGLengthArrD = d(arrayList);
            this.w = sVGLengthArrD;
            this.f45733b.add(sVGLengthArrD);
        }
        if (arrayList2 != null && arrayList2.size() != 0) {
            this.C++;
            this.H = -1;
            this.f45739h.add(-1);
            SVGLength[] sVGLengthArrD2 = d(arrayList2);
            this.x = sVGLengthArrD2;
            this.f45734c.add(sVGLengthArrD2);
        }
        if (arrayList3 != null && arrayList3.size() != 0) {
            this.D++;
            this.I = -1;
            this.f45740i.add(-1);
            SVGLength[] sVGLengthArrD3 = d(arrayList3);
            this.y = sVGLengthArrD3;
            this.f45735d.add(sVGLengthArrD3);
        }
        if (arrayList4 != null && arrayList4.size() != 0) {
            this.E++;
            this.J = -1;
            this.f45741j.add(-1);
            SVGLength[] sVGLengthArrD4 = d(arrayList4);
            this.z = sVGLengthArrD4;
            this.f45736e.add(sVGLengthArrD4);
        }
        if (arrayList5 != null && arrayList5.size() != 0) {
            this.F++;
            this.K = -1;
            this.f45742k.add(-1);
            int size = arrayList5.size();
            double[] dArr = new double[size];
            for (int i2 = 0; i2 < size; i2++) {
                dArr[i2] = ((SVGLength) arrayList5.get(i2)).f45853a;
            }
            this.A = dArr;
            this.f45737f.add(dArr);
        }
        o();
    }

    public final void o() {
        this.f45743l.add(Integer.valueOf(this.B));
        this.f45744m.add(Integer.valueOf(this.C));
        this.n.add(Integer.valueOf(this.D));
        this.o.add(Integer.valueOf(this.E));
        this.p.add(Integer.valueOf(this.F));
    }

    public final void p(GroupView groupView, ReadableMap readableMap) {
        FontData fontData;
        if (this.L > 0) {
            fontData = this.r;
        } else {
            GroupView parentTextRoot = groupView.getParentTextRoot();
            while (true) {
                if (parentTextRoot == null) {
                    fontData = FontData.p;
                    break;
                }
                FontData fontData2 = parentTextRoot.f45749b.r;
                if (fontData2 != FontData.p) {
                    fontData = fontData2;
                    break;
                }
                parentTextRoot = parentTextRoot.getParentTextRoot();
            }
        }
        this.L++;
        ArrayList arrayList = this.f45732a;
        if (readableMap == null) {
            arrayList.add(fontData);
            return;
        }
        FontData fontData3 = new FontData(readableMap, fontData, this.M);
        this.q = fontData3.f45712a;
        arrayList.add(fontData3);
        this.r = fontData3;
    }
}
