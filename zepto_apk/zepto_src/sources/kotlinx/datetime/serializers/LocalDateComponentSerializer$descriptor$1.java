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
public final class LocalDateComponentSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalDateComponentSerializer$descriptor$1 f55666c = new LocalDateComponentSerializer$descriptor$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ClassSerialDescriptorBuilder buildClassSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        EmptyList emptyList = EmptyList.f53609a;
        IntSerializer intSerializer = IntSerializer.f55831a;
        buildClassSerialDescriptor.a("year", IntSerializer.f55832b, emptyList, false);
        ShortSerializer shortSerializer = ShortSerializer.f55900a;
        PrimitiveSerialDescriptor primitiveSerialDescriptor = ShortSerializer.f55901b;
        buildClassSerialDescriptor.a("month", primitiveSerialDescriptor, emptyList, false);
        buildClassSerialDescriptor.a("day", primitiveSerialDescriptor, emptyList, false);
        return Unit.f53572a;
    }
}
