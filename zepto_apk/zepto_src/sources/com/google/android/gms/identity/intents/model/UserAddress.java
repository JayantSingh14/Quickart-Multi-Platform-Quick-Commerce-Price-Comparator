package com.google.android.gms.identity.intents.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAddressCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class UserAddress extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<UserAddress> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public String f22536a;

    /* renamed from: b, reason: collision with root package name */
    public String f22537b;

    /* renamed from: c, reason: collision with root package name */
    public String f22538c;

    /* renamed from: d, reason: collision with root package name */
    public String f22539d;

    /* renamed from: e, reason: collision with root package name */
    public String f22540e;

    /* renamed from: f, reason: collision with root package name */
    public String f22541f;

    /* renamed from: g, reason: collision with root package name */
    public String f22542g;

    /* renamed from: h, reason: collision with root package name */
    public String f22543h;

    /* renamed from: i, reason: collision with root package name */
    public String f22544i;

    /* renamed from: j, reason: collision with root package name */
    public String f22545j;

    /* renamed from: k, reason: collision with root package name */
    public String f22546k;

    /* renamed from: l, reason: collision with root package name */
    public String f22547l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f22548m;
    public String n;
    public String o;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f22536a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22537b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22538c, false);
        SafeParcelWriter.writeString(parcel, 5, this.f22539d, false);
        SafeParcelWriter.writeString(parcel, 6, this.f22540e, false);
        SafeParcelWriter.writeString(parcel, 7, this.f22541f, false);
        SafeParcelWriter.writeString(parcel, 8, this.f22542g, false);
        SafeParcelWriter.writeString(parcel, 9, this.f22543h, false);
        SafeParcelWriter.writeString(parcel, 10, this.f22544i, false);
        SafeParcelWriter.writeString(parcel, 11, this.f22545j, false);
        SafeParcelWriter.writeString(parcel, 12, this.f22546k, false);
        SafeParcelWriter.writeString(parcel, 13, this.f22547l, false);
        SafeParcelWriter.writeBoolean(parcel, 14, this.f22548m);
        SafeParcelWriter.writeString(parcel, 15, this.n, false);
        SafeParcelWriter.writeString(parcel, 16, this.o, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
