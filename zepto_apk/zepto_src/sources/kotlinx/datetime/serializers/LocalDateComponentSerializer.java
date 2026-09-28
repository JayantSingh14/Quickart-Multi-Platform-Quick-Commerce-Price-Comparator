package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.LocalDate;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorImpl;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class LocalDateComponentSerializer implements KSerializer<LocalDate> {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialDescriptorImpl f55665a = SerialDescriptorsKt.b("kotlinx.datetime.LocalDate", new SerialDescriptor[0], LocalDateComponentSerializer$descriptor$1.f55666c);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55665a;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = f55665a;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorImpl);
        Integer numValueOf = null;
        Short shValueOf = null;
        Short shValueOf2 = null;
        while (true) {
            int iO = compositeDecoderB.o(serialDescriptorImpl);
            if (iO == -1) {
                String str = serialDescriptorImpl.f55741a;
                if (numValueOf == null) {
                    throw new MissingFieldException("year", str);
                }
                if (shValueOf == null) {
                    throw new MissingFieldException("month", str);
                }
                if (shValueOf2 == null) {
                    throw new MissingFieldException("day", str);
                }
                LocalDate localDate = new LocalDate(numValueOf.intValue(), shValueOf.shortValue(), shValueOf2.shortValue());
                compositeDecoderB.c(serialDescriptorImpl);
                return localDate;
            }
            if (iO == 0) {
                numValueOf = Integer.valueOf(compositeDecoderB.l(serialDescriptorImpl, 0));
            } else if (iO == 1) {
                shValueOf = Short.valueOf(compositeDecoderB.B(serialDescriptorImpl, 1));
            } else {
                if (iO != 2) {
                    DateTimeUnitSerializersKt.a(iO);
                    throw null;
                }
                shValueOf2 = Short.valueOf(compositeDecoderB.B(serialDescriptorImpl, 2));
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        LocalDate value = (LocalDate) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = f55665a;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorImpl);
        compositeEncoderB.w(serialDescriptorImpl, 0, value.f55353a.getYear());
        j$.time.LocalDate localDate = value.f55353a;
        compositeEncoderB.C(serialDescriptorImpl, 1, (short) localDate.getMonthValue());
        compositeEncoderB.C(serialDescriptorImpl, 2, (short) localDate.getDayOfMonth());
        compositeEncoderB.c(serialDescriptorImpl);
    }
}
