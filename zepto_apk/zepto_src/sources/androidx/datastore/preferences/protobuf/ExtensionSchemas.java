package androidx.datastore.preferences.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
final class ExtensionSchemas {

    /* renamed from: a, reason: collision with root package name */
    public static final ExtensionSchemaLite f3954a = new ExtensionSchemaLite();

    /* renamed from: b, reason: collision with root package name */
    public static final ExtensionSchema f3955b;

    static {
        Protobuf protobuf = Protobuf.f4112c;
        ExtensionSchema extensionSchema = null;
        try {
            extensionSchema = (ExtensionSchema) Class.forName("androidx.datastore.preferences.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f3955b = extensionSchema;
    }
}
