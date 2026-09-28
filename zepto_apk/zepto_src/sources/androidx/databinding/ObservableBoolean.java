package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObservableBoolean extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableBoolean> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public boolean f3366a;

    /* renamed from: androidx.databinding.ObservableBoolean$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ObservableBoolean> {
        @Override // android.os.Parcelable.Creator
        public final ObservableBoolean createFromParcel(Parcel parcel) {
            boolean z = parcel.readInt() == 1;
            ObservableBoolean observableBoolean = new ObservableBoolean();
            observableBoolean.f3366a = z;
            return observableBoolean;
        }

        @Override // android.os.Parcelable.Creator
        public final ObservableBoolean[] newArray(int i2) {
            return new ObservableBoolean[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f3366a ? 1 : 0);
    }
}
