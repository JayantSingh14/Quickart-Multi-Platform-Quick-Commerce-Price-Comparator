package androidx.datastore.preferences.protobuf;

import android.support.v4.media.b;
import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.CodedOutputStream;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

@CheckReturnValue
/* loaded from: classes3.dex */
final class MessageSchema<T> implements Schema<T> {
    public static final int[] p = new int[0];
    public static final Unsafe q = UnsafeUtil.k();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f4081a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f4082b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4083c;

    /* renamed from: d, reason: collision with root package name */
    public final int f4084d;

    /* renamed from: e, reason: collision with root package name */
    public final MessageLite f4085e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f4086f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f4087g;

    /* renamed from: h, reason: collision with root package name */
    public final int[] f4088h;

    /* renamed from: i, reason: collision with root package name */
    public final int f4089i;

    /* renamed from: j, reason: collision with root package name */
    public final int f4090j;

    /* renamed from: k, reason: collision with root package name */
    public final NewInstanceSchema f4091k;

    /* renamed from: l, reason: collision with root package name */
    public final ListFieldSchema f4092l;

    /* renamed from: m, reason: collision with root package name */
    public final UnknownFieldSchema f4093m;
    public final ExtensionSchema n;
    public final MapFieldSchema o;

    /* renamed from: androidx.datastore.preferences.protobuf.MessageSchema$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4094a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f4094a = iArr;
            try {
                iArr[WireFormat.FieldType.f4201j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4094a[WireFormat.FieldType.n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4094a[WireFormat.FieldType.f4194c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4094a[WireFormat.FieldType.f4200i.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4094a[WireFormat.FieldType.q.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4094a[WireFormat.FieldType.f4199h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4094a[WireFormat.FieldType.r.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4094a[WireFormat.FieldType.f4195d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4094a[WireFormat.FieldType.p.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4094a[WireFormat.FieldType.f4198g.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4094a[WireFormat.FieldType.o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4094a[WireFormat.FieldType.f4196e.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f4094a[WireFormat.FieldType.f4197f.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f4094a[WireFormat.FieldType.f4204m.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f4094a[WireFormat.FieldType.s.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f4094a[WireFormat.FieldType.t.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f4094a[WireFormat.FieldType.f4202k.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public MessageSchema(int[] iArr, Object[] objArr, int i2, int i3, MessageLite messageLite, int[] iArr2, int i4, int i5, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema unknownFieldSchema, ExtensionSchema extensionSchema, MapFieldSchema mapFieldSchema) {
        this.f4081a = iArr;
        this.f4082b = objArr;
        this.f4083c = i2;
        this.f4084d = i3;
        this.f4087g = messageLite instanceof GeneratedMessageLite;
        this.f4086f = extensionSchema != null && extensionSchema.e(messageLite);
        this.f4088h = iArr2;
        this.f4089i = i4;
        this.f4090j = i5;
        this.f4091k = newInstanceSchema;
        this.f4092l = listFieldSchema;
        this.f4093m = unknownFieldSchema;
        this.n = extensionSchema;
        this.f4085e = messageLite;
        this.o = mapFieldSchema;
    }

    public static int A(long j2, Object obj) {
        return ((Integer) UnsafeUtil.f4183c.m(j2, obj)).intValue();
    }

    public static long B(long j2, Object obj) {
        return ((Long) UnsafeUtil.f4183c.m(j2, obj)).longValue();
    }

    public static java.lang.reflect.Field H(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            java.lang.reflect.Field[] declaredFields = cls.getDeclaredFields();
            for (java.lang.reflect.Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            StringBuilder sbY = b.y("Field ", str, " for ");
            sbY.append(cls.getName());
            sbY.append(" not found. Known fields are ");
            sbY.append(Arrays.toString(declaredFields));
            throw new RuntimeException(sbY.toString());
        }
    }

    public static int M(int i2) {
        return (i2 & 267386880) >>> 20;
    }

    public static void P(int i2, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.f(i2, (String) obj);
        } else {
            writer.j(i2, (ByteString) obj);
        }
    }

    public static boolean q(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).r();
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x037e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.datastore.preferences.protobuf.MessageSchema y(androidx.datastore.preferences.protobuf.RawMessageInfo r33, androidx.datastore.preferences.protobuf.NewInstanceSchema r34, androidx.datastore.preferences.protobuf.ListFieldSchema r35, androidx.datastore.preferences.protobuf.UnknownFieldSchema r36, androidx.datastore.preferences.protobuf.ExtensionSchema r37, androidx.datastore.preferences.protobuf.MapFieldSchema r38) {
        /*
            Method dump skipped, instructions count: 1005
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.y(androidx.datastore.preferences.protobuf.RawMessageInfo, androidx.datastore.preferences.protobuf.NewInstanceSchema, androidx.datastore.preferences.protobuf.ListFieldSchema, androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, androidx.datastore.preferences.protobuf.MapFieldSchema):androidx.datastore.preferences.protobuf.MessageSchema");
    }

    public static long z(int i2) {
        return i2 & 1048575;
    }

    public final int C(int i2) {
        if (i2 >= this.f4083c && i2 <= this.f4084d) {
            int[] iArr = this.f4081a;
            int length = (iArr.length / 3) - 1;
            int i3 = 0;
            while (i3 <= length) {
                int i4 = (length + i3) >>> 1;
                int i5 = i4 * 3;
                int i6 = iArr[i5];
                if (i2 == i6) {
                    return i5;
                }
                if (i2 < i6) {
                    length = i4 - 1;
                } else {
                    i3 = i4 + 1;
                }
            }
        }
        return -1;
    }

    public final void D(Object obj, long j2, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.J(this.f4092l.b(j2, obj), schema, extensionRegistryLite);
    }

    public final void E(Object obj, int i2, Reader reader, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.q(this.f4092l.b(i2 & 1048575, obj), schema, extensionRegistryLite);
    }

    public final void F(int i2, Reader reader, Object obj) {
        if ((536870912 & i2) != 0) {
            UnsafeUtil.r(obj, i2 & 1048575, reader.P());
        } else if (this.f4087g) {
            UnsafeUtil.r(obj, i2 & 1048575, reader.F());
        } else {
            UnsafeUtil.r(obj, i2 & 1048575, reader.o());
        }
    }

    public final void G(int i2, Reader reader, Object obj) {
        boolean z = (536870912 & i2) != 0;
        ListFieldSchema listFieldSchema = this.f4092l;
        if (z) {
            reader.n(listFieldSchema.b(i2 & 1048575, obj));
        } else {
            reader.H(listFieldSchema.b(i2 & 1048575, obj));
        }
    }

    public final void I(int i2, Object obj) {
        int i3 = this.f4081a[i2 + 2];
        long j2 = 1048575 & i3;
        if (j2 == 1048575) {
            return;
        }
        UnsafeUtil.p(obj, (1 << (i3 >>> 20)) | UnsafeUtil.f4183c.j(j2, obj), j2);
    }

    public final void J(int i2, int i3, Object obj) {
        UnsafeUtil.p(obj, i2, this.f4081a[i3 + 2] & 1048575);
    }

    public final void K(Object obj, int i2, MessageLite messageLite) {
        q.putObject(obj, N(i2) & 1048575, messageLite);
        I(i2, obj);
    }

    public final void L(Object obj, int i2, int i3, MessageLite messageLite) {
        q.putObject(obj, N(i3) & 1048575, messageLite);
        J(i2, i3, obj);
    }

    public final int N(int i2) {
        return this.f4081a[i2 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void O(java.lang.Object r21, androidx.datastore.preferences.protobuf.Writer r22) {
        /*
            Method dump skipped, instructions count: 1530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.O(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.Object r11, java.lang.Object r12) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.a(java.lang.Object, java.lang.Object):void");
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final void b(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.getClass();
        if (!q(obj)) {
            throw new IllegalArgumentException(b.j(obj, "Mutating immutable message: "));
        }
        s(this.f4093m, this.n, obj, reader, extensionRegistryLite);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.lang.Object r9) {
        /*
            r8 = this;
            boolean r0 = q(r9)
            if (r0 != 0) goto L8
            goto L8f
        L8:
            boolean r0 = r9 instanceof androidx.datastore.preferences.protobuf.GeneratedMessageLite
            r1 = 0
            if (r0 == 0) goto L1b
            r0 = r9
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r0 = (androidx.datastore.preferences.protobuf.GeneratedMessageLite) r0
            r2 = 2147483647(0x7fffffff, float:NaN)
            r0.k(r2)
            r0.memoizedHashCode = r1
            r0.s()
        L1b:
            int[] r0 = r8.f4081a
            int r2 = r0.length
        L1e:
            if (r1 >= r2) goto L81
            int r3 = r8.N(r1)
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r3
            long r4 = (long) r4
            int r3 = M(r3)
            r6 = 9
            if (r3 == r6) goto L6b
            r6 = 60
            if (r3 == r6) goto L55
            r6 = 68
            if (r3 == r6) goto L55
            switch(r3) {
                case 17: goto L6b;
                case 18: goto L4f;
                case 19: goto L4f;
                case 20: goto L4f;
                case 21: goto L4f;
                case 22: goto L4f;
                case 23: goto L4f;
                case 24: goto L4f;
                case 25: goto L4f;
                case 26: goto L4f;
                case 27: goto L4f;
                case 28: goto L4f;
                case 29: goto L4f;
                case 30: goto L4f;
                case 31: goto L4f;
                case 32: goto L4f;
                case 33: goto L4f;
                case 34: goto L4f;
                case 35: goto L4f;
                case 36: goto L4f;
                case 37: goto L4f;
                case 38: goto L4f;
                case 39: goto L4f;
                case 40: goto L4f;
                case 41: goto L4f;
                case 42: goto L4f;
                case 43: goto L4f;
                case 44: goto L4f;
                case 45: goto L4f;
                case 46: goto L4f;
                case 47: goto L4f;
                case 48: goto L4f;
                case 49: goto L4f;
                case 50: goto L3d;
                default: goto L3c;
            }
        L3c:
            goto L7e
        L3d:
            sun.misc.Unsafe r3 = androidx.datastore.preferences.protobuf.MessageSchema.q
            java.lang.Object r6 = r3.getObject(r9, r4)
            if (r6 == 0) goto L7e
            androidx.datastore.preferences.protobuf.MapFieldSchema r7 = r8.o
            java.lang.Object r6 = r7.e(r6)
            r3.putObject(r9, r4, r6)
            goto L7e
        L4f:
            androidx.datastore.preferences.protobuf.ListFieldSchema r3 = r8.f4092l
            r3.c(r4, r9)
            goto L7e
        L55:
            r3 = r0[r1]
            boolean r3 = r8.r(r3, r1, r9)
            if (r3 == 0) goto L7e
            androidx.datastore.preferences.protobuf.Schema r3 = r8.n(r1)
            sun.misc.Unsafe r6 = androidx.datastore.preferences.protobuf.MessageSchema.q
            java.lang.Object r4 = r6.getObject(r9, r4)
            r3.c(r4)
            goto L7e
        L6b:
            boolean r3 = r8.o(r1, r9)
            if (r3 == 0) goto L7e
            androidx.datastore.preferences.protobuf.Schema r3 = r8.n(r1)
            sun.misc.Unsafe r6 = androidx.datastore.preferences.protobuf.MessageSchema.q
            java.lang.Object r4 = r6.getObject(r9, r4)
            r3.c(r4)
        L7e:
            int r1 = r1 + 3
            goto L1e
        L81:
            androidx.datastore.preferences.protobuf.UnknownFieldSchema r0 = r8.f4093m
            r0.j(r9)
            boolean r0 = r8.f4086f
            if (r0 == 0) goto L8f
            androidx.datastore.preferences.protobuf.ExtensionSchema r0 = r8.n
            r0.f(r9)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.c(java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:141:0x037f A[PHI: r18
      0x037f: PHI (r18v48 int) = 
      (r18v31 int)
      (r18v32 int)
      (r18v33 int)
      (r18v37 int)
      (r18v39 int)
      (r18v40 int)
      (r18v41 int)
      (r18v45 int)
      (r18v49 int)
     binds: [B:215:0x053f, B:211:0x0523, B:207:0x0507, B:179:0x0476, B:161:0x0406, B:157:0x03ec, B:153:0x03d2, B:146:0x039c, B:140:0x037d] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int d(androidx.datastore.preferences.protobuf.AbstractMessageLite r20) {
        /*
            Method dump skipped, instructions count: 2050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.d(androidx.datastore.preferences.protobuf.AbstractMessageLite):int");
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean e(Object obj) {
        int i2;
        int i3;
        int i4;
        int i5 = 1048575;
        int i6 = 0;
        int i7 = 0;
        loop0: while (true) {
            if (i7 < this.f4089i) {
                int i8 = this.f4088h[i7];
                int[] iArr = this.f4081a;
                int i9 = iArr[i8];
                int iN = N(i8);
                int i10 = iArr[i8 + 2];
                int i11 = i10 & 1048575;
                int i12 = 1 << (i10 >>> 20);
                if (i11 != i5) {
                    if (i11 != 1048575) {
                        i6 = q.getInt(obj, i11);
                    }
                    i3 = i8;
                    i4 = i6;
                    i2 = i11;
                } else {
                    int i13 = i6;
                    i2 = i5;
                    i3 = i8;
                    i4 = i13;
                }
                if ((268435456 & iN) != 0 && !p(obj, i3, i2, i4, i12)) {
                    break;
                }
                int iM = M(iN);
                if (iM == 9 || iM == 17) {
                    if (p(obj, i3, i2, i4, i12)) {
                        if (!n(i3).e(UnsafeUtil.f4183c.m(iN & 1048575, obj))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                    i7++;
                    i5 = i2;
                    i6 = i4;
                } else {
                    if (iM != 27) {
                        if (iM == 60 || iM == 68) {
                            if (r(i9, i3, obj)) {
                                if (!n(i3).e(UnsafeUtil.f4183c.m(iN & 1048575, obj))) {
                                    break;
                                }
                            } else {
                                continue;
                            }
                            i7++;
                            i5 = i2;
                            i6 = i4;
                        } else if (iM != 49) {
                            if (iM != 50) {
                                continue;
                            } else {
                                Object objM = UnsafeUtil.f4183c.m(iN & 1048575, obj);
                                MapFieldSchema mapFieldSchema = this.o;
                                MapFieldLite mapFieldLiteD = mapFieldSchema.d(objM);
                                if (!mapFieldLiteD.isEmpty() && mapFieldSchema.b(m(i3)).f4074b.f4205a == WireFormat.JavaType.MESSAGE) {
                                    Schema schemaA = null;
                                    for (Object obj2 : mapFieldLiteD.values()) {
                                        if (schemaA == null) {
                                            schemaA = Protobuf.f4112c.a(obj2.getClass());
                                        }
                                        if (!schemaA.e(obj2)) {
                                            break loop0;
                                        }
                                    }
                                }
                            }
                            i7++;
                            i5 = i2;
                            i6 = i4;
                        }
                    }
                    List list = (List) UnsafeUtil.f4183c.m(iN & 1048575, obj);
                    if (list.isEmpty()) {
                        continue;
                    } else {
                        Schema schemaN = n(i3);
                        for (int i14 = 0; i14 < list.size(); i14++) {
                            if (!schemaN.e(list.get(i14))) {
                                break loop0;
                            }
                        }
                    }
                    i7++;
                    i5 = i2;
                    i6 = i4;
                }
            } else if (!this.f4086f || this.n.c(obj).g()) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final Object f() {
        return this.f4091k.a(this.f4085e);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00e4 A[PHI: r3
      0x00e4: PHI (r3v32 int) = (r3v10 int), (r3v33 int) binds: [B:84:0x0219, B:42:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int g(androidx.datastore.preferences.protobuf.GeneratedMessageLite r12) {
        /*
            Method dump skipped, instructions count: 814
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.g(androidx.datastore.preferences.protobuf.GeneratedMessageLite):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(java.lang.Object r13, androidx.datastore.preferences.protobuf.Writer r14) {
        /*
            Method dump skipped, instructions count: 1660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.h(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    @Override // androidx.datastore.preferences.protobuf.Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(androidx.datastore.preferences.protobuf.GeneratedMessageLite r12, androidx.datastore.preferences.protobuf.GeneratedMessageLite r13) {
        /*
            Method dump skipped, instructions count: 680
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.i(androidx.datastore.preferences.protobuf.GeneratedMessageLite, androidx.datastore.preferences.protobuf.GeneratedMessageLite):boolean");
    }

    public final boolean j(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2, int i2) {
        return o(i2, generatedMessageLite) == o(i2, generatedMessageLite2);
    }

    public final Object k(Object obj, int i2, Object obj2, UnknownFieldSchema unknownFieldSchema, Object obj3) {
        Internal.EnumVerifier enumVerifierL;
        int i3 = this.f4081a[i2];
        Object objM = UnsafeUtil.f4183c.m(N(i2) & 1048575, obj);
        if (objM == null || (enumVerifierL = l(i2)) == null) {
            return obj2;
        }
        MapFieldSchema mapFieldSchema = this.o;
        MapFieldLite mapFieldLiteC = mapFieldSchema.c(objM);
        MapEntryLite.Metadata metadataB = mapFieldSchema.b(m(i2));
        Iterator it = mapFieldLiteC.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!enumVerifierL.a(((Integer) entry.getValue()).intValue())) {
                if (obj2 == null) {
                    obj2 = unknownFieldSchema.f(obj3);
                }
                ByteString.CodedBuilder codedBuilder = new ByteString.CodedBuilder(MapEntryLite.a(metadataB, entry.getKey(), entry.getValue()));
                CodedOutputStream codedOutputStream = codedBuilder.f3756a;
                try {
                    MapEntryLite.b(codedOutputStream, metadataB, entry.getKey(), entry.getValue());
                    CodedOutputStream.ArrayEncoder arrayEncoder = (CodedOutputStream.ArrayEncoder) codedOutputStream;
                    if (arrayEncoder.f3808e - arrayEncoder.f3809f != 0) {
                        throw new IllegalStateException("Did not write as much data as expected.");
                    }
                    unknownFieldSchema.d(obj2, i3, new ByteString.LiteralByteString(codedBuilder.f3757b));
                    it.remove();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }
        return obj2;
    }

    public final Internal.EnumVerifier l(int i2) {
        return (Internal.EnumVerifier) this.f4082b[((i2 / 3) * 2) + 1];
    }

    public final Object m(int i2) {
        return this.f4082b[(i2 / 3) * 2];
    }

    public final Schema n(int i2) {
        int i3 = (i2 / 3) * 2;
        Object[] objArr = this.f4082b;
        Schema schema = (Schema) objArr[i3];
        if (schema != null) {
            return schema;
        }
        Schema schemaA = Protobuf.f4112c.a((Class) objArr[i3 + 1]);
        objArr[i3] = schemaA;
        return schemaA;
    }

    public final boolean o(int i2, Object obj) {
        int i3 = this.f4081a[i2 + 2];
        long j2 = i3 & 1048575;
        if (j2 == 1048575) {
            int iN = N(i2);
            long j3 = iN & 1048575;
            switch (M(iN)) {
                case 0:
                    if (Double.doubleToRawLongBits(UnsafeUtil.f4183c.h(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (Float.floatToRawIntBits(UnsafeUtil.f4183c.i(j3, obj)) == 0) {
                        return false;
                    }
                    break;
                case 2:
                    if (UnsafeUtil.f4183c.l(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 3:
                    if (UnsafeUtil.f4183c.l(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 4:
                    if (UnsafeUtil.f4183c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 5:
                    if (UnsafeUtil.f4183c.l(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 6:
                    if (UnsafeUtil.f4183c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 7:
                    return UnsafeUtil.f4183c.e(j3, obj);
                case 8:
                    Object objM = UnsafeUtil.f4183c.m(j3, obj);
                    if (objM instanceof String) {
                        return !((String) objM).isEmpty();
                    }
                    if (objM instanceof ByteString) {
                        return !ByteString.f3748b.equals(objM);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    if (UnsafeUtil.f4183c.m(j3, obj) == null) {
                        return false;
                    }
                    break;
                case 10:
                    return !ByteString.f3748b.equals(UnsafeUtil.f4183c.m(j3, obj));
                case 11:
                    if (UnsafeUtil.f4183c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 12:
                    if (UnsafeUtil.f4183c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 13:
                    if (UnsafeUtil.f4183c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 14:
                    if (UnsafeUtil.f4183c.l(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 15:
                    if (UnsafeUtil.f4183c.j(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 16:
                    if (UnsafeUtil.f4183c.l(j3, obj) == 0) {
                        return false;
                    }
                    break;
                case 17:
                    if (UnsafeUtil.f4183c.m(j3, obj) == null) {
                        return false;
                    }
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } else if (((1 << (i3 >>> 20)) & UnsafeUtil.f4183c.j(j2, obj)) == 0) {
            return false;
        }
        return true;
    }

    public final boolean p(Object obj, int i2, int i3, int i4, int i5) {
        return i3 == 1048575 ? o(i2, obj) : (i4 & i5) != 0;
    }

    public final boolean r(int i2, int i3, Object obj) {
        return UnsafeUtil.f4183c.j((long) (this.f4081a[i3 + 2] & 1048575), obj) == i2;
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    public final void s(androidx.datastore.preferences.protobuf.UnknownFieldSchema r19, androidx.datastore.preferences.protobuf.ExtensionSchema r20, java.lang.Object r21, androidx.datastore.preferences.protobuf.Reader r22, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r23) {
        /*
            Method dump skipped, instructions count: 2212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.MessageSchema.s(androidx.datastore.preferences.protobuf.UnknownFieldSchema, androidx.datastore.preferences.protobuf.ExtensionSchema, java.lang.Object, androidx.datastore.preferences.protobuf.Reader, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    public final void t(Object obj, int i2, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long jN = N(i2) & 1048575;
        Object objM = UnsafeUtil.f4183c.m(jN, obj);
        MapFieldSchema mapFieldSchema = this.o;
        if (objM == null) {
            objM = mapFieldSchema.f();
            UnsafeUtil.r(obj, jN, objM);
        } else if (mapFieldSchema.h(objM)) {
            MapFieldLite mapFieldLiteF = mapFieldSchema.f();
            mapFieldSchema.a(mapFieldLiteF, objM);
            UnsafeUtil.r(obj, jN, mapFieldLiteF);
            objM = mapFieldLiteF;
        }
        reader.B(mapFieldSchema.c(objM), mapFieldSchema.b(obj2), extensionRegistryLite);
    }

    public final void u(int i2, Object obj, Object obj2) {
        if (o(i2, obj2)) {
            long jN = N(i2) & 1048575;
            Unsafe unsafe = q;
            Object object = unsafe.getObject(obj2, jN);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f4081a[i2] + " is present but null: " + obj2);
            }
            Schema schemaN = n(i2);
            if (!o(i2, obj)) {
                if (q(object)) {
                    Object objF = schemaN.f();
                    schemaN.a(objF, object);
                    unsafe.putObject(obj, jN, objF);
                } else {
                    unsafe.putObject(obj, jN, object);
                }
                I(i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jN);
            if (!q(object2)) {
                Object objF2 = schemaN.f();
                schemaN.a(objF2, object2);
                unsafe.putObject(obj, jN, objF2);
                object2 = objF2;
            }
            schemaN.a(object2, object);
        }
    }

    public final void v(int i2, Object obj, Object obj2) {
        int[] iArr = this.f4081a;
        int i3 = iArr[i2];
        if (r(i3, i2, obj2)) {
            long jN = N(i2) & 1048575;
            Unsafe unsafe = q;
            Object object = unsafe.getObject(obj2, jN);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + iArr[i2] + " is present but null: " + obj2);
            }
            Schema schemaN = n(i2);
            if (!r(i3, i2, obj)) {
                if (q(object)) {
                    Object objF = schemaN.f();
                    schemaN.a(objF, object);
                    unsafe.putObject(obj, jN, objF);
                } else {
                    unsafe.putObject(obj, jN, object);
                }
                J(i3, i2, obj);
                return;
            }
            Object object2 = unsafe.getObject(obj, jN);
            if (!q(object2)) {
                Object objF2 = schemaN.f();
                schemaN.a(objF2, object2);
                unsafe.putObject(obj, jN, objF2);
                object2 = objF2;
            }
            schemaN.a(object2, object);
        }
    }

    public final Object w(int i2, Object obj) {
        Schema schemaN = n(i2);
        long jN = N(i2) & 1048575;
        if (!o(i2, obj)) {
            return schemaN.f();
        }
        Object object = q.getObject(obj, jN);
        if (q(object)) {
            return object;
        }
        Object objF = schemaN.f();
        if (object != null) {
            schemaN.a(objF, object);
        }
        return objF;
    }

    public final Object x(int i2, int i3, Object obj) {
        Schema schemaN = n(i3);
        if (!r(i2, i3, obj)) {
            return schemaN.f();
        }
        Object object = q.getObject(obj, N(i3) & 1048575);
        if (q(object)) {
            return object;
        }
        Object objF = schemaN.f();
        if (object != null) {
            schemaN.a(objF, object);
        }
        return objF;
    }
}
