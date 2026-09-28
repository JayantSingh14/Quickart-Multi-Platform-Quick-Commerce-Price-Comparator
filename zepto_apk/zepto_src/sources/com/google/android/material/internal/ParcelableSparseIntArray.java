package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public class ParcelableSparseIntArray extends SparseIntArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseIntArray> CREATOR = new AnonymousClass1();

    /* renamed from: com.google.android.material.internal.ParcelableSparseIntArray$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ParcelableSparseIntArray> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseIntArray createFromParcel(Parcel parcel) {
            int i2 = parcel.readInt();
            ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(i2);
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            parcel.readIntArray(iArr);
            parcel.readIntArray(iArr2);
            for (int i3 = 0; i3 < i2; i3++) {
                parcelableSparseIntArray.put(iArr[i3], iArr2[i3]);
            }
            return parcelableSparseIntArray;
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseIntArray[] newArray(int i2) {
            return new ParcelableSparseIntArray[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int[] iArr = new int[size()];
        int[] iArr2 = new int[size()];
        for (int i3 = 0; i3 < size(); i3++) {
            iArr[i3] = keyAt(i3);
            iArr2[i3] = valueAt(i3);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeIntArray(iArr2);
    }
}
