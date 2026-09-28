package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.internal.DecimalFraction;
import kotlinx.datetime.internal.format.parser.Copyable;

@Metadata
/* loaded from: classes3.dex */
public final class IncompleteLocalDateTime implements DateTimeFieldContainer, DateFieldContainer, TimeFieldContainer, Copyable<IncompleteLocalDateTime> {

    /* renamed from: a, reason: collision with root package name */
    public final IncompleteLocalDate f55426a;

    /* renamed from: b, reason: collision with root package name */
    public final IncompleteLocalTime f55427b;

    public IncompleteLocalDateTime() {
        this(0);
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer A() {
        return this.f55426a.f55422b;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void B(Integer num) {
        this.f55427b.f55428a = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void C(Integer num) {
        this.f55426a.f55424d = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer D() {
        return this.f55427b.f55428a;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void a(AmPmMarker amPmMarker) {
        this.f55427b.f55430c = amPmMarker;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer c() {
        return this.f55427b.f55429b;
    }

    @Override // kotlinx.datetime.internal.format.parser.Copyable
    public final Object copy() {
        return new IncompleteLocalDateTime(this.f55426a.copy(), this.f55427b.copy());
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer d() {
        return this.f55426a.f55424d;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void h(DecimalFraction decimalFraction) {
        this.f55427b.h(decimalFraction);
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer i() {
        return this.f55427b.f55432e;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void k(Integer num) {
        this.f55427b.f55432e = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void l(Integer num) {
        this.f55426a.f55425e = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final AmPmMarker o() {
        return this.f55427b.f55430c;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void p(Integer num) {
        this.f55427b.f55429b = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void q(Integer num) {
        this.f55426a.f55422b = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final Integer s() {
        return this.f55427b.f55431d;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final void t(Integer num) {
        this.f55427b.f55431d = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer u() {
        return this.f55426a.f55421a;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void v(Integer num) {
        this.f55426a.f55423c = num;
    }

    @Override // kotlinx.datetime.format.TimeFieldContainer
    public final DecimalFraction w() {
        return this.f55427b.w();
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer x() {
        return this.f55426a.f55425e;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final void y(Integer num) {
        this.f55426a.f55421a = num;
    }

    @Override // kotlinx.datetime.format.DateFieldContainer
    public final Integer z() {
        return this.f55426a.f55423c;
    }

    public IncompleteLocalDateTime(IncompleteLocalDate date, IncompleteLocalTime time) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(time, "time");
        this.f55426a = date;
        this.f55427b = time;
    }

    public /* synthetic */ IncompleteLocalDateTime(int i2) {
        this(new IncompleteLocalDate(0), new IncompleteLocalTime(0));
    }
}
