package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes4.dex */
final class zzabo {

    /* renamed from: a, reason: collision with root package name */
    public long f22660a;

    /* renamed from: b, reason: collision with root package name */
    public long f22661b;

    /* renamed from: c, reason: collision with root package name */
    public long f22662c;

    /* renamed from: d, reason: collision with root package name */
    public long f22663d;

    /* renamed from: e, reason: collision with root package name */
    public long f22664e;

    /* renamed from: f, reason: collision with root package name */
    public long f22665f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean[] f22666g = new boolean[15];

    /* renamed from: h, reason: collision with root package name */
    public int f22667h;

    public final void a() {
        this.f22663d = 0L;
        this.f22664e = 0L;
        this.f22665f = 0L;
        this.f22667h = 0;
        Arrays.fill(this.f22666g, false);
    }

    public final boolean b() {
        return this.f22663d > 15 && this.f22667h == 0;
    }

    public final void c(long j2) {
        long j3 = this.f22663d;
        if (j3 == 0) {
            this.f22660a = j2;
        } else if (j3 == 1) {
            long j4 = j2 - this.f22660a;
            this.f22661b = j4;
            this.f22665f = j4;
            this.f22664e = 1L;
        } else {
            long j5 = j2 - this.f22662c;
            long jAbs = Math.abs(j5 - this.f22661b);
            int i2 = (int) (j3 % 15);
            boolean[] zArr = this.f22666g;
            if (jAbs <= 1000000) {
                this.f22664e++;
                this.f22665f += j5;
                if (zArr[i2]) {
                    zArr[i2] = false;
                    this.f22667h--;
                }
            } else if (!zArr[i2]) {
                zArr[i2] = true;
                this.f22667h++;
            }
        }
        this.f22663d++;
        this.f22662c = j2;
    }
}
