package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObservableFloat extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableFloat> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public float f3371a;

    /* renamed from: androidx.databinding.ObservableFloat$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ObservableFloat> {
        @Override // android.os.Parcelable.Creator
        public final ObservableFloat createFromParcel(Parcel parcel) {
            float f2 = parcel.readFloat();
            ObservableFloat observableFloat = new ObservableFloat();
            observableFloat.f3371a = f2;
            return observableFloat;
        }

        @Override // android.os.Parcelable.Creator
        public final ObservableFloat[] newArray(int i2) {
            return new ObservableFloat[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeFloat(this.f3371a);
    }
}
