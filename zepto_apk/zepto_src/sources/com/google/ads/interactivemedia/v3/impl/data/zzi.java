package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzi implements zza {
    private String appState;
    private String eventId;
    private long nativeTime;
    private zzbh nativeViewBounds;
    private boolean nativeViewHidden;
    private zzbh nativeViewVisibleBounds;
    private double nativeVolume;
    private String queryId;
    private byte set$0;

    @Override // com.google.ads.interactivemedia.v3.impl.data.zza
    public zza appState(String str) {
        if (str == null) {
            throw new NullPointerException("Null appState");
        }
        this.appState = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zza
    public zzb build() {
        String str;
        String str2;
        String str3;
        zzbh zzbhVar;
        zzbh zzbhVar2;
        if (this.set$0 == 7 && (str = this.queryId) != null && (str2 = this.eventId) != null && (str3 = this.appState) != null && (zzbhVar = this.nativeViewBounds) != null && (zzbhVar2 = this.nativeViewVisibleBounds) != null) {
            return new zzk(str, str2, str3, this.nativeTime, this.nativeVolume, this.nativeViewHidden, zzbhVar, zzbhVar2);
        }
        StringBuilder sb = new StringBuilder();
        if (this.queryId == null) {
            sb.append(" queryId");
        }
        if (this.eventId == null) {
            sb.append(" eventId");
        }
        if (this.appState == null) {
            sb.append(" appState");
        }
        if ((this.set$0 & 1) == 0) {
            sb.append(" nativeTime");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" nativeVolume");
        }
        if ((this.set$0 & 4) == 0) {
            sb.append(" nativeViewHidden");
        }
        if (this.nativeViewBounds == null) {
            sb.append(" nativeViewBounds");
        }
        if (this.nativeViewVisibleBounds == null) {
            sb.append(" nativeViewVisibleBounds");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zza
    public zza eventId(String str) {
        if (str == null) {
            throw new NullPointerException("Null eventId");
        }
        this.eventId = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zza
    public zza nativeTime(long j2) {
        this.nativeTime = j2;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zza
    public zza nativeViewBounds(zzbh zzbhVar) {
        if (zzbhVar == null) {
            throw new NullPointerException("Null nativeViewBounds");
        }
        this.nativeViewBounds = zzbhVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zza
    public zza nativeViewHidden(boolean z) {
        this.nativeViewHidden = z;
        this.set$0 = (byte) (this.set$0 | 4);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zza
    public zza nativeViewVisibleBounds(zzbh zzbhVar) {
        if (zzbhVar == null) {
            throw new NullPointerException("Null nativeViewVisibleBounds");
        }
        this.nativeViewVisibleBounds = zzbhVar;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zza
    public zza nativeVolume(double d2) {
        this.nativeVolume = d2;
        this.set$0 = (byte) (this.set$0 | 2);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zza
    public zza queryId(String str) {
        if (str == null) {
            throw new NullPointerException("Null queryId");
        }
        this.queryId = str;
        return this;
    }
}
