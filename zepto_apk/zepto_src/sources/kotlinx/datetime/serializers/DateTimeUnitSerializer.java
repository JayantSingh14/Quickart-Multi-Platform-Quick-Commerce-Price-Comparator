package kotlinx.datetime.serializers;

import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SealedClassSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;

@Metadata
/* loaded from: classes3.dex */
public final class DateTimeUnitSerializer extends AbstractPolymorphicSerializer<DateTimeUnit> {

    /* renamed from: a, reason: collision with root package name */
    public static final DateTimeUnitSerializer f55651a = new DateTimeUnitSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f55652b = LazyKt.a(LazyThreadSafetyMode.f53529b, DateTimeUnitSerializer$impl$2.f55653c);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return ((SealedClassSerializer) f55652b.getValue()).a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final DeserializationStrategy e(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return ((SealedClassSerializer) f55652b.getValue()).e(decoder, str);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final SerializationStrategy f(Encoder encoder, Object obj) {
        DateTimeUnit value = (DateTimeUnit) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return ((SealedClassSerializer) f55652b.getValue()).f(encoder, value);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass g() {
        return Reflection.a(DateTimeUnit.class);
    }
}
