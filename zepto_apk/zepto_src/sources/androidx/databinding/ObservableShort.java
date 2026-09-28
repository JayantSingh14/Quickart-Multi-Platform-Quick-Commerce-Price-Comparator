package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObservableShort extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableShort> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public short f3374a;

    /* renamed from: androidx.databinding.ObservableShort$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ObservableShort> {
        @Override // android.os.Parcelable.Creator
        public final ObservableShort createFromParcel(Parcel parcel) {
            short s = (short) parcel.readInt();
            ObservableShort observableShort = new ObservableShort();
            observableShort.f3374a = s;
            return observableShort;
        }

        @Override // android.os.Parcelable.Creator
        public final ObservableShort[] newArray(int i2) {
            return new ObservableShort[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f3374a);
    }
}
