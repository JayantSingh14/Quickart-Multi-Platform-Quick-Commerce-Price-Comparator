package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzaus {

    /* renamed from: a, reason: collision with root package name */
    public Object f24403a;

    /* renamed from: b, reason: collision with root package name */
    public long f24404b;

    /* renamed from: c, reason: collision with root package name */
    public double f24405c;

    /* renamed from: d, reason: collision with root package name */
    public zzatw f24406d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f24407e;

    /* renamed from: f, reason: collision with root package name */
    public zzauk f24408f;

    /* renamed from: g, reason: collision with root package name */
    public int f24409g = 1;

    public static zzaus a(Object obj) {
        zzaus zzausVar = new zzaus();
        int[] iArr = {572660336, 1963204074, 810270723, 1168973800, 12304897, -1027511958, 1433925857, 2084420925, 1937477084};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        zzausVar.r();
        zzausVar.f24409g = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8) ^ (i9 % 1937477084);
        zzausVar.f24403a = obj;
        return zzausVar;
    }

    public static zzaus b(long j2) {
        zzaus zzausVar = new zzaus();
        int[] iArr = {269455306, 1628467785, 508432336, 1769894153, 149815616, -1737813993, 468055906, 524872353, 327254586};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        zzausVar.r();
        zzausVar.f24409g = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8) ^ (i9 % 327254586);
        zzausVar.f24404b = j2;
        return zzausVar;
    }

    public static zzaus c(double d2) {
        zzaus zzausVar = new zzaus();
        int[] iArr = {76065818, 1629326670, 912768099, 1092092300, 784816880, -1349977414, 434065736, 1884661237, 1605908235};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        zzausVar.r();
        zzausVar.f24409g = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8) ^ (i9 % 1605908235);
        zzausVar.f24405c = d2;
        return zzausVar;
    }

    public static zzaus d(zzatw zzatwVar) {
        zzaus zzausVar = new zzaus();
        int[] iArr = {1143408282, 544368152, 1884037077, 79323401, 1472762119, -801477845, 201305624, 1470503465, 1402586708};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        zzausVar.r();
        zzausVar.f24409g = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8) ^ (i9 % 1402586708);
        zzausVar.f24406d = zzatwVar;
        return zzausVar;
    }

    public static zzaus e(ArrayList arrayList) {
        zzaus zzausVar = new zzaus();
        int[] iArr = {231602422, 370241669, 619070592, 319896591, 694865338, 1425770340, 39950860, 555996658, 324763920};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        zzausVar.r();
        zzausVar.f24409g = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8) ^ (i9 % 324763920);
        zzausVar.f24407e = arrayList;
        return zzausVar;
    }

    public static zzaus f(zzauk zzaukVar) {
        zzaus zzausVar = new zzaus();
        int[] iArr = {1315209188, 67133601, 1612794668, 612376713, 2023183116, -774012042, 5007439, 661761152, 474613996};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        zzausVar.r();
        zzausVar.f24409g = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8) ^ (i9 % 474613996);
        zzausVar.f24408f = zzaukVar;
        return zzausVar;
    }

    public static zzaus g(Object obj) {
        if (obj instanceof Long) {
            return b(((Long) obj).longValue());
        }
        if (obj instanceof Boolean) {
            return b(true != ((Boolean) obj).booleanValue() ? 0L : 1L);
        }
        if (obj instanceof Integer) {
            return b(((Integer) obj).intValue());
        }
        if (obj instanceof Double) {
            return c(((Double) obj).doubleValue());
        }
        if (obj instanceof Float) {
            return c(((Float) obj).floatValue());
        }
        if (obj instanceof Short) {
            return b(((Short) obj).shortValue());
        }
        if (obj instanceof Byte) {
            return b(((Byte) obj).byteValue());
        }
        if (obj instanceof zzatw) {
            return d((zzatw) obj);
        }
        if (obj instanceof String) {
            zzatw zzatwVar = zzatw.f24365b;
            return d(zzatw.e(((String) obj).getBytes(Charset.forName(zzatu.a("Hn2H4l0=")))));
        }
        if (!(obj instanceof ArrayList)) {
            return a(obj);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) obj;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(g(arrayList2.get(i2)));
        }
        return e(arrayList);
    }

    public static zzaus j(zzaus zzausVar) {
        int[] iArr = {1154349542, 1365661854, 772762753, -35647458, -1399059520, 905919471, 65677639, 1759726503, 552812661};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int iA = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8);
        int i10 = i9 % 552812661;
        try {
            int i11 = zzausVar.f24409g;
            int i12 = (i10 ^ iA) + i11;
            if (i11 == 0) {
                throw null;
            }
            switch (i12) {
                case 0:
                    return new zzaus();
                case 1:
                    return a(zzausVar.l());
                case 2:
                    return b(zzausVar.m());
                case 3:
                    return d(zzausVar.n());
                case 4:
                    ArrayList arrayList = new ArrayList();
                    Iterator it = ((ArrayList) zzausVar.o()).iterator();
                    while (it.hasNext()) {
                        arrayList.add(j((zzaus) it.next()));
                    }
                    return e(arrayList);
                case 5:
                    return f(zzausVar.p());
                case 6:
                    return c(zzausVar.q());
                default:
                    throw new AssertionError(zzatu.a("HkezqgQcPni/TE/NwjgYPC5H6Q2JRdEp275wOg=="));
            }
        } catch (zzaup e2) {
            throw new AssertionError(zzatu.a("CEiv6BFfPnitUE+D"), e2);
        }
    }

    public final Object h() throws zzaup {
        int[] iArr = {172154289, 1050326876, 843682288, -858640882, -228026365, 881347074, 13857144, 514820752, 473891334};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int iA = android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, i7, i8);
        int i10 = this.f24409g;
        int i11 = ((i9 % 473891334) ^ iA) + i10;
        if (i10 == 0) {
            throw null;
        }
        switch (i11) {
            case 0:
            case 5:
                throw new zzaup();
            case 1:
                return l();
            case 2:
                return Long.valueOf(m());
            case 3:
                return n().a();
            case 4:
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayList) o()).iterator();
                while (it.hasNext()) {
                    arrayList.add(((zzaus) it.next()).h());
                }
                return arrayList;
            case 6:
                return Double.valueOf(q());
            default:
                throw new AssertionError(zzatu.a("HkezqgQcPni/TE/NwjgYPC5H6Q2JRdEp275wOg=="));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x01f4, code lost:
    
        if (r18.equals(java.lang.Object.class) != false) goto L150;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(java.lang.Class r18) throws java.lang.ArrayIndexOutOfBoundsException, java.lang.IllegalArgumentException, com.google.android.gms.internal.ads.zzaup, java.lang.NegativeArraySizeException {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaus.i(java.lang.Class):java.lang.Object");
    }

    public final void k(ByteArrayOutputStream byteArrayOutputStream) throws IOException, zzaup {
        long[] jArr = {1269833163, 1628598594, 308676977, 1629286434, 15633520, 3337700125L, 1402923307, 613197917, 297598514};
        long j2 = jArr[0];
        long j3 = jArr[1];
        long j4 = jArr[2];
        long j5 = jArr[3];
        long j6 = jArr[4];
        long j7 = jArr[5];
        long j8 = jArr[6];
        long j9 = jArr[7];
        long j10 = (((((~j2) & j3) | j4) + ((j2 & j5) | j6)) - j7) + j8;
        long j11 = j9 % 297598514;
        int i2 = this.f24409g;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        switch (i3) {
            case 0:
            case 1:
            case 5:
                throw new zzaup();
            case 2:
                zzats.b(m(), new zzaur(byteArrayOutputStream), true);
                return;
            case 3:
                byte[] bArr = n().f24367a;
                zzats.b(bArr.length * (j10 ^ j11), new zzaur(byteArrayOutputStream), true);
                byteArrayOutputStream.write(bArr);
                return;
            case 4:
                ArrayList arrayList = (ArrayList) o();
                zzats.b(arrayList.size(), new zzaur(byteArrayOutputStream), true);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((zzaus) it.next()).k(byteArrayOutputStream);
                }
                return;
            case 6:
                double dQ = q();
                zzaur zzaurVar = new zzaur(byteArrayOutputStream);
                long jDoubleToRawLongBits = Double.doubleToRawLongBits(dQ);
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
                byteBufferAllocate.putLong(jDoubleToRawLongBits);
                for (byte b2 : byteBufferAllocate.array()) {
                    zzaurVar.f24402a.write(b2);
                }
                int length = byteBufferAllocate.array().length;
                return;
            default:
                return;
        }
    }

    public final Object l() throws zzaup {
        int[] iArr = {427355115, 404248040, 1318670750, 874677346, 1819730563, -970011213, 126401947, 1858504292, 235745791};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        s(android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, iArr[5], iArr[6]) ^ (iArr[7] % 235745791));
        return this.f24403a;
    }

    public final long m() throws zzaup {
        int[] iArr = {1646478179, 763209928, 1529626135, 609321208, 1403807536, -1382063087, 25624641, 1388803074, 733327814};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        s(android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, iArr[5], iArr[6]) ^ (iArr[7] % 733327814));
        return this.f24404b;
    }

    public final zzatw n() throws zzaup {
        int[] iArr = {2059344234, 1917530355, 739411611, 1399403104, 95815174, 2094390031, 51245830, 1312994984, 1140384172};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        s(android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, iArr[5], iArr[6]) ^ (iArr[7] % 1140384172));
        return this.f24406d;
    }

    public final List o() throws zzaup {
        int[] iArr = {1435218189, 1093276829, 949583962, 1092752517, 575966040, -2054938211, 262178224, 1891252715, 1250801052};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        s(android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, iArr[5], iArr[6]) ^ (iArr[7] % 1250801052));
        return this.f24407e;
    }

    public final zzauk p() throws zzaup {
        int[] iArr = {672139932, 1821026951, 1629321417, 214090246, 828986457, -1439766056, 580508860, 1579068977, 395191309};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        s(android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, iArr[5], iArr[6]) ^ (iArr[7] % 395191309));
        return this.f24408f;
    }

    public final double q() throws zzaup {
        int[] iArr = {1714636915, 1758565445, 174653454, 1653642817, 38095532, -1976041400, 596516649, 1804289383, 846930886};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        s(android.support.v4.media.a.A((i3 & (~i2)) | i4, (i2 & i5) | i6, iArr[5], iArr[6]) ^ (iArr[7] % 846930886));
        return this.f24405c;
    }

    public final void r() {
        this.f24409g = 1;
        this.f24404b = 0L;
        this.f24403a = null;
        this.f24406d = null;
        this.f24407e = null;
        this.f24408f = null;
    }

    public final void s(int i2) throws zzaup {
        if (i2 != this.f24409g) {
            throw new zzaup();
        }
    }
}
