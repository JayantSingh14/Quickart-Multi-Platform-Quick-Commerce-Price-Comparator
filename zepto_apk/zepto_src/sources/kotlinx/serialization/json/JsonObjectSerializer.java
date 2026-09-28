package kotlinx.serialization.json;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.LinkedHashMapClassDesc;
import kotlinx.serialization.internal.StringSerializer;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class JsonObjectSerializer implements KSerializer<JsonObject> {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonObjectSerializer f55999a = new JsonObjectSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final SerialDescriptor f56000b = JsonObjectDescriptor.f56001b;

    @Metadata
    public static final class JsonObjectDescriptor implements SerialDescriptor {

        /* renamed from: b, reason: collision with root package name */
        public static final JsonObjectDescriptor f56001b = new JsonObjectDescriptor();

        /* renamed from: c, reason: collision with root package name */
        public static final String f56002c = "kotlinx.serialization.json.JsonObject";

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedHashMapClassDesc f56003a;

        public JsonObjectDescriptor() {
            BuiltinSerializersKt.d(StringCompanionObject.f53805a);
            this.f56003a = BuiltinSerializersKt.b(StringSerializer.f55902a, JsonElementSerializer.f55978a).f55836c;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean b() {
            this.f56003a.getClass();
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int c(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.f56003a.c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialKind d() {
            this.f56003a.getClass();
            return StructureKind.MAP.f55767a;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int e() {
            this.f56003a.getClass();
            return 2;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String f(int i2) {
            this.f56003a.getClass();
            return String.valueOf(i2);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List g(int i2) {
            return this.f56003a.g(i2);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List getAnnotations() {
            this.f56003a.getClass();
            return EmptyList.f53609a;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialDescriptor h(int i2) {
            return this.f56003a.h(i2);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String i() {
            return f56002c;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isInline() {
            this.f56003a.getClass();
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean j(int i2) {
            this.f56003a.j(i2);
            return false;
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f56000b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElementSerializersKt.a(decoder);
        BuiltinSerializersKt.d(StringCompanionObject.f53805a);
        return new JsonObject((Map) BuiltinSerializersKt.b(StringSerializer.f55902a, JsonElementSerializer.f55978a).b(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        JsonObject value = (JsonObject) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.b(encoder);
        BuiltinSerializersKt.d(StringCompanionObject.f53805a);
        BuiltinSerializersKt.b(StringSerializer.f55902a, JsonElementSerializer.f55978a).c(encoder, value);
    }
}
