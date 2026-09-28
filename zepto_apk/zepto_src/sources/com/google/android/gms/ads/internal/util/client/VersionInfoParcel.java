package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import androidx.fragment.app.e;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@SafeParcelable.Class(creator = "VersionInfoParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class VersionInfoParcel extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<VersionInfoParcel> CREATOR = new zzy();

    /* renamed from: a, reason: collision with root package name */
    public final String f21400a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21401b;

    /* renamed from: c, reason: collision with root package name */
    public final int f21402c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f21403d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f21404e;

    public VersionInfoParcel(int i2, int i3, boolean z, boolean z2) {
        String str = z ? "0" : "1";
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + String.valueOf(i2).length() + 13 + 2);
        e.w(i2, i3, "afma-sdk-a-v", CLConstants.DOT_SALT_DELIMETER, sb);
        this(b.r(sb, CLConstants.DOT_SALT_DELIMETER, str), i2, i3, z, z2);
    }

    public static VersionInfoParcel b() {
        return new VersionInfoParcel(12451000, 12451000, true, false);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f21400a, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f21401b);
        SafeParcelWriter.writeInt(parcel, 4, this.f21402c);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f21403d);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f21404e);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }

    public VersionInfoParcel(String str, int i2, int i3, boolean z, boolean z2) {
        this.f21400a = str;
        this.f21401b = i2;
        this.f21402c = i3;
        this.f21403d = z;
        this.f21404e = z2;
    }
}
