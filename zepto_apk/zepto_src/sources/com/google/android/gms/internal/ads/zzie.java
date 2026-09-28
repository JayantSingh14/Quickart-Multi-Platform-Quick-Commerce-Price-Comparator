package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* loaded from: classes4.dex */
public final class zzie {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f34798a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f34799b;

    /* renamed from: c, reason: collision with root package name */
    public int f34800c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f34801d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f34802e;

    /* renamed from: f, reason: collision with root package name */
    public int f34803f;

    /* renamed from: g, reason: collision with root package name */
    public int f34804g;

    /* renamed from: h, reason: collision with root package name */
    public int f34805h;

    /* renamed from: i, reason: collision with root package name */
    public final MediaCodec.CryptoInfo f34806i;

    /* renamed from: j, reason: collision with root package name */
    public final zzid f34807j;

    public zzie() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f34806i = cryptoInfo;
        this.f34807j = new zzid(cryptoInfo);
    }

    public final void a(int i2) {
        if (i2 == 0) {
            return;
        }
        if (this.f34801d == null) {
            int[] iArr = new int[1];
            this.f34801d = iArr;
            this.f34806i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f34801d;
        iArr2[0] = iArr2[0] + i2;
    }
}
