package io.sentry;

/* loaded from: classes.dex */
public abstract class SentryDate implements Comparable<SentryDate> {
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(SentryDate sentryDate) {
        return Long.valueOf(d()).compareTo(Long.valueOf(sentryDate.d()));
    }

    public long b(SentryDate sentryDate) {
        return d() - sentryDate.d();
    }

    public long c(SentryDate sentryDate) {
        return (sentryDate == null || compareTo(sentryDate) >= 0) ? d() : sentryDate.d();
    }

    public abstract long d();
}
