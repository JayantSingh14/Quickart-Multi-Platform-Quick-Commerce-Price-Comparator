package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzagb {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22981a = new byte[10];

    /* renamed from: b, reason: collision with root package name */
    public boolean f22982b;

    /* renamed from: c, reason: collision with root package name */
    public int f22983c;

    /* renamed from: d, reason: collision with root package name */
    public long f22984d;

    /* renamed from: e, reason: collision with root package name */
    public int f22985e;

    /* renamed from: f, reason: collision with root package name */
    public int f22986f;

    /* renamed from: g, reason: collision with root package name */
    public int f22987g;

    public final void a(zzaep zzaepVar) {
        if (this.f22982b) {
            return;
        }
        byte[] bArr = this.f22981a;
        zzaepVar.s(0, bArr, 10);
        zzaepVar.zzl();
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            this.f22982b = true;
        }
    }

    public final void b(zzaga zzagaVar, long j2, int i2, int i3, int i4, zzafz zzafzVar) {
        zzgqa.g("TrueHD chunk samples must be contiguous in the sample queue.", this.f22987g <= i3 + i4);
        if (this.f22982b) {
            int i5 = this.f22983c;
            int i6 = i5 + 1;
            this.f22983c = i6;
            if (i5 == 0) {
                this.f22984d = j2;
                this.f22985e = i2;
                this.f22986f = 0;
            }
            this.f22986f += i3;
            this.f22987g = i4;
            if (i6 >= 16) {
                c(zzagaVar, zzafzVar);
            }
        }
    }

    public final void c(zzaga zzagaVar, zzafz zzafzVar) {
        if (this.f22983c > 0) {
            zzagaVar.e(this.f22984d, this.f22985e, this.f22986f, this.f22987g, zzafzVar);
            this.f22983c = 0;
        }
    }
}
