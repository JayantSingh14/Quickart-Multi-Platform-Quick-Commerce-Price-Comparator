package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.GenericFieldSpec;
import kotlinx.datetime.internal.format.PropertyAccessor;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;

@Metadata
/* loaded from: classes3.dex */
final class TimeFields {

    /* renamed from: a, reason: collision with root package name */
    public static final UnsignedFieldSpec f55485a = new UnsignedFieldSpec(new PropertyAccessor(TimeFields$hour$1.f55491c), 0, 23, null, 56);

    /* renamed from: b, reason: collision with root package name */
    public static final UnsignedFieldSpec f55486b = new UnsignedFieldSpec(new PropertyAccessor(TimeFields$minute$1.f55493c), 0, 59, null, 56);

    /* renamed from: c, reason: collision with root package name */
    public static final UnsignedFieldSpec f55487c = new UnsignedFieldSpec(new PropertyAccessor(TimeFields$second$1.f55494c), 0, 59, null, 40);

    /* renamed from: d, reason: collision with root package name */
    public static final GenericFieldSpec f55488d = new GenericFieldSpec(new PropertyAccessor(TimeFields$fractionOfSecond$1.f55490c), new DecimalFraction(0, 9), 10);

    static {
        new GenericFieldSpec(new PropertyAccessor(TimeFields$amPm$1.f55489c), null, 14);
        new UnsignedFieldSpec(new PropertyAccessor(TimeFields$hourOfAmPm$1.f55492c), 1, 12, null, 56);
    }
}
