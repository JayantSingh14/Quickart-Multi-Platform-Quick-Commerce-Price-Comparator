package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.WireFormat;
import com.google.android.gms.common.api.Api;
import java.util.List;

@CheckReturnValue
/* loaded from: classes3.dex */
final class CodedInputStreamReader implements Reader {

    /* renamed from: a, reason: collision with root package name */
    public final CodedInputStream f3796a;

    /* renamed from: b, reason: collision with root package name */
    public int f3797b;

    /* renamed from: c, reason: collision with root package name */
    public int f3798c;

    /* renamed from: d, reason: collision with root package name */
    public int f3799d = 0;

    /* renamed from: androidx.datastore.preferences.protobuf.CodedInputStreamReader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3800a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f3800a = iArr;
            try {
                iArr[WireFormat.FieldType.f4201j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3800a[WireFormat.FieldType.n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3800a[WireFormat.FieldType.f4194c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3800a[WireFormat.FieldType.p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3800a[WireFormat.FieldType.f4200i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3800a[WireFormat.FieldType.f4199h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3800a[WireFormat.FieldType.f4195d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3800a[WireFormat.FieldType.f4198g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3800a[WireFormat.FieldType.f4196e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3800a[WireFormat.FieldType.f4204m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3800a[WireFormat.FieldType.q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3800a[WireFormat.FieldType.r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3800a[WireFormat.FieldType.s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3800a[WireFormat.FieldType.t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3800a[WireFormat.FieldType.f4202k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3800a[WireFormat.FieldType.o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3800a[WireFormat.FieldType.f4197f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public CodedInputStreamReader(CodedInputStream codedInputStream) {
        Internal.a(codedInputStream, "input");
        this.f3796a = codedInputStream;
        codedInputStream.f3762b = this;
    }

    public static void W(int i2) throws InvalidProtocolBufferException {
        if ((i2 & 3) != 0) {
            throw InvalidProtocolBufferException.f();
        }
    }

    public static void X(int i2) throws InvalidProtocolBufferException {
        if ((i2 & 7) != 0) {
            throw InvalidProtocolBufferException.f();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void A(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(codedInputStream.o()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iB = codedInputStream.b() + codedInputStream.x();
            do {
                list.add(Integer.valueOf(codedInputStream.o()));
            } while (codedInputStream.b() < iB);
            U(iB);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 0) {
            do {
                intArrayList.d(codedInputStream.o());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iB2 = codedInputStream.b() + codedInputStream.x();
        do {
            intArrayList.d(codedInputStream.o());
        } while (codedInputStream.b() < iB2);
        U(iB2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r10.put(r3, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r1.f(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        return;
     */
    @Override // androidx.datastore.preferences.protobuf.Reader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void B(java.util.Map r10, androidx.datastore.preferences.protobuf.MapEntryLite.Metadata r11, androidx.datastore.preferences.protobuf.ExtensionRegistryLite r12) throws androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException {
        /*
            r9 = this;
            r0 = 2
            r9.V(r0)
            androidx.datastore.preferences.protobuf.CodedInputStream r1 = r9.f3796a
            int r2 = r1.x()
            int r2 = r1.g(r2)
            r11.getClass()
            java.lang.String r3 = ""
            androidx.datastore.preferences.protobuf.GeneratedMessageLite r4 = r11.f4075c
            r5 = r4
        L16:
            int r6 = r9.G()     // Catch: java.lang.Throwable -> L3a
            r7 = 2147483647(0x7fffffff, float:NaN)
            if (r6 == r7) goto L5c
            boolean r7 = r1.c()     // Catch: java.lang.Throwable -> L3a
            if (r7 == 0) goto L26
            goto L5c
        L26:
            r7 = 1
            java.lang.String r8 = "Unable to parse map entry."
            if (r6 == r7) goto L47
            if (r6 == r0) goto L3c
            boolean r6 = r9.K()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            if (r6 == 0) goto L34
            goto L16
        L34:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r6 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            r6.<init>(r8)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            throw r6     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
        L3a:
            r10 = move-exception
            goto L63
        L3c:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r6 = r11.f4074b     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            java.lang.Class r7 = r4.getClass()     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            java.lang.Object r5 = r9.S(r6, r7, r12)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            goto L16
        L47:
            androidx.datastore.preferences.protobuf.WireFormat$FieldType r6 = r11.f4073a     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            r7 = 0
            java.lang.Object r3 = r9.S(r6, r7, r7)     // Catch: java.lang.Throwable -> L3a androidx.datastore.preferences.protobuf.InvalidProtocolBufferException.InvalidWireTypeException -> L4f
            goto L16
        L4f:
            boolean r6 = r9.K()     // Catch: java.lang.Throwable -> L3a
            if (r6 == 0) goto L56
            goto L16
        L56:
            androidx.datastore.preferences.protobuf.InvalidProtocolBufferException r10 = new androidx.datastore.preferences.protobuf.InvalidProtocolBufferException     // Catch: java.lang.Throwable -> L3a
            r10.<init>(r8)     // Catch: java.lang.Throwable -> L3a
            throw r10     // Catch: java.lang.Throwable -> L3a
        L5c:
            r10.put(r3, r5)     // Catch: java.lang.Throwable -> L3a
            r1.f(r2)
            return
        L63:
            r1.f(r2)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.CodedInputStreamReader.B(java.util.Map, androidx.datastore.preferences.protobuf.MapEntryLite$Metadata, androidx.datastore.preferences.protobuf.ExtensionRegistryLite):void");
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void C(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(3);
        Q(obj, schema, extensionRegistryLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void D(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 2) {
                int iX = codedInputStream.x();
                W(iX);
                int iB = codedInputStream.b() + iX;
                do {
                    list.add(Integer.valueOf(codedInputStream.l()));
                } while (codedInputStream.b() < iB);
                return;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Integer.valueOf(codedInputStream.l()));
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW = codedInputStream.w();
                }
            } while (iW == this.f3797b);
            this.f3799d = iW;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 2) {
            int iX2 = codedInputStream.x();
            W(iX2);
            int iB2 = codedInputStream.b() + iX2;
            do {
                intArrayList.d(codedInputStream.l());
            } while (codedInputStream.b() < iB2);
            return;
        }
        if (i3 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            intArrayList.d(codedInputStream.l());
            if (codedInputStream.c()) {
                return;
            } else {
                iW2 = codedInputStream.w();
            }
        } while (iW2 == this.f3797b);
        this.f3799d = iW2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final long E() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(0);
        return this.f3796a.t();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final String F() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(2);
        return this.f3796a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final int G() {
        int i2 = this.f3799d;
        if (i2 != 0) {
            this.f3797b = i2;
            this.f3799d = 0;
        } else {
            this.f3797b = this.f3796a.w();
        }
        int i3 = this.f3797b;
        return (i3 == 0 || i3 == this.f3798c) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : i3 >>> 3;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void H(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        T(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void I(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof FloatArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 2) {
                int iX = codedInputStream.x();
                W(iX);
                int iB = codedInputStream.b() + iX;
                do {
                    list.add(Float.valueOf(codedInputStream.n()));
                } while (codedInputStream.b() < iB);
                return;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Float.valueOf(codedInputStream.n()));
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW = codedInputStream.w();
                }
            } while (iW == this.f3797b);
            this.f3799d = iW;
            return;
        }
        FloatArrayList floatArrayList = (FloatArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 2) {
            int iX2 = codedInputStream.x();
            W(iX2);
            int iB2 = codedInputStream.b() + iX2;
            do {
                floatArrayList.d(codedInputStream.n());
            } while (codedInputStream.b() < iB2);
            return;
        }
        if (i3 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            floatArrayList.d(codedInputStream.n());
            if (codedInputStream.c()) {
                return;
            } else {
                iW2 = codedInputStream.w();
            }
        } while (iW2 == this.f3797b);
        this.f3799d = iW2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void J(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iW;
        int i2 = this.f3797b;
        if ((i2 & 7) != 3) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            Object objF = schema.f();
            Q(objF, schema, extensionRegistryLite);
            schema.c(objF);
            list.add(objF);
            CodedInputStream codedInputStream = this.f3796a;
            if (codedInputStream.c() || this.f3799d != 0) {
                return;
            } else {
                iW = codedInputStream.w();
            }
        } while (iW == i2);
        this.f3799d = iW;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final boolean K() {
        int i2;
        CodedInputStream codedInputStream = this.f3796a;
        if (codedInputStream.c() || (i2 = this.f3797b) == this.f3798c) {
            return false;
        }
        return codedInputStream.z(i2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final int L() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(5);
        return this.f3796a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void M(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iW;
        if ((this.f3797b & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            list.add(o());
            CodedInputStream codedInputStream = this.f3796a;
            if (codedInputStream.c()) {
                return;
            } else {
                iW = codedInputStream.w();
            }
        } while (iW == this.f3797b);
        this.f3799d = iW;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void N(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof DoubleArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(codedInputStream.j()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iX = codedInputStream.x();
            X(iX);
            int iB = codedInputStream.b() + iX;
            do {
                list.add(Double.valueOf(codedInputStream.j()));
            } while (codedInputStream.b() < iB);
            return;
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 1) {
            do {
                doubleArrayList.d(codedInputStream.j());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iX2 = codedInputStream.x();
        X(iX2);
        int iB2 = codedInputStream.b() + iX2;
        do {
            doubleArrayList.d(codedInputStream.j());
        } while (codedInputStream.b() < iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final long O() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(0);
        return this.f3796a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final String P() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(2);
        return this.f3796a.v();
    }

    public final void Q(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
        int i2 = this.f3798c;
        this.f3798c = ((this.f3797b >>> 3) << 3) | 4;
        try {
            schema.b(obj, this, extensionRegistryLite);
            if (this.f3797b == this.f3798c) {
            } else {
                throw InvalidProtocolBufferException.f();
            }
        } finally {
            this.f3798c = i2;
        }
    }

    public final void R(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        CodedInputStream codedInputStream = this.f3796a;
        int iX = codedInputStream.x();
        if (codedInputStream.f3761a >= 100) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int iG = codedInputStream.g(iX);
        codedInputStream.f3761a++;
        schema.b(obj, this, extensionRegistryLite);
        codedInputStream.a(0);
        codedInputStream.f3761a--;
        codedInputStream.f(iG);
    }

    public final Object S(WireFormat.FieldType fieldType, Class cls, ExtensionRegistryLite extensionRegistryLite) {
        switch (fieldType.ordinal()) {
            case 0:
                return Double.valueOf(readDouble());
            case 1:
                return Float.valueOf(readFloat());
            case 2:
                return Long.valueOf(O());
            case 3:
                return Long.valueOf(t());
            case 4:
                return Integer.valueOf(p());
            case 5:
                return Long.valueOf(a());
            case 6:
                return Integer.valueOf(w());
            case 7:
                return Boolean.valueOf(d());
            case 8:
                return P();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                return u(cls, extensionRegistryLite);
            case 11:
                return o();
            case 12:
                return Integer.valueOf(g());
            case 13:
                return Integer.valueOf(k());
            case 14:
                return Integer.valueOf(L());
            case 15:
                return Long.valueOf(e());
            case 16:
                return Integer.valueOf(l());
            case 17:
                return Long.valueOf(E());
        }
    }

    public final void T(List list, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iW;
        int iW2;
        if ((this.f3797b & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        boolean z2 = list instanceof LazyStringList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z2 || z) {
            do {
                list.add(z ? P() : F());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW = codedInputStream.w();
                }
            } while (iW == this.f3797b);
            this.f3799d = iW;
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        do {
            lazyStringList.T0(o());
            if (codedInputStream.c()) {
                return;
            } else {
                iW2 = codedInputStream.w();
            }
        } while (iW2 == this.f3797b);
        this.f3799d = iW2;
    }

    public final void U(int i2) throws InvalidProtocolBufferException {
        if (this.f3796a.b() != i2) {
            throw InvalidProtocolBufferException.g();
        }
    }

    public final void V(int i2) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if ((this.f3797b & 7) != i2) {
            throw InvalidProtocolBufferException.c();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final long a() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(1);
        return this.f3796a.m();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void b(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 2) {
                int iX = codedInputStream.x();
                W(iX);
                int iB = codedInputStream.b() + iX;
                do {
                    list.add(Integer.valueOf(codedInputStream.q()));
                } while (codedInputStream.b() < iB);
                return;
            }
            if (i2 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            do {
                list.add(Integer.valueOf(codedInputStream.q()));
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW = codedInputStream.w();
                }
            } while (iW == this.f3797b);
            this.f3799d = iW;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 2) {
            int iX2 = codedInputStream.x();
            W(iX2);
            int iB2 = codedInputStream.b() + iX2;
            do {
                intArrayList.d(codedInputStream.q());
            } while (codedInputStream.b() < iB2);
            return;
        }
        if (i3 != 5) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            intArrayList.d(codedInputStream.q());
            if (codedInputStream.c()) {
                return;
            } else {
                iW2 = codedInputStream.w();
            }
        } while (iW2 == this.f3797b);
        this.f3799d = iW2;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void c(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(codedInputStream.t()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iB = codedInputStream.b() + codedInputStream.x();
            do {
                list.add(Long.valueOf(codedInputStream.t()));
            } while (codedInputStream.b() < iB);
            U(iB);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 0) {
            do {
                longArrayList.d(codedInputStream.t());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iB2 = codedInputStream.b() + codedInputStream.x();
        do {
            longArrayList.d(codedInputStream.t());
        } while (codedInputStream.b() < iB2);
        U(iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final boolean d() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(0);
        return this.f3796a.h();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final long e() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(1);
        return this.f3796a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void f(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(codedInputStream.y()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iB = codedInputStream.b() + codedInputStream.x();
            do {
                list.add(Long.valueOf(codedInputStream.y()));
            } while (codedInputStream.b() < iB);
            U(iB);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 0) {
            do {
                longArrayList.d(codedInputStream.y());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iB2 = codedInputStream.b() + codedInputStream.x();
        do {
            longArrayList.d(codedInputStream.y());
        } while (codedInputStream.b() < iB2);
        U(iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final int g() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(0);
        return this.f3796a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void h(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(codedInputStream.p()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iB = codedInputStream.b() + codedInputStream.x();
            do {
                list.add(Long.valueOf(codedInputStream.p()));
            } while (codedInputStream.b() < iB);
            U(iB);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 0) {
            do {
                longArrayList.d(codedInputStream.p());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iB2 = codedInputStream.b() + codedInputStream.x();
        do {
            longArrayList.d(codedInputStream.p());
        } while (codedInputStream.b() < iB2);
        U(iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void i(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        V(2);
        R(obj, schema, extensionRegistryLite);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void j(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(codedInputStream.k()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iB = codedInputStream.b() + codedInputStream.x();
            do {
                list.add(Integer.valueOf(codedInputStream.k()));
            } while (codedInputStream.b() < iB);
            U(iB);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 0) {
            do {
                intArrayList.d(codedInputStream.k());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iB2 = codedInputStream.b() + codedInputStream.x();
        do {
            intArrayList.d(codedInputStream.k());
        } while (codedInputStream.b() < iB2);
        U(iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final int k() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(0);
        return this.f3796a.k();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final int l() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(0);
        return this.f3796a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void m(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof BooleanArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(codedInputStream.h()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iB = codedInputStream.b() + codedInputStream.x();
            do {
                list.add(Boolean.valueOf(codedInputStream.h()));
            } while (codedInputStream.b() < iB);
            U(iB);
            return;
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 0) {
            do {
                booleanArrayList.d(codedInputStream.h());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iB2 = codedInputStream.b() + codedInputStream.x();
        do {
            booleanArrayList.d(codedInputStream.h());
        } while (codedInputStream.b() < iB2);
        U(iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void n(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        T(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final ByteString o() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(2);
        return this.f3796a.i();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final int p() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(0);
        return this.f3796a.o();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void q(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int iW;
        int i2 = this.f3797b;
        if ((i2 & 7) != 2) {
            throw InvalidProtocolBufferException.c();
        }
        do {
            Object objF = schema.f();
            R(objF, schema, extensionRegistryLite);
            schema.c(objF);
            list.add(objF);
            CodedInputStream codedInputStream = this.f3796a;
            if (codedInputStream.c() || this.f3799d != 0) {
                return;
            } else {
                iW = codedInputStream.w();
            }
        } while (iW == i2);
        this.f3799d = iW;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void r(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(codedInputStream.m()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iX = codedInputStream.x();
            X(iX);
            int iB = codedInputStream.b() + iX;
            do {
                list.add(Long.valueOf(codedInputStream.m()));
            } while (codedInputStream.b() < iB);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 1) {
            do {
                longArrayList.d(codedInputStream.m());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iX2 = codedInputStream.x();
        X(iX2);
        int iB2 = codedInputStream.b() + iX2;
        do {
            longArrayList.d(codedInputStream.m());
        } while (codedInputStream.b() < iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(1);
        return this.f3796a.j();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(5);
        return this.f3796a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void s(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(codedInputStream.s()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iB = codedInputStream.b() + codedInputStream.x();
            do {
                list.add(Integer.valueOf(codedInputStream.s()));
            } while (codedInputStream.b() < iB);
            U(iB);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 0) {
            do {
                intArrayList.d(codedInputStream.s());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iB2 = codedInputStream.b() + codedInputStream.x();
        do {
            intArrayList.d(codedInputStream.s());
        } while (codedInputStream.b() < iB2);
        U(iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final long t() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(0);
        return this.f3796a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final Object u(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        V(2);
        Schema schemaA = Protobuf.f4112c.a(cls);
        Object objF = schemaA.f();
        R(objF, schemaA, extensionRegistryLite);
        schemaA.c(objF);
        return objF;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void v(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof IntArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(codedInputStream.x()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iB = codedInputStream.b() + codedInputStream.x();
            do {
                list.add(Integer.valueOf(codedInputStream.x()));
            } while (codedInputStream.b() < iB);
            U(iB);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 0) {
            do {
                intArrayList.d(codedInputStream.x());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iB2 = codedInputStream.b() + codedInputStream.x();
        do {
            intArrayList.d(codedInputStream.x());
        } while (codedInputStream.b() < iB2);
        U(iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final int w() throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(5);
        return this.f3796a.l();
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final Object x(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        V(3);
        Schema schemaA = Protobuf.f4112c.a(cls);
        Object objF = schemaA.f();
        Q(objF, schemaA, extensionRegistryLite);
        schemaA.c(objF);
        return objF;
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final void y(List list) throws InvalidProtocolBufferException {
        int iW;
        int iW2;
        boolean z = list instanceof LongArrayList;
        CodedInputStream codedInputStream = this.f3796a;
        if (!z) {
            int i2 = this.f3797b & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(codedInputStream.r()));
                    if (codedInputStream.c()) {
                        return;
                    } else {
                        iW = codedInputStream.w();
                    }
                } while (iW == this.f3797b);
                this.f3799d = iW;
                return;
            }
            if (i2 != 2) {
                throw InvalidProtocolBufferException.c();
            }
            int iX = codedInputStream.x();
            X(iX);
            int iB = codedInputStream.b() + iX;
            do {
                list.add(Long.valueOf(codedInputStream.r()));
            } while (codedInputStream.b() < iB);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int i3 = this.f3797b & 7;
        if (i3 == 1) {
            do {
                longArrayList.d(codedInputStream.r());
                if (codedInputStream.c()) {
                    return;
                } else {
                    iW2 = codedInputStream.w();
                }
            } while (iW2 == this.f3797b);
            this.f3799d = iW2;
            return;
        }
        if (i3 != 2) {
            throw InvalidProtocolBufferException.c();
        }
        int iX2 = codedInputStream.x();
        X(iX2);
        int iB2 = codedInputStream.b() + iX2;
        do {
            longArrayList.d(codedInputStream.r());
        } while (codedInputStream.b() < iB2);
    }

    @Override // androidx.datastore.preferences.protobuf.Reader
    public final int z() {
        return this.f3797b;
    }
}
