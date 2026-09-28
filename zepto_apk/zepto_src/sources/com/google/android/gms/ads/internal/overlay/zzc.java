package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@SafeParcelable.Class(creator = "AdLauncherIntentInfoCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final String f21336a;

    /* renamed from: b, reason: collision with root package name */
    public final String f21337b;

    /* renamed from: c, reason: collision with root package name */
    public final String f21338c;

    /* renamed from: d, reason: collision with root package name */
    public final String f21339d;

    /* renamed from: e, reason: collision with root package name */
    public final String f21340e;

    /* renamed from: f, reason: collision with root package name */
    public final String f21341f;

    /* renamed from: g, reason: collision with root package name */
    public final String f21342g;

    /* renamed from: h, reason: collision with root package name */
    public final Intent f21343h;

    /* renamed from: i, reason: collision with root package name */
    public final zzaa f21344i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f21345j;

    /* renamed from: k, reason: collision with root package name */
    public final Bundle f21346k;

    public zzc(Intent intent, zzaa zzaaVar) {
        this(null, null, null, null, null, null, null, intent, new ObjectWrapper(zzaaVar).asBinder(), false, new Bundle());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f21336a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f21337b, false);
        SafeParcelWriter.writeString(parcel, 4, this.f21338c, false);
        SafeParcelWriter.writeString(parcel, 5, this.f21339d, false);
        SafeParcelWriter.writeString(parcel, 6, this.f21340e, false);
        SafeParcelWriter.writeString(parcel, 7, this.f21341f, false);
        SafeParcelWriter.writeString(parcel, 8, this.f21342g, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f21343h, i2, false);
        SafeParcelWriter.writeIBinder(parcel, 10, new ObjectWrapper(this.f21344i).asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 11, this.f21345j);
        SafeParcelWriter.writeBundle(parcel, 12, this.f21346k, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7, zzaa zzaaVar) {
        this(str, str2, str3, str4, str5, str6, str7, null, new ObjectWrapper(zzaaVar).asBinder(), false, new Bundle());
    }

    public zzc(String str, String str2, String str3, String str4, String str5, String str6, String str7, Intent intent, IBinder iBinder, boolean z, Bundle bundle) {
        this.f21336a = str;
        this.f21337b = str2;
        this.f21338c = str3;
        this.f21339d = str4;
        this.f21340e = str5;
        this.f21341f = str6;
        this.f21342g = str7;
        this.f21343h = intent;
        this.f21344i = (zzaa) ObjectWrapper.z0(IObjectWrapper.Stub.g(iBinder));
        this.f21345j = z;
        this.f21346k = bundle;
    }
}
