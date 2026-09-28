package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.parser.Copyable;

@Metadata
/* loaded from: classes3.dex */
public final class DateTimeComponentsContents implements DateFieldContainer, TimeFieldContainer, UtcOffsetFieldContainer, DateTimeFieldContainer, Copyable<DateTimeComponentsContents> {

    /* renamed from: a, reason: collision with root package name */
    public final IncompleteLocalDate f55401a;

    /* renamed from: b, reason: collision with root package name */
    public final IncompleteLocalTime f55402b;

    /* renamed from: c, reason: collision with root package name */
    public final IncompleteUtcOffset f55403c;

    /* renamed from: d, reason: collision with root package name */
    public String f55404d;

    public DateTimeComponentsContents() {
        this(0);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer A() {
        return this.f55401a.f55422b;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void B(Integer num) {
        this.f55402b.f55428a = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void C(Integer num) {
        this.f55401a.f55424d = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer D() {
        return this.f55402b.f55428a;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void a(AmPmMarker amPmMarker) {
        this.f55402b.f55430c = amPmMarker;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final Integer b() {
        return this.f55403c.f55435b;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer c() {
        return this.f55402b.f55429b;
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public final Object copy() {
        IncompleteLocalDate incompleteLocalDateCopy = this.f55401a.copy();
        IncompleteLocalTime incompleteLocalTimeCopy = this.f55402b.copy();
        IncompleteUtcOffset incompleteUtcOffset = this.f55403c;
        return new DateTimeComponentsContents(incompleteLocalDateCopy, incompleteLocalTimeCopy, new IncompleteUtcOffset(incompleteUtcOffset.f55434a, incompleteUtcOffset.f55435b, incompleteUtcOffset.f55436c, incompleteUtcOffset.f55437d), this.f55404d);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer d() {
        return this.f55401a.f55424d;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final Integer e() {
        return this.f55403c.f55436c;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof DateTimeComponentsContents)) {
            return false;
        }
        DateTimeComponentsContents dateTimeComponentsContents = (DateTimeComponentsContents) obj;
        return Intrinsics.b(dateTimeComponentsContents.f55401a, this.f55401a) && Intrinsics.b(dateTimeComponentsContents.f55402b, this.f55402b) && Intrinsics.b(dateTimeComponentsContents.f55403c, this.f55403c) && Intrinsics.b(dateTimeComponentsContents.f55404d, this.f55404d);
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final Boolean f() {
        return this.f55403c.f55434a;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final void g(Boolean bool) {
        this.f55403c.f55434a = bool;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void h(DecimalFraction decimalFraction) {
        this.f55402b.h(decimalFraction);
    }

    public final int hashCode() {
        int iHashCode = (this.f55401a.hashCode() ^ this.f55402b.hashCode()) ^ this.f55403c.hashCode();
        String str = this.f55404d;
        return iHashCode ^ (str != null ? str.hashCode() : 0);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer i() {
        return this.f55402b.f55432e;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final void j(Integer num) {
        this.f55403c.f55436c = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void k(Integer num) {
        this.f55402b.f55432e = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void l(Integer num) {
        this.f55401a.f55425e = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final void m(Integer num) {
        this.f55403c.f55435b = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final void n(Integer num) {
        this.f55403c.f55437d = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final AmPmMarker o() {
        return this.f55402b.f55430c;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void p(Integer num) {
        this.f55402b.f55429b = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void q(Integer num) {
        this.f55401a.f55422b = num;
    }

    @Override // kotlinx.datetime.format.UtcOffsetFieldContainer
    public final Integer r() {
        return this.f55403c.f55437d;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer s() {
        return this.f55402b.f55431d;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void t(Integer num) {
        this.f55402b.f55431d = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer u() {
        return this.f55401a.f55421a;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void v(Integer num) {
        this.f55401a.f55423c = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final DecimalFraction w() {
        return this.f55402b.w();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer x() {
        return this.f55401a.f55425e;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void y(Integer num) {
        this.f55401a.f55421a = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer z() {
        return this.f55401a.f55423c;
    }

    public DateTimeComponentsContents(IncompleteLocalDate date, IncompleteLocalTime time, IncompleteUtcOffset offset, String str) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(offset, "offset");
        this.f55401a = date;
        this.f55402b = time;
        this.f55403c = offset;
        this.f55404d = str;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ DateTimeComponentsContents(int i2) {
        int i3 = 0;
        this(new IncompleteLocalDate(i3), new IncompleteLocalTime(i3), new IncompleteUtcOffset(null, null, null, null), null);
    }
}
