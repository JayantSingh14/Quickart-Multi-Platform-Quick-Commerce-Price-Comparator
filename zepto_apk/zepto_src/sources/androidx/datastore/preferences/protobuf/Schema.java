package androidx.datastore.preferences.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
interface Schema<T> {
    void a(Object obj, Object obj2);

    void b(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void c(Object obj);

    int d(AbstractMessageLite abstractMessageLite);

    boolean e(Object obj);

    Object f();

    int g(GeneratedMessageLite generatedMessageLite);

    void h(Object obj, Writer writer);

    boolean i(GeneratedMessageLite generatedMessageLite, GeneratedMessageLite generatedMessageLite2);
}
