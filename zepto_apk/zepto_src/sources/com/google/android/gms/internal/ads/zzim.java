package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzim {

    /* renamed from: a, reason: collision with root package name */
    public final long f34928a;

    /* renamed from: b, reason: collision with root package name */
    public final long f34929b;

    /* renamed from: c, reason: collision with root package name */
    public long f34930c = -9223372036854775807L;

    /* renamed from: d, reason: collision with root package name */
    public long f34931d = -9223372036854775807L;

    /* renamed from: f, reason: collision with root package name */
    public long f34933f = -9223372036854775807L;

    /* renamed from: g, reason: collision with root package name */
    public long f34934g = -9223372036854775807L;

    /* renamed from: i, reason: collision with root package name */
    public float f34936i = 1.0f;

    /* renamed from: j, reason: collision with root package name */
    public long f34937j = -9223372036854775807L;

    /* renamed from: e, reason: collision with root package name */
    public long f34932e = -9223372036854775807L;

    /* renamed from: h, reason: collision with root package name */
    public long f34935h = -9223372036854775807L;

    /* renamed from: k, reason: collision with root package name */
    public long f34938k = -9223372036854775807L;

    /* renamed from: l, reason: collision with root package name */
    public long f34939l = -9223372036854775807L;

    public /* synthetic */ zzim(long j2, long j3) {
        this.f34928a = j2;
        this.f34929b = j3;
    }

    public final void a() {
        long j2 = this.f34935h;
        if (j2 == -9223372036854775807L) {
            return;
        }
        long j3 = j2 + this.f34929b;
        this.f34935h = j3;
        long j4 = this.f34934g;
        if (j4 != -9223372036854775807L && j3 > j4) {
            this.f34935h = j4;
        }
        this.f34937j = -9223372036854775807L;
    }

    public final long b() {
        return this.f34935h;
    }

    public final void c() {
        long j2;
        long j3 = this.f34930c;
        if (j3 != -9223372036854775807L) {
            j2 = this.f34931d;
            if (j2 == -9223372036854775807L) {
                long j4 = this.f34933f;
                if (j4 != -9223372036854775807L && j3 < j4) {
                    j3 = j4;
                }
                j2 = this.f34934g;
                if (j2 == -9223372036854775807L || j3 <= j2) {
                    j2 = j3;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.f34932e == j2) {
            return;
        }
        this.f34932e = j2;
        this.f34935h = j2;
        this.f34938k = -9223372036854775807L;
        this.f34939l = -9223372036854775807L;
        this.f34937j = -9223372036854775807L;
    }
}
