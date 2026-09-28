package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.internal.AbstractJsonLexer;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.JsonStreamsKt;
import kotlinx.serialization.json.internal.JsonToStringWriter;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerialModuleImpl;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata
/* loaded from: classes.dex */
public abstract class Json implements StringFormat {

    /* renamed from: d, reason: collision with root package name */
    public static final Default f55944d = new Default(new JsonConfiguration(0), SerializersModuleKt.f56126a);

    /* renamed from: a, reason: collision with root package name */
    public final JsonConfiguration f55945a;

    /* renamed from: b, reason: collision with root package name */
    public final SerialModuleImpl f55946b;

    /* renamed from: c, reason: collision with root package name */
    public final DescriptorSchemaCache f55947c = new DescriptorSchemaCache();

    @Metadata
    public static final class Default extends Json {
    }

    public Json(JsonConfiguration jsonConfiguration, SerialModuleImpl serialModuleImpl) {
        this.f55945a = jsonConfiguration;
        this.f55946b = serialModuleImpl;
    }

    @Override // kotlinx.serialization.SerialFormat
    public final SerializersModule a() {
        return this.f55946b;
    }

    @Override // kotlinx.serialization.StringFormat
    public final Object b(String string, KSerializer deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(string, "string");
        StringJsonLexer stringJsonLexer = new StringJsonLexer(string);
        Object objW = new StreamingJsonDecoder(this, WriteMode.f56108c, stringJsonLexer, deserializer.a(), null).w(deserializer);
        if (stringJsonLexer.f() == 10) {
            return objW;
        }
        AbstractJsonLexer.p(stringJsonLexer, "Expected EOF after parsing, but had " + stringJsonLexer.s().charAt(stringJsonLexer.f56006a - 1) + " instead", 0, null, 6);
        throw null;
    }

    @Override // kotlinx.serialization.StringFormat
    public final String d(KSerializer serializer, Object obj) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        JsonToStringWriter jsonToStringWriter = new JsonToStringWriter();
        try {
            JsonStreamsKt.a(this, jsonToStringWriter, serializer, obj);
            return jsonToStringWriter.toString();
        } finally {
            jsonToStringWriter.b();
        }
    }
}
