package com.google.ads.interactivemedia.v3.impl.data;

/* loaded from: classes3.dex */
final class zzt implements zzbm {
    private String androidVersion;
    private String manufacturer;
    private String model;
    private int requestCounter;
    private String sdkVersion;
    private byte set$0;

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbm
    public zzbm androidVersion(String str) {
        if (str == null) {
            throw new NullPointerException("Null androidVersion");
        }
        this.androidVersion = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbm
    public zzbn build() {
        String str;
        String str2;
        String str3;
        String str4;
        if (this.set$0 == 1 && (str = this.model) != null && (str2 = this.manufacturer) != null && (str3 = this.sdkVersion) != null && (str4 = this.androidVersion) != null) {
            return new zzv(str, str2, str3, str4, this.requestCounter);
        }
        StringBuilder sb = new StringBuilder();
        if (this.model == null) {
            sb.append(" model");
        }
        if (this.manufacturer == null) {
            sb.append(" manufacturer");
        }
        if (this.sdkVersion == null) {
            sb.append(" sdkVersion");
        }
        if (this.androidVersion == null) {
            sb.append(" androidVersion");
        }
        if ((1 & this.set$0) == 0) {
            sb.append(" requestCounter");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbm
    public zzbm manufacturer(String str) {
        if (str == null) {
            throw new NullPointerException("Null manufacturer");
        }
        this.manufacturer = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbm
    public zzbm model(String str) {
        if (str == null) {
            throw new NullPointerException("Null model");
        }
        this.model = str;
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbm
    public zzbm requestCounter(int i2) {
        this.requestCounter = i2;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    @Override // com.google.ads.interactivemedia.v3.impl.data.zzbm
    public zzbm sdkVersion(String str) {
        if (str == null) {
            throw new NullPointerException("Null sdkVersion");
        }
        this.sdkVersion = str;
        return this;
    }
}
