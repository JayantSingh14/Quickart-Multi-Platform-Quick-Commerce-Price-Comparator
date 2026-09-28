package androidx.datastore.preferences.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
final class NewInstanceSchemas {

    /* renamed from: a, reason: collision with root package name */
    public static final NewInstanceSchema f4101a;

    /* renamed from: b, reason: collision with root package name */
    public static final NewInstanceSchemaLite f4102b;

    static {
        Protobuf protobuf = Protobuf.f4112c;
        NewInstanceSchema newInstanceSchema = null;
        try {
            newInstanceSchema = (NewInstanceSchema) Class.forName("androidx.datastore.preferences.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f4101a = newInstanceSchema;
        f4102b = new NewInstanceSchemaLite();
    }
}
