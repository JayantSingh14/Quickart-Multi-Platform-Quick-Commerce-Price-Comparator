package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ShowFirstParty
@SafeParcelable.Class(creator = "UserPreferredSleepWindowCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();

    /* renamed from: a, reason: collision with root package name */
    public final int f38372a;

    /* renamed from: b, reason: collision with root package name */
    public final int f38373b;

    /* renamed from: c, reason: collision with root package name */
    public final int f38374c;

    /* renamed from: d, reason: collision with root package name */
    public final int f38375d;

    public zzaj(int i2, int i3, int i4, int i5) {
        Preconditions.checkState(i2 >= 0 && i2 <= 23, "Start hour must be in range [0, 23].");
        Preconditions.checkState(i3 >= 0 && i3 <= 59, "Start minute must be in range [0, 59].");
        Preconditions.checkState(i4 >= 0 && i4 <= 23, "End hour must be in range [0, 23].");
        Preconditions.checkState(i5 >= 0 && i5 <= 59, "End minute must be in range [0, 59].");
        Preconditions.checkState(((i2 + i3) + i4) + i5 > 0, "Parameters can't be all 0.");
        this.f38372a = i2;
        this.f38373b = i3;
        this.f38374c = i4;
        this.f38375d = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzaj)) {
            return false;
        }
        zzaj zzajVar = (zzaj) obj;
        return this.f38372a == zzajVar.f38372a && this.f38373b == zzajVar.f38373b && this.f38374c == zzajVar.f38374c && this.f38375d == zzajVar.f38375d;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f38372a), Integer.valueOf(this.f38373b), Integer.valueOf(this.f38374c), Integer.valueOf(this.f38375d));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("UserPreferredSleepWindow [startHour=");
        sb.append(this.f38372a);
        sb.append(", startMinute=");
        sb.append(this.f38373b);
        sb.append(", endHour=");
        sb.append(this.f38374c);
        sb.append(", endMinute=");
        return b.o(sb, this.f38375d, "]");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        Preconditions.checkNotNull(parcel);
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f38372a);
        SafeParcelWriter.writeInt(parcel, 2, this.f38373b);
        SafeParcelWriter.writeInt(parcel, 3, this.f38374c);
        SafeParcelWriter.writeInt(parcel, 4, this.f38375d);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
