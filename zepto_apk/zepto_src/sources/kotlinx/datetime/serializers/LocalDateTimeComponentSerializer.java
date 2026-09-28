package kotlinx.datetime.serializers;

import android.support.v4.media.b;
import j$.time.DateTimeException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.LocalDateTime;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.SerializationException;
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
public final class LocalDateTimeComponentSerializer implements KSerializer<LocalDateTime> {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialDescriptorImpl f55669a = SerialDescriptorsKt.b("kotlinx.datetime.LocalDateTime", new SerialDescriptor[0], LocalDateTimeComponentSerializer$descriptor$1.f55670c);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55669a;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = f55669a;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorImpl);
        Integer numValueOf = null;
        short sB = 0;
        int iL = 0;
        Short shValueOf = null;
        Short shValueOf2 = null;
        Short shValueOf3 = null;
        Short shValueOf4 = null;
        while (true) {
            int iO = compositeDecoderB.o(serialDescriptorImpl);
            switch (iO) {
                case -1:
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
                    if (shValueOf3 == null) {
                        throw new MissingFieldException("hour", str);
                    }
                    if (shValueOf4 == null) {
                        throw new MissingFieldException("minute", str);
                    }
                    try {
                        j$.time.LocalDateTime localDateTimeOf = j$.time.LocalDateTime.of(numValueOf.intValue(), shValueOf.shortValue(), shValueOf2.shortValue(), shValueOf3.shortValue(), shValueOf4.shortValue(), sB, iL);
                        Intrinsics.c(localDateTimeOf);
                        LocalDateTime localDateTime = new LocalDateTime(localDateTimeOf);
                        compositeDecoderB.c(serialDescriptorImpl);
                        return localDateTime;
                    } catch (DateTimeException e2) {
                        throw new IllegalArgumentException(e2);
                    }
                case 0:
                    numValueOf = Integer.valueOf(compositeDecoderB.l(serialDescriptorImpl, 0));
                    break;
                case 1:
                    shValueOf = Short.valueOf(compositeDecoderB.B(serialDescriptorImpl, 1));
                    break;
                case 2:
                    shValueOf2 = Short.valueOf(compositeDecoderB.B(serialDescriptorImpl, 2));
                    break;
                case 3:
                    shValueOf3 = Short.valueOf(compositeDecoderB.B(serialDescriptorImpl, 3));
                    break;
                case 4:
                    shValueOf4 = Short.valueOf(compositeDecoderB.B(serialDescriptorImpl, 4));
                    break;
                case 5:
                    sB = compositeDecoderB.B(serialDescriptorImpl, 5);
                    break;
                case 6:
                    iL = compositeDecoderB.l(serialDescriptorImpl, 6);
                    break;
                default:
                    throw new SerializationException(b.f(iO, "Unexpected index: "));
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        LocalDateTime value = (LocalDateTime) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = f55669a;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorImpl);
        compositeEncoderB.w(serialDescriptorImpl, 0, value.f55358a.getYear());
        j$.time.LocalDateTime localDateTime = value.f55358a;
        compositeEncoderB.C(serialDescriptorImpl, 1, (short) localDateTime.getMonthValue());
        compositeEncoderB.C(serialDescriptorImpl, 2, (short) localDateTime.getDayOfMonth());
        compositeEncoderB.C(serialDescriptorImpl, 3, (short) localDateTime.getHour());
        compositeEncoderB.C(serialDescriptorImpl, 4, (short) localDateTime.getMinute());
        if (localDateTime.getSecond() != 0 || localDateTime.getNano() != 0) {
            compositeEncoderB.C(serialDescriptorImpl, 5, (short) localDateTime.getSecond());
            if (localDateTime.getNano() != 0) {
                compositeEncoderB.w(serialDescriptorImpl, 6, localDateTime.getNano());
            }
        }
        compositeEncoderB.c(serialDescriptorImpl);
    }
}
