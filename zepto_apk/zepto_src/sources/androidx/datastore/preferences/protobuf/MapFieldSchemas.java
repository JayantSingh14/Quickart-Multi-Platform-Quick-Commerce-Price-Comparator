package androidx.datastore.preferences.protobuf;

@CheckReturnValue
/* loaded from: classes3.dex */
final class MapFieldSchemas {

    /* renamed from: a, reason: collision with root package name */
    public static final MapFieldSchema f4078a;

    /* renamed from: b, reason: collision with root package name */
    public static final MapFieldSchemaLite f4079b;

    static {
        Protobuf protobuf = Protobuf.f4112c;
        MapFieldSchema mapFieldSchema = null;
        try {
            mapFieldSchema = (MapFieldSchema) Class.forName("androidx.datastore.preferences.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        f4078a = mapFieldSchema;
        f4079b = new MapFieldSchemaLite();
    }
}
