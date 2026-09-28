package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbf {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f21525a;

    /* renamed from: b, reason: collision with root package name */
    public final double[] f21526b;

    /* renamed from: c, reason: collision with root package name */
    public final double[] f21527c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f21528d;

    /* renamed from: e, reason: collision with root package name */
    public int f21529e;

    public zzbf(zzbe zzbeVar) {
        ArrayList arrayList = zzbeVar.f21523b;
        int size = arrayList.size();
        this.f21525a = (String[]) zzbeVar.f21522a.toArray(new String[size]);
        int size2 = arrayList.size();
        double[] dArr = new double[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            dArr[i2] = ((Double) arrayList.get(i2)).doubleValue();
        }
        this.f21526b = dArr;
        ArrayList arrayList2 = zzbeVar.f21524c;
        int size3 = arrayList2.size();
        double[] dArr2 = new double[size3];
        for (int i3 = 0; i3 < size3; i3++) {
            dArr2[i3] = ((Double) arrayList2.get(i3)).doubleValue();
        }
        this.f21527c = dArr2;
        this.f21528d = new int[size];
        this.f21529e = 0;
    }
}
