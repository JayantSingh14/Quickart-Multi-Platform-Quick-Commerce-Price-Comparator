package io.ktor.http;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class IllegalHeaderValueException extends IllegalArgumentException {
    public IllegalHeaderValueException(String headerValue, int i2) {
        Intrinsics.checkNotNullParameter(headerValue, "headerValue");
        StringBuilder sb = new StringBuilder("Header value '");
        sb.append(headerValue);
        sb.append("' contains illegal character '");
        sb.append(headerValue.charAt(i2));
        sb.append("' (code ");
        super(b.n(sb, headerValue.charAt(i2) & 255, ')'));
    }
}
