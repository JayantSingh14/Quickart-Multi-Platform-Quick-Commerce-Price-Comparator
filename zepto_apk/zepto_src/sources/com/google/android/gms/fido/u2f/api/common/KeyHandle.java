package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import java.util.ArrayList;
import java.util.Arrays;

@SafeParcelable.Class(creator = "KeyHandleCreator")
@Deprecated
/* loaded from: classes4.dex */
public class KeyHandle extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<KeyHandle> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    public final int f22490a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22491b;

    /* renamed from: c, reason: collision with root package name */
    public final ProtocolVersion f22492c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f22493d;

    public KeyHandle(int i2, byte[] bArr, String str, ArrayList arrayList) {
        this.f22490a = i2;
        this.f22491b = bArr;
        try {
            this.f22492c = ProtocolVersion.a(str);
            this.f22493d = arrayList;
        } catch (ProtocolVersion.UnsupportedProtocolException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyHandle)) {
            return false;
        }
        KeyHandle keyHandle = (KeyHandle) obj;
        if (!Arrays.equals(this.f22491b, keyHandle.f22491b) || !this.f22492c.equals(keyHandle.f22492c)) {
            return false;
        }
        ArrayList arrayList = this.f22493d;
        ArrayList arrayList2 = keyHandle.f22493d;
        if (arrayList == null && arrayList2 == null) {
            return true;
        }
        return arrayList != null && arrayList2 != null && arrayList.containsAll(arrayList2) && arrayList2.containsAll(arrayList);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22491b)), this.f22492c, this.f22493d);
    }

    public final String toString() {
        ArrayList arrayList = this.f22493d;
        String string = arrayList == null ? "null" : arrayList.toString();
        StringBuilder sbY = b.y("{keyHandle: ", Base64Utils.encode(this.f22491b), ", version: ");
        sbY.append(this.f22492c);
        sbY.append(", transports: ");
        sbY.append(string);
        sbY.append("}");
        return sbY.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22490a);
        SafeParcelWriter.writeByteArray(parcel, 2, this.f22491b, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22492c.f22496a, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.f22493d, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
