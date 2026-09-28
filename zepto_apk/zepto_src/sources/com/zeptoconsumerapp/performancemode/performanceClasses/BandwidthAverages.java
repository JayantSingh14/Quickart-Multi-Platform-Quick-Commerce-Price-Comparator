package com.zeptoconsumerapp.performancemode.performanceClasses;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class BandwidthAverages {

    /* renamed from: a, reason: collision with root package name */
    public final double f47749a;

    /* renamed from: b, reason: collision with root package name */
    public final double f47750b;

    /* renamed from: c, reason: collision with root package name */
    public final double f47751c;

    /* renamed from: d, reason: collision with root package name */
    public final double f47752d;

    public BandwidthAverages(double d2, double d3, double d4, double d5) {
        this.f47749a = d2;
        this.f47750b = d3;
        this.f47751c = d4;
        this.f47752d = d5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BandwidthAverages)) {
            return false;
        }
        BandwidthAverages bandwidthAverages = (BandwidthAverages) obj;
        return Double.compare(this.f47749a, bandwidthAverages.f47749a) == 0 && Double.compare(this.f47750b, bandwidthAverages.f47750b) == 0 && Double.compare(this.f47751c, bandwidthAverages.f47751c) == 0 && Double.compare(this.f47752d, bandwidthAverages.f47752d) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.f47752d) + ((Double.hashCode(this.f47751c) + ((Double.hashCode(this.f47750b) + (Double.hashCode(this.f47749a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "BandwidthAverages(cumulativeExponential=" + this.f47749a + ", recentExponential=" + this.f47750b + ", cumulativeArithmetic=" + this.f47751c + ", recentArithmetic=" + this.f47752d + ")";
    }
}
