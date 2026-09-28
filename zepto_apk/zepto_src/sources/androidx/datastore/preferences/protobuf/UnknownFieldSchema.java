package androidx.datastore.preferences.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
abstract class UnknownFieldSchema<T, B> {
    public abstract void a(int i2, int i3, Object obj);

    public abstract void b(Object obj, int i2, long j2);

    public abstract void c(int i2, Object obj, Object obj2);

    public abstract void d(Object obj, int i2, ByteString byteString);

    public abstract void e(Object obj, int i2, long j2);

    public abstract UnknownFieldSetLite f(Object obj);

    public abstract UnknownFieldSetLite g(Object obj);

    public abstract int h(Object obj);

    public abstract int i(Object obj);

    public abstract void j(Object obj);

    public abstract UnknownFieldSetLite k(Object obj, Object obj2);

    public final boolean l(int i2, Reader reader, Object obj) throws InvalidProtocolBufferException {
        int iZ = reader.z();
        int i3 = iZ >>> 3;
        int i4 = iZ & 7;
        if (i4 == 0) {
            e(obj, i3, reader.O());
            return true;
        }
        if (i4 == 1) {
            b(obj, i3, reader.a());
            return true;
        }
        if (i4 == 2) {
            d(obj, i3, reader.o());
            return true;
        }
        if (i4 != 3) {
            if (i4 == 4) {
                return false;
            }
            if (i4 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            a(i3, reader.w(), obj);
            return true;
        }
        UnknownFieldSetLite unknownFieldSetLiteM = m();
        int i5 = (i3 << 3) | 4;
        int i6 = i2 + 1;
        if (i6 >= 100) {
            throw new InvalidProtocolBufferException("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (reader.G() != Integer.MAX_VALUE && l(i6, reader, unknownFieldSetLiteM)) {
        }
        if (i5 != reader.z()) {
            throw InvalidProtocolBufferException.a();
        }
        c(i3, obj, p(unknownFieldSetLiteM));
        return true;
    }

    public abstract UnknownFieldSetLite m();

    public abstract void n(Object obj, Object obj2);

    public abstract void o(Object obj, Object obj2);

    public abstract UnknownFieldSetLite p(Object obj);

    public abstract void q(Object obj, Writer writer);

    public abstract void r(Object obj, Writer writer);
}
