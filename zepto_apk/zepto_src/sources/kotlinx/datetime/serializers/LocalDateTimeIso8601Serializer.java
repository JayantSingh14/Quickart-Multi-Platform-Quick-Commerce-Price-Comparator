package kotlinx.datetime.serializers;

import j$.time.format.DateTimeParseException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.LocalDateTime;
import kotlinx.datetime.format.LocalDateTimeFormat;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

@Metadata
/* loaded from: classes3.dex */
public final class LocalDateTimeIso8601Serializer implements KSerializer<LocalDateTime> {

    /* renamed from: a, reason: collision with root package name */
    public static final LocalDateTimeIso8601Serializer f55671a = new LocalDateTimeIso8601Serializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55672b = SerialDescriptorsKt.a("kotlinx.datetime.LocalDateTime");

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55672b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        LocalDateTime.Companion companion = LocalDateTime.Companion;
        String input = decoder.y();
        LocalDateTimeFormat format = LocalDateTime.Formats.f55359a;
        companion.getClass();
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(format, "format");
        try {
            String input2 = input.toString();
            Intrinsics.checkNotNullParameter(input2, "input");
            return new LocalDateTime(j$.time.LocalDateTime.parse(UtilKt.b(12, input2.toString())));
        } catch (DateTimeParseException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            throw new DateTimeFormatException(cause);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        LocalDateTime value = (LocalDateTime) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.F(value.toString());
    }
}
