package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.DateTimePeriod;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

@Metadata
/* loaded from: classes3.dex */
public final class DatePeriodIso8601Serializer implements KSerializer<DatePeriod> {

    /* renamed from: a, reason: collision with root package name */
    public static final DatePeriodIso8601Serializer f55645a = new DatePeriodIso8601Serializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55646b = SerialDescriptorsKt.a("kotlinx.datetime.DatePeriod");

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55646b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        DateTimePeriod.Companion companion = DateTimePeriod.Companion;
        String strY = decoder.y();
        companion.getClass();
        DateTimePeriod dateTimePeriodA = DateTimePeriod.Companion.a(strY);
        if (dateTimePeriodA instanceof DatePeriod) {
            return (DatePeriod) dateTimePeriodA;
        }
        throw new SerializationException(dateTimePeriodA + " is not a date-based period");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        DatePeriod value = (DatePeriod) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.F(value.toString());
    }
}
