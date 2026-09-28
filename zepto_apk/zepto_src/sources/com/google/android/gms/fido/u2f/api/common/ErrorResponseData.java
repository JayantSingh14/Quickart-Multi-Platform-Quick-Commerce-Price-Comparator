package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fido.zzaj;
import com.google.android.gms.internal.fido.zzak;

@SafeParcelable.Class(creator = "ErrorResponseDataCreator")
@SafeParcelable.Reserved({1})
@Deprecated
/* loaded from: classes4.dex */
public class ErrorResponseData extends ResponseData {

    @NonNull
    public static final Parcelable.Creator<ErrorResponseData> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    public final ErrorCode f22488a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22489b;

    public ErrorResponseData(int i2, String str) {
        ErrorCode errorCode;
        ErrorCode[] errorCodeArrValues = ErrorCode.values();
        int length = errorCodeArrValues.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                errorCode = ErrorCode.OTHER_ERROR;
                break;
            }
            errorCode = errorCodeArrValues[i3];
            if (i2 == errorCode.f22487a) {
                break;
            } else {
                i3++;
            }
        }
        this.f22488a = errorCode;
        this.f22489b = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ErrorResponseData)) {
            return false;
        }
        ErrorResponseData errorResponseData = (ErrorResponseData) obj;
        return Objects.equal(this.f22488a, errorResponseData.f22488a) && Objects.equal(this.f22489b, errorResponseData.f22489b);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22488a, this.f22489b);
    }

    public final String toString() {
        zzaj zzajVarA = zzak.a(this);
        zzajVarA.a(this.f22488a.f22487a);
        String str = this.f22489b;
        if (str != null) {
            zzajVarA.b(str, "errorMessage");
        }
        return zzajVarA.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.f22488a.f22487a);
        SafeParcelWriter.writeString(parcel, 3, this.f22489b, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
