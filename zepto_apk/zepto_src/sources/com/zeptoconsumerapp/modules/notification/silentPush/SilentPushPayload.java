package com.zeptoconsumerapp.modules.notification.silentPush;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class SilentPushPayload {

    /* renamed from: a, reason: collision with root package name */
    public final String f47700a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f47701b;

    public SilentPushPayload(String actionType, Map map) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        this.f47700a = actionType;
        this.f47701b = map;
    }

    public final String a() {
        return this.f47700a;
    }

    public final Map b() {
        return this.f47701b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SilentPushPayload)) {
            return false;
        }
        SilentPushPayload silentPushPayload = (SilentPushPayload) obj;
        return Intrinsics.b(this.f47700a, silentPushPayload.f47700a) && Intrinsics.b(this.f47701b, silentPushPayload.f47701b);
    }

    public final int hashCode() {
        int iHashCode = this.f47700a.hashCode() * 31;
        Map map = this.f47701b;
        return iHashCode + (map == null ? 0 : map.hashCode());
    }

    public final String toString() {
        return "SilentPushPayload(actionType=" + this.f47700a + ", data=" + this.f47701b + ")";
    }
}
