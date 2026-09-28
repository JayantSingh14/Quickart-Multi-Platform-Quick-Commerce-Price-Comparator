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
@SafeParcelable.Class(creator = "IncomingCallRetrieverRequestCreator")
/* loaded from: classes4.dex */
public final class IncomingCallRetrieverRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    @JvmField
    @NotNull
    public static final Parcelable.Creator<IncomingCallRetrieverRequest> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    public final String f22130a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22131b;

    /* renamed from: c, reason: collision with root package name */
    public final String f22132c;

    /* renamed from: d, reason: collision with root package name */
    public final String f22133d;

    @Metadata
    public static final class Companion {
    }

    public IncomingCallRetrieverRequest(String countryCode, String prefix, String startRange, String endRange) {
        Intrinsics.checkNotNullParameter(countryCode, "countryCode");
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        Intrinsics.checkNotNullParameter(startRange, "startRange");
        Intrinsics.checkNotNullParameter(endRange, "endRange");
        this.f22130a = countryCode;
        this.f22131b = prefix;
        this.f22132c = startRange;
        this.f22133d = endRange;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i2) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(dest);
        SafeParcelWriter.writeString(dest, 1, this.f22130a, false);
        SafeParcelWriter.writeString(dest, 2, this.f22131b, false);
        SafeParcelWriter.writeString(dest, 3, this.f22132c, false);
        SafeParcelWriter.writeString(dest, 4, this.f22133d, false);
        SafeParcelWriter.finishObjectHeader(dest, iBeginObjectHeader);
    }
}
