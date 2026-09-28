package androidx.datastore.preferences.protobuf;

import java.util.concurrent.ConcurrentHashMap;

@CheckReturnValue
/* loaded from: classes3.dex */
final class Protobuf {

    /* renamed from: c, reason: collision with root package name */
    public static final Protobuf f4112c = new Protobuf();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f4114b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final ManifestSchemaFactory f4113a = new ManifestSchemaFactory();

    public final Schema a(Class cls) {
        ExtensionSchema extensionSchema;
        Schema schemaY;
        Class cls2;
        Internal.a(cls, "messageType");
        ConcurrentHashMap concurrentHashMap = this.f4114b;
        Schema schema = (Schema) concurrentHashMap.get(cls);
        if (schema != null) {
            return schema;
        }
        ManifestSchemaFactory manifestSchemaFactory = this.f4113a;
        manifestSchemaFactory.getClass();
        Class cls3 = SchemaUtil.f4138a;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = SchemaUtil.f4138a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        MessageInfo messageInfoA = manifestSchemaFactory.f4069a.a(cls);
        if (messageInfoA.a()) {
            if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                schemaY = new MessageSetSchema(SchemaUtil.f4140c, ExtensionSchemas.f3954a, messageInfoA.b());
            } else {
                UnknownFieldSchema unknownFieldSchema = SchemaUtil.f4139b;
                ExtensionSchema extensionSchema2 = ExtensionSchemas.f3955b;
                if (extensionSchema2 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                schemaY = new MessageSetSchema(unknownFieldSchema, extensionSchema2, messageInfoA.b());
            }
        } else if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
            NewInstanceSchemaLite newInstanceSchemaLite = NewInstanceSchemas.f4102b;
            ListFieldSchemaLite listFieldSchemaLite = ListFieldSchemas.f4064b;
            UnknownFieldSetLiteSchema unknownFieldSetLiteSchema = SchemaUtil.f4140c;
            ExtensionSchemaLite extensionSchemaLite = messageInfoA.c().ordinal() != 1 ? ExtensionSchemas.f3954a : null;
            MapFieldSchemaLite mapFieldSchemaLite = MapFieldSchemas.f4079b;
            int[] iArr = MessageSchema.p;
            if (!(messageInfoA instanceof RawMessageInfo)) {
                throw null;
            }
            schemaY = MessageSchema.y((RawMessageInfo) messageInfoA, newInstanceSchemaLite, listFieldSchemaLite, unknownFieldSetLiteSchema, extensionSchemaLite, mapFieldSchemaLite);
        } else {
            NewInstanceSchema newInstanceSchema = NewInstanceSchemas.f4101a;
            ListFieldSchema listFieldSchema = ListFieldSchemas.f4063a;
            UnknownFieldSchema unknownFieldSchema2 = SchemaUtil.f4139b;
            if (messageInfoA.c().ordinal() != 1) {
                ExtensionSchema extensionSchema3 = ExtensionSchemas.f3955b;
                if (extensionSchema3 == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                extensionSchema = extensionSchema3;
            } else {
                extensionSchema = null;
            }
            MapFieldSchema mapFieldSchema = MapFieldSchemas.f4078a;
            int[] iArr2 = MessageSchema.p;
            if (!(messageInfoA instanceof RawMessageInfo)) {
                throw null;
            }
            schemaY = MessageSchema.y((RawMessageInfo) messageInfoA, newInstanceSchema, listFieldSchema, unknownFieldSchema2, extensionSchema, mapFieldSchema);
        }
        Schema schema2 = (Schema) concurrentHashMap.putIfAbsent(cls, schemaY);
        return schema2 != null ? schema2 : schemaY;
    }

    public final Schema b(Object obj) {
        return a(obj.getClass());
    }
}
