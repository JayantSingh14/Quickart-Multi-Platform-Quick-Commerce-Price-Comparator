package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObservableDouble extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableDouble> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public double f3369a;

    /* renamed from: androidx.databinding.ObservableDouble$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ObservableDouble> {
        @Override // android.os.Parcelable.Creator
        public final ObservableDouble createFromParcel(Parcel parcel) {
            double d2 = parcel.readDouble();
            ObservableDouble observableDouble = new ObservableDouble();
            observableDouble.f3369a = d2;
            return observableDouble;
        }

        @Override // android.os.Parcelable.Creator
        public final ObservableDouble[] newArray(int i2) {
            return new ObservableDouble[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeDouble(this.f3369a);
    }
}
