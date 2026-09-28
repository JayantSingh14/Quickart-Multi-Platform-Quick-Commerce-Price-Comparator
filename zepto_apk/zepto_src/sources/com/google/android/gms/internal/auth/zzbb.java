package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserChallengeRequestCreator")
/* loaded from: classes4.dex */
public final class zzbb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbb> CREATOR = new zzbc();

    /* renamed from: a, reason: collision with root package name */
    public final int f36299a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final String f36300b;

    /* renamed from: c, reason: collision with root package name */
    public final PendingIntent f36301c;

    public zzbb(String str, PendingIntent pendingIntent) {
        this.f36300b = (String) Preconditions.checkNotNull(str);
        this.f36301c = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f36299a);
        SafeParcelWriter.writeString(parcel, 2, this.f36300b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f36301c, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
