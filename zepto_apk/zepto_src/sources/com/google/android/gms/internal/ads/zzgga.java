package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes4.dex */
final class zzgga extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final Map f32520f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgba f32521g;

    public zzgga(zzavs zzavsVar, zzgev zzgevVar, zzgba zzgbaVar, Map map, zzgnc zzgncVar) {
        super("PL1+PnLeilPUwoW2fO9HYIrx4Gg09J/+FJQHQ2Jxmj5/l/Syl1OYiCh2G/imF0wq", "lSzEOSnnLGs69ZQnPGdq+hn/fw2CPePS7EJBVgPn7n4=", zzavsVar, zzgevVar, zzgncVar.a(122));
        this.f32520f = map;
        this.f32521g = zzgbaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        Long[] lArr = new Long[9];
        Arrays.fill((Object[]) lArr, (Object) (-1L));
        Map map = this.f32520f;
        Long l2 = (Long) map.get("tcq");
        if (l2 == null) {
            l2 = -1L;
        }
        lArr[0] = l2;
        Long l3 = (Long) map.get("tpq");
        if (l3 == null) {
            l3 = -1L;
        }
        lArr[1] = l3;
        Long l4 = (Long) map.get("tcv");
        if (l4 == null) {
            l4 = -1L;
        }
        lArr[2] = l4;
        Long l5 = (Long) map.get("tpv");
        if (l5 == null) {
            l5 = -1L;
        }
        lArr[3] = l5;
        Long l6 = (Long) map.get("tchv");
        if (l6 == null) {
            l6 = -1L;
        }
        lArr[4] = l6;
        Long l7 = (Long) map.get("tphv");
        if (l7 == null) {
            l7 = -1L;
        }
        lArr[5] = l7;
        Long l8 = (Long) map.get("tcc");
        if (l8 == null) {
            l8 = -1L;
        }
        lArr[6] = l8;
        Long l9 = (Long) map.get("tpc");
        if (l9 == null) {
            l9 = -1L;
        }
        lArr[7] = l9;
        Long l10 = (Long) map.get("tst");
        if (l10 == null) {
            l10 = -1L;
        }
        lArr[8] = l10;
        for (int i2 = 0; i2 < 9; i2++) {
            if (lArr[i2] == null) {
                lArr[i2] = -1L;
            }
        }
        Long[] lArr2 = (Long[]) method.invoke("", lArr, Integer.valueOf(this.f32521g.ordinal()));
        lArr2.getClass();
        synchronized (zzavsVar) {
            long jLongValue = lArr2[0].longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).q0(jLongValue);
            long jLongValue2 = lArr2[1].longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).F(jLongValue2);
            long jLongValue3 = lArr2[2].longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).U0(jLongValue3);
            long jLongValue4 = lArr2[3].longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).R0(jLongValue4);
            long jLongValue5 = lArr2[4].longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).l0(jLongValue5);
            long jLongValue6 = lArr2[5].longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).m0(jLongValue6);
            long jLongValue7 = lArr2[6].longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).S(jLongValue7);
            long jLongValue8 = lArr2[7].longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).T(jLongValue8);
        }
    }
}
