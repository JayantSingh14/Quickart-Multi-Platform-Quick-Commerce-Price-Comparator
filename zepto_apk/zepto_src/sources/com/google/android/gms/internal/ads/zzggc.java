package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.lang.reflect.Method;
import java.util.Map;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class zzggc extends zzgfz {

    /* renamed from: f, reason: collision with root package name */
    public final Map f32527f;

    /* renamed from: g, reason: collision with root package name */
    public final zzgev f32528g;

    /* renamed from: h, reason: collision with root package name */
    public final DisplayMetrics f32529h;

    public zzggc(zzavs zzavsVar, zzgev zzgevVar, Map map, DisplayMetrics displayMetrics, zzgnc zzgncVar) {
        super("TVhQaRYX1XJdJjovebNLV6RZa+CHXoXNSDwsvD2M+2M/jcZaYqephUke/9lWGtpK", "6PtDO9Iljdiz/XZTZ5iBSB6rGbi6sfeQlXfzSke6Ktw=", zzavsVar, zzgevVar, zzgncVar.a(WKSRecord.Service.NTP));
        this.f32528g = zzgevVar;
        this.f32527f = map;
        this.f32529h = displayMetrics;
    }

    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        Object[] objArr;
        Map map = this.f32527f;
        MotionEvent motionEvent = (MotionEvent) map.get("nv");
        DisplayMetrics displayMetrics = this.f32529h;
        Object[] objArr2 = (Object[]) method.invoke("", motionEvent, displayMetrics);
        objArr2.getClass();
        zzawl zzawlVarC = zzawm.C();
        Object obj = objArr2[0];
        boolean z = true;
        if (obj != null && objArr2[1] != null) {
            long jLongValue = ((Long) obj).longValue();
            zzawlVarC.j();
            ((zzawm) zzawlVarC.f34638b).D(jLongValue);
            long jLongValue2 = ((Long) objArr2[1]).longValue();
            zzawlVarC.j();
            ((zzawm) zzawlVarC.f34638b).E(jLongValue2);
        }
        Object obj2 = objArr2[2];
        if (obj2 != null) {
            long jLongValue3 = ((Long) obj2).longValue();
            zzawlVarC.j();
            ((zzawm) zzawlVarC.f34638b).K(jLongValue3);
        }
        Object obj3 = objArr2[3];
        if (obj3 != null) {
            long jLongValue4 = ((Long) obj3).longValue();
            zzawlVarC.j();
            ((zzawm) zzawlVarC.f34638b).I(jLongValue4);
        }
        Object obj4 = objArr2[4];
        if (obj4 != null) {
            long jLongValue5 = ((Long) obj4).longValue();
            zzawlVarC.j();
            ((zzawm) zzawlVarC.f34638b).F(jLongValue5);
        }
        Object obj5 = objArr2[5];
        if (obj5 != null) {
            int i2 = ((Long) obj5).longValue() != 0 ? 2 : 1;
            zzawlVarC.j();
            ((zzawm) zzawlVarC.f34638b).V(i2);
        }
        Object obj6 = objArr2[6];
        if (obj6 != null) {
            long jLongValue6 = ((Long) obj6).longValue();
            zzawlVarC.j();
            ((zzawm) zzawlVarC.f34638b).M(jLongValue6);
        }
        Object obj7 = objArr2[7];
        if (obj7 != null) {
            long jLongValue7 = ((Long) obj7).longValue();
            zzawlVarC.j();
            ((zzawm) zzawlVarC.f34638b).L(jLongValue7);
        }
        Object obj8 = objArr2[8];
        if (obj8 != null) {
            int i3 = ((Long) obj8).longValue() != 0 ? 2 : 1;
            zzawlVarC.j();
            ((zzawm) zzawlVarC.f34638b).W(i3);
        }
        synchronized (zzavsVar) {
            try {
                Method methodC = this.f32528g.c("o3UXVie8/suJOQmyOLMVpxbmPmxGzwCoQMAjB1gTC92yDn7FjyneAFFenBlXs1/s", "Pvu/YKY6AN7DXo4Zzc6oTKshDXcTgIHi2A4rOK2JeRs=");
                if (methodC == null || (objArr = (Object[]) methodC.invoke("", (MotionEvent) map.get("nv"), displayMetrics)) == null) {
                    throw null;
                }
                Object obj9 = objArr[0];
                if (obj9 != null) {
                    long jLongValue8 = ((Long) obj9).longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).O0(jLongValue8);
                }
                Object obj10 = objArr[1];
                if (obj10 != null) {
                    long jLongValue9 = ((Long) obj10).longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).P0(jLongValue9);
                }
                Object obj11 = objArr[2];
                if (obj11 != null) {
                    long jLongValue10 = ((Long) obj11).longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).Q0(jLongValue10);
                }
                Object obj12 = objArr[3];
                if (obj12 != null) {
                    long jLongValue11 = ((Long) obj12).longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).I(jLongValue11);
                }
                Object obj13 = objArr[4];
                if (obj13 != null) {
                    long jLongValue12 = ((Long) obj13).longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).J(jLongValue12);
                }
                zzgdp zzgdpVar = (zzgdp) map.get("oe");
                if (zzgdpVar != null) {
                    long j2 = zzgdpVar.f32330a;
                    if (j2 > 0) {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).M(j2);
                    }
                    long j3 = zzgdpVar.f32331b;
                    if (j3 > 0) {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).L(j3);
                    }
                    long j4 = zzgdpVar.f32332c;
                    if (j4 > 0) {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).K(j4);
                    }
                    long j5 = zzgdpVar.f32333d;
                    if (j5 > 0) {
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).N(j5);
                    }
                }
                zzgdp zzgdpVar2 = (zzgdp) map.get("oe");
                if (zzgdpVar2 != null && zzgdpVar2.f32330a != 0) {
                    if ((displayMetrics == null || displayMetrics.density == 0.0f) ? false : true) {
                        double d2 = zzgdpVar2.f32336g;
                        if (displayMetrics == null) {
                            throw null;
                        }
                        long jRound = Math.round(d2 / displayMetrics.density);
                        zzawlVarC.j();
                        ((zzawm) zzawlVarC.f34638b).O(jRound);
                        long jRound2 = Math.round((zzgdpVar2.f32339j - zzgdpVar2.f32337h) / displayMetrics.density);
                        zzawlVarC.j();
                        ((zzawm) zzawlVarC.f34638b).P(jRound2);
                        long jRound3 = Math.round((zzgdpVar2.f32340k - zzgdpVar2.f32338i) / displayMetrics.density);
                        zzawlVarC.j();
                        ((zzawm) zzawlVarC.f34638b).Q(jRound3);
                        long jRound4 = Math.round(zzgdpVar2.f32337h / displayMetrics.density);
                        zzawlVarC.j();
                        ((zzawm) zzawlVarC.f34638b).T(jRound4);
                        long jRound5 = Math.round(zzgdpVar2.f32338i / displayMetrics.density);
                        zzawlVarC.j();
                        ((zzawm) zzawlVarC.f34638b).U(jRound5);
                        if (((MotionEvent) map.get("nv")) != null) {
                            long jRound6 = Math.round((((zzgdpVar2.f32337h - zzgdpVar2.f32339j) + r7.getRawX()) - r7.getX()) / displayMetrics.density);
                            if (jRound6 != 0) {
                                zzawlVarC.j();
                                ((zzawm) zzawlVarC.f34638b).R(jRound6);
                            }
                            long jRound7 = Math.round((((zzgdpVar2.f32338i - zzgdpVar2.f32340k) + r7.getRawY()) - r7.getY()) / displayMetrics.density);
                            if (jRound7 != 0) {
                                zzawlVarC.j();
                                ((zzawm) zzawlVarC.f34638b).S(jRound7);
                            }
                        }
                    }
                }
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).V((zzawm) zzawlVarC.l());
                zzgdq[] zzgdqVarArr = (zzgdq[]) map.get("ro");
                if (zzgdqVarArr != null) {
                    if (displayMetrics == null || displayMetrics.density == 0.0f) {
                        z = false;
                    }
                    if (z) {
                        for (int i4 = 0; i4 <= zzgdqVarArr.length - 2; i4++) {
                            zzgdq zzgdqVar = zzgdqVarArr[i4];
                            zzawl zzawlVarC2 = zzawm.C();
                            double d3 = zzgdqVar.f32341a;
                            if (displayMetrics == null) {
                                throw null;
                            }
                            long jRound8 = Math.round(d3 / displayMetrics.density);
                            zzawlVarC2.j();
                            ((zzawm) zzawlVarC2.f34638b).D(jRound8);
                            long jRound9 = Math.round(zzgdqVar.f32342b / displayMetrics.density);
                            zzawlVarC2.j();
                            ((zzawm) zzawlVarC2.f34638b).E(jRound9);
                            zzawm zzawmVar = (zzawm) zzawlVarC2.l();
                            zzavsVar.j();
                            ((zzawp) zzavsVar.f34638b).W(zzawmVar);
                        }
                    }
                }
            } finally {
            }
        }
    }
}
