package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes3.dex */
class BackStackState implements Parcelable {
    public static final Parcelable.Creator<BackStackState> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4461a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4462b;

    /* renamed from: androidx.fragment.app.BackStackState$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<BackStackState> {
        @Override // android.os.Parcelable.Creator
        public final BackStackState createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BackStackState[] newArray(int i2) {
            return new BackStackState[i2];
        }
    }

    public BackStackState(Parcel parcel) {
        this.f4461a = parcel.createStringArrayList();
        this.f4462b = parcel.createTypedArrayList(BackStackRecordState.CREATOR);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.f4461a);
        parcel.writeTypedList(this.f4462b);
    }
}
