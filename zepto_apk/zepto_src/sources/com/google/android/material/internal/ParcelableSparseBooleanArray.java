package com.google.android.material.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public class ParcelableSparseBooleanArray extends SparseBooleanArray implements Parcelable {
    public static final Parcelable.Creator<ParcelableSparseBooleanArray> CREATOR = new AnonymousClass1();

    /* renamed from: com.google.android.material.internal.ParcelableSparseBooleanArray$1, reason: invalid class name */
    public class AnonymousClass1 implements Parcelable.Creator<ParcelableSparseBooleanArray> {
        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseBooleanArray createFromParcel(Parcel parcel) {
            int i2 = parcel.readInt();
            ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(i2);
            int[] iArr = new int[i2];
            boolean[] zArr = new boolean[i2];
            parcel.readIntArray(iArr);
            parcel.readBooleanArray(zArr);
            for (int i3 = 0; i3 < i2; i3++) {
                parcelableSparseBooleanArray.put(iArr[i3], zArr[i3]);
            }
            return parcelableSparseBooleanArray;
        }

        @Override // android.os.Parcelable.Creator
        public final ParcelableSparseBooleanArray[] newArray(int i2) {
            return new ParcelableSparseBooleanArray[i2];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int[] iArr = new int[size()];
        boolean[] zArr = new boolean[size()];
        for (int i3 = 0; i3 < size(); i3++) {
            iArr[i3] = keyAt(i3);
            zArr[i3] = valueAt(i3);
        }
        parcel.writeInt(size());
        parcel.writeIntArray(iArr);
        parcel.writeBooleanArray(zArr);
    }
}
