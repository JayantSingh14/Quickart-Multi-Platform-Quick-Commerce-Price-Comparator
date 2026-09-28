package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzpq;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzy {

    /* renamed from: a, reason: collision with root package name */
    public final String f39666a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f39667b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.internal.measurement.zzii f39668c;

    /* renamed from: d, reason: collision with root package name */
    public final BitSet f39669d;

    /* renamed from: e, reason: collision with root package name */
    public final BitSet f39670e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayMap f39671f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayMap f39672g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ zzad f39673h;

    public /* synthetic */ zzy(zzad zzadVar, String str, com.google.android.gms.internal.measurement.zzii zziiVar, BitSet bitSet, BitSet bitSet2, ArrayMap arrayMap, ArrayMap arrayMap2) {
        Objects.requireNonNull(zzadVar);
        this.f39673h = zzadVar;
        this.f39666a = str;
        this.f39669d = bitSet;
        this.f39670e = bitSet2;
        this.f39671f = arrayMap;
        this.f39672g = new ArrayMap();
        for (Integer num : arrayMap2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) arrayMap2.get(num));
            this.f39672g.put(num, arrayList);
        }
        this.f39667b = false;
        this.f39668c = zziiVar;
    }

    public final void a(zzab zzabVar) {
        int iA = zzabVar.a();
        if (zzabVar.f38662c != null) {
            this.f39670e.set(iA, true);
        }
        Boolean bool = zzabVar.f38663d;
        if (bool != null) {
            this.f39669d.set(iA, bool.booleanValue());
        }
        if (zzabVar.f38664e != null) {
            Integer numValueOf = Integer.valueOf(iA);
            ArrayMap arrayMap = this.f39671f;
            Long l2 = (Long) arrayMap.get(numValueOf);
            long jLongValue = zzabVar.f38664e.longValue() / 1000;
            if (l2 == null || jLongValue > l2.longValue()) {
                arrayMap.put(numValueOf, Long.valueOf(jLongValue));
            }
        }
        if (zzabVar.f38665f != null) {
            ArrayMap arrayMap2 = this.f39672g;
            Integer numValueOf2 = Integer.valueOf(iA);
            List arrayList = (List) arrayMap2.get(numValueOf2);
            if (arrayList == null) {
                arrayList = new ArrayList();
                arrayMap2.put(numValueOf2, arrayList);
            }
            if (zzabVar.b()) {
                arrayList.clear();
            }
            zzpq.a();
            zzib zzibVar = this.f39673h.f39180a;
            zzal zzalVar = zzibVar.f39087d;
            zzfw zzfwVar = zzfx.F0;
            String str = this.f39666a;
            if (zzalVar.q(str, zzfwVar) && zzabVar.c()) {
                arrayList.clear();
            }
            zzpq.a();
            if (!zzibVar.f39087d.q(str, zzfwVar)) {
                arrayList.add(Long.valueOf(zzabVar.f38665f.longValue() / 1000));
                return;
            }
            Long lValueOf = Long.valueOf(zzabVar.f38665f.longValue() / 1000);
            if (arrayList.contains(lValueOf)) {
                return;
            }
            arrayList.add(lValueOf);
        }
    }

    public final com.google.android.gms.internal.measurement.zzhg b(int i2) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.zzhf zzhfVarZ = com.google.android.gms.internal.measurement.zzhg.z();
        zzhfVarZ.i();
        ((com.google.android.gms.internal.measurement.zzhg) zzhfVarZ.f37107b).A(i2);
        zzhfVarZ.i();
        ((com.google.android.gms.internal.measurement.zzhg) zzhfVarZ.f37107b).D(this.f39667b);
        com.google.android.gms.internal.measurement.zzii zziiVar = this.f39668c;
        if (zziiVar != null) {
            zzhfVarZ.i();
            ((com.google.android.gms.internal.measurement.zzhg) zzhfVarZ.f37107b).C(zziiVar);
        }
        com.google.android.gms.internal.measurement.zzih zzihVarA = com.google.android.gms.internal.measurement.zzii.A();
        zzihVarA.q(zzpj.J(this.f39669d));
        zzihVarA.o(zzpj.J(this.f39670e));
        ArrayMap arrayMap = this.f39671f;
        if (arrayMap == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(arrayMap.f1605c);
            for (Integer num : arrayMap.keySet()) {
                int iIntValue = num.intValue();
                Long l2 = (Long) arrayMap.get(num);
                if (l2 != null) {
                    com.google.android.gms.internal.measurement.zzhp zzhpVarW = com.google.android.gms.internal.measurement.zzhq.w();
                    zzhpVarW.i();
                    ((com.google.android.gms.internal.measurement.zzhq) zzhpVarW.f37107b).x(iIntValue);
                    long jLongValue = l2.longValue();
                    zzhpVarW.i();
                    ((com.google.android.gms.internal.measurement.zzhq) zzhpVarW.f37107b).y(jLongValue);
                    arrayList2.add((com.google.android.gms.internal.measurement.zzhq) zzhpVarW.l());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zzihVarA.u(arrayList);
        }
        ArrayMap arrayMap2 = this.f39672g;
        if (arrayMap2 == null) {
            list = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList(arrayMap2.f1605c);
            for (Integer num2 : arrayMap2.keySet()) {
                com.google.android.gms.internal.measurement.zzij zzijVarX = com.google.android.gms.internal.measurement.zzik.x();
                int iIntValue2 = num2.intValue();
                zzijVarX.i();
                ((com.google.android.gms.internal.measurement.zzik) zzijVarX.f37107b).y(iIntValue2);
                List list2 = (List) arrayMap2.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzijVarX.i();
                    ((com.google.android.gms.internal.measurement.zzik) zzijVarX.f37107b).z(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzik) zzijVarX.l());
            }
            list = arrayList3;
        }
        zzihVarA.w(list);
        zzhfVarZ.i();
        ((com.google.android.gms.internal.measurement.zzhg) zzhfVarZ.f37107b).B((com.google.android.gms.internal.measurement.zzii) zzihVarA.l());
        return (com.google.android.gms.internal.measurement.zzhg) zzhfVarZ.l();
    }

    public final /* synthetic */ BitSet c() {
        return this.f39669d;
    }

    public /* synthetic */ zzy(zzad zzadVar, String str) {
        Objects.requireNonNull(zzadVar);
        this.f39673h = zzadVar;
        this.f39666a = str;
        this.f39667b = true;
        this.f39669d = new BitSet();
        this.f39670e = new BitSet();
        this.f39671f = new ArrayMap();
        this.f39672g = new ArrayMap();
    }
}
