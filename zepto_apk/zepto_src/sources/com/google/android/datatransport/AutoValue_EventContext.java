package com.google.android.datatransport;

import com.google.android.datatransport.EventContext;
import java.util.Arrays;

/* loaded from: classes3.dex */
final class AutoValue_EventContext extends EventContext {

    public static final class Builder extends EventContext.Builder {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventContext)) {
            return false;
        }
        EventContext eventContext = (EventContext) obj;
        eventContext.getClass();
        boolean z = eventContext instanceof AutoValue_EventContext;
        if (z) {
        }
        if (!Arrays.equals((byte[]) null, (byte[]) null)) {
            return false;
        }
        if (z) {
        }
        return Arrays.equals((byte[]) null, (byte[]) null);
    }

    public final int hashCode() {
        return Arrays.hashCode((byte[]) null) ^ (((1000003 * 1000003) ^ Arrays.hashCode((byte[]) null)) * 1000003);
    }

    public final String toString() {
        return "EventContext{pseudonymousId=null, experimentIdsClear=" + Arrays.toString((byte[]) null) + ", experimentIdsEncrypted=" + Arrays.toString((byte[]) null) + "}";
    }
}
