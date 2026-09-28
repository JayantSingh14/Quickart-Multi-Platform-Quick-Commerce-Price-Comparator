package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PoolConfigurationCreator")
/* loaded from: classes4.dex */
public final class zzfkg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfkg> CREATOR = new zzfkh();

    /* renamed from: a, reason: collision with root package name */
    public final Context f31307a;

    /* renamed from: b, reason: collision with root package name */
    public final int f31308b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfkd f31309c;

    /* renamed from: d, reason: collision with root package name */
    public final int f31310d;

    /* renamed from: e, reason: collision with root package name */
    public final int f31311e;

    /* renamed from: f, reason: collision with root package name */
    public final int f31312f;

    /* renamed from: g, reason: collision with root package name */
    public final String f31313g;

    /* renamed from: h, reason: collision with root package name */
    public final int f31314h;

    /* renamed from: i, reason: collision with root package name */
    public final int f31315i;

    /* renamed from: j, reason: collision with root package name */
    public final int f31316j;

    public zzfkg(int i2, int i3, int i4, int i5, String str, int i6, int i7) {
        zzfkd[] zzfkdVarArrValues = zzfkd.values();
        this.f31307a = null;
        this.f31308b = i2;
        this.f31309c = zzfkdVarArrValues[i2];
        this.f31310d = i3;
        this.f31311e = i4;
        this.f31312f = i5;
        this.f31313g = str;
        this.f31314h = i6;
        this.f31316j = new int[]{1, 2, 3}[i6];
        this.f31315i = i7;
        int i8 = new int[]{1}[i7];
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f31308b);
        SafeParcelWriter.writeInt(parcel, 2, this.f31310d);
        SafeParcelWriter.writeInt(parcel, 3, this.f31311e);
        SafeParcelWriter.writeInt(parcel, 4, this.f31312f);
        SafeParcelWriter.writeString(parcel, 5, this.f31313g, false);
        SafeParcelWriter.writeInt(parcel, 6, this.f31314h);
        SafeParcelWriter.writeInt(parcel, 7, this.f31315i);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzfkg(Context context, zzfkd zzfkdVar, int i2, int i3, int i4, String str, String str2) {
        zzfkd.values();
        this.f31307a = context;
        this.f31308b = zzfkdVar.ordinal();
        this.f31309c = zzfkdVar;
        this.f31310d = i2;
        this.f31311e = i3;
        this.f31312f = i4;
        this.f31313g = str;
        int i5 = "oldest".equals(str2) ? 1 : (!"lru".equals(str2) && "lfu".equals(str2)) ? 3 : 2;
        this.f31316j = i5;
        this.f31314h = i5 - 1;
        this.f31315i = 0;
    }
}
