package com.zeptoconsumerapp.apiprefetch.tracker;

import android.support.v4.media.a;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
/* loaded from: classes4.dex */
public final class ApiState {

    @Nullable
    private final String data;

    @Nullable
    private final String error;

    @NotNull
    private final String id;

    @NotNull
    private final ApiStatus status;

    public ApiState(@NotNull String id, @NotNull ApiStatus status, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(status, "status");
        this.id = id;
        this.status = status;
        this.data = str;
        this.error = str2;
    }

    public static /* synthetic */ ApiState copy$default(ApiState apiState, String str, ApiStatus apiStatus, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = apiState.id;
        }
        if ((i2 & 2) != 0) {
            apiStatus = apiState.status;
        }
        if ((i2 & 4) != 0) {
            str2 = apiState.data;
        }
        if ((i2 & 8) != 0) {
            str3 = apiState.error;
        }
        return apiState.copy(str, apiStatus, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final ApiStatus component2() {
        return this.status;
    }

    @Nullable
    public final String component3() {
        return this.data;
    }

    @Nullable
    public final String component4() {
        return this.error;
    }

    @NotNull
    public final ApiState copy(@NotNull String id, @NotNull ApiStatus status, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(status, "status");
        return new ApiState(id, status, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiState)) {
            return false;
        }
        ApiState apiState = (ApiState) obj;
        return Intrinsics.b(this.id, apiState.id) && this.status == apiState.status && Intrinsics.b(this.data, apiState.data) && Intrinsics.b(this.error, apiState.error);
    }

    @Nullable
    public final String getData() {
        return this.data;
    }

    @Nullable
    public final String getError() {
        return this.error;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final ApiStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        int iHashCode = (this.status.hashCode() + (this.id.hashCode() * 31)) * 31;
        String str = this.data;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.error;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.id;
        ApiStatus apiStatus = this.status;
        String str2 = this.data;
        String str3 = this.error;
        StringBuilder sb = new StringBuilder("ApiState(id=");
        sb.append(str);
        sb.append(", status=");
        sb.append(apiStatus);
        sb.append(", data=");
        return a.n(sb, str2, ", error=", str3, ")");
    }

    public /* synthetic */ ApiState(String str, ApiStatus apiStatus, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, apiStatus, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3);
    }
}
