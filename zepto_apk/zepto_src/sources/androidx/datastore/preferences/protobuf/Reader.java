package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes3.dex */
interface Reader {
    void A(List list);

    void B(Map map, MapEntryLite.Metadata metadata, ExtensionRegistryLite extensionRegistryLite);

    void C(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite);

    void D(List list);

    long E();

    String F();

    int G();

    void H(List list);

    void I(List list);

    void J(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite);

    boolean K();

    int L();

    void M(List list);

    void N(List list);

    long O();

    String P();

    long a();

    void b(List list);

    void c(List list);

    boolean d();

    long e();

    void f(List list);

    int g();

    void h(List list);

    void i(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite);

    void j(List list);

    int k();

    int l();

    void m(List list);

    void n(List list);

    ByteString o();

    int p();

    void q(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite);

    void r(List list);

    double readDouble();

    float readFloat();

    void s(List list);

    long t();

    Object u(Class cls, ExtensionRegistryLite extensionRegistryLite);

    void v(List list);

    int w();

    Object x(Class cls, ExtensionRegistryLite extensionRegistryLite);

    void y(List list);

    int z();
}
