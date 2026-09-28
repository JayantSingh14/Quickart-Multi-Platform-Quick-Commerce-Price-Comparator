package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;

@SafeParcelable.Class(creator = "RewardItemParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzbzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbzy> CREATOR = new zzbzz();

    /* renamed from: a, reason: collision with root package name */
    public final String f25781a;

    /* renamed from: b, reason: collision with root package name */
    public final int f25782b;

    public zzbzy(String str, int i2) {
        this.f25781a = str;
        this.f25782b = i2;
    }

    public static zzbzy b(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzbzy(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbzy)) {
            return false;
        }
        zzbzy zzbzyVar = (zzbzy) obj;
        return Objects.equal(this.f25781a, zzbzyVar.f25781a) && Objects.equal(Integer.valueOf(this.f25782b), Integer.valueOf(zzbzyVar.f25782b));
    }

    public final int hashCode() {
        return Objects.hashCode(this.f25781a, Integer.valueOf(this.f25782b));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f25781a, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f25782b);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
