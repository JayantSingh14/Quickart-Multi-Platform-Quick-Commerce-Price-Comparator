package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NotifyCompletionRequestCreator")
/* loaded from: classes4.dex */
public final class zzav extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();

    /* renamed from: a, reason: collision with root package name */
    public final int f36291a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final String f36292b;

    /* renamed from: c, reason: collision with root package name */
    public final int f36293c;

    public zzav(String str, int i2) {
        this.f36292b = (String) Preconditions.checkNotNull(str);
        this.f36293c = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f36291a);
        SafeParcelWriter.writeString(parcel, 2, this.f36292b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f36293c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
