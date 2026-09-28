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
import java.util.HashSet;
import java.util.Iterator;

@SafeParcelable.Class(creator = "RegisterRequestParamsCreator")
@SafeParcelable.Reserved({1})
@Deprecated
/* loaded from: classes4.dex */
public class RegisterRequestParams extends RequestParams {

    @NonNull
    public static final Parcelable.Creator<RegisterRequestParams> CREATOR = new zzh();

    /* renamed from: a, reason: collision with root package name */
    public final Integer f22501a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f22502b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f22503c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f22504d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f22505e;

    /* renamed from: f, reason: collision with root package name */
    public final ChannelIdValue f22506f;

    /* renamed from: g, reason: collision with root package name */
    public final String f22507g;

    public static final class Builder {
    }

    public RegisterRequestParams(Integer num, Double d2, Uri uri, ArrayList arrayList, ArrayList arrayList2, ChannelIdValue channelIdValue, String str) {
        this.f22501a = num;
        this.f22502b = d2;
        this.f22503c = uri;
        Preconditions.checkArgument((arrayList == null || arrayList.isEmpty()) ? false : true, "empty list of register requests is provided");
        this.f22504d = arrayList;
        this.f22505e = arrayList2;
        this.f22506f = channelIdValue;
        HashSet hashSet = new HashSet();
        if (uri != null) {
            hashSet.add(uri);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            RegisterRequest registerRequest = (RegisterRequest) it.next();
            Preconditions.checkArgument((uri == null && registerRequest.f22500d == null) ? false : true, "register request has null appId and no request appId is provided");
            String str2 = registerRequest.f22500d;
            if (str2 != null) {
                hashSet.add(Uri.parse(str2));
            }
        }
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            RegisteredKey registeredKey = (RegisteredKey) it2.next();
            Preconditions.checkArgument((uri == null && registeredKey.f22512b == null) ? false : true, "registered key has null appId and no request appId is provided");
            String str3 = registeredKey.f22512b;
            if (str3 != null) {
                hashSet.add(Uri.parse(str3));
            }
        }
        Preconditions.checkArgument(str == null || str.length() <= 80, "Display Hint cannot be longer than 80 characters");
        this.f22507g = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RegisterRequestParams)) {
            return false;
        }
        RegisterRequestParams registerRequestParams = (RegisterRequestParams) obj;
        if (!Objects.equal(this.f22501a, registerRequestParams.f22501a) || !Objects.equal(this.f22502b, registerRequestParams.f22502b) || !Objects.equal(this.f22503c, registerRequestParams.f22503c) || !Objects.equal(this.f22504d, registerRequestParams.f22504d)) {
            return false;
        }
        ArrayList arrayList = this.f22505e;
        ArrayList arrayList2 = registerRequestParams.f22505e;
        return ((arrayList == null && arrayList2 == null) || (arrayList != null && arrayList2 != null && arrayList.containsAll(arrayList2) && arrayList2.containsAll(arrayList))) && Objects.equal(this.f22506f, registerRequestParams.f22506f) && Objects.equal(this.f22507g, registerRequestParams.f22507g);
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22501a, this.f22503c, this.f22502b, this.f22504d, this.f22505e, this.f22506f, this.f22507g);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerObject(parcel, 2, this.f22501a, false);
        SafeParcelWriter.writeDoubleObject(parcel, 3, this.f22502b, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.f22503c, i2, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.f22504d, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.f22505e, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.f22506f, i2, false);
        SafeParcelWriter.writeString(parcel, 8, this.f22507g, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
