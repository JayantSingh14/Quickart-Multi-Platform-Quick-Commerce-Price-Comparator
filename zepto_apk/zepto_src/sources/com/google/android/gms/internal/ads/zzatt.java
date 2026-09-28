package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/* loaded from: classes4.dex */
public final /* synthetic */ class zzatt implements zzauk {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24351b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24352c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24353d;

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24354e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24355f;

    /* renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24356g;

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24357h;

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24358i;

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24359j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24360k;

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24361l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ zzatt f24362m;
    public static final /* synthetic */ zzatt n;
    public static final /* synthetic */ zzatt o;
    public static final /* synthetic */ zzatt p;
    public static final /* synthetic */ zzatt q;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f24363a;

    static {
        int i2 = (((((~358984857) & 11257432) | 369424399) + ((358984857 & 615188052) | 873771151)) - 1245366369) ^ (1985433483 % 395279207);
        int i3 = (((((~1402492972) & 1009329808) | 1643537068) + ((1402492972 & 503911450) | 580170602)) - (-2136216298)) ^ (1489001354 % 953691761);
        int i4 = (((((~1389079342) & 405954790) | 5768193) + ((1389079342 & 967468022) | 1640566552)) - 1618010502) ^ (1588695568 % 1155465115);
        int i5 = (((((~1666231349) & 289538432) | 621649449) + ((1666231349 & 406985104) | 264059443)) - 1093855303) ^ (1698487330 % 272312086);
        int i6 = (((((~1953161956) & 2021553924) | 1308628610) + ((1953161956 & 813590916) | 134225131)) - 2074905685) ^ (1172063133 % 990526343);
        int i7 = (((((~1889804310) & 69748745) | 707083896) + ((1889804310 & 604795185) | 951435262)) - 1284100923) ^ (1663080928 % 610506582);
        int i8 = (((((~279121308) & 136482862) | 293951273) + ((279121308 & 1302561302) | 1440046744)) - 1857458389) ^ (1404515797 % 695748720);
        int i9 = (((((~1460082195) & 849562858) | 543970048) + ((1460082195 & 381881578) | 1279262981)) - 1872584419) ^ (1122336503 % 861109485);
        int i10 = (((((~70788355) & 1377181904) | 713084892) + ((70788355 & 1410740224) | 99160279)) - 1955016785) ^ (1156541312 % 318561886);
        int i11 = (((((~12895151) & 1277237303) | 185162640) + ((12895151 & 1411547303) | 306429832)) - 1475739783) ^ (1498617647 % 669908538);
        int i12 = (((((~1566288819) & 1018167620) | 793479703) + ((1566288819 & 284165456) | 1648575546)) - (-1895196318)) ^ (846942590 % 524688209);
        int i13 = (((((~1540846267) & 571107379) | 1484708373) + ((1540846267 & 709108258) | 1568035525)) - (-834164565)) ^ (2037335344 % 1874960596);
        q = new zzatt((((((~1245644428) & 268473430) | 2019232319) + ((1245644428 & 2266696) | 1693582250)) - (-827594116)) ^ (1308581515 % 354367395));
        p = new zzatt((((((~464837581) & 1181588952) | 603091067) + ((464837581 & 1544523140) | 967967255)) - (-2124025763)) ^ (1295815494 % 753959819));
        o = new zzatt(i13);
        n = new zzatt(i4);
        f24362m = new zzatt(i5);
        f24361l = new zzatt(i6);
        f24360k = new zzatt(i3);
        f24359j = new zzatt(i7);
        f24358i = new zzatt(i8);
        f24357h = new zzatt(i9);
        f24356g = new zzatt(i2);
        f24355f = new zzatt(i10);
        f24354e = new zzatt(i11);
        f24353d = new zzatt(i12);
        f24352c = new zzatt(1);
        f24351b = new zzatt(0);
    }

    public /* synthetic */ zzatt(int i2) {
        this.f24363a = i2;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) throws zzauq {
        zzatc zzatcVar;
        zzaus zzausVarC;
        try {
            try {
                try {
                    try {
                        try {
                            switch (this.f24363a) {
                                case 0:
                                    return ((zzaun) obj).a();
                                case 1:
                                    try {
                                        zzauj zzaujVar = ((zzaun) obj).f24398b;
                                        long jM = zzaujVar.c().m();
                                        zzaus zzausVarC2 = zzaujVar.c();
                                        List listO = zzausVarC2.o();
                                        if (jM < 0) {
                                            jM += ((ArrayList) listO).size();
                                        }
                                        if (jM >= 0) {
                                            ArrayList arrayList = (ArrayList) listO;
                                            if (jM < arrayList.size()) {
                                                arrayList.remove((int) jM);
                                                zzaujVar.b(zzausVarC2);
                                                return Optional.empty();
                                            }
                                        }
                                        throw new zzauq();
                                    } catch (zzauq unused) {
                                        zzatcVar = zzatc.J;
                                        break;
                                    }
                                case 2:
                                    zzaun zzaunVar = (zzaun) obj;
                                    zzauj zzaujVar2 = zzaunVar.f24398b;
                                    zzaus zzausVarC3 = zzaujVar2.c();
                                    zzatw zzatwVarN = zzaujVar2.c().n();
                                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    zzausVarC3.k(byteArrayOutputStream);
                                    zzaunVar.f24398b.b(zzaus.d(zzatwVarN.d(zzatw.e(byteArrayOutputStream.toByteArray()))));
                                    return Optional.empty();
                                case 3:
                                    zzaun zzaunVar2 = (zzaun) obj;
                                    zzauj zzaujVar3 = zzaunVar2.f24398b;
                                    zzaus zzausVarC4 = zzaujVar3.c();
                                    zzatw zzatwVarN2 = zzaujVar3.c().n();
                                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                                    zzats.b(zzausVarC4.m(), new zzaur(byteArrayOutputStream2), false);
                                    zzaunVar2.f24398b.b(zzaus.d(zzatwVarN2.d(zzatw.e(byteArrayOutputStream2.toByteArray()))));
                                    return Optional.empty();
                                case 4:
                                    zzaun zzaunVar3 = (zzaun) obj;
                                    zzaub zzaubVar = zzaunVar3.f24400d;
                                    zzauj zzaujVar4 = zzaunVar3.f24398b;
                                    zzaujVar4.f24394a.set(zzaujVar4.a(-(zzaunVar3.f24399c.b().f24391b + zzaubVar.e())), zzaujVar4.c());
                                    return Optional.empty();
                                case 5:
                                    zzauj zzaujVar5 = ((zzaun) obj).f24398b;
                                    zzaujVar5.b(zzaus.b(zzaujVar5.c().m() << ((int) zzaujVar5.c().m())));
                                    return Optional.empty();
                                case 6:
                                    zzauj zzaujVar6 = ((zzaun) obj).f24398b;
                                    zzaujVar6.b(zzaus.b(zzaujVar6.c().m() >>> ((int) zzaujVar6.c().m())));
                                    return Optional.empty();
                                case 7:
                                    zzauj zzaujVar7 = ((zzaun) obj).f24398b;
                                    zzaujVar7.b(zzaus.c(zzaujVar7.c().q() - zzaujVar7.c().q()));
                                    return Optional.empty();
                                case 8:
                                    zzauj zzaujVar8 = ((zzaun) obj).f24398b;
                                    zzaujVar8.b(zzaus.b(zzaujVar8.c().m() - zzaujVar8.c().m()));
                                    return Optional.empty();
                                case 9:
                                    zzaun zzaunVar4 = (zzaun) obj;
                                    zzauj zzaujVar9 = zzaunVar4.f24398b;
                                    long jM2 = zzaujVar9.c().m();
                                    zzaus zzausVarC5 = zzaujVar9.c();
                                    zzauj zzaujVar10 = zzaunVar4.f24398b;
                                    zzaus zzausVarD = zzaujVar10.d(jM2);
                                    zzaujVar10.f24394a.set(zzaujVar10.a(jM2), zzausVarC5);
                                    zzaujVar10.b(zzausVarD);
                                    return Optional.empty();
                                case 10:
                                    zzaun zzaunVar5 = (zzaun) obj;
                                    zzauj zzaujVar11 = zzaunVar5.f24398b;
                                    long jM3 = zzaunVar5.f24399c.b().f24391b + zzaujVar11.c().m();
                                    zzaus zzausVarC6 = zzaujVar11.c();
                                    zzauj zzaujVar12 = zzaunVar5.f24398b;
                                    long j2 = -jM3;
                                    zzaus zzausVarD2 = zzaujVar12.d(j2);
                                    zzaujVar12.f24394a.set(zzaujVar12.a(j2), zzausVarC6);
                                    zzaujVar12.b(zzausVarD2);
                                    return Optional.empty();
                                case 11:
                                    zzaun zzaunVar6 = (zzaun) obj;
                                    zzaub zzaubVar2 = zzaunVar6.f24400d;
                                    zzauj zzaujVar13 = zzaunVar6.f24398b;
                                    long jE = zzaunVar6.f24399c.b().f24391b + zzaubVar2.e();
                                    zzaus zzausVarC7 = zzaujVar13.c();
                                    long j3 = -jE;
                                    zzaus zzausVarD3 = zzaujVar13.d(j3);
                                    zzaujVar13.f24394a.set(zzaujVar13.a(j3), zzausVarC7);
                                    zzaujVar13.b(zzausVarD3);
                                    return Optional.empty();
                                case 12:
                                    zzaun zzaunVar7 = (zzaun) obj;
                                    long jM4 = zzaunVar7.f24398b.c().m();
                                    try {
                                        zzauj zzaujVar14 = zzaunVar7.f24398b;
                                        if (jM4 == 0) {
                                            zzausVarC = zzaujVar14.c();
                                        } else {
                                            zzaujVar14.f24395b--;
                                            zzausVarC = (zzaus) zzaujVar14.f24394a.remove(zzaujVar14.a(jM4));
                                        }
                                        zzaujVar14.b(zzausVarC);
                                        return Optional.empty();
                                    } catch (zzauh unused2) {
                                        zzatcVar = zzatc.f24299h;
                                        break;
                                    }
                                case 13:
                                    zzaun zzaunVar8 = (zzaun) obj;
                                    try {
                                        zzauj zzaujVar15 = zzaunVar8.f24398b;
                                        long jM5 = zzaujVar15.c().m();
                                        long jM6 = zzaujVar15.c().m();
                                        zzaug zzaugVar = zzaunVar8.f24399c;
                                        zzaub zzaubVar3 = zzaunVar8.f24400d;
                                        zzaugVar.a(zzaubVar3.b(), jM6, zzaugVar.b().f24391b);
                                        zzaubVar3.a(jM5);
                                        return Optional.empty();
                                    } catch (zzatz | zzaua unused3) {
                                        zzatcVar = zzatc.s;
                                        break;
                                    } catch (zzaue unused4) {
                                        zzatcVar = zzatc.C;
                                        break;
                                    } catch (zzauf unused5) {
                                        zzatcVar = zzatc.x;
                                        break;
                                    }
                                case 14:
                                    zzaun zzaunVar9 = (zzaun) obj;
                                    try {
                                        zzaunVar9.f24398b.b(zzaus.g(zzaunVar9.f24398b.c().l()));
                                        return Optional.empty();
                                    } catch (zzaup unused6) {
                                        zzatcVar = zzatc.q;
                                        break;
                                    }
                                default:
                                    try {
                                        zzauj zzaujVar16 = ((zzaun) obj).f24398b;
                                        Iterator it = ((ArrayList) zzaujVar16.c().o()).iterator();
                                        while (it.hasNext()) {
                                            zzaujVar16.b((zzaus) it.next());
                                        }
                                        return Optional.empty();
                                    } catch (zzaui unused7) {
                                        zzatcVar = zzatc.f24293b;
                                        break;
                                    }
                            }
                        } catch (zzauh unused8) {
                            zzatcVar = zzatc.f24300i;
                        }
                    } catch (zzaui e2) {
                        e = e2;
                        throw new AssertionError(zzatu.a("CEiv6BFfPnitUE+D"), e);
                    }
                } catch (zzaty | zzaua | zzaup unused9) {
                    zzatcVar = zzatc.z;
                }
            } catch (zzauf | zzauh unused10) {
                zzatcVar = zzatc.y;
            }
        } catch (zzaup unused11) {
            zzatcVar = zzatc.f24303l;
        } catch (IOException e3) {
            e = e3;
            throw new AssertionError(zzatu.a("CEiv6BFfPnitUE+D"), e);
        }
        return Optional.of(zzatcVar);
    }
}
