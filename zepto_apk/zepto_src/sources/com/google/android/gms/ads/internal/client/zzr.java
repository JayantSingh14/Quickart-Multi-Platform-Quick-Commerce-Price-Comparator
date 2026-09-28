package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();

    /* renamed from: a, reason: collision with root package name */
    public final String f21281a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21282b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21283c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f21284d;

    /* renamed from: e, reason: collision with root package name */
    public final int f21285e;

    /* renamed from: f, reason: collision with root package name */
    public final int f21286f;

    /* renamed from: g, reason: collision with root package name */
    public final zzr[] f21287g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f21288h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f21289i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f21290j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f21291k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f21292l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f21293m;
    public final boolean n;
    public final boolean o;

    public zzr() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false, false, false, false, false, false);
    }

    public static zzr b() {
        return new zzr("320x50_mb", 0, 0, false, 0, 0, null, true, false, false, false, false, false, false, false);
    }

    public static zzr r() {
        return new zzr("interstitial_mb", 0, 0, false, 0, 0, null, false, false, false, false, true, false, false, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f21281a, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f21282b);
        SafeParcelWriter.writeInt(parcel, 4, this.f21283c);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f21284d);
        SafeParcelWriter.writeInt(parcel, 6, this.f21285e);
        SafeParcelWriter.writeInt(parcel, 7, this.f21286f);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.f21287g, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f21288h);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f21289i);
        SafeParcelWriter.writeBoolean(parcel, 11, this.f21290j);
        SafeParcelWriter.writeBoolean(parcel, 12, this.f21291k);
        SafeParcelWriter.writeBoolean(parcel, 13, this.f21292l);
        SafeParcelWriter.writeBoolean(parcel, 14, this.f21293m);
        SafeParcelWriter.writeBoolean(parcel, 15, this.n);
        SafeParcelWriter.writeBoolean(parcel, 16, this.o);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzr(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzr(android.content.Context r17, com.google.android.gms.ads.AdSize[] r18) {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzr.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    public zzr(String str, int i2, int i3, boolean z, int i4, int i5, zzr[] zzrVarArr, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
        this.f21281a = str;
        this.f21282b = i2;
        this.f21283c = i3;
        this.f21284d = z;
        this.f21285e = i4;
        this.f21286f = i5;
        this.f21287g = zzrVarArr;
        this.f21288h = z2;
        this.f21289i = z3;
        this.f21290j = z4;
        this.f21291k = z5;
        this.f21292l = z6;
        this.f21293m = z7;
        this.n = z8;
        this.o = z9;
    }
}
