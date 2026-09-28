package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzcbh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcbh> CREATOR = new zzcbi();

    /* renamed from: a, reason: collision with root package name */
    public final String f25825a;

    /* renamed from: b, reason: collision with root package name */
    public final String f25826b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f25827c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f25828d;

    /* renamed from: e, reason: collision with root package name */
    public final List f25829e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f25830f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f25831g;

    /* renamed from: h, reason: collision with root package name */
    public final List f25832h;

    public zzcbh(String str, String str2, boolean z, boolean z2, List list, boolean z3, boolean z4, List list2) {
        this.f25825a = str;
        this.f25826b = str2;
        this.f25827c = z;
        this.f25828d = z2;
        this.f25829e = list;
        this.f25830f = z3;
        this.f25831g = z4;
        this.f25832h = list2 == null ? new ArrayList() : list2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f25825a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f25826b, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f25827c);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f25828d);
        SafeParcelWriter.writeStringList(parcel, 6, this.f25829e, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.f25830f);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f25831g);
        SafeParcelWriter.writeStringList(parcel, 9, this.f25832h, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
