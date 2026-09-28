package com.google.android.gms.auth.api.phone;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
@SafeParcelable.Class(creator = "IncomingCallRetrieverResponseCreator")
/* loaded from: classes4.dex */
public final class IncomingCallRetrieverResponse extends AbstractSafeParcelable implements ReflectedParcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<IncomingCallRetrieverResponse> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    public final String f22134a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22135b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22136c;

    @Metadata
    public static final class Companion {
    }

    public IncomingCallRetrieverResponse(String str, String incomingCallVerificationStatusCode, String str2) {
        Intrinsics.checkNotNullParameter(incomingCallVerificationStatusCode, "incomingCallVerificationStatusCode");
        this.f22134a = str;
        this.f22135b = incomingCallVerificationStatusCode;
        this.f22136c = str2;
        if (str != null) {
            IncomingCallRetrieverStatusCodes.f22137a.getClass();
            if (!Intrinsics.b(incomingCallVerificationStatusCode, IncomingCallRetrieverStatusCodes.a())) {
                throw new IllegalArgumentException("incomingCallVerificationStatusCode should be SUCCESS when phone number is set.");
            }
        }
        if (str == null) {
            IncomingCallRetrieverStatusCodes.f22137a.getClass();
            if (Intrinsics.b(incomingCallVerificationStatusCode, IncomingCallRetrieverStatusCodes.a())) {
                throw new IllegalArgumentException("Phone number must not be null when verificationStatus is SUCCESS.");
            }
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i2) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 1, this.f22134a, false);
        SafeParcelWriter.writeString(dest, 2, this.f22135b, false);
        SafeParcelWriter.writeString(dest, 3, this.f22136c, false);
        SafeParcelWriter.finishObjectHeader(dest, iBeginObjectHeader);
    }
}
