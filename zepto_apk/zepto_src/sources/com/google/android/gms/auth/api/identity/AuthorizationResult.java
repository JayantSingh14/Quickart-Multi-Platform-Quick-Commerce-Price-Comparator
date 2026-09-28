package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AuthorizationResultCreator")
/* loaded from: classes4.dex */
public final class AuthorizationResult extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AuthorizationResult> CREATOR = new zbc();

    /* renamed from: a, reason: collision with root package name */
    public final String f22073a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22074b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22075c;

    /* renamed from: d, reason: collision with root package name */
    public final List f22076d;

    /* renamed from: e, reason: collision with root package name */
    public final GoogleSignInAccount f22077e;

    /* renamed from: f, reason: collision with root package name */
    public final PendingIntent f22078f;

    public AuthorizationResult(String str, String str2, String str3, ArrayList arrayList, GoogleSignInAccount googleSignInAccount, PendingIntent pendingIntent) {
        this.f22073a = str;
        this.f22074b = str2;
        this.f22075c = str3;
        this.f22076d = (List) Preconditions.checkNotNull(arrayList);
        this.f22078f = pendingIntent;
        this.f22077e = googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AuthorizationResult)) {
            return false;
        }
        AuthorizationResult authorizationResult = (AuthorizationResult) obj;
        return Objects.equal(this.f22073a, authorizationResult.f22073a) && Objects.equal(this.f22074b, authorizationResult.f22074b) && Objects.equal(this.f22075c, authorizationResult.f22075c) && Objects.equal(this.f22076d, authorizationResult.f22076d) && Objects.equal(this.f22078f, authorizationResult.f22078f) && Objects.equal(this.f22077e, authorizationResult.f22077e);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22073a, this.f22074b, this.f22075c, this.f22076d, this.f22078f, this.f22077e);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f22073a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f22074b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22075c, false);
        SafeParcelWriter.writeStringList(parcel, 4, this.f22076d, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f22077e, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f22078f, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
