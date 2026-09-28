package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UvmEntryCreator")
/* loaded from: classes4.dex */
public class UvmEntry extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<UvmEntry> CREATOR = new zzba();

    /* renamed from: a, reason: collision with root package name */
    public final int f22447a;

    /* renamed from: b, reason: collision with root package name */
    public final short f22448b;

    /* renamed from: c, reason: collision with root package name */
    public final short f22449c;

    public static final class Builder {
    }

    public UvmEntry(int i2, short s, short s2) {
        this.f22447a = i2;
        this.f22448b = s;
        this.f22449c = s2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UvmEntry)) {
            return false;
        }
        UvmEntry uvmEntry = (UvmEntry) obj;
        return this.f22447a == uvmEntry.f22447a && this.f22448b == uvmEntry.f22448b && this.f22449c == uvmEntry.f22449c;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22447a), Short.valueOf(this.f22448b), Short.valueOf(this.f22449c));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22447a);
        SafeParcelWriter.writeShort(parcel, 2, this.f22448b);
        SafeParcelWriter.writeShort(parcel, 3, this.f22449c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
