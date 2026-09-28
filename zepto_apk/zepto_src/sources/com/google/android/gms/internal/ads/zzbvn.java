package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import javax.annotation.ParametersAreNonnullByDefault;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "RtbVersionInfoParcelCreator")
/* loaded from: classes4.dex */
public final class zzbvn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbvn> CREATOR = new zzbvo();

    /* renamed from: a, reason: collision with root package name */
    public final int f25597a;

    /* renamed from: b, reason: collision with root package name */
    public final int f25598b;

    /* renamed from: c, reason: collision with root package name */
    public final int f25599c;

    public zzbvn(int i2, int i3, int i4) {
        this.f25597a = i2;
        this.f25598b = i3;
        this.f25599c = i4;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbvn)) {
            zzbvn zzbvnVar = (zzbvn) obj;
            if (zzbvnVar.f25599c == this.f25599c && zzbvnVar.f25598b == this.f25598b && zzbvnVar.f25597a == this.f25597a) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.f25597a, this.f25598b, this.f25599c});
    }

    public final String toString() {
        int i2 = this.f25597a;
        int length = String.valueOf(i2).length();
        int i3 = this.f25598b;
        int length2 = String.valueOf(i3).length();
        int i4 = this.f25599c;
        StringBuilder sb = new StringBuilder(length + 1 + length2 + 1 + String.valueOf(i4).length());
        android.support.v4.media.a.q(i2, i3, CLConstants.DOT_SALT_DELIMETER, CLConstants.DOT_SALT_DELIMETER, sb);
        sb.append(i4);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f25597a);
        SafeParcelWriter.writeInt(parcel, 2, this.f25598b);
        SafeParcelWriter.writeInt(parcel, 3, this.f25599c);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
