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
public final class DateTimeUnitSerializer$impl$2 extends Lambda implements Function0<SealedClassSerializer<DateTimeUnit>> {

    /* renamed from: c, reason: collision with root package name */
    public static final DateTimeUnitSerializer$impl$2 f55653c = new DateTimeUnitSerializer$impl$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new SealedClassSerializer("kotlinx.datetime.DateTimeUnit", Reflection.a(DateTimeUnit.class), new KClass[]{Reflection.a(DateTimeUnit.DayBased.class), Reflection.a(DateTimeUnit.MonthBased.class), Reflection.a(DateTimeUnit.TimeBased.class)}, new KSerializer[]{DayBasedDateTimeUnitSerializer.f55654a, MonthBasedDateTimeUnitSerializer.f55677a, TimeBasedDateTimeUnitSerializer.f55682a});
    }
}
