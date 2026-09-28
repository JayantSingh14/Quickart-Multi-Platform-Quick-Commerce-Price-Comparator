package co.touchlab.kermit;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@JvmInline
/* loaded from: classes3.dex */
public final class Message {
    public static void a(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Message)) {
            return false;
        }
        ((Message) obj).getClass();
        return Intrinsics.b(null, null);
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "Message(message=null)";
    }
}
