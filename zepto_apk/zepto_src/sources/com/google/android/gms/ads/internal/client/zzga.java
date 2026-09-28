package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "VideoOptionsParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzga extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzga> CREATOR = new zzgb();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f21247a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f21248b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f21249c;

    public zzga(VideoOptions videoOptions) {
        this(videoOptions.f21032a, videoOptions.f21033b, videoOptions.f21034c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f21247a);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f21248b);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f21249c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzga(boolean z, boolean z2, boolean z3) {
        this.f21247a = z;
        this.f21248b = z2;
        this.f21249c = z3;
    }
}
