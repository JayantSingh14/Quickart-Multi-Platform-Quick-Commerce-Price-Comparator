package kotlinx.datetime.serializers;

import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DayBasedDateTimeUnitSerializer implements KSerializer<DateTimeUnit.DayBased> {

    /* renamed from: a, reason: collision with root package name */
    public static final DayBasedDateTimeUnitSerializer f55654a = new DayBasedDateTimeUnitSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f55655b = LazyKt.a(LazyThreadSafetyMode.f53529b, DayBasedDateTimeUnitSerializer$descriptor$2.f55656c);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return (SerialDescriptor) f55655b.getValue();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptorA = a();
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorA);
        DayBasedDateTimeUnitSerializer dayBasedDateTimeUnitSerializer = f55654a;
        boolean z = false;
        int iL = 0;
        while (true) {
            int iO = compositeDecoderB.o(dayBasedDateTimeUnitSerializer.a());
            if (iO == -1) {
                Unit unit = Unit.f53572a;
                compositeDecoderB.c(serialDescriptorA);
                if (z) {
                    return new DateTimeUnit.DayBased(iL);
                }
                throw new MissingFieldException("days", a().i());
            }
            if (iO != 0) {
                DateTimeUnitSerializersKt.a(iO);
                throw null;
            }
            iL = compositeDecoderB.l(dayBasedDateTimeUnitSerializer.a(), 0);
            z = true;
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        DateTimeUnit.DayBased value = (DateTimeUnit.DayBased) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptorA = a();
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorA);
        compositeEncoderB.w(f55654a.a(), 0, value.f55344b);
        compositeEncoderB.c(serialDescriptorA);
    }
}
