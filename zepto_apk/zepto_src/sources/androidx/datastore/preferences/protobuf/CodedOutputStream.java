package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public abstract class CodedOutputStream extends ByteOutput {

    /* renamed from: b, reason: collision with root package name */
    public static final Logger f3801b = Logger.getLogger(CodedOutputStream.class.getName());

    /* renamed from: c, reason: collision with root package name */
    public static final boolean f3802c = UnsafeUtil.f4185e;

    /* renamed from: a, reason: collision with root package name */
    public CodedOutputStreamWriter f3803a;

    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f3804d;

        /* renamed from: e, reason: collision with root package name */
        public final int f3805e;

        /* renamed from: f, reason: collision with root package name */
        public int f3806f;

        public AbstractBufferedEncoder(int i2) {
            if (i2 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i2, 20)];
            this.f3804d = bArr;
            this.f3805e = bArr.length;
        }

        public final void t0(byte b2) {
            int i2 = this.f3806f;
            this.f3806f = i2 + 1;
            this.f3804d[i2] = b2;
        }

        public final void u0(int i2) {
            int i3 = this.f3806f;
            int i4 = i3 + 1;
            this.f3806f = i4;
            byte[] bArr = this.f3804d;
            bArr[i3] = (byte) (i2 & 255);
            int i5 = i3 + 2;
            this.f3806f = i5;
            bArr[i4] = (byte) ((i2 >> 8) & 255);
            int i6 = i3 + 3;
            this.f3806f = i6;
            bArr[i5] = (byte) ((i2 >> 16) & 255);
            this.f3806f = i3 + 4;
            bArr[i6] = (byte) ((i2 >> 24) & 255);
        }

        public final void v0(long j2) {
            int i2 = this.f3806f;
            int i3 = i2 + 1;
            this.f3806f = i3;
            byte[] bArr = this.f3804d;
            bArr[i2] = (byte) (j2 & 255);
            int i4 = i2 + 2;
            this.f3806f = i4;
            bArr[i3] = (byte) ((j2 >> 8) & 255);
            int i5 = i2 + 3;
            this.f3806f = i5;
            bArr[i4] = (byte) ((j2 >> 16) & 255);
            int i6 = i2 + 4;
            this.f3806f = i6;
            bArr[i5] = (byte) (255 & (j2 >> 24));
            int i7 = i2 + 5;
            this.f3806f = i7;
            bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
            int i8 = i2 + 6;
            this.f3806f = i8;
            bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
            int i9 = i2 + 7;
            this.f3806f = i9;
            bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
            this.f3806f = i2 + 8;
            bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
        }

        public final void w0(int i2, int i3) {
            x0((i2 << 3) | i3);
        }

        public final void x0(int i2) {
            boolean z = CodedOutputStream.f3802c;
            byte[] bArr = this.f3804d;
            if (z) {
                while ((i2 & (-128)) != 0) {
                    int i3 = this.f3806f;
                    this.f3806f = i3 + 1;
                    UnsafeUtil.m(bArr, i3, (byte) ((i2 | 128) & 255));
                    i2 >>>= 7;
                }
                int i4 = this.f3806f;
                this.f3806f = i4 + 1;
                UnsafeUtil.m(bArr, i4, (byte) i2);
                return;
            }
            while ((i2 & (-128)) != 0) {
                int i5 = this.f3806f;
                this.f3806f = i5 + 1;
                bArr[i5] = (byte) ((i2 | 128) & 255);
                i2 >>>= 7;
            }
            int i6 = this.f3806f;
            this.f3806f = i6 + 1;
            bArr[i6] = (byte) i2;
        }

        public final void y0(long j2) {
            boolean z = CodedOutputStream.f3802c;
            byte[] bArr = this.f3804d;
            if (z) {
                while ((j2 & (-128)) != 0) {
                    int i2 = this.f3806f;
                    this.f3806f = i2 + 1;
                    UnsafeUtil.m(bArr, i2, (byte) ((((int) j2) | 128) & 255));
                    j2 >>>= 7;
                }
                int i3 = this.f3806f;
                this.f3806f = i3 + 1;
                UnsafeUtil.m(bArr, i3, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                int i4 = this.f3806f;
                this.f3806f = i4 + 1;
                bArr[i4] = (byte) ((((int) j2) | 128) & 255);
                j2 >>>= 7;
            }
            int i5 = this.f3806f;
            this.f3806f = i5 + 1;
            bArr[i5] = (byte) j2;
        }
    }

    public static class ArrayEncoder extends CodedOutputStream {

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f3807d;

        /* renamed from: e, reason: collision with root package name */
        public final int f3808e;

        /* renamed from: f, reason: collision with root package name */
        public int f3809f;

        public ArrayEncoder(byte[] bArr, int i2) {
            if (((bArr.length - i2) | i2) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.f3807d = bArr;
            this.f3809f = 0;
            this.f3808e = i2;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void D(int i2, boolean z) throws OutOfSpaceException {
            q0(i2, 0);
            e0(z ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void Q(int i2, byte[] bArr, int i3) throws OutOfSpaceException {
            t0(bArr, i2, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) throws OutOfSpaceException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f3807d, this.f3809f, iRemaining);
                this.f3809f += iRemaining;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3809f), Integer.valueOf(this.f3808e), Integer.valueOf(iRemaining)), e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void c(int i2, int i3) throws OutOfSpaceException {
            q0(i2, 5);
            h0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void e0(byte b2) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f3807d;
                int i2 = this.f3809f;
                this.f3809f = i2 + 1;
                bArr[i2] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3809f), Integer.valueOf(this.f3808e), 1), e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f(int i2, String str) throws OutOfSpaceException {
            q0(i2, 2);
            p0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f0(int i2, byte[] bArr) throws OutOfSpaceException {
            r0(i2);
            t0(bArr, 0, i2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g(int i2, long j2) throws OutOfSpaceException {
            q0(i2, 0);
            s0(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g0(ByteString byteString) throws OutOfSpaceException {
            r0(byteString.size());
            byteString.w(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void h0(int i2) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f3807d;
                int i3 = this.f3809f;
                int i4 = i3 + 1;
                this.f3809f = i4;
                bArr[i3] = (byte) (i2 & 255);
                int i5 = i3 + 2;
                this.f3809f = i5;
                bArr[i4] = (byte) ((i2 >> 8) & 255);
                int i6 = i3 + 3;
                this.f3809f = i6;
                bArr[i5] = (byte) ((i2 >> 16) & 255);
                this.f3809f = i3 + 4;
                bArr[i6] = (byte) ((i2 >> 24) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3809f), Integer.valueOf(this.f3808e), 1), e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i(int i2, int i3) throws OutOfSpaceException {
            q0(i2, 0);
            j0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i0(long j2) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f3807d;
                int i2 = this.f3809f;
                int i3 = i2 + 1;
                this.f3809f = i3;
                bArr[i2] = (byte) (((int) j2) & 255);
                int i4 = i2 + 2;
                this.f3809f = i4;
                bArr[i3] = (byte) (((int) (j2 >> 8)) & 255);
                int i5 = i2 + 3;
                this.f3809f = i5;
                bArr[i4] = (byte) (((int) (j2 >> 16)) & 255);
                int i6 = i2 + 4;
                this.f3809f = i6;
                bArr[i5] = (byte) (((int) (j2 >> 24)) & 255);
                int i7 = i2 + 5;
                this.f3809f = i7;
                bArr[i6] = (byte) (((int) (j2 >> 32)) & 255);
                int i8 = i2 + 6;
                this.f3809f = i8;
                bArr[i7] = (byte) (((int) (j2 >> 40)) & 255);
                int i9 = i2 + 7;
                this.f3809f = i9;
                bArr[i8] = (byte) (((int) (j2 >> 48)) & 255);
                this.f3809f = i2 + 8;
                bArr[i9] = (byte) (((int) (j2 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3809f), Integer.valueOf(this.f3808e), 1), e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j(int i2, ByteString byteString) throws OutOfSpaceException {
            q0(i2, 2);
            g0(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j0(int i2) throws OutOfSpaceException {
            if (i2 >= 0) {
                r0(i2);
            } else {
                s0(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void k0(int i2, MessageLite messageLite) throws OutOfSpaceException {
            q0(i2, 2);
            m0(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void l0(int i2, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            q0(i2, 2);
            r0(((AbstractMessageLite) messageLite).j(schema));
            schema.h(messageLite, this.f3803a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void m0(MessageLite messageLite) throws OutOfSpaceException {
            r0(messageLite.c());
            messageLite.g(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void n0(int i2, MessageLite messageLite) throws OutOfSpaceException {
            q0(1, 3);
            t(2, i2);
            k0(3, messageLite);
            q0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void o0(int i2, ByteString byteString) throws OutOfSpaceException {
            q0(1, 3);
            t(2, i2);
            j(3, byteString);
            q0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void p0(String str) throws OutOfSpaceException {
            int i2 = this.f3809f;
            try {
                int iZ = CodedOutputStream.Z(str.length() * 3);
                int iZ2 = CodedOutputStream.Z(str.length());
                int i3 = this.f3808e;
                byte[] bArr = this.f3807d;
                if (iZ2 != iZ) {
                    r0(Utf8.d(str));
                    int i4 = this.f3809f;
                    this.f3809f = Utf8.f4190a.d(str, bArr, i4, i3 - i4);
                    return;
                }
                int i5 = i2 + iZ2;
                this.f3809f = i5;
                int iD = Utf8.f4190a.d(str, bArr, i5, i3 - i5);
                this.f3809f = i2;
                r0((iD - i2) - iZ2);
                this.f3809f = iD;
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f3809f = i2;
                d0(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void q0(int i2, int i3) throws OutOfSpaceException {
            r0((i2 << 3) | i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void r0(int i2) throws OutOfSpaceException {
            while (true) {
                int i3 = i2 & (-128);
                byte[] bArr = this.f3807d;
                if (i3 == 0) {
                    int i4 = this.f3809f;
                    this.f3809f = i4 + 1;
                    bArr[i4] = (byte) i2;
                    return;
                } else {
                    try {
                        int i5 = this.f3809f;
                        this.f3809f = i5 + 1;
                        bArr[i5] = (byte) ((i2 | 128) & 255);
                        i2 >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3809f), Integer.valueOf(this.f3808e), 1), e2);
                    }
                }
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3809f), Integer.valueOf(this.f3808e), 1), e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void s0(long j2) throws OutOfSpaceException {
            boolean z = CodedOutputStream.f3802c;
            int i2 = this.f3808e;
            byte[] bArr = this.f3807d;
            if (z && i2 - this.f3809f >= 10) {
                while ((j2 & (-128)) != 0) {
                    int i3 = this.f3809f;
                    this.f3809f = i3 + 1;
                    UnsafeUtil.m(bArr, i3, (byte) ((((int) j2) | 128) & 255));
                    j2 >>>= 7;
                }
                int i4 = this.f3809f;
                this.f3809f = i4 + 1;
                UnsafeUtil.m(bArr, i4, (byte) j2);
                return;
            }
            while ((j2 & (-128)) != 0) {
                try {
                    int i5 = this.f3809f;
                    this.f3809f = i5 + 1;
                    bArr[i5] = (byte) ((((int) j2) | 128) & 255);
                    j2 >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3809f), Integer.valueOf(i2), 1), e2);
                }
            }
            int i6 = this.f3809f;
            this.f3809f = i6 + 1;
            bArr[i6] = (byte) j2;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void t(int i2, int i3) throws OutOfSpaceException {
            q0(i2, 0);
            r0(i3);
        }

        public final void t0(byte[] bArr, int i2, int i3) throws OutOfSpaceException {
            try {
                System.arraycopy(bArr, i2, this.f3807d, this.f3809f, i3);
                this.f3809f += i3;
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f3809f), Integer.valueOf(this.f3808e), Integer.valueOf(i3)), e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void x(int i2, long j2) throws OutOfSpaceException {
            q0(i2, 1);
            i0(j2);
        }
    }

    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {
        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void D(int i2, boolean z) {
            z0(11);
            w0(i2, 0);
            t0(z ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void Q(int i2, byte[] bArr, int i3) {
            if (this.f3806f > 0) {
                throw null;
            }
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) {
            if (this.f3806f > 0) {
                throw null;
            }
            byteBuffer.remaining();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void c(int i2, int i3) {
            z0(14);
            w0(i2, 5);
            u0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void e0(byte b2) {
            if (this.f3806f == this.f3805e) {
                throw null;
            }
            t0(b2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f(int i2, String str) throws OutOfSpaceException {
            q0(i2, 2);
            p0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f0(int i2, byte[] bArr) {
            r0(i2);
            if (this.f3806f > 0) {
                throw null;
            }
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g(int i2, long j2) {
            z0(20);
            w0(i2, 0);
            y0(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g0(ByteString byteString) {
            r0(byteString.size());
            byteString.w(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void h0(int i2) {
            z0(4);
            u0(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i(int i2, int i3) {
            z0(20);
            w0(i2, 0);
            if (i3 >= 0) {
                x0(i3);
            } else {
                y0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i0(long j2) {
            z0(8);
            v0(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j(int i2, ByteString byteString) {
            q0(i2, 2);
            g0(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j0(int i2) {
            if (i2 >= 0) {
                r0(i2);
            } else {
                s0(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void k0(int i2, MessageLite messageLite) {
            q0(i2, 2);
            m0(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void l0(int i2, MessageLite messageLite, Schema schema) {
            q0(i2, 2);
            r0(((AbstractMessageLite) messageLite).j(schema));
            schema.h(messageLite, this.f3803a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void m0(MessageLite messageLite) {
            r0(messageLite.c());
            messageLite.g(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void n0(int i2, MessageLite messageLite) {
            q0(1, 3);
            t(2, i2);
            k0(3, messageLite);
            q0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void o0(int i2, ByteString byteString) {
            q0(1, 3);
            t(2, i2);
            j(3, byteString);
            q0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void p0(String str) throws OutOfSpaceException {
            int length = str.length() * 3;
            int iZ = CodedOutputStream.Z(length);
            int i2 = iZ + length;
            int i3 = this.f3805e;
            if (i2 > i3) {
                r0(Utf8.f4190a.d(str, new byte[length], 0, length));
                if (this.f3806f > 0) {
                    throw null;
                }
                throw null;
            }
            int i4 = this.f3806f;
            if (i2 > i3 - i4) {
                throw null;
            }
            try {
                int iZ2 = CodedOutputStream.Z(str.length());
                byte[] bArr = this.f3804d;
                if (iZ2 != iZ) {
                    int iD = Utf8.d(str);
                    x0(iD);
                    this.f3806f = Utf8.f4190a.d(str, bArr, this.f3806f, iD);
                    return;
                }
                int i5 = i4 + iZ2;
                this.f3806f = i5;
                int iD2 = Utf8.f4190a.d(str, bArr, i5, i3 - i5);
                this.f3806f = i4;
                x0((iD2 - i4) - iZ2);
                this.f3806f = iD2;
            } catch (Utf8.UnpairedSurrogateException e2) {
                this.f3806f = i4;
                d0(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void q0(int i2, int i3) {
            r0((i2 << 3) | i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void r0(int i2) {
            z0(5);
            x0(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void s0(long j2) {
            z0(10);
            y0(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void t(int i2, int i3) {
            z0(20);
            w0(i2, 0);
            x0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void x(int i2, long j2) {
            z0(18);
            w0(i2, 1);
            v0(j2);
        }

        public final void z0(int i2) {
            if (this.f3805e - this.f3806f < i2) {
                throw null;
            }
        }
    }

    public static final class HeapNioEncoder extends ArrayEncoder {
    }

    public static class OutOfSpaceException extends IOException {
        public OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(str));
        }

        public OutOfSpaceException(RuntimeException runtimeException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", runtimeException);
        }

        public OutOfSpaceException(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(str), indexOutOfBoundsException);
        }
    }

    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {

        /* renamed from: g, reason: collision with root package name */
        public final OutputStream f3810g;

        public OutputStreamEncoder(OutputStream outputStream, int i2) {
            super(i2);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f3810g = outputStream;
        }

        public final void A0(int i2) throws IOException {
            if (this.f3805e - this.f3806f < i2) {
                z0();
            }
        }

        public final void B0(byte[] bArr, int i2, int i3) throws IOException {
            int i4 = this.f3806f;
            int i5 = this.f3805e;
            int i6 = i5 - i4;
            byte[] bArr2 = this.f3804d;
            if (i6 >= i3) {
                System.arraycopy(bArr, i2, bArr2, i4, i3);
                this.f3806f += i3;
                return;
            }
            System.arraycopy(bArr, i2, bArr2, i4, i6);
            int i7 = i2 + i6;
            int i8 = i3 - i6;
            this.f3806f = i5;
            z0();
            if (i8 > i5) {
                this.f3810g.write(bArr, i7, i8);
            } else {
                System.arraycopy(bArr, i7, bArr2, 0, i8);
                this.f3806f = i8;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void D(int i2, boolean z) throws IOException {
            A0(11);
            w0(i2, 0);
            t0(z ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void Q(int i2, byte[] bArr, int i3) throws IOException {
            B0(bArr, i2, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i2 = this.f3806f;
            int i3 = this.f3805e;
            int i4 = i3 - i2;
            byte[] bArr = this.f3804d;
            if (i4 >= iRemaining) {
                byteBuffer.get(bArr, i2, iRemaining);
                this.f3806f += iRemaining;
                return;
            }
            byteBuffer.get(bArr, i2, i4);
            int i5 = iRemaining - i4;
            this.f3806f = i3;
            z0();
            while (i5 > i3) {
                byteBuffer.get(bArr, 0, i3);
                this.f3810g.write(bArr, 0, i3);
                i5 -= i3;
            }
            byteBuffer.get(bArr, 0, i5);
            this.f3806f = i5;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void c(int i2, int i3) throws IOException {
            A0(14);
            w0(i2, 5);
            u0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void e0(byte b2) throws IOException {
            if (this.f3806f == this.f3805e) {
                z0();
            }
            t0(b2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f(int i2, String str) throws IOException {
            q0(i2, 2);
            p0(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f0(int i2, byte[] bArr) throws IOException {
            r0(i2);
            B0(bArr, 0, i2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g(int i2, long j2) throws IOException {
            A0(20);
            w0(i2, 0);
            y0(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g0(ByteString byteString) throws IOException {
            r0(byteString.size());
            byteString.w(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void h0(int i2) throws IOException {
            A0(4);
            u0(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i(int i2, int i3) throws IOException {
            A0(20);
            w0(i2, 0);
            if (i3 >= 0) {
                x0(i3);
            } else {
                y0(i3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i0(long j2) throws IOException {
            A0(8);
            v0(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j(int i2, ByteString byteString) throws IOException {
            q0(i2, 2);
            g0(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j0(int i2) throws IOException {
            if (i2 >= 0) {
                r0(i2);
            } else {
                s0(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void k0(int i2, MessageLite messageLite) throws IOException {
            q0(i2, 2);
            m0(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void l0(int i2, MessageLite messageLite, Schema schema) throws IOException {
            q0(i2, 2);
            r0(((AbstractMessageLite) messageLite).j(schema));
            schema.h(messageLite, this.f3803a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void m0(MessageLite messageLite) throws IOException {
            r0(messageLite.c());
            messageLite.g(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void n0(int i2, MessageLite messageLite) throws IOException {
            q0(1, 3);
            t(2, i2);
            k0(3, messageLite);
            q0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void o0(int i2, ByteString byteString) throws IOException {
            q0(1, 3);
            t(2, i2);
            j(3, byteString);
            q0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void p0(String str) throws IOException {
            try {
                int length = str.length() * 3;
                int iZ = CodedOutputStream.Z(length);
                int i2 = iZ + length;
                int i3 = this.f3805e;
                if (i2 > i3) {
                    byte[] bArr = new byte[length];
                    int iD = Utf8.f4190a.d(str, bArr, 0, length);
                    r0(iD);
                    B0(bArr, 0, iD);
                    return;
                }
                if (i2 > i3 - this.f3806f) {
                    z0();
                }
                int iZ2 = CodedOutputStream.Z(str.length());
                int i4 = this.f3806f;
                byte[] bArr2 = this.f3804d;
                try {
                    try {
                        if (iZ2 == iZ) {
                            int i5 = i4 + iZ2;
                            this.f3806f = i5;
                            int iD2 = Utf8.f4190a.d(str, bArr2, i5, i3 - i5);
                            this.f3806f = i4;
                            x0((iD2 - i4) - iZ2);
                            this.f3806f = iD2;
                        } else {
                            int iD3 = Utf8.d(str);
                            x0(iD3);
                            this.f3806f = Utf8.f4190a.d(str, bArr2, this.f3806f, iD3);
                        }
                    } catch (Utf8.UnpairedSurrogateException e2) {
                        this.f3806f = i4;
                        throw e2;
                    }
                } catch (ArrayIndexOutOfBoundsException e3) {
                    throw new OutOfSpaceException(e3);
                }
            } catch (Utf8.UnpairedSurrogateException e4) {
                d0(str, e4);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void q0(int i2, int i3) throws IOException {
            r0((i2 << 3) | i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void r0(int i2) throws IOException {
            A0(5);
            x0(i2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void s0(long j2) throws IOException {
            A0(10);
            y0(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void t(int i2, int i3) throws IOException {
            A0(20);
            w0(i2, 0);
            x0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void x(int i2, long j2) throws IOException {
            A0(18);
            w0(i2, 1);
            v0(j2);
        }

        public final void z0() throws IOException {
            this.f3810g.write(this.f3804d, 0, this.f3806f);
            this.f3806f = 0;
        }
    }

    public static final class SafeDirectNioEncoder extends CodedOutputStream {
        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void D(int i2, boolean z) {
            q0(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void Q(int i2, byte[] bArr, int i3) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void c(int i2, int i3) {
            q0(i2, 5);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void e0(byte b2) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f(int i2, String str) {
            q0(i2, 2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f0(int i2, byte[] bArr) {
            r0(i2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g(int i2, long j2) {
            q0(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g0(ByteString byteString) {
            r0(byteString.size());
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void h0(int i2) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i(int i2, int i3) {
            q0(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i0(long j2) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j(int i2, ByteString byteString) {
            q0(i2, 2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j0(int i2) {
            if (i2 >= 0) {
                r0(i2);
                throw null;
            }
            s0(i2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void k0(int i2, MessageLite messageLite) {
            q0(i2, 2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void l0(int i2, MessageLite messageLite, Schema schema) {
            q0(i2, 2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void m0(MessageLite messageLite) {
            r0(messageLite.c());
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void n0(int i2, MessageLite messageLite) {
            q0(1, 3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void o0(int i2, ByteString byteString) {
            q0(1, 3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void p0(String str) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void q0(int i2, int i3) {
            r0((i2 << 3) | i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void r0(int i2) {
            if ((i2 & (-128)) != 0) {
                throw null;
            }
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void s0(long j2) {
            if ((j2 & (-128)) != 0) {
                throw null;
            }
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void t(int i2, int i3) {
            q0(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void x(int i2, long j2) {
            q0(i2, 1);
            throw null;
        }
    }

    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {

        /* renamed from: d, reason: collision with root package name */
        public long f3811d;

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void D(int i2, boolean z) throws OutOfSpaceException {
            q0(i2, 0);
            e0(z ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void Q(int i2, byte[] bArr, int i3) throws OutOfSpaceException {
            t0(bArr, i2, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) throws OutOfSpaceException {
            try {
                byteBuffer.remaining();
                throw null;
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void c(int i2, int i3) throws OutOfSpaceException {
            q0(i2, 5);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void e0(byte b2) throws OutOfSpaceException {
            long j2 = this.f3811d;
            if (j2 >= 0) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f3811d), 0L, 1));
            }
            this.f3811d = 1 + j2;
            UnsafeUtil.l(j2, b2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f(int i2, String str) throws OutOfSpaceException {
            q0(i2, 2);
            p0(str);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void f0(int i2, byte[] bArr) throws OutOfSpaceException {
            r0(i2);
            t0(bArr, 0, i2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g(int i2, long j2) throws OutOfSpaceException {
            q0(i2, 0);
            s0(j2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void g0(ByteString byteString) throws OutOfSpaceException {
            r0(byteString.size());
            byteString.w(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void h0(int i2) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i(int i2, int i3) throws OutOfSpaceException {
            q0(i2, 0);
            j0(i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void i0(long j2) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j(int i2, ByteString byteString) throws OutOfSpaceException {
            q0(i2, 2);
            g0(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void j0(int i2) throws OutOfSpaceException {
            if (i2 >= 0) {
                r0(i2);
            } else {
                s0(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void k0(int i2, MessageLite messageLite) throws OutOfSpaceException {
            q0(i2, 2);
            m0(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void l0(int i2, MessageLite messageLite, Schema schema) throws OutOfSpaceException {
            q0(i2, 2);
            r0(((AbstractMessageLite) messageLite).j(schema));
            schema.h(messageLite, this.f3803a);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void m0(MessageLite messageLite) throws OutOfSpaceException {
            r0(messageLite.c());
            messageLite.g(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void n0(int i2, MessageLite messageLite) throws OutOfSpaceException {
            q0(1, 3);
            t(2, i2);
            k0(3, messageLite);
            q0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void o0(int i2, ByteString byteString) throws OutOfSpaceException {
            q0(1, 3);
            t(2, i2);
            j(3, byteString);
            q0(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void p0(String str) throws OutOfSpaceException {
            long j2 = this.f3811d;
            try {
                if (CodedOutputStream.Z(str.length()) == CodedOutputStream.Z(str.length() * 3)) {
                    throw null;
                }
                r0(Utf8.d(str));
                throw null;
            } catch (Utf8.UnpairedSurrogateException unused) {
                this.f3811d = j2;
                throw null;
            } catch (IllegalArgumentException e2) {
                throw new OutOfSpaceException(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void q0(int i2, int i3) throws OutOfSpaceException {
            r0((i2 << 3) | i3);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void r0(int i2) throws OutOfSpaceException {
            if (this.f3811d <= 0) {
                while ((i2 & (-128)) != 0) {
                    long j2 = this.f3811d;
                    this.f3811d = j2 + 1;
                    UnsafeUtil.l(j2, (byte) ((i2 | 128) & 255));
                    i2 >>>= 7;
                }
                long j3 = this.f3811d;
                this.f3811d = 1 + j3;
                UnsafeUtil.l(j3, (byte) i2);
                return;
            }
            while (true) {
                long j4 = this.f3811d;
                if (j4 >= 0) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f3811d), 0L, 1));
                }
                if ((i2 & (-128)) == 0) {
                    this.f3811d = 1 + j4;
                    UnsafeUtil.l(j4, (byte) i2);
                    return;
                } else {
                    this.f3811d = j4 + 1;
                    UnsafeUtil.l(j4, (byte) ((i2 | 128) & 255));
                    i2 >>>= 7;
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void s0(long j2) throws OutOfSpaceException {
            if (this.f3811d <= 0) {
                while ((j2 & (-128)) != 0) {
                    long j3 = this.f3811d;
                    this.f3811d = j3 + 1;
                    UnsafeUtil.l(j3, (byte) ((((int) j2) | 128) & 255));
                    j2 >>>= 7;
                }
                long j4 = this.f3811d;
                this.f3811d = 1 + j4;
                UnsafeUtil.l(j4, (byte) j2);
                return;
            }
            while (true) {
                long j5 = this.f3811d;
                if (j5 >= 0) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f3811d), 0L, 1));
                }
                if ((j2 & (-128)) == 0) {
                    this.f3811d = 1 + j5;
                    UnsafeUtil.l(j5, (byte) j2);
                    return;
                } else {
                    this.f3811d = j5 + 1;
                    UnsafeUtil.l(j5, (byte) ((((int) j2) | 128) & 255));
                    j2 >>>= 7;
                }
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void t(int i2, int i3) throws OutOfSpaceException {
            q0(i2, 0);
            r0(i3);
        }

        public final void t0(byte[] bArr, int i2, int i3) throws OutOfSpaceException {
            if (bArr != null && i2 >= 0 && i3 >= 0 && bArr.length - i3 >= i2) {
                long j2 = i3;
                long j3 = 0 - j2;
                long j4 = this.f3811d;
                if (j3 >= j4) {
                    UnsafeUtil.f4183c.d(bArr, i2, j4, j2);
                    this.f3811d += j2;
                    return;
                }
            }
            if (bArr != null) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.f3811d), 0L, Integer.valueOf(i3)));
            }
            throw new NullPointerException(CLConstants.FIELD_PAY_INFO_VALUE);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public final void x(int i2, long j2) throws OutOfSpaceException {
            q0(i2, 1);
            throw null;
        }
    }

    public static int S(int i2, ByteString byteString) {
        return T(byteString) + Y(i2);
    }

    public static int T(ByteString byteString) {
        int size = byteString.size();
        return Z(size) + size;
    }

    public static int U(LazyFieldLite lazyFieldLite) {
        int size = lazyFieldLite.f4060b != null ? lazyFieldLite.f4060b.size() : lazyFieldLite.f4059a != null ? lazyFieldLite.f4059a.c() : 0;
        return Z(size) + size;
    }

    public static int V(int i2) {
        return Z(b0(i2));
    }

    public static int W(long j2) {
        return a0(c0(j2));
    }

    public static int X(String str) {
        int length;
        try {
            length = Utf8.d(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f4024a).length;
        }
        return Z(length) + length;
    }

    public static int Y(int i2) {
        return Z(i2 << 3);
    }

    public static int Z(int i2) {
        return (352 - (Integer.numberOfLeadingZeros(i2) * 9)) >>> 6;
    }

    public static int a0(long j2) {
        return (640 - (Long.numberOfLeadingZeros(j2) * 9)) >>> 6;
    }

    public static int b0(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    public static long c0(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    public abstract void D(int i2, boolean z);

    public abstract void c(int i2, int i3);

    public final void d0(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) throws OutOfSpaceException {
        f3801b.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f4024a);
        try {
            r0(bytes.length);
            Q(0, bytes, bytes.length);
        } catch (IndexOutOfBoundsException e2) {
            throw new OutOfSpaceException(e2);
        }
    }

    public abstract void e0(byte b2);

    public abstract void f(int i2, String str);

    public abstract void f0(int i2, byte[] bArr);

    public abstract void g(int i2, long j2);

    public abstract void g0(ByteString byteString);

    public abstract void h0(int i2);

    public abstract void i(int i2, int i3);

    public abstract void i0(long j2);

    public abstract void j(int i2, ByteString byteString);

    public abstract void j0(int i2);

    public abstract void k0(int i2, MessageLite messageLite);

    public abstract void l0(int i2, MessageLite messageLite, Schema schema);

    public abstract void m0(MessageLite messageLite);

    public abstract void n0(int i2, MessageLite messageLite);

    public abstract void o0(int i2, ByteString byteString);

    public abstract void p0(String str);

    public abstract void q0(int i2, int i3);

    public abstract void r0(int i2);

    public abstract void s0(long j2);

    public abstract void t(int i2, int i3);

    public abstract void x(int i2, long j2);
}
