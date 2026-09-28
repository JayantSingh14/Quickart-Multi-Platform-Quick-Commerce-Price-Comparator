package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GoogleSignInOptionsExtensionCreator")
/* loaded from: classes4.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new zaa();

    /* renamed from: a, reason: collision with root package name */
    public final int f22192a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22193b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f22194c;

    public GoogleSignInOptionsExtensionParcelable(int i2, int i3, Bundle bundle) {
        this.f22192a = i2;
        this.f22193b = i3;
        this.f22194c = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22192a);
        SafeParcelWriter.writeInt(parcel, 2, this.f22193b);
        SafeParcelWriter.writeBundle(parcel, 3, this.f22194c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
