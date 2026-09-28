package com.google.android.tv.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
final class zzf extends C$AutoValue_IconClickFallbackImages {
    public static final Parcelable.Creator<zzf> CREATOR = new zze();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.AbstractCollection, java.util.List] */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeList(this.f42208a);
    }
}
