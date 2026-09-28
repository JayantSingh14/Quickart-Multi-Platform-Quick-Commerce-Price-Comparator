package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
public final class zzsz extends zzcp {

    /* renamed from: i, reason: collision with root package name */
    public static final int f35563i = Float.floatToIntBits(Float.NaN);

    public static void i(int i2, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (i2 * 4.656612875245797E-10d));
        if (iFloatToIntBits == f35563i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferD;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit - iPosition;
        int i3 = this.f26854b.f26487c;
        if (i3 == 2) {
            byteBufferD = d(i2 + i2);
            while (iPosition < iLimit) {
                i(((byteBuffer.get(iPosition) & 255) << 16) | ((byteBuffer.get(iPosition + 1) & 255) << 24), byteBufferD);
                iPosition += 2;
            }
        } else if (i3 == 1342177280) {
            byteBufferD = d((i2 / 3) * 4);
            while (iPosition < iLimit) {
                i(((byteBuffer.get(iPosition + 2) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferD);
                iPosition += 3;
            }
        } else if (i3 == 1610612736) {
            byteBufferD = d(i2);
            while (iPosition < iLimit) {
                int i4 = byteBuffer.get(iPosition + 3) & 255;
                int i5 = (byteBuffer.get(iPosition + 2) & 255) << 8;
                i(i4 | i5 | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition) & 255) << 24), byteBufferD);
                iPosition += 4;
            }
        } else if (i3 == 21) {
            byteBufferD = d((i2 / 3) * 4);
            while (iPosition < iLimit) {
                i(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferD);
                iPosition += 3;
            }
        } else {
            if (i3 != 22) {
                throw new IllegalStateException();
            }
            byteBufferD = d(i2);
            while (iPosition < iLimit) {
                int i6 = byteBuffer.get(iPosition) & 255;
                int i7 = (byteBuffer.get(iPosition + 1) & 255) << 8;
                i(i6 | i7 | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferD);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferD.flip();
    }

    @Override // com.google.android.gms.internal.ads.zzcp
    public final zzcl e(zzcl zzclVar) throws zzcn {
        String str = zzfj.f31254a;
        int i2 = zzclVar.f26487c;
        if (i2 != 21 && i2 != 1342177280 && i2 != 22 && i2 != 1610612736) {
            if (i2 == 4) {
                return zzcl.f26484e;
            }
            if (i2 != 2) {
                throw new zzcn("Unhandled input format:", zzclVar);
            }
        }
        return new zzcl(zzclVar.f26485a, zzclVar.f26486b, 4);
    }
}
