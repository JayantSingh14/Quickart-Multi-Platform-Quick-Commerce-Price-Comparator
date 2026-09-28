package kotlinx.datetime.serializers;

import j$.time.format.DateTimeParseException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.LocalTimeFormat;
import kotlinx.datetime.format.LocalTimeFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

@Metadata
/* loaded from: classes3.dex */
public final class LocalTimeIso8601Serializer implements KSerializer<LocalTime> {

    /* renamed from: a, reason: collision with root package name */
    public static final LocalTimeIso8601Serializer f55675a = new LocalTimeIso8601Serializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55676b = SerialDescriptorsKt.a("kotlinx.datetime.LocalTime");

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55676b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        LocalTime.Companion companion = LocalTime.Companion;
        String input = decoder.y();
        Lazy lazy = LocalTimeFormatKt.f55457a;
        LocalTimeFormat format = (LocalTimeFormat) lazy.getValue();
        companion.getClass();
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(format, "format");
        if (format != ((LocalTimeFormat) lazy.getValue())) {
            return (LocalTime) format.parse(input);
        }
        try {
            return new LocalTime(j$.time.LocalTime.parse(input));
        } catch (DateTimeParseException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            throw new DateTimeFormatException(cause);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        LocalTime value = (LocalTime) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.F(value.toString());
    }
}
