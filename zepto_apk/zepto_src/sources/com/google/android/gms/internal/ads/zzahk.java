package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzahk implements zzaeo {

    /* renamed from: b, reason: collision with root package name */
    public zzaer f23119b;

    /* renamed from: c, reason: collision with root package name */
    public int f23120c;

    /* renamed from: d, reason: collision with root package name */
    public int f23121d;

    /* renamed from: e, reason: collision with root package name */
    public int f23122e;

    /* renamed from: g, reason: collision with root package name */
    public zzaho f23124g;

    /* renamed from: h, reason: collision with root package name */
    public zzaef f23125h;

    /* renamed from: i, reason: collision with root package name */
    public zzafw f23126i;

    /* renamed from: j, reason: collision with root package name */
    public zzakp f23127j;

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23118a = new zzer(2);

    /* renamed from: f, reason: collision with root package name */
    public long f23123f = -1;

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        if (j2 == 0) {
            this.f23120c = 0;
            this.f23127j = null;
        } else if (this.f23120c == 5) {
            zzakp zzakpVar = this.f23127j;
            zzakpVar.getClass();
            zzakpVar.a(j2, j3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23119b = zzaerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) throws EOFException, InterruptedIOException {
        String strM;
        zzaef zzaefVar = (zzaef) zzaepVar;
        zzer zzerVar = this.f23118a;
        zzerVar.y(2);
        zzaefVar.t(zzerVar.f30144a, 0, 2, false);
        if (zzerVar.L() == 65496) {
            while (true) {
                zzerVar.y(2);
                zzaefVar.t(zzerVar.f30144a, 0, 2, false);
                int iL = zzerVar.L();
                this.f23121d = iL;
                if (iL == 65498) {
                    break;
                }
                zzerVar.y(2);
                zzaefVar.t(zzerVar.f30144a, 0, 2, false);
                int iL2 = zzerVar.L() - 2;
                if (iL2 < 0) {
                    break;
                }
                if (this.f23121d != 65505) {
                    ((zzaef) zzaepVar).f(iL2, false);
                } else {
                    zzerVar.y(iL2);
                    ((zzaef) zzaepVar).t(zzerVar.f30144a, 0, iL2, false);
                    if (Objects.equals(zzerVar.m(), "http://ns.adobe.com/xap/1.0/") && (strM = zzerVar.m()) != null) {
                        String[] strArr = zzahn.f23133a;
                        for (int i2 = 0; i2 < 4; i2++) {
                            if (strM.contains(String.valueOf(strArr[i2]).concat("=\"1\""))) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0193, code lost:
    
        r2 = -9223372036854775807L;
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0286  */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r32, com.google.android.gms.internal.ads.zzafo r33) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 738
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahk.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    public final void e() {
        zzaer zzaerVar = this.f23119b;
        zzaerVar.getClass();
        zzaerVar.h();
        this.f23119b.d(new zzafq(-9223372036854775807L, 0L));
        this.f23120c = 6;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }
}
