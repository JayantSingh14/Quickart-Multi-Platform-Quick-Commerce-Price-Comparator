package kotlinx.datetime.serializers;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.DateTimePeriod;
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
public final class DateTimePeriodComponentSerializer implements KSerializer<DateTimePeriod> {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialDescriptorImpl f55647a = SerialDescriptorsKt.b("kotlinx.datetime.DateTimePeriod", new SerialDescriptor[0], DateTimePeriodComponentSerializer$descriptor$1.f55648c);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55647a;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = f55647a;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorImpl);
        int iL = 0;
        int iL2 = 0;
        int iL3 = 0;
        int iL4 = 0;
        int iL5 = 0;
        int iL6 = 0;
        long jH = 0;
        while (true) {
            int iO = compositeDecoderB.o(serialDescriptorImpl);
            switch (iO) {
                case -1:
                    DateTimePeriod dateTimePeriodA = DateTimePeriodKt.a(iL, iL2, iL3, iL4, iL5, iL6, jH);
                    compositeDecoderB.c(serialDescriptorImpl);
                    return dateTimePeriodA;
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
                    iL4 = compositeDecoderB.l(serialDescriptorImpl, 3);
                    break;
                case 4:
                    iL5 = compositeDecoderB.l(serialDescriptorImpl, 4);
                    break;
                case 5:
                    iL6 = compositeDecoderB.l(serialDescriptorImpl, 5);
                    break;
                case 6:
                    jH = compositeDecoderB.h(serialDescriptorImpl, 6);
                    break;
                default:
                    throw new SerializationException(b.f(iO, "Unexpected index: "));
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        DateTimePeriod value = (DateTimePeriod) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = f55647a;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorImpl);
        if (value.i() != 0) {
            compositeEncoderB.w(serialDescriptorImpl, 0, value.i());
        }
        if (value.d() != 0) {
            compositeEncoderB.w(serialDescriptorImpl, 1, value.d());
        }
        if (value.a() != 0) {
            compositeEncoderB.w(serialDescriptorImpl, 2, value.a());
        }
        if (value.b() != 0) {
            compositeEncoderB.w(serialDescriptorImpl, 3, value.b());
        }
        if (value.c() != 0) {
            compositeEncoderB.w(serialDescriptorImpl, 4, value.c());
        }
        if (value.f() != 0) {
            compositeEncoderB.w(serialDescriptorImpl, 5, value.f());
        }
        if (value.e() != 0) {
            compositeEncoderB.E(serialDescriptorImpl, 6, value.e());
        }
        compositeEncoderB.c(serialDescriptorImpl);
    }
}
