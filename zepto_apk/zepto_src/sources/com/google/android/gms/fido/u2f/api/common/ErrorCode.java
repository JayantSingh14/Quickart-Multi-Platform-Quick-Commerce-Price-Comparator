package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

@Deprecated
/* loaded from: classes4.dex */
public enum ErrorCode implements Parcelable {
    /* JADX INFO: Fake field, exist only in values array */
    OK(0),
    OTHER_ERROR(1),
    /* JADX INFO: Fake field, exist only in values array */
    BAD_REQUEST(2),
    /* JADX INFO: Fake field, exist only in values array */
    CONFIGURATION_UNSUPPORTED(3),
    /* JADX INFO: Fake field, exist only in values array */
    DEVICE_INELIGIBLE(4),
    /* JADX INFO: Fake field, exist only in values array */
    TIMEOUT(5);


    @NonNull
    public static final Parcelable.Creator<ErrorCode> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    public final int f22487a;

    ErrorCode(int i2) {
        this.f22487a = i2;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f22487a);
    }
}
