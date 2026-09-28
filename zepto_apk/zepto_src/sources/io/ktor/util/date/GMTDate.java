package io.ktor.util.date;

import android.support.v4.media.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class GMTDate implements Comparable<GMTDate> {

    /* renamed from: a, reason: collision with root package name */
    public final int f50535a;

    /* renamed from: b, reason: collision with root package name */
    public final int f50536b;

    /* renamed from: c, reason: collision with root package name */
    public final int f50537c;

    /* renamed from: d, reason: collision with root package name */
    public final WeekDay f50538d;

    /* renamed from: e, reason: collision with root package name */
    public final int f50539e;

    /* renamed from: f, reason: collision with root package name */
    public final int f50540f;

    /* renamed from: g, reason: collision with root package name */
    public final Month f50541g;

    /* renamed from: h, reason: collision with root package name */
    public final int f50542h;

    /* renamed from: i, reason: collision with root package name */
    public final long f50543i;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    static {
        DateJvmKt.b(0L);
    }

    public GMTDate(int i2, int i3, int i4, WeekDay dayOfWeek, int i5, int i6, Month month, int i7, long j2) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "dayOfWeek");
        Intrinsics.checkNotNullParameter(month, "month");
        this.f50535a = i2;
        this.f50536b = i3;
        this.f50537c = i4;
        this.f50538d = dayOfWeek;
        this.f50539e = i5;
        this.f50540f = i6;
        this.f50541g = month;
        this.f50542h = i7;
        this.f50543i = j2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(GMTDate gMTDate) {
        GMTDate other = gMTDate;
        Intrinsics.checkNotNullParameter(other, "other");
        long j2 = other.f50543i;
        long j3 = this.f50543i;
        if (j3 < j2) {
            return -1;
        }
        return j3 == j2 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GMTDate)) {
            return false;
        }
        GMTDate gMTDate = (GMTDate) obj;
        return this.f50535a == gMTDate.f50535a && this.f50536b == gMTDate.f50536b && this.f50537c == gMTDate.f50537c && this.f50538d == gMTDate.f50538d && this.f50539e == gMTDate.f50539e && this.f50540f == gMTDate.f50540f && this.f50541g == gMTDate.f50541g && this.f50542h == gMTDate.f50542h && this.f50543i == gMTDate.f50543i;
    }

    public final int hashCode() {
        return Long.hashCode(this.f50543i) + a.b(this.f50542h, (this.f50541g.hashCode() + a.b(this.f50540f, a.b(this.f50539e, (this.f50538d.hashCode() + a.b(this.f50537c, a.b(this.f50536b, Integer.hashCode(this.f50535a) * 31, 31), 31)) * 31, 31), 31)) * 31, 31);
    }

    public final String toString() {
        return "GMTDate(seconds=" + this.f50535a + ", minutes=" + this.f50536b + ", hours=" + this.f50537c + ", dayOfWeek=" + this.f50538d + ", dayOfMonth=" + this.f50539e + ", dayOfYear=" + this.f50540f + ", month=" + this.f50541g + ", year=" + this.f50542h + ", timestamp=" + this.f50543i + ')';
    }
}
