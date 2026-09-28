package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: classes3.dex */
class IterableByteBufferInputStream extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    public Iterator f4029a;

    /* renamed from: b, reason: collision with root package name */
    public ByteBuffer f4030b;

    /* renamed from: c, reason: collision with root package name */
    public int f4031c;

    /* renamed from: d, reason: collision with root package name */
    public int f4032d;

    /* renamed from: e, reason: collision with root package name */
    public int f4033e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4034f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f4035g;

    /* renamed from: h, reason: collision with root package name */
    public int f4036h;

    /* renamed from: i, reason: collision with root package name */
    public long f4037i;

    public final boolean a() {
        this.f4032d++;
        Iterator it = this.f4029a;
        if (!it.hasNext()) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer) it.next();
        this.f4030b = byteBuffer;
        this.f4033e = byteBuffer.position();
        if (this.f4030b.hasArray()) {
            this.f4034f = true;
            this.f4035g = this.f4030b.array();
            this.f4036h = this.f4030b.arrayOffset();
        } else {
            this.f4034f = false;
            this.f4037i = UnsafeUtil.b(this.f4030b);
            this.f4035g = null;
        }
        return true;
    }

    public final void b(int i2) {
        int i3 = this.f4033e + i2;
        this.f4033e = i3;
        if (i3 == this.f4030b.limit()) {
            a();
        }
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f4032d == this.f4031c) {
            return -1;
        }
        if (this.f4034f) {
            int i2 = this.f4035g[this.f4033e + this.f4036h] & 255;
            b(1);
            return i2;
        }
        int iF = UnsafeUtil.f4183c.f(this.f4033e + this.f4037i) & 255;
        b(1);
        return iF;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) {
        if (this.f4032d == this.f4031c) {
            return -1;
        }
        int iLimit = this.f4030b.limit();
        int i4 = this.f4033e;
        int i5 = iLimit - i4;
        if (i3 > i5) {
            i3 = i5;
        }
        if (this.f4034f) {
            System.arraycopy(this.f4035g, i4 + this.f4036h, bArr, i2, i3);
            b(i3);
            return i3;
        }
        int iPosition = this.f4030b.position();
        this.f4030b.position(this.f4033e);
        this.f4030b.get(bArr, i2, i3);
        this.f4030b.position(iPosition);
        b(i3);
        return i3;
    }
}
