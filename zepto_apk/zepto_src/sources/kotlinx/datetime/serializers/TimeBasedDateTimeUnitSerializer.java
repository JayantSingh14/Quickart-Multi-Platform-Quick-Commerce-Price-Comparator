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
public final class TimeBasedDateTimeUnitSerializer implements KSerializer<DateTimeUnit.TimeBased> {

    /* renamed from: a, reason: collision with root package name */
    public static final TimeBasedDateTimeUnitSerializer f55682a = new TimeBasedDateTimeUnitSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f55683b = LazyKt.a(LazyThreadSafetyMode.f53529b, TimeBasedDateTimeUnitSerializer$descriptor$2.f55684c);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return (SerialDescriptor) f55683b.getValue();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptorA = a();
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorA);
        TimeBasedDateTimeUnitSerializer timeBasedDateTimeUnitSerializer = f55682a;
        long jH = 0;
        boolean z = false;
        while (true) {
            int iO = compositeDecoderB.o(timeBasedDateTimeUnitSerializer.a());
            if (iO == -1) {
                Unit unit = Unit.f53572a;
                compositeDecoderB.c(serialDescriptorA);
                if (z) {
                    return new DateTimeUnit.TimeBased(jH);
                }
                throw new MissingFieldException("nanoseconds", a().i());
            }
            if (iO != 0) {
                DateTimeUnitSerializersKt.a(iO);
                throw null;
            }
            jH = compositeDecoderB.h(timeBasedDateTimeUnitSerializer.a(), 0);
            z = true;
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        DateTimeUnit.TimeBased value = (DateTimeUnit.TimeBased) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptorA = a();
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorA);
        compositeEncoderB.E(f55682a.a(), 0, value.f55346b);
        compositeEncoderB.c(serialDescriptorA);
    }
}
