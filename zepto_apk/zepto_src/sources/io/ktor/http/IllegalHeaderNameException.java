package io.ktor.http;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class IllegalHeaderNameException extends IllegalArgumentException {
    public IllegalHeaderNameException(String headerName, int i2) {
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        StringBuilder sb = new StringBuilder("Header name '");
        sb.append(headerName);
        sb.append("' contains illegal character '");
        sb.append(headerName.charAt(i2));
        sb.append("' (code ");
        super(b.n(sb, headerName.charAt(i2) & 255, ')'));
    }
}
