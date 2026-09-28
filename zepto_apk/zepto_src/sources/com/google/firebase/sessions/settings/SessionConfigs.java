package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class SessionConfigs {

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f45179a;

    /* renamed from: b, reason: collision with root package name */
    public final Double f45180b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f45181c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f45182d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f45183e;

    public SessionConfigs(Boolean bool, Double d2, Integer num, Integer num2, Long l2) {
        this.f45179a = bool;
        this.f45180b = d2;
        this.f45181c = num;
        this.f45182d = num2;
        this.f45183e = l2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        return Intrinsics.b(this.f45179a, sessionConfigs.f45179a) && Intrinsics.b(this.f45180b, sessionConfigs.f45180b) && Intrinsics.b(this.f45181c, sessionConfigs.f45181c) && Intrinsics.b(this.f45182d, sessionConfigs.f45182d) && Intrinsics.b(this.f45183e, sessionConfigs.f45183e);
    }

    public final int hashCode() {
        Boolean bool = this.f45179a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d2 = this.f45180b;
        int iHashCode2 = (iHashCode + (d2 == null ? 0 : d2.hashCode())) * 31;
        Integer num = this.f45181c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f45182d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l2 = this.f45183e;
        return iHashCode4 + (l2 != null ? l2.hashCode() : 0);
    }

    public final String toString() {
        return "SessionConfigs(sessionEnabled=" + this.f45179a + ", sessionSamplingRate=" + this.f45180b + ", sessionRestartTimeout=" + this.f45181c + ", cacheDuration=" + this.f45182d + ", cacheUpdatedTime=" + this.f45183e + ')';
    }
}
