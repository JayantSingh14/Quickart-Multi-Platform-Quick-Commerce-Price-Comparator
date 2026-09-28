package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Objects;

@SafeParcelable.Class(creator = "ScionActivityInfoCreator")
/* loaded from: classes.dex */
public final class zzdf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdf> CREATOR = new zzdg();

    /* renamed from: a, reason: collision with root package name */
    public final int f36836a;

    /* renamed from: b, reason: collision with root package name */
    public final String f36837b;

    /* renamed from: c, reason: collision with root package name */
    public final Intent f36838c;

    public zzdf(int i2, String str, Intent intent) {
        this.f36836a = i2;
        this.f36837b = str;
        this.f36838c = intent;
    }

    public static zzdf b(Activity activity) {
        return new zzdf(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdf)) {
            return false;
        }
        zzdf zzdfVar = (zzdf) obj;
        return this.f36836a == zzdfVar.f36836a && Objects.equals(this.f36837b, zzdfVar.f36837b) && Objects.equals(this.f36838c, zzdfVar.f36838c);
    }

    public final int hashCode() {
        return this.f36836a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f36836a);
        SafeParcelWriter.writeString(parcel, 2, this.f36837b, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f36838c, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
