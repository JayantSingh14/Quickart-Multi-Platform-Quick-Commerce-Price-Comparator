package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzaok {

    /* renamed from: a, reason: collision with root package name */
    public final zzaga f23895a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f23896b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f23897c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f23898d;

    /* renamed from: e, reason: collision with root package name */
    public int f23899e;

    /* renamed from: f, reason: collision with root package name */
    public int f23900f;

    /* renamed from: g, reason: collision with root package name */
    public long f23901g;

    /* renamed from: h, reason: collision with root package name */
    public long f23902h;

    public zzaok(zzaga zzagaVar) {
        this.f23895a = zzagaVar;
    }

    public final void a(byte[] bArr, int i2, int i3) {
        if (this.f23897c) {
            int i4 = this.f23900f;
            int i5 = (i2 + 1) - i4;
            if (i5 >= i3) {
                this.f23900f = (i3 - i2) + i4;
            } else {
                this.f23898d = ((bArr[i5] & 192) >> 6) == 0;
                this.f23897c = false;
            }
        }
    }

    public final void b(int i2, long j2, boolean z) {
        zzgqa.f(this.f23902h != -9223372036854775807L);
        if (this.f23899e == 182 && z && this.f23896b) {
            long j3 = j2 - this.f23901g;
            this.f23895a.e(this.f23902h, this.f23898d ? 1 : 0, (int) j3, i2, null);
        }
        if (this.f23899e != 179) {
            this.f23901g = j2;
        }
    }
}
