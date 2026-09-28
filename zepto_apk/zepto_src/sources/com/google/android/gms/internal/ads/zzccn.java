package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "SignalConfigurationParcelCreator")
/* loaded from: classes4.dex */
public final class zzccn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzccn> CREATOR = new zzcco();

    /* renamed from: a, reason: collision with root package name */
    public final String f25885a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25886b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzr f25887c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzm f25888d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25889e;

    /* renamed from: f, reason: collision with root package name */
    public final String f25890f;

    public zzccn(String str, String str2, com.google.android.gms.ads.internal.client.zzr zzrVar, com.google.android.gms.ads.internal.client.zzm zzmVar, int i2, String str3) {
        this.f25885a = str;
        this.f25886b = str2;
        this.f25887c = zzrVar;
        this.f25888d = zzmVar;
        this.f25889e = i2;
        this.f25890f = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f25885a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f25886b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f25887c, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f25888d, i2, false);
        SafeParcelWriter.writeInt(parcel, 5, this.f25889e);
        SafeParcelWriter.writeString(parcel, 6, this.f25890f, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
