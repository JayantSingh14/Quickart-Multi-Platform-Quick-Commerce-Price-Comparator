package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzakg {

    /* renamed from: a, reason: collision with root package name */
    public final zzaga f23346a;

    /* renamed from: d, reason: collision with root package name */
    public zzaky f23349d;

    /* renamed from: e, reason: collision with root package name */
    public zzakb f23350e;

    /* renamed from: f, reason: collision with root package name */
    public int f23351f;

    /* renamed from: g, reason: collision with root package name */
    public int f23352g;

    /* renamed from: h, reason: collision with root package name */
    public int f23353h;

    /* renamed from: i, reason: collision with root package name */
    public int f23354i;

    /* renamed from: j, reason: collision with root package name */
    public final zzv f23355j;

    /* renamed from: m, reason: collision with root package name */
    public boolean f23358m;

    /* renamed from: b, reason: collision with root package name */
    public final zzakx f23347b = new zzakx();

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23348c = new zzer();

    /* renamed from: k, reason: collision with root package name */
    public final zzer f23356k = new zzer(1);

    /* renamed from: l, reason: collision with root package name */
    public final zzer f23357l = new zzer();

    public zzakg(zzaga zzagaVar, zzaky zzakyVar, zzakb zzakbVar, zzv zzvVar) {
        this.f23346a = zzagaVar;
        this.f23349d = zzakyVar;
        this.f23350e = zzakbVar;
        this.f23355j = zzvVar;
        this.f23349d = zzakyVar;
        this.f23350e = zzakbVar;
        zzagaVar.c(zzvVar);
        a();
    }

    public final void a() {
        zzakx zzakxVar = this.f23347b;
        zzakxVar.f23429d = 0;
        zzakxVar.p = 0L;
        zzakxVar.q = false;
        zzakxVar.f23436k = false;
        zzakxVar.o = false;
        zzakxVar.f23438m = null;
        this.f23351f = 0;
        this.f23353h = 0;
        this.f23352g = 0;
        this.f23354i = 0;
        this.f23358m = false;
    }

    public final int b() {
        int i2 = !this.f23358m ? this.f23349d.f23445g[this.f23351f] : this.f23347b.f23435j[this.f23351f] ? 1 : 0;
        return e() != null ? i2 | 1073741824 : i2;
    }

    public final boolean c() {
        this.f23351f++;
        if (!this.f23358m) {
            return false;
        }
        int i2 = this.f23352g + 1;
        this.f23352g = i2;
        int[] iArr = this.f23347b.f23432g;
        int i3 = this.f23353h;
        if (i2 != iArr[i3]) {
            return true;
        }
        this.f23353h = i3 + 1;
        this.f23352g = 0;
        return false;
    }

    public final int d(int i2, int i3) {
        zzer zzerVar;
        zzakw zzakwVarE = e();
        if (zzakwVarE == null) {
            return 0;
        }
        zzakx zzakxVar = this.f23347b;
        int length = zzakwVarE.f23424d;
        if (length != 0) {
            zzerVar = zzakxVar.n;
        } else {
            String str = zzfj.f31254a;
            byte[] bArr = zzakwVarE.f23425e;
            length = bArr.length;
            zzer zzerVar2 = this.f23357l;
            zzerVar2.z(length, bArr);
            zzerVar = zzerVar2;
        }
        boolean z = zzakxVar.f23436k && zzakxVar.f23437l[this.f23351f];
        boolean z2 = z || i3 != 0;
        int i4 = true != z2 ? 0 : 128;
        zzer zzerVar3 = this.f23356k;
        zzerVar3.f30144a[0] = (byte) (i4 | length);
        zzerVar3.E(0);
        zzaga zzagaVar = this.f23346a;
        zzagaVar.d(zzerVar3, 1, 1);
        zzagaVar.d(zzerVar, length, 1);
        if (!z2) {
            return length + 1;
        }
        zzer zzerVar4 = this.f23348c;
        if (!z) {
            zzerVar4.y(8);
            byte[] bArr2 = zzerVar4.f30144a;
            bArr2[0] = 0;
            bArr2[1] = 1;
            bArr2[2] = 0;
            bArr2[3] = (byte) i3;
            bArr2[4] = (byte) ((i2 >> 24) & 255);
            bArr2[5] = (byte) ((i2 >> 16) & 255);
            bArr2[6] = (byte) ((i2 >> 8) & 255);
            bArr2[7] = (byte) (i2 & 255);
            zzagaVar.d(zzerVar4, 8, 1);
            return length + 9;
        }
        int i5 = length + 1;
        zzer zzerVar5 = zzakxVar.n;
        int iL = zzerVar5.L();
        zzerVar5.G(-2);
        int i6 = (iL * 6) + 2;
        if (i3 != 0) {
            zzerVar4.y(i6);
            byte[] bArr3 = zzerVar4.f30144a;
            zzerVar5.H(0, bArr3, i6);
            int i7 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i3;
            bArr3[2] = (byte) ((i7 >> 8) & 255);
            bArr3[3] = (byte) (i7 & 255);
        } else {
            zzerVar4 = zzerVar5;
        }
        zzagaVar.d(zzerVar4, i6, 1);
        return i5 + i6;
    }

    public final zzakw e() {
        if (!this.f23358m) {
            return null;
        }
        zzakx zzakxVar = this.f23347b;
        zzakb zzakbVar = zzakxVar.f23426a;
        String str = zzfj.f31254a;
        int i2 = zzakbVar.f23338a;
        zzakw zzakwVar = zzakxVar.f23438m;
        if (zzakwVar == null) {
            zzakwVar = this.f23349d.f23439a.f23420l[i2];
        }
        if (zzakwVar == null || !zzakwVar.f23421a) {
            return null;
        }
        return zzakwVar;
    }
}
