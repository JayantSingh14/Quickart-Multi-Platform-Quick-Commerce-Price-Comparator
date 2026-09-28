package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.format.FieldSign;
import kotlinx.datetime.internal.format.PropertyAccessor;
import kotlinx.datetime.internal.format.UnsignedFieldSpec;

@Metadata
/* loaded from: classes3.dex */
final class OffsetFields {

    /* renamed from: a, reason: collision with root package name */
    public static final UnsignedFieldSpec f55470a;

    /* renamed from: b, reason: collision with root package name */
    public static final UnsignedFieldSpec f55471b;

    /* renamed from: c, reason: collision with root package name */
    public static final UnsignedFieldSpec f55472c;

    /* JADX WARN: Type inference failed for: r4v0, types: [kotlinx.datetime.format.OffsetFields$sign$1] */
    static {
        ?? r4 = new FieldSign<UtcOffsetFieldContainer>() { // from class: kotlinx.datetime.format.OffsetFields$sign$1

            /* renamed from: a, reason: collision with root package name */
            public final PropertyAccessor f55475a = new PropertyAccessor(OffsetFields$sign$1$isNegative$1.f55476c);

            @Override // kotlinx.datetime.internal.format.FieldSign
            public final boolean a(Object obj) {
                UtcOffsetFieldContainer obj2 = (UtcOffsetFieldContainer) obj;
                Intrinsics.checkNotNullParameter(obj2, "obj");
                Integer numB = obj2.b();
                if ((numB != null ? numB.intValue() : 0) == 0) {
                    Integer numE = obj2.e();
                    if ((numE != null ? numE.intValue() : 0) == 0) {
                        Integer numR = obj2.r();
                        if ((numR != null ? numR.intValue() : 0) == 0) {
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override // kotlinx.datetime.internal.format.FieldSign
            public final PropertyAccessor b() {
                return this.f55475a;
            }
        };
        f55470a = new UnsignedFieldSpec(new PropertyAccessor(OffsetFields$totalHoursAbs$1.f55477c), 0, 18, r4, 8);
        f55471b = new UnsignedFieldSpec(new PropertyAccessor(OffsetFields$minutesOfHour$1.f55473c), 0, 59, r4, 8);
        f55472c = new UnsignedFieldSpec(new PropertyAccessor(OffsetFields$secondsOfMinute$1.f55474c), 0, 59, r4, 8);
    }
}
