package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {

    /* renamed from: a, reason: collision with root package name */
    public final Operator f40301a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f40302b;

    /* renamed from: c, reason: collision with root package name */
    public static final AnonymousClass1 f40299c = new AnonymousClass1();

    /* renamed from: d, reason: collision with root package name */
    public static final AnonymousClass2 f40300d = new AnonymousClass2();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new AnonymousClass3();

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$1, reason: invalid class name */
    public class AnonymousClass1 implements Operator {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public final boolean a(ArrayList arrayList, long j2) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
                if (dateValidator != null && dateValidator.V2(j2)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public final int getId() {
            return 1;
        }
    }

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$2, reason: invalid class name */
    public class AnonymousClass2 implements Operator {
        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public final boolean a(ArrayList arrayList, long j2) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                CalendarConstraints.DateValidator dateValidator = (CalendarConstraints.DateValidator) it.next();
                if (dateValidator != null && !dateValidator.V2(j2)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public final int getId() {
            return 2;
        }
    }

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$3, reason: invalid class name */
    public class AnonymousClass3 implements Parcelable.Creator<CompositeDateValidator> {
        @Override // android.os.Parcelable.Creator
        public final CompositeDateValidator createFromParcel(Parcel parcel) {
            ArrayList arrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int i2 = parcel.readInt();
            Operator operator = CompositeDateValidator.f40300d;
            if (i2 != 2 && i2 == 1) {
                operator = CompositeDateValidator.f40299c;
            }
            arrayList.getClass();
            return new CompositeDateValidator(arrayList, operator);
        }

        @Override // android.os.Parcelable.Creator
        public final CompositeDateValidator[] newArray(int i2) {
            return new CompositeDateValidator[i2];
        }
    }

    public interface Operator {
        boolean a(ArrayList arrayList, long j2);

        int getId();
    }

    public CompositeDateValidator(ArrayList arrayList, Operator operator) {
        this.f40302b = arrayList;
        this.f40301a = operator;
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public final boolean V2(long j2) {
        return this.f40301a.a(this.f40302b, j2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.f40302b.equals(compositeDateValidator.f40302b) && this.f40301a.getId() == compositeDateValidator.f40301a.getId();
    }

    public final int hashCode() {
        return this.f40302b.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f40302b);
        parcel.writeInt(this.f40301a.getId());
    }
}
