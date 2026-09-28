package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public class zzih extends zzic {

    /* renamed from: b, reason: collision with root package name */
    public zzv f34827b;

    /* renamed from: c, reason: collision with root package name */
    public final zzie f34828c = new zzie();

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f34829d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f34830e;

    /* renamed from: f, reason: collision with root package name */
    public long f34831f;

    /* renamed from: g, reason: collision with root package name */
    public ByteBuffer f34832g;

    /* renamed from: h, reason: collision with root package name */
    public final int f34833h;

    static {
        zzal.a("media3.decoder");
    }

    public zzih(int i2) {
        this.f34833h = i2;
    }

    public void c() {
        this.f34703a = 0;
        ByteBuffer byteBuffer = this.f34829d;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.f34832g;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.f34830e = false;
    }

    public final void d(int i2) {
        ByteBuffer byteBuffer = this.f34829d;
        if (byteBuffer == null) {
            this.f34829d = g(i2);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i3 = i2 + iPosition;
        if (iCapacity >= i3) {
            this.f34829d = byteBuffer;
            return;
        }
        ByteBuffer byteBufferG = g(i3);
        byteBufferG.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferG.put(byteBuffer);
        }
        this.f34829d = byteBufferG;
    }

    public final boolean e() {
        return b(1073741824);
    }

    public final void f() {
        ByteBuffer byteBuffer = this.f34829d;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.f34832g;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final ByteBuffer g(int i2) {
        int i3 = this.f34833h;
        if (i3 == 1) {
            return ByteBuffer.allocate(i2);
        }
        if (i3 == 2) {
            return ByteBuffer.allocateDirect(i2);
        }
        ByteBuffer byteBuffer = this.f34829d;
        int iCapacity = byteBuffer == null ? 0 : byteBuffer.capacity();
        StringBuilder sb = new StringBuilder(String.valueOf(iCapacity).length() + 21 + String.valueOf(i2).length() + 1);
        androidx.fragment.app.e.w(iCapacity, i2, "Buffer too small (", " < ", sb);
        sb.append(")");
        throw new zzig(sb.toString());
    }
}
