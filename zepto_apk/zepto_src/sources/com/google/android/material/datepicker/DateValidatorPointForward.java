package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.Arrays;

/* loaded from: classes4.dex */
public class DateValidatorPointForward implements CalendarConstraints.DateValidator {
    public static final Parcelable.Creator<DateValidatorPointForward> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final long f40312a;

    /* renamed from: com.google.android.material.datepicker.DateValidatorPointForward$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<DateValidatorPointForward> {
        @Override // android.os.Parcelable.Creator
        public final DateValidatorPointForward createFromParcel(Parcel parcel) {
            return new DateValidatorPointForward(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final DateValidatorPointForward[] newArray(int i2) {
            return new DateValidatorPointForward[i2];
        }
    }

    public DateValidatorPointForward(long j2) {
        this.f40312a = j2;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean V2(long j2) {
        return j2 >= this.f40312a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DateValidatorPointForward) && this.f40312a == ((DateValidatorPointForward) obj).f40312a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f40312a)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f40312a);
    }
}
