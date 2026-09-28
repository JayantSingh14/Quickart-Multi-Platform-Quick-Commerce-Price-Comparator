package com.google.android.gms.fido.u2f.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.u2f.api.common.ProtocolVersion;
import java.util.Arrays;

@SafeParcelable.Class(creator = "RegisterRequestCreator")
@Deprecated
/* loaded from: classes4.dex */
public class RegisterRequest extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<RegisterRequest> CREATOR = new zzg();

    /* renamed from: a, reason: collision with root package name */
    public final int f22497a;

    /* renamed from: b, reason: collision with root package name */
    public final ProtocolVersion f22498b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f22499c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22500d;

    public RegisterRequest(int i2, String str, String str2, byte[] bArr) {
        this.f22497a = i2;
        try {
            this.f22498b = ProtocolVersion.a(str);
            this.f22499c = bArr;
            this.f22500d = str2;
        } catch (ProtocolVersion.UnsupportedProtocolException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequest)) {
            return false;
        }
        RegisterRequest registerRequest = (RegisterRequest) obj;
        if (!Arrays.equals(this.f22499c, registerRequest.f22499c) || this.f22498b != registerRequest.f22498b) {
            return false;
        }
        String str = registerRequest.f22500d;
        String str2 = this.f22500d;
        if (str2 == null) {
            if (str != null) {
                return false;
            }
        } else if (!str2.equals(str)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.f22499c) + 31) * 31) + this.f22498b.hashCode();
        String str = this.f22500d;
        return (iHashCode * 31) + (str == null ? 0 : str.hashCode());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22497a);
        SafeParcelWriter.writeString(parcel, 2, this.f22498b.f22496a, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.f22499c, false);
        SafeParcelWriter.writeString(parcel, 4, this.f22500d, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
