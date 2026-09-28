package io.ktor.utils.io.core.internal;

import kotlin.Metadata;
import kotlin.UShort;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.Message;

@Metadata
@JvmInline
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class EncodeResult {
    public static final short a(int i2) {
        short s = (short) (i2 >>> 16);
        UShort.Companion companion = UShort.f53567b;
        return s;
    }

    public static final short b(int i2) {
        short s = (short) (i2 & Message.MAXLENGTH);
        UShort.Companion companion = UShort.f53567b;
        return s;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof EncodeResult)) {
            return false;
        }
        ((EncodeResult) obj).getClass();
        return true;
    }

    public final int hashCode() {
        return Integer.hashCode(0);
    }

    public final String toString() {
        return "EncodeResult(value=0)";
    }
}
