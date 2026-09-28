package kotlinx.datetime.serializers;

import j$.time.format.DateTimeFormatter;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.UtcOffsetJvmKt;
import kotlinx.datetime.format.UtcOffsetFormat;
import kotlinx.datetime.format.UtcOffsetFormatKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

@Metadata
/* loaded from: classes3.dex */
public final class UtcOffsetSerializer implements KSerializer<UtcOffset> {

    /* renamed from: a, reason: collision with root package name */
    public static final UtcOffsetSerializer f55688a = new UtcOffsetSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final PrimitiveSerialDescriptor f55689b = SerialDescriptorsKt.a("kotlinx.datetime.UtcOffset");

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55689b;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        UtcOffset.Companion companion = UtcOffset.Companion;
        String input = decoder.y();
        Lazy lazy = UtcOffsetFormatKt.f55497a;
        UtcOffsetFormat format = (UtcOffsetFormat) lazy.getValue();
        companion.getClass();
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(format, "format");
        if (format == ((UtcOffsetFormat) lazy.getValue())) {
            DateTimeFormatter dateTimeFormatter = (DateTimeFormatter) UtcOffsetJvmKt.f55364a.getValue();
            Intrinsics.checkNotNullExpressionValue(dateTimeFormatter, "access$getIsoFormat(...)");
            return UtcOffsetJvmKt.a(input, dateTimeFormatter);
        }
        if (format == ((UtcOffsetFormat) UtcOffsetFormatKt.f55498b.getValue())) {
            DateTimeFormatter dateTimeFormatter2 = (DateTimeFormatter) UtcOffsetJvmKt.f55365b.getValue();
            Intrinsics.checkNotNullExpressionValue(dateTimeFormatter2, "access$getIsoBasicFormat(...)");
            return UtcOffsetJvmKt.a(input, dateTimeFormatter2);
        }
        if (format != ((UtcOffsetFormat) UtcOffsetFormatKt.f55499c.getValue())) {
            return (UtcOffset) format.parse(input);
        }
        DateTimeFormatter dateTimeFormatter3 = (DateTimeFormatter) UtcOffsetJvmKt.f55366c.getValue();
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatter3, "access$getFourDigitsFormat(...)");
        return UtcOffsetJvmKt.a(input, dateTimeFormatter3);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        UtcOffset value = (UtcOffset) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.F(value.toString());
    }
}
