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
public final class MonthBasedDateTimeUnitSerializer implements KSerializer<DateTimeUnit.MonthBased> {

    /* renamed from: a, reason: collision with root package name */
    public static final MonthBasedDateTimeUnitSerializer f55677a = new MonthBasedDateTimeUnitSerializer();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f55678b = LazyKt.a(LazyThreadSafetyMode.f53529b, MonthBasedDateTimeUnitSerializer$descriptor$2.f55679c);

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, kotlin.Lazy] */
    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return (SerialDescriptor) f55678b.getValue();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptorA = a();
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptorA);
        MonthBasedDateTimeUnitSerializer monthBasedDateTimeUnitSerializer = f55677a;
        boolean z = false;
        int iL = 0;
        while (true) {
            int iO = compositeDecoderB.o(monthBasedDateTimeUnitSerializer.a());
            if (iO == -1) {
                Unit unit = Unit.f53572a;
                compositeDecoderB.c(serialDescriptorA);
                if (z) {
                    return new DateTimeUnit.MonthBased(iL);
                }
                throw new MissingFieldException("months", a().i());
            }
            if (iO != 0) {
                DateTimeUnitSerializersKt.a(iO);
                throw null;
            }
            iL = compositeDecoderB.l(monthBasedDateTimeUnitSerializer.a(), 0);
            z = true;
        }
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        DateTimeUnit.MonthBased value = (DateTimeUnit.MonthBased) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptorA = a();
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptorA);
        compositeEncoderB.w(f55677a.a(), 0, value.f55345b);
        compositeEncoderB.c(serialDescriptorA);
    }
}
