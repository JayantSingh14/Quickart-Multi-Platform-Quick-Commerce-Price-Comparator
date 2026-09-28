package kotlinx.datetime.serializers;

import j$.time.DayOfWeek;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumSerializer;

@Metadata
/* loaded from: classes3.dex */
public final class DayOfWeekSerializer implements KSerializer<DayOfWeek> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ EnumSerializer f55658a;

    static {
        new DayOfWeekSerializer();
    }

    public DayOfWeekSerializer() {
        DayOfWeek[] values = DayOfWeek.values();
        Intrinsics.checkNotNullParameter("kotlinx.datetime.DayOfWeek", "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        this.f55658a = new EnumSerializer("kotlinx.datetime.DayOfWeek", values);
    }

    @Override // kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor a() {
        return this.f55658a.a();
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object b(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return (DayOfWeek) this.f55658a.b(decoder);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void c(Encoder encoder, Object obj) {
        DayOfWeek value = (DayOfWeek) obj;
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f55658a.c(encoder, value);
    }
}
