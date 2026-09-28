package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class zzagi implements zzaeo {

    /* renamed from: l, reason: collision with root package name */
    public static final int[] f23001l = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f23002m = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
    public static final byte[] n;
    public static final byte[] o;

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f23003a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f23004b;

    /* renamed from: c, reason: collision with root package name */
    public long f23005c;

    /* renamed from: d, reason: collision with root package name */
    public int f23006d;

    /* renamed from: e, reason: collision with root package name */
    public int f23007e;

    /* renamed from: f, reason: collision with root package name */
    public int f23008f;

    /* renamed from: g, reason: collision with root package name */
    public zzaer f23009g;

    /* renamed from: h, reason: collision with root package name */
    public zzaga f23010h;

    /* renamed from: i, reason: collision with root package name */
    public zzaga f23011i;

    /* renamed from: j, reason: collision with root package name */
    public zzafq f23012j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f23013k;

    static {
        String str = zzfj.f31254a;
        Charset charset = StandardCharsets.UTF_8;
        n = "#!AMR\n".getBytes(charset);
        o = "#!AMR-WB\n".getBytes(charset);
    }

    public zzagi() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void a(long j2, long j3) {
        this.f23005c = 0L;
        this.f23006d = 0;
        this.f23007e = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void b(zzaer zzaerVar) {
        this.f23009g = zzaerVar;
        zzxk zzxkVar = (zzxk) zzaerVar;
        zzaga zzagaVarE = zzxkVar.e(0, 1);
        this.f23010h = zzagaVarE;
        this.f23011i = zzagaVarE;
        zzxkVar.h();
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final boolean c(zzaep zzaepVar) {
        return e((zzaef) zzaepVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00aa A[Catch: EOFException -> 0x0103, TryCatch #0 {EOFException -> 0x0103, blocks: (B:26:0x0073, B:28:0x0088, B:42:0x00aa, B:44:0x00af, B:43:0x00ad, B:51:0x00c1, B:52:0x00e4, B:53:0x00e5, B:54:0x0102), top: B:71:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad A[Catch: EOFException -> 0x0103, TryCatch #0 {EOFException -> 0x0103, blocks: (B:26:0x0073, B:28:0x0088, B:42:0x00aa, B:44:0x00af, B:43:0x00ad, B:51:0x00c1, B:52:0x00e4, B:53:0x00e5, B:54:0x0102), top: B:71:0x0073 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010e  */
    @Override // com.google.android.gms.internal.ads.zzaeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(com.google.android.gms.internal.ads.zzaep r19, com.google.android.gms.internal.ads.zzafo r20) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instructions count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagi.d(com.google.android.gms.internal.ads.zzaep, com.google.android.gms.internal.ads.zzafo):int");
    }

    public final boolean e(zzaef zzaefVar) throws EOFException, InterruptedIOException {
        zzaefVar.f22874f = 0;
        byte[] bArr = n;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        zzaefVar.t(bArr2, 0, length, false);
        if (Arrays.equals(bArr2, bArr)) {
            this.f23004b = false;
            zzaefVar.d(bArr.length, false);
            return true;
        }
        zzaefVar.f22874f = 0;
        byte[] bArr3 = o;
        int length2 = bArr3.length;
        byte[] bArr4 = new byte[length2];
        zzaefVar.t(bArr4, 0, length2, false);
        if (!Arrays.equals(bArr4, bArr3)) {
            return false;
        }
        this.f23004b = true;
        zzaefVar.d(bArr3.length, false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaeo
    public final void zzf() {
    }

    public zzagi(int i2) {
        this.f23003a = new byte[1];
        this.f23008f = -1;
        this.f23011i = new zzael();
    }
}
