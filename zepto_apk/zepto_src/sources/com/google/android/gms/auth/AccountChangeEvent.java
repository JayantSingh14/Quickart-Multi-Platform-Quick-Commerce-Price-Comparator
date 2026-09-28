package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AccountChangeEventCreator")
/* loaded from: classes4.dex */
public class AccountChangeEvent extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    public final int f22002a;

    /* renamed from: b, reason: collision with root package name */
    public final long f22003b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22004c;

    /* renamed from: d, reason: collision with root package name */
    public final int f22005d;

    /* renamed from: e, reason: collision with root package name */
    public final int f22006e;

    /* renamed from: f, reason: collision with root package name */
    public final String f22007f;

    public AccountChangeEvent(int i2, long j2, String str, int i3, int i4, String str2) {
        this.f22002a = i2;
        this.f22003b = j2;
        this.f22004c = (String) Preconditions.checkNotNull(str);
        this.f22005d = i3;
        this.f22006e = i4;
        this.f22007f = str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.f22002a == accountChangeEvent.f22002a && this.f22003b == accountChangeEvent.f22003b && Objects.equal(this.f22004c, accountChangeEvent.f22004c) && this.f22005d == accountChangeEvent.f22005d && this.f22006e == accountChangeEvent.f22006e && Objects.equal(this.f22007f, accountChangeEvent.f22007f);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22002a), Long.valueOf(this.f22003b), this.f22004c, Integer.valueOf(this.f22005d), Integer.valueOf(this.f22006e), this.f22007f);
    }

    public final String toString() {
        int i2 = this.f22005d;
        String str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        StringBuilder sb = new StringBuilder("AccountChangeEvent {accountName = ");
        b.B(sb, this.f22004c, ", changeType = ", str, ", changeData = ");
        sb.append(this.f22007f);
        sb.append(", eventIndex = ");
        return b.o(sb, this.f22006e, "}");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22002a);
        SafeParcelWriter.writeLong(parcel, 2, this.f22003b);
        SafeParcelWriter.writeString(parcel, 3, this.f22004c, false);
        SafeParcelWriter.writeInt(parcel, 4, this.f22005d);
        SafeParcelWriter.writeInt(parcel, 5, this.f22006e);
        SafeParcelWriter.writeString(parcel, 6, this.f22007f, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
