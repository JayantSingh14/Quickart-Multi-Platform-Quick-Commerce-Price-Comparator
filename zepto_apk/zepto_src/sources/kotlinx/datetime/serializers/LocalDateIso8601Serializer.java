package kotlinx.datetime.serializers;

import j$.time.format.DateTimeParseException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeFormatException;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.format.LocalDateFormatKt;
import kotlinx.datetime.internal.UtilKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

@Metadata
/* loaded from: classes3.dex */
public final class LocalDateIso8601Serializer implements KSerializer<LocalDate> {

    /* renamed from: a, reason: collision with root package name */
    public static final LocalDateIso8601Serializer f55667a = new LocalDateIso8601Serializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55668b = SerialDescriptorsKt.a("kotlinx.datetime.LocalDate");

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55668b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        LocalDate.Companion companion = LocalDate.Companion;
        String input = decoder.y();
        DateTimeFormat dateTimeFormat = LocalDate.Formats.f55354a;
        DateTimeFormat format = LocalDateFormatKt.a();
        companion.getClass();
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(format, "format");
        if (format != LocalDateFormatKt.a()) {
            return (LocalDate) format.parse(input);
        }
        try {
            String input2 = input.toString();
            Intrinsics.checkNotNullParameter(input2, "input");
            return new LocalDate(j$.time.LocalDate.parse(UtilKt.b(6, input2.toString())));
        } catch (DateTimeParseException cause) {
            Intrinsics.checkNotNullParameter(cause, "cause");
            throw new DateTimeFormatException(cause);
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        LocalDate value = (LocalDate) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.F(value.toString());
    }
}
