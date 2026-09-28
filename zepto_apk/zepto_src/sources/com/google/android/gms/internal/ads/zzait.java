package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;

/* loaded from: classes4.dex */
final class zzait {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f23213a = new byte[8];

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f23214b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final zzajc f23215c = new zzajc();

    /* renamed from: d, reason: collision with root package name */
    public zzaiu f23216d;

    /* renamed from: e, reason: collision with root package name */
    public int f23217e;

    /* renamed from: f, reason: collision with root package name */
    public int f23218f;

    /* renamed from: g, reason: collision with root package name */
    public long f23219g;

    public final long a(zzaef zzaefVar, int i2) throws EOFException, InterruptedIOException {
        zzaefVar.v(this.f23213a, 0, i2, false);
        long j2 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            j2 = (j2 << 8) | (r0[i3] & 255);
        }
        return j2;
    }
}
