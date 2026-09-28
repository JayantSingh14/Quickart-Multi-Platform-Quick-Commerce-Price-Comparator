package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes3.dex */
interface Writer {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class FieldOrder {

        /* renamed from: a, reason: collision with root package name */
        public static final FieldOrder f4219a;

        /* renamed from: b, reason: collision with root package name */
        public static final FieldOrder f4220b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ FieldOrder[] f4221c;

        static {
            FieldOrder fieldOrder = new FieldOrder("ASCENDING", 0);
            f4219a = fieldOrder;
            FieldOrder fieldOrder2 = new FieldOrder("DESCENDING", 1);
            f4220b = fieldOrder2;
            f4221c = new FieldOrder[]{fieldOrder, fieldOrder2};
        }

        public static FieldOrder valueOf(String str) {
            return (FieldOrder) java.lang.Enum.valueOf(FieldOrder.class, str);
        }

        public static FieldOrder[] values() {
            return (FieldOrder[]) f4221c.clone();
        }
    }

    void A(int i2, Object obj);

    void B(float f2, int i2);

    void C(int i2, long j2);

    void D(int i2, boolean z);

    void E(int i2, int i3);

    void F(int i2);

    void G(int i2, List list, boolean z);

    void H(int i2, List list, boolean z);

    void I(int i2, List list, boolean z);

    void J(int i2);

    void K(int i2, List list, boolean z);

    void L(int i2, int i3);

    void M(int i2, List list, boolean z);

    void N(int i2, List list, boolean z);

    void O(int i2, int i3);

    void P(int i2, List list);

    void a(int i2, List list, boolean z);

    void b(int i2, Object obj);

    void c(int i2, int i3);

    void d(int i2, List list);

    void e(int i2, List list, Schema schema);

    void f(int i2, String str);

    void g(int i2, long j2);

    void h(int i2, List list, boolean z);

    void i(int i2, int i3);

    void j(int i2, ByteString byteString);

    void k(int i2, long j2);

    void l(int i2, List list, boolean z);

    void m(int i2, Object obj, Schema schema);

    void n(int i2, List list, boolean z);

    void o(int i2, List list, boolean z);

    void p(int i2, long j2);

    void q(int i2, List list, boolean z);

    void r(int i2, MapEntryLite.Metadata metadata, Map map);

    void s(int i2, Object obj, Schema schema);

    void t(int i2, int i3);

    void u(int i2, double d2);

    void v(int i2, List list, boolean z);

    void w(int i2, List list, boolean z);

    void x(int i2, long j2);

    FieldOrder y();

    void z(int i2, List list, Schema schema);
}
