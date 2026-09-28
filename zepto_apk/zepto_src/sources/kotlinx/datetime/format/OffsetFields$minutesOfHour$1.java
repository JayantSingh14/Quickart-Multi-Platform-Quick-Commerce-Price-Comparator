package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata
/* loaded from: classes3.dex */
public /* synthetic */ class OffsetFields$minutesOfHour$1 extends MutablePropertyReference1Impl {

    /* renamed from: c, reason: collision with root package name */
    public static final OffsetFields$minutesOfHour$1 f55473c = new OffsetFields$minutesOfHour$1("minutesOfHour", "getMinutesOfHour()Ljava/lang/Integer;", UtcOffsetFieldContainer.class);

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public final void g(Object obj, Object obj2) {
        ((UtcOffsetFieldContainer) obj).j((Integer) obj2);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return ((UtcOffsetFieldContainer) obj).e();
    }
}
