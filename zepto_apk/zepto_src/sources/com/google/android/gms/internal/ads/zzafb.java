package com.google.android.gms.internal.ads;

import java.nio.ByteOrder;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class zzafb {

    /* renamed from: a, reason: collision with root package name */
    public final int f22904a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22905b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22906c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22907d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22908e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22909f;

    /* renamed from: g, reason: collision with root package name */
    public final int f22910g;

    /* renamed from: h, reason: collision with root package name */
    public final int f22911h;

    /* renamed from: i, reason: collision with root package name */
    public final int f22912i;

    /* renamed from: j, reason: collision with root package name */
    public final long f22913j;

    /* renamed from: k, reason: collision with root package name */
    public final zzafa f22914k;

    /* renamed from: l, reason: collision with root package name */
    public final zzap f22915l;

    public zzafb(int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j2, zzafa zzafaVar, zzap zzapVar) {
        this.f22904a = i2;
        this.f22905b = i3;
        this.f22906c = i4;
        this.f22907d = i5;
        this.f22908e = i6;
        this.f22909f = c(i6);
        this.f22910g = i7;
        this.f22911h = i8;
        this.f22912i = d(i8);
        this.f22913j = j2;
        this.f22914k = zzafaVar;
        this.f22915l = zzapVar;
    }

    public static int c(int i2) {
        switch (i2) {
            case 8000:
                return 4;
            case 16000:
                return 5;
            case 22050:
                return 6;
            case 24000:
                return 7;
            case 32000:
                return 8;
            case 44100:
                return 9;
            case 48000:
                return 10;
            case 88200:
                return 1;
            case 96000:
                return 11;
            case 176400:
                return 2;
            case 192000:
                return 3;
            default:
                return -1;
        }
    }

    public static int d(int i2) {
        if (i2 == 8) {
            return 1;
        }
        if (i2 == 12) {
            return 2;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 20) {
            return 5;
        }
        if (i2 != 24) {
            return i2 != 32 ? -1 : 7;
        }
        return 6;
    }

    public final long a() {
        long j2 = this.f22913j;
        if (j2 == 0) {
            return -9223372036854775807L;
        }
        return (j2 * 1000000) / this.f22908e;
    }

    public final zzv b(byte[] bArr, zzap zzapVar) {
        bArr[4] = -128;
        zzap zzapVar2 = this.f22915l;
        if (zzapVar2 != null) {
            zzapVar = zzapVar2.b(zzapVar);
        }
        zzt zztVar = new zzt();
        zztVar.e("audio/flac");
        int i2 = this.f22907d;
        if (i2 <= 0) {
            i2 = -1;
        }
        zztVar.f35576m = i2;
        zztVar.D = this.f22910g;
        zztVar.E = this.f22908e;
        zztVar.F = zzfj.y(this.f22911h, ByteOrder.LITTLE_ENDIAN);
        zztVar.o = Collections.singletonList(bArr);
        zztVar.f35573j = zzapVar;
        return new zzv(zztVar);
    }

    public zzafb(byte[] bArr, int i2) {
        zzeq zzeqVar = new zzeq(bArr, bArr.length);
        zzeqVar.d(i2 * 8);
        this.f22904a = zzeqVar.h(16);
        this.f22905b = zzeqVar.h(16);
        this.f22906c = zzeqVar.h(24);
        this.f22907d = zzeqVar.h(24);
        int iH = zzeqVar.h(20);
        this.f22908e = iH;
        this.f22909f = c(iH);
        this.f22910g = zzeqVar.h(3) + 1;
        int iH2 = zzeqVar.h(5) + 1;
        this.f22911h = iH2;
        this.f22912i = d(iH2);
        this.f22913j = zzeqVar.i(36);
        this.f22914k = null;
        this.f22915l = null;
    }
}
