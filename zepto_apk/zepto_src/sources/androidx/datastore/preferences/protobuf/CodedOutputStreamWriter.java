package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@CheckReturnValue
/* loaded from: classes3.dex */
final class CodedOutputStreamWriter implements Writer {

    /* renamed from: a, reason: collision with root package name */
    public final CodedOutputStream f3812a;

    /* renamed from: androidx.datastore.preferences.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3813a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f3813a = iArr;
            try {
                iArr[WireFormat.FieldType.f4201j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3813a[WireFormat.FieldType.f4200i.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3813a[WireFormat.FieldType.f4198g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3813a[WireFormat.FieldType.q.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3813a[WireFormat.FieldType.s.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3813a[WireFormat.FieldType.o.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3813a[WireFormat.FieldType.f4199h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3813a[WireFormat.FieldType.f4196e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3813a[WireFormat.FieldType.r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3813a[WireFormat.FieldType.t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3813a[WireFormat.FieldType.f4197f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3813a[WireFormat.FieldType.f4202k.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        Internal.a(codedOutputStream, "output");
        this.f3812a = codedOutputStream;
        codedOutputStream.f3803a = this;
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void A(int i2, Object obj) {
        this.f3812a.k0(i2, (MessageLite) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void B(float f2, int i2) {
        CodedOutputStream codedOutputStream = this.f3812a;
        codedOutputStream.getClass();
        codedOutputStream.c(i2, Float.floatToRawIntBits(f2));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void C(int i2, long j2) {
        this.f3812a.g(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void D(int i2, boolean z) {
        this.f3812a.D(i2, z);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void E(int i2, int i3) {
        this.f3812a.c(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void F(int i2) {
        this.f3812a.q0(i2, 3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void G(int i2, List list, boolean z) {
        boolean z2 = list instanceof LongArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.x(i2, ((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Long) list.get(i5)).getClass();
                Logger logger = CodedOutputStream.f3801b;
                i4 += 8;
            }
            codedOutputStream.r0(i4);
            while (i3 < list.size()) {
                codedOutputStream.i0(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        if (!z) {
            while (i3 < longArrayList.f4067c) {
                codedOutputStream.x(i2, longArrayList.g(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < longArrayList.f4067c; i7++) {
            longArrayList.g(i7);
            Logger logger2 = CodedOutputStream.f3801b;
            i6 += 8;
        }
        codedOutputStream.r0(i6);
        while (i3 < longArrayList.f4067c) {
            codedOutputStream.i0(longArrayList.g(i3));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void H(int i2, List list, boolean z) {
        boolean z2 = list instanceof IntArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.c(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).getClass();
                Logger logger = CodedOutputStream.f3801b;
                i4 += 4;
            }
            codedOutputStream.r0(i4);
            while (i3 < list.size()) {
                codedOutputStream.h0(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            while (i3 < intArrayList.f4023c) {
                codedOutputStream.c(i2, intArrayList.getInt(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < intArrayList.f4023c; i7++) {
            intArrayList.getInt(i7);
            Logger logger2 = CodedOutputStream.f3801b;
            i6 += 4;
        }
        codedOutputStream.r0(i6);
        while (i3 < intArrayList.f4023c) {
            codedOutputStream.h0(intArrayList.getInt(i3));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void I(int i2, List list, boolean z) {
        boolean z2 = list instanceof BooleanArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.D(i2, ((Boolean) list.get(i3)).booleanValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Boolean) list.get(i5)).getClass();
                Logger logger = CodedOutputStream.f3801b;
                i4++;
            }
            codedOutputStream.r0(i4);
            while (i3 < list.size()) {
                codedOutputStream.e0(((Boolean) list.get(i3)).booleanValue() ? (byte) 1 : (byte) 0);
                i3++;
            }
            return;
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        if (!z) {
            while (i3 < booleanArrayList.f3747c) {
                codedOutputStream.D(i2, booleanArrayList.getBoolean(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < booleanArrayList.f3747c; i7++) {
            booleanArrayList.getBoolean(i7);
            Logger logger2 = CodedOutputStream.f3801b;
            i6++;
        }
        codedOutputStream.r0(i6);
        while (i3 < booleanArrayList.f3747c) {
            codedOutputStream.e0(booleanArrayList.getBoolean(i3) ? (byte) 1 : (byte) 0);
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void J(int i2) {
        this.f3812a.q0(i2, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void K(int i2, List list, boolean z) {
        boolean z2 = list instanceof IntArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.t(i2, CodedOutputStream.b0(((Integer) list.get(i3)).intValue()));
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int iV = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iV += CodedOutputStream.V(((Integer) list.get(i4)).intValue());
            }
            codedOutputStream.r0(iV);
            while (i3 < list.size()) {
                codedOutputStream.r0(CodedOutputStream.b0(((Integer) list.get(i3)).intValue()));
                i3++;
            }
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            while (i3 < intArrayList.f4023c) {
                codedOutputStream.t(i2, CodedOutputStream.b0(intArrayList.getInt(i3)));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int iV2 = 0;
        for (int i5 = 0; i5 < intArrayList.f4023c; i5++) {
            iV2 += CodedOutputStream.V(intArrayList.getInt(i5));
        }
        codedOutputStream.r0(iV2);
        while (i3 < intArrayList.f4023c) {
            codedOutputStream.r0(CodedOutputStream.b0(intArrayList.getInt(i3)));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void L(int i2, int i3) {
        this.f3812a.i(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void M(int i2, List list, boolean z) {
        boolean z2 = list instanceof LongArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.g(i2, ((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int iA0 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iA0 += CodedOutputStream.a0(((Long) list.get(i4)).longValue());
            }
            codedOutputStream.r0(iA0);
            while (i3 < list.size()) {
                codedOutputStream.s0(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        if (!z) {
            while (i3 < longArrayList.f4067c) {
                codedOutputStream.g(i2, longArrayList.g(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int iA02 = 0;
        for (int i5 = 0; i5 < longArrayList.f4067c; i5++) {
            iA02 += CodedOutputStream.a0(longArrayList.g(i5));
        }
        codedOutputStream.r0(iA02);
        while (i3 < longArrayList.f4067c) {
            codedOutputStream.s0(longArrayList.g(i3));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void N(int i2, List list, boolean z) {
        boolean z2 = list instanceof DoubleArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    double dDoubleValue = ((Double) list.get(i3)).doubleValue();
                    codedOutputStream.getClass();
                    codedOutputStream.x(i2, Double.doubleToRawLongBits(dDoubleValue));
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Double) list.get(i5)).getClass();
                Logger logger = CodedOutputStream.f3801b;
                i4 += 8;
            }
            codedOutputStream.r0(i4);
            while (i3 < list.size()) {
                codedOutputStream.i0(Double.doubleToRawLongBits(((Double) list.get(i3)).doubleValue()));
                i3++;
            }
            return;
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        if (!z) {
            while (i3 < doubleArrayList.f3941c) {
                double d2 = doubleArrayList.getDouble(i3);
                codedOutputStream.getClass();
                codedOutputStream.x(i2, Double.doubleToRawLongBits(d2));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < doubleArrayList.f3941c; i7++) {
            doubleArrayList.getDouble(i7);
            Logger logger2 = CodedOutputStream.f3801b;
            i6 += 8;
        }
        codedOutputStream.r0(i6);
        while (i3 < doubleArrayList.f3941c) {
            codedOutputStream.i0(Double.doubleToRawLongBits(doubleArrayList.getDouble(i3)));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void O(int i2, int i3) {
        this.f3812a.t(i2, CodedOutputStream.b0(i3));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void P(int i2, List list) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f3812a.j(i2, (ByteString) list.get(i3));
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void a(int i2, List list, boolean z) {
        boolean z2 = list instanceof FloatArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    float fFloatValue = ((Float) list.get(i3)).floatValue();
                    codedOutputStream.getClass();
                    codedOutputStream.c(i2, Float.floatToRawIntBits(fFloatValue));
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Float) list.get(i5)).getClass();
                Logger logger = CodedOutputStream.f3801b;
                i4 += 4;
            }
            codedOutputStream.r0(i4);
            while (i3 < list.size()) {
                codedOutputStream.h0(Float.floatToRawIntBits(((Float) list.get(i3)).floatValue()));
                i3++;
            }
            return;
        }
        FloatArrayList floatArrayList = (FloatArrayList) list;
        if (!z) {
            while (i3 < floatArrayList.f4003c) {
                float fG = floatArrayList.g(i3);
                codedOutputStream.getClass();
                codedOutputStream.c(i2, Float.floatToRawIntBits(fG));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < floatArrayList.f4003c; i7++) {
            floatArrayList.g(i7);
            Logger logger2 = CodedOutputStream.f3801b;
            i6 += 4;
        }
        codedOutputStream.r0(i6);
        while (i3 < floatArrayList.f4003c) {
            codedOutputStream.h0(Float.floatToRawIntBits(floatArrayList.g(i3)));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void b(int i2, Object obj) {
        boolean z = obj instanceof ByteString;
        CodedOutputStream codedOutputStream = this.f3812a;
        if (z) {
            codedOutputStream.o0(i2, (ByteString) obj);
        } else {
            codedOutputStream.n0(i2, (MessageLite) obj);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void c(int i2, int i3) {
        this.f3812a.c(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void d(int i2, List list) {
        boolean z = list instanceof LazyStringList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z) {
            while (i3 < list.size()) {
                codedOutputStream.f(i2, (String) list.get(i3));
                i3++;
            }
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        while (i3 < list.size()) {
            Object objJ1 = lazyStringList.J1(i3);
            if (objJ1 instanceof String) {
                codedOutputStream.f(i2, (String) objJ1);
            } else {
                codedOutputStream.j(i2, (ByteString) objJ1);
            }
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void e(int i2, List list, Schema schema) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            s(i2, list.get(i3), schema);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void f(int i2, String str) {
        this.f3812a.f(i2, str);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void g(int i2, long j2) {
        this.f3812a.g(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void h(int i2, List list, boolean z) {
        boolean z2 = list instanceof IntArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.i(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int iA0 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iA0 += CodedOutputStream.a0(((Integer) list.get(i4)).intValue());
            }
            codedOutputStream.r0(iA0);
            while (i3 < list.size()) {
                codedOutputStream.j0(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            while (i3 < intArrayList.f4023c) {
                codedOutputStream.i(i2, intArrayList.getInt(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int iA02 = 0;
        for (int i5 = 0; i5 < intArrayList.f4023c; i5++) {
            iA02 += CodedOutputStream.a0(intArrayList.getInt(i5));
        }
        codedOutputStream.r0(iA02);
        while (i3 < intArrayList.f4023c) {
            codedOutputStream.j0(intArrayList.getInt(i3));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void i(int i2, int i3) {
        this.f3812a.i(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void j(int i2, ByteString byteString) {
        this.f3812a.j(i2, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void k(int i2, long j2) {
        this.f3812a.x(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void l(int i2, List list, boolean z) {
        boolean z2 = list instanceof IntArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.c(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Integer) list.get(i5)).getClass();
                Logger logger = CodedOutputStream.f3801b;
                i4 += 4;
            }
            codedOutputStream.r0(i4);
            while (i3 < list.size()) {
                codedOutputStream.h0(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            while (i3 < intArrayList.f4023c) {
                codedOutputStream.c(i2, intArrayList.getInt(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < intArrayList.f4023c; i7++) {
            intArrayList.getInt(i7);
            Logger logger2 = CodedOutputStream.f3801b;
            i6 += 4;
        }
        codedOutputStream.r0(i6);
        while (i3 < intArrayList.f4023c) {
            codedOutputStream.h0(intArrayList.getInt(i3));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void m(int i2, Object obj, Schema schema) {
        this.f3812a.l0(i2, (MessageLite) obj, schema);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void n(int i2, List list, boolean z) {
        boolean z2 = list instanceof IntArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.t(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int iZ = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iZ += CodedOutputStream.Z(((Integer) list.get(i4)).intValue());
            }
            codedOutputStream.r0(iZ);
            while (i3 < list.size()) {
                codedOutputStream.r0(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            while (i3 < intArrayList.f4023c) {
                codedOutputStream.t(i2, intArrayList.getInt(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int iZ2 = 0;
        for (int i5 = 0; i5 < intArrayList.f4023c; i5++) {
            iZ2 += CodedOutputStream.Z(intArrayList.getInt(i5));
        }
        codedOutputStream.r0(iZ2);
        while (i3 < intArrayList.f4023c) {
            codedOutputStream.r0(intArrayList.getInt(i3));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void o(int i2, List list, boolean z) {
        boolean z2 = list instanceof LongArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.g(i2, CodedOutputStream.c0(((Long) list.get(i3)).longValue()));
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int iW = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iW += CodedOutputStream.W(((Long) list.get(i4)).longValue());
            }
            codedOutputStream.r0(iW);
            while (i3 < list.size()) {
                codedOutputStream.s0(CodedOutputStream.c0(((Long) list.get(i3)).longValue()));
                i3++;
            }
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        if (!z) {
            while (i3 < longArrayList.f4067c) {
                codedOutputStream.g(i2, CodedOutputStream.c0(longArrayList.g(i3)));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int iW2 = 0;
        for (int i5 = 0; i5 < longArrayList.f4067c; i5++) {
            iW2 += CodedOutputStream.W(longArrayList.g(i5));
        }
        codedOutputStream.r0(iW2);
        while (i3 < longArrayList.f4067c) {
            codedOutputStream.s0(CodedOutputStream.c0(longArrayList.g(i3)));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void p(int i2, long j2) {
        this.f3812a.g(i2, CodedOutputStream.c0(j2));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void q(int i2, List list, boolean z) {
        boolean z2 = list instanceof IntArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.i(i2, ((Integer) list.get(i3)).intValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int iA0 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iA0 += CodedOutputStream.a0(((Integer) list.get(i4)).intValue());
            }
            codedOutputStream.r0(iA0);
            while (i3 < list.size()) {
                codedOutputStream.j0(((Integer) list.get(i3)).intValue());
                i3++;
            }
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        if (!z) {
            while (i3 < intArrayList.f4023c) {
                codedOutputStream.i(i2, intArrayList.getInt(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int iA02 = 0;
        for (int i5 = 0; i5 < intArrayList.f4023c; i5++) {
            iA02 += CodedOutputStream.a0(intArrayList.getInt(i5));
        }
        codedOutputStream.r0(iA02);
        while (i3 < intArrayList.f4023c) {
            codedOutputStream.j0(intArrayList.getInt(i3));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void r(int i2, MapEntryLite.Metadata metadata, Map map) {
        CodedOutputStream codedOutputStream = this.f3812a;
        codedOutputStream.getClass();
        for (Map.Entry entry : map.entrySet()) {
            codedOutputStream.q0(i2, 2);
            codedOutputStream.r0(MapEntryLite.a(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.b(codedOutputStream, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void s(int i2, Object obj, Schema schema) {
        CodedOutputStream codedOutputStream = this.f3812a;
        codedOutputStream.q0(i2, 3);
        schema.h((MessageLite) obj, codedOutputStream.f3803a);
        codedOutputStream.q0(i2, 4);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void t(int i2, int i3) {
        this.f3812a.t(i2, i3);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void u(int i2, double d2) {
        CodedOutputStream codedOutputStream = this.f3812a;
        codedOutputStream.getClass();
        codedOutputStream.x(i2, Double.doubleToRawLongBits(d2));
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void v(int i2, List list, boolean z) {
        boolean z2 = list instanceof LongArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.x(i2, ((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                ((Long) list.get(i5)).getClass();
                Logger logger = CodedOutputStream.f3801b;
                i4 += 8;
            }
            codedOutputStream.r0(i4);
            while (i3 < list.size()) {
                codedOutputStream.i0(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        if (!z) {
            while (i3 < longArrayList.f4067c) {
                codedOutputStream.x(i2, longArrayList.g(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int i6 = 0;
        for (int i7 = 0; i7 < longArrayList.f4067c; i7++) {
            longArrayList.g(i7);
            Logger logger2 = CodedOutputStream.f3801b;
            i6 += 8;
        }
        codedOutputStream.r0(i6);
        while (i3 < longArrayList.f4067c) {
            codedOutputStream.i0(longArrayList.g(i3));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void w(int i2, List list, boolean z) {
        boolean z2 = list instanceof LongArrayList;
        CodedOutputStream codedOutputStream = this.f3812a;
        int i3 = 0;
        if (!z2) {
            if (!z) {
                while (i3 < list.size()) {
                    codedOutputStream.g(i2, ((Long) list.get(i3)).longValue());
                    i3++;
                }
                return;
            }
            codedOutputStream.q0(i2, 2);
            int iA0 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                iA0 += CodedOutputStream.a0(((Long) list.get(i4)).longValue());
            }
            codedOutputStream.r0(iA0);
            while (i3 < list.size()) {
                codedOutputStream.s0(((Long) list.get(i3)).longValue());
                i3++;
            }
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        if (!z) {
            while (i3 < longArrayList.f4067c) {
                codedOutputStream.g(i2, longArrayList.g(i3));
                i3++;
            }
            return;
        }
        codedOutputStream.q0(i2, 2);
        int iA02 = 0;
        for (int i5 = 0; i5 < longArrayList.f4067c; i5++) {
            iA02 += CodedOutputStream.a0(longArrayList.g(i5));
        }
        codedOutputStream.r0(iA02);
        while (i3 < longArrayList.f4067c) {
            codedOutputStream.s0(longArrayList.g(i3));
            i3++;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void x(int i2, long j2) {
        this.f3812a.x(i2, j2);
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final Writer.FieldOrder y() {
        return Writer.FieldOrder.f4219a;
    }

    @Override // androidx.datastore.preferences.protobuf.Writer
    public final void z(int i2, List list, Schema schema) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            m(i2, list.get(i3), schema);
        }
    }
}
