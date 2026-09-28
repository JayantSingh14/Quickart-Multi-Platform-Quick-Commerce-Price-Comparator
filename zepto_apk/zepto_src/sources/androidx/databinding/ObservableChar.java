package androidx.databinding;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class ObservableChar extends BaseObservableField implements Parcelable, Serializable {
    public static final Parcelable.Creator<ObservableChar> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public char f3368a;

    /* renamed from: androidx.databinding.ObservableChar$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ObservableChar> {
        @Override // android.os.Parcelable.Creator
        public final ObservableChar createFromParcel(Parcel parcel) {
            char c2 = (char) parcel.readInt();
            ObservableChar observableChar = new ObservableChar();
            observableChar.f3368a = c2;
            return observableChar;
        }

        @Override // android.os.Parcelable.Creator
        public final ObservableChar[] newArray(int i2) {
            return new ObservableChar[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f3368a);
    }
}
