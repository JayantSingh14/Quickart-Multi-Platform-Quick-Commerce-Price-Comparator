package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "AdRequestParcelCreator")
/* loaded from: classes4.dex */
public final class zzm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzo();
    public final long A;
    public final Bundle B = new Bundle();

    /* renamed from: a, reason: collision with root package name */
    public final int f21254a;

    /* renamed from: b, reason: collision with root package name */
    public final long f21255b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f21256c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21257d;

    /* renamed from: e, reason: collision with root package name */
    public final List f21258e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f21259f;

    /* renamed from: g, reason: collision with root package name */
    public final int f21260g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f21261h;

    /* renamed from: i, reason: collision with root package name */
    public final String f21262i;

    /* renamed from: j, reason: collision with root package name */
    public final zzfx f21263j;

    /* renamed from: k, reason: collision with root package name */
    public final Location f21264k;

    /* renamed from: l, reason: collision with root package name */
    public final String f21265l;

    /* renamed from: m, reason: collision with root package name */
    public final Bundle f21266m;
    public final Bundle n;
    public final List o;
    public final String p;
    public final String q;
    public final boolean r;
    public final zzc s;
    public final int t;
    public final String u;
    public final List v;
    public final int w;
    public final String x;
    public final int y;
    public final long z;

    public zzm(int i2, long j2, Bundle bundle, int i3, List list, boolean z, int i4, boolean z2, String str, zzfx zzfxVar, Location location, String str2, Bundle bundle2, Bundle bundle3, List list2, String str3, String str4, boolean z3, zzc zzcVar, int i5, String str5, List list3, int i6, String str6, int i7, long j3, long j4) {
        this.f21254a = i2;
        this.f21255b = j2;
        this.f21256c = bundle == null ? new Bundle() : bundle;
        this.f21257d = i3;
        this.f21258e = list;
        this.f21259f = z;
        this.f21260g = i4;
        this.f21261h = z2;
        this.f21262i = str;
        this.f21263j = zzfxVar;
        this.f21264k = location;
        this.f21265l = str2;
        this.f21266m = bundle2 == null ? new Bundle() : bundle2;
        this.n = bundle3;
        this.o = list2;
        this.p = str3;
        this.q = str4;
        this.r = z3;
        this.s = zzcVar;
        this.t = i5;
        this.u = str5;
        this.v = list3 == null ? new ArrayList() : list3;
        this.w = i6;
        this.x = str6;
        this.y = i7;
        this.z = j3;
        this.A = j4;
    }

    public final boolean b(zzm zzmVar) {
        if (zzmVar == null) {
            return false;
        }
        return this.f21254a == zzmVar.f21254a && this.f21255b == zzmVar.f21255b && com.google.android.gms.ads.internal.util.client.zzp.a(this.f21256c, zzmVar.f21256c) && this.f21257d == zzmVar.f21257d && Objects.equal(this.f21258e, zzmVar.f21258e) && this.f21259f == zzmVar.f21259f && this.f21260g == zzmVar.f21260g && this.f21261h == zzmVar.f21261h && Objects.equal(this.f21262i, zzmVar.f21262i) && Objects.equal(this.f21263j, zzmVar.f21263j) && Objects.equal(this.f21264k, zzmVar.f21264k) && Objects.equal(this.f21265l, zzmVar.f21265l) && com.google.android.gms.ads.internal.util.client.zzp.a(this.f21266m, zzmVar.f21266m) && com.google.android.gms.ads.internal.util.client.zzp.a(this.n, zzmVar.n) && Objects.equal(this.o, zzmVar.o) && Objects.equal(this.p, zzmVar.p) && Objects.equal(this.q, zzmVar.q) && this.r == zzmVar.r && this.t == zzmVar.t && Objects.equal(this.u, zzmVar.u) && Objects.equal(this.v, zzmVar.v) && this.w == zzmVar.w && Objects.equal(this.x, zzmVar.x) && this.y == zzmVar.y;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzm) {
            return b((zzm) obj) && this.z == ((zzm) obj).z;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f21254a), Long.valueOf(this.f21255b), this.f21256c, Integer.valueOf(this.f21257d), this.f21258e, Boolean.valueOf(this.f21259f), Integer.valueOf(this.f21260g), Boolean.valueOf(this.f21261h), this.f21262i, this.f21263j, this.f21264k, this.f21265l, this.f21266m, this.n, this.o, this.p, this.q, Boolean.valueOf(this.r), Integer.valueOf(this.t), this.u, this.v, Integer.valueOf(this.w), this.x, Integer.valueOf(this.y), Long.valueOf(this.z), Long.valueOf(this.A));
    }

    public final boolean r() {
        Bundle bundle = this.f21256c;
        return bundle.getBoolean("is_sdk_preload", false) || bundle.getBoolean("zenith_v2", false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f21254a);
        SafeParcelWriter.writeLong(parcel, 2, this.f21255b);
        SafeParcelWriter.writeBundle(parcel, 3, this.f21256c, false);
        SafeParcelWriter.writeInt(parcel, 4, this.f21257d);
        SafeParcelWriter.writeStringList(parcel, 5, this.f21258e, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f21259f);
        SafeParcelWriter.writeInt(parcel, 7, this.f21260g);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f21261h);
        SafeParcelWriter.writeString(parcel, 9, this.f21262i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.f21263j, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.f21264k, i2, false);
        SafeParcelWriter.writeString(parcel, 12, this.f21265l, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.f21266m, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.n, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.o, false);
        SafeParcelWriter.writeString(parcel, 16, this.p, false);
        SafeParcelWriter.writeString(parcel, 17, this.q, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.r);
        SafeParcelWriter.writeParcelable(parcel, 19, this.s, i2, false);
        SafeParcelWriter.writeInt(parcel, 20, this.t);
        SafeParcelWriter.writeString(parcel, 21, this.u, false);
        SafeParcelWriter.writeStringList(parcel, 22, this.v, false);
        SafeParcelWriter.writeInt(parcel, 23, this.w);
        SafeParcelWriter.writeString(parcel, 24, this.x, false);
        SafeParcelWriter.writeInt(parcel, 25, this.y);
        SafeParcelWriter.writeLong(parcel, 26, this.z);
        SafeParcelWriter.writeLong(parcel, 27, this.A);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
