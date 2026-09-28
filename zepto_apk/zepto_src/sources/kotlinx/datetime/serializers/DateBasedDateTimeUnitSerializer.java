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
public final class DateBasedDateTimeUnitSerializer extends AbstractPolymorphicSerializer<DateTimeUnit.DateBased> {

    /* renamed from: a, reason: collision with root package name */
    public static final DateBasedDateTimeUnitSerializer f55640a = new DateBasedDateTimeUnitSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f55641b = LazyKt.a(LazyThreadSafetyMode.f53529b, DateBasedDateTimeUnitSerializer$impl$2.f55642c);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return ((SealedClassSerializer) f55641b.getValue()).a();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final DeserializationStrategy e(CompositeDecoder decoder, String str) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return ((SealedClassSerializer) f55641b.getValue()).e(decoder, str);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final SerializationStrategy f(Encoder encoder, Object obj) {
        DateTimeUnit.DateBased value = (DateTimeUnit.DateBased) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        return ((SealedClassSerializer) f55641b.getValue()).f(encoder, value);
    }

    @Override // kotlinx.serialization.internal.AbstractPolymorphicSerializer
    public final KClass g() {
        return Reflection.a(DateTimeUnit.DateBased.class);
    }
}
