package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlinx.datetime.internal.DecimalFraction;

@Metadata
/* loaded from: classes3.dex */
public /* synthetic */ class TimeFields$fractionOfSecond$1 extends MutablePropertyReference1Impl {

    /* renamed from: c, reason: collision with root package name */
    public static final TimeFields$fractionOfSecond$1 f55490c = new TimeFields$fractionOfSecond$1("fractionOfSecond", "getFractionOfSecond()Lkotlinx/datetime/internal/DecimalFraction;", TimeFieldContainer.class);

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KMutableProperty1
    public final void g(Object obj, Object obj2) {
        ((TimeFieldContainer) obj).h((DecimalFraction) obj2);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return ((TimeFieldContainer) obj).w();
    }
}
