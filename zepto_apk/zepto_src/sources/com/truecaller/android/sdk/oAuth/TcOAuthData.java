package com.truecaller.android.sdk.oAuth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import androidx.fragment.app.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Parcelize
@Keep
@Metadata
/* loaded from: classes4.dex */
public final class TcOAuthData implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<TcOAuthData> CREATOR = new Creator();

    @NotNull
    private final String authorizationCode;

    @NotNull
    private final Map<String, String> properties;

    @NotNull
    private final List<String> scopesGranted;

    @NotNull
    private final String state;

    @Metadata
    public static final class Creator implements Parcelable.Creator<TcOAuthData> {
        @Override // android.os.Parcelable.Creator
        public final TcOAuthData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            String string = parcel.readString();
            String string2 = parcel.readString();
            ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
            int i2 = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(i2);
            for (int i3 = 0; i3 != i2; i3++) {
                linkedHashMap.put(parcel.readString(), parcel.readString());
            }
            return new TcOAuthData(string, string2, arrayListCreateStringArrayList, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        public final TcOAuthData[] newArray(int i2) {
            return new TcOAuthData[i2];
        }
    }

    public TcOAuthData() {
        this(null, null, null, null, 15, null);
    }

    private final Map<String, String> component4() {
        return this.properties;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TcOAuthData copy$default(TcOAuthData tcOAuthData, String str, String str2, List list, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = tcOAuthData.authorizationCode;
        }
        if ((i2 & 2) != 0) {
            str2 = tcOAuthData.state;
        }
        if ((i2 & 4) != 0) {
            list = tcOAuthData.scopesGranted;
        }
        if ((i2 & 8) != 0) {
            map = tcOAuthData.properties;
        }
        return tcOAuthData.copy(str, str2, list, map);
    }

    @NotNull
    public final String component1() {
        return this.authorizationCode;
    }

    @NotNull
    public final String component2() {
        return this.state;
    }

    @NotNull
    public final List<String> component3() {
        return this.scopesGranted;
    }

    @NotNull
    public final TcOAuthData copy(@NotNull String authorizationCode, @NotNull String state, @NotNull List<String> scopesGranted, @NotNull Map<String, String> properties) {
        Intrinsics.checkNotNullParameter(authorizationCode, "authorizationCode");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(scopesGranted, "scopesGranted");
        Intrinsics.checkNotNullParameter(properties, "properties");
        return new TcOAuthData(authorizationCode, state, scopesGranted, properties);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TcOAuthData)) {
            return false;
        }
        TcOAuthData tcOAuthData = (TcOAuthData) obj;
        return Intrinsics.b(this.authorizationCode, tcOAuthData.authorizationCode) && Intrinsics.b(this.state, tcOAuthData.state) && Intrinsics.b(this.scopesGranted, tcOAuthData.scopesGranted) && Intrinsics.b(this.properties, tcOAuthData.properties);
    }

    @NotNull
    public final String getAuthorizationCode() {
        return this.authorizationCode;
    }

    @NotNull
    public final String getDeviceCode() {
        String str = this.properties.get(OAuthResponse.KEY_DEVICE_CODE);
        return str == null ? "-1" : str;
    }

    @NotNull
    public final List<String> getScopesGranted() {
        return this.scopesGranted;
    }

    public final int getSimState() {
        String str = this.properties.get(OAuthResponse.KEY_SIM_STATE);
        if (str != null) {
            return Integer.parseInt(str);
        }
        return -1;
    }

    @NotNull
    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return this.properties.hashCode() + e.f(e.e(this.authorizationCode.hashCode() * 31, 31, this.state), 31, this.scopesGranted);
    }

    @NotNull
    public String toString() {
        String str = this.authorizationCode;
        String str2 = this.state;
        List<String> list = this.scopesGranted;
        Map<String, String> map = this.properties;
        StringBuilder sbV = e.v("TcOAuthData(authorizationCode=", str, ", state=", str2, ", scopesGranted=");
        sbV.append(list);
        sbV.append(", properties=");
        sbV.append(map);
        sbV.append(")");
        return sbV.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NotNull Parcel dest, int i2) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeString(this.authorizationCode);
        dest.writeString(this.state);
        dest.writeStringList(this.scopesGranted);
        Map<String, String> map = this.properties;
        dest.writeInt(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            dest.writeString(entry.getKey());
            dest.writeString(entry.getValue());
        }
    }

    public TcOAuthData(@NotNull String authorizationCode, @NotNull String state, @NotNull List<String> scopesGranted, @NotNull Map<String, String> properties) {
        Intrinsics.checkNotNullParameter(authorizationCode, "authorizationCode");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(scopesGranted, "scopesGranted");
        Intrinsics.checkNotNullParameter(properties, "properties");
        this.authorizationCode = authorizationCode;
        this.state = state;
        this.scopesGranted = scopesGranted;
        this.properties = properties;
    }

    public TcOAuthData(String str, String str2, List list, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? EmptyList.f53609a : list, (i2 & 8) != 0 ? MapsKt.c() : map);
    }
}
