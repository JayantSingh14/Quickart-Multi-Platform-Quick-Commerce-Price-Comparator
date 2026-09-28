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
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;
import kotlinx.serialization.internal.ShortSerializer;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class LocalDateTimeComponentSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalDateTimeComponentSerializer$descriptor$1 f55670c = new LocalDateTimeComponentSerializer$descriptor$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ClassSerialDescriptorBuilder buildClassSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        EmptyList emptyList = EmptyList.f53609a;
        IntSerializer intSerializer = IntSerializer.f55831a;
        PrimitiveSerialDescriptor primitiveSerialDescriptor = IntSerializer.f55832b;
        buildClassSerialDescriptor.a("year", primitiveSerialDescriptor, emptyList, false);
        ShortSerializer shortSerializer = ShortSerializer.f55900a;
        PrimitiveSerialDescriptor primitiveSerialDescriptor2 = ShortSerializer.f55901b;
        buildClassSerialDescriptor.a("month", primitiveSerialDescriptor2, emptyList, false);
        buildClassSerialDescriptor.a("day", primitiveSerialDescriptor2, emptyList, false);
        buildClassSerialDescriptor.a("hour", primitiveSerialDescriptor2, emptyList, false);
        buildClassSerialDescriptor.a("minute", primitiveSerialDescriptor2, emptyList, false);
        buildClassSerialDescriptor.a("second", primitiveSerialDescriptor2, emptyList, true);
        buildClassSerialDescriptor.a("nanosecond", primitiveSerialDescriptor, emptyList, true);
        return Unit.f53572a;
    }
}
