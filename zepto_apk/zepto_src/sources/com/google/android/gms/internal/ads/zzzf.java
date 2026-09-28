package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.time.DateUtils;

/* loaded from: classes4.dex */
public final class zzzf extends zzbl {
    public static final zzzf F = new zzzf(new zzze());
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final SparseArray D;
    public final SparseBooleanArray E;
    public final boolean w;
    public final boolean x;
    public final boolean y;
    public final boolean z;

    static {
        String str = zzfj.f31254a;
        Integer.toString(1000, 36);
        Integer.toString(DateUtils.SEMI_MONTH, 36);
        Integer.toString(1002, 36);
        Integer.toString(1003, 36);
        Integer.toString(1004, 36);
        Integer.toString(1005, 36);
        Integer.toString(1006, 36);
        Integer.toString(1007, 36);
        Integer.toString(1008, 36);
        Integer.toString(1009, 36);
        Integer.toString(1010, 36);
        Integer.toString(1011, 36);
        Integer.toString(1012, 36);
        Integer.toString(1013, 36);
        Integer.toString(1014, 36);
        Integer.toString(1015, 36);
        Integer.toString(1016, 36);
        Integer.toString(1017, 36);
        Integer.toString(1018, 36);
    }

    public zzzf(zzze zzzeVar) {
        super(zzzeVar);
        this.w = zzzeVar.w;
        this.x = zzzeVar.x;
        this.y = zzzeVar.y;
        this.z = zzzeVar.z;
        this.A = zzzeVar.A;
        this.B = zzzeVar.B;
        this.C = zzzeVar.C;
        this.D = zzzeVar.D;
        this.E = zzzeVar.E;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzzf.class == obj.getClass()) {
            zzzf zzzfVar = (zzzf) obj;
            if (super.equals(zzzfVar) && this.w == zzzfVar.w && this.x == zzzfVar.x && this.y == zzzfVar.y && this.z == zzzfVar.z && this.A == zzzfVar.A && this.B == zzzfVar.B && this.C == zzzfVar.C) {
                SparseBooleanArray sparseBooleanArray = this.E;
                int size = sparseBooleanArray.size();
                SparseBooleanArray sparseBooleanArray2 = zzzfVar.E;
                if (sparseBooleanArray2.size() == size) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            SparseArray sparseArray = this.D;
                            int size2 = sparseArray.size();
                            SparseArray sparseArray2 = zzzfVar.D;
                            if (sparseArray2.size() == size2) {
                                for (int i3 = 0; i3 < size2; i3++) {
                                    int iIndexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i3));
                                    if (iIndexOfKey >= 0) {
                                        Map map = (Map) sparseArray.valueAt(i3);
                                        Map map2 = (Map) sparseArray2.valueAt(iIndexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                zzyh zzyhVar = (zzyh) entry.getKey();
                                                if (!map2.containsKey(zzyhVar) || !Objects.equals(entry.getValue(), map2.get(zzyhVar))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        } else {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i2)) < 0) {
                                break;
                            }
                            i2++;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbl
    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.w ? 1 : 0)) * 961) + (this.x ? 1 : 0)) * 961) + (this.y ? 1 : 0)) * 28629151) + (this.z ? 1 : 0)) * 31) + (this.A ? 1 : 0)) * 31) + (this.B ? 1 : 0)) * 961) + (this.C ? 1 : 0)) * 31;
    }
}
