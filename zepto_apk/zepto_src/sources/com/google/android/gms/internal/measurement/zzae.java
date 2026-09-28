package com.google.android.gms.internal.measurement;

import androidx.fragment.app.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public final class zzae implements Iterable, zzao, zzak {

    /* renamed from: a, reason: collision with root package name */
    public final TreeMap f36756a;

    /* renamed from: b, reason: collision with root package name */
    public final TreeMap f36757b;

    public zzae() {
        this.f36756a = new TreeMap();
        this.f36757b = new TreeMap();
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final zzao b(String str) {
        zzao zzaoVar;
        return "length".equals(str) ? new zzah(Double.valueOf(n())) : (!j(str) || (zzaoVar = (zzao) this.f36757b.get(str)) == null) ? zzao.o0 : zzaoVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final void d(String str, zzao zzaoVar) {
        TreeMap treeMap = this.f36757b;
        if (zzaoVar == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, zzaoVar);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzae)) {
            return false;
        }
        zzae zzaeVar = (zzae) obj;
        if (n() != zzaeVar.n()) {
            return false;
        }
        TreeMap treeMap = this.f36756a;
        if (treeMap.isEmpty()) {
            return zzaeVar.f36756a.isEmpty();
        }
        for (int iIntValue = ((Integer) treeMap.firstKey()).intValue(); iIntValue <= ((Integer) treeMap.lastKey()).intValue(); iIntValue++) {
            if (!o(iIntValue).equals(zzaeVar.o(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final zzao f() {
        zzae zzaeVar = new zzae();
        for (Map.Entry entry : this.f36756a.entrySet()) {
            boolean z = entry.getValue() instanceof zzak;
            TreeMap treeMap = zzaeVar.f36756a;
            if (z) {
                treeMap.put((Integer) entry.getKey(), (zzao) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((zzao) entry.getValue()).f());
            }
        }
        return zzaeVar;
    }

    public final int hashCode() {
        return this.f36756a.hashCode() * 31;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x0827, code lost:
    
        if (com.google.android.gms.internal.measurement.zzba.b(r29, r31, (com.google.android.gms.internal.measurement.zzan) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).n() == n()) goto L379;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x03fc  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0470  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0513  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0554  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x055e  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x05df  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x068a  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x06c8  */
    /* JADX WARN: Removed duplicated region for block: B:348:0x0764  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0792  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x07f3  */
    /* JADX WARN: Removed duplicated region for block: B:383:0x0835  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0171  */
    @Override // com.google.android.gms.internal.measurement.zzao
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.zzao i(java.lang.String r30, com.google.android.gms.internal.measurement.zzg r31, java.util.ArrayList r32) {
        /*
            Method dump skipped, instructions count: 2326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzae.i(java.lang.String, com.google.android.gms.internal.measurement.zzg, java.util.ArrayList):com.google.android.gms.internal.measurement.zzao");
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzad(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzak
    public final boolean j(String str) {
        return "length".equals(str) || this.f36757b.containsKey(str);
    }

    public final List k() {
        ArrayList arrayList = new ArrayList(n());
        for (int i2 = 0; i2 < n(); i2++) {
            arrayList.add(o(i2));
        }
        return arrayList;
    }

    public final Iterator m() {
        return this.f36756a.keySet().iterator();
    }

    public final int n() {
        TreeMap treeMap = this.f36756a;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    public final zzao o(int i2) {
        zzao zzaoVar;
        if (i2 < n()) {
            return (!q(i2) || (zzaoVar = (zzao) this.f36756a.get(Integer.valueOf(i2))) == null) ? zzao.o0 : zzaoVar;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    public final void p(int i2, zzao zzaoVar) {
        if (i2 > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException(e.r(new StringBuilder(String.valueOf(i2).length() + 21), i2, "Out of bounds index: "));
        }
        TreeMap treeMap = this.f36756a;
        if (zzaoVar == null) {
            treeMap.remove(Integer.valueOf(i2));
        } else {
            treeMap.put(Integer.valueOf(i2), zzaoVar);
        }
    }

    public final boolean q(int i2) {
        if (i2 >= 0) {
            TreeMap treeMap = this.f36756a;
            if (i2 <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(i2));
            }
        }
        throw new IndexOutOfBoundsException(e.r(new StringBuilder(String.valueOf(i2).length() + 21), i2, "Out of bounds index: "));
    }

    public final void r(int i2) {
        TreeMap treeMap = this.f36756a;
        int iIntValue = ((Integer) treeMap.lastKey()).intValue();
        if (i2 > iIntValue || i2 < 0) {
            return;
        }
        treeMap.remove(Integer.valueOf(i2));
        if (i2 == iIntValue) {
            int i3 = i2 - 1;
            Integer numValueOf = Integer.valueOf(i3);
            if (treeMap.containsKey(numValueOf) || i3 < 0) {
                return;
            }
            treeMap.put(numValueOf, zzao.o0);
            return;
        }
        while (true) {
            i2++;
            if (i2 > ((Integer) treeMap.lastKey()).intValue()) {
                return;
            }
            Integer numValueOf2 = Integer.valueOf(i2);
            zzao zzaoVar = (zzao) treeMap.get(numValueOf2);
            if (zzaoVar != null) {
                treeMap.put(Integer.valueOf(i2 - 1), zzaoVar);
                treeMap.remove(numValueOf2);
            }
        }
    }

    public final String s(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.f36756a.isEmpty()) {
            int i2 = 0;
            while (true) {
                str2 = str == null ? "" : str;
                if (i2 >= n()) {
                    break;
                }
                zzao zzaoVarO = o(i2);
                sb.append(str2);
                if (!(zzaoVarO instanceof zzat) && !(zzaoVarO instanceof zzam)) {
                    sb.append(zzaoVarO.zzc());
                }
                i2++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    public final String toString() {
        return s(",");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final String zzc() {
        return s(",");
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Double zzd() {
        TreeMap treeMap = this.f36756a;
        return treeMap.size() == 1 ? o(0).zzd() : treeMap.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Boolean zze() {
        return Boolean.TRUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzao
    public final Iterator zzf() {
        return new zzac(this, this.f36756a.keySet().iterator(), this.f36757b.keySet().iterator());
    }

    public zzae(List list) {
        this();
        if (list != null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                p(i2, (zzao) list.get(i2));
            }
        }
    }
}
