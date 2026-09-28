package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/* loaded from: classes4.dex */
final class Month implements Comparable<Month>, Parcelable {
    public static final Parcelable.Creator<Month> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final Calendar f40344a;

    /* renamed from: b, reason: collision with root package name */
    public final int f40345b;

    /* renamed from: c, reason: collision with root package name */
    public final int f40346c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40347d;

    /* renamed from: e, reason: collision with root package name */
    public final int f40348e;

    /* renamed from: f, reason: collision with root package name */
    public final long f40349f;

    /* renamed from: g, reason: collision with root package name */
    public String f40350g;

    /* renamed from: com.google.android.material.datepicker.Month$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<Month> {
        @Override // android.os.Parcelable.Creator
        public final Month createFromParcel(Parcel parcel) {
            return Month.a(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final Month[] newArray(int i2) {
            return new Month[i2];
        }
    }

    public Month(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarC = UtcDates.c(calendar);
        this.f40344a = calendarC;
        this.f40345b = calendarC.get(2);
        this.f40346c = calendarC.get(1);
        this.f40347d = calendarC.getMaximum(7);
        this.f40348e = calendarC.getActualMaximum(5);
        this.f40349f = calendarC.getTimeInMillis();
    }

    public static Month a(int i2, int i3) {
        Calendar calendarG = UtcDates.g(null);
        calendarG.set(1, i2);
        calendarG.set(2, i3);
        return new Month(calendarG);
    }

    public static Month b(long j2) {
        Calendar calendarG = UtcDates.g(null);
        calendarG.setTimeInMillis(j2);
        return new Month(calendarG);
    }

    public final String c() {
        if (this.f40350g == null) {
            this.f40350g = UtcDates.b("yMMMM", Locale.getDefault()).format(new Date(this.f40344a.getTimeInMillis()));
        }
        return this.f40350g;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Month month) {
        return this.f40344a.compareTo(month.f40344a);
    }

    public final int d(Month month) {
        if (!(this.f40344a instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (month.f40345b - this.f40345b) + ((month.f40346c - this.f40346c) * 12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Month)) {
            return false;
        }
        Month month = (Month) obj;
        return this.f40345b == month.f40345b && this.f40346c == month.f40346c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f40345b), Integer.valueOf(this.f40346c)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f40346c);
        parcel.writeInt(this.f40345b);
    }
}
