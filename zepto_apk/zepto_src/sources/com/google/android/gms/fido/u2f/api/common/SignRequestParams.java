package com.google.android.gms.fido.u2f.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

@SafeParcelable.Class(creator = "SignRequestParamsCreator")
@SafeParcelable.Reserved({1})
@Deprecated
/* loaded from: classes4.dex */
public class SignRequestParams extends RequestParams {

    @NonNull
    public static final Parcelable.Creator<SignRequestParams> CREATOR = new zzk();

    /* renamed from: a, reason: collision with root package name */
    public final Integer f22514a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f22515b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f22516c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f22517d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f22518e;

    /* renamed from: f, reason: collision with root package name */
    public final ChannelIdValue f22519f;

    /* renamed from: g, reason: collision with root package name */
    public final String f22520g;

    public static final class Builder {
    }

    public SignRequestParams(Integer num, Double d2, Uri uri, byte[] bArr, ArrayList arrayList, ChannelIdValue channelIdValue, String str) {
        this.f22514a = num;
        this.f22515b = d2;
        this.f22516c = uri;
        this.f22517d = bArr;
        Preconditions.checkArgument((arrayList == null || arrayList.isEmpty()) ? false : true, "registeredKeys must not be null or empty");
        this.f22518e = arrayList;
        this.f22519f = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RegisteredKey registeredKey = (RegisteredKey) it.next();
            Preconditions.checkArgument((registeredKey.f22512b == null && uri == null) ? false : true, "registered key has null appId and no request appId is provided");
            Preconditions.checkArgument(true, "register request has null challenge and no default challenge isprovided");
            String str2 = registeredKey.f22512b;
            if (str2 != null) {
                hashSet.add(Uri.parse(str2));
            }
        }
        Preconditions.checkArgument(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f22520g = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignRequestParams)) {
            return false;
        }
        SignRequestParams signRequestParams = (SignRequestParams) obj;
        if (!Objects.equal(this.f22514a, signRequestParams.f22514a) || !Objects.equal(this.f22515b, signRequestParams.f22515b) || !Objects.equal(this.f22516c, signRequestParams.f22516c) || !Arrays.equals(this.f22517d, signRequestParams.f22517d)) {
            return false;
        }
        ArrayList arrayList = this.f22518e;
        ArrayList arrayList2 = signRequestParams.f22518e;
        return arrayList.containsAll(arrayList2) && arrayList2.containsAll(arrayList) && Objects.equal(this.f22519f, signRequestParams.f22519f) && Objects.equal(this.f22520g, signRequestParams.f22520g);
    }

    public final int hashCode() {
        Integer numValueOf = Integer.valueOf(Arrays.hashCode(this.f22517d));
        return Objects.hashCode(this.f22514a, this.f22516c, this.f22515b, this.f22518e, this.f22519f, this.f22520g, numValueOf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerObject(parcel, 2, this.f22514a, false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, this.f22515b, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f22516c, i2, false);
        SafeParcelWriter.writeByteArray(parcel, 5, this.f22517d, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.f22518e, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f22519f, i2, false);
        SafeParcelWriter.writeString(parcel, 8, this.f22520g, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
