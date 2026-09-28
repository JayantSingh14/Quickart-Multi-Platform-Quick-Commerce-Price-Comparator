package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final String f4606a;

    /* renamed from: b, reason: collision with root package name */
    public final String f4607b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f4608c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f4609d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4610e;

    /* renamed from: f, reason: collision with root package name */
    public final int f4611f;

    /* renamed from: g, reason: collision with root package name */
    public final String f4612g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f4613h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4614i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f4615j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f4616k;

    /* renamed from: l, reason: collision with root package name */
    public final int f4617l;

    /* renamed from: m, reason: collision with root package name */
    public final String f4618m;
    public final int n;
    public final boolean o;

    /* renamed from: androidx.fragment.app.FragmentState$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Parcelable.Creator<FragmentState> {
        @Override // android.os.Parcelable.Creator
        public final FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final FragmentState[] newArray(int i2) {
            return new FragmentState[i2];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f4606a = fragment.getClass().getName();
        this.f4607b = fragment.mWho;
        this.f4608c = fragment.mFromLayout;
        this.f4609d = fragment.mInDynamicContainer;
        this.f4610e = fragment.mFragmentId;
        this.f4611f = fragment.mContainerId;
        this.f4612g = fragment.mTag;
        this.f4613h = fragment.mRetainInstance;
        this.f4614i = fragment.mRemoving;
        this.f4615j = fragment.mDetached;
        this.f4616k = fragment.mHidden;
        this.f4617l = fragment.mMaxState.ordinal();
        this.f4618m = fragment.mTargetWho;
        this.n = fragment.mTargetRequestCode;
        this.o = fragment.mUserVisibleHint;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f4606a);
        sb.append(" (");
        sb.append(this.f4607b);
        sb.append(")}:");
        if (this.f4608c) {
            sb.append(" fromLayout");
        }
        if (this.f4609d) {
            sb.append(" dynamicContainer");
        }
        int i2 = this.f4611f;
        if (i2 != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(i2));
        }
        String str = this.f4612g;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(str);
        }
        if (this.f4613h) {
            sb.append(" retainInstance");
        }
        if (this.f4614i) {
            sb.append(" removing");
        }
        if (this.f4615j) {
            sb.append(" detached");
        }
        if (this.f4616k) {
            sb.append(" hidden");
        }
        String str2 = this.f4618m;
        if (str2 != null) {
            sb.append(" targetWho=");
            sb.append(str2);
            sb.append(" targetRequestCode=");
            sb.append(this.n);
        }
        if (this.o) {
            sb.append(" userVisibleHint");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f4606a);
        parcel.writeString(this.f4607b);
        parcel.writeInt(this.f4608c ? 1 : 0);
        parcel.writeInt(this.f4609d ? 1 : 0);
        parcel.writeInt(this.f4610e);
        parcel.writeInt(this.f4611f);
        parcel.writeString(this.f4612g);
        parcel.writeInt(this.f4613h ? 1 : 0);
        parcel.writeInt(this.f4614i ? 1 : 0);
        parcel.writeInt(this.f4615j ? 1 : 0);
        parcel.writeInt(this.f4616k ? 1 : 0);
        parcel.writeInt(this.f4617l);
        parcel.writeString(this.f4618m);
        parcel.writeInt(this.n);
        parcel.writeInt(this.o ? 1 : 0);
    }

    public FragmentState(Parcel parcel) {
        this.f4606a = parcel.readString();
        this.f4607b = parcel.readString();
        this.f4608c = parcel.readInt() != 0;
        this.f4609d = parcel.readInt() != 0;
        this.f4610e = parcel.readInt();
        this.f4611f = parcel.readInt();
        this.f4612g = parcel.readString();
        this.f4613h = parcel.readInt() != 0;
        this.f4614i = parcel.readInt() != 0;
        this.f4615j = parcel.readInt() != 0;
        this.f4616k = parcel.readInt() != 0;
        this.f4617l = parcel.readInt();
        this.f4618m = parcel.readString();
        this.n = parcel.readInt();
        this.o = parcel.readInt() != 0;
    }
}
