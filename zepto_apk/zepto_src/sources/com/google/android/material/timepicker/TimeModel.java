package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes4.dex */
class TimeModel implements Parcelable {
    public static final Parcelable.Creator<TimeModel> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final MaxInputValidator f41415a;

    /* renamed from: b, reason: collision with root package name */
    public final MaxInputValidator f41416b;

    /* renamed from: c, reason: collision with root package name */
    public final int f41417c;

    /* renamed from: d, reason: collision with root package name */
    public int f41418d;

    /* renamed from: e, reason: collision with root package name */
    public int f41419e;

    /* renamed from: f, reason: collision with root package name */
    public int f41420f;

    /* renamed from: g, reason: collision with root package name */
    public int f41421g;

    /* renamed from: com.google.android.material.timepicker.TimeModel$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<TimeModel> {
        @Override // android.os.Parcelable.Creator
        public final TimeModel createFromParcel(Parcel parcel) {
            return new TimeModel(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final TimeModel[] newArray(int i2) {
            return new TimeModel[i2];
        }
    }

    public TimeModel() {
        this(0, 0, 10, 0);
    }

    public static String a(Resources resources, CharSequence charSequence, String str) {
        try {
            return String.format(resources.getConfiguration().locale, str, Integer.valueOf(Integer.parseInt(String.valueOf(charSequence))));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public final int b() {
        if (this.f41417c == 1) {
            return this.f41418d % 24;
        }
        int i2 = this.f41418d;
        if (i2 % 12 == 0) {
            return 12;
        }
        return this.f41421g == 1 ? i2 - 12 : i2;
    }

    public final void c(int i2) {
        if (this.f41417c == 1) {
            this.f41418d = i2;
        } else {
            this.f41418d = (i2 % 12) + (this.f41421g != 1 ? 0 : 12);
        }
    }

    public final void d(int i2) {
        if (i2 != this.f41421g) {
            this.f41421g = i2;
            int i3 = this.f41418d;
            if (i3 < 12 && i2 == 1) {
                this.f41418d = i3 + 12;
            } else {
                if (i3 < 12 || i2 != 0) {
                    return;
                }
                this.f41418d = i3 - 12;
            }
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimeModel)) {
            return false;
        }
        TimeModel timeModel = (TimeModel) obj;
        return this.f41418d == timeModel.f41418d && this.f41419e == timeModel.f41419e && this.f41417c == timeModel.f41417c && this.f41420f == timeModel.f41420f;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f41417c), Integer.valueOf(this.f41418d), Integer.valueOf(this.f41419e), Integer.valueOf(this.f41420f)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f41418d);
        parcel.writeInt(this.f41419e);
        parcel.writeInt(this.f41420f);
        parcel.writeInt(this.f41417c);
    }

    public TimeModel(int i2, int i3, int i4, int i5) {
        this.f41418d = i2;
        this.f41419e = i3;
        this.f41420f = i4;
        this.f41417c = i5;
        this.f41421g = i2 >= 12 ? 1 : 0;
        this.f41415a = new MaxInputValidator(59);
        this.f41416b = new MaxInputValidator(i5 == 1 ? 23 : 12);
    }
}
