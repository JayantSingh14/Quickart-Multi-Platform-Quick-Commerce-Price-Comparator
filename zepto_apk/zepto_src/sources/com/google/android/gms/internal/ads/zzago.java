package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzago implements zzagj {

    /* renamed from: a, reason: collision with root package name */
    public final int f23034a;

    /* renamed from: b, reason: collision with root package name */
    public final int f23035b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23036c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23037d;

    /* renamed from: e, reason: collision with root package name */
    public final int f23038e;

    /* renamed from: f, reason: collision with root package name */
    public final int f23039f;

    public zzago(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f23034a = i2;
        this.f23035b = i3;
        this.f23036c = i4;
        this.f23037d = i5;
        this.f23038e = i6;
        this.f23039f = i7;
    }

    public final int a() {
        int i2 = this.f23034a;
        if (i2 == 1935960438) {
            return 2;
        }
        if (i2 == 1935963489) {
            return 1;
        }
        if (i2 == 1937012852) {
            return 3;
        }
        zzee.c("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(Integer.toHexString(i2))));
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzagj
    public final int zza() {
        return 1752331379;
    }
}
