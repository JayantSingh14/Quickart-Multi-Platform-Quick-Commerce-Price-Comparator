package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Writer;
import java.util.Arrays;

@CheckReturnValue
/* loaded from: classes3.dex */
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void a(int i2, int i3, Object obj) {
        ((UnknownFieldSetLite) obj).c((i2 << 3) | 5, Integer.valueOf(i3));
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void b(Object obj, int i2, long j2) {
        ((UnknownFieldSetLite) obj).c((i2 << 3) | 1, Long.valueOf(j2));
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void c(int i2, Object obj, Object obj2) {
        ((UnknownFieldSetLite) obj).c((i2 << 3) | 3, (UnknownFieldSetLite) obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void d(Object obj, int i2, ByteString byteString) {
        ((UnknownFieldSetLite) obj).c((i2 << 3) | 2, byteString);
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void e(Object obj, int i2, long j2) {
        ((UnknownFieldSetLite) obj).c(i2 << 3, Long.valueOf(j2));
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite f(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.f4175f) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLite2 = new UnknownFieldSetLite(0, new int[8], new Object[8], true);
        generatedMessageLite.unknownFields = unknownFieldSetLite2;
        return unknownFieldSetLite2;
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite g(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final int h(Object obj) {
        return ((UnknownFieldSetLite) obj).b();
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final int i(Object obj) {
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i2 = unknownFieldSetLite.f4179d;
        if (i2 != -1) {
            return i2;
        }
        int iS = 0;
        for (int i3 = 0; i3 < unknownFieldSetLite.f4176a; i3++) {
            int i4 = unknownFieldSetLite.f4177b[i3] >>> 3;
            iS += CodedOutputStream.S(3, (ByteString) unknownFieldSetLite.f4178c[i3]) + CodedOutputStream.Z(i4) + CodedOutputStream.Y(2) + (CodedOutputStream.Y(1) * 2);
        }
        unknownFieldSetLite.f4179d = iS;
        return iS;
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void j(Object obj) {
        UnknownFieldSetLite unknownFieldSetLite = ((GeneratedMessageLite) obj).unknownFields;
        if (unknownFieldSetLite.f4180e) {
            unknownFieldSetLite.f4180e = false;
        }
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite k(Object obj, Object obj2) {
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        UnknownFieldSetLite unknownFieldSetLite2 = (UnknownFieldSetLite) obj2;
        UnknownFieldSetLite unknownFieldSetLite3 = UnknownFieldSetLite.f4175f;
        if (unknownFieldSetLite3.equals(unknownFieldSetLite2)) {
            return unknownFieldSetLite;
        }
        if (unknownFieldSetLite3.equals(unknownFieldSetLite)) {
            int i2 = unknownFieldSetLite.f4176a + unknownFieldSetLite2.f4176a;
            int[] iArrCopyOf = Arrays.copyOf(unknownFieldSetLite.f4177b, i2);
            System.arraycopy(unknownFieldSetLite2.f4177b, 0, iArrCopyOf, unknownFieldSetLite.f4176a, unknownFieldSetLite2.f4176a);
            Object[] objArrCopyOf = Arrays.copyOf(unknownFieldSetLite.f4178c, i2);
            System.arraycopy(unknownFieldSetLite2.f4178c, 0, objArrCopyOf, unknownFieldSetLite.f4176a, unknownFieldSetLite2.f4176a);
            return new UnknownFieldSetLite(i2, iArrCopyOf, objArrCopyOf, true);
        }
        unknownFieldSetLite.getClass();
        if (unknownFieldSetLite2.equals(unknownFieldSetLite3)) {
            return unknownFieldSetLite;
        }
        if (!unknownFieldSetLite.f4180e) {
            throw new UnsupportedOperationException();
        }
        int i3 = unknownFieldSetLite.f4176a + unknownFieldSetLite2.f4176a;
        unknownFieldSetLite.a(i3);
        System.arraycopy(unknownFieldSetLite2.f4177b, 0, unknownFieldSetLite.f4177b, unknownFieldSetLite.f4176a, unknownFieldSetLite2.f4176a);
        System.arraycopy(unknownFieldSetLite2.f4178c, 0, unknownFieldSetLite.f4178c, unknownFieldSetLite.f4176a, unknownFieldSetLite2.f4176a);
        unknownFieldSetLite.f4176a = i3;
        return unknownFieldSetLite;
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite m() {
        return new UnknownFieldSetLite(0, new int[8], new Object[8], true);
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void n(Object obj, Object obj2) {
        ((GeneratedMessageLite) obj).unknownFields = (UnknownFieldSetLite) obj2;
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void o(Object obj, Object obj2) {
        ((GeneratedMessageLite) obj).unknownFields = (UnknownFieldSetLite) obj2;
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final UnknownFieldSetLite p(Object obj) {
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        if (unknownFieldSetLite.f4180e) {
            unknownFieldSetLite.f4180e = false;
        }
        return unknownFieldSetLite;
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void q(Object obj, Writer writer) {
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        unknownFieldSetLite.getClass();
        if (writer.y() == Writer.FieldOrder.f4220b) {
            for (int i2 = unknownFieldSetLite.f4176a - 1; i2 >= 0; i2--) {
                writer.b(unknownFieldSetLite.f4177b[i2] >>> 3, unknownFieldSetLite.f4178c[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < unknownFieldSetLite.f4176a; i3++) {
            writer.b(unknownFieldSetLite.f4177b[i3] >>> 3, unknownFieldSetLite.f4178c[i3]);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.UnknownFieldSchema
    public final void r(Object obj, Writer writer) {
        ((UnknownFieldSetLite) obj).e(writer);
    }
}
