package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;

@Metadata
/* loaded from: classes3.dex */
public /* synthetic */ class DateTimeComponentsKt$timeZoneField$1 extends MutablePropertyReference1Impl {

    /* renamed from: c, reason: collision with root package name */
    public static final DateTimeComponentsKt$timeZoneField$1 f55408c = new DateTimeComponentsKt$timeZoneField$1("timeZoneId", "getTimeZoneId()Ljava/lang/String;", DateTimeComponentsContents.class);

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public final void g(Object obj, Object obj2) {
        ((DateTimeComponentsContents) obj).f55404d = (String) obj2;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return ((DateTimeComponentsContents) obj).f55404d;
    }
}
