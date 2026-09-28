package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObservableLong extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableLong> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public long f3373a;

    /* renamed from: androidx.databinding.ObservableLong$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ObservableLong> {
        @Override // android.os.Parcelable.Creator
        public final ObservableLong createFromParcel(Parcel parcel) {
            long j2 = parcel.readLong();
            ObservableLong observableLong = new ObservableLong();
            observableLong.f3373a = j2;
            return observableLong;
        }

        @Override // android.os.Parcelable.Creator
        public final ObservableLong[] newArray(int i2) {
            return new ObservableLong[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f3373a);
    }
}
