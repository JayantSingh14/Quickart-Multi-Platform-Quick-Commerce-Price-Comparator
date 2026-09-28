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
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
/* loaded from: classes4.dex */
public final class zzbza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbza> CREATOR = new zzbzb();

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f25720a;

    /* renamed from: b, reason: collision with root package name */
    public final VersionInfoParcel f25721b;

    /* renamed from: c, reason: collision with root package name */
    public final ApplicationInfo f25722c;

    /* renamed from: d, reason: collision with root package name */
    public final String f25723d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f25724e;

    /* renamed from: f, reason: collision with root package name */
    public final PackageInfo f25725f;

    /* renamed from: g, reason: collision with root package name */
    public final String f25726g;

    /* renamed from: h, reason: collision with root package name */
    public final String f25727h;

    /* renamed from: i, reason: collision with root package name */
    public zzfkg f25728i;

    /* renamed from: j, reason: collision with root package name */
    public String f25729j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f25730k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f25731l;

    /* renamed from: m, reason: collision with root package name */
    public final Bundle f25732m;
    public final Bundle n;
    public final int o;

    public zzbza(Bundle bundle, VersionInfoParcel versionInfoParcel, ApplicationInfo applicationInfo, String str, ArrayList arrayList, PackageInfo packageInfo, String str2, String str3, zzfkg zzfkgVar, String str4, boolean z, boolean z2, Bundle bundle2, Bundle bundle3, int i2) {
        this.f25720a = bundle;
        this.f25721b = versionInfoParcel;
        this.f25723d = str;
        this.f25722c = applicationInfo;
        this.f25724e = arrayList;
        this.f25725f = packageInfo;
        this.f25726g = str2;
        this.f25727h = str3;
        this.f25728i = zzfkgVar;
        this.f25729j = str4;
        this.f25730k = z;
        this.f25731l = z2;
        this.f25732m = bundle2;
        this.n = bundle3;
        this.o = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.f25720a, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f25721b, i2, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f25722c, i2, false);
        SafeParcelWriter.writeString(parcel, 4, this.f25723d, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.f25724e, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f25725f, i2, false);
        SafeParcelWriter.writeString(parcel, 7, this.f25726g, false);
        SafeParcelWriter.writeString(parcel, 9, this.f25727h, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.f25728i, i2, false);
        SafeParcelWriter.writeString(parcel, 11, this.f25729j, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.f25730k);
        SafeParcelWriter.writeBoolean(parcel, 13, this.f25731l);
        SafeParcelWriter.writeBundle(parcel, 14, this.f25732m, false);
        SafeParcelWriter.writeBundle(parcel, 15, this.n, false);
        SafeParcelWriter.writeInt(parcel, 16, this.o);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
