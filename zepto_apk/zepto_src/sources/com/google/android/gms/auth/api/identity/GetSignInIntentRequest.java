package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GetSignInIntentRequestCreator")
@Deprecated
/* loaded from: classes4.dex */
public class GetSignInIntentRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GetSignInIntentRequest> CREATOR = new zbi();

    /* renamed from: a, reason: collision with root package name */
    public final String f22102a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22103b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22104c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22105d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22106e;

    /* renamed from: f, reason: collision with root package name */
    public final int f22107f;

    public static final class Builder {
    }

    public GetSignInIntentRequest(String str, String str2, int i2, String str3, String str4, boolean z) {
        Preconditions.checkNotNull(str);
        this.f22102a = str;
        this.f22103b = str2;
        this.f22104c = str3;
        this.f22105d = str4;
        this.f22106e = z;
        this.f22107f = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof GetSignInIntentRequest)) {
            return false;
        }
        GetSignInIntentRequest getSignInIntentRequest = (GetSignInIntentRequest) obj;
        return Objects.equal(this.f22102a, getSignInIntentRequest.f22102a) && Objects.equal(this.f22105d, getSignInIntentRequest.f22105d) && Objects.equal(this.f22103b, getSignInIntentRequest.f22103b) && Objects.equal(Boolean.valueOf(this.f22106e), Boolean.valueOf(getSignInIntentRequest.f22106e)) && this.f22107f == getSignInIntentRequest.f22107f;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22102a, this.f22103b, this.f22105d, Boolean.valueOf(this.f22106e), Integer.valueOf(this.f22107f));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f22102a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f22103b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22104c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22105d, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f22106e);
        SafeParcelWriter.writeInt(parcel, 6, this.f22107f);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
