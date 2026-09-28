package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInAccountCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zbc();

    /* renamed from: a, reason: collision with root package name */
    public final String f22189a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f22190b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22191c;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f22190b = googleSignInAccount;
        this.f22189a = Preconditions.checkNotEmpty(str, "8.3 and 8.4 SDKs require non-null email");
        this.f22191c = Preconditions.checkNotEmpty(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 4, this.f22189a, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f22190b, i2, false);
        SafeParcelWriter.writeString(parcel, 8, this.f22191c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
