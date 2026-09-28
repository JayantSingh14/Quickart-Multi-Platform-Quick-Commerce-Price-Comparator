package com.zeptoconsumerapp.modules.notification.silentPush;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ActionMeta {

    /* renamed from: a, reason: collision with root package name */
    public final Long f47689a;

    /* renamed from: b, reason: collision with root package name */
    public final Function1 f47690b;

    public ActionMeta(Long l2, Function1 handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f47689a = l2;
        this.f47690b = handler;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionMeta)) {
            return false;
        }
        ActionMeta actionMeta = (ActionMeta) obj;
        return Intrinsics.b(this.f47689a, actionMeta.f47689a) && Intrinsics.b(this.f47690b, actionMeta.f47690b);
    }

    public final int hashCode() {
        Long l2 = this.f47689a;
        return this.f47690b.hashCode() + ((l2 == null ? 0 : l2.hashCode()) * 31);
    }

    public final String toString() {
        return "ActionMeta(cooldownWindowMs=" + this.f47689a + ", handler=" + this.f47690b + ")";
    }
}
