package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class DataCollectionStatus {

    /* renamed from: a, reason: collision with root package name */
    public final DataCollectionState f44984a;

    /* renamed from: b, reason: collision with root package name */
    public final DataCollectionState f44985b;

    /* renamed from: c, reason: collision with root package name */
    public final double f44986c;

    /* JADX WARN: Illegal instructions before constructor call */
    public DataCollectionStatus() {
        DataCollectionState dataCollectionState = DataCollectionState.COLLECTION_SDK_NOT_INSTALLED;
        this(dataCollectionState, dataCollectionState, 1.0d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataCollectionStatus)) {
            return false;
        }
        DataCollectionStatus dataCollectionStatus = (DataCollectionStatus) obj;
        return this.f44984a == dataCollectionStatus.f44984a && this.f44985b == dataCollectionStatus.f44985b && Double.compare(this.f44986c, dataCollectionStatus.f44986c) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.f44986c) + ((this.f44985b.hashCode() + (this.f44984a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "DataCollectionStatus(performance=" + this.f44984a + ", crashlytics=" + this.f44985b + ", sessionSamplingRate=" + this.f44986c + ')';
    }

    public DataCollectionStatus(DataCollectionState performance, DataCollectionState crashlytics, double d2) {
        Intrinsics.checkNotNullParameter(performance, "performance");
        Intrinsics.checkNotNullParameter(crashlytics, "crashlytics");
        this.f44984a = performance;
        this.f44985b = crashlytics;
        this.f44986c = d2;
    }
}
