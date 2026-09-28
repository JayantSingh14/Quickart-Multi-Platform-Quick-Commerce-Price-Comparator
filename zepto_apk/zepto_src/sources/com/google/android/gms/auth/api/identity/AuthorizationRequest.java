package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;

@SafeParcelable.Class(creator = "AuthorizationRequestCreator")
/* loaded from: classes4.dex */
public class AuthorizationRequest extends AbstractSafeParcelable implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new zbb();

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f22062a;

    /* renamed from: b, reason: collision with root package name */
    public final String f22063b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f22064c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22065d;

    /* renamed from: e, reason: collision with root package name */
    public final Account f22066e;

    /* renamed from: f, reason: collision with root package name */
    public final String f22067f;

    /* renamed from: g, reason: collision with root package name */
    public final String f22068g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f22069h;

    /* renamed from: i, reason: collision with root package name */
    public final Bundle f22070i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f22071j;

    public static final class Builder {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class ResourceParameter {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ResourceParameter[] f22072a = {new ResourceParameter("ACCOUNT_SELECTION_TOKEN", 0), new ResourceParameter("ACCOUNT_SELECTION_STATE", 1)};

        /* JADX INFO: Fake field, exist only in values array */
        ResourceParameter EF5;

        @NonNull
        public static ResourceParameter valueOf(@NonNull String str) {
            return (ResourceParameter) Enum.valueOf(ResourceParameter.class, str);
        }

        @NonNull
        public static ResourceParameter[] values() {
            return (ResourceParameter[]) f22072a.clone();
        }
    }

    public AuthorizationRequest(ArrayList arrayList, String str, boolean z, boolean z2, Account account, String str2, String str3, boolean z3, Bundle bundle, boolean z4) {
        boolean z5 = false;
        if (arrayList != null && !arrayList.isEmpty()) {
            z5 = true;
        }
        Preconditions.checkArgument(z5, "requestedScopes cannot be null or empty");
        this.f22062a = arrayList;
        this.f22063b = str;
        this.f22064c = z;
        this.f22065d = z2;
        this.f22066e = account;
        this.f22067f = str2;
        this.f22068g = str3;
        this.f22069h = z3;
        this.f22070i = bundle;
        this.f22071j = z4;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        ArrayList arrayList = this.f22062a;
        if (arrayList.size() != authorizationRequest.f22062a.size() || !arrayList.containsAll(authorizationRequest.f22062a)) {
            return false;
        }
        Bundle bundle = this.f22070i;
        Bundle bundle2 = authorizationRequest.f22070i;
        if (bundle == null) {
            if (bundle2 != null) {
                return false;
            }
            bundle2 = null;
        }
        if (bundle != null && bundle2 == null) {
            return false;
        }
        if (bundle != null) {
            if (bundle.size() != bundle2.size()) {
                return false;
            }
            for (String str : bundle.keySet()) {
                if (!Objects.equal(bundle.getString(str), bundle2.getString(str))) {
                    return false;
                }
            }
        }
        return this.f22064c == authorizationRequest.f22064c && this.f22069h == authorizationRequest.f22069h && this.f22065d == authorizationRequest.f22065d && this.f22071j == authorizationRequest.f22071j && Objects.equal(this.f22063b, authorizationRequest.f22063b) && Objects.equal(this.f22066e, authorizationRequest.f22066e) && Objects.equal(this.f22067f, authorizationRequest.f22067f) && Objects.equal(this.f22068g, authorizationRequest.f22068g);
    }

    public final int hashCode() {
        Boolean boolValueOf = Boolean.valueOf(this.f22064c);
        Boolean boolValueOf2 = Boolean.valueOf(this.f22069h);
        Boolean boolValueOf3 = Boolean.valueOf(this.f22065d);
        Boolean boolValueOf4 = Boolean.valueOf(this.f22071j);
        return Objects.hashCode(this.f22062a, this.f22063b, boolValueOf, boolValueOf2, boolValueOf3, this.f22066e, this.f22067f, this.f22068g, this.f22070i, boolValueOf4);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.f22062a, false);
        SafeParcelWriter.writeString(parcel, 2, this.f22063b, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f22064c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22065d);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f22066e, i2, false);
        SafeParcelWriter.writeString(parcel, 6, this.f22067f, false);
        SafeParcelWriter.writeString(parcel, 7, this.f22068g, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f22069h);
        SafeParcelWriter.writeBundle(parcel, 9, this.f22070i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f22071j);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
