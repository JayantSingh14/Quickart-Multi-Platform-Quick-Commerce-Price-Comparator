package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.LazyField;
import androidx.datastore.preferences.protobuf.MessageLite;
import androidx.datastore.preferences.protobuf.SmallSortedMap;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/* loaded from: classes3.dex */
final class FieldSet<T extends FieldDescriptorLite<T>> {

    /* renamed from: d, reason: collision with root package name */
    public static final FieldSet f3979d = new FieldSet(0);

    /* renamed from: a, reason: collision with root package name */
    public final SmallSortedMap.AnonymousClass1 f3980a = SmallSortedMap.g();

    /* renamed from: b, reason: collision with root package name */
    public boolean f3981b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3982c;

    /* renamed from: androidx.datastore.preferences.protobuf.FieldSet$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3983a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f3984b;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f3984b = iArr;
            try {
                iArr[WireFormat.FieldType.f4194c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3984b[WireFormat.FieldType.f4195d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3984b[WireFormat.FieldType.f4196e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3984b[WireFormat.FieldType.f4197f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3984b[WireFormat.FieldType.f4198g.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3984b[WireFormat.FieldType.f4199h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3984b[WireFormat.FieldType.f4200i.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3984b[WireFormat.FieldType.f4201j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3984b[WireFormat.FieldType.f4203l.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3984b[WireFormat.FieldType.f4204m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3984b[WireFormat.FieldType.f4202k.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3984b[WireFormat.FieldType.n.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3984b[WireFormat.FieldType.o.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3984b[WireFormat.FieldType.q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3984b[WireFormat.FieldType.r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3984b[WireFormat.FieldType.s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3984b[WireFormat.FieldType.t.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f3984b[WireFormat.FieldType.p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[WireFormat.JavaType.values().length];
            f3983a = iArr2;
            try {
                WireFormat.JavaType javaType = WireFormat.JavaType.INT;
                iArr2[0] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                int[] iArr3 = f3983a;
                WireFormat.JavaType javaType2 = WireFormat.JavaType.INT;
                iArr3[1] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                int[] iArr4 = f3983a;
                WireFormat.JavaType javaType3 = WireFormat.JavaType.INT;
                iArr4[2] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                int[] iArr5 = f3983a;
                WireFormat.JavaType javaType4 = WireFormat.JavaType.INT;
                iArr5[3] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                int[] iArr6 = f3983a;
                WireFormat.JavaType javaType5 = WireFormat.JavaType.INT;
                iArr6[4] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                int[] iArr7 = f3983a;
                WireFormat.JavaType javaType6 = WireFormat.JavaType.INT;
                iArr7[5] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f3983a[WireFormat.JavaType.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f3983a[WireFormat.JavaType.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f3983a[WireFormat.JavaType.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    public static final class Builder<T extends FieldDescriptorLite<T>> {
    }

    public interface FieldDescriptorLite<T extends FieldDescriptorLite<T>> extends Comparable<T> {
        int f();

        GeneratedMessageLite.Builder k(MessageLite.Builder builder, MessageLite messageLite);

        boolean m();

        WireFormat.FieldType o();

        WireFormat.JavaType v();

        boolean w();
    }

    public FieldSet() {
    }

    public static int b(WireFormat.FieldType fieldType, int i2, Object obj) {
        int iY = CodedOutputStream.Y(i2);
        if (fieldType == WireFormat.FieldType.f4203l) {
            iY *= 2;
        }
        return iY + c(fieldType, obj);
    }

    public static int c(WireFormat.FieldType fieldType, Object obj) {
        int iC;
        int iZ;
        switch (fieldType.ordinal()) {
            case 0:
                ((Double) obj).getClass();
                Logger logger = CodedOutputStream.f3801b;
                return 8;
            case 1:
                ((Float) obj).getClass();
                Logger logger2 = CodedOutputStream.f3801b;
                return 4;
            case 2:
                return CodedOutputStream.a0(((Long) obj).longValue());
            case 3:
                return CodedOutputStream.a0(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.a0(((Integer) obj).intValue());
            case 5:
                ((Long) obj).getClass();
                Logger logger3 = CodedOutputStream.f3801b;
                return 8;
            case 6:
                ((Integer) obj).getClass();
                Logger logger4 = CodedOutputStream.f3801b;
                return 4;
            case 7:
                ((Boolean) obj).getClass();
                Logger logger5 = CodedOutputStream.f3801b;
                return 1;
            case 8:
                return obj instanceof ByteString ? CodedOutputStream.T((ByteString) obj) : CodedOutputStream.X((String) obj);
            case 9:
                Logger logger6 = CodedOutputStream.f3801b;
                return ((MessageLite) obj).c();
            case 10:
                if (!(obj instanceof LazyField)) {
                    Logger logger7 = CodedOutputStream.f3801b;
                    iC = ((MessageLite) obj).c();
                    iZ = CodedOutputStream.Z(iC);
                    break;
                } else {
                    return CodedOutputStream.U((LazyField) obj);
                }
            case 11:
                if (!(obj instanceof ByteString)) {
                    Logger logger8 = CodedOutputStream.f3801b;
                    iC = ((byte[]) obj).length;
                    iZ = CodedOutputStream.Z(iC);
                    break;
                } else {
                    return CodedOutputStream.T((ByteString) obj);
                }
            case 12:
                return CodedOutputStream.Z(((Integer) obj).intValue());
            case 13:
                return obj instanceof Internal.EnumLite ? CodedOutputStream.a0(((Internal.EnumLite) obj).f()) : CodedOutputStream.a0(((Integer) obj).intValue());
            case 14:
                ((Integer) obj).getClass();
                Logger logger9 = CodedOutputStream.f3801b;
                return 4;
            case 15:
                ((Long) obj).getClass();
                Logger logger10 = CodedOutputStream.f3801b;
                return 8;
            case 16:
                return CodedOutputStream.V(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.W(((Long) obj).longValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
        return iZ + iC;
    }

    public static int d(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        WireFormat.FieldType fieldTypeO = fieldDescriptorLite.o();
        int iF = fieldDescriptorLite.f();
        if (!fieldDescriptorLite.m()) {
            return b(fieldTypeO, iF, obj);
        }
        List list = (List) obj;
        int size = list.size();
        int i2 = 0;
        if (!fieldDescriptorLite.w()) {
            int iB = 0;
            while (i2 < size) {
                iB += b(fieldTypeO, iF, list.get(i2));
                i2++;
            }
            return iB;
        }
        if (list.isEmpty()) {
            return 0;
        }
        int iC = 0;
        while (i2 < size) {
            iC += c(fieldTypeO, list.get(i2));
            i2++;
        }
        return CodedOutputStream.Z(iC) + CodedOutputStream.Y(iF) + iC;
    }

    public static int f(Map.Entry entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        if (fieldDescriptorLite.v() != WireFormat.JavaType.MESSAGE || fieldDescriptorLite.m() || fieldDescriptorLite.w()) {
            return d(fieldDescriptorLite, value);
        }
        if (value instanceof LazyField) {
            int iF = ((FieldDescriptorLite) entry.getKey()).f();
            return CodedOutputStream.U((LazyField) value) + CodedOutputStream.Y(3) + CodedOutputStream.Z(iF) + CodedOutputStream.Y(2) + (CodedOutputStream.Y(1) * 2);
        }
        int iF2 = ((FieldDescriptorLite) entry.getKey()).f();
        int iZ = CodedOutputStream.Z(iF2) + CodedOutputStream.Y(2) + (CodedOutputStream.Y(1) * 2);
        int iY = CodedOutputStream.Y(3);
        int iC = ((MessageLite) value).c();
        return CodedOutputStream.Z(iC) + iC + iY + iZ;
    }

    public static boolean h(Map.Entry entry) {
        boolean zD;
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        if (fieldDescriptorLite.v() == WireFormat.JavaType.MESSAGE) {
            if (!fieldDescriptorLite.m()) {
                Object value = entry.getValue();
                if (value instanceof MessageLiteOrBuilder) {
                    return ((MessageLiteOrBuilder) value).d();
                }
                if (value instanceof LazyField) {
                    return true;
                }
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list = (List) entry.getValue();
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                Object obj = list.get(i2);
                if (obj instanceof MessageLiteOrBuilder) {
                    zD = ((MessageLiteOrBuilder) obj).d();
                } else {
                    if (!(obj instanceof LazyField)) {
                        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                    }
                    zD = true;
                }
                if (!zD) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m(androidx.datastore.preferences.protobuf.FieldSet.FieldDescriptorLite r3, java.lang.Object r4) {
        /*
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r0 = r3.o()
            java.nio.charset.Charset r1 = androidx.datastore.preferences.protobuf.Internal.f4024a
            r4.getClass()
            androidx.datastore.preferences.protobuf.WireFormat$JavaType r0 = r0.f4205a
            int r0 = r0.ordinal()
            r1 = 1
            r2 = 0
            switch(r0) {
                case 0: goto L40;
                case 1: goto L3d;
                case 2: goto L3a;
                case 3: goto L37;
                case 4: goto L34;
                case 5: goto L31;
                case 6: goto L28;
                case 7: goto L1f;
                case 8: goto L16;
                default: goto L14;
            }
        L14:
            r1 = r2
            goto L42
        L16:
            boolean r0 = r4 instanceof androidx.datastore.preferences.protobuf.MessageLite
            if (r0 != 0) goto L42
            boolean r0 = r4 instanceof androidx.datastore.preferences.protobuf.LazyField
            if (r0 == 0) goto L14
            goto L42
        L1f:
            boolean r0 = r4 instanceof java.lang.Integer
            if (r0 != 0) goto L42
            boolean r0 = r4 instanceof androidx.datastore.preferences.protobuf.Internal.EnumLite
            if (r0 == 0) goto L14
            goto L42
        L28:
            boolean r0 = r4 instanceof androidx.datastore.preferences.protobuf.ByteString
            if (r0 != 0) goto L42
            boolean r0 = r4 instanceof byte[]
            if (r0 == 0) goto L14
            goto L42
        L31:
            boolean r1 = r4 instanceof java.lang.String
            goto L42
        L34:
            boolean r1 = r4 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r1 = r4 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r1 = r4 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r1 = r4 instanceof java.lang.Long
            goto L42
        L40:
            boolean r1 = r4 instanceof java.lang.Integer
        L42:
            if (r1 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            int r1 = r3.f()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r3 = r3.o()
            androidx.datastore.preferences.protobuf.WireFormat$JavaType r3 = r3.f4205a
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            java.lang.Object[] r3 = new java.lang.Object[]{r1, r3, r4}
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r3 = java.lang.String.format(r4, r3)
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.FieldSet.m(androidx.datastore.preferences.protobuf.FieldSet$FieldDescriptorLite, java.lang.Object):void");
    }

    public static void n(CodedOutputStream codedOutputStream, WireFormat.FieldType fieldType, int i2, Object obj) {
        if (fieldType == WireFormat.FieldType.f4203l) {
            codedOutputStream.q0(i2, 3);
            ((MessageLite) obj).g(codedOutputStream);
            codedOutputStream.q0(i2, 4);
        }
        codedOutputStream.q0(i2, fieldType.f4206b);
        switch (fieldType.ordinal()) {
            case 0:
                codedOutputStream.i0(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                codedOutputStream.h0(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                codedOutputStream.s0(((Long) obj).longValue());
                break;
            case 3:
                codedOutputStream.s0(((Long) obj).longValue());
                break;
            case 4:
                codedOutputStream.j0(((Integer) obj).intValue());
                break;
            case 5:
                codedOutputStream.i0(((Long) obj).longValue());
                break;
            case 6:
                codedOutputStream.h0(((Integer) obj).intValue());
                break;
            case 7:
                codedOutputStream.e0(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof ByteString)) {
                    codedOutputStream.p0((String) obj);
                    break;
                } else {
                    codedOutputStream.g0((ByteString) obj);
                    break;
                }
            case 9:
                ((MessageLite) obj).g(codedOutputStream);
                break;
            case 10:
                codedOutputStream.m0((MessageLite) obj);
                break;
            case 11:
                if (!(obj instanceof ByteString)) {
                    byte[] bArr = (byte[]) obj;
                    codedOutputStream.f0(bArr.length, bArr);
                    break;
                } else {
                    codedOutputStream.g0((ByteString) obj);
                    break;
                }
            case 12:
                codedOutputStream.r0(((Integer) obj).intValue());
                break;
            case 13:
                if (!(obj instanceof Internal.EnumLite)) {
                    codedOutputStream.j0(((Integer) obj).intValue());
                    break;
                } else {
                    codedOutputStream.j0(((Internal.EnumLite) obj).f());
                    break;
                }
            case 14:
                codedOutputStream.h0(((Integer) obj).intValue());
                break;
            case 15:
                codedOutputStream.i0(((Long) obj).longValue());
                break;
            case 16:
                codedOutputStream.r0(CodedOutputStream.b0(((Integer) obj).intValue()));
                break;
            case 17:
                codedOutputStream.s0(CodedOutputStream.c0(((Long) obj).longValue()));
                break;
        }
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final FieldSet clone() {
        FieldSet fieldSet = new FieldSet();
        SmallSortedMap.AnonymousClass1 anonymousClass1 = this.f3980a;
        int size = anonymousClass1.f4142a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Map.Entry entryC = anonymousClass1.c(i2);
            fieldSet.l((FieldDescriptorLite) entryC.getKey(), entryC.getValue());
        }
        for (Map.Entry entry : anonymousClass1.d()) {
            fieldSet.l((FieldDescriptorLite) entry.getKey(), entry.getValue());
        }
        fieldSet.f3982c = this.f3982c;
        return fieldSet;
    }

    public final Object e(FieldDescriptorLite fieldDescriptorLite) {
        Object obj = this.f3980a.get(fieldDescriptorLite);
        return obj instanceof LazyField ? ((LazyField) obj).a(null) : obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FieldSet) {
            return this.f3980a.equals(((FieldSet) obj).f3980a);
        }
        return false;
    }

    public final boolean g() {
        SmallSortedMap.AnonymousClass1 anonymousClass1 = this.f3980a;
        int size = anonymousClass1.f4142a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                Iterator it = anonymousClass1.d().iterator();
                while (it.hasNext()) {
                    if (!h((Map.Entry) it.next())) {
                    }
                }
                return true;
            }
            if (!h(anonymousClass1.c(i2))) {
                break;
            }
            i2++;
        }
        return false;
    }

    public final int hashCode() {
        return this.f3980a.hashCode();
    }

    public final Iterator i() {
        SmallSortedMap.AnonymousClass1 anonymousClass1 = this.f3980a;
        return anonymousClass1.isEmpty() ? Collections.emptyIterator() : this.f3982c ? new LazyField.LazyIterator(((SmallSortedMap.EntrySet) anonymousClass1.entrySet()).iterator()) : ((SmallSortedMap.EntrySet) anonymousClass1.entrySet()).iterator();
    }

    public final void j() {
        if (this.f3981b) {
            return;
        }
        SmallSortedMap.AnonymousClass1 anonymousClass1 = this.f3980a;
        int size = anonymousClass1.f4142a.size();
        for (int i2 = 0; i2 < size; i2++) {
            Map.Entry entryC = anonymousClass1.c(i2);
            if (entryC.getValue() instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) entryC.getValue();
                generatedMessageLite.getClass();
                Protobuf protobuf = Protobuf.f4112c;
                protobuf.getClass();
                protobuf.a(generatedMessageLite.getClass()).c(generatedMessageLite);
                generatedMessageLite.s();
            }
        }
        anonymousClass1.f();
        this.f3981b = true;
    }

    public final void k(Map.Entry entry) {
        FieldDescriptorLite fieldDescriptorLite = (FieldDescriptorLite) entry.getKey();
        Object value = entry.getValue();
        boolean z = value instanceof LazyField;
        boolean zM = fieldDescriptorLite.m();
        SmallSortedMap.AnonymousClass1 anonymousClass1 = this.f3980a;
        if (zM) {
            if (z) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            Object objE = e(fieldDescriptorLite);
            if (objE == null) {
                objE = new ArrayList();
            }
            for (Object obj : (List) value) {
                List list = (List) objE;
                if (obj instanceof byte[]) {
                    byte[] bArr = (byte[]) obj;
                    byte[] bArr2 = new byte[bArr.length];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    obj = bArr2;
                }
                list.add(obj);
            }
            anonymousClass1.put(fieldDescriptorLite, objE);
            return;
        }
        if (fieldDescriptorLite.v() != WireFormat.JavaType.MESSAGE) {
            if (z) {
                throw new IllegalStateException("Lazy fields must be message-valued");
            }
            if (value instanceof byte[]) {
                byte[] bArr3 = (byte[]) value;
                byte[] bArr4 = new byte[bArr3.length];
                System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
                value = bArr4;
            }
            anonymousClass1.put(fieldDescriptorLite, value);
            return;
        }
        Object objE2 = e(fieldDescriptorLite);
        if (objE2 != null) {
            if (z) {
                value = ((LazyField) value).a(null);
            }
            anonymousClass1.put(fieldDescriptorLite, fieldDescriptorLite.k(((MessageLite) objE2).a(), (MessageLite) value).i());
            return;
        }
        if (value instanceof byte[]) {
            byte[] bArr5 = (byte[]) value;
            byte[] bArr6 = new byte[bArr5.length];
            System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
            value = bArr6;
        }
        anonymousClass1.put(fieldDescriptorLite, value);
        if (z) {
            this.f3982c = true;
        }
    }

    public final void l(FieldDescriptorLite fieldDescriptorLite, Object obj) {
        if (!fieldDescriptorLite.m()) {
            m(fieldDescriptorLite, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m(fieldDescriptorLite, it.next());
            }
            obj = arrayList;
        }
        if (obj instanceof LazyField) {
            this.f3982c = true;
        }
        this.f3980a.put(fieldDescriptorLite, obj);
    }

    public FieldSet(int i2) {
        j();
        j();
    }
}
