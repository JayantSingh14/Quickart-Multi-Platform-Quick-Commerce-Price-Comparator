package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzs extends zzbl {
    private final double end;
    private final boolean played;
    private final double start;

    public zzs(double d2, double d3, boolean z) {
        this.start = d2;
        this.end = d3;
        this.played = z;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbl
    public double end() {
        return this.end;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbl) {
            zzbl zzblVar = (zzbl) obj;
            if (Double.doubleToLongBits(this.start) == Double.doubleToLongBits(zzblVar.start()) && Double.doubleToLongBits(this.end) == Double.doubleToLongBits(zzblVar.end()) && this.played == zzblVar.played()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((int) ((Double.doubleToLongBits(this.start) >>> 32) ^ Double.doubleToLongBits(this.start))) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.end) >>> 32) ^ Double.doubleToLongBits(this.end)))) * 1000003) ^ (true != this.played ? 1237 : 1231);
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbl
    public boolean played() {
        return this.played;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbl
    public double start() {
        return this.start;
    }

    public String toString() {
        return "CuePointData{start=" + this.start + ", end=" + this.end + ", played=" + this.played + "}";
    }
}
