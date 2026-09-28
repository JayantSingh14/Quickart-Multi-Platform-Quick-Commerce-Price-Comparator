package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.MapEntryLite;
import androidx.datastore.preferences.protobuf.WireFormat;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes3.dex */
abstract class BinaryReader implements Reader {

    /* renamed from: androidx.datastore.preferences.protobuf.BinaryReader$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3738a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f3738a = iArr;
            try {
                iArr[WireFormat.FieldType.f4201j.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3738a[WireFormat.FieldType.n.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3738a[WireFormat.FieldType.f4194c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3738a[WireFormat.FieldType.p.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3738a[WireFormat.FieldType.f4200i.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3738a[WireFormat.FieldType.f4199h.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3738a[WireFormat.FieldType.f4195d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3738a[WireFormat.FieldType.f4198g.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3738a[WireFormat.FieldType.f4196e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f3738a[WireFormat.FieldType.f4204m.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3738a[WireFormat.FieldType.q.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3738a[WireFormat.FieldType.r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f3738a[WireFormat.FieldType.s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f3738a[WireFormat.FieldType.t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f3738a[WireFormat.FieldType.f4202k.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f3738a[WireFormat.FieldType.o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f3738a[WireFormat.FieldType.f4197f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public static final class SafeHeapReader extends BinaryReader {
        public static void R(int i2) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (i2 != 0) {
                throw InvalidProtocolBufferException.c();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void A(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (list instanceof IntArrayList) {
                p();
                throw null;
            }
            p();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void B(Map map, MapEntryLite.Metadata metadata, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void C(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            schema.b(obj, this, extensionRegistryLite);
            throw InvalidProtocolBufferException.f();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void D(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (!(list instanceof IntArrayList)) {
                throw InvalidProtocolBufferException.c();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final long E() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final String F() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final int G() {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void H(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void I(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (!(list instanceof FloatArrayList)) {
                throw InvalidProtocolBufferException.c();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void J(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final boolean K() {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final int L() throws InvalidProtocolBufferException {
            R(5);
            Q(4);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void M(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void N(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (!(list instanceof DoubleArrayList)) {
                throw InvalidProtocolBufferException.c();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final long O() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final String P() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(2);
            throw null;
        }

        public final void Q(int i2) throws InvalidProtocolBufferException {
            if (i2 < 0) {
                throw InvalidProtocolBufferException.g();
            }
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final long a() throws InvalidProtocolBufferException {
            R(1);
            Q(8);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void b(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (!(list instanceof IntArrayList)) {
                throw InvalidProtocolBufferException.c();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void c(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (list instanceof LongArrayList) {
                E();
                throw null;
            }
            E();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final boolean d() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final long e() throws InvalidProtocolBufferException {
            R(1);
            Q(8);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void f(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (list instanceof LongArrayList) {
                t();
                throw null;
            }
            t();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final int g() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void h(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (list instanceof LongArrayList) {
                O();
                throw null;
            }
            O();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void i(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite) {
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void j(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (list instanceof IntArrayList) {
                k();
                throw null;
            }
            k();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final int k() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final int l() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void m(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (list instanceof BooleanArrayList) {
                d();
                throw null;
            }
            d();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void n(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final ByteString o() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(2);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final int p() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void q(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void r(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (!(list instanceof LongArrayList)) {
                throw InvalidProtocolBufferException.c();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final double readDouble() throws InvalidProtocolBufferException {
            R(1);
            Q(8);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final float readFloat() throws InvalidProtocolBufferException {
            R(5);
            Q(4);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void s(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (list instanceof IntArrayList) {
                l();
                throw null;
            }
            l();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final long t() throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(0);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final Object u(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            R(2);
            Protobuf.f4112c.a(cls).f();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void v(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (list instanceof IntArrayList) {
                g();
                throw null;
            }
            g();
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final int w() throws InvalidProtocolBufferException {
            R(5);
            Q(4);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final Object x(Class cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            R(3);
            Schema schemaA = Protobuf.f4112c.a(cls);
            C(schemaA.f(), schemaA, extensionRegistryLite);
            throw null;
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final void y(List list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (!(list instanceof LongArrayList)) {
                throw InvalidProtocolBufferException.c();
            }
            throw InvalidProtocolBufferException.c();
        }

        @Override // androidx.datastore.preferences.protobuf.Reader
        public final int z() {
            return 0;
        }
    }
}
