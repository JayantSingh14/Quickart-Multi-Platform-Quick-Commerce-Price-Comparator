package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Objects;

@SafeParcelable.Class(creator = "PreloadConfigurationParcelCreator")
/* loaded from: classes4.dex */
public final class zzft extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzft> CREATOR = new zzfu();

    /* renamed from: a, reason: collision with root package name */
    public final String f21239a;

    /* renamed from: b, reason: collision with root package name */
    public final int f21240b;

    /* renamed from: c, reason: collision with root package name */
    public final zzm f21241c;

    /* renamed from: d, reason: collision with root package name */
    public final int f21242d;

    public zzft(String str, int i2, zzm zzmVar, int i3) {
        this.f21239a = str;
        this.f21240b = i2;
        this.f21241c = zzmVar;
        this.f21242d = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return false;
        }
        zzft zzftVar = (zzft) obj;
        return this.f21239a.equals(zzftVar.f21239a) && this.f21240b == zzftVar.f21240b && this.f21241c.b(zzftVar.f21241c);
    }

    public final int hashCode() {
        return Objects.hash(this.f21239a, Integer.valueOf(this.f21240b), this.f21241c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.f21239a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.f21240b);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f21241c, i2, false);
        SafeParcelWriter.writeInt(parcel, 4, this.f21242d);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
