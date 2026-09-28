package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.Utf8;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.xbill.DNS.WKSRecord;

@CheckReturnValue
/* loaded from: classes3.dex */
abstract class BinaryWriter extends ByteOutput implements Writer {

    /* renamed from: a, reason: collision with root package name */
    public int f3739a;

    /* renamed from: androidx.datastore.preferences.protobuf.BinaryWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3740a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f3740a = iArr;
            try {
                iArr[WireFormat.FieldType.f4201j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3740a[WireFormat.FieldType.f4200i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3740a[WireFormat.FieldType.f4199h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3740a[WireFormat.FieldType.f4198g.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3740a[WireFormat.FieldType.f4196e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3740a[WireFormat.FieldType.q.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3740a[WireFormat.FieldType.r.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3740a[WireFormat.FieldType.s.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3740a[WireFormat.FieldType.t.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3740a[WireFormat.FieldType.f4202k.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3740a[WireFormat.FieldType.o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3740a[WireFormat.FieldType.f4197f.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3740a[WireFormat.FieldType.f4195d.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3740a[WireFormat.FieldType.f4194c.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3740a[WireFormat.FieldType.f4204m.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3740a[WireFormat.FieldType.n.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3740a[WireFormat.FieldType.p.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public static final class SafeDirectWriter extends BinaryWriter {

        /* renamed from: b, reason: collision with root package name */
        public int f3741b;

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void A(int i2, Object obj) {
            int iT = T();
            Protobuf.f4112c.b(obj).h(obj, this);
            int iT2 = T() - iT;
            U(10);
            d0(iT2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void D(int i2, boolean z) {
            U(6);
            this.f3741b--;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void F(int i2) {
            c0(i2, 3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void J(int i2) {
            c0(i2, 4);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void O(int i2, int i3) {
            U(10);
            a0(i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void Q(int i2, byte[] bArr, int i3) {
            int i4 = this.f3741b;
            if (i4 + 1 >= i3) {
                this.f3741b = i4 - i3;
                throw null;
            }
            this.f3739a += i3;
            AllocatedBuffer.b(i2, bArr, i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            int i2 = this.f3741b;
            if (i2 + 1 >= iRemaining) {
                this.f3741b = i2 - iRemaining;
                throw null;
            }
            this.f3739a += iRemaining;
            AllocatedBuffer.a(byteBuffer);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final int T() {
            return (0 - this.f3741b) + this.f3739a;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void U(int i2) {
            if (this.f3741b + 1 >= i2) {
                return;
            }
            Math.max(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void V(boolean z) {
            this.f3741b--;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void W(int i2) {
            this.f3741b -= 4;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void X(long j2) {
            this.f3741b -= 8;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void Y(int i2) {
            if (i2 < 0) {
                e0(i2);
            } else {
                d0(i2);
                throw null;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void a0(int i2) {
            d0(CodedOutputStream.b0(i2));
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void b0(long j2) {
            e0(CodedOutputStream.c0(j2));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void c(int i2, int i3) {
            U(9);
            W(i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void c0(int i2, int i3) {
            d0((i2 << 3) | i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void d0(int i2) {
            if ((i2 & (-128)) == 0) {
                this.f3741b--;
                throw null;
            }
            if ((i2 & (-16384)) == 0) {
                h0(i2);
                throw null;
            }
            if (((-2097152) & i2) == 0) {
                g0(i2);
                throw null;
            }
            if (((-268435456) & i2) == 0) {
                f0(i2);
                throw null;
            }
            this.f3741b--;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void e0(long j2) {
            switch (BinaryWriter.S(j2)) {
                case 1:
                    this.f3741b--;
                    throw null;
                case 2:
                    h0((int) j2);
                    throw null;
                case 3:
                    g0((int) j2);
                    throw null;
                case 4:
                    f0((int) j2);
                    throw null;
                case 5:
                    this.f3741b -= 5;
                    throw null;
                case 6:
                    this.f3741b -= 6;
                    throw null;
                case 7:
                    this.f3741b -= 7;
                    throw null;
                case 8:
                    this.f3741b -= 8;
                    throw null;
                case 9:
                    this.f3741b--;
                    throw null;
                case 10:
                    this.f3741b--;
                    throw null;
                default:
                    return;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void f(int i2, String str) {
            int i3;
            int i4;
            int i5;
            int iT = T();
            U(str.length());
            int length = str.length();
            int i6 = length - 1;
            this.f3741b -= i6;
            if (i6 >= 0 && str.charAt(i6) < 128) {
                throw null;
            }
            if (i6 != -1) {
                this.f3741b += i6;
                while (i6 >= 0) {
                    char cCharAt = str.charAt(i6);
                    if (cCharAt < 128 && (i5 = this.f3741b) >= 0) {
                        this.f3741b = i5 - 1;
                        throw null;
                    }
                    if (cCharAt < 2048 && (i4 = this.f3741b) > 0) {
                        this.f3741b = i4 - 1;
                        throw null;
                    }
                    if ((cCharAt < 55296 || 57343 < cCharAt) && (i3 = this.f3741b) > 1) {
                        this.f3741b = i3 - 1;
                        throw null;
                    }
                    if (this.f3741b > 2) {
                        if (i6 != 0) {
                            char cCharAt2 = str.charAt(length - 2);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt)) {
                                Character.toCodePoint(cCharAt2, cCharAt);
                                this.f3741b--;
                                throw null;
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 2, i6);
                    }
                    U(i6);
                }
            } else {
                this.f3741b--;
            }
            int iT2 = T() - iT;
            U(10);
            d0(iT2);
            throw null;
        }

        public final void f0(int i2) {
            this.f3741b -= 4;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void g(int i2, long j2) {
            U(15);
            e0(j2);
            c0(i2, 0);
            throw null;
        }

        public final void g0(int i2) {
            this.f3741b -= 3;
            throw null;
        }

        public final void h0(int i2) {
            this.f3741b -= 2;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void i(int i2, int i3) {
            U(15);
            Y(i3);
            c0(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void j(int i2, ByteString byteString) {
            try {
                byteString.y(this);
                U(10);
                d0(byteString.size());
                throw null;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void m(int i2, Object obj, Schema schema) {
            int iT = T();
            schema.h(obj, this);
            int iT2 = T() - iT;
            U(10);
            d0(iT2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void p(int i2, long j2) {
            U(15);
            b0(j2);
            c0(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void s(int i2, Object obj, Schema schema) {
            c0(i2, 4);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void t(int i2, int i3) {
            U(10);
            d0(i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void x(int i2, long j2) {
            U(13);
            X(j2);
            throw null;
        }
    }

    public static final class SafeHeapWriter extends BinaryWriter {

        /* renamed from: b, reason: collision with root package name */
        public int f3742b;

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void A(int i2, Object obj) {
            int iT = T();
            Protobuf.f4112c.b(obj).h(obj, this);
            int iT2 = T() - iT;
            U(10);
            d0(iT2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void D(int i2, boolean z) {
            U(6);
            this.f3742b--;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void F(int i2) {
            c0(i2, 3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void J(int i2) {
            c0(i2, 4);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void O(int i2, int i3) {
            U(10);
            a0(i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void Q(int i2, byte[] bArr, int i3) {
            int i4 = this.f3742b;
            if (i4 < i3) {
                this.f3739a += i3;
                AllocatedBuffer.b(i2, bArr, i3);
                throw null;
            }
            int i5 = i4 - i3;
            this.f3742b = i5;
            System.arraycopy(bArr, i2, null, i5 + 1, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            int i2 = this.f3742b;
            if (i2 < iRemaining) {
                this.f3739a += iRemaining;
                AllocatedBuffer.a(byteBuffer);
                throw null;
            }
            int i3 = i2 - iRemaining;
            this.f3742b = i3;
            byteBuffer.get(null, i3 + 1, iRemaining);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final int T() {
            return (0 - this.f3742b) + this.f3739a;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void U(int i2) {
            if (this.f3742b >= i2) {
                return;
            }
            Math.max(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void V(boolean z) {
            this.f3742b--;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void W(int i2) {
            this.f3742b--;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void X(long j2) {
            this.f3742b--;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void Y(int i2) {
            if (i2 < 0) {
                e0(i2);
            } else {
                d0(i2);
                throw null;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void a0(int i2) {
            d0(CodedOutputStream.b0(i2));
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void b0(long j2) {
            e0(CodedOutputStream.c0(j2));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void c(int i2, int i3) {
            U(9);
            W(i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void c0(int i2, int i3) {
            d0((i2 << 3) | i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void d0(int i2) {
            if ((i2 & (-128)) == 0) {
                this.f3742b--;
                throw null;
            }
            if ((i2 & (-16384)) == 0) {
                this.f3742b--;
                throw null;
            }
            if (((-2097152) & i2) == 0) {
                this.f3742b--;
                throw null;
            }
            if ((i2 & (-268435456)) == 0) {
                this.f3742b--;
                throw null;
            }
            this.f3742b--;
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void e0(long j2) {
            switch (BinaryWriter.S(j2)) {
                case 1:
                    this.f3742b--;
                    throw null;
                case 2:
                    this.f3742b--;
                    throw null;
                case 3:
                    this.f3742b--;
                    throw null;
                case 4:
                    this.f3742b--;
                    throw null;
                case 5:
                    this.f3742b--;
                    throw null;
                case 6:
                    this.f3742b--;
                    throw null;
                case 7:
                    this.f3742b--;
                    throw null;
                case 8:
                    this.f3742b--;
                    throw null;
                case 9:
                    this.f3742b--;
                    throw null;
                case 10:
                    this.f3742b--;
                    throw null;
                default:
                    return;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void f(int i2, String str) {
            int i3;
            int i4;
            int i5;
            int iT = T();
            U(str.length());
            int length = str.length();
            int i6 = length - 1;
            this.f3742b -= i6;
            if (i6 >= 0 && str.charAt(i6) < 128) {
                throw null;
            }
            if (i6 != -1) {
                this.f3742b += i6;
                while (i6 >= 0) {
                    char cCharAt = str.charAt(i6);
                    if (cCharAt < 128 && (i5 = this.f3742b) > 0) {
                        this.f3742b = i5 - 1;
                        throw null;
                    }
                    if (cCharAt < 2048 && (i4 = this.f3742b) > 0) {
                        this.f3742b = i4 - 1;
                        throw null;
                    }
                    if ((cCharAt < 55296 || 57343 < cCharAt) && (i3 = this.f3742b) > 1) {
                        this.f3742b = i3 - 1;
                        throw null;
                    }
                    if (this.f3742b > 2) {
                        if (i6 != 0) {
                            char cCharAt2 = str.charAt(length - 2);
                            if (Character.isSurrogatePair(cCharAt2, cCharAt)) {
                                Character.toCodePoint(cCharAt2, cCharAt);
                                this.f3742b--;
                                throw null;
                            }
                        }
                        throw new Utf8.UnpairedSurrogateException(length - 2, i6);
                    }
                    U(i6);
                }
            } else {
                this.f3742b--;
            }
            int iT2 = T() - iT;
            U(10);
            d0(iT2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void g(int i2, long j2) {
            U(15);
            e0(j2);
            c0(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void i(int i2, int i3) {
            U(15);
            Y(i3);
            c0(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void j(int i2, ByteString byteString) {
            try {
                byteString.y(this);
                U(10);
                d0(byteString.size());
                throw null;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void m(int i2, Object obj, Schema schema) {
            int iT = T();
            schema.h(obj, this);
            int iT2 = T() - iT;
            U(10);
            d0(iT2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void p(int i2, long j2) {
            U(15);
            b0(j2);
            c0(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void s(int i2, Object obj, Schema schema) {
            c0(i2, 4);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void t(int i2, int i3) {
            U(10);
            d0(i3);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void x(int i2, long j2) {
            U(13);
            X(j2);
            throw null;
        }
    }

    public static final class UnsafeDirectWriter extends BinaryWriter {

        /* renamed from: b, reason: collision with root package name */
        public long f3743b;

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void A(int i2, Object obj) {
            Protobuf.f4112c.b(obj).h(obj, this);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void D(int i2, boolean z) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void F(int i2) {
            c0(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void J(int i2) {
            c0(i2, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void O(int i2, int i3) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void Q(int i2, byte[] bArr, int i3) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) {
            byteBuffer.remaining();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final int T() {
            return this.f3739a + ((int) (0 - this.f3743b));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void U(int i2) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void V(boolean z) {
            byte b2 = z ? (byte) 1 : (byte) 0;
            long j2 = this.f3743b;
            this.f3743b = j2 - 1;
            UnsafeUtil.l(j2, b2);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void W(int i2) {
            long j2 = this.f3743b;
            this.f3743b = j2 - 1;
            UnsafeUtil.l(j2, (byte) ((i2 >> 24) & 255));
            long j3 = this.f3743b;
            this.f3743b = j3 - 1;
            UnsafeUtil.l(j3, (byte) ((i2 >> 16) & 255));
            long j4 = this.f3743b;
            this.f3743b = j4 - 1;
            UnsafeUtil.l(j4, (byte) ((i2 >> 8) & 255));
            long j5 = this.f3743b;
            this.f3743b = j5 - 1;
            UnsafeUtil.l(j5, (byte) (i2 & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void X(long j2) {
            long j3 = this.f3743b;
            this.f3743b = j3 - 1;
            UnsafeUtil.l(j3, (byte) (((int) (j2 >> 56)) & 255));
            long j4 = this.f3743b;
            this.f3743b = j4 - 1;
            UnsafeUtil.l(j4, (byte) (((int) (j2 >> 48)) & 255));
            long j5 = this.f3743b;
            this.f3743b = j5 - 1;
            UnsafeUtil.l(j5, (byte) (((int) (j2 >> 40)) & 255));
            long j6 = this.f3743b;
            this.f3743b = j6 - 1;
            UnsafeUtil.l(j6, (byte) (((int) (j2 >> 32)) & 255));
            long j7 = this.f3743b;
            this.f3743b = j7 - 1;
            UnsafeUtil.l(j7, (byte) (((int) (j2 >> 24)) & 255));
            long j8 = this.f3743b;
            this.f3743b = j8 - 1;
            UnsafeUtil.l(j8, (byte) (((int) (j2 >> 16)) & 255));
            long j9 = this.f3743b;
            this.f3743b = j9 - 1;
            UnsafeUtil.l(j9, (byte) (((int) (j2 >> 8)) & 255));
            long j10 = this.f3743b;
            this.f3743b = j10 - 1;
            UnsafeUtil.l(j10, (byte) (((int) j2) & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void Y(int i2) {
            if (i2 >= 0) {
                d0(i2);
            } else {
                e0(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void a0(int i2) {
            d0(CodedOutputStream.b0(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void b0(long j2) {
            e0(CodedOutputStream.c0(j2));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void c(int i2, int i3) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void c0(int i2, int i3) {
            d0((i2 << 3) | i3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void d0(int i2) {
            if ((i2 & (-128)) == 0) {
                long j2 = this.f3743b;
                this.f3743b = j2 - 1;
                UnsafeUtil.l(j2, (byte) i2);
                return;
            }
            if ((i2 & (-16384)) == 0) {
                long j3 = this.f3743b;
                this.f3743b = j3 - 1;
                UnsafeUtil.l(j3, (byte) (i2 >>> 7));
                long j4 = this.f3743b;
                this.f3743b = j4 - 1;
                UnsafeUtil.l(j4, (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128));
                return;
            }
            if (((-2097152) & i2) == 0) {
                long j5 = this.f3743b;
                this.f3743b = j5 - 1;
                UnsafeUtil.l(j5, (byte) (i2 >>> 14));
                long j6 = this.f3743b;
                this.f3743b = j6 - 1;
                UnsafeUtil.l(j6, (byte) (((i2 >>> 7) & WKSRecord.Service.LOCUS_CON) | 128));
                long j7 = this.f3743b;
                this.f3743b = j7 - 1;
                UnsafeUtil.l(j7, (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128));
                return;
            }
            if (((-268435456) & i2) == 0) {
                long j8 = this.f3743b;
                this.f3743b = j8 - 1;
                UnsafeUtil.l(j8, (byte) (i2 >>> 21));
                long j9 = this.f3743b;
                this.f3743b = j9 - 1;
                UnsafeUtil.l(j9, (byte) (((i2 >>> 14) & WKSRecord.Service.LOCUS_CON) | 128));
                long j10 = this.f3743b;
                this.f3743b = j10 - 1;
                UnsafeUtil.l(j10, (byte) (((i2 >>> 7) & WKSRecord.Service.LOCUS_CON) | 128));
                long j11 = this.f3743b;
                this.f3743b = j11 - 1;
                UnsafeUtil.l(j11, (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128));
                return;
            }
            long j12 = this.f3743b;
            this.f3743b = j12 - 1;
            UnsafeUtil.l(j12, (byte) (i2 >>> 28));
            long j13 = this.f3743b;
            this.f3743b = j13 - 1;
            UnsafeUtil.l(j13, (byte) (((i2 >>> 21) & WKSRecord.Service.LOCUS_CON) | 128));
            long j14 = this.f3743b;
            this.f3743b = j14 - 1;
            UnsafeUtil.l(j14, (byte) (((i2 >>> 14) & WKSRecord.Service.LOCUS_CON) | 128));
            long j15 = this.f3743b;
            this.f3743b = j15 - 1;
            UnsafeUtil.l(j15, (byte) (((i2 >>> 7) & WKSRecord.Service.LOCUS_CON) | 128));
            long j16 = this.f3743b;
            this.f3743b = j16 - 1;
            UnsafeUtil.l(j16, (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void e0(long j2) {
            switch (BinaryWriter.S(j2)) {
                case 1:
                    long j3 = this.f3743b;
                    this.f3743b = j3 - 1;
                    UnsafeUtil.l(j3, (byte) j2);
                    break;
                case 2:
                    long j4 = this.f3743b;
                    this.f3743b = j4 - 1;
                    UnsafeUtil.l(j4, (byte) (j2 >>> 7));
                    long j5 = this.f3743b;
                    this.f3743b = j5 - 1;
                    UnsafeUtil.l(j5, (byte) ((((int) j2) & WKSRecord.Service.LOCUS_CON) | 128));
                    break;
                case 3:
                    long j6 = this.f3743b;
                    this.f3743b = j6 - 1;
                    UnsafeUtil.l(j6, (byte) (((int) j2) >>> 14));
                    long j7 = this.f3743b;
                    this.f3743b = j7 - 1;
                    UnsafeUtil.l(j7, (byte) (((j2 >>> 7) & 127) | 128));
                    long j8 = this.f3743b;
                    this.f3743b = j8 - 1;
                    UnsafeUtil.l(j8, (byte) ((j2 & 127) | 128));
                    break;
                case 4:
                    long j9 = this.f3743b;
                    this.f3743b = j9 - 1;
                    UnsafeUtil.l(j9, (byte) (j2 >>> 21));
                    long j10 = this.f3743b;
                    this.f3743b = j10 - 1;
                    UnsafeUtil.l(j10, (byte) (((j2 >>> 14) & 127) | 128));
                    long j11 = this.f3743b;
                    this.f3743b = j11 - 1;
                    UnsafeUtil.l(j11, (byte) (((j2 >>> 7) & 127) | 128));
                    long j12 = this.f3743b;
                    this.f3743b = j12 - 1;
                    UnsafeUtil.l(j12, (byte) ((j2 & 127) | 128));
                    break;
                case 5:
                    long j13 = this.f3743b;
                    this.f3743b = j13 - 1;
                    UnsafeUtil.l(j13, (byte) (j2 >>> 28));
                    long j14 = this.f3743b;
                    this.f3743b = j14 - 1;
                    UnsafeUtil.l(j14, (byte) (((j2 >>> 21) & 127) | 128));
                    long j15 = this.f3743b;
                    this.f3743b = j15 - 1;
                    UnsafeUtil.l(j15, (byte) (((j2 >>> 14) & 127) | 128));
                    long j16 = this.f3743b;
                    this.f3743b = j16 - 1;
                    UnsafeUtil.l(j16, (byte) (((j2 >>> 7) & 127) | 128));
                    long j17 = this.f3743b;
                    this.f3743b = j17 - 1;
                    UnsafeUtil.l(j17, (byte) ((j2 & 127) | 128));
                    break;
                case 6:
                    long j18 = this.f3743b;
                    this.f3743b = j18 - 1;
                    UnsafeUtil.l(j18, (byte) (j2 >>> 35));
                    long j19 = this.f3743b;
                    this.f3743b = j19 - 1;
                    UnsafeUtil.l(j19, (byte) (((j2 >>> 28) & 127) | 128));
                    long j20 = this.f3743b;
                    this.f3743b = j20 - 1;
                    UnsafeUtil.l(j20, (byte) (((j2 >>> 21) & 127) | 128));
                    long j21 = this.f3743b;
                    this.f3743b = j21 - 1;
                    UnsafeUtil.l(j21, (byte) (((j2 >>> 14) & 127) | 128));
                    long j22 = this.f3743b;
                    this.f3743b = j22 - 1;
                    UnsafeUtil.l(j22, (byte) (((j2 >>> 7) & 127) | 128));
                    long j23 = this.f3743b;
                    this.f3743b = j23 - 1;
                    UnsafeUtil.l(j23, (byte) ((j2 & 127) | 128));
                    break;
                case 7:
                    long j24 = this.f3743b;
                    this.f3743b = j24 - 1;
                    UnsafeUtil.l(j24, (byte) (j2 >>> 42));
                    long j25 = this.f3743b;
                    this.f3743b = j25 - 1;
                    UnsafeUtil.l(j25, (byte) (((j2 >>> 35) & 127) | 128));
                    long j26 = this.f3743b;
                    this.f3743b = j26 - 1;
                    UnsafeUtil.l(j26, (byte) (((j2 >>> 28) & 127) | 128));
                    long j27 = this.f3743b;
                    this.f3743b = j27 - 1;
                    UnsafeUtil.l(j27, (byte) (((j2 >>> 21) & 127) | 128));
                    long j28 = this.f3743b;
                    this.f3743b = j28 - 1;
                    UnsafeUtil.l(j28, (byte) (((j2 >>> 14) & 127) | 128));
                    long j29 = this.f3743b;
                    this.f3743b = j29 - 1;
                    UnsafeUtil.l(j29, (byte) (((j2 >>> 7) & 127) | 128));
                    long j30 = this.f3743b;
                    this.f3743b = j30 - 1;
                    UnsafeUtil.l(j30, (byte) ((j2 & 127) | 128));
                    break;
                case 8:
                    long j31 = this.f3743b;
                    this.f3743b = j31 - 1;
                    UnsafeUtil.l(j31, (byte) (j2 >>> 49));
                    long j32 = this.f3743b;
                    this.f3743b = j32 - 1;
                    UnsafeUtil.l(j32, (byte) (((j2 >>> 42) & 127) | 128));
                    long j33 = this.f3743b;
                    this.f3743b = j33 - 1;
                    UnsafeUtil.l(j33, (byte) (((j2 >>> 35) & 127) | 128));
                    long j34 = this.f3743b;
                    this.f3743b = j34 - 1;
                    UnsafeUtil.l(j34, (byte) (((j2 >>> 28) & 127) | 128));
                    long j35 = this.f3743b;
                    this.f3743b = j35 - 1;
                    UnsafeUtil.l(j35, (byte) (((j2 >>> 21) & 127) | 128));
                    long j36 = this.f3743b;
                    this.f3743b = j36 - 1;
                    UnsafeUtil.l(j36, (byte) (((j2 >>> 14) & 127) | 128));
                    long j37 = this.f3743b;
                    this.f3743b = j37 - 1;
                    UnsafeUtil.l(j37, (byte) (((j2 >>> 7) & 127) | 128));
                    long j38 = this.f3743b;
                    this.f3743b = j38 - 1;
                    UnsafeUtil.l(j38, (byte) ((j2 & 127) | 128));
                    break;
                case 9:
                    long j39 = this.f3743b;
                    this.f3743b = j39 - 1;
                    UnsafeUtil.l(j39, (byte) (j2 >>> 56));
                    long j40 = this.f3743b;
                    this.f3743b = j40 - 1;
                    UnsafeUtil.l(j40, (byte) (((j2 >>> 49) & 127) | 128));
                    long j41 = this.f3743b;
                    this.f3743b = j41 - 1;
                    UnsafeUtil.l(j41, (byte) (((j2 >>> 42) & 127) | 128));
                    long j42 = this.f3743b;
                    this.f3743b = j42 - 1;
                    UnsafeUtil.l(j42, (byte) (((j2 >>> 35) & 127) | 128));
                    long j43 = this.f3743b;
                    this.f3743b = j43 - 1;
                    UnsafeUtil.l(j43, (byte) (((j2 >>> 28) & 127) | 128));
                    long j44 = this.f3743b;
                    this.f3743b = j44 - 1;
                    UnsafeUtil.l(j44, (byte) (((j2 >>> 21) & 127) | 128));
                    long j45 = this.f3743b;
                    this.f3743b = j45 - 1;
                    UnsafeUtil.l(j45, (byte) (((j2 >>> 14) & 127) | 128));
                    long j46 = this.f3743b;
                    this.f3743b = j46 - 1;
                    UnsafeUtil.l(j46, (byte) (((j2 >>> 7) & 127) | 128));
                    long j47 = this.f3743b;
                    this.f3743b = j47 - 1;
                    UnsafeUtil.l(j47, (byte) ((j2 & 127) | 128));
                    break;
                case 10:
                    long j48 = this.f3743b;
                    this.f3743b = j48 - 1;
                    UnsafeUtil.l(j48, (byte) (j2 >>> 63));
                    long j49 = this.f3743b;
                    this.f3743b = j49 - 1;
                    UnsafeUtil.l(j49, (byte) (((j2 >>> 56) & 127) | 128));
                    long j50 = this.f3743b;
                    this.f3743b = j50 - 1;
                    UnsafeUtil.l(j50, (byte) (((j2 >>> 49) & 127) | 128));
                    long j51 = this.f3743b;
                    this.f3743b = j51 - 1;
                    UnsafeUtil.l(j51, (byte) (((j2 >>> 42) & 127) | 128));
                    long j52 = this.f3743b;
                    this.f3743b = j52 - 1;
                    UnsafeUtil.l(j52, (byte) (((j2 >>> 35) & 127) | 128));
                    long j53 = this.f3743b;
                    this.f3743b = j53 - 1;
                    UnsafeUtil.l(j53, (byte) (((j2 >>> 28) & 127) | 128));
                    long j54 = this.f3743b;
                    this.f3743b = j54 - 1;
                    UnsafeUtil.l(j54, (byte) (((j2 >>> 21) & 127) | 128));
                    long j55 = this.f3743b;
                    this.f3743b = j55 - 1;
                    UnsafeUtil.l(j55, (byte) (((j2 >>> 14) & 127) | 128));
                    long j56 = this.f3743b;
                    this.f3743b = j56 - 1;
                    UnsafeUtil.l(j56, (byte) (((j2 >>> 7) & 127) | 128));
                    long j57 = this.f3743b;
                    this.f3743b = j57 - 1;
                    UnsafeUtil.l(j57, (byte) ((j2 & 127) | 128));
                    break;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void f(int i2, String str) {
            str.length();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void g(int i2, long j2) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void i(int i2, int i3) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void j(int i2, ByteString byteString) {
            try {
                byteString.y(this);
                throw null;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void m(int i2, Object obj, Schema schema) {
            schema.h(obj, this);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void p(int i2, long j2) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void s(int i2, Object obj, Schema schema) {
            c0(i2, 4);
            schema.h(obj, this);
            c0(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void t(int i2, int i3) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void x(int i2, long j2) {
            throw null;
        }
    }

    public static final class UnsafeHeapWriter extends BinaryWriter {

        /* renamed from: b, reason: collision with root package name */
        public long f3744b;

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void A(int i2, Object obj) {
            int iT = T();
            Protobuf.f4112c.b(obj).h(obj, this);
            int iT2 = T() - iT;
            U(10);
            d0(iT2);
            c0(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void D(int i2, boolean z) {
            U(6);
            byte b2 = z ? (byte) 1 : (byte) 0;
            long j2 = this.f3744b;
            this.f3744b = j2 - 1;
            UnsafeUtil.m(null, j2, b2);
            c0(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void F(int i2) {
            c0(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void J(int i2) {
            c0(i2, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void O(int i2, int i3) {
            U(10);
            a0(i3);
            c0(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void Q(int i2, byte[] bArr, int i3) {
            if (i2 < 0 || i2 + i3 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
            }
            long j2 = this.f3744b;
            if (((int) j2) < i3) {
                this.f3739a += i3;
                AllocatedBuffer.b(i2, bArr, i3);
                throw null;
            }
            long j3 = j2 - i3;
            this.f3744b = j3;
            System.arraycopy(bArr, i2, null, ((int) j3) + 1, i3);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteOutput
        public final void R(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            long j2 = this.f3744b;
            if (((int) j2) < iRemaining) {
                this.f3739a += iRemaining;
                AllocatedBuffer.a(byteBuffer);
                throw null;
            }
            long j3 = j2 - iRemaining;
            this.f3744b = j3;
            byteBuffer.get(null, ((int) j3) + 1, iRemaining);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final int T() {
            return this.f3739a + ((int) (0 - this.f3744b));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void U(int i2) {
            if (((int) this.f3744b) >= i2) {
                return;
            }
            Math.max(i2, 0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void V(boolean z) {
            byte b2 = z ? (byte) 1 : (byte) 0;
            long j2 = this.f3744b;
            this.f3744b = j2 - 1;
            UnsafeUtil.m(null, j2, b2);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void W(int i2) {
            long j2 = this.f3744b;
            this.f3744b = j2 - 1;
            UnsafeUtil.m(null, j2, (byte) ((i2 >> 24) & 255));
            long j3 = this.f3744b;
            this.f3744b = j3 - 1;
            UnsafeUtil.m(null, j3, (byte) ((i2 >> 16) & 255));
            long j4 = this.f3744b;
            this.f3744b = j4 - 1;
            UnsafeUtil.m(null, j4, (byte) ((i2 >> 8) & 255));
            long j5 = this.f3744b;
            this.f3744b = j5 - 1;
            UnsafeUtil.m(null, j5, (byte) (i2 & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void X(long j2) {
            long j3 = this.f3744b;
            this.f3744b = j3 - 1;
            UnsafeUtil.m(null, j3, (byte) (((int) (j2 >> 56)) & 255));
            long j4 = this.f3744b;
            this.f3744b = j4 - 1;
            UnsafeUtil.m(null, j4, (byte) (((int) (j2 >> 48)) & 255));
            long j5 = this.f3744b;
            this.f3744b = j5 - 1;
            UnsafeUtil.m(null, j5, (byte) (((int) (j2 >> 40)) & 255));
            long j6 = this.f3744b;
            this.f3744b = j6 - 1;
            UnsafeUtil.m(null, j6, (byte) (((int) (j2 >> 32)) & 255));
            long j7 = this.f3744b;
            this.f3744b = j7 - 1;
            UnsafeUtil.m(null, j7, (byte) (((int) (j2 >> 24)) & 255));
            long j8 = this.f3744b;
            this.f3744b = j8 - 1;
            UnsafeUtil.m(null, j8, (byte) (((int) (j2 >> 16)) & 255));
            long j9 = this.f3744b;
            this.f3744b = j9 - 1;
            UnsafeUtil.m(null, j9, (byte) (((int) (j2 >> 8)) & 255));
            long j10 = this.f3744b;
            this.f3744b = j10 - 1;
            UnsafeUtil.m(null, j10, (byte) (((int) j2) & 255));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void Y(int i2) {
            if (i2 >= 0) {
                d0(i2);
            } else {
                e0(i2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void a0(int i2) {
            d0(CodedOutputStream.b0(i2));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void b0(long j2) {
            e0(CodedOutputStream.c0(j2));
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void c(int i2, int i3) {
            U(9);
            W(i3);
            c0(i2, 5);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void c0(int i2, int i3) {
            d0((i2 << 3) | i3);
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void d0(int i2) {
            if ((i2 & (-128)) == 0) {
                long j2 = this.f3744b;
                this.f3744b = j2 - 1;
                UnsafeUtil.m(null, j2, (byte) i2);
                return;
            }
            if ((i2 & (-16384)) == 0) {
                long j3 = this.f3744b;
                this.f3744b = j3 - 1;
                UnsafeUtil.m(null, j3, (byte) (i2 >>> 7));
                long j4 = this.f3744b;
                this.f3744b = j4 - 1;
                UnsafeUtil.m(null, j4, (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128));
                return;
            }
            if (((-2097152) & i2) == 0) {
                long j5 = this.f3744b;
                this.f3744b = j5 - 1;
                UnsafeUtil.m(null, j5, (byte) (i2 >>> 14));
                long j6 = this.f3744b;
                this.f3744b = j6 - 1;
                UnsafeUtil.m(null, j6, (byte) (((i2 >>> 7) & WKSRecord.Service.LOCUS_CON) | 128));
                long j7 = this.f3744b;
                this.f3744b = j7 - 1;
                UnsafeUtil.m(null, j7, (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128));
                return;
            }
            if (((-268435456) & i2) == 0) {
                long j8 = this.f3744b;
                this.f3744b = j8 - 1;
                UnsafeUtil.m(null, j8, (byte) (i2 >>> 21));
                long j9 = this.f3744b;
                this.f3744b = j9 - 1;
                UnsafeUtil.m(null, j9, (byte) (((i2 >>> 14) & WKSRecord.Service.LOCUS_CON) | 128));
                long j10 = this.f3744b;
                this.f3744b = j10 - 1;
                UnsafeUtil.m(null, j10, (byte) (((i2 >>> 7) & WKSRecord.Service.LOCUS_CON) | 128));
                long j11 = this.f3744b;
                this.f3744b = j11 - 1;
                UnsafeUtil.m(null, j11, (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128));
                return;
            }
            long j12 = this.f3744b;
            this.f3744b = j12 - 1;
            UnsafeUtil.m(null, j12, (byte) (i2 >>> 28));
            long j13 = this.f3744b;
            this.f3744b = j13 - 1;
            UnsafeUtil.m(null, j13, (byte) (((i2 >>> 21) & WKSRecord.Service.LOCUS_CON) | 128));
            long j14 = this.f3744b;
            this.f3744b = j14 - 1;
            UnsafeUtil.m(null, j14, (byte) (((i2 >>> 14) & WKSRecord.Service.LOCUS_CON) | 128));
            long j15 = this.f3744b;
            this.f3744b = j15 - 1;
            UnsafeUtil.m(null, j15, (byte) (((i2 >>> 7) & WKSRecord.Service.LOCUS_CON) | 128));
            long j16 = this.f3744b;
            this.f3744b = j16 - 1;
            UnsafeUtil.m(null, j16, (byte) ((i2 & WKSRecord.Service.LOCUS_CON) | 128));
        }

        @Override // androidx.datastore.preferences.protobuf.BinaryWriter
        public final void e0(long j2) {
            switch (BinaryWriter.S(j2)) {
                case 1:
                    long j3 = this.f3744b;
                    this.f3744b = j3 - 1;
                    UnsafeUtil.m(null, j3, (byte) j2);
                    break;
                case 2:
                    long j4 = this.f3744b;
                    this.f3744b = j4 - 1;
                    UnsafeUtil.m(null, j4, (byte) (j2 >>> 7));
                    long j5 = this.f3744b;
                    this.f3744b = j5 - 1;
                    UnsafeUtil.m(null, j5, (byte) ((((int) j2) & WKSRecord.Service.LOCUS_CON) | 128));
                    break;
                case 3:
                    long j6 = this.f3744b;
                    this.f3744b = j6 - 1;
                    UnsafeUtil.m(null, j6, (byte) (((int) j2) >>> 14));
                    long j7 = this.f3744b;
                    this.f3744b = j7 - 1;
                    UnsafeUtil.m(null, j7, (byte) (((j2 >>> 7) & 127) | 128));
                    long j8 = this.f3744b;
                    this.f3744b = j8 - 1;
                    UnsafeUtil.m(null, j8, (byte) ((j2 & 127) | 128));
                    break;
                case 4:
                    long j9 = this.f3744b;
                    this.f3744b = j9 - 1;
                    UnsafeUtil.m(null, j9, (byte) (j2 >>> 21));
                    long j10 = this.f3744b;
                    this.f3744b = j10 - 1;
                    UnsafeUtil.m(null, j10, (byte) (((j2 >>> 14) & 127) | 128));
                    long j11 = this.f3744b;
                    this.f3744b = j11 - 1;
                    UnsafeUtil.m(null, j11, (byte) (((j2 >>> 7) & 127) | 128));
                    long j12 = this.f3744b;
                    this.f3744b = j12 - 1;
                    UnsafeUtil.m(null, j12, (byte) ((j2 & 127) | 128));
                    break;
                case 5:
                    long j13 = this.f3744b;
                    this.f3744b = j13 - 1;
                    UnsafeUtil.m(null, j13, (byte) (j2 >>> 28));
                    long j14 = this.f3744b;
                    this.f3744b = j14 - 1;
                    UnsafeUtil.m(null, j14, (byte) (((j2 >>> 21) & 127) | 128));
                    long j15 = this.f3744b;
                    this.f3744b = j15 - 1;
                    UnsafeUtil.m(null, j15, (byte) (((j2 >>> 14) & 127) | 128));
                    long j16 = this.f3744b;
                    this.f3744b = j16 - 1;
                    UnsafeUtil.m(null, j16, (byte) (((j2 >>> 7) & 127) | 128));
                    long j17 = this.f3744b;
                    this.f3744b = j17 - 1;
                    UnsafeUtil.m(null, j17, (byte) ((j2 & 127) | 128));
                    break;
                case 6:
                    long j18 = this.f3744b;
                    this.f3744b = j18 - 1;
                    UnsafeUtil.m(null, j18, (byte) (j2 >>> 35));
                    long j19 = this.f3744b;
                    this.f3744b = j19 - 1;
                    UnsafeUtil.m(null, j19, (byte) (((j2 >>> 28) & 127) | 128));
                    long j20 = this.f3744b;
                    this.f3744b = j20 - 1;
                    UnsafeUtil.m(null, j20, (byte) (((j2 >>> 21) & 127) | 128));
                    long j21 = this.f3744b;
                    this.f3744b = j21 - 1;
                    UnsafeUtil.m(null, j21, (byte) (((j2 >>> 14) & 127) | 128));
                    long j22 = this.f3744b;
                    this.f3744b = j22 - 1;
                    UnsafeUtil.m(null, j22, (byte) (((j2 >>> 7) & 127) | 128));
                    long j23 = this.f3744b;
                    this.f3744b = j23 - 1;
                    UnsafeUtil.m(null, j23, (byte) ((j2 & 127) | 128));
                    break;
                case 7:
                    long j24 = this.f3744b;
                    this.f3744b = j24 - 1;
                    UnsafeUtil.m(null, j24, (byte) (j2 >>> 42));
                    long j25 = this.f3744b;
                    this.f3744b = j25 - 1;
                    UnsafeUtil.m(null, j25, (byte) (((j2 >>> 35) & 127) | 128));
                    long j26 = this.f3744b;
                    this.f3744b = j26 - 1;
                    UnsafeUtil.m(null, j26, (byte) (((j2 >>> 28) & 127) | 128));
                    long j27 = this.f3744b;
                    this.f3744b = j27 - 1;
                    UnsafeUtil.m(null, j27, (byte) (((j2 >>> 21) & 127) | 128));
                    long j28 = this.f3744b;
                    this.f3744b = j28 - 1;
                    UnsafeUtil.m(null, j28, (byte) (((j2 >>> 14) & 127) | 128));
                    long j29 = this.f3744b;
                    this.f3744b = j29 - 1;
                    UnsafeUtil.m(null, j29, (byte) (((j2 >>> 7) & 127) | 128));
                    long j30 = this.f3744b;
                    this.f3744b = j30 - 1;
                    UnsafeUtil.m(null, j30, (byte) ((j2 & 127) | 128));
                    break;
                case 8:
                    long j31 = this.f3744b;
                    this.f3744b = j31 - 1;
                    UnsafeUtil.m(null, j31, (byte) (j2 >>> 49));
                    long j32 = this.f3744b;
                    this.f3744b = j32 - 1;
                    UnsafeUtil.m(null, j32, (byte) (((j2 >>> 42) & 127) | 128));
                    long j33 = this.f3744b;
                    this.f3744b = j33 - 1;
                    UnsafeUtil.m(null, j33, (byte) (((j2 >>> 35) & 127) | 128));
                    long j34 = this.f3744b;
                    this.f3744b = j34 - 1;
                    UnsafeUtil.m(null, j34, (byte) (((j2 >>> 28) & 127) | 128));
                    long j35 = this.f3744b;
                    this.f3744b = j35 - 1;
                    UnsafeUtil.m(null, j35, (byte) (((j2 >>> 21) & 127) | 128));
                    long j36 = this.f3744b;
                    this.f3744b = j36 - 1;
                    UnsafeUtil.m(null, j36, (byte) (((j2 >>> 14) & 127) | 128));
                    long j37 = this.f3744b;
                    this.f3744b = j37 - 1;
                    UnsafeUtil.m(null, j37, (byte) (((j2 >>> 7) & 127) | 128));
                    long j38 = this.f3744b;
                    this.f3744b = j38 - 1;
                    UnsafeUtil.m(null, j38, (byte) ((j2 & 127) | 128));
                    break;
                case 9:
                    long j39 = this.f3744b;
                    this.f3744b = j39 - 1;
                    UnsafeUtil.m(null, j39, (byte) (j2 >>> 56));
                    long j40 = this.f3744b;
                    this.f3744b = j40 - 1;
                    UnsafeUtil.m(null, j40, (byte) (((j2 >>> 49) & 127) | 128));
                    long j41 = this.f3744b;
                    this.f3744b = j41 - 1;
                    UnsafeUtil.m(null, j41, (byte) (((j2 >>> 42) & 127) | 128));
                    long j42 = this.f3744b;
                    this.f3744b = j42 - 1;
                    UnsafeUtil.m(null, j42, (byte) (((j2 >>> 35) & 127) | 128));
                    long j43 = this.f3744b;
                    this.f3744b = j43 - 1;
                    UnsafeUtil.m(null, j43, (byte) (((j2 >>> 28) & 127) | 128));
                    long j44 = this.f3744b;
                    this.f3744b = j44 - 1;
                    UnsafeUtil.m(null, j44, (byte) (((j2 >>> 21) & 127) | 128));
                    long j45 = this.f3744b;
                    this.f3744b = j45 - 1;
                    UnsafeUtil.m(null, j45, (byte) (((j2 >>> 14) & 127) | 128));
                    long j46 = this.f3744b;
                    this.f3744b = j46 - 1;
                    UnsafeUtil.m(null, j46, (byte) (((j2 >>> 7) & 127) | 128));
                    long j47 = this.f3744b;
                    this.f3744b = j47 - 1;
                    UnsafeUtil.m(null, j47, (byte) ((j2 & 127) | 128));
                    break;
                case 10:
                    long j48 = this.f3744b;
                    this.f3744b = j48 - 1;
                    UnsafeUtil.m(null, j48, (byte) (j2 >>> 63));
                    long j49 = this.f3744b;
                    this.f3744b = j49 - 1;
                    UnsafeUtil.m(null, j49, (byte) (((j2 >>> 56) & 127) | 128));
                    long j50 = this.f3744b;
                    this.f3744b = j50 - 1;
                    UnsafeUtil.m(null, j50, (byte) (((j2 >>> 49) & 127) | 128));
                    long j51 = this.f3744b;
                    this.f3744b = j51 - 1;
                    UnsafeUtil.m(null, j51, (byte) (((j2 >>> 42) & 127) | 128));
                    long j52 = this.f3744b;
                    this.f3744b = j52 - 1;
                    UnsafeUtil.m(null, j52, (byte) (((j2 >>> 35) & 127) | 128));
                    long j53 = this.f3744b;
                    this.f3744b = j53 - 1;
                    UnsafeUtil.m(null, j53, (byte) (((j2 >>> 28) & 127) | 128));
                    long j54 = this.f3744b;
                    this.f3744b = j54 - 1;
                    UnsafeUtil.m(null, j54, (byte) (((j2 >>> 21) & 127) | 128));
                    long j55 = this.f3744b;
                    this.f3744b = j55 - 1;
                    UnsafeUtil.m(null, j55, (byte) (((j2 >>> 14) & 127) | 128));
                    long j56 = this.f3744b;
                    this.f3744b = j56 - 1;
                    UnsafeUtil.m(null, j56, (byte) (((j2 >>> 7) & 127) | 128));
                    long j57 = this.f3744b;
                    this.f3744b = j57 - 1;
                    UnsafeUtil.m(null, j57, (byte) ((j2 & 127) | 128));
                    break;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        @Override // androidx.datastore.preferences.protobuf.Writer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void f(int r14, java.lang.String r15) {
            /*
                Method dump skipped, instructions count: 288
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.BinaryWriter.UnsafeHeapWriter.f(int, java.lang.String):void");
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void g(int i2, long j2) {
            U(15);
            e0(j2);
            c0(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void i(int i2, int i3) {
            U(15);
            Y(i3);
            c0(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void j(int i2, ByteString byteString) {
            try {
                byteString.y(this);
                U(10);
                d0(byteString.size());
                c0(i2, 2);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void m(int i2, Object obj, Schema schema) {
            int iT = T();
            schema.h(obj, this);
            int iT2 = T() - iT;
            U(10);
            d0(iT2);
            c0(i2, 2);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void p(int i2, long j2) {
            U(15);
            b0(j2);
            c0(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void s(int i2, Object obj, Schema schema) {
            c0(i2, 4);
            schema.h(obj, this);
            c0(i2, 3);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void t(int i2, int i3) {
            U(10);
            d0(i3);
            c0(i2, 0);
        }

        @Override // androidx.datastore.preferences.protobuf.Writer
        public final void x(int i2, long j2) {
            U(13);
            X(j2);
            c0(i2, 1);
        }
    }

    public static byte S(long j2) {
        byte b2;
        if (((-128) & j2) == 0) {
            return (byte) 1;
        }
        if (j2 < 0) {
            return (byte) 10;
        }
        if (((-34359738368L) & j2) != 0) {
            b2 = (byte) 6;
            j2 >>>= 28;
        } else {
            b2 = 2;
        }
        if (((-2097152) & j2) != 0) {
            b2 = (byte) (b2 + 2);
            j2 >>>= 14;
        }
        return (j2 & (-16384)) != 0 ? (byte) (b2 + 1) : b2;
    }

    public static final void Z(BinaryWriter binaryWriter, int i2, WireFormat.FieldType fieldType, Object obj) {
        switch (fieldType.ordinal()) {
            case 0:
                binaryWriter.u(i2, ((Double) obj).doubleValue());
                return;
            case 1:
                binaryWriter.B(((Float) obj).floatValue(), i2);
                return;
            case 2:
                binaryWriter.g(i2, ((Long) obj).longValue());
                return;
            case 3:
                binaryWriter.g(i2, ((Long) obj).longValue());
                return;
            case 4:
                binaryWriter.i(i2, ((Integer) obj).intValue());
                return;
            case 5:
                binaryWriter.x(i2, ((Long) obj).longValue());
                return;
            case 6:
                binaryWriter.c(i2, ((Integer) obj).intValue());
                return;
            case 7:
                binaryWriter.D(i2, ((Boolean) obj).booleanValue());
                return;
            case 8:
                binaryWriter.f(i2, (String) obj);
                return;
            case 9:
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
            case 10:
                binaryWriter.A(i2, obj);
                return;
            case 11:
                binaryWriter.j(i2, (ByteString) obj);
                return;
            case 12:
                binaryWriter.t(i2, ((Integer) obj).intValue());
                return;
            case 13:
                if (obj instanceof Internal.EnumLite) {
                    binaryWriter.i(i2, ((Internal.EnumLite) obj).f());
                    return;
                } else {
                    if (!(obj instanceof Integer)) {
                        throw new IllegalArgumentException("Unexpected type for enum in map.");
                    }
                    binaryWriter.i(i2, ((Integer) obj).intValue());
                    return;
                }
            case 14:
                binaryWriter.c(i2, ((Integer) obj).intValue());
                return;
            case 15:
                binaryWriter.x(i2, ((Long) obj).longValue());
                return;
            case 16:
                binaryWriter.O(i2, ((Integer) obj).intValue());
                return;
            case 17:
                binaryWriter.p(i2, ((Long) obj).longValue());
                return;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void B(float f2, int i2) {
        c(i2, Float.floatToRawIntBits(f2));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void C(int i2, long j2) {
        g(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void E(int i2, int i3) {
        c(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void G(int i2, List list, boolean z) {
        if (!(list instanceof LongArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    x(i2, ((Long) list.get(size)).longValue());
                }
                return;
            }
            U((list.size() * 8) + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                X(((Long) list.get(size2)).longValue());
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        if (!z) {
            for (int i3 = longArrayList.f4067c - 1; i3 >= 0; i3--) {
                x(i2, longArrayList.g(i3));
            }
            return;
        }
        U((longArrayList.f4067c * 8) + 10);
        int iT2 = T();
        for (int i4 = longArrayList.f4067c - 1; i4 >= 0; i4--) {
            X(longArrayList.g(i4));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void H(int i2, List list, boolean z) {
        l(i2, list, z);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void I(int i2, List list, boolean z) {
        if (!(list instanceof BooleanArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    D(i2, ((Boolean) list.get(size)).booleanValue());
                }
                return;
            }
            U(list.size() + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                V(((Boolean) list.get(size2)).booleanValue());
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        if (!z) {
            for (int i3 = booleanArrayList.f3747c - 1; i3 >= 0; i3--) {
                D(i2, booleanArrayList.getBoolean(i3));
            }
            return;
        }
        U(booleanArrayList.f3747c + 10);
        int iT2 = T();
        for (int i4 = booleanArrayList.f3747c - 1; i4 >= 0; i4--) {
            V(booleanArrayList.getBoolean(i4));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void K(int i2, List list, boolean z) {
        if (!(list instanceof IntArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    O(i2, ((Integer) list.get(size)).intValue());
                }
                return;
            }
            U((list.size() * 5) + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                a0(((Integer) list.get(size2)).intValue());
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            for (int i3 = intArrayList.f4023c - 1; i3 >= 0; i3--) {
                O(i2, intArrayList.getInt(i3));
            }
            return;
        }
        U((intArrayList.f4023c * 5) + 10);
        int iT2 = T();
        for (int i4 = intArrayList.f4023c - 1; i4 >= 0; i4--) {
            a0(intArrayList.getInt(i4));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void L(int i2, int i3) {
        i(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void M(int i2, List list, boolean z) {
        w(i2, list, z);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void N(int i2, List list, boolean z) {
        if (!(list instanceof DoubleArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    u(i2, ((Double) list.get(size)).doubleValue());
                }
                return;
            }
            U((list.size() * 8) + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                X(Double.doubleToRawLongBits(((Double) list.get(size2)).doubleValue()));
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        if (!z) {
            for (int i3 = doubleArrayList.f3941c - 1; i3 >= 0; i3--) {
                u(i2, doubleArrayList.getDouble(i3));
            }
            return;
        }
        U((doubleArrayList.f3941c * 8) + 10);
        int iT2 = T();
        for (int i4 = doubleArrayList.f3941c - 1; i4 >= 0; i4--) {
            X(Double.doubleToRawLongBits(doubleArrayList.getDouble(i4)));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void P(int i2, List list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            j(i2, (ByteString) list.get(size));
        }
    }

    public abstract int T();

    public abstract void U(int i2);

    public abstract void V(boolean z);

    public abstract void W(int i2);

    public abstract void X(long j2);

    public abstract void Y(int i2);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void a(int i2, List list, boolean z) {
        if (!(list instanceof FloatArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    B(((Float) list.get(size)).floatValue(), i2);
                }
                return;
            }
            U((list.size() * 4) + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                W(Float.floatToRawIntBits(((Float) list.get(size2)).floatValue()));
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        FloatArrayList floatArrayList = (FloatArrayList) list;
        if (!z) {
            for (int i3 = floatArrayList.f4003c - 1; i3 >= 0; i3--) {
                B(floatArrayList.g(i3), i2);
            }
            return;
        }
        U((floatArrayList.f4003c * 4) + 10);
        int iT2 = T();
        for (int i4 = floatArrayList.f4003c - 1; i4 >= 0; i4--) {
            W(Float.floatToRawIntBits(floatArrayList.g(i4)));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    public abstract void a0(int i2);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void b(int i2, Object obj) {
        c0(1, 4);
        if (obj instanceof ByteString) {
            j(3, (ByteString) obj);
        } else {
            A(3, obj);
        }
        t(2, i2);
        c0(1, 3);
    }

    public abstract void b0(long j2);

    public abstract void c0(int i2, int i3);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void d(int i2, List list) {
        if (!(list instanceof LazyStringList)) {
            for (int size = list.size() - 1; size >= 0; size--) {
                f(i2, (String) list.get(size));
            }
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            Object objJ1 = lazyStringList.J1(size2);
            if (objJ1 instanceof String) {
                f(i2, (String) objJ1);
            } else {
                j(i2, (ByteString) objJ1);
            }
        }
    }

    public abstract void d0(int i2);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void e(int i2, List list, Schema schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            s(i2, list.get(size), schema);
        }
    }

    public abstract void e0(long j2);

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void h(int i2, List list, boolean z) {
        if (!(list instanceof IntArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    i(i2, ((Integer) list.get(size)).intValue());
                }
                return;
            }
            U((list.size() * 10) + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                Y(((Integer) list.get(size2)).intValue());
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            for (int i3 = intArrayList.f4023c - 1; i3 >= 0; i3--) {
                i(i2, intArrayList.getInt(i3));
            }
            return;
        }
        U((intArrayList.f4023c * 10) + 10);
        int iT2 = T();
        for (int i4 = intArrayList.f4023c - 1; i4 >= 0; i4--) {
            Y(intArrayList.getInt(i4));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void k(int i2, long j2) {
        x(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void l(int i2, List list, boolean z) {
        if (!(list instanceof IntArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    c(i2, ((Integer) list.get(size)).intValue());
                }
                return;
            }
            U((list.size() * 4) + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                W(((Integer) list.get(size2)).intValue());
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            for (int i3 = intArrayList.f4023c - 1; i3 >= 0; i3--) {
                c(i2, intArrayList.getInt(i3));
            }
            return;
        }
        U((intArrayList.f4023c * 4) + 10);
        int iT2 = T();
        for (int i4 = intArrayList.f4023c - 1; i4 >= 0; i4--) {
            W(intArrayList.getInt(i4));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void n(int i2, List list, boolean z) {
        if (!(list instanceof IntArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    t(i2, ((Integer) list.get(size)).intValue());
                }
                return;
            }
            U((list.size() * 5) + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                d0(((Integer) list.get(size2)).intValue());
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            for (int i3 = intArrayList.f4023c - 1; i3 >= 0; i3--) {
                t(i2, intArrayList.getInt(i3));
            }
            return;
        }
        U((intArrayList.f4023c * 5) + 10);
        int iT2 = T();
        for (int i4 = intArrayList.f4023c - 1; i4 >= 0; i4--) {
            d0(intArrayList.getInt(i4));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void o(int i2, List list, boolean z) {
        if (!(list instanceof LongArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    p(i2, ((Long) list.get(size)).longValue());
                }
                return;
            }
            U((list.size() * 10) + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                b0(((Long) list.get(size2)).longValue());
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        if (!z) {
            for (int i3 = longArrayList.f4067c - 1; i3 >= 0; i3--) {
                p(i2, longArrayList.g(i3));
            }
            return;
        }
        U((longArrayList.f4067c * 10) + 10);
        int iT2 = T();
        for (int i4 = longArrayList.f4067c - 1; i4 >= 0; i4--) {
            b0(longArrayList.g(i4));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void q(int i2, List list, boolean z) {
        h(i2, list, z);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void r(int i2, MapEntryLite.Metadata metadata, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            int iT = T();
            Z(this, 2, metadata.f4074b, entry.getValue());
            Z(this, 1, metadata.f4073a, entry.getKey());
            d0(T() - iT);
            c0(i2, 2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void u(int i2, double d2) {
        x(i2, Double.doubleToRawLongBits(d2));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void v(int i2, List list, boolean z) {
        G(i2, list, z);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void w(int i2, List list, boolean z) {
        if (!(list instanceof LongArrayList)) {
            if (!z) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    g(i2, ((Long) list.get(size)).longValue());
                }
                return;
            }
            U((list.size() * 10) + 10);
            int iT = T();
            for (int size2 = list.size() - 1; size2 >= 0; size2--) {
                e0(((Long) list.get(size2)).longValue());
            }
            d0(T() - iT);
            c0(i2, 2);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        if (!z) {
            for (int i3 = longArrayList.f4067c - 1; i3 >= 0; i3--) {
                g(i2, longArrayList.g(i3));
            }
            return;
        }
        U((longArrayList.f4067c * 10) + 10);
        int iT2 = T();
        for (int i4 = longArrayList.f4067c - 1; i4 >= 0; i4--) {
            e0(longArrayList.g(i4));
        }
        d0(T() - iT2);
        c0(i2, 2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final Writer.FieldOrder y() {
        return Writer.FieldOrder.f4220b;
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void z(int i2, List list, Schema schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            m(i2, list.get(size), schema);
        }
    }
}
