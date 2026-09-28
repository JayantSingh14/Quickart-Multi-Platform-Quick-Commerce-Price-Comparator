package com.truecaller.android.sdk.common;

import androidx.annotation.Keep;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Keep
@Metadata
@RestrictTo
/* loaded from: classes4.dex */
public final class ErrorResponse {
    private final int code;

    @NotNull
    private final String message;

    /* JADX WARN: Multi-variable type inference failed */
    public ErrorResponse() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ErrorResponse copy$default(ErrorResponse errorResponse, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = errorResponse.code;
        }
        if ((i3 & 2) != 0) {
            str = errorResponse.message;
        }
        return errorResponse.copy(i2, str);
    }

    public final int component1() {
        return this.code;
    }

    @NotNull
    public final String component2() {
        return this.message;
    }

    @NotNull
    public final ErrorResponse copy(int i2, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        return new ErrorResponse(i2, message);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ErrorResponse)) {
            return false;
        }
        ErrorResponse errorResponse = (ErrorResponse) obj;
        return this.code == errorResponse.code && Intrinsics.b(this.message, errorResponse.message);
    }

    public final int getCode() {
        return this.code;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    public int hashCode() {
        return this.message.hashCode() + (Integer.hashCode(this.code) * 31);
    }

    @NotNull
    public String toString() {
        return "ErrorResponse(code=" + this.code + ", message=" + this.message + ")";
    }

    public ErrorResponse(int i2, @NotNull String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = i2;
        this.message = message;
    }

    public /* synthetic */ ErrorResponse(int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i2, (i3 & 2) != 0 ? TrueException.TYPE_UNKNOWN_MESSAGE : str);
    }
}
