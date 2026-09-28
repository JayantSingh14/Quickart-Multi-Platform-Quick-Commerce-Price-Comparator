package androidx.datastore.preferences.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
final class ListFieldSchemas {

    /* renamed from: a, reason: collision with root package name */
    public static final ListFieldSchema f4063a;

    /* renamed from: b, reason: collision with root package name */
    public static final ListFieldSchemaLite f4064b;

    static {
        Protobuf protobuf = Protobuf.f4112c;
        ListFieldSchema listFieldSchema = null;
        try {
            listFieldSchema = (ListFieldSchema) Class.forName("androidx.datastore.preferences.protobuf.ListFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f4063a = listFieldSchema;
        f4064b = new ListFieldSchemaLite();
    }
}
