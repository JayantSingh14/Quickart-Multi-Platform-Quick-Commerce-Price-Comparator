package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "AdRequestInfoParcelCreator")
/* loaded from: classes4.dex */
public final class zzbyf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbyf> CREATOR = new zzbyg();
    public final long A;
    public final String A0;
    public final String B;
    public final String B0;
    public final float C;
    public final boolean C0;
    public final int D;
    public final ArrayList D0;
    public final int E;
    public final String E0;
    public final boolean F;
    public final ArrayList F0;
    public final String G;
    public final int G0;
    public final boolean H;
    public final boolean H0;
    public final String I;
    public final boolean I0;
    public final boolean J;
    public final boolean J0;
    public final int K;
    public final ArrayList K0;
    public final Bundle L;
    public final String L0;
    public final String M;
    public final zzbpy M0;
    public final String N0;
    public final Bundle O0;
    public final com.google.android.gms.ads.internal.client.zzeh Q;
    public final boolean X;
    public final Bundle Y;
    public final String Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f25690a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f25691b;

    /* renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzm f25692c;

    /* renamed from: d, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzr f25693d;

    /* renamed from: e, reason: collision with root package name */
    public final String f25694e;

    /* renamed from: f, reason: collision with root package name */
    public final ApplicationInfo f25695f;

    /* renamed from: g, reason: collision with root package name */
    public final PackageInfo f25696g;

    /* renamed from: h, reason: collision with root package name */
    public final String f25697h;

    /* renamed from: i, reason: collision with root package name */
    public final String f25698i;

    /* renamed from: j, reason: collision with root package name */
    public final String f25699j;

    /* renamed from: k, reason: collision with root package name */
    public final VersionInfoParcel f25700k;

    /* renamed from: l, reason: collision with root package name */
    public final Bundle f25701l;

    /* renamed from: m, reason: collision with root package name */
    public final int f25702m;
    public final ArrayList n;
    public final Bundle o;
    public final boolean p;
    public final int q;
    public final int r;
    public final float s;
    public final String t;
    public final long u;
    public final String v;
    public final List w;
    public final String x;
    public final zzbjn y;
    public final List z;

    public zzbyf(int i2, Bundle bundle, com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, ApplicationInfo applicationInfo, PackageInfo packageInfo, String str2, String str3, String str4, VersionInfoParcel versionInfoParcel, Bundle bundle2, int i3, ArrayList arrayList, Bundle bundle3, boolean z, int i4, int i5, float f2, String str5, long j2, String str6, ArrayList arrayList2, String str7, zzbjn zzbjnVar, ArrayList arrayList3, long j3, String str8, float f3, boolean z2, int i6, int i7, boolean z3, String str9, String str10, boolean z4, int i8, Bundle bundle4, String str11, com.google.android.gms.ads.internal.client.zzeh zzehVar, boolean z5, Bundle bundle5, String str12, String str13, String str14, boolean z6, ArrayList arrayList4, String str15, ArrayList arrayList5, int i9, boolean z7, boolean z8, boolean z9, ArrayList arrayList6, String str16, zzbpy zzbpyVar, String str17, Bundle bundle6) {
        this.f25690a = i2;
        this.f25691b = bundle;
        this.f25692c = zzmVar;
        this.f25693d = zzrVar;
        this.f25694e = str;
        this.f25695f = applicationInfo;
        this.f25696g = packageInfo;
        this.f25697h = str2;
        this.f25698i = str3;
        this.f25699j = str4;
        this.f25700k = versionInfoParcel;
        this.f25701l = bundle2;
        this.f25702m = i3;
        this.n = arrayList;
        this.z = arrayList3 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList3);
        this.o = bundle3;
        this.p = z;
        this.q = i4;
        this.r = i5;
        this.s = f2;
        this.t = str5;
        this.u = j2;
        this.v = str6;
        this.w = arrayList2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(arrayList2);
        this.x = str7;
        this.y = zzbjnVar;
        this.A = j3;
        this.B = str8;
        this.C = f3;
        this.H = z2;
        this.D = i6;
        this.E = i7;
        this.F = z3;
        this.G = str9;
        this.I = str10;
        this.J = z4;
        this.K = i8;
        this.L = bundle4;
        this.M = str11;
        this.Q = zzehVar;
        this.X = z5;
        this.Y = bundle5;
        this.Z = str12;
        this.A0 = str13;
        this.B0 = str14;
        this.C0 = z6;
        this.D0 = arrayList4;
        this.E0 = str15;
        this.F0 = arrayList5;
        this.G0 = i9;
        this.H0 = z7;
        this.I0 = z8;
        this.J0 = z9;
        this.K0 = arrayList6;
        this.L0 = str16;
        this.M0 = zzbpyVar;
        this.N0 = str17;
        this.O0 = bundle6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f25690a);
        SafeParcelWriter.writeBundle(parcel, 2, this.f25691b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f25692c, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f25693d, i2, false);
        SafeParcelWriter.writeString(parcel, 5, this.f25694e, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f25695f, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f25696g, i2, false);
        SafeParcelWriter.writeString(parcel, 8, this.f25697h, false);
        SafeParcelWriter.writeString(parcel, 9, this.f25698i, false);
        SafeParcelWriter.writeString(parcel, 10, this.f25699j, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.f25700k, i2, false);
        SafeParcelWriter.writeBundle(parcel, 12, this.f25701l, false);
        SafeParcelWriter.writeInt(parcel, 13, this.f25702m);
        SafeParcelWriter.writeStringList(parcel, 14, this.n, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.o, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.p);
        SafeParcelWriter.writeInt(parcel, 18, this.q);
        SafeParcelWriter.writeInt(parcel, 19, this.r);
        SafeParcelWriter.writeFloat(parcel, 20, this.s);
        SafeParcelWriter.writeString(parcel, 21, this.t, false);
        SafeParcelWriter.writeLong(parcel, 25, this.u);
        SafeParcelWriter.writeString(parcel, 26, this.v, false);
        SafeParcelWriter.writeStringList(parcel, 27, this.w, false);
        SafeParcelWriter.writeString(parcel, 28, this.x, false);
        SafeParcelWriter.writeParcelable(parcel, 29, this.y, i2, false);
        SafeParcelWriter.writeStringList(parcel, 30, this.z, false);
        SafeParcelWriter.writeLong(parcel, 31, this.A);
        SafeParcelWriter.writeString(parcel, 33, this.B, false);
        SafeParcelWriter.writeFloat(parcel, 34, this.C);
        SafeParcelWriter.writeInt(parcel, 35, this.D);
        SafeParcelWriter.writeInt(parcel, 36, this.E);
        SafeParcelWriter.writeBoolean(parcel, 37, this.F);
        SafeParcelWriter.writeString(parcel, 39, this.G, false);
        SafeParcelWriter.writeBoolean(parcel, 40, this.H);
        SafeParcelWriter.writeString(parcel, 41, this.I, false);
        SafeParcelWriter.writeBoolean(parcel, 42, this.J);
        SafeParcelWriter.writeInt(parcel, 43, this.K);
        SafeParcelWriter.writeBundle(parcel, 44, this.L, false);
        SafeParcelWriter.writeString(parcel, 45, this.M, false);
        SafeParcelWriter.writeParcelable(parcel, 46, this.Q, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 47, this.X);
        SafeParcelWriter.writeBundle(parcel, 48, this.Y, false);
        SafeParcelWriter.writeString(parcel, 49, this.Z, false);
        SafeParcelWriter.writeString(parcel, 50, this.A0, false);
        SafeParcelWriter.writeString(parcel, 51, this.B0, false);
        SafeParcelWriter.writeBoolean(parcel, 52, this.C0);
        SafeParcelWriter.writeIntegerList(parcel, 53, this.D0, false);
        SafeParcelWriter.writeString(parcel, 54, this.E0, false);
        SafeParcelWriter.writeStringList(parcel, 55, this.F0, false);
        SafeParcelWriter.writeInt(parcel, 56, this.G0);
        SafeParcelWriter.writeBoolean(parcel, 57, this.H0);
        SafeParcelWriter.writeBoolean(parcel, 58, this.I0);
        SafeParcelWriter.writeBoolean(parcel, 59, this.J0);
        SafeParcelWriter.writeStringList(parcel, 60, this.K0, false);
        SafeParcelWriter.writeString(parcel, 61, this.L0, false);
        SafeParcelWriter.writeParcelable(parcel, 63, this.M0, i2, false);
        SafeParcelWriter.writeString(parcel, 64, this.N0, false);
        SafeParcelWriter.writeBundle(parcel, 65, this.O0, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
