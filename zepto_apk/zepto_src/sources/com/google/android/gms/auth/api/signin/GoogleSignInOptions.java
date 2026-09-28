package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable;
import com.google.android.gms.auth.api.signin.internal.HashAccumulator;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AccountType;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GoogleSignInOptionsCreator")
@Deprecated
/* loaded from: classes4.dex */
public class GoogleSignInOptions extends AbstractSafeParcelable implements Api.ApiOptions.Optional, ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* renamed from: k, reason: collision with root package name */
    public static final GoogleSignInOptions f22165k;

    /* renamed from: l, reason: collision with root package name */
    public static final Scope f22166l;

    /* renamed from: m, reason: collision with root package name */
    public static final Scope f22167m;
    public static final Scope n;
    public static final Comparator o;

    /* renamed from: a, reason: collision with root package name */
    public final int f22168a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f22169b;

    /* renamed from: c, reason: collision with root package name */
    public final Account f22170c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f22171d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f22172e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f22173f;

    /* renamed from: g, reason: collision with root package name */
    public final String f22174g;

    /* renamed from: h, reason: collision with root package name */
    public final String f22175h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f22176i;

    /* renamed from: j, reason: collision with root package name */
    public final String f22177j;

    public static final class Builder {

        /* renamed from: b, reason: collision with root package name */
        public boolean f22179b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f22180c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f22181d;

        /* renamed from: e, reason: collision with root package name */
        public String f22182e;

        /* renamed from: f, reason: collision with root package name */
        public Account f22183f;

        /* renamed from: g, reason: collision with root package name */
        public String f22184g;

        /* renamed from: i, reason: collision with root package name */
        public String f22186i;

        /* renamed from: a, reason: collision with root package name */
        public HashSet f22178a = new HashSet();

        /* renamed from: h, reason: collision with root package name */
        public HashMap f22185h = new HashMap();

        public final GoogleSignInOptions a() {
            Scope scope = GoogleSignInOptions.n;
            HashSet hashSet = this.f22178a;
            if (hashSet.contains(scope)) {
                Scope scope2 = GoogleSignInOptions.f22167m;
                if (hashSet.contains(scope2)) {
                    hashSet.remove(scope2);
                }
            }
            if (this.f22181d && (this.f22183f == null || !hashSet.isEmpty())) {
                this.f22178a.add(GoogleSignInOptions.f22166l);
            }
            return new GoogleSignInOptions(3, new ArrayList(hashSet), this.f22183f, this.f22181d, this.f22179b, this.f22180c, this.f22182e, this.f22184g, this.f22185h, this.f22186i);
        }
    }

    static {
        Scope scope = new Scope(Scopes.PROFILE);
        new Scope(Scopes.EMAIL);
        Scope scope2 = new Scope(Scopes.OPEN_ID);
        f22166l = scope2;
        Scope scope3 = new Scope(Scopes.GAMES_LITE);
        f22167m = scope3;
        n = new Scope(Scopes.GAMES);
        Builder builder = new Builder();
        builder.f22178a.add(scope2);
        builder.f22178a.add(scope);
        f22165k = builder.a();
        Builder builder2 = new Builder();
        HashSet hashSet = builder2.f22178a;
        hashSet.add(scope3);
        hashSet.addAll(Arrays.asList(new Scope[0]));
        builder2.a();
        CREATOR = new zae();
        o = new zac();
    }

    public GoogleSignInOptions(int i2, ArrayList arrayList, Account account, boolean z, boolean z2, boolean z3, String str, String str2, HashMap map, String str3) {
        this.f22168a = i2;
        this.f22169b = arrayList;
        this.f22170c = account;
        this.f22171d = z;
        this.f22172e = z2;
        this.f22173f = z3;
        this.f22174g = str;
        this.f22175h = str2;
        this.f22176i = new ArrayList(map.values());
        this.f22177j = str3;
    }

    public static GoogleSignInOptions b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        String strOptString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(strOptString) ? new Account(strOptString, AccountType.GOOGLE) : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), null);
    }

    public static HashMap r(ArrayList arrayList) {
        HashMap map = new HashMap();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleSignInOptionsExtensionParcelable googleSignInOptionsExtensionParcelable = (GoogleSignInOptionsExtensionParcelable) it.next();
                map.put(Integer.valueOf(googleSignInOptionsExtensionParcelable.f22193b), googleSignInOptionsExtensionParcelable);
            }
        }
        return map;
    }

    public final boolean equals(Object obj) {
        String str = this.f22174g;
        ArrayList arrayList = this.f22169b;
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            ArrayList arrayList2 = googleSignInOptions.f22169b;
            String str2 = googleSignInOptions.f22174g;
            Account account = googleSignInOptions.f22170c;
            if (this.f22176i.isEmpty() && googleSignInOptions.f22176i.isEmpty() && arrayList.size() == new ArrayList(arrayList2).size() && arrayList.containsAll(new ArrayList(arrayList2))) {
                Account account2 = this.f22170c;
                if (account2 == null) {
                    if (account != null) {
                        return false;
                    }
                } else if (!account2.equals(account)) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        return false;
                    }
                } else if (!str.equals(str2)) {
                    return false;
                }
                if (this.f22173f == googleSignInOptions.f22173f && this.f22171d == googleSignInOptions.f22171d && this.f22172e == googleSignInOptions.f22172e) {
                    return TextUtils.equals(this.f22177j, googleSignInOptions.f22177j);
                }
                return false;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f22169b;
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(((Scope) arrayList2.get(i2)).getScopeUri());
        }
        Collections.sort(arrayList);
        HashAccumulator hashAccumulator = new HashAccumulator();
        hashAccumulator.a(arrayList);
        hashAccumulator.a(this.f22170c);
        hashAccumulator.a(this.f22174g);
        hashAccumulator.f22195a = (((((hashAccumulator.f22195a * 31) + (this.f22173f ? 1 : 0)) * 31) + (this.f22171d ? 1 : 0)) * 31) + (this.f22172e ? 1 : 0);
        hashAccumulator.a(this.f22177j);
        return hashAccumulator.f22195a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22168a);
        SafeParcelWriter.writeTypedList(parcel, 2, new ArrayList(this.f22169b), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f22170c, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22171d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f22172e);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f22173f);
        SafeParcelWriter.writeString(parcel, 7, this.f22174g, false);
        SafeParcelWriter.writeString(parcel, 8, this.f22175h, false);
        SafeParcelWriter.writeTypedList(parcel, 9, this.f22176i, false);
        SafeParcelWriter.writeString(parcel, 10, this.f22177j, false);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
