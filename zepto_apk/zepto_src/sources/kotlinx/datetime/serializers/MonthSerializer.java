package kotlinx.datetime.serializers;

import j$.time.Month;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumSerializer;

@Metadata
/* loaded from: classes3.dex */
public final class MonthSerializer implements KSerializer<Month> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EnumSerializer f55681a;

    static {
        new MonthSerializer();
    }

    public MonthSerializer() {
        Month[] values = Month.values();
        Intrinsics.checkNotNullParameter("kotlinx.datetime.Month", "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f55681a = new EnumSerializer("kotlinx.datetime.Month", values);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return this.f55681a.a();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return (Month) this.f55681a.b(decoder);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        Month value = (Month) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f55681a.c(encoder, value);
    }
}
