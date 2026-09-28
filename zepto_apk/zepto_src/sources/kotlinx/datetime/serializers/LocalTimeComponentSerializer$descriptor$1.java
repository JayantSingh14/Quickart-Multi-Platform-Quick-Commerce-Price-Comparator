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
public final class LocalTimeComponentSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalTimeComponentSerializer$descriptor$1 f55674c = new LocalTimeComponentSerializer$descriptor$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ClassSerialDescriptorBuilder buildClassSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        EmptyList emptyList = EmptyList.f53609a;
        ShortSerializer shortSerializer = ShortSerializer.f55900a;
        PrimitiveSerialDescriptor primitiveSerialDescriptor = ShortSerializer.f55901b;
        buildClassSerialDescriptor.a("hour", primitiveSerialDescriptor, emptyList, false);
        buildClassSerialDescriptor.a("minute", primitiveSerialDescriptor, emptyList, false);
        buildClassSerialDescriptor.a("second", primitiveSerialDescriptor, emptyList, true);
        IntSerializer intSerializer = IntSerializer.f55831a;
        buildClassSerialDescriptor.a("nanosecond", IntSerializer.f55832b, emptyList, true);
        return Unit.f53572a;
    }
}
