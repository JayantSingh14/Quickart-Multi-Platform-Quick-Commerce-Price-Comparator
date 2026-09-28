package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@KeepForSdkWithMembers
@SafeParcelable.Class(creator = "ProxyResponseCreator")
/* loaded from: classes4.dex */
public class ProxyResponse extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final int f22145a;

    /* renamed from: b, reason: collision with root package name */
    public final PendingIntent f22146b;

    /* renamed from: c, reason: collision with root package name */
    public final int f22147c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f22148d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22149e;

    /* renamed from: f, reason: collision with root package name */
    public final Bundle f22150f;

    public ProxyResponse(int i2, int i3, PendingIntent pendingIntent, int i4, Bundle bundle, byte[] bArr) {
        this.f22149e = i2;
        this.f22145a = i3;
        this.f22147c = i4;
        this.f22150f = bundle;
        this.f22148d = bArr;
        this.f22146b = pendingIntent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22145a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f22146b, i2, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f22147c);
        SafeParcelWriter.writeBundle(parcel, 4, this.f22150f, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.f22148d, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f22149e);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
