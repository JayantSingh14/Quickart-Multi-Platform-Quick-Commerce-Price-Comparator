package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class zzibh extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f34664a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f34665b;

    /* renamed from: c, reason: collision with root package name */
    public int f34666c;

    /* renamed from: d, reason: collision with root package name */
    public int f34667d;

    /* renamed from: e, reason: collision with root package name */
    public int f34668e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f34669f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f34670g;

    /* renamed from: h, reason: collision with root package name */
    public int f34671h;

    /* renamed from: i, reason: collision with root package name */
    public long f34672i;

    public final boolean a() {
        ByteBuffer byteBuffer;
        do {
            this.f34667d++;
            Iterator it = this.f34664a;
            if (!it.hasNext()) {
                return false;
            }
            byteBuffer = (ByteBuffer) it.next();
            this.f34665b = byteBuffer;
        } while (!byteBuffer.hasRemaining());
        this.f34668e = this.f34665b.position();
        if (this.f34665b.hasArray()) {
            this.f34669f = true;
            this.f34670g = this.f34665b.array();
            this.f34671h = this.f34665b.arrayOffset();
        } else {
            this.f34669f = false;
            this.f34672i = zzidm.m(this.f34665b);
            this.f34670g = null;
        }
        return true;
    }

    public final void b(int i2) {
        int i3 = this.f34668e + i2;
        this.f34668e = i3;
        if (i3 == this.f34665b.limit()) {
            a();
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f34667d == this.f34666c) {
            return -1;
        }
        if (this.f34669f) {
            int i2 = this.f34670g[this.f34668e + this.f34671h] & 255;
            b(1);
            return i2;
        }
        int iH = zzidm.f34769c.h(this.f34668e + this.f34672i) & 255;
        b(1);
        return iH;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        if (this.f34667d == this.f34666c) {
            return -1;
        }
        int iLimit = this.f34665b.limit();
        int i4 = this.f34668e;
        int i5 = iLimit - i4;
        if (i3 > i5) {
            i3 = i5;
        }
        if (this.f34669f) {
            System.arraycopy(this.f34670g, i4 + this.f34671h, bArr, i2, i3);
            b(i3);
            return i3;
        }
        int iPosition = this.f34665b.position();
        this.f34665b.position(this.f34668e);
        this.f34665b.get(bArr, i2, i3);
        this.f34665b.position(iPosition);
        b(i3);
        return i3;
    }
}
