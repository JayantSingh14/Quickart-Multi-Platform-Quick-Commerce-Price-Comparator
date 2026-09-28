package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Build;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LocationReceiverCreator")
/* loaded from: classes4.dex */
public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdb> CREATOR = new zzdc();

    /* renamed from: a, reason: collision with root package name */
    public final int f36670a;

    /* renamed from: b, reason: collision with root package name */
    public final IBinder f36671b;

    /* renamed from: c, reason: collision with root package name */
    public final IBinder f36672c;

    /* renamed from: d, reason: collision with root package name */
    public final PendingIntent f36673d;

    /* renamed from: e, reason: collision with root package name */
    public final String f36674e;

    /* renamed from: f, reason: collision with root package name */
    public final String f36675f;

    public zzdb(int i2, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str, String str2) {
        this.f36670a = i2;
        this.f36671b = iBinder;
        this.f36672c = iBinder2;
        this.f36673d = pendingIntent;
        this.f36674e = Build.VERSION.SDK_INT >= 30 ? null : str;
        this.f36675f = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f36670a);
        SafeParcelWriter.writeIBinder(parcel, 2, this.f36671b, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.f36672c, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f36673d, i2, false);
        SafeParcelWriter.writeString(parcel, 5, this.f36674e, false);
        SafeParcelWriter.writeString(parcel, 6, this.f36675f, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
