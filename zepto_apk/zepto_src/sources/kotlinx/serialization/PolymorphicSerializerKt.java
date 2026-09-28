package kotlinx.serialization;

import kotlin.Metadata;
import kotlin.jvm.internal.ClassReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.AbstractPolymorphicSerializerKt;

@Metadata
/* loaded from: classes3.dex */
public final class PolymorphicSerializerKt {
    public static final DeserializationStrategy a(AbstractPolymorphicSerializer abstractPolymorphicSerializer, CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(abstractPolymorphicSerializer, "<this>");
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        DeserializationStrategy deserializationStrategyE = abstractPolymorphicSerializer.e(decoder, str);
        if (deserializationStrategyE != null) {
            return deserializationStrategyE;
        }
        AbstractPolymorphicSerializerKt.a(str, abstractPolymorphicSerializer.g());
        throw null;
    }

    public static final SerializationStrategy b(AbstractPolymorphicSerializer abstractPolymorphicSerializer, Encoder encoder, Object value) {
        Intrinsics.checkNotNullParameter(abstractPolymorphicSerializer, "<this>");
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerializationStrategy serializationStrategyF = abstractPolymorphicSerializer.f(encoder, value);
        if (serializationStrategyF != null) {
            return serializationStrategyF;
        }
        ClassReference subClass = Reflection.a(value.getClass());
        KClass baseClass = abstractPolymorphicSerializer.g();
        Intrinsics.checkNotNullParameter(subClass, "subClass");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        String strI = subClass.i();
        if (strI == null) {
            strI = String.valueOf(subClass);
        }
        AbstractPolymorphicSerializerKt.a(strI, baseClass);
        throw null;
    }
}
