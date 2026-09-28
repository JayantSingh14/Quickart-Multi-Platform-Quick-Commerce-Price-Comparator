package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import java.util.ArrayList;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes3.dex */
final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator<BackStackRecordState> CREATOR = new AnonymousClass1();

    /* renamed from: a, reason: collision with root package name */
    public final int[] f4448a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f4449b;

    /* renamed from: c, reason: collision with root package name */
    public final int[] f4450c;

    /* renamed from: d, reason: collision with root package name */
    public final int[] f4451d;

    /* renamed from: e, reason: collision with root package name */
    public final int f4452e;

    /* renamed from: f, reason: collision with root package name */
    public final String f4453f;

    /* renamed from: g, reason: collision with root package name */
    public final int f4454g;

    /* renamed from: h, reason: collision with root package name */
    public final int f4455h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f4456i;

    /* renamed from: j, reason: collision with root package name */
    public final int f4457j;

    /* renamed from: k, reason: collision with root package name */
    public final CharSequence f4458k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f4459l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f4460m;
    public final boolean n;

    /* renamed from: androidx.fragment.app.BackStackRecordState$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<BackStackRecordState> {
        @Override // android.os.Parcelable.Creator
        public final BackStackRecordState createFromParcel(Parcel parcel) {
            return new BackStackRecordState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BackStackRecordState[] newArray(int i2) {
            return new BackStackRecordState[i2];
        }
    }

    public BackStackRecordState(BackStackRecord backStackRecord) {
        int size = backStackRecord.f4643c.size();
        this.f4448a = new int[size * 6];
        if (!backStackRecord.f4649i) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f4449b = new ArrayList(size);
        this.f4450c = new int[size];
        this.f4451d = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            FragmentTransaction.Op op = (FragmentTransaction.Op) backStackRecord.f4643c.get(i3);
            int i4 = i2 + 1;
            this.f4448a[i2] = op.f4654a;
            ArrayList arrayList = this.f4449b;
            Fragment fragment = op.f4655b;
            arrayList.add(fragment != null ? fragment.mWho : null);
            int[] iArr = this.f4448a;
            iArr[i4] = op.f4656c ? 1 : 0;
            iArr[i2 + 2] = op.f4657d;
            iArr[i2 + 3] = op.f4658e;
            int i5 = i2 + 5;
            iArr[i2 + 4] = op.f4659f;
            i2 += 6;
            iArr[i5] = op.f4660g;
            this.f4450c[i3] = op.f4661h.ordinal();
            this.f4451d[i3] = op.f4662i.ordinal();
        }
        this.f4452e = backStackRecord.f4648h;
        this.f4453f = backStackRecord.f4651k;
        this.f4454g = backStackRecord.v;
        this.f4455h = backStackRecord.f4652l;
        this.f4456i = backStackRecord.f4653m;
        this.f4457j = backStackRecord.n;
        this.f4458k = backStackRecord.o;
        this.f4459l = backStackRecord.p;
        this.f4460m = backStackRecord.q;
        this.n = backStackRecord.r;
    }

    public final BackStackRecord a(FragmentManager fragmentManager) {
        BackStackRecord backStackRecord = new BackStackRecord(fragmentManager);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.f4448a;
            boolean z = true;
            if (i2 >= iArr.length) {
                break;
            }
            FragmentTransaction.Op op = new FragmentTransaction.Op();
            int i4 = i2 + 1;
            op.f4654a = iArr[i2];
            if (FragmentManager.O(2)) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i3 + " base fragment #" + iArr[i4]);
            }
            op.f4661h = Lifecycle.State.values()[this.f4450c[i3]];
            op.f4662i = Lifecycle.State.values()[this.f4451d[i3]];
            int i5 = i2 + 2;
            if (iArr[i4] == 0) {
                z = false;
            }
            op.f4656c = z;
            int i6 = iArr[i5];
            op.f4657d = i6;
            int i7 = iArr[i2 + 3];
            op.f4658e = i7;
            int i8 = i2 + 5;
            int i9 = iArr[i2 + 4];
            op.f4659f = i9;
            i2 += 6;
            int i10 = iArr[i8];
            op.f4660g = i10;
            backStackRecord.f4644d = i6;
            backStackRecord.f4645e = i7;
            backStackRecord.f4646f = i9;
            backStackRecord.f4647g = i10;
            backStackRecord.b(op);
            i3++;
        }
        backStackRecord.f4648h = this.f4452e;
        backStackRecord.f4651k = this.f4453f;
        backStackRecord.f4649i = true;
        backStackRecord.f4652l = this.f4455h;
        backStackRecord.f4653m = this.f4456i;
        backStackRecord.n = this.f4457j;
        backStackRecord.o = this.f4458k;
        backStackRecord.p = this.f4459l;
        backStackRecord.q = this.f4460m;
        backStackRecord.r = this.n;
        backStackRecord.v = this.f4454g;
        int i11 = 0;
        while (true) {
            ArrayList arrayList = this.f4449b;
            if (i11 >= arrayList.size()) {
                backStackRecord.m(1);
                return backStackRecord;
            }
            String str = (String) arrayList.get(i11);
            if (str != null) {
                ((FragmentTransaction.Op) backStackRecord.f4643c.get(i11)).f4655b = fragmentManager.f4566c.b(str);
            }
            i11++;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeIntArray(this.f4448a);
        parcel.writeStringList(this.f4449b);
        parcel.writeIntArray(this.f4450c);
        parcel.writeIntArray(this.f4451d);
        parcel.writeInt(this.f4452e);
        parcel.writeString(this.f4453f);
        parcel.writeInt(this.f4454g);
        parcel.writeInt(this.f4455h);
        TextUtils.writeToParcel(this.f4456i, parcel, 0);
        parcel.writeInt(this.f4457j);
        TextUtils.writeToParcel(this.f4458k, parcel, 0);
        parcel.writeStringList(this.f4459l);
        parcel.writeStringList(this.f4460m);
        parcel.writeInt(this.n ? 1 : 0);
    }

    public BackStackRecordState(Parcel parcel) {
        this.f4448a = parcel.createIntArray();
        this.f4449b = parcel.createStringArrayList();
        this.f4450c = parcel.createIntArray();
        this.f4451d = parcel.createIntArray();
        this.f4452e = parcel.readInt();
        this.f4453f = parcel.readString();
        this.f4454g = parcel.readInt();
        this.f4455h = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f4456i = (CharSequence) creator.createFromParcel(parcel);
        this.f4457j = parcel.readInt();
        this.f4458k = (CharSequence) creator.createFromParcel(parcel);
        this.f4459l = parcel.createStringArrayList();
        this.f4460m = parcel.createStringArrayList();
        this.n = parcel.readInt() != 0;
    }
}
