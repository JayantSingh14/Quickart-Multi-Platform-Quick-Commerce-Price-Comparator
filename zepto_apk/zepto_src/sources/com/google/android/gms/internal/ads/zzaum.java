package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes4.dex */
public final class zzaum {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap f24396a;

    static {
        zzgtq zzgtqVar;
        zzgto zzgtoVar = new zzgto();
        zzgtoVar.a(new Long[]{-42L, -64L}, zzatx.f24368a);
        zzgtoVar.a(new Long[]{-6L, -53L}, zzatx.f24369b);
        zzgtoVar.a(new Long[]{-41L, -31L}, zzatx.f24370c);
        zzgtoVar.a(new Long[]{-40L, -28L}, zzatx.f24371d);
        zzgtoVar.a(new Long[]{-29L, -37L}, zzatx.f24372e);
        zzgtoVar.a(new Long[]{-80L, -32L}, zzatx.f24373f);
        zzgtoVar.a(new Long[]{-17L, -36L}, zzatx.f24374g);
        zzgtoVar.a(new Long[]{-82L, -35L}, zzatx.f24375h);
        zzgtoVar.a(new Long[]{-63L, -52L}, zzatx.f24376i);
        zzgtoVar.a(new Long[]{-23L, -11L}, zzatx.f24377j);
        zzgtoVar.a(new Long[]{-69L, -68L}, zzatx.f24378k);
        zzgtoVar.a(new Long[]{-62L, -55L}, zzatx.f24379l);
        zzgtoVar.a(new Long[]{-78L, -25L}, zzatx.f24380m);
        zzgtoVar.a(new Long[]{-71L, -3L}, zzatx.n);
        zzgtoVar.a(new Long[]{-18L, -4L}, zzatx.o);
        zzgtoVar.a(new Long[]{-67L, -19L}, zzatx.p);
        zzgtoVar.a(new Long[]{-58L}, zzatx.q);
        zzgtoVar.a(new Long[]{-2L}, zzatx.r);
        zzgtoVar.a(new Long[]{-34L}, zzatx.s);
        zzgtoVar.a(new Long[]{-30L}, zzatx.t);
        zzgtoVar.a(new Long[]{-56L}, zzatx.u);
        zzgtoVar.a(new Long[]{-57L}, zzatx.w);
        zzgtoVar.a(new Long[]{-66L}, zzatx.x);
        zzgtoVar.a(new Long[]{-60L}, zzatx.y);
        zzgtoVar.a(new Long[]{-27L}, zzatx.z);
        zzgtoVar.a(new Long[]{-26L}, zzatx.A);
        zzgtoVar.a(new Long[]{-74L}, zzatx.B);
        zzgtoVar.a(new Long[]{-77L}, zzatx.C);
        zzgtoVar.a(new Long[]{-38L}, zzatx.E);
        zzgtoVar.a(new Long[]{-79L}, zzatx.G);
        zzgtoVar.a(new Long[]{-7L}, zzatx.H);
        zzgtoVar.a(new Long[]{-51L}, zzatx.I);
        zzgtoVar.a(new Long[]{-9L}, zzatx.J);
        zzgtoVar.a(new Long[]{-47L}, zzatx.K);
        zzgtoVar.a(new Long[]{-70L}, zzatx.L);
        zzgtoVar.a(new Long[]{-14L}, zzatx.M);
        zzgtoVar.a(new Long[]{-5L}, zzatx.Q);
        zzgtoVar.a(new Long[]{-39L}, zzatx.X);
        zzgtoVar.a(new Long[]{-8L}, zzatx.Y);
        zzgtoVar.a(new Long[]{-54L}, zzatx.Z);
        zzgtoVar.a(new Long[]{-15L}, zzatx.A0);
        zzgtoVar.a(new Long[]{-12L}, zzatx.B0);
        zzgtoVar.a(new Long[]{-21L}, zzatx.C0);
        zzgtoVar.a(new Long[]{-43L}, zzatx.D0);
        zzgtoVar.a(new Long[]{-20L}, zzatx.F);
        zzgtoVar.a(new Long[]{-81L}, zzatx.D);
        zzgtoVar.a(new Long[]{-46L}, zzatx.E0);
        zzgtoVar.a(new Long[]{-61L}, zzatx.F0);
        zzgtoVar.a(new Long[]{-44L}, zzatx.G0);
        zzgtoVar.a(new Long[]{-59L}, zzatx.v);
        zzgtoVar.a(new Long[]{-49L}, zzatx.H0);
        zzgtoVar.a(new Long[]{-75L}, zzatx.I0);
        zzgtoVar.a(new Long[]{-24L}, zzatx.J0);
        zzgtoVar.a(new Long[]{-13L}, zzatx.O0);
        zzgtoVar.a(new Long[]{-1L}, zzatx.P0);
        zzgtoVar.a(new Long[]{-33L}, zzatx.K0);
        zzgtoVar.a(new Long[]{-45L}, zzatx.L0);
        zzgtoVar.a(new Long[]{-50L}, zzatx.M0);
        zzgtoVar.a(new Long[]{-65L}, zzatx.N0);
        zzgtoVar.a(new Long[]{-16L}, zzatx.Q0);
        zzgtoVar.a(new Long[]{-73L}, zzatx.R0);
        zzgtoVar.a(new Long[]{-10L}, zzatx.S0);
        zzgtoVar.a(new Long[]{-48L}, zzatx.T0);
        zzgtoVar.a(new Long[]{-22L}, zzatx.U0);
        zzgtoVar.a(new Long[]{-76L}, zzatx.V0);
        zzgtoVar.a(new Long[]{-72L}, zzatx.W0);
        Map map = zzgtoVar.f33198a;
        if (map == null) {
            zzgtqVar = zzgsr.f33170g;
        } else {
            Collection collectionEntrySet = ((zzgsk) map).entrySet();
            if (((AbstractCollection) collectionEntrySet).isEmpty()) {
                zzgtqVar = zzgsr.f33170g;
            } else {
                zzgsf zzgsfVar = (zzgsf) collectionEntrySet;
                zzgtf zzgtfVar = new zzgtf(zzgsfVar.f33145a.size());
                Iterator it = zzgsfVar.iterator();
                int size = 0;
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Object key = entry.getKey();
                    zzgtn zzgtnVarP = zzgtn.p(((zzgtm) entry.getValue()).h());
                    if (!zzgtnVarP.isEmpty()) {
                        zzgtfVar.a(key, zzgtnVarP);
                        size += zzgtnVarP.size();
                    }
                }
                zzgtqVar = new zzgtq(zzgtfVar.d(true), size);
            }
        }
        zzgtn zzgtpVar = zzgtqVar.f33206f;
        if (zzgtpVar == null) {
            zzgtpVar = new zzgtp(zzgtqVar);
            zzgtqVar.f33206f = zzgtpVar;
        }
        zzgvr it2 = zzgtpVar.iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            if (((Long) entry2.getValue()).longValue() > -1 || ((Long) entry2.getValue()).longValue() < -82) {
                throw new zzaul(zzatu.a("DkWkogARIjm8VAqEzyEdNWdUqAjIW8EtmA==").concat(String.valueOf(entry2.getValue())));
            }
        }
        HashMap map2 = new HashMap();
        zzgtn zzgtpVar2 = zzgtqVar.f33206f;
        if (zzgtpVar2 == null) {
            zzgtpVar2 = new zzgtp(zzgtqVar);
            zzgtqVar.f33206f = zzgtpVar2;
        }
        zzgvr it3 = zzgtpVar2.iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            zzatx zzatxVar = (zzatx) entry3.getKey();
            Long l2 = (Long) entry3.getValue();
            long jLongValue = l2.longValue();
            if (map2.containsKey(l2)) {
                String strValueOf = String.valueOf(map2.get(l2));
                String strValueOf2 = String.valueOf(zzatxVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + String.valueOf(jLongValue).length() + 27 + 5 + strValueOf2.length());
                sb.append(zzatu.a("H16u7wATM3S4Tl6egTYIeX5f+xfdXtsmmA=="));
                sb.append(jLongValue);
                sb.append(zzatu.a("cQk="));
                sb.append(strValueOf);
                sb.append(zzatu.a("a0ivq0U="));
                sb.append(strValueOf2);
                throw new zzaul(sb.toString());
            }
            map2.put(l2, zzatxVar);
        }
        f24396a = map2;
    }
}
