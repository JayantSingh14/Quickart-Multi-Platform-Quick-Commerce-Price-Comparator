package io.sentry;

import java.util.Date;

/* loaded from: classes.dex */
public final class SentryNanotimeDate extends SentryDate {

    /* renamed from: a, reason: collision with root package name */
    public final Date f51846a;

    /* renamed from: b, reason: collision with root package name */
    public final long f51847b;

    public SentryNanotimeDate() {
        this(DateUtils.a(), System.nanoTime());
    }

    @Override // io.sentry.SentryDate, java.lang.Comparable
    /* renamed from: a */
    public final int compareTo(SentryDate sentryDate) {
        if (!(sentryDate instanceof SentryNanotimeDate)) {
            return super.compareTo(sentryDate);
        }
        SentryNanotimeDate sentryNanotimeDate = (SentryNanotimeDate) sentryDate;
        long time = this.f51846a.getTime();
        long time2 = sentryNanotimeDate.f51846a.getTime();
        return time == time2 ? Long.valueOf(this.f51847b).compareTo(Long.valueOf(sentryNanotimeDate.f51847b)) : Long.valueOf(time).compareTo(Long.valueOf(time2));
    }

    @Override // io.sentry.SentryDate
    public final long b(SentryDate sentryDate) {
        return sentryDate instanceof SentryNanotimeDate ? this.f51847b - ((SentryNanotimeDate) sentryDate).f51847b : super.b(sentryDate);
    }

    @Override // io.sentry.SentryDate
    public final long c(SentryDate sentryDate) {
        if (sentryDate == null || !(sentryDate instanceof SentryNanotimeDate)) {
            return super.c(sentryDate);
        }
        SentryNanotimeDate sentryNanotimeDate = (SentryNanotimeDate) sentryDate;
        int iCompareTo = compareTo(sentryDate);
        long j2 = this.f51847b;
        long j3 = sentryNanotimeDate.f51847b;
        if (iCompareTo < 0) {
            return d() + (j3 - j2);
        }
        return sentryNanotimeDate.d() + (j2 - j3);
    }

    @Override // io.sentry.SentryDate
    public final long d() {
        return this.f51846a.getTime() * 1000000;
    }

    public SentryNanotimeDate(Date date, long j2) {
        this.f51846a = date;
        this.f51847b = j2;
    }
}
