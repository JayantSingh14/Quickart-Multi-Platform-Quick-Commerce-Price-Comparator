package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialType;
import java.util.ArrayList;
import java.util.Arrays;

@SafeParcelable.Class(creator = "PublicKeyCredentialDescriptorCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class PublicKeyCredentialDescriptor extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<PublicKeyCredentialDescriptor> CREATOR;

    /* renamed from: a, reason: collision with root package name */
    public final PublicKeyCredentialType f22414a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f22415b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f22416c;

    public static class UnsupportedPubKeyCredDescriptorException extends Exception {
    }

    static {
        com.google.android.gms.internal.fido.zzau.k(2, com.google.android.gms.internal.fido.zzh.f36613a, com.google.android.gms.internal.fido.zzh.f36614b);
        CREATOR = new zzam();
    }

    public PublicKeyCredentialDescriptor(String str, byte[] bArr, ArrayList arrayList) {
        Preconditions.checkNotNull(str);
        try {
            this.f22414a = PublicKeyCredentialType.a(str);
            this.f22415b = (byte[]) Preconditions.checkNotNull(bArr);
            this.f22416c = arrayList;
        } catch (PublicKeyCredentialType.UnsupportedPublicKeyCredTypeException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PublicKeyCredentialDescriptor)) {
            return false;
        }
        PublicKeyCredentialDescriptor publicKeyCredentialDescriptor = (PublicKeyCredentialDescriptor) obj;
        if (!this.f22414a.equals(publicKeyCredentialDescriptor.f22414a) || !Arrays.equals(this.f22415b, publicKeyCredentialDescriptor.f22415b)) {
            return false;
        }
        ArrayList arrayList = this.f22416c;
        ArrayList arrayList2 = publicKeyCredentialDescriptor.f22416c;
        if (arrayList == null && arrayList2 == null) {
            return true;
        }
        return arrayList != null && arrayList2 != null && arrayList.containsAll(arrayList2) && arrayList2.containsAll(arrayList);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22414a, Integer.valueOf(Arrays.hashCode(this.f22415b)), this.f22416c);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        this.f22414a.getClass();
        SafeParcelWriter.writeString(parcel, 2, "public-key", false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.f22415b, false);
        SafeParcelWriter.writeTypedList(parcel, 4, this.f22416c, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
