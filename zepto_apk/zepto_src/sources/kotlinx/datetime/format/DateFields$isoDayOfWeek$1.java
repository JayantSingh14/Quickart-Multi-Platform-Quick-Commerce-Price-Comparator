package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata
/* loaded from: classes3.dex */
public /* synthetic */ class DateFields$isoDayOfWeek$1 extends MutablePropertyReference1Impl {

    /* renamed from: c, reason: collision with root package name */
    public static final DateFields$isoDayOfWeek$1 f55379c = new DateFields$isoDayOfWeek$1("isoDayOfWeek", "getIsoDayOfWeek()Ljava/lang/Integer;", DateFieldContainer.class);

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public final void g(Object obj, Object obj2) {
        ((DateFieldContainer) obj).C((Integer) obj2);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return ((DateFieldContainer) obj).d();
    }
}
