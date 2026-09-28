package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public final class zzahc implements zzaeo {

    /* renamed from: f, reason: collision with root package name */
    public zzaer f23088f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f23090h;

    /* renamed from: i, reason: collision with root package name */
    public long f23091i;

    /* renamed from: j, reason: collision with root package name */
    public int f23092j;

    /* renamed from: k, reason: collision with root package name */
    public int f23093k;

    /* renamed from: l, reason: collision with root package name */
    public int f23094l;

    /* renamed from: m, reason: collision with root package name */
    public long f23095m;
    public boolean n;
    public zzaha o;
    public zzahg p;

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23083a = new zzer(4);

    /* renamed from: b, reason: collision with root package name */
    public final zzer f23084b = new zzer(9);

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23085c = new zzer(11);

    /* renamed from: d, reason: collision with root package name */
    public final zzer f23086d = new zzer();

    /* renamed from: e, reason: collision with root package name */
    public final zzahd f23087e = new zzahd();

    /* renamed from: g, reason: collision with root package name */
    public int f23089g = 1;

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        if (j2 == 0) {
            this.f23089g = 1;
            this.f23090h = false;
        } else {
            this.f23089g = 3;
        }
        this.f23092j = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23088f = zzaerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) throws EOFException, InterruptedIOException {
        zzer zzerVar = this.f23083a;
        zzaef zzaefVar = (zzaef) zzaepVar;
        zzaefVar.t(zzerVar.f30144a, 0, 3, false);
        zzerVar.E(0);
        if (zzerVar.O() == 4607062) {
            zzaefVar.t(zzerVar.f30144a, 0, 2, false);
            zzerVar.E(0);
            if ((zzerVar.L() & Type.TSIG) == 0) {
                zzaefVar.t(zzerVar.f30144a, 0, 4, false);
                zzerVar.E(0);
                int iB = zzerVar.b();
                ((zzaef) zzaepVar).f22874f = 0;
                zzaefVar.f(iB, false);
                zzaefVar.t(zzerVar.f30144a, 0, 4, false);
                zzerVar.E(0);
                if (zzerVar.b() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x03a8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x03c1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0007 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r30, com.google.android.gms.internal.ads.zzafo r31) throws com.google.android.gms.internal.ads.zzat, java.io.EOFException, java.io.InterruptedIOException {
        /*
            Method dump skipped, instructions count: 1145
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahc.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    public final zzer e(zzaef zzaefVar) throws EOFException, InterruptedIOException {
        int i2 = this.f23094l;
        zzer zzerVar = this.f23086d;
        byte[] bArr = zzerVar.f30144a;
        if (i2 > bArr.length) {
            int length = bArr.length;
            zzerVar.z(0, new byte[Math.max(length + length, i2)]);
        } else {
            zzerVar.E(0);
        }
        zzerVar.C(this.f23094l);
        zzaefVar.v(zzerVar.f30144a, 0, this.f23094l, false);
        return zzerVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }
}
