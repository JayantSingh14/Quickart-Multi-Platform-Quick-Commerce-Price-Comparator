package kotlinx.serialization.json.internal;

import android.support.v4.media.b;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {

    /* renamed from: c, reason: collision with root package name */
    public final Json f56010c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonElement f56011d;

    /* renamed from: e, reason: collision with root package name */
    public final JsonConfiguration f56012e;

    public AbstractJsonTreeDecoder(Json json, JsonElement jsonElement) {
        this.f56010c = json;
        this.f56011d = jsonElement;
        this.f56012e = json.f55945a;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean A() {
        return !(X() instanceof JsonNull);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final boolean E(Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive jsonPrimitiveY = Y(tag);
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.f55977a;
            Intrinsics.checkNotNullParameter(jsonPrimitiveY, "<this>");
            String strB = jsonPrimitiveY.b();
            String[] strArr = StringOpsKt.f56105a;
            Intrinsics.checkNotNullParameter(strB, "<this>");
            Boolean bool = StringsKt.t(strB, "true", true) ? Boolean.TRUE : StringsKt.t(strB, "false", true) ? Boolean.FALSE : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            a0("boolean");
            throw null;
        } catch (IllegalArgumentException unused) {
            a0("boolean");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final byte F(Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            int iD = JsonElementKt.d(Y(tag));
            Byte bValueOf = (-128 > iD || iD > 127) ? null : Byte.valueOf((byte) iD);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            a0("byte");
            throw null;
        } catch (IllegalArgumentException unused) {
            a0("byte");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final char G(Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            String strB = Y(tag).b();
            Intrinsics.checkNotNullParameter(strB, "<this>");
            int length = strB.length();
            if (length == 0) {
                throw new NoSuchElementException("Char sequence is empty.");
            }
            if (length == 1) {
                return strB.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        } catch (IllegalArgumentException unused) {
            a0("char");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final double H(Object obj) throws NumberFormatException {
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "tag");
        JsonPrimitive jsonPrimitiveY = Y(key);
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.f55977a;
            Intrinsics.checkNotNullParameter(jsonPrimitiveY, "<this>");
            double d2 = Double.parseDouble(jsonPrimitiveY.b());
            if (this.f56010c.f55945a.f55974i || !(Double.isInfinite(d2) || Double.isNaN(d2))) {
                return d2;
            }
            Double value = Double.valueOf(d2);
            String output = X().toString();
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(output, "output");
            throw JsonExceptionsKt.c(-1, JsonExceptionsKt.i(value, key, output));
        } catch (IllegalArgumentException unused) {
            a0("double");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final int I(Object obj, SerialDescriptor enumDescriptor) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.d(enumDescriptor, this.f56010c, Y(tag).b(), "");
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final float J(Object obj) throws NumberFormatException {
        String key = (String) obj;
        Intrinsics.checkNotNullParameter(key, "tag");
        JsonPrimitive jsonPrimitiveY = Y(key);
        try {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.f55977a;
            Intrinsics.checkNotNullParameter(jsonPrimitiveY, "<this>");
            float f2 = Float.parseFloat(jsonPrimitiveY.b());
            if (this.f56010c.f55945a.f55974i || !(Float.isInfinite(f2) || Float.isNaN(f2))) {
                return f2;
            }
            Float value = Float.valueOf(f2);
            String output = X().toString();
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(output, "output");
            throw JsonExceptionsKt.c(-1, JsonExceptionsKt.i(value, key, output));
        } catch (IllegalArgumentException unused) {
            a0("float");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final Decoder K(Object obj, SerialDescriptor inlineDescriptor) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.b(inlineDescriptor)) {
            return new JsonDecoderForUnsignedTypes(new StringJsonLexer(Y(tag).b()), this.f56010c);
        }
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        this.f55904a.add(tag);
        return this;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final int L(Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return JsonElementKt.d(Y(tag));
        } catch (IllegalArgumentException unused) {
            a0("int");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final long M(Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return JsonElementKt.f(Y(tag));
        } catch (IllegalArgumentException unused) {
            a0("long");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final boolean N(Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        return W(tag) != JsonNull.INSTANCE;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final short O(Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            int iD = JsonElementKt.d(Y(tag));
            Short shValueOf = (-32768 > iD || iD > 32767) ? null : Short.valueOf((short) iD);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            a0("short");
            throw null;
        } catch (IllegalArgumentException unused) {
            a0("short");
            throw null;
        }
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder
    public final String P(Object obj) {
        String tag = (String) obj;
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive jsonPrimitiveY = Y(tag);
        if (!this.f56010c.f55945a.f55968c) {
            JsonLiteral jsonLiteral = jsonPrimitiveY instanceof JsonLiteral ? (JsonLiteral) jsonPrimitiveY : null;
            if (jsonLiteral == null) {
                throw JsonExceptionsKt.c(-1, "Unexpected 'null' literal when non-nullable string was expected");
            }
            if (!jsonLiteral.f55987a) {
                throw JsonExceptionsKt.d(b.D("String literal for key '", tag, "' should be quoted.\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON."), X().toString(), -1);
            }
        }
        if (jsonPrimitiveY instanceof JsonNull) {
            throw JsonExceptionsKt.d("Unexpected 'null' value instead of string literal", X().toString(), -1);
        }
        return jsonPrimitiveY.b();
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    public final String T(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    public abstract JsonElement W(String str);

    public final JsonElement X() {
        JsonElement jsonElementW;
        String str = (String) CollectionsKt.G(this.f55904a);
        return (str == null || (jsonElementW = W(str)) == null) ? Z() : jsonElementW;
    }

    public final JsonPrimitive Y(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementW = W(tag);
        JsonPrimitive jsonPrimitive = jsonElementW instanceof JsonPrimitive ? (JsonPrimitive) jsonElementW : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw JsonExceptionsKt.d("Expected JsonPrimitive at " + tag + ", found " + jsonElementW, X().toString(), -1);
    }

    public JsonElement Z() {
        return this.f56011d;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public final SerializersModule a() {
        return this.f56010c.f55946b;
    }

    public final void a0(String str) {
        throw JsonExceptionsKt.d(b.D("Failed to parse literal as '", str, "' value"), X().toString(), -1);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonElement jsonElementX = X();
        SerialKind serialKindD = descriptor.d();
        boolean z = Intrinsics.b(serialKindD, StructureKind.LIST.f55766a) ? true : serialKindD instanceof PolymorphicKind;
        Json json = this.f56010c;
        if (z) {
            if (jsonElementX instanceof JsonArray) {
                return new JsonTreeListDecoder(json, (JsonArray) jsonElementX);
            }
            throw JsonExceptionsKt.c(-1, "Expected " + Reflection.a(JsonArray.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.a(jsonElementX.getClass()));
        }
        if (!Intrinsics.b(serialKindD, StructureKind.MAP.f55767a)) {
            if (jsonElementX instanceof JsonObject) {
                return new JsonTreeDecoder(json, (JsonObject) jsonElementX, null, null);
            }
            throw JsonExceptionsKt.c(-1, "Expected " + Reflection.a(JsonObject.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.a(jsonElementX.getClass()));
        }
        SerialDescriptor serialDescriptorA = WriteModeKt.a(descriptor.h(0), json.f55946b);
        SerialKind serialKindD2 = serialDescriptorA.d();
        if ((serialKindD2 instanceof PrimitiveKind) || Intrinsics.b(serialKindD2, SerialKind.ENUM.f55764a)) {
            if (jsonElementX instanceof JsonObject) {
                return new JsonTreeMapDecoder(json, (JsonObject) jsonElementX);
            }
            throw JsonExceptionsKt.c(-1, "Expected " + Reflection.a(JsonObject.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.a(jsonElementX.getClass()));
        }
        if (!json.f55945a.f55969d) {
            throw JsonExceptionsKt.b(serialDescriptorA);
        }
        if (jsonElementX instanceof JsonArray) {
            return new JsonTreeListDecoder(json, (JsonArray) jsonElementX);
        }
        throw JsonExceptionsKt.c(-1, "Expected " + Reflection.a(JsonArray.class) + " as the serialized body of " + descriptor.i() + ", but had " + Reflection.a(jsonElementX.getClass()));
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json d() {
        return this.f56010c;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final JsonElement j() {
        return X();
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public final Decoder p(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (CollectionsKt.G(this.f55904a) != null) {
            return super.p(descriptor);
        }
        return new JsonPrimitiveDecoder(this.f56010c, Z()).p(descriptor);
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public final Object w(DeserializationStrategy deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return PolymorphicKt.d(this, deserializer);
    }
}
