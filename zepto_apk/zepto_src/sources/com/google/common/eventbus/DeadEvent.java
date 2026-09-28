package com.google.common.eventbus;

import com.google.common.base.MoreObjects;

@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class DeadEvent {
    public final String toString() {
        MoreObjects.ToStringHelper toStringHelperB = MoreObjects.b(this);
        toStringHelperB.a(null, "source");
        toStringHelperB.a(null, "event");
        return toStringHelperB.toString();
    }
}
