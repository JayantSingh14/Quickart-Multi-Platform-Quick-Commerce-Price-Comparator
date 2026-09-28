package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fido.fido2.api.common.Attachment;
import com.google.android.gms.fido.fido2.api.common.ResidentKeyRequirement;

@SafeParcelable.Class(creator = "AuthenticatorSelectionCriteriaCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class AuthenticatorSelectionCriteria extends AbstractSafeParcelable {

    @NonNull
    public static final Parcelable.Creator<AuthenticatorSelectionCriteria> CREATOR = new zzm();

    /* renamed from: a, reason: collision with root package name */
    public final Attachment f22372a;

    /* renamed from: b, reason: collision with root package name */
    public final Boolean f22373b;

    /* renamed from: c, reason: collision with root package name */
    public final zzay f22374c;

    /* renamed from: d, reason: collision with root package name */
    public final ResidentKeyRequirement f22375d;

    public static class Builder {
    }

    public AuthenticatorSelectionCriteria(Boolean bool, String str, String str2, String str3) {
        Attachment attachmentA;
        ResidentKeyRequirement residentKeyRequirementA = null;
        if (str == null) {
            attachmentA = null;
        } else {
            try {
                attachmentA = Attachment.a(str);
            } catch (Attachment.UnsupportedAttachmentException | ResidentKeyRequirement.UnsupportedResidentKeyRequirementException | zzax e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        this.f22372a = attachmentA;
        this.f22373b = bool;
        this.f22374c = str2 == null ? null : zzay.a(str2);
        if (str3 != null) {
            residentKeyRequirementA = ResidentKeyRequirement.a(str3);
        }
        this.f22375d = residentKeyRequirementA;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AuthenticatorSelectionCriteria)) {
            return false;
        }
        AuthenticatorSelectionCriteria authenticatorSelectionCriteria = (AuthenticatorSelectionCriteria) obj;
        return Objects.equal(this.f22372a, authenticatorSelectionCriteria.f22372a) && Objects.equal(this.f22373b, authenticatorSelectionCriteria.f22373b) && Objects.equal(this.f22374c, authenticatorSelectionCriteria.f22374c) && Objects.equal(this.f22375d, authenticatorSelectionCriteria.f22375d);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22372a, this.f22373b, this.f22374c, this.f22375d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Attachment attachment = this.f22372a;
        SafeParcelWriter.writeString(parcel, 2, attachment == null ? null : attachment.f22342a, false);
        SafeParcelWriter.writeBooleanObject(parcel, 3, this.f22373b, false);
        zzay zzayVar = this.f22374c;
        SafeParcelWriter.writeString(parcel, 4, zzayVar == null ? null : zzayVar.f22455a, false);
        ResidentKeyRequirement residentKeyRequirement = this.f22375d;
        SafeParcelWriter.writeString(parcel, 5, residentKeyRequirement != null ? residentKeyRequirement.f22440a : null, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
