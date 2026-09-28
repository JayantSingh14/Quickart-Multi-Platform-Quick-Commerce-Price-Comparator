package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlinx.datetime.internal.format.GenericFieldSpec;
import kotlinx.datetime.internal.format.PropertyAccessor;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;

@Metadata
/* loaded from: classes3.dex */
final class DateFields {

    /* renamed from: a, reason: collision with root package name */
    public static final GenericFieldSpec f55373a = new GenericFieldSpec(new PropertyAccessor(DateFields$year$1.f55381c), null, 14);

    /* renamed from: b, reason: collision with root package name */
    public static final UnsignedFieldSpec f55374b = new UnsignedFieldSpec(new PropertyAccessor(DateFields$month$1.f55380c), 1, 12, null, 56);

    /* renamed from: c, reason: collision with root package name */
    public static final UnsignedFieldSpec f55375c = new UnsignedFieldSpec(new PropertyAccessor(DateFields$dayOfMonth$1.f55377c), 1, 31, null, 56);

    /* renamed from: d, reason: collision with root package name */
    public static final UnsignedFieldSpec f55376d = new UnsignedFieldSpec(new PropertyAccessor(DateFields$isoDayOfWeek$1.f55379c), 1, 7, null, 56);

    static {
        new UnsignedFieldSpec(new PropertyAccessor(DateFields$dayOfYear$1.f55378c), 1, 366, null, 56);
    }
}
