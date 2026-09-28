package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class Subscriber {

    @VisibleForTesting
    public static final class SynchronizedSubscriber extends Subscriber {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Subscriber)) {
            return false;
        }
        ((Subscriber) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }
}
