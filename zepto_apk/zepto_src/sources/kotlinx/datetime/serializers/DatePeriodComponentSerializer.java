package kotlinx.datetime.serializers;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.DatePeriod;
import kotlinx.datetime.DateTimePeriodKt;
import kotlinx.serialization.KSerializer;
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
public final class DatePeriodComponentSerializer implements KSerializer<DatePeriod> {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialDescriptorImpl f55643a = SerialDescriptorsKt.b("kotlinx.datetime.DatePeriod", new SerialDescriptor[0], DatePeriodComponentSerializer$descriptor$1.f55644c);

    public static void e(long j2, String str) {
        if (j2 == 0) {
            return;
        }
        throw new SerializationException("DatePeriod should have non-date components be zero, but got " + j2 + " in '" + str + '\'');
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55643a;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = f55643a;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorImpl);
        int iL = 0;
        int iL2 = 0;
        int iL3 = 0;
        while (true) {
            int iO = compositeDecoderB.o(serialDescriptorImpl);
            switch (iO) {
                case -1:
                    DatePeriod datePeriod = new DatePeriod(DateTimePeriodKt.b(iL, iL2), iL3);
                    compositeDecoderB.c(serialDescriptorImpl);
                    return datePeriod;
                case 0:
                    iL = compositeDecoderB.l(serialDescriptorImpl, 0);
                    break;
                case 1:
                    iL2 = compositeDecoderB.l(serialDescriptorImpl, 1);
                    break;
                case 2:
                    iL3 = compositeDecoderB.l(serialDescriptorImpl, 2);
                    break;
                case 3:
                    e(compositeDecoderB.l(serialDescriptorImpl, 3), "hours");
                    break;
                case 4:
                    e(compositeDecoderB.l(serialDescriptorImpl, 4), "minutes");
                    break;
                case 5:
                    e(compositeDecoderB.l(serialDescriptorImpl, 5), "seconds");
                    break;
                case 6:
                    e(compositeDecoderB.h(serialDescriptorImpl, 6), "nanoseconds");
                    break;
                default:
                    throw new SerializationException(b.f(iO, "Unexpected index: "));
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        DatePeriod value = (DatePeriod) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = f55643a;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorImpl);
        if (value.i() != 0) {
            compositeEncoderB.w(DateTimePeriodComponentSerializer.f55647a, 0, value.i());
        }
        if (value.d() != 0) {
            compositeEncoderB.w(DateTimePeriodComponentSerializer.f55647a, 1, value.d());
        }
        int i2 = value.f55339b;
        if (i2 != 0) {
            compositeEncoderB.w(DateTimePeriodComponentSerializer.f55647a, 2, i2);
        }
        compositeEncoderB.c(serialDescriptorImpl);
    }
}
