package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import org.xbill.DNS.Flags;

/* loaded from: classes4.dex */
public final class zzsx {

    /* renamed from: d, reason: collision with root package name */
    public static final byte[] f35553d = {79, 103, 103, 83, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 28, -43, -59, -9, 1, 19, 79, 112, 117, 115, 72, 101, 97, 100, 1, 2, 56, 1, -128, -69, 0, 0, 0, 0, 0};

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f35554e = {79, 103, 103, 83, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, Flags.CD, -103, 87, 83, 1, 16, 79, 112, 117, 115, 84, 97, 103, 115, 0, 0, 0, 0, 0, 0, 0, 0};

    /* renamed from: a, reason: collision with root package name */
    public ByteBuffer f35555a = zzco.f26781a;

    /* renamed from: c, reason: collision with root package name */
    public int f35557c = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f35556b = 2;

    public static final void b(ByteBuffer byteBuffer, long j2, int i2, int i3, boolean z) {
        byteBuffer.put((byte) 79);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 103);
        byteBuffer.put((byte) 83);
        byteBuffer.put((byte) 0);
        byteBuffer.put(true != z ? (byte) 0 : (byte) 2);
        byteBuffer.putLong(j2);
        byteBuffer.putInt(0);
        byteBuffer.putInt(i2);
        byteBuffer.putInt(0);
        byteBuffer.put(zzgxb.a(i3));
    }

    public final void a(zzih zzihVar, List list) {
        int length;
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2 = zzihVar.f34829d;
        byteBuffer2.getClass();
        if (byteBuffer2.limit() - zzihVar.f34829d.position() == 0) {
            return;
        }
        byte[] bArr = null;
        if (this.f35556b == 2 && (list.size() == 1 || list.size() == 3)) {
            bArr = (byte[]) list.get(0);
        }
        ByteBuffer byteBuffer3 = zzihVar.f34829d;
        int iPosition = byteBuffer3.position();
        int iLimit = byteBuffer3.limit();
        int i2 = iLimit - iPosition;
        int i3 = (i2 + 255) / 255;
        int i4 = i3 + 27 + i2;
        if (this.f35556b == 2) {
            length = bArr != null ? bArr.length + 28 : 47;
            i4 += length + 44;
        } else {
            length = 0;
        }
        if (this.f35555a.capacity() < i4) {
            this.f35555a = ByteBuffer.allocate(i4).order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f35555a.clear();
        }
        ByteBuffer byteBuffer4 = this.f35555a;
        if (this.f35556b == 2) {
            if (bArr != null) {
                byteBuffer = byteBuffer4;
                b(byteBuffer, 0L, 0, 1, true);
                int length2 = bArr.length;
                byteBuffer.put(zzgxb.a(length2));
                byteBuffer.put(bArr);
                int i5 = length2 + 28;
                byteBuffer.putInt(22, zzfj.f(byteBuffer.arrayOffset(), i5, byteBuffer.array(), 0));
                byteBuffer.position(i5);
            } else {
                byteBuffer = byteBuffer4;
                byteBuffer.put(f35553d);
            }
            byteBuffer.put(f35554e);
        } else {
            byteBuffer = byteBuffer4;
        }
        int iB = this.f35557c + ((int) ((zzafn.b(byteBuffer3.get(0), byteBuffer3.limit() > 1 ? byteBuffer3.get(1) : (byte) 0) * 48000) / 1000000));
        this.f35557c = iB;
        ByteBuffer byteBuffer5 = byteBuffer;
        b(byteBuffer5, iB, this.f35556b, i3, false);
        for (int i6 = 0; i6 < i3; i6++) {
            if (i2 >= 255) {
                byteBuffer5.put((byte) -1);
                i2 -= 255;
            } else {
                byteBuffer5.put((byte) i2);
                i2 = 0;
            }
        }
        while (iPosition < iLimit) {
            byteBuffer5.put(byteBuffer3.get(iPosition));
            iPosition++;
        }
        byteBuffer3.position(byteBuffer3.limit());
        byteBuffer5.flip();
        if (this.f35556b == 2) {
            byteBuffer5.putInt(length + 66, zzfj.f(byteBuffer5.arrayOffset() + length + 44, byteBuffer5.limit() - byteBuffer5.position(), byteBuffer5.array(), 0));
        } else {
            byteBuffer5.putInt(22, zzfj.f(byteBuffer5.arrayOffset(), byteBuffer5.limit() - byteBuffer5.position(), byteBuffer5.array(), 0));
        }
        this.f35556b++;
        this.f35555a = byteBuffer5;
        zzihVar.c();
        zzihVar.d(this.f35555a.remaining());
        zzihVar.f34829d.put(this.f35555a);
        zzihVar.f();
    }
}
