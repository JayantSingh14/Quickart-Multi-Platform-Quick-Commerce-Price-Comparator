package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

@SafeParcelable.Class(creator = "GeofencingRequestCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public class GeofencingRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzn();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f38297a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38298b;

    /* renamed from: c, reason: collision with root package name */
    public final String f38299c;

    /* renamed from: d, reason: collision with root package name */
    public final String f38300d;

    public static final class Builder {
        public Builder() {
            new ArrayList();
        }
    }

    public @interface InitialTrigger {
    }

    public GeofencingRequest(ArrayList arrayList, int i2, String str, String str2) {
        this.f38297a = arrayList;
        this.f38298b = i2;
        this.f38299c = str;
        this.f38300d = str2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("GeofencingRequest[geofences=");
        sb.append(this.f38297a);
        sb.append(", initialTrigger=");
        sb.append(this.f38298b);
        sb.append(", tag=");
        sb.append(this.f38299c);
        sb.append(", attributionTag=");
        return b.r(sb, this.f38300d, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f38297a, false);
        SafeParcelWriter.writeInt(parcel, 2, this.f38298b);
        SafeParcelWriter.writeString(parcel, 3, this.f38299c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f38300d, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
