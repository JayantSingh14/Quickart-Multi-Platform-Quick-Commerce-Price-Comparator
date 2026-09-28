package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
final class zzc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int i2 = parcel.readInt();
        for (ErrorCode errorCode : ErrorCode.values()) {
            if (i2 == errorCode.f22487a) {
                return errorCode;
            }
        }
        return ErrorCode.OTHER_ERROR;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i2) {
        return new ErrorCode[i2];
    }
}
