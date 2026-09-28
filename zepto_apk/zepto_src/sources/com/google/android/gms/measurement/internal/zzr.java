package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AppMetadataCreator")
@SafeParcelable.Reserved({1, 13, 17, 19, 20, 24, 33})
/* loaded from: classes.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    public final long A;
    public final String B;
    public final String C;
    public final long D;
    public final int E;

    /* renamed from: a, reason: collision with root package name */
    public final String f39648a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39649b;

    /* renamed from: c, reason: collision with root package name */
    public final String f39650c;

    /* renamed from: d, reason: collision with root package name */
    public final String f39651d;

    /* renamed from: e, reason: collision with root package name */
    public final long f39652e;

    /* renamed from: f, reason: collision with root package name */
    public final long f39653f;

    /* renamed from: g, reason: collision with root package name */
    public final String f39654g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f39655h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f39656i;

    /* renamed from: j, reason: collision with root package name */
    public final long f39657j;

    /* renamed from: k, reason: collision with root package name */
    public final String f39658k;

    /* renamed from: l, reason: collision with root package name */
    public final long f39659l;

    /* renamed from: m, reason: collision with root package name */
    public final int f39660m;
    public final boolean n;
    public final boolean o;
    public final Boolean p;
    public final long q;
    public final List r;
    public final String s;
    public final String t;
    public final String u;
    public final boolean v;
    public final long w;
    public final int x;
    public final String y;
    public final int z;

    public zzr(String str, String str2, String str3, long j2, String str4, long j3, long j4, String str5, boolean z, boolean z2, String str6, long j5, int i2, boolean z3, boolean z4, Boolean bool, long j6, List list, String str7, String str8, String str9, boolean z5, long j7, int i3, String str10, int i4, long j8, String str11, String str12, long j9, int i5) {
        Preconditions.checkNotEmpty(str);
        this.f39648a = str;
        this.f39649b = true == TextUtils.isEmpty(str2) ? null : str2;
        this.f39650c = str3;
        this.f39657j = j2;
        this.f39651d = str4;
        this.f39652e = j3;
        this.f39653f = j4;
        this.f39654g = str5;
        this.f39655h = z;
        this.f39656i = z2;
        this.f39658k = str6;
        this.f39659l = j5;
        this.f39660m = i2;
        this.n = z3;
        this.o = z4;
        this.p = bool;
        this.q = j6;
        this.r = list;
        this.s = str7;
        this.t = str8;
        this.u = str9;
        this.v = z5;
        this.w = j7;
        this.x = i3;
        this.y = str10;
        this.z = i4;
        this.A = j8;
        this.B = str11;
        this.C = str12;
        this.D = j9;
        this.E = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f39648a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f39649b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f39650c, false);
        SafeParcelWriter.writeString(parcel, 5, this.f39651d, false);
        SafeParcelWriter.writeLong(parcel, 6, this.f39652e);
        SafeParcelWriter.writeLong(parcel, 7, this.f39653f);
        SafeParcelWriter.writeString(parcel, 8, this.f39654g, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f39655h);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f39656i);
        SafeParcelWriter.writeLong(parcel, 11, this.f39657j);
        SafeParcelWriter.writeString(parcel, 12, this.f39658k, false);
        SafeParcelWriter.writeLong(parcel, 14, this.f39659l);
        SafeParcelWriter.writeInt(parcel, 15, this.f39660m);
        SafeParcelWriter.writeBoolean(parcel, 16, this.n);
        SafeParcelWriter.writeBoolean(parcel, 18, this.o);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.p, false);
        SafeParcelWriter.writeLong(parcel, 22, this.q);
        SafeParcelWriter.writeStringList(parcel, 23, this.r, false);
        SafeParcelWriter.writeString(parcel, 25, this.s, false);
        SafeParcelWriter.writeString(parcel, 26, this.t, false);
        SafeParcelWriter.writeString(parcel, 27, this.u, false);
        SafeParcelWriter.writeBoolean(parcel, 28, this.v);
        SafeParcelWriter.writeLong(parcel, 29, this.w);
        SafeParcelWriter.writeInt(parcel, 30, this.x);
        SafeParcelWriter.writeString(parcel, 31, this.y, false);
        SafeParcelWriter.writeInt(parcel, 32, this.z);
        SafeParcelWriter.writeLong(parcel, 34, this.A);
        SafeParcelWriter.writeString(parcel, 35, this.B, false);
        SafeParcelWriter.writeString(parcel, 36, this.C, false);
        SafeParcelWriter.writeLong(parcel, 37, this.D);
        SafeParcelWriter.writeInt(parcel, 38, this.E);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzr(String str, String str2, String str3, String str4, long j2, long j3, String str5, boolean z, boolean z2, long j4, String str6, long j5, int i2, boolean z3, boolean z4, Boolean bool, long j6, ArrayList arrayList, String str7, String str8, String str9, boolean z5, long j7, int i3, String str10, int i4, long j8, String str11, String str12, long j9, int i5) {
        this.f39648a = str;
        this.f39649b = str2;
        this.f39650c = str3;
        this.f39657j = j4;
        this.f39651d = str4;
        this.f39652e = j2;
        this.f39653f = j3;
        this.f39654g = str5;
        this.f39655h = z;
        this.f39656i = z2;
        this.f39658k = str6;
        this.f39659l = j5;
        this.f39660m = i2;
        this.n = z3;
        this.o = z4;
        this.p = bool;
        this.q = j6;
        this.r = arrayList;
        this.s = str7;
        this.t = str8;
        this.u = str9;
        this.v = z5;
        this.w = j7;
        this.x = i3;
        this.y = str10;
        this.z = i4;
        this.A = j8;
        this.B = str11;
        this.C = str12;
        this.D = j9;
        this.E = i5;
    }
}
