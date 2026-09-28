package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GetPhoneNumberHintIntentRequestCreator")
/* loaded from: classes4.dex */
public class GetPhoneNumberHintIntentRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GetPhoneNumberHintIntentRequest> CREATOR = new zbh();

    /* renamed from: a, reason: collision with root package name */
    public final int f22101a;

    public static final class Builder {
        public static GetPhoneNumberHintIntentRequest a() {
            return new GetPhoneNumberHintIntentRequest(0);
        }
    }

    public GetPhoneNumberHintIntentRequest(int i2) {
        this.f22101a = i2;
    }

    public static Builder b() {
        return new Builder();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof GetPhoneNumberHintIntentRequest) {
            return Objects.equal(Integer.valueOf(this.f22101a), Integer.valueOf(((GetPhoneNumberHintIntentRequest) obj).f22101a));
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22101a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22101a);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
