package kotlinx.datetime.serializers;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.LocalTime;
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
public final class LocalTimeComponentSerializer implements KSerializer<LocalTime> {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialDescriptorImpl f55673a = SerialDescriptorsKt.b("kotlinx.datetime.LocalTime", new SerialDescriptor[0], LocalTimeComponentSerializer$descriptor$1.f55674c);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55673a;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = f55673a;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorImpl);
        Short shValueOf = null;
        Short shValueOf2 = null;
        short sB = 0;
        int iL = 0;
        while (true) {
            int iO = compositeDecoderB.o(serialDescriptorImpl);
            if (iO == -1) {
                String str = serialDescriptorImpl.f55741a;
                if (shValueOf == null) {
                    throw new MissingFieldException("hour", str);
                }
                if (shValueOf2 == null) {
                    throw new MissingFieldException("minute", str);
                }
                LocalTime localTime = new LocalTime(shValueOf.shortValue(), shValueOf2.shortValue(), sB, iL);
                compositeDecoderB.c(serialDescriptorImpl);
                return localTime;
            }
            if (iO == 0) {
                shValueOf = Short.valueOf(compositeDecoderB.B(serialDescriptorImpl, 0));
            } else if (iO == 1) {
                shValueOf2 = Short.valueOf(compositeDecoderB.B(serialDescriptorImpl, 1));
            } else if (iO == 2) {
                sB = compositeDecoderB.B(serialDescriptorImpl, 2);
            } else {
                if (iO != 3) {
                    throw new SerializationException(b.f(iO, "Unexpected index: "));
                }
                iL = compositeDecoderB.l(serialDescriptorImpl, 3);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        LocalTime value = (LocalTime) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = f55673a;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorImpl);
        compositeEncoderB.C(serialDescriptorImpl, 0, (short) value.f55360a.getHour());
        j$.time.LocalTime localTime = value.f55360a;
        compositeEncoderB.C(serialDescriptorImpl, 1, (short) localTime.getMinute());
        if (localTime.getSecond() != 0 || localTime.getNano() != 0) {
            compositeEncoderB.C(serialDescriptorImpl, 2, (short) localTime.getSecond());
            if (localTime.getNano() != 0) {
                compositeEncoderB.w(serialDescriptorImpl, 3, localTime.getNano());
            }
        }
        compositeEncoderB.c(serialDescriptorImpl);
    }
}
