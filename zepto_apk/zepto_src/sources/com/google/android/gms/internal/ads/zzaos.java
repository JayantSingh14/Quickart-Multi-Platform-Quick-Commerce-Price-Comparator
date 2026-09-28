package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzaos implements zzaog {

    /* renamed from: a, reason: collision with root package name */
    public final zzer f23984a;

    /* renamed from: b, reason: collision with root package name */
    public final zzafk f23985b;

    /* renamed from: c, reason: collision with root package name */
    public final String f23986c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23987d;

    /* renamed from: e, reason: collision with root package name */
    public final String f23988e;

    /* renamed from: f, reason: collision with root package name */
    public zzaga f23989f;

    /* renamed from: g, reason: collision with root package name */
    public String f23990g;

    /* renamed from: h, reason: collision with root package name */
    public int f23991h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f23992i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f23993j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f23994k;

    /* renamed from: l, reason: collision with root package name */
    public long f23995l;

    /* renamed from: m, reason: collision with root package name */
    public int f23996m;
    public long n;

    public zzaos(String str, int i2, String str2) {
        zzer zzerVar = new zzer(4);
        this.f23984a = zzerVar;
        zzerVar.f30144a[0] = -1;
        this.f23985b = new zzafk();
        this.n = -9223372036854775807L;
        this.f23986c = str;
        this.f23987d = i2;
        this.f23988e = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void b(int i2, long j2) {
        this.n = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void c(boolean z) {
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void d(zzer zzerVar) {
        this.f23989f.getClass();
        while (zzerVar.B() > 0) {
            int i2 = this.f23991h;
            zzer zzerVar2 = this.f23984a;
            if (i2 == 0) {
                byte[] bArr = zzerVar.f30144a;
                int i3 = zzerVar.f30145b;
                int i4 = zzerVar.f30146c;
                while (true) {
                    if (i3 >= i4) {
                        zzerVar.E(i4);
                        break;
                    }
                    int i5 = i3 + 1;
                    byte b2 = bArr[i3];
                    boolean z = (b2 & 255) == 255;
                    boolean z2 = this.f23994k && (b2 & 224) == 224;
                    this.f23994k = z;
                    if (z2) {
                        zzerVar.E(i5);
                        this.f23994k = false;
                        zzerVar2.f30144a[1] = bArr[i3];
                        this.f23992i = 2;
                        this.f23991h = 1;
                        break;
                    }
                    i3 = i5;
                }
            } else if (i2 != 1) {
                int iMin = Math.min(zzerVar.B(), this.f23996m - this.f23992i);
                this.f23989f.b(iMin, zzerVar);
                int i6 = this.f23992i + iMin;
                this.f23992i = i6;
                if (i6 >= this.f23996m) {
                    zzgqa.f(this.n != -9223372036854775807L);
                    this.f23989f.e(this.n, 1, this.f23996m, 0, null);
                    this.n += this.f23995l;
                    this.f23992i = 0;
                    this.f23991h = 0;
                }
            } else {
                int iMin2 = Math.min(zzerVar.B(), 4 - this.f23992i);
                zzerVar.H(this.f23992i, zzerVar2.f30144a, iMin2);
                int i7 = this.f23992i + iMin2;
                this.f23992i = i7;
                if (i7 >= 4) {
                    zzerVar2.E(0);
                    int iB = zzerVar2.b();
                    zzafk zzafkVar = this.f23985b;
                    if (zzafkVar.a(iB)) {
                        this.f23996m = zzafkVar.f22942c;
                        if (!this.f23993j) {
                            this.f23995l = (zzafkVar.f22946g * 1000000) / zzafkVar.f22943d;
                            zzt zztVar = new zzt();
                            zztVar.f35564a = this.f23990g;
                            zztVar.d(this.f23988e);
                            zztVar.e(zzafkVar.f22941b);
                            zztVar.f35576m = 4096;
                            zztVar.D = zzafkVar.f22944e;
                            zztVar.E = zzafkVar.f22943d;
                            zztVar.f35567d = this.f23986c;
                            zztVar.f35569f = this.f23987d;
                            this.f23989f.c(new zzv(zztVar));
                            this.f23993j = true;
                        }
                        zzerVar2.E(0);
                        this.f23989f.b(4, zzerVar2);
                        this.f23991h = 2;
                    } else {
                        this.f23992i = 0;
                        this.f23991h = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void e(zzaer zzaerVar, zzapu zzapuVar) {
        zzapuVar.a();
        zzapuVar.b();
        this.f23990g = zzapuVar.f24112e;
        zzapuVar.b();
        this.f23989f = zzaerVar.e(zzapuVar.f24111d, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaog
    public final void zza() {
        this.f23991h = 0;
        this.f23992i = 0;
        this.f23994k = false;
        this.n = -9223372036854775807L;
    }
}
