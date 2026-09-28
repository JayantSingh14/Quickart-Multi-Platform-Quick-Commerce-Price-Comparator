package com.google.firebase.heartbeatinfo;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
final class AutoValue_HeartBeatResult extends HeartBeatResult {

    /* renamed from: a, reason: collision with root package name */
    public final String f44543a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f44544b;

    public AutoValue_HeartBeatResult(String str, ArrayList arrayList) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f44543a = str;
        this.f44544b = arrayList;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final List b() {
        return this.f44544b;
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatResult
    public final String c() {
        return this.f44543a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HeartBeatResult)) {
            return false;
        }
        HeartBeatResult heartBeatResult = (HeartBeatResult) obj;
        return this.f44543a.equals(heartBeatResult.c()) && this.f44544b.equals(heartBeatResult.b());
    }

    public final int hashCode() {
        return ((this.f44543a.hashCode() ^ 1000003) * 1000003) ^ this.f44544b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.f44543a + ", usedDates=" + this.f44544b + "}";
    }
}
