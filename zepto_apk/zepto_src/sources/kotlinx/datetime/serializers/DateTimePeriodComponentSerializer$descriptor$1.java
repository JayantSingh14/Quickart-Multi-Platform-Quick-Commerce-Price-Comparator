package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class DateTimePeriodComponentSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final DateTimePeriodComponentSerializer$descriptor$1 f55648c = new DateTimePeriodComponentSerializer$descriptor$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ClassSerialDescriptorBuilder buildClassSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        EmptyList emptyList = EmptyList.f53609a;
        IntSerializer intSerializer = IntSerializer.f55831a;
        PrimitiveSerialDescriptor primitiveSerialDescriptor = IntSerializer.f55832b;
        buildClassSerialDescriptor.a("years", primitiveSerialDescriptor, emptyList, true);
        buildClassSerialDescriptor.a("months", primitiveSerialDescriptor, emptyList, true);
        buildClassSerialDescriptor.a("days", primitiveSerialDescriptor, emptyList, true);
        buildClassSerialDescriptor.a("hours", primitiveSerialDescriptor, emptyList, true);
        buildClassSerialDescriptor.a("minutes", primitiveSerialDescriptor, emptyList, true);
        buildClassSerialDescriptor.a("seconds", primitiveSerialDescriptor, emptyList, true);
        LongSerializer longSerializer = LongSerializer.f55842a;
        buildClassSerialDescriptor.a("nanoseconds", LongSerializer.f55843b, emptyList, true);
        return Unit.f53572a;
    }
}
