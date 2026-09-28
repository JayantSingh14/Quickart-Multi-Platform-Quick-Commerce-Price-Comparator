package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashSet;

@SafeParcelable.Class(creator = "UvmEntriesCreator")
/* loaded from: classes4.dex */
public class UvmEntries extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<UvmEntries> CREATOR = new zzaz();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f22446a;

    public static final class Builder {
        public Builder() {
            new ArrayList();
        }
    }

    public UvmEntries(ArrayList arrayList) {
        this.f22446a = arrayList;
    }

    public final boolean equals(Object obj) {
        ArrayList arrayList;
        if (!(obj instanceof UvmEntries)) {
            return false;
        }
        UvmEntries uvmEntries = (UvmEntries) obj;
        ArrayList arrayList2 = this.f22446a;
        if (arrayList2 == null && uvmEntries.f22446a == null) {
            return true;
        }
        return arrayList2 != null && (arrayList = uvmEntries.f22446a) != null && arrayList2.containsAll(arrayList) && uvmEntries.f22446a.containsAll(arrayList2);
    }

    public final int hashCode() {
        return Objects.hashCode(new HashSet(this.f22446a));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f22446a, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
