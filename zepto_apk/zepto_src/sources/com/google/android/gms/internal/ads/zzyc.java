package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* loaded from: classes4.dex */
final class zzyc {

    /* renamed from: a, reason: collision with root package name */
    public int f35894a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f35895b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdr f35896c;

    public zzyc() {
        this(zzyb.f35893a);
    }

    public final Object a(int i2) {
        SparseArray sparseArray;
        if (this.f35894a == -1) {
            this.f35894a = 0;
        }
        while (true) {
            int i3 = this.f35894a;
            sparseArray = this.f35895b;
            if (i3 <= 0 || i2 >= sparseArray.keyAt(i3)) {
                break;
            }
            this.f35894a--;
        }
        while (this.f35894a < sparseArray.size() - 1 && i2 >= sparseArray.keyAt(this.f35894a + 1)) {
            this.f35894a++;
        }
        return sparseArray.valueAt(this.f35894a);
    }

    public zzyc(zzdr zzdrVar) {
        this.f35895b = new SparseArray();
        this.f35896c = zzdrVar;
        this.f35894a = -1;
    }
}
