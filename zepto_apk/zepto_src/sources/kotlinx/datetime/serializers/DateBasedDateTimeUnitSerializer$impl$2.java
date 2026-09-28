package kotlinx.datetime.serializers;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SealedClassSerializer;

@Metadata
/* loaded from: classes3.dex */
public final class DateBasedDateTimeUnitSerializer$impl$2 extends Lambda implements Function0<SealedClassSerializer<DateTimeUnit.DateBased>> {

    /* renamed from: c, reason: collision with root package name */
    public static final DateBasedDateTimeUnitSerializer$impl$2 f55642c = new DateBasedDateTimeUnitSerializer$impl$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new SealedClassSerializer("kotlinx.datetime.DateTimeUnit.DateBased", Reflection.a(DateTimeUnit.DateBased.class), new KClass[]{Reflection.a(DateTimeUnit.DayBased.class), Reflection.a(DateTimeUnit.MonthBased.class)}, new KSerializer[]{DayBasedDateTimeUnitSerializer.f55654a, MonthBasedDateTimeUnitSerializer.f55677a});
    }
}
