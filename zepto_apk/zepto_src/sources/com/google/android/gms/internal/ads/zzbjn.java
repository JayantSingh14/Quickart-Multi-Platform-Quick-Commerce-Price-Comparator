package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "NativeAdOptionsParcelCreator")
/* loaded from: classes4.dex */
public final class zzbjn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbjn> CREATOR = new zzbjo();

    /* renamed from: a, reason: collision with root package name */
    public final int f25249a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f25250b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25251c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f25252d;

    /* renamed from: e, reason: collision with root package name */
    public final int f25253e;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzga f25254f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f25255g;

    /* renamed from: h, reason: collision with root package name */
    public final int f25256h;

    /* renamed from: i, reason: collision with root package name */
    public final int f25257i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f25258j;

    /* renamed from: k, reason: collision with root package name */
    public final int f25259k;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzbjn(NativeAdOptions nativeAdOptions) {
        boolean z = nativeAdOptions.f21045a;
        VideoOptions videoOptions = nativeAdOptions.f21050f;
        this(4, z, nativeAdOptions.f21046b, nativeAdOptions.f21048d, nativeAdOptions.f21049e, videoOptions != null ? new com.google.android.gms.ads.internal.client.zzga(videoOptions) : null, nativeAdOptions.f21051g, nativeAdOptions.f21047c, 0, false, 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f25249a);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f25250b);
        SafeParcelWriter.writeInt(parcel, 3, this.f25251c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f25252d);
        SafeParcelWriter.writeInt(parcel, 5, this.f25253e);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f25254f, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.f25255g);
        SafeParcelWriter.writeInt(parcel, 8, this.f25256h);
        SafeParcelWriter.writeInt(parcel, 9, this.f25257i);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f25258j);
        SafeParcelWriter.writeInt(parcel, 11, this.f25259k);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzbjn(int i2, boolean z, int i3, boolean z2, int i4, com.google.android.gms.ads.internal.client.zzga zzgaVar, boolean z3, int i5, int i6, boolean z4, int i7) {
        this.f25249a = i2;
        this.f25250b = z;
        this.f25251c = i3;
        this.f25252d = z2;
        this.f25253e = i4;
        this.f25254f = zzgaVar;
        this.f25255g = z3;
        this.f25256h = i5;
        this.f25258j = z4;
        this.f25257i = i6;
        this.f25259k = i7;
    }
}
