package com.google.android.tv.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
final class zzd extends C$AutoValue_IconClickFallbackImage {
    public static final Parcelable.Creator<zzd> CREATOR = new zzc();

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f42203a);
        parcel.writeInt(this.f42204b);
        String str = this.f42205c;
        if (str == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(str);
        }
        String str2 = this.f42206d;
        if (str2 == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(str2);
        }
        String str3 = this.f42207e;
        if (str3 == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(str3);
        }
    }
}
