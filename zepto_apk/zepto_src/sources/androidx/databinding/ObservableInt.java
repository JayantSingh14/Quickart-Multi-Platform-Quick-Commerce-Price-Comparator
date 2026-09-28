package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObservableInt extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableInt> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public int f3372a;

    /* renamed from: androidx.databinding.ObservableInt$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ObservableInt> {
        @Override // android.os.Parcelable.Creator
        public final ObservableInt createFromParcel(Parcel parcel) {
            int i2 = parcel.readInt();
            ObservableInt observableInt = new ObservableInt();
            observableInt.f3372a = i2;
            return observableInt;
        }

        @Override // android.os.Parcelable.Creator
        public final ObservableInt[] newArray(int i2) {
            return new ObservableInt[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f3372a);
    }
}
