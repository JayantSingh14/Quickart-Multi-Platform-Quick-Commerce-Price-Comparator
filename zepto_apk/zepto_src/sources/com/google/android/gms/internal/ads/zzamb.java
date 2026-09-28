package com.google.android.gms.internal.ads;

import java.io.EOFException;

/* loaded from: classes4.dex */
final class zzamb implements zzaga {

    /* renamed from: a, reason: collision with root package name */
    public final zzaga f23531a;

    /* renamed from: b, reason: collision with root package name */
    public final zzalw f23532b;

    /* renamed from: g, reason: collision with root package name */
    public zzaly f23537g;

    /* renamed from: h, reason: collision with root package name */
    public zzv f23538h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f23539i;

    /* renamed from: d, reason: collision with root package name */
    public int f23534d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f23535e = 0;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f23536f = zzfj.f31255b;

    /* renamed from: c, reason: collision with root package name */
    public final zzer f23533c = new zzer();

    public zzamb(zzaga zzagaVar, zzalw zzalwVar) {
        this.f23531a = zzagaVar;
        this.f23532b = zzalwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final int a(zzj zzjVar, int i2, boolean z) throws EOFException {
        if (this.f23537g == null) {
            return this.f23531a.a(zzjVar, i2, z);
        }
        g(i2);
        int iB = zzjVar.b(this.f23535e, this.f23536f, i2);
        if (iB != -1) {
            this.f23535e += iB;
            return iB;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final void c(zzv zzvVar) {
        String str = zzvVar.f35691m;
        str.getClass();
        zzgqa.a(zzas.f(str) == 3);
        boolean zEquals = zzvVar.equals(this.f23538h);
        zzalw zzalwVar = this.f23532b;
        if (!zEquals) {
            this.f23538h = zzvVar;
            this.f23537g = zzalwVar.a(zzvVar) ? zzalwVar.c(zzvVar) : null;
        }
        zzaly zzalyVar = this.f23537g;
        zzaga zzagaVar = this.f23531a;
        if (zzalyVar == null) {
            zzagaVar.c(zzvVar);
            return;
        }
        zzt zztVar = new zzt(zzvVar);
        zztVar.e("application/x-media3-cues");
        zztVar.f35572i = str;
        zztVar.q = Long.MAX_VALUE;
        zztVar.J = zzalwVar.b(zzvVar);
        zzagaVar.c(new zzv(zztVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final void d(zzer zzerVar, int i2, int i3) {
        if (this.f23537g == null) {
            this.f23531a.d(zzerVar, i2, i3);
            return;
        }
        g(i2);
        zzerVar.H(this.f23535e, this.f23536f, i2);
        this.f23535e += i2;
    }

    @Override // com.google.android.gms.internal.ads.zzaga
    public final void e(long j2, int i2, int i3, int i4, zzafz zzafzVar) {
        if (this.f23537g == null) {
            this.f23531a.e(j2, i2, i3, i4, zzafzVar);
            return;
        }
        zzgqa.b("DRM on subtitles is not supported", zzafzVar == null);
        int i5 = (this.f23535e - i4) - i3;
        try {
            this.f23537g.a(this.f23536f, i5, i3, new zzama(this, j2, i2));
        } catch (RuntimeException e2) {
            if (!this.f23539i) {
                throw e2;
            }
            zzee.d("SubtitleTranscodingTO", "Parsing subtitles failed, ignoring sample.", e2);
        }
        int i6 = i5 + i3;
        this.f23534d = i6;
        if (i6 == this.f23535e) {
            this.f23534d = 0;
            this.f23535e = 0;
        }
    }

    public final void g(int i2) {
        int length = this.f23536f.length;
        int i3 = this.f23535e;
        if (length - i3 >= i2) {
            return;
        }
        int i4 = i3 - this.f23534d;
        int iMax = Math.max(i4 + i4, i2 + i4);
        byte[] bArr = this.f23536f;
        byte[] bArr2 = iMax <= bArr.length ? bArr : new byte[iMax];
        System.arraycopy(bArr, this.f23534d, bArr2, 0, i4);
        this.f23534d = 0;
        this.f23535e = i4;
        this.f23536f = bArr2;
    }
}
