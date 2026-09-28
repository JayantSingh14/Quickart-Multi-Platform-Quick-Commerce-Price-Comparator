package kotlinx.datetime.serializers;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.Instant;
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
public final class InstantComponentSerializer implements KSerializer<Instant> {

    /* renamed from: a, reason: collision with root package name */
    public static final SerialDescriptorImpl f55661a = SerialDescriptorsKt.b("kotlinx.datetime.Instant", new SerialDescriptor[0], InstantComponentSerializer$descriptor$1.f55662c);

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return f55661a;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) throws Exception {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptorImpl serialDescriptorImpl = f55661a;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorImpl);
        Long lValueOf = null;
        int iL = 0;
        while (true) {
            int iO = compositeDecoderB.o(serialDescriptorImpl);
            if (iO == -1) {
                if (lValueOf == null) {
                    throw new MissingFieldException("epochSeconds", serialDescriptorImpl.f55741a);
                }
                Instant.Companion companion = Instant.Companion;
                long jLongValue = lValueOf.longValue();
                companion.getClass();
                Instant instantA = Instant.Companion.a(iL, jLongValue);
                compositeDecoderB.c(serialDescriptorImpl);
                return instantA;
            }
            if (iO == 0) {
                lValueOf = Long.valueOf(compositeDecoderB.h(serialDescriptorImpl, 0));
            } else {
                if (iO != 1) {
                    throw new SerializationException(b.f(iO, "Unexpected index: "));
                }
                iL = compositeDecoderB.l(serialDescriptorImpl, 1);
            }
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        Instant value = (Instant) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptorImpl serialDescriptorImpl = f55661a;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorImpl);
        compositeEncoderB.E(serialDescriptorImpl, 0, value.f55352a.getEpochSecond());
        j$.time.Instant instant = value.f55352a;
        if (instant.getNano() != 0) {
            compositeEncoderB.w(serialDescriptorImpl, 1, instant.getNano());
        }
        compositeEncoderB.c(serialDescriptorImpl);
    }
}
