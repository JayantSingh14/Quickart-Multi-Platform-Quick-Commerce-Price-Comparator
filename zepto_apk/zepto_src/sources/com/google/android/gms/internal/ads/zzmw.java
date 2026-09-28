package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* loaded from: classes4.dex */
public final class zzmw {

    /* renamed from: a, reason: collision with root package name */
    public final zzs f35242a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f35243b;

    public zzmw(zzs zzsVar, SparseArray sparseArray) {
        this.f35242a = zzsVar;
        SparseBooleanArray sparseBooleanArray = zzsVar.f35478a;
        SparseArray sparseArray2 = new SparseArray(sparseBooleanArray.size());
        for (int i2 = 0; i2 < sparseBooleanArray.size(); i2++) {
            zzgqa.i(i2, sparseBooleanArray.size());
            int iKeyAt = sparseBooleanArray.keyAt(i2);
            zzmv zzmvVar = (zzmv) sparseArray.get(iKeyAt);
            zzmvVar.getClass();
            sparseArray2.append(iKeyAt, zzmvVar);
        }
        this.f35243b = sparseArray2;
    }

    public final boolean a(int i2) {
        return this.f35242a.f35478a.get(i2);
    }
}
