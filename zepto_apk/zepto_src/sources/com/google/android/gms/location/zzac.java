package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "NetworkLocationStatusCreator")
@Deprecated
/* loaded from: classes4.dex */
public final class zzac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzac> CREATOR = new zzad();

    /* renamed from: a, reason: collision with root package name */
    public final int f38368a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38369b;

    /* renamed from: c, reason: collision with root package name */
    public final long f38370c;

    /* renamed from: d, reason: collision with root package name */
    public final long f38371d;

    public zzac(int i2, int i3, long j2, long j3) {
        this.f38368a = i2;
        this.f38369b = i3;
        this.f38370c = j2;
        this.f38371d = j3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzac) {
            zzac zzacVar = (zzac) obj;
            if (this.f38368a == zzacVar.f38368a && this.f38369b == zzacVar.f38369b && this.f38370c == zzacVar.f38370c && this.f38371d == zzacVar.f38371d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38369b), Integer.valueOf(this.f38368a), Long.valueOf(this.f38371d), Long.valueOf(this.f38370c));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f38368a + " Cell status: " + this.f38369b + " elapsed time NS: " + this.f38371d + " system time ms: " + this.f38370c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f38368a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38369b);
        SafeParcelWriter.writeLong(parcel, 3, this.f38370c);
        SafeParcelWriter.writeLong(parcel, 4, this.f38371d);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
