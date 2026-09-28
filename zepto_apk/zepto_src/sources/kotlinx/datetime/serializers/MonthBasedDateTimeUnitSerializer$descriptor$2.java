package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptyList;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.internal.IntSerializer;

@Metadata
/* loaded from: classes3.dex */
public final class MonthBasedDateTimeUnitSerializer$descriptor$2 extends Lambda implements Function0<SerialDescriptor> {

    /* renamed from: c, reason: collision with root package name */
    public static final MonthBasedDateTimeUnitSerializer$descriptor$2 f55679c = new MonthBasedDateTimeUnitSerializer$descriptor$2(0);

    @Metadata
    @SourceDebugExtension
    /* renamed from: kotlinx.datetime.serializers.MonthBasedDateTimeUnitSerializer$descriptor$2$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function1<ClassSerialDescriptorBuilder, Unit> {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55680c = new AnonymousClass1(1);

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            ClassSerialDescriptorBuilder buildClassSerialDescriptor = (ClassSerialDescriptorBuilder) obj;
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            EmptyList emptyList = EmptyList.f53609a;
            IntSerializer intSerializer = IntSerializer.f55831a;
            buildClassSerialDescriptor.a("months", IntSerializer.f55832b, emptyList, false);
            return Unit.f53572a;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return SerialDescriptorsKt.b("kotlinx.datetime.MonthBased", new SerialDescriptor[0], AnonymousClass1.f55680c);
    }
}
