package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObservableByte extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableByte> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public byte f3367a;

    /* renamed from: androidx.databinding.ObservableByte$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ObservableByte> {
        @Override // android.os.Parcelable.Creator
        public final ObservableByte createFromParcel(Parcel parcel) {
            byte b2 = parcel.readByte();
            ObservableByte observableByte = new ObservableByte();
            observableByte.f3367a = b2;
            return observableByte;
        }

        @Override // android.os.Parcelable.Creator
        public final ObservableByte[] newArray(int i2) {
            return new ObservableByte[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeByte(this.f3367a);
    }
}
