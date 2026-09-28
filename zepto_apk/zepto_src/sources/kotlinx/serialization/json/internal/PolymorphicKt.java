package kotlinx.serialization.json.internal;

import androidx.fragment.app.e;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.InlineClassDescriptor;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.json.ClassDiscriminatorMode;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonClassDiscriminator;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class PolymorphicKt {

    @Metadata
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[ClassDiscriminatorMode.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ClassDiscriminatorMode classDiscriminatorMode = ClassDiscriminatorMode.f55938a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ClassDiscriminatorMode classDiscriminatorMode2 = ClassDiscriminatorMode.f55938a;
                iArr[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static final void a(SerializationStrategy serializationStrategy, SerializationStrategy serializationStrategy2, String str) {
        if (serializationStrategy instanceof SealedClassSerializer) {
            SerialDescriptor serialDescriptorA = serializationStrategy2.a();
            Intrinsics.checkNotNullParameter(serialDescriptorA, "<this>");
            if (Platform_commonKt.a(serialDescriptorA).contains(str)) {
                StringBuilder sbV = e.v("Sealed class '", serializationStrategy2.a().i(), "' cannot be serialized as base class '", ((SealedClassSerializer) serializationStrategy).a().i(), "' because it has property name that conflicts with JSON class discriminator '");
                sbV.append(str);
                sbV.append("'. You can either change class discriminator in JsonConfiguration, rename property with @SerialName annotation or fall back to array polymorphism");
                throw new IllegalStateException(sbV.toString().toString());
            }
        }
    }

    public static final void b(SerialKind kind) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (kind instanceof SerialKind.ENUM) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof PrimitiveKind) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead");
        }
        if (kind instanceof PolymorphicKind) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself");
        }
    }

    public static final String c(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        for (Annotation annotation : serialDescriptor.getAnnotations()) {
            if (annotation instanceof JsonClassDiscriminator) {
                ((JsonClassDiscriminator) annotation).getClass();
                return null;
            }
        }
        return json.f55945a.f55973h;
    }

    public static final Object d(JsonDecoder jsonDecoder, DeserializationStrategy deserializer) {
        Intrinsics.checkNotNullParameter(jsonDecoder, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        if (!(deserializer instanceof AbstractPolymorphicSerializer)) {
            return deserializer.b(jsonDecoder);
        }
        JsonConfiguration jsonConfiguration = jsonDecoder.d().f55945a;
        String discriminator = c(deserializer.a(), jsonDecoder.d());
        JsonElement jsonElementJ = jsonDecoder.j();
        SerialDescriptor serialDescriptorA = deserializer.a();
        if (!(jsonElementJ instanceof JsonObject)) {
            throw JsonExceptionsKt.c(-1, "Expected " + Reflection.a(JsonObject.class) + " as the serialized body of " + serialDescriptorA.i() + ", but had " + Reflection.a(jsonElementJ.getClass()));
        }
        JsonObject element = (JsonObject) jsonElementJ;
        JsonElement jsonElement = (JsonElement) element.get(discriminator);
        String strB = null;
        if (jsonElement != null) {
            InlineClassDescriptor inlineClassDescriptor = JsonElementKt.f55977a;
            Intrinsics.checkNotNullParameter(jsonElement, "<this>");
            JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
            if (jsonPrimitive == null) {
                JsonElementKt.c("JsonPrimitive", jsonElement);
                throw null;
            }
            Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
            if (!(jsonPrimitive instanceof JsonNull)) {
                strB = jsonPrimitive.b();
            }
        }
        try {
            DeserializationStrategy deserializer2 = PolymorphicSerializerKt.a((AbstractPolymorphicSerializer) deserializer, jsonDecoder, strB);
            Json jsonD = jsonDecoder.d();
            Intrinsics.checkNotNullParameter(jsonD, "<this>");
            Intrinsics.checkNotNullParameter(discriminator, "discriminator");
            Intrinsics.checkNotNullParameter(element, "element");
            Intrinsics.checkNotNullParameter(deserializer2, "deserializer");
            JsonTreeDecoder jsonTreeDecoder = new JsonTreeDecoder(jsonD, element, discriminator, deserializer2.a());
            Intrinsics.checkNotNullParameter(deserializer2, "deserializer");
            return d(jsonTreeDecoder, deserializer2);
        } catch (SerializationException e2) {
            String message = e2.getMessage();
            Intrinsics.c(message);
            throw JsonExceptionsKt.d(message, element.toString(), -1);
        }
    }
}
