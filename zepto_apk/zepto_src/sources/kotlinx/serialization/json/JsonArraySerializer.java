package kotlinx.serialization.json;

import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.ArrayListClassDesc;

@Metadata
@PublishedApi
/* loaded from: classes.dex */
public final class JsonArraySerializer implements KSerializer<JsonArray> {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonArraySerializer f55949a = new JsonArraySerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final SerialDescriptor f55950b = JsonArrayDescriptor.f55951b;

    @Metadata
    public static final class JsonArrayDescriptor implements SerialDescriptor {

        /* renamed from: b, reason: collision with root package name */
        public static final JsonArrayDescriptor f55951b = new JsonArrayDescriptor();

        /* renamed from: c, reason: collision with root package name */
        public static final String f55952c = "kotlinx.serialization.json.JsonArray";

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayListClassDesc f55953a = BuiltinSerializersKt.a(JsonElementSerializer.f55978a).f55769b;

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean b() {
            this.f55953a.getClass();
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int c(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.f55953a.c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialKind d() {
            this.f55953a.getClass();
            return StructureKind.LIST.f55766a;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final int e() {
            this.f55953a.getClass();
            return 1;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String f(int i2) {
            this.f55953a.getClass();
            return String.valueOf(i2);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List g(int i2) {
            return this.f55953a.g(i2);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final List getAnnotations() {
            this.f55953a.getClass();
            return EmptyList.f53609a;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final SerialDescriptor h(int i2) {
            return this.f55953a.h(i2);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final String i() {
            return f55952c;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean isInline() {
            this.f55953a.getClass();
            return false;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public final boolean j(int i2) {
            this.f55953a.j(i2);
            return false;
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55950b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElementSerializersKt.a(decoder);
        return new JsonArray((List) BuiltinSerializersKt.a(JsonElementSerializer.f55978a).b(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        JsonArray value = (JsonArray) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.b(encoder);
        BuiltinSerializersKt.a(JsonElementSerializer.f55978a).c(encoder, value);
    }
}
