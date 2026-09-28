package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PrimitiveSerialDescriptor;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class InstantComponentSerializer$descriptor$1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final InstantComponentSerializer$descriptor$1 f55662c = new InstantComponentSerializer$descriptor$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        ClassSerialDescriptorBuilder buildClassSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
        Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        EmptyList emptyList = EmptyList.f53609a;
        LongSerializer longSerializer = LongSerializer.f55842a;
        PrimitiveSerialDescriptor primitiveSerialDescriptor = LongSerializer.f55843b;
        buildClassSerialDescriptor.a("epochSeconds", primitiveSerialDescriptor, emptyList, false);
        buildClassSerialDescriptor.a("nanosecondsOfSecond", primitiveSerialDescriptor, emptyList, true);
        return Unit.f53572a;
    }
}
