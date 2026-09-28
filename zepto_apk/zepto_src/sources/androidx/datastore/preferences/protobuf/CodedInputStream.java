package androidx.datastore.preferences.protobuf;

import android.support.v4.media.b;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.UnsafeUtil;
import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class CodedInputStream {

    /* renamed from: a, reason: collision with root package name */
    public int f3761a;

    /* renamed from: b, reason: collision with root package name */
    public CodedInputStreamReader f3762b;

    public static final class ArrayDecoder extends CodedInputStream {

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f3763c;

        /* renamed from: d, reason: collision with root package name */
        public int f3764d;

        /* renamed from: e, reason: collision with root package name */
        public int f3765e;

        /* renamed from: f, reason: collision with root package name */
        public int f3766f;

        /* renamed from: g, reason: collision with root package name */
        public final int f3767g;

        /* renamed from: h, reason: collision with root package name */
        public int f3768h;

        /* renamed from: i, reason: collision with root package name */
        public int f3769i = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        public ArrayDecoder(byte[] bArr, int i2, int i3, boolean z) {
            this.f3763c = bArr;
            this.f3764d = i3 + i2;
            this.f3766f = i2;
            this.f3767g = i2;
        }

        public final int B() throws InvalidProtocolBufferException {
            int i2 = this.f3766f;
            if (this.f3764d - i2 < 4) {
                throw InvalidProtocolBufferException.g();
            }
            this.f3766f = i2 + 4;
            byte[] bArr = this.f3763c;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public final long C() throws InvalidProtocolBufferException {
            int i2 = this.f3766f;
            if (this.f3764d - i2 < 8) {
                throw InvalidProtocolBufferException.g();
            }
            this.f3766f = i2 + 8;
            byte[] bArr = this.f3763c;
            return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
        }

        public final int D() {
            int i2;
            int i3 = this.f3766f;
            int i4 = this.f3764d;
            if (i4 != i3) {
                int i5 = i3 + 1;
                byte[] bArr = this.f3763c;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.f3766f = i5;
                    return b2;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i3 + 2;
                    int i7 = (bArr[i5] << 7) ^ b2;
                    if (i7 < 0) {
                        i2 = i7 ^ (-128);
                    } else {
                        int i8 = i3 + 3;
                        int i9 = (bArr[i6] << 14) ^ i7;
                        if (i9 >= 0) {
                            i2 = i9 ^ 16256;
                        } else {
                            int i10 = i3 + 4;
                            int i11 = i9 ^ (bArr[i8] << 21);
                            if (i11 < 0) {
                                i2 = (-2080896) ^ i11;
                            } else {
                                i8 = i3 + 5;
                                byte b3 = bArr[i10];
                                int i12 = (i11 ^ (b3 << 28)) ^ 266354560;
                                if (b3 < 0) {
                                    i10 = i3 + 6;
                                    if (bArr[i8] < 0) {
                                        i8 = i3 + 7;
                                        if (bArr[i10] < 0) {
                                            i10 = i3 + 8;
                                            if (bArr[i8] < 0) {
                                                i8 = i3 + 9;
                                                if (bArr[i10] < 0) {
                                                    int i13 = i3 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i6 = i13;
                                                        i2 = i12;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i2 = i12;
                                }
                                i2 = i12;
                            }
                            i6 = i10;
                        }
                        i6 = i8;
                    }
                    this.f3766f = i6;
                    return i2;
                }
            }
            return (int) F();
        }

        public final long E() {
            long j2;
            long j3;
            long j4;
            long j5;
            int i2 = this.f3766f;
            int i3 = this.f3764d;
            if (i3 != i2) {
                int i4 = i2 + 1;
                byte[] bArr = this.f3763c;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.f3766f = i4;
                    return b2;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b2;
                    if (i6 < 0) {
                        j2 = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            j2 = i8 ^ 16256;
                            i5 = i7;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                j5 = (-2080896) ^ i10;
                            } else {
                                long j6 = i10;
                                i5 = i2 + 5;
                                long j7 = j6 ^ (bArr[i9] << 28);
                                if (j7 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    i9 = i2 + 6;
                                    long j8 = j7 ^ (bArr[i5] << 35);
                                    if (j8 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i5 = i2 + 7;
                                        j7 = j8 ^ (bArr[i9] << 42);
                                        if (j7 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i9 = i2 + 8;
                                            j8 = j7 ^ (bArr[i5] << 49);
                                            if (j8 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i5 = i2 + 9;
                                                long j9 = (j8 ^ (bArr[i9] << 56)) ^ 71499008037633920L;
                                                if (j9 < 0) {
                                                    int i11 = i2 + 10;
                                                    if (bArr[i5] >= 0) {
                                                        i5 = i11;
                                                    }
                                                }
                                                j2 = j9;
                                            }
                                        }
                                    }
                                    j5 = j3 ^ j8;
                                }
                                j2 = j4 ^ j7;
                            }
                            i5 = i9;
                            j2 = j5;
                        }
                    }
                    this.f3766f = i5;
                    return j2;
                }
            }
            return F();
        }

        public final long F() throws InvalidProtocolBufferException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                int i3 = this.f3766f;
                if (i3 == this.f3764d) {
                    throw InvalidProtocolBufferException.g();
                }
                this.f3766f = i3 + 1;
                j2 |= (r3 & 127) << i2;
                if ((this.f3763c[i3] & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.d();
        }

        public final void G() {
            int i2 = this.f3764d + this.f3765e;
            this.f3764d = i2;
            int i3 = i2 - this.f3767g;
            int i4 = this.f3769i;
            if (i3 <= i4) {
                this.f3765e = 0;
                return;
            }
            int i5 = i3 - i4;
            this.f3765e = i5;
            this.f3764d = i2 - i5;
        }

        public final void H(int i2) throws InvalidProtocolBufferException {
            if (i2 >= 0) {
                int i3 = this.f3764d;
                int i4 = this.f3766f;
                if (i2 <= i3 - i4) {
                    this.f3766f = i4 + i2;
                    return;
                }
            }
            if (i2 >= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final void a(int i2) throws InvalidProtocolBufferException {
            if (this.f3768h != i2) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int b() {
            return this.f3766f - this.f3767g;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean c() {
            return this.f3766f == this.f3764d;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final void f(int i2) {
            this.f3769i = i2;
            G();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int g(int i2) {
            if (i2 < 0) {
                throw InvalidProtocolBufferException.e();
            }
            int iB = i2 + b();
            if (iB < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int i3 = this.f3769i;
            if (iB > i3) {
                throw InvalidProtocolBufferException.g();
            }
            this.f3769i = iB;
            G();
            return i3;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean h() {
            return E() != 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final androidx.datastore.preferences.protobuf.ByteString i() throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException {
            /*
                r4 = this;
                int r0 = r4.D()
                byte[] r1 = r4.f3763c
                if (r0 <= 0) goto L19
                int r2 = r4.f3764d
                int r3 = r4.f3766f
                int r2 = r2 - r3
                if (r0 > r2) goto L19
                androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.i(r3, r1, r0)
                int r2 = r4.f3766f
                int r2 = r2 + r0
                r4.f3766f = r2
                return r1
            L19:
                if (r0 != 0) goto L1e
                androidx.datastore.preferences.protobuf.ByteString r0 = androidx.datastore.preferences.protobuf.ByteString.f3748b
                return r0
            L1e:
                if (r0 <= 0) goto L2f
                int r2 = r4.f3764d
                int r3 = r4.f3766f
                int r2 = r2 - r3
                if (r0 > r2) goto L2f
                int r0 = r0 + r3
                r4.f3766f = r0
                byte[] r0 = java.util.Arrays.copyOfRange(r1, r3, r0)
                goto L35
            L2f:
                if (r0 > 0) goto L42
                if (r0 != 0) goto L3d
                byte[] r0 = androidx.datastore.preferences.protobuf.Internal.f4025b
            L35:
                androidx.datastore.preferences.protobuf.ByteString r1 = androidx.datastore.preferences.protobuf.ByteString.f3748b
                androidx.datastore.preferences.protobuf.ByteString$LiteralByteString r1 = new androidx.datastore.preferences.protobuf.ByteString$LiteralByteString
                r1.<init>(r0)
                return r1
            L3d:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.e()
                throw r0
            L42:
                androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r0 = androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.g()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.ArrayDecoder.i():androidx.datastore.preferences.protobuf.ByteString");
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final double j() {
            return Double.longBitsToDouble(C());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int k() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int l() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long m() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final float n() {
            return Float.intBitsToFloat(B());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int o() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long p() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int q() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long r() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int s() {
            int iD = D();
            return (-(iD & 1)) ^ (iD >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long t() {
            long jE = E();
            return (-(jE & 1)) ^ (jE >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final String u() throws InvalidProtocolBufferException {
            int iD = D();
            if (iD > 0) {
                int i2 = this.f3764d;
                int i3 = this.f3766f;
                if (iD <= i2 - i3) {
                    String str = new String(this.f3763c, i3, iD, Internal.f4024a);
                    this.f3766f += iD;
                    return str;
                }
            }
            if (iD == 0) {
                return "";
            }
            if (iD < 0) {
                throw InvalidProtocolBufferException.e();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final String v() throws InvalidProtocolBufferException {
            int iD = D();
            if (iD > 0) {
                int i2 = this.f3764d;
                int i3 = this.f3766f;
                if (iD <= i2 - i3) {
                    String strA = Utf8.f4190a.a(i3, this.f3763c, iD);
                    this.f3766f += iD;
                    return strA;
                }
            }
            if (iD == 0) {
                return "";
            }
            if (iD <= 0) {
                throw InvalidProtocolBufferException.e();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int w() throws InvalidProtocolBufferException {
            if (c()) {
                this.f3768h = 0;
                return 0;
            }
            int iD = D();
            this.f3768h = iD;
            if ((iD >>> 3) != 0) {
                return iD;
            }
            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int x() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long y() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean z(int i2) throws InvalidProtocolBufferException {
            int i3 = i2 & 7;
            int i4 = 0;
            if (i3 != 0) {
                if (i3 == 1) {
                    H(8);
                    return true;
                }
                if (i3 == 2) {
                    H(D());
                    return true;
                }
                if (i3 == 3) {
                    A();
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                }
                if (i3 == 4) {
                    return false;
                }
                if (i3 != 5) {
                    throw InvalidProtocolBufferException.c();
                }
                H(4);
                return true;
            }
            int i5 = this.f3764d - this.f3766f;
            byte[] bArr = this.f3763c;
            if (i5 >= 10) {
                while (i4 < 10) {
                    int i6 = this.f3766f;
                    this.f3766f = i6 + 1;
                    if (bArr[i6] < 0) {
                        i4++;
                    }
                }
                throw InvalidProtocolBufferException.d();
            }
            while (i4 < 10) {
                int i7 = this.f3766f;
                if (i7 == this.f3764d) {
                    throw InvalidProtocolBufferException.g();
                }
                this.f3766f = i7 + 1;
                if (bArr[i7] < 0) {
                    i4++;
                }
            }
            throw InvalidProtocolBufferException.d();
            return true;
        }
    }

    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {

        /* renamed from: c, reason: collision with root package name */
        public final Iterator f3770c;

        /* renamed from: d, reason: collision with root package name */
        public ByteBuffer f3771d;

        /* renamed from: e, reason: collision with root package name */
        public int f3772e;

        /* renamed from: f, reason: collision with root package name */
        public int f3773f;

        /* renamed from: h, reason: collision with root package name */
        public int f3775h;

        /* renamed from: j, reason: collision with root package name */
        public long f3777j;

        /* renamed from: k, reason: collision with root package name */
        public long f3778k;

        /* renamed from: l, reason: collision with root package name */
        public long f3779l;

        /* renamed from: g, reason: collision with root package name */
        public int f3774g = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* renamed from: i, reason: collision with root package name */
        public int f3776i = 0;

        public IterableDirectByteBufferDecoder(int i2, ArrayList arrayList) {
            this.f3772e = i2;
            this.f3770c = arrayList.iterator();
            if (i2 != 0) {
                L();
                return;
            }
            this.f3771d = Internal.f4026c;
            this.f3777j = 0L;
            this.f3778k = 0L;
            this.f3779l = 0L;
        }

        public final long B() {
            return this.f3779l - this.f3777j;
        }

        public final byte C() throws InvalidProtocolBufferException {
            if (B() == 0) {
                if (!this.f3770c.hasNext()) {
                    throw InvalidProtocolBufferException.g();
                }
                L();
            }
            long j2 = this.f3777j;
            this.f3777j = 1 + j2;
            return UnsafeUtil.f4183c.f(j2);
        }

        public final void D(int i2, byte[] bArr) throws InvalidProtocolBufferException {
            if (i2 < 0 || i2 > J()) {
                if (i2 > 0) {
                    throw InvalidProtocolBufferException.g();
                }
                if (i2 != 0) {
                    throw InvalidProtocolBufferException.e();
                }
                return;
            }
            int i3 = i2;
            while (i3 > 0) {
                if (B() == 0) {
                    if (!this.f3770c.hasNext()) {
                        throw InvalidProtocolBufferException.g();
                    }
                    L();
                }
                int iMin = Math.min(i3, (int) B());
                long j2 = iMin;
                byte[] bArr2 = bArr;
                UnsafeUtil.f4183c.c(this.f3777j, bArr2, i2 - i3, j2);
                i3 -= iMin;
                this.f3777j += j2;
                bArr = bArr2;
            }
        }

        public final int E() {
            if (B() < 4) {
                return (C() & 255) | ((C() & 255) << 8) | ((C() & 255) << 16) | ((C() & 255) << 24);
            }
            long j2 = this.f3777j;
            this.f3777j = 4 + j2;
            UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
            return ((memoryAccessor.f(j2 + 3) & 255) << 24) | (memoryAccessor.f(j2) & 255) | ((memoryAccessor.f(1 + j2) & 255) << 8) | ((memoryAccessor.f(2 + j2) & 255) << 16);
        }

        public final long F() {
            if (B() < 8) {
                return (C() & 255) | ((C() & 255) << 8) | ((C() & 255) << 16) | ((C() & 255) << 24) | ((C() & 255) << 32) | ((C() & 255) << 40) | ((C() & 255) << 48) | ((C() & 255) << 56);
            }
            this.f3777j = 8 + this.f3777j;
            UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
            return (memoryAccessor.f(r13) & 255) | ((memoryAccessor.f(r13 + 1) & 255) << 8) | ((memoryAccessor.f(r13 + 2) & 255) << 16) | ((memoryAccessor.f(3 + r13) & 255) << 24) | ((memoryAccessor.f(4 + r13) & 255) << 32) | ((memoryAccessor.f(5 + r13) & 255) << 40) | ((memoryAccessor.f(6 + r13) & 255) << 48) | ((memoryAccessor.f(r13 + 7) & 255) << 56);
        }

        public final int G() {
            int i2;
            long j2 = this.f3777j;
            if (this.f3779l != j2) {
                long j3 = j2 + 1;
                UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
                byte bF = memoryAccessor.f(j2);
                if (bF >= 0) {
                    this.f3777j++;
                    return bF;
                }
                if (this.f3779l - this.f3777j >= 10) {
                    long j4 = 2 + j2;
                    int iF = (memoryAccessor.f(j3) << 7) ^ bF;
                    if (iF < 0) {
                        i2 = iF ^ (-128);
                    } else {
                        long j5 = 3 + j2;
                        int iF2 = (memoryAccessor.f(j4) << 14) ^ iF;
                        if (iF2 >= 0) {
                            i2 = iF2 ^ 16256;
                        } else {
                            long j6 = 4 + j2;
                            int iF3 = iF2 ^ (memoryAccessor.f(j5) << 21);
                            if (iF3 < 0) {
                                i2 = (-2080896) ^ iF3;
                            } else {
                                j5 = 5 + j2;
                                byte bF2 = memoryAccessor.f(j6);
                                int i3 = (iF3 ^ (bF2 << 28)) ^ 266354560;
                                if (bF2 < 0) {
                                    j6 = 6 + j2;
                                    if (memoryAccessor.f(j5) < 0) {
                                        j5 = 7 + j2;
                                        if (memoryAccessor.f(j6) < 0) {
                                            j6 = 8 + j2;
                                            if (memoryAccessor.f(j5) < 0) {
                                                j5 = 9 + j2;
                                                if (memoryAccessor.f(j6) < 0) {
                                                    long j7 = j2 + 10;
                                                    if (memoryAccessor.f(j5) >= 0) {
                                                        i2 = i3;
                                                        j4 = j7;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i2 = i3;
                                }
                                i2 = i3;
                            }
                            j4 = j6;
                        }
                        j4 = j5;
                    }
                    this.f3777j = j4;
                    return i2;
                }
            }
            return (int) I();
        }

        public final long H() {
            long j2;
            long j3;
            long j4;
            long j5 = this.f3777j;
            if (this.f3779l != j5) {
                long j6 = j5 + 1;
                UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
                byte bF = memoryAccessor.f(j5);
                if (bF >= 0) {
                    this.f3777j++;
                    return bF;
                }
                if (this.f3779l - this.f3777j >= 10) {
                    long j7 = 2 + j5;
                    int iF = (memoryAccessor.f(j6) << 7) ^ bF;
                    if (iF < 0) {
                        j2 = iF ^ (-128);
                    } else {
                        long j8 = 3 + j5;
                        int iF2 = (memoryAccessor.f(j7) << 14) ^ iF;
                        if (iF2 >= 0) {
                            j2 = iF2 ^ 16256;
                        } else {
                            long j9 = 4 + j5;
                            int iF3 = iF2 ^ (memoryAccessor.f(j8) << 21);
                            if (iF3 < 0) {
                                j2 = (-2080896) ^ iF3;
                                j7 = j9;
                            } else {
                                long j10 = 5 + j5;
                                long jF = (memoryAccessor.f(j9) << 28) ^ iF3;
                                if (jF >= 0) {
                                    j4 = 266354560;
                                } else {
                                    j8 = 6 + j5;
                                    long jF2 = jF ^ (memoryAccessor.f(j10) << 35);
                                    if (jF2 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j10 = 7 + j5;
                                        jF = jF2 ^ (memoryAccessor.f(j8) << 42);
                                        if (jF >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j8 = 8 + j5;
                                            jF2 = jF ^ (memoryAccessor.f(j10) << 49);
                                            if (jF2 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                j10 = 9 + j5;
                                                long jF3 = (jF2 ^ (memoryAccessor.f(j8) << 56)) ^ 71499008037633920L;
                                                if (jF3 < 0) {
                                                    long j11 = j5 + 10;
                                                    if (memoryAccessor.f(j10) >= 0) {
                                                        j7 = j11;
                                                        j2 = jF3;
                                                    }
                                                } else {
                                                    j2 = jF3;
                                                    j7 = j10;
                                                }
                                            }
                                        }
                                    }
                                    j2 = j3 ^ jF2;
                                }
                                j2 = j4 ^ jF;
                                j7 = j10;
                            }
                        }
                        j7 = j8;
                    }
                    this.f3777j = j7;
                    return j2;
                }
            }
            return I();
        }

        public final long I() throws InvalidProtocolBufferException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                j2 |= (r3 & 127) << i2;
                if ((C() & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.d();
        }

        public final int J() {
            return (int) (((this.f3772e - this.f3776i) - this.f3777j) + this.f3778k);
        }

        public final void K(int i2) throws InvalidProtocolBufferException {
            if (i2 < 0 || i2 > ((this.f3772e - this.f3776i) - this.f3777j) + this.f3778k) {
                if (i2 >= 0) {
                    throw InvalidProtocolBufferException.g();
                }
                throw InvalidProtocolBufferException.e();
            }
            while (i2 > 0) {
                if (B() == 0) {
                    if (!this.f3770c.hasNext()) {
                        throw InvalidProtocolBufferException.g();
                    }
                    L();
                }
                int iMin = Math.min(i2, (int) B());
                i2 -= iMin;
                this.f3777j += iMin;
            }
        }

        public final void L() {
            ByteBuffer byteBuffer = (ByteBuffer) this.f3770c.next();
            this.f3771d = byteBuffer;
            this.f3776i += (int) (this.f3777j - this.f3778k);
            long jPosition = byteBuffer.position();
            this.f3777j = jPosition;
            this.f3778k = jPosition;
            this.f3779l = this.f3771d.limit();
            long jB = UnsafeUtil.b(this.f3771d);
            this.f3777j += jB;
            this.f3778k += jB;
            this.f3779l += jB;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final void a(int i2) throws InvalidProtocolBufferException {
            if (this.f3775h != i2) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int b() {
            return (int) ((this.f3776i + this.f3777j) - this.f3778k);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean c() {
            return (((long) this.f3776i) + this.f3777j) - this.f3778k == ((long) this.f3772e);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final void f(int i2) {
            this.f3774g = i2;
            int i3 = this.f3772e + this.f3773f;
            this.f3772e = i3;
            if (i3 <= i2) {
                this.f3773f = 0;
                return;
            }
            int i4 = i3 - i2;
            this.f3773f = i4;
            this.f3772e = i3 - i4;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int g(int i2) throws InvalidProtocolBufferException {
            if (i2 < 0) {
                throw InvalidProtocolBufferException.e();
            }
            int iB = i2 + b();
            int i3 = this.f3774g;
            if (iB > i3) {
                throw InvalidProtocolBufferException.g();
            }
            this.f3774g = iB;
            int i4 = this.f3772e + this.f3773f;
            this.f3772e = i4;
            if (i4 <= iB) {
                this.f3773f = 0;
                return i3;
            }
            int i5 = i4 - iB;
            this.f3773f = i5;
            this.f3772e = i4 - i5;
            return i3;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean h() {
            return H() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final ByteString i() throws InvalidProtocolBufferException {
            int iG = G();
            if (iG > 0) {
                long j2 = iG;
                long j3 = this.f3779l;
                long j4 = this.f3777j;
                if (j2 <= j3 - j4) {
                    byte[] bArr = new byte[iG];
                    UnsafeUtil.f4183c.c(j4, bArr, 0L, j2);
                    this.f3777j += j2;
                    ByteString byteString = ByteString.f3748b;
                    return new ByteString.LiteralByteString(bArr);
                }
            }
            if (iG > 0 && iG <= J()) {
                byte[] bArr2 = new byte[iG];
                D(iG, bArr2);
                ByteString byteString2 = ByteString.f3748b;
                return new ByteString.LiteralByteString(bArr2);
            }
            if (iG == 0) {
                return ByteString.f3748b;
            }
            if (iG < 0) {
                throw InvalidProtocolBufferException.e();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final double j() {
            return Double.longBitsToDouble(F());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int k() {
            return G();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int l() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long m() {
            return F();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final float n() {
            return Float.intBitsToFloat(E());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int o() {
            return G();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long p() {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int q() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long r() {
            return F();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int s() {
            int iG = G();
            return (-(iG & 1)) ^ (iG >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long t() {
            long jH = H();
            return (-(jH & 1)) ^ (jH >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final String u() throws InvalidProtocolBufferException {
            int iG = G();
            if (iG > 0) {
                long j2 = iG;
                long j3 = this.f3779l;
                long j4 = this.f3777j;
                if (j2 <= j3 - j4) {
                    byte[] bArr = new byte[iG];
                    UnsafeUtil.f4183c.c(j4, bArr, 0L, j2);
                    String str = new String(bArr, Internal.f4024a);
                    this.f3777j += j2;
                    return str;
                }
            }
            if (iG > 0 && iG <= J()) {
                byte[] bArr2 = new byte[iG];
                D(iG, bArr2);
                return new String(bArr2, Internal.f4024a);
            }
            if (iG == 0) {
                return "";
            }
            if (iG < 0) {
                throw InvalidProtocolBufferException.e();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final String v() throws InvalidProtocolBufferException {
            int iG = G();
            if (iG > 0) {
                long j2 = iG;
                long j3 = this.f3779l;
                long j4 = this.f3777j;
                if (j2 <= j3 - j4) {
                    String strC = Utf8.c(this.f3771d, (int) (j4 - this.f3778k), iG);
                    this.f3777j += j2;
                    return strC;
                }
            }
            if (iG >= 0 && iG <= J()) {
                byte[] bArr = new byte[iG];
                D(iG, bArr);
                return Utf8.f4190a.a(0, bArr, iG);
            }
            if (iG == 0) {
                return "";
            }
            if (iG <= 0) {
                throw InvalidProtocolBufferException.e();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int w() throws InvalidProtocolBufferException {
            if (c()) {
                this.f3775h = 0;
                return 0;
            }
            int iG = G();
            this.f3775h = iG;
            if ((iG >>> 3) != 0) {
                return iG;
            }
            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int x() {
            return G();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long y() {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean z(int i2) throws InvalidProtocolBufferException {
            int i3 = i2 & 7;
            if (i3 == 0) {
                for (int i4 = 0; i4 < 10; i4++) {
                    if (C() >= 0) {
                        return true;
                    }
                }
                throw InvalidProtocolBufferException.d();
            }
            if (i3 == 1) {
                K(8);
                return true;
            }
            if (i3 == 2) {
                K(G());
                return true;
            }
            if (i3 == 3) {
                A();
                a(((i2 >>> 3) << 3) | 4);
                return true;
            }
            if (i3 == 4) {
                return false;
            }
            if (i3 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            K(4);
            return true;
        }
    }

    public static final class StreamDecoder extends CodedInputStream {

        /* renamed from: c, reason: collision with root package name */
        public final InputStream f3780c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f3781d;

        /* renamed from: e, reason: collision with root package name */
        public int f3782e;

        /* renamed from: f, reason: collision with root package name */
        public int f3783f;

        /* renamed from: g, reason: collision with root package name */
        public int f3784g;

        /* renamed from: h, reason: collision with root package name */
        public int f3785h;

        /* renamed from: i, reason: collision with root package name */
        public int f3786i;

        /* renamed from: j, reason: collision with root package name */
        public int f3787j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        public interface RefillCallback {
        }

        public class SkippedDataSink implements RefillCallback {
        }

        public StreamDecoder(InputStream inputStream) {
            Internal.a(inputStream, "input");
            this.f3780c = inputStream;
            this.f3781d = new byte[4096];
            this.f3782e = 0;
            this.f3784g = 0;
            this.f3786i = 0;
        }

        public final byte[] B(int i2) throws IOException {
            byte[] bArrC = C(i2);
            if (bArrC != null) {
                return bArrC;
            }
            int i3 = this.f3784g;
            int i4 = this.f3782e;
            int length = i4 - i3;
            this.f3786i += i4;
            this.f3784g = 0;
            this.f3782e = 0;
            ArrayList arrayListD = D(i2 - length);
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f3781d, i3, bArr, 0, length);
            Iterator it = arrayListD.iterator();
            while (it.hasNext()) {
                byte[] bArr2 = (byte[]) it.next();
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        public final byte[] C(int i2) throws IOException {
            if (i2 == 0) {
                return Internal.f4025b;
            }
            if (i2 < 0) {
                throw InvalidProtocolBufferException.e();
            }
            int i3 = this.f3786i;
            int i4 = this.f3784g;
            int i5 = i3 + i4 + i2;
            if (i5 - Api.BaseClientBuilder.API_PRIORITY_OTHER > 0) {
                throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
            }
            int i6 = this.f3787j;
            if (i5 > i6) {
                L((i6 - i3) - i4);
                throw InvalidProtocolBufferException.g();
            }
            int i7 = this.f3782e - i4;
            int i8 = i2 - i7;
            InputStream inputStream = this.f3780c;
            if (i8 >= 4096) {
                try {
                    if (i8 > inputStream.available()) {
                        return null;
                    }
                } catch (InvalidProtocolBufferException e2) {
                    e2.f4028a = true;
                    throw e2;
                }
            }
            byte[] bArr = new byte[i2];
            System.arraycopy(this.f3781d, this.f3784g, bArr, 0, i7);
            this.f3786i += this.f3782e;
            this.f3784g = 0;
            this.f3782e = 0;
            while (i7 < i2) {
                try {
                    int i9 = inputStream.read(bArr, i7, i2 - i7);
                    if (i9 == -1) {
                        throw InvalidProtocolBufferException.g();
                    }
                    this.f3786i += i9;
                    i7 += i9;
                } catch (InvalidProtocolBufferException e3) {
                    e3.f4028a = true;
                    throw e3;
                }
            }
            return bArr;
        }

        public final ArrayList D(int i2) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i2 > 0) {
                int iMin = Math.min(i2, 4096);
                byte[] bArr = new byte[iMin];
                int i3 = 0;
                while (i3 < iMin) {
                    int i4 = this.f3780c.read(bArr, i3, iMin - i3);
                    if (i4 == -1) {
                        throw InvalidProtocolBufferException.g();
                    }
                    this.f3786i += i4;
                    i3 += i4;
                }
                i2 -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        public final int E() throws InvalidProtocolBufferException {
            int i2 = this.f3784g;
            if (this.f3782e - i2 < 4) {
                K(4);
                i2 = this.f3784g;
            }
            this.f3784g = i2 + 4;
            byte[] bArr = this.f3781d;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }

        public final long F() throws InvalidProtocolBufferException {
            int i2 = this.f3784g;
            if (this.f3782e - i2 < 8) {
                K(8);
                i2 = this.f3784g;
            }
            this.f3784g = i2 + 8;
            byte[] bArr = this.f3781d;
            return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
        }

        public final int G() {
            int i2;
            int i3 = this.f3784g;
            int i4 = this.f3782e;
            if (i4 != i3) {
                int i5 = i3 + 1;
                byte[] bArr = this.f3781d;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    this.f3784g = i5;
                    return b2;
                }
                if (i4 - i5 >= 9) {
                    int i6 = i3 + 2;
                    int i7 = (bArr[i5] << 7) ^ b2;
                    if (i7 < 0) {
                        i2 = i7 ^ (-128);
                    } else {
                        int i8 = i3 + 3;
                        int i9 = (bArr[i6] << 14) ^ i7;
                        if (i9 >= 0) {
                            i2 = i9 ^ 16256;
                        } else {
                            int i10 = i3 + 4;
                            int i11 = i9 ^ (bArr[i8] << 21);
                            if (i11 < 0) {
                                i2 = (-2080896) ^ i11;
                            } else {
                                i8 = i3 + 5;
                                byte b3 = bArr[i10];
                                int i12 = (i11 ^ (b3 << 28)) ^ 266354560;
                                if (b3 < 0) {
                                    i10 = i3 + 6;
                                    if (bArr[i8] < 0) {
                                        i8 = i3 + 7;
                                        if (bArr[i10] < 0) {
                                            i10 = i3 + 8;
                                            if (bArr[i8] < 0) {
                                                i8 = i3 + 9;
                                                if (bArr[i10] < 0) {
                                                    int i13 = i3 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i6 = i13;
                                                        i2 = i12;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i2 = i12;
                                }
                                i2 = i12;
                            }
                            i6 = i10;
                        }
                        i6 = i8;
                    }
                    this.f3784g = i6;
                    return i2;
                }
            }
            return (int) I();
        }

        public final long H() {
            long j2;
            long j3;
            long j4;
            long j5;
            int i2 = this.f3784g;
            int i3 = this.f3782e;
            if (i3 != i2) {
                int i4 = i2 + 1;
                byte[] bArr = this.f3781d;
                byte b2 = bArr[i2];
                if (b2 >= 0) {
                    this.f3784g = i4;
                    return b2;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b2;
                    if (i6 < 0) {
                        j2 = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            j2 = i8 ^ 16256;
                            i5 = i7;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                j5 = (-2080896) ^ i10;
                            } else {
                                long j6 = i10;
                                i5 = i2 + 5;
                                long j7 = j6 ^ (bArr[i9] << 28);
                                if (j7 >= 0) {
                                    j4 = 266354560;
                                } else {
                                    i9 = i2 + 6;
                                    long j8 = j7 ^ (bArr[i5] << 35);
                                    if (j8 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        i5 = i2 + 7;
                                        j7 = j8 ^ (bArr[i9] << 42);
                                        if (j7 >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            i9 = i2 + 8;
                                            j8 = j7 ^ (bArr[i5] << 49);
                                            if (j8 < 0) {
                                                j3 = -558586000294016L;
                                            } else {
                                                i5 = i2 + 9;
                                                long j9 = (j8 ^ (bArr[i9] << 56)) ^ 71499008037633920L;
                                                if (j9 < 0) {
                                                    int i11 = i2 + 10;
                                                    if (bArr[i5] >= 0) {
                                                        i5 = i11;
                                                    }
                                                }
                                                j2 = j9;
                                            }
                                        }
                                    }
                                    j5 = j3 ^ j8;
                                }
                                j2 = j4 ^ j7;
                            }
                            i5 = i9;
                            j2 = j5;
                        }
                    }
                    this.f3784g = i5;
                    return j2;
                }
            }
            return I();
        }

        public final long I() throws InvalidProtocolBufferException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                if (this.f3784g == this.f3782e) {
                    K(1);
                }
                int i3 = this.f3784g;
                this.f3784g = i3 + 1;
                j2 |= (r3 & 127) << i2;
                if ((this.f3781d[i3] & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.d();
        }

        public final void J() {
            int i2 = this.f3782e + this.f3783f;
            this.f3782e = i2;
            int i3 = this.f3786i + i2;
            int i4 = this.f3787j;
            if (i3 <= i4) {
                this.f3783f = 0;
                return;
            }
            int i5 = i3 - i4;
            this.f3783f = i5;
            this.f3782e = i2 - i5;
        }

        public final void K(int i2) throws InvalidProtocolBufferException {
            if (M(i2)) {
                return;
            }
            if (i2 <= (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.f3786i) - this.f3784g) {
                throw InvalidProtocolBufferException.g();
            }
            throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }

        public final void L(int i2) throws InvalidProtocolBufferException {
            int i3 = this.f3782e;
            int i4 = this.f3784g;
            if (i2 <= i3 - i4 && i2 >= 0) {
                this.f3784g = i4 + i2;
                return;
            }
            InputStream inputStream = this.f3780c;
            if (i2 < 0) {
                throw InvalidProtocolBufferException.e();
            }
            int i5 = this.f3786i;
            int i6 = i5 + i4;
            int i7 = i6 + i2;
            int i8 = this.f3787j;
            if (i7 > i8) {
                L((i8 - i5) - i4);
                throw InvalidProtocolBufferException.g();
            }
            this.f3786i = i6;
            int i9 = i3 - i4;
            this.f3782e = 0;
            this.f3784g = 0;
            while (i9 < i2) {
                long j2 = i2 - i9;
                try {
                    try {
                        long jSkip = inputStream.skip(j2);
                        if (jSkip < 0 || jSkip > j2) {
                            throw new IllegalStateException(inputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                        }
                        if (jSkip == 0) {
                            break;
                        } else {
                            i9 += (int) jSkip;
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        e2.f4028a = true;
                        throw e2;
                    }
                } catch (Throwable th) {
                    this.f3786i += i9;
                    J();
                    throw th;
                }
            }
            this.f3786i += i9;
            J();
            if (i9 >= i2) {
                return;
            }
            int i10 = this.f3782e;
            int i11 = i10 - this.f3784g;
            this.f3784g = i10;
            K(1);
            while (true) {
                int i12 = i2 - i11;
                int i13 = this.f3782e;
                if (i12 <= i13) {
                    this.f3784g = i12;
                    return;
                } else {
                    i11 += i13;
                    this.f3784g = i13;
                    K(1);
                }
            }
        }

        public final boolean M(int i2) throws IOException {
            int i3 = this.f3784g;
            int i4 = i3 + i2;
            int i5 = this.f3782e;
            if (i4 <= i5) {
                throw new IllegalStateException(b.g(i2, "refillBuffer() called when ", " bytes were already available in buffer"));
            }
            int i6 = this.f3786i;
            if (i2 <= (Api.BaseClientBuilder.API_PRIORITY_OTHER - i6) - i3 && i6 + i3 + i2 <= this.f3787j) {
                byte[] bArr = this.f3781d;
                if (i3 > 0) {
                    if (i5 > i3) {
                        System.arraycopy(bArr, i3, bArr, 0, i5 - i3);
                    }
                    this.f3786i += i3;
                    this.f3782e -= i3;
                    this.f3784g = 0;
                }
                int i7 = this.f3782e;
                int iMin = Math.min(bArr.length - i7, (Api.BaseClientBuilder.API_PRIORITY_OTHER - this.f3786i) - i7);
                InputStream inputStream = this.f3780c;
                try {
                    int i8 = inputStream.read(bArr, i7, iMin);
                    if (i8 == 0 || i8 < -1 || i8 > bArr.length) {
                        throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + i8 + "\nThe InputStream implementation is buggy.");
                    }
                    if (i8 > 0) {
                        this.f3782e += i8;
                        J();
                        if (this.f3782e >= i2) {
                            return true;
                        }
                        return M(i2);
                    }
                } catch (InvalidProtocolBufferException e2) {
                    e2.f4028a = true;
                    throw e2;
                }
            }
            return false;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final void a(int i2) throws InvalidProtocolBufferException {
            if (this.f3785h != i2) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int b() {
            return this.f3786i + this.f3784g;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean c() {
            return this.f3784g == this.f3782e && !M(1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final void f(int i2) {
            this.f3787j = i2;
            J();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int g(int i2) throws InvalidProtocolBufferException {
            if (i2 < 0) {
                throw InvalidProtocolBufferException.e();
            }
            int i3 = this.f3786i + this.f3784g + i2;
            if (i3 < 0) {
                throw InvalidProtocolBufferException.f();
            }
            int i4 = this.f3787j;
            if (i3 > i4) {
                throw InvalidProtocolBufferException.g();
            }
            this.f3787j = i3;
            J();
            return i4;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean h() {
            return H() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final ByteString i() throws IOException {
            int iG = G();
            int i2 = this.f3782e;
            int i3 = this.f3784g;
            int i4 = i2 - i3;
            byte[] bArr = this.f3781d;
            if (iG <= i4 && iG > 0) {
                ByteString byteStringI = ByteString.i(i3, bArr, iG);
                this.f3784g += iG;
                return byteStringI;
            }
            if (iG == 0) {
                return ByteString.f3748b;
            }
            if (iG < 0) {
                throw InvalidProtocolBufferException.e();
            }
            byte[] bArrC = C(iG);
            if (bArrC != null) {
                return ByteString.i(0, bArrC, bArrC.length);
            }
            int i5 = this.f3784g;
            int i6 = this.f3782e;
            int length = i6 - i5;
            this.f3786i += i6;
            this.f3784g = 0;
            this.f3782e = 0;
            ArrayList arrayListD = D(iG - length);
            byte[] bArr2 = new byte[iG];
            System.arraycopy(bArr, i5, bArr2, 0, length);
            Iterator it = arrayListD.iterator();
            while (it.hasNext()) {
                byte[] bArr3 = (byte[]) it.next();
                System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
                length += bArr3.length;
            }
            ByteString byteString = ByteString.f3748b;
            return new ByteString.LiteralByteString(bArr2);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final double j() {
            return Double.longBitsToDouble(F());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int k() {
            return G();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int l() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long m() {
            return F();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final float n() {
            return Float.intBitsToFloat(E());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int o() {
            return G();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long p() {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int q() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long r() {
            return F();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int s() {
            int iG = G();
            return (-(iG & 1)) ^ (iG >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long t() {
            long jH = H();
            return (-(jH & 1)) ^ (jH >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final String u() throws InvalidProtocolBufferException {
            int iG = G();
            byte[] bArr = this.f3781d;
            if (iG > 0) {
                int i2 = this.f3782e;
                int i3 = this.f3784g;
                if (iG <= i2 - i3) {
                    String str = new String(bArr, i3, iG, Internal.f4024a);
                    this.f3784g += iG;
                    return str;
                }
            }
            if (iG == 0) {
                return "";
            }
            if (iG < 0) {
                throw InvalidProtocolBufferException.e();
            }
            if (iG > this.f3782e) {
                return new String(B(iG), Internal.f4024a);
            }
            K(iG);
            String str2 = new String(bArr, this.f3784g, iG, Internal.f4024a);
            this.f3784g += iG;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final String v() throws IOException {
            int iG = G();
            int i2 = this.f3784g;
            int i3 = this.f3782e;
            int i4 = i3 - i2;
            byte[] bArrB = this.f3781d;
            if (iG <= i4 && iG > 0) {
                this.f3784g = i2 + iG;
            } else {
                if (iG == 0) {
                    return "";
                }
                if (iG < 0) {
                    throw InvalidProtocolBufferException.e();
                }
                i2 = 0;
                if (iG <= i3) {
                    K(iG);
                    this.f3784g = iG;
                } else {
                    bArrB = B(iG);
                }
            }
            return Utf8.f4190a.a(i2, bArrB, iG);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int w() throws InvalidProtocolBufferException {
            if (c()) {
                this.f3785h = 0;
                return 0;
            }
            int iG = G();
            this.f3785h = iG;
            if ((iG >>> 3) != 0) {
                return iG;
            }
            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int x() {
            return G();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long y() {
            return H();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean z(int i2) throws InvalidProtocolBufferException {
            int i3 = i2 & 7;
            int i4 = 0;
            if (i3 != 0) {
                if (i3 == 1) {
                    L(8);
                    return true;
                }
                if (i3 == 2) {
                    L(G());
                    return true;
                }
                if (i3 == 3) {
                    A();
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                }
                if (i3 == 4) {
                    return false;
                }
                if (i3 != 5) {
                    throw InvalidProtocolBufferException.c();
                }
                L(4);
                return true;
            }
            int i5 = this.f3782e - this.f3784g;
            byte[] bArr = this.f3781d;
            if (i5 >= 10) {
                while (i4 < 10) {
                    int i6 = this.f3784g;
                    this.f3784g = i6 + 1;
                    if (bArr[i6] < 0) {
                        i4++;
                    }
                }
                throw InvalidProtocolBufferException.d();
            }
            while (i4 < 10) {
                if (this.f3784g == this.f3782e) {
                    K(1);
                }
                int i7 = this.f3784g;
                this.f3784g = i7 + 1;
                if (bArr[i7] < 0) {
                    i4++;
                }
            }
            throw InvalidProtocolBufferException.d();
            return true;
        }
    }

    public static final class UnsafeDirectNioDecoder extends CodedInputStream {

        /* renamed from: c, reason: collision with root package name */
        public final ByteBuffer f3788c;

        /* renamed from: d, reason: collision with root package name */
        public final long f3789d;

        /* renamed from: e, reason: collision with root package name */
        public long f3790e;

        /* renamed from: f, reason: collision with root package name */
        public long f3791f;

        /* renamed from: g, reason: collision with root package name */
        public final long f3792g;

        /* renamed from: h, reason: collision with root package name */
        public int f3793h;

        /* renamed from: i, reason: collision with root package name */
        public int f3794i;

        /* renamed from: j, reason: collision with root package name */
        public int f3795j = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        public UnsafeDirectNioDecoder(ByteBuffer byteBuffer) {
            this.f3788c = byteBuffer;
            long jB = UnsafeUtil.b(byteBuffer);
            this.f3789d = jB;
            this.f3790e = byteBuffer.limit() + jB;
            long jPosition = jB + byteBuffer.position();
            this.f3791f = jPosition;
            this.f3792g = jPosition;
        }

        public final int B() throws InvalidProtocolBufferException {
            long j2 = this.f3791f;
            if (this.f3790e - j2 < 4) {
                throw InvalidProtocolBufferException.g();
            }
            this.f3791f = 4 + j2;
            UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
            return ((memoryAccessor.f(j2 + 3) & 255) << 24) | (memoryAccessor.f(j2) & 255) | ((memoryAccessor.f(1 + j2) & 255) << 8) | ((memoryAccessor.f(2 + j2) & 255) << 16);
        }

        public final long C() throws InvalidProtocolBufferException {
            long j2 = this.f3791f;
            if (this.f3790e - j2 < 8) {
                throw InvalidProtocolBufferException.g();
            }
            this.f3791f = 8 + j2;
            UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
            return ((memoryAccessor.f(j2 + 7) & 255) << 56) | (memoryAccessor.f(j2) & 255) | ((memoryAccessor.f(1 + j2) & 255) << 8) | ((memoryAccessor.f(2 + j2) & 255) << 16) | ((memoryAccessor.f(3 + j2) & 255) << 24) | ((memoryAccessor.f(4 + j2) & 255) << 32) | ((memoryAccessor.f(5 + j2) & 255) << 40) | ((memoryAccessor.f(6 + j2) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0091, code lost:
        
            if (r4.f(r8) < 0) goto L34;
         */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0099 A[PHI: r6
          0x0099: PHI (r6v7 long) = (r6v6 long), (r6v8 long), (r6v10 long) binds: [B:25:0x006d, B:29:0x0080, B:33:0x0091] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int D() {
            /*
                r12 = this;
                long r0 = r12.f3791f
                long r2 = r12.f3790e
                int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r2 != 0) goto La
                goto L93
            La:
                r2 = 1
                long r2 = r2 + r0
                androidx.datastore.preferences.protobuf.UnsafeUtil$MemoryAccessor r4 = androidx.datastore.preferences.protobuf.UnsafeUtil.f4183c
                byte r5 = r4.f(r0)
                if (r5 < 0) goto L18
                r12.f3791f = r2
                return r5
            L18:
                long r6 = r12.f3790e
                long r6 = r6 - r2
                r8 = 9
                int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r6 >= 0) goto L23
                goto L93
            L23:
                r6 = 2
                long r6 = r6 + r0
                byte r2 = r4.f(r2)
                int r2 = r2 << 7
                r2 = r2 ^ r5
                if (r2 >= 0) goto L33
                r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
                goto La0
            L33:
                r10 = 3
                long r10 = r10 + r0
                byte r3 = r4.f(r6)
                int r3 = r3 << 14
                r2 = r2 ^ r3
                if (r2 < 0) goto L43
                r0 = r2 ^ 16256(0x3f80, float:2.278E-41)
            L41:
                r6 = r10
                goto La0
            L43:
                r5 = 4
                long r6 = r0 + r5
                byte r3 = r4.f(r10)
                int r3 = r3 << 21
                r2 = r2 ^ r3
                if (r2 >= 0) goto L55
                r0 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto La0
            L55:
                r10 = 5
                long r10 = r10 + r0
                byte r3 = r4.f(r6)
                int r5 = r3 << 28
                r2 = r2 ^ r5
                r5 = 266354560(0xfe03f80, float:2.2112565E-29)
                r2 = r2 ^ r5
                if (r3 >= 0) goto L9e
                r5 = 6
                long r6 = r0 + r5
                byte r3 = r4.f(r10)
                if (r3 >= 0) goto L99
                r10 = 7
                long r10 = r10 + r0
                byte r3 = r4.f(r6)
                if (r3 >= 0) goto L9e
                r5 = 8
                long r6 = r0 + r5
                byte r3 = r4.f(r10)
                if (r3 >= 0) goto L99
                long r8 = r8 + r0
                byte r3 = r4.f(r6)
                if (r3 >= 0) goto L9b
                r5 = 10
                long r6 = r0 + r5
                byte r0 = r4.f(r8)
                if (r0 >= 0) goto L99
            L93:
                long r0 = r12.F()
                int r0 = (int) r0
                return r0
            L99:
                r0 = r2
                goto La0
            L9b:
                r0 = r2
                r6 = r8
                goto La0
            L9e:
                r0 = r2
                goto L41
            La0:
                r12.f3791f = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStream.UnsafeDirectNioDecoder.D():int");
        }

        public final long E() {
            long j2;
            long j3;
            long j4;
            int i2;
            long j5 = this.f3791f;
            if (this.f3790e != j5) {
                long j6 = 1 + j5;
                UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
                byte bF = memoryAccessor.f(j5);
                if (bF >= 0) {
                    this.f3791f = j6;
                    return bF;
                }
                if (this.f3790e - j6 >= 9) {
                    long j7 = 2 + j5;
                    int iF = (memoryAccessor.f(j6) << 7) ^ bF;
                    if (iF >= 0) {
                        long j8 = 3 + j5;
                        int iF2 = iF ^ (memoryAccessor.f(j7) << 14);
                        if (iF2 >= 0) {
                            j2 = iF2 ^ 16256;
                        } else {
                            j7 = j5 + 4;
                            int iF3 = iF2 ^ (memoryAccessor.f(j8) << 21);
                            if (iF3 < 0) {
                                i2 = (-2080896) ^ iF3;
                            } else {
                                j8 = 5 + j5;
                                long jF = iF3 ^ (memoryAccessor.f(j7) << 28);
                                if (jF < 0) {
                                    long j9 = 6 + j5;
                                    long jF2 = jF ^ (memoryAccessor.f(j8) << 35);
                                    if (jF2 < 0) {
                                        j3 = -34093383808L;
                                    } else {
                                        j8 = 7 + j5;
                                        jF = jF2 ^ (memoryAccessor.f(j9) << 42);
                                        if (jF >= 0) {
                                            j4 = 4363953127296L;
                                        } else {
                                            j9 = 8 + j5;
                                            jF2 = jF ^ (memoryAccessor.f(j8) << 49);
                                            if (jF2 >= 0) {
                                                long j10 = j5 + 9;
                                                long jF3 = (jF2 ^ (memoryAccessor.f(j9) << 56)) ^ 71499008037633920L;
                                                if (jF3 < 0) {
                                                    long j11 = j5 + 10;
                                                    if (memoryAccessor.f(j10) >= 0) {
                                                        j7 = j11;
                                                        j2 = jF3;
                                                    }
                                                } else {
                                                    j2 = jF3;
                                                    j7 = j10;
                                                }
                                                this.f3791f = j7;
                                                return j2;
                                            }
                                            j3 = -558586000294016L;
                                        }
                                    }
                                    j2 = j3 ^ jF2;
                                    j7 = j9;
                                    this.f3791f = j7;
                                    return j2;
                                }
                                j4 = 266354560;
                                j2 = j4 ^ jF;
                            }
                        }
                        j7 = j8;
                        this.f3791f = j7;
                        return j2;
                    }
                    i2 = iF ^ (-128);
                    j2 = i2;
                    this.f3791f = j7;
                    return j2;
                }
            }
            return F();
        }

        public final long F() throws InvalidProtocolBufferException {
            long j2 = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                long j3 = this.f3791f;
                if (j3 == this.f3790e) {
                    throw InvalidProtocolBufferException.g();
                }
                this.f3791f = 1 + j3;
                j2 |= (r3 & 127) << i2;
                if ((UnsafeUtil.f4183c.f(j3) & 128) == 0) {
                    return j2;
                }
            }
            throw InvalidProtocolBufferException.d();
        }

        public final void G() {
            long j2 = this.f3790e + this.f3793h;
            this.f3790e = j2;
            int i2 = (int) (j2 - this.f3792g);
            int i3 = this.f3795j;
            if (i2 <= i3) {
                this.f3793h = 0;
                return;
            }
            int i4 = i2 - i3;
            this.f3793h = i4;
            this.f3790e = j2 - i4;
        }

        public final void H(int i2) throws InvalidProtocolBufferException {
            if (i2 >= 0) {
                long j2 = this.f3790e;
                long j3 = this.f3791f;
                if (i2 <= ((int) (j2 - j3))) {
                    this.f3791f = j3 + i2;
                    return;
                }
            }
            if (i2 >= 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw InvalidProtocolBufferException.e();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final void a(int i2) throws InvalidProtocolBufferException {
            if (this.f3794i != i2) {
                throw InvalidProtocolBufferException.a();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int b() {
            return (int) (this.f3791f - this.f3792g);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean c() {
            return this.f3791f == this.f3790e;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final void f(int i2) {
            this.f3795j = i2;
            G();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int g(int i2) throws InvalidProtocolBufferException {
            if (i2 < 0) {
                throw InvalidProtocolBufferException.e();
            }
            int iB = i2 + b();
            int i3 = this.f3795j;
            if (iB > i3) {
                throw InvalidProtocolBufferException.g();
            }
            this.f3795j = iB;
            G();
            return i3;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean h() {
            return E() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final ByteString i() throws InvalidProtocolBufferException {
            int iD = D();
            if (iD > 0) {
                long j2 = this.f3790e;
                long j3 = this.f3791f;
                if (iD <= ((int) (j2 - j3))) {
                    byte[] bArr = new byte[iD];
                    long j4 = iD;
                    UnsafeUtil.f4183c.c(j3, bArr, 0L, j4);
                    this.f3791f += j4;
                    ByteString byteString = ByteString.f3748b;
                    return new ByteString.LiteralByteString(bArr);
                }
            }
            if (iD == 0) {
                return ByteString.f3748b;
            }
            if (iD < 0) {
                throw InvalidProtocolBufferException.e();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final double j() {
            return Double.longBitsToDouble(C());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int k() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int l() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long m() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final float n() {
            return Float.intBitsToFloat(B());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int o() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long p() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int q() {
            return B();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long r() {
            return C();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int s() {
            int iD = D();
            return (-(iD & 1)) ^ (iD >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long t() {
            long jE = E();
            return (-(jE & 1)) ^ (jE >>> 1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final String u() throws InvalidProtocolBufferException {
            int iD = D();
            if (iD > 0) {
                long j2 = this.f3790e;
                long j3 = this.f3791f;
                if (iD <= ((int) (j2 - j3))) {
                    byte[] bArr = new byte[iD];
                    long j4 = iD;
                    UnsafeUtil.f4183c.c(j3, bArr, 0L, j4);
                    String str = new String(bArr, Internal.f4024a);
                    this.f3791f += j4;
                    return str;
                }
            }
            if (iD == 0) {
                return "";
            }
            if (iD < 0) {
                throw InvalidProtocolBufferException.e();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final String v() throws InvalidProtocolBufferException {
            int iD = D();
            if (iD > 0) {
                long j2 = this.f3790e;
                long j3 = this.f3791f;
                if (iD <= ((int) (j2 - j3))) {
                    String strC = Utf8.c(this.f3788c, (int) (j3 - this.f3789d), iD);
                    this.f3791f += iD;
                    return strC;
                }
            }
            if (iD == 0) {
                return "";
            }
            if (iD <= 0) {
                throw InvalidProtocolBufferException.e();
            }
            throw InvalidProtocolBufferException.g();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int w() throws InvalidProtocolBufferException {
            if (c()) {
                this.f3794i = 0;
                return 0;
            }
            int iD = D();
            this.f3794i = iD;
            if ((iD >>> 3) != 0) {
                return iD;
            }
            throw new InvalidProtocolBufferException("Protocol message contained an invalid tag (zero).");
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final int x() {
            return D();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final long y() {
            return E();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public final boolean z(int i2) throws InvalidProtocolBufferException {
            int i3 = i2 & 7;
            int i4 = 0;
            if (i3 != 0) {
                if (i3 == 1) {
                    H(8);
                    return true;
                }
                if (i3 == 2) {
                    H(D());
                    return true;
                }
                if (i3 == 3) {
                    A();
                    a(((i2 >>> 3) << 3) | 4);
                    return true;
                }
                if (i3 == 4) {
                    return false;
                }
                if (i3 != 5) {
                    throw InvalidProtocolBufferException.c();
                }
                H(4);
                return true;
            }
            if (((int) (this.f3790e - this.f3791f)) >= 10) {
                while (i4 < 10) {
                    long j2 = this.f3791f;
                    this.f3791f = j2 + 1;
                    if (UnsafeUtil.f4183c.f(j2) < 0) {
                        i4++;
                    }
                }
                throw InvalidProtocolBufferException.d();
            }
            while (i4 < 10) {
                long j3 = this.f3791f;
                if (j3 == this.f3790e) {
                    throw InvalidProtocolBufferException.g();
                }
                this.f3791f = j3 + 1;
                if (UnsafeUtil.f4183c.f(j3) < 0) {
                    i4++;
                }
            }
            throw InvalidProtocolBufferException.d();
            return true;
        }
    }

    public static CodedInputStream d(InputStream inputStream) {
        if (inputStream != null) {
            return new StreamDecoder(inputStream);
        }
        byte[] bArr = Internal.f4025b;
        return e(bArr, 0, bArr.length, false);
    }

    public static CodedInputStream e(byte[] bArr, int i2, int i3, boolean z) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i2, i3, z);
        try {
            arrayDecoder.g(i3);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final void A() throws InvalidProtocolBufferException {
        int iW;
        do {
            iW = w();
            if (iW == 0) {
                return;
            }
            int i2 = this.f3761a;
            if (i2 >= 100) {
                throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.f3761a = i2 + 1;
            this.f3761a--;
        } while (z(iW));
    }

    public abstract void a(int i2);

    public abstract int b();

    public abstract boolean c();

    public abstract void f(int i2);

    public abstract int g(int i2);

    public abstract boolean h();

    public abstract ByteString i();

    public abstract double j();

    public abstract int k();

    public abstract int l();

    public abstract long m();

    public abstract float n();

    public abstract int o();

    public abstract long p();

    public abstract int q();

    public abstract long r();

    public abstract int s();

    public abstract long t();

    public abstract String u();

    public abstract String v();

    public abstract int w();

    public abstract int x();

    public abstract long y();

    public abstract boolean z(int i2);
}
