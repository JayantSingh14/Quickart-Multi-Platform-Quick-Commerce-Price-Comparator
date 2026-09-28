package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzze extends zzbk {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final SparseArray D;
    public final SparseBooleanArray E;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final boolean z;

    public zzze() {
        this.D = new SparseArray();
        this.E = new SparseBooleanArray();
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = true;
        this.A = true;
        this.B = true;
        this.C = true;
    }

    public zzze(zzzf zzzfVar) {
        a(zzzfVar);
        this.w = zzzfVar.w;
        this.x = zzzfVar.x;
        this.y = zzzfVar.y;
        this.z = zzzfVar.z;
        this.A = zzzfVar.A;
        this.B = zzzfVar.B;
        this.C = zzzfVar.C;
        SparseArray sparseArray = new SparseArray();
        int i2 = 0;
        while (true) {
            SparseArray sparseArray2 = zzzfVar.D;
            if (i2 < sparseArray2.size()) {
                sparseArray.put(sparseArray2.keyAt(i2), new HashMap((Map) sparseArray2.valueAt(i2)));
                i2++;
            } else {
                this.D = sparseArray;
                this.E = zzzfVar.E.clone();
                return;
            }
        }
    }
}
