package kotlinx.datetime.format;

import j$.time.DateTimeException;
import j$.time.ZoneOffset;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.UtcOffsetJvmKt;
import kotlinx.datetime.internal.format.parser.Copyable;
import org.apache.commons.lang3.StringUtils;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class IncompleteUtcOffset implements UtcOffsetFieldContainer, Copyable<IncompleteUtcOffset> {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f55434a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f55435b;

    /* renamed from: c, reason: collision with root package name */
    public Integer f55436c;

    /* renamed from: d, reason: collision with root package name */
    public Integer f55437d;

    public IncompleteUtcOffset() {
        this(null, null, null, null);
    }

    public final UtcOffset a() {
        int i2 = Intrinsics.b(this.f55434a, Boolean.TRUE) ? -1 : 1;
        Integer num = this.f55435b;
        Integer numValueOf = num != null ? Integer.valueOf(num.intValue() * i2) : null;
        Integer num2 = this.f55436c;
        Integer numValueOf2 = num2 != null ? Integer.valueOf(num2.intValue() * i2) : null;
        Integer num3 = this.f55437d;
        Integer numValueOf3 = num3 != null ? Integer.valueOf(num3.intValue() * i2) : null;
        Lazy lazy = UtcOffsetJvmKt.f55364a;
        try {
            if (numValueOf != null) {
                ZoneOffset zoneOffsetOfHoursMinutesSeconds = ZoneOffset.ofHoursMinutesSeconds(numValueOf.intValue(), numValueOf2 != null ? numValueOf2.intValue() : 0, numValueOf3 != null ? numValueOf3.intValue() : 0);
                Intrinsics.checkNotNullExpressionValue(zoneOffsetOfHoursMinutesSeconds, "ofHoursMinutesSeconds(...)");
                return new UtcOffset(zoneOffsetOfHoursMinutesSeconds);
            }
            if (numValueOf2 != null) {
                ZoneOffset zoneOffsetOfHoursMinutesSeconds2 = ZoneOffset.ofHoursMinutesSeconds(numValueOf2.intValue() / 60, numValueOf2.intValue() % 60, numValueOf3 != null ? numValueOf3.intValue() : 0);
                Intrinsics.checkNotNullExpressionValue(zoneOffsetOfHoursMinutesSeconds2, "ofHoursMinutesSeconds(...)");
                return new UtcOffset(zoneOffsetOfHoursMinutesSeconds2);
            }
            ZoneOffset zoneOffsetOfTotalSeconds = ZoneOffset.ofTotalSeconds(numValueOf3 != null ? numValueOf3.intValue() : 0);
            Intrinsics.checkNotNullExpressionValue(zoneOffsetOfTotalSeconds, "ofTotalSeconds(...)");
            return new UtcOffset(zoneOffsetOfTotalSeconds);
        } catch (DateTimeException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final Integer b() {
        return this.f55435b;
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public final Object copy() {
        return new IncompleteUtcOffset(this.f55434a, this.f55435b, this.f55436c, this.f55437d);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final Integer e() {
        return this.f55436c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof IncompleteUtcOffset)) {
            return false;
        }
        IncompleteUtcOffset incompleteUtcOffset = (IncompleteUtcOffset) obj;
        return Intrinsics.b(this.f55434a, incompleteUtcOffset.f55434a) && Intrinsics.b(this.f55435b, incompleteUtcOffset.f55435b) && Intrinsics.b(this.f55436c, incompleteUtcOffset.f55436c) && Intrinsics.b(this.f55437d, incompleteUtcOffset.f55437d);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final Boolean f() {
        return this.f55434a;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final void g(Boolean bool) {
        this.f55434a = bool;
    }

    public final int hashCode() {
        Boolean bool = this.f55434a;
        int iHashCode = bool != null ? bool.hashCode() : 0;
        Integer num = this.f55435b;
        int iHashCode2 = iHashCode + (num != null ? num.hashCode() : 0);
        Integer num2 = this.f55436c;
        int iHashCode3 = iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        Integer num3 = this.f55437d;
        return iHashCode3 + (num3 != null ? num3.hashCode() : 0);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final void j(Integer num) {
        this.f55436c = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final void m(Integer num) {
        this.f55435b = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final void n(Integer num) {
        this.f55437d = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final Integer r() {
        return this.f55437d;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Boolean bool = this.f55434a;
        sb.append(bool != null ? bool.booleanValue() ? "-" : "+" : StringUtils.SPACE);
        Object obj = this.f55435b;
        if (obj == null) {
            obj = "??";
        }
        sb.append(obj);
        sb.append(':');
        Object obj2 = this.f55436c;
        if (obj2 == null) {
            obj2 = "??";
        }
        sb.append(obj2);
        sb.append(':');
        Integer num = this.f55437d;
        sb.append(num != null ? num : "??");
        return sb.toString();
    }

    public IncompleteUtcOffset(Boolean bool, Integer num, Integer num2, Integer num3) {
        this.f55434a = bool;
        this.f55435b = num;
        this.f55436c = num2;
        this.f55437d = num3;
    }
}
