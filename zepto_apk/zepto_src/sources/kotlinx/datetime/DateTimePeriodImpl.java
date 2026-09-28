package kotlinx.datetime;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class DateTimePeriodImpl extends DateTimePeriod {

    /* renamed from: a, reason: collision with root package name */
    public final int f55340a;

    /* renamed from: b, reason: collision with root package name */
    public final int f55341b;

    /* renamed from: c, reason: collision with root package name */
    public final long f55342c;

    public DateTimePeriodImpl(int i2, int i3, long j2) {
        this.f55340a = i2;
        this.f55341b = i3;
        this.f55342c = j2;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int a() {
        return this.f55341b;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final int g() {
        return this.f55340a;
    }

    @Override // kotlinx.datetime.DateTimePeriod
    public final long h() {
        return this.f55342c;
    }
}
