package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class UnknownFieldSetLite {

    /* renamed from: f, reason: collision with root package name */
    public static final UnknownFieldSetLite f4175f = new UnknownFieldSetLite(0, new int[0], new Object[0], false);

    /* renamed from: a, reason: collision with root package name */
    public int f4176a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f4177b;

    /* renamed from: c, reason: collision with root package name */
    public Object[] f4178c;

    /* renamed from: d, reason: collision with root package name */
    public int f4179d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4180e;

    public UnknownFieldSetLite(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f4176a = i2;
        this.f4177b = iArr;
        this.f4178c = objArr;
        this.f4180e = z;
    }

    public static void d(int i2, Object obj, Writer writer) {
        int i3 = i2 >>> 3;
        int i4 = i2 & 7;
        if (i4 == 0) {
            writer.C(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 1) {
            writer.x(i3, ((Long) obj).longValue());
            return;
        }
        if (i4 == 2) {
            writer.j(i3, (ByteString) obj);
            return;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.c());
            }
            writer.c(i3, ((Integer) obj).intValue());
        } else if (writer.y() == Writer.FieldOrder.f4219a) {
            writer.F(i3);
            ((UnknownFieldSetLite) obj).e(writer);
            writer.J(i3);
        } else {
            writer.J(i3);
            ((UnknownFieldSetLite) obj).e(writer);
            writer.F(i3);
        }
    }

    public final void a(int i2) {
        int[] iArr = this.f4177b;
        if (i2 > iArr.length) {
            int i3 = this.f4176a;
            int i4 = (i3 / 2) + i3;
            if (i4 >= i2) {
                i2 = i4;
            }
            if (i2 < 8) {
                i2 = 8;
            }
            this.f4177b = Arrays.copyOf(iArr, i2);
            this.f4178c = Arrays.copyOf(this.f4178c, i2);
        }
    }

    public final int b() {
        int iY;
        int iA0;
        int iY2;
        int i2 = this.f4179d;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f4176a; i4++) {
            int i5 = this.f4177b[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 0) {
                if (i7 == 1) {
                    ((Long) this.f4178c[i4]).getClass();
                    iY2 = CodedOutputStream.Y(i6) + 8;
                } else if (i7 == 2) {
                    iY2 = CodedOutputStream.S(i6, (ByteString) this.f4178c[i4]);
                } else if (i7 == 3) {
                    iY = CodedOutputStream.Y(i6) * 2;
                    iA0 = ((UnknownFieldSetLite) this.f4178c[i4]).b();
                } else {
                    if (i7 != 5) {
                        throw new IllegalStateException(InvalidProtocolBufferException.c());
                    }
                    ((Integer) this.f4178c[i4]).getClass();
                    iY2 = CodedOutputStream.Y(i6) + 4;
                }
                i3 = iY2 + i3;
            } else {
                long jLongValue = ((Long) this.f4178c[i4]).longValue();
                iY = CodedOutputStream.Y(i6);
                iA0 = CodedOutputStream.a0(jLongValue);
            }
            i3 = iA0 + iY + i3;
        }
        this.f4179d = i3;
        return i3;
    }

    public final void c(int i2, Object obj) {
        if (!this.f4180e) {
            throw new UnsupportedOperationException();
        }
        a(this.f4176a + 1);
        int[] iArr = this.f4177b;
        int i3 = this.f4176a;
        iArr[i3] = i2;
        this.f4178c[i3] = obj;
        this.f4176a = i3 + 1;
    }

    public final void e(Writer writer) {
        if (this.f4176a == 0) {
            return;
        }
        if (writer.y() == Writer.FieldOrder.f4219a) {
            for (int i2 = 0; i2 < this.f4176a; i2++) {
                d(this.f4177b[i2], this.f4178c[i2], writer);
            }
            return;
        }
        for (int i3 = this.f4176a - 1; i3 >= 0; i3--) {
            d(this.f4177b[i3], this.f4178c[i3], writer);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i2 = this.f4176a;
        if (i2 == unknownFieldSetLite.f4176a) {
            int[] iArr = this.f4177b;
            int[] iArr2 = unknownFieldSetLite.f4177b;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    Object[] objArr = this.f4178c;
                    Object[] objArr2 = unknownFieldSetLite.f4178c;
                    int i4 = this.f4176a;
                    for (int i5 = 0; i5 < i4; i5++) {
                        if (objArr[i5].equals(objArr2[i5])) {
                        }
                    }
                    return true;
                }
                if (iArr[i3] != iArr2[i3]) {
                    break;
                }
                i3++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.f4176a;
        int i3 = (527 + i2) * 31;
        int[] iArr = this.f4177b;
        int iHashCode = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i3 + i4) * 31;
        Object[] objArr = this.f4178c;
        int i7 = this.f4176a;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return i6 + iHashCode;
    }
}
