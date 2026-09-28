package com.google.android.tv.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
final class zze implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new zzf(parcel.readArrayList(IconClickFallbackImages.class.getClassLoader()));
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new zzf[i2];
    }
}
