package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbe {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f21522a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f21523b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f21524c = new ArrayList();

    public final void a(String str, double d2, double d3) {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i2 = 0;
        while (true) {
            arrayList = this.f21522a;
            int size = arrayList.size();
            arrayList2 = this.f21523b;
            arrayList3 = this.f21524c;
            if (i2 >= size) {
                break;
            }
            double dDoubleValue = ((Double) arrayList3.get(i2)).doubleValue();
            double dDoubleValue2 = ((Double) arrayList2.get(i2)).doubleValue();
            if (d2 < dDoubleValue || (dDoubleValue == d2 && d3 < dDoubleValue2)) {
                break;
            } else {
                i2++;
            }
        }
        arrayList.add(i2, str);
        arrayList3.add(i2, Double.valueOf(d2));
        arrayList2.add(i2, Double.valueOf(d3));
    }
}
