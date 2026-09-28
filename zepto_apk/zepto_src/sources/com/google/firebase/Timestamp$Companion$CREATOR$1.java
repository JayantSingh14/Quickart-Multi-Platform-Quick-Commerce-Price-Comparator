package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class Timestamp$Companion$CREATOR$1 implements Parcelable.Creator<Timestamp> {
    @Override // android.os.Parcelable.Creator
    public final Timestamp createFromParcel(Parcel source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new Timestamp(source.readLong(), source.readInt());
    }

    @Override // android.os.Parcelable.Creator
    public final Timestamp[] newArray(int i2) {
        return new Timestamp[i2];
    }
}
