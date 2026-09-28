package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObservableParcelable<T extends Parcelable> extends ObservableField<T> implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableParcelable> CREATOR = new AnonymousClass1();

    /* renamed from: androidx.databinding.ObservableParcelable$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ObservableParcelable> {
        @Override // android.os.Parcelable.Creator
        public final ObservableParcelable createFromParcel(Parcel parcel) {
            Parcelable parcelable = parcel.readParcelable(getClass().getClassLoader());
            ObservableParcelable observableParcelable = new ObservableParcelable();
            observableParcelable.f3370a = parcelable;
            return observableParcelable;
        }

        @Override // android.os.Parcelable.Creator
        public final ObservableParcelable[] newArray(int i2) {
            return new ObservableParcelable[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f3370a, 0);
    }
}
