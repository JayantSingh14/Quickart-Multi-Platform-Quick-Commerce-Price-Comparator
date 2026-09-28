package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes4.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final Month f40275a;

    /* renamed from: b, reason: collision with root package name */
    public final Month f40276b;

    /* renamed from: c, reason: collision with root package name */
    public final DateValidator f40277c;

    /* renamed from: d, reason: collision with root package name */
    public final Month f40278d;

    /* renamed from: e, reason: collision with root package name */
    public final int f40279e;

    /* renamed from: f, reason: collision with root package name */
    public final int f40280f;

    /* renamed from: g, reason: collision with root package name */
    public final int f40281g;

    /* renamed from: com.google.android.material.datepicker.CalendarConstraints$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<CalendarConstraints> {
        @Override // android.os.Parcelable.Creator
        public final CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final CalendarConstraints[] newArray(int i2) {
            return new CalendarConstraints[i2];
        }
    }

    public static final class Builder {

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f40282c = 0;

        /* renamed from: a, reason: collision with root package name */
        public Long f40283a;

        /* renamed from: b, reason: collision with root package name */
        public DateValidator f40284b = new DateValidatorPointForward(Long.MIN_VALUE);

        static {
            UtcDates.a(Month.a(1900, 0).f40349f);
            UtcDates.a(Month.a(2100, 11).f40349f);
        }
    }

    public interface DateValidator extends Parcelable {
        boolean V2(long j2);
    }

    public CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i2) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.f40275a = month;
        this.f40276b = month2;
        this.f40278d = month3;
        this.f40279e = i2;
        this.f40277c = dateValidator;
        if (month3 != null && month.f40344a.compareTo(month3.f40344a) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.f40344a.compareTo(month2.f40344a) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i2 < 0 || i2 > UtcDates.g(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f40281g = month.d(month2) + 1;
        this.f40280f = (month2.f40346c - month.f40346c) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.f40275a.equals(calendarConstraints.f40275a) && this.f40276b.equals(calendarConstraints.f40276b) && Objects.equals(this.f40278d, calendarConstraints.f40278d) && this.f40279e == calendarConstraints.f40279e && this.f40277c.equals(calendarConstraints.f40277c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f40275a, this.f40276b, this.f40278d, Integer.valueOf(this.f40279e), this.f40277c});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f40275a, 0);
        parcel.writeParcelable(this.f40276b, 0);
        parcel.writeParcelable(this.f40278d, 0);
        parcel.writeParcelable(this.f40277c, 0);
        parcel.writeInt(this.f40279e);
    }
}
