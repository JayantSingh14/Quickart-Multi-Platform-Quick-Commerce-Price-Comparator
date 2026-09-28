package com.google.android.gms.auth.api.identity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SavePasswordRequestCreator")
@Deprecated
/* loaded from: classes4.dex */
public class SavePasswordRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<SavePasswordRequest> CREATOR = new zbp();

    /* renamed from: a, reason: collision with root package name */
    public final SignInPassword f22115a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22116b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22117c;

    @Deprecated
    public static final class Builder {
    }

    public SavePasswordRequest(SignInPassword signInPassword, String str, int i2) {
        this.f22115a = (SignInPassword) Preconditions.checkNotNull(signInPassword);
        this.f22116b = str;
        this.f22117c = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SavePasswordRequest)) {
            return false;
        }
        SavePasswordRequest savePasswordRequest = (SavePasswordRequest) obj;
        return Objects.equal(this.f22115a, savePasswordRequest.f22115a) && Objects.equal(this.f22116b, savePasswordRequest.f22116b) && this.f22117c == savePasswordRequest.f22117c;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22115a, this.f22116b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f22115a, i2, false);
        SafeParcelWriter.writeString(parcel, 2, this.f22116b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f22117c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
