package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f4590a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f4591b;

    /* renamed from: c, reason: collision with root package name */
    public BackStackRecordState[] f4592c;

    /* renamed from: d, reason: collision with root package name */
    public int f4593d;

    /* renamed from: e, reason: collision with root package name */
    public String f4594e = null;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f4595f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public ArrayList f4596g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f4597h;

    /* renamed from: androidx.fragment.app.FragmentManagerState$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Parcelable.Creator<FragmentManagerState> {
        @Override // android.os.Parcelable.Creator
        public final FragmentManagerState createFromParcel(Parcel parcel) {
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f4594e = null;
            fragmentManagerState.f4595f = new ArrayList();
            fragmentManagerState.f4596g = new ArrayList();
            fragmentManagerState.f4590a = parcel.createStringArrayList();
            fragmentManagerState.f4591b = parcel.createStringArrayList();
            fragmentManagerState.f4592c = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
            fragmentManagerState.f4593d = parcel.readInt();
            fragmentManagerState.f4594e = parcel.readString();
            fragmentManagerState.f4595f = parcel.createStringArrayList();
            fragmentManagerState.f4596g = parcel.createTypedArrayList(BackStackState.CREATOR);
            fragmentManagerState.f4597h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
            return fragmentManagerState;
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentManagerState[] newArray(int i2) {
            return new FragmentManagerState[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStringList(this.f4590a);
        parcel.writeStringList(this.f4591b);
        parcel.writeTypedArray(this.f4592c, i2);
        parcel.writeInt(this.f4593d);
        parcel.writeString(this.f4594e);
        parcel.writeStringList(this.f4595f);
        parcel.writeTypedList(this.f4596g);
        parcel.writeTypedList(this.f4597h);
    }
}
