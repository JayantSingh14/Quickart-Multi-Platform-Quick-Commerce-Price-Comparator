package com.zeptoconsumerapp.performancemode.performanceClasses;

import android.os.SystemClock;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.SourceDebugExtension;
import timber.log.Timber;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class NetworkBandwidthAggregator {

    /* renamed from: a, reason: collision with root package name */
    public static final NetworkBandwidthAggregator f47757a = new NetworkBandwidthAggregator();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f47758b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f47759c;

    /* renamed from: d, reason: collision with root package name */
    public static final Lazy f47760d;

    /* renamed from: e, reason: collision with root package name */
    public static final Lazy f47761e;

    /* renamed from: f, reason: collision with root package name */
    public static double f47762f;

    /* renamed from: g, reason: collision with root package name */
    public static int f47763g;

    /* renamed from: h, reason: collision with root package name */
    public static double f47764h;

    /* renamed from: i, reason: collision with root package name */
    public static long f47765i;

    /* renamed from: j, reason: collision with root package name */
    public static com.zeptoconsumerapp.performancemode.a f47766j;

    @Metadata
    public static final class BandwidthSample {

        /* renamed from: a, reason: collision with root package name */
        public final double f47767a;

        /* renamed from: b, reason: collision with root package name */
        public final long f47768b;

        /* renamed from: c, reason: collision with root package name */
        public final long f47769c;

        public BandwidthSample(double d2, long j2, long j3) {
            this.f47767a = d2;
            this.f47768b = j2;
            this.f47769c = j3;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BandwidthSample)) {
                return false;
            }
            BandwidthSample bandwidthSample = (BandwidthSample) obj;
            return Double.compare(this.f47767a, bandwidthSample.f47767a) == 0 && this.f47768b == bandwidthSample.f47768b && this.f47769c == bandwidthSample.f47769c;
        }

        public final int hashCode() {
            return Long.hashCode(this.f47769c) + android.support.v4.media.a.d(Double.hashCode(this.f47767a) * 31, 31, this.f47768b);
        }

        public final String toString() {
            return "BandwidthSample(bandwidthKbps=" + this.f47767a + ", timestamp=" + this.f47768b + ", duration=" + this.f47769c + ")";
        }
    }

    @Metadata
    public static final class ExponentialGeometricAverage {

        /* renamed from: a, reason: collision with root package name */
        public final double f47770a;

        /* renamed from: b, reason: collision with root package name */
        public double f47771b = -1.0d;

        /* renamed from: c, reason: collision with root package name */
        public final int f47772c;

        /* renamed from: d, reason: collision with root package name */
        public int f47773d;

        public ExponentialGeometricAverage(double d2) {
            this.f47770a = d2;
            this.f47772c = d2 == 0.0d ? Api.BaseClientBuilder.API_PRIORITY_OTHER : (int) Math.ceil(1 / d2);
        }

        public final void a(double d2) {
            double d3 = this.f47770a;
            double d4 = 1 - d3;
            int i2 = this.f47773d;
            if (i2 > this.f47772c) {
                d2 = Math.exp((Math.log(d2) * d3) + (Math.log(this.f47771b) * d4));
            } else if (i2 > 0) {
                double d5 = (d4 * i2) / (i2 + 1.0d);
                d2 = Math.exp((Math.log(d2) * (1.0d - d5)) + (Math.log(this.f47771b) * d5));
            }
            this.f47771b = d2;
            this.f47773d++;
        }
    }

    static {
        final int i2 = 2;
        f47759c = LazyKt.b(new Function0() { // from class: com.zeptoconsumerapp.performancemode.performanceClasses.a
            /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x008c A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:7:0x0027, B:10:0x003c, B:12:0x0049, B:14:0x0054, B:19:0x005e, B:21:0x0066, B:23:0x0071, B:26:0x0079, B:28:0x0081, B:30:0x008c, B:32:0x0092, B:34:0x009a, B:36:0x00a5, B:38:0x00b3), top: B:48:0x0027 }] */
            @Override // kotlin.jvm.functions.Function0
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invoke() throws java.lang.RuntimeException {
                /*
                    r7 = this;
                    int r0 = r1
                    switch(r0) {
                        case 0: goto Ldd;
                        case 1: goto Lc9;
                        default: goto L5;
                    }
                L5:
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator r0 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47757a
                    java.lang.String r0 = com.zeptoconsumerapp.Utils.f47559a
                    java.lang.String r0 = "performance"
                    java.lang.String r1 = "config"
                    java.lang.String r2 = "imgkitConfig"
                    java.lang.String r3 = "decay"
                    com.tencent.mmkv.MMKV r4 = com.zeptoconsumerapp.modules.base.StorageManager.a()
                    com.zeptoconsumerapp.modules.base.StorageKeys[] r5 = com.zeptoconsumerapp.modules.base.StorageKeys.f47625b
                    java.lang.String r5 = ""
                    java.lang.String r6 = "FeaturesConfig"
                    java.lang.String r4 = r4.getString(r6, r5)
                    boolean r5 = r4.isEmpty()
                    if (r5 == 0) goto L27
                    goto Lbf
                L27:
                    com.google.gson.Gson r5 = com.zeptoconsumerapp.Utils.c()     // Catch: java.lang.Throwable -> L59
                    java.lang.Class<com.google.gson.JsonElement> r6 = com.google.gson.JsonElement.class
                    java.lang.Object r4 = r5.d(r6, r4)     // Catch: java.lang.Throwable -> L59
                    com.google.gson.JsonElement r4 = (com.google.gson.JsonElement) r4     // Catch: java.lang.Throwable -> L59
                    r4.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r5 = r4 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r5 != 0) goto L3c
                    goto Lbf
                L3c:
                    com.google.gson.JsonObject r4 = r4.f()     // Catch: java.lang.Throwable -> L59
                    com.google.gson.internal.LinkedTreeMap r5 = r4.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r5 = r5.containsKey(r2)     // Catch: java.lang.Throwable -> L59
                    r6 = 0
                    if (r5 == 0) goto L5b
                    com.google.gson.JsonElement r5 = r4.k(r2)     // Catch: java.lang.Throwable -> L59
                    r5.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r5 = r5 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r5 == 0) goto L5b
                    com.google.gson.JsonObject r2 = r4.m(r2)     // Catch: java.lang.Throwable -> L59
                    goto L5c
                L59:
                    r0 = move-exception
                    goto Lbc
                L5b:
                    r2 = r6
                L5c:
                    if (r2 == 0) goto L76
                    com.google.gson.internal.LinkedTreeMap r4 = r2.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r4 = r4.containsKey(r1)     // Catch: java.lang.Throwable -> L59
                    if (r4 == 0) goto L76
                    com.google.gson.JsonElement r4 = r2.k(r1)     // Catch: java.lang.Throwable -> L59
                    r4.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r4 = r4 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r4 == 0) goto L76
                    com.google.gson.JsonObject r1 = r2.m(r1)     // Catch: java.lang.Throwable -> L59
                    goto L77
                L76:
                    r1 = r6
                L77:
                    if (r1 == 0) goto L90
                    com.google.gson.internal.LinkedTreeMap r2 = r1.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r2 = r2.containsKey(r0)     // Catch: java.lang.Throwable -> L59
                    if (r2 == 0) goto L90
                    com.google.gson.JsonElement r2 = r1.k(r0)     // Catch: java.lang.Throwable -> L59
                    r2.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r2 = r2 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r2 == 0) goto L90
                    com.google.gson.JsonObject r6 = r1.m(r0)     // Catch: java.lang.Throwable -> L59
                L90:
                    if (r6 == 0) goto Lbf
                    com.google.gson.internal.LinkedTreeMap r0 = r6.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r0 = r0.containsKey(r3)     // Catch: java.lang.Throwable -> L59
                    if (r0 == 0) goto Lbf
                    com.google.gson.JsonElement r0 = r6.k(r3)     // Catch: java.lang.Throwable -> L59
                    r0.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r0 = r0 instanceof com.google.gson.JsonPrimitive     // Catch: java.lang.Throwable -> L59
                    if (r0 == 0) goto Lbf
                    com.google.gson.JsonElement r0 = r6.k(r3)     // Catch: java.lang.Throwable -> L59
                    com.google.gson.JsonPrimitive r0 = r0.g()     // Catch: java.lang.Throwable -> L59
                    java.io.Serializable r0 = r0.f45257a     // Catch: java.lang.Throwable -> L59
                    boolean r0 = r0 instanceof java.lang.Number     // Catch: java.lang.Throwable -> L59
                    if (r0 == 0) goto Lbf
                    com.google.gson.JsonElement r0 = r6.k(r3)     // Catch: java.lang.Throwable -> L59
                    double r0 = r0.b()     // Catch: java.lang.Throwable -> L59
                    goto Lc4
                Lbc:
                    r0.printStackTrace()
                Lbf:
                    r0 = 4599075939470750515(0x3fd3333333333333, double:0.3)
                Lc4:
                    java.lang.Double r0 = java.lang.Double.valueOf(r0)
                    return r0
                Lc9:
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage r0 = new com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47757a
                    kotlin.Lazy r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47759c
                    java.lang.Object r1 = r1.getValue()
                    java.lang.Number r1 = (java.lang.Number) r1
                    double r1 = r1.doubleValue()
                    r0.<init>(r1)
                    return r0
                Ldd:
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage r0 = new com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47757a
                    kotlin.Lazy r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47759c
                    java.lang.Object r1 = r1.getValue()
                    java.lang.Number r1 = (java.lang.Number) r1
                    double r1 = r1.doubleValue()
                    r0.<init>(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.performancemode.performanceClasses.a.invoke():java.lang.Object");
            }
        });
        final int i3 = 0;
        f47760d = LazyKt.b(new Function0() { // from class: com.zeptoconsumerapp.performancemode.performanceClasses.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws RuntimeException {
                /*
                    this = this;
                    int r0 = r1
                    switch(r0) {
                        case 0: goto Ldd;
                        case 1: goto Lc9;
                        default: goto L5;
                    }
                L5:
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator r0 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47757a
                    java.lang.String r0 = com.zeptoconsumerapp.Utils.f47559a
                    java.lang.String r0 = "performance"
                    java.lang.String r1 = "config"
                    java.lang.String r2 = "imgkitConfig"
                    java.lang.String r3 = "decay"
                    com.tencent.mmkv.MMKV r4 = com.zeptoconsumerapp.modules.base.StorageManager.a()
                    com.zeptoconsumerapp.modules.base.StorageKeys[] r5 = com.zeptoconsumerapp.modules.base.StorageKeys.f47625b
                    java.lang.String r5 = ""
                    java.lang.String r6 = "FeaturesConfig"
                    java.lang.String r4 = r4.getString(r6, r5)
                    boolean r5 = r4.isEmpty()
                    if (r5 == 0) goto L27
                    goto Lbf
                L27:
                    com.google.gson.Gson r5 = com.zeptoconsumerapp.Utils.c()     // Catch: java.lang.Throwable -> L59
                    java.lang.Class<com.google.gson.JsonElement> r6 = com.google.gson.JsonElement.class
                    java.lang.Object r4 = r5.d(r6, r4)     // Catch: java.lang.Throwable -> L59
                    com.google.gson.JsonElement r4 = (com.google.gson.JsonElement) r4     // Catch: java.lang.Throwable -> L59
                    r4.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r5 = r4 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r5 != 0) goto L3c
                    goto Lbf
                L3c:
                    com.google.gson.JsonObject r4 = r4.f()     // Catch: java.lang.Throwable -> L59
                    com.google.gson.internal.LinkedTreeMap r5 = r4.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r5 = r5.containsKey(r2)     // Catch: java.lang.Throwable -> L59
                    r6 = 0
                    if (r5 == 0) goto L5b
                    com.google.gson.JsonElement r5 = r4.k(r2)     // Catch: java.lang.Throwable -> L59
                    r5.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r5 = r5 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r5 == 0) goto L5b
                    com.google.gson.JsonObject r2 = r4.m(r2)     // Catch: java.lang.Throwable -> L59
                    goto L5c
                L59:
                    r0 = move-exception
                    goto Lbc
                L5b:
                    r2 = r6
                L5c:
                    if (r2 == 0) goto L76
                    com.google.gson.internal.LinkedTreeMap r4 = r2.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r4 = r4.containsKey(r1)     // Catch: java.lang.Throwable -> L59
                    if (r4 == 0) goto L76
                    com.google.gson.JsonElement r4 = r2.k(r1)     // Catch: java.lang.Throwable -> L59
                    r4.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r4 = r4 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r4 == 0) goto L76
                    com.google.gson.JsonObject r1 = r2.m(r1)     // Catch: java.lang.Throwable -> L59
                    goto L77
                L76:
                    r1 = r6
                L77:
                    if (r1 == 0) goto L90
                    com.google.gson.internal.LinkedTreeMap r2 = r1.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r2 = r2.containsKey(r0)     // Catch: java.lang.Throwable -> L59
                    if (r2 == 0) goto L90
                    com.google.gson.JsonElement r2 = r1.k(r0)     // Catch: java.lang.Throwable -> L59
                    r2.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r2 = r2 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r2 == 0) goto L90
                    com.google.gson.JsonObject r6 = r1.m(r0)     // Catch: java.lang.Throwable -> L59
                L90:
                    if (r6 == 0) goto Lbf
                    com.google.gson.internal.LinkedTreeMap r0 = r6.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r0 = r0.containsKey(r3)     // Catch: java.lang.Throwable -> L59
                    if (r0 == 0) goto Lbf
                    com.google.gson.JsonElement r0 = r6.k(r3)     // Catch: java.lang.Throwable -> L59
                    r0.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r0 = r0 instanceof com.google.gson.JsonPrimitive     // Catch: java.lang.Throwable -> L59
                    if (r0 == 0) goto Lbf
                    com.google.gson.JsonElement r0 = r6.k(r3)     // Catch: java.lang.Throwable -> L59
                    com.google.gson.JsonPrimitive r0 = r0.g()     // Catch: java.lang.Throwable -> L59
                    java.io.Serializable r0 = r0.f45257a     // Catch: java.lang.Throwable -> L59
                    boolean r0 = r0 instanceof java.lang.Number     // Catch: java.lang.Throwable -> L59
                    if (r0 == 0) goto Lbf
                    com.google.gson.JsonElement r0 = r6.k(r3)     // Catch: java.lang.Throwable -> L59
                    double r0 = r0.b()     // Catch: java.lang.Throwable -> L59
                    goto Lc4
                Lbc:
                    r0.printStackTrace()
                Lbf:
                    r0 = 4599075939470750515(0x3fd3333333333333, double:0.3)
                Lc4:
                    java.lang.Double r0 = java.lang.Double.valueOf(r0)
                    return r0
                Lc9:
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage r0 = new com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47757a
                    kotlin.Lazy r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47759c
                    java.lang.Object r1 = r1.getValue()
                    java.lang.Number r1 = (java.lang.Number) r1
                    double r1 = r1.doubleValue()
                    r0.<init>(r1)
                    return r0
                Ldd:
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage r0 = new com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47757a
                    kotlin.Lazy r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47759c
                    java.lang.Object r1 = r1.getValue()
                    java.lang.Number r1 = (java.lang.Number) r1
                    double r1 = r1.doubleValue()
                    r0.<init>(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.performancemode.performanceClasses.a.invoke():java.lang.Object");
            }
        });
        final int i4 = 1;
        f47761e = LazyKt.b(new Function0() { // from class: com.zeptoconsumerapp.performancemode.performanceClasses.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() throws RuntimeException {
                /*
                    this = this;
                    int r0 = r1
                    switch(r0) {
                        case 0: goto Ldd;
                        case 1: goto Lc9;
                        default: goto L5;
                    }
                L5:
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator r0 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47757a
                    java.lang.String r0 = com.zeptoconsumerapp.Utils.f47559a
                    java.lang.String r0 = "performance"
                    java.lang.String r1 = "config"
                    java.lang.String r2 = "imgkitConfig"
                    java.lang.String r3 = "decay"
                    com.tencent.mmkv.MMKV r4 = com.zeptoconsumerapp.modules.base.StorageManager.a()
                    com.zeptoconsumerapp.modules.base.StorageKeys[] r5 = com.zeptoconsumerapp.modules.base.StorageKeys.f47625b
                    java.lang.String r5 = ""
                    java.lang.String r6 = "FeaturesConfig"
                    java.lang.String r4 = r4.getString(r6, r5)
                    boolean r5 = r4.isEmpty()
                    if (r5 == 0) goto L27
                    goto Lbf
                L27:
                    com.google.gson.Gson r5 = com.zeptoconsumerapp.Utils.c()     // Catch: java.lang.Throwable -> L59
                    java.lang.Class<com.google.gson.JsonElement> r6 = com.google.gson.JsonElement.class
                    java.lang.Object r4 = r5.d(r6, r4)     // Catch: java.lang.Throwable -> L59
                    com.google.gson.JsonElement r4 = (com.google.gson.JsonElement) r4     // Catch: java.lang.Throwable -> L59
                    r4.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r5 = r4 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r5 != 0) goto L3c
                    goto Lbf
                L3c:
                    com.google.gson.JsonObject r4 = r4.f()     // Catch: java.lang.Throwable -> L59
                    com.google.gson.internal.LinkedTreeMap r5 = r4.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r5 = r5.containsKey(r2)     // Catch: java.lang.Throwable -> L59
                    r6 = 0
                    if (r5 == 0) goto L5b
                    com.google.gson.JsonElement r5 = r4.k(r2)     // Catch: java.lang.Throwable -> L59
                    r5.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r5 = r5 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r5 == 0) goto L5b
                    com.google.gson.JsonObject r2 = r4.m(r2)     // Catch: java.lang.Throwable -> L59
                    goto L5c
                L59:
                    r0 = move-exception
                    goto Lbc
                L5b:
                    r2 = r6
                L5c:
                    if (r2 == 0) goto L76
                    com.google.gson.internal.LinkedTreeMap r4 = r2.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r4 = r4.containsKey(r1)     // Catch: java.lang.Throwable -> L59
                    if (r4 == 0) goto L76
                    com.google.gson.JsonElement r4 = r2.k(r1)     // Catch: java.lang.Throwable -> L59
                    r4.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r4 = r4 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r4 == 0) goto L76
                    com.google.gson.JsonObject r1 = r2.m(r1)     // Catch: java.lang.Throwable -> L59
                    goto L77
                L76:
                    r1 = r6
                L77:
                    if (r1 == 0) goto L90
                    com.google.gson.internal.LinkedTreeMap r2 = r1.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r2 = r2.containsKey(r0)     // Catch: java.lang.Throwable -> L59
                    if (r2 == 0) goto L90
                    com.google.gson.JsonElement r2 = r1.k(r0)     // Catch: java.lang.Throwable -> L59
                    r2.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r2 = r2 instanceof com.google.gson.JsonObject     // Catch: java.lang.Throwable -> L59
                    if (r2 == 0) goto L90
                    com.google.gson.JsonObject r6 = r1.m(r0)     // Catch: java.lang.Throwable -> L59
                L90:
                    if (r6 == 0) goto Lbf
                    com.google.gson.internal.LinkedTreeMap r0 = r6.f45256a     // Catch: java.lang.Throwable -> L59
                    boolean r0 = r0.containsKey(r3)     // Catch: java.lang.Throwable -> L59
                    if (r0 == 0) goto Lbf
                    com.google.gson.JsonElement r0 = r6.k(r3)     // Catch: java.lang.Throwable -> L59
                    r0.getClass()     // Catch: java.lang.Throwable -> L59
                    boolean r0 = r0 instanceof com.google.gson.JsonPrimitive     // Catch: java.lang.Throwable -> L59
                    if (r0 == 0) goto Lbf
                    com.google.gson.JsonElement r0 = r6.k(r3)     // Catch: java.lang.Throwable -> L59
                    com.google.gson.JsonPrimitive r0 = r0.g()     // Catch: java.lang.Throwable -> L59
                    java.io.Serializable r0 = r0.f45257a     // Catch: java.lang.Throwable -> L59
                    boolean r0 = r0 instanceof java.lang.Number     // Catch: java.lang.Throwable -> L59
                    if (r0 == 0) goto Lbf
                    com.google.gson.JsonElement r0 = r6.k(r3)     // Catch: java.lang.Throwable -> L59
                    double r0 = r0.b()     // Catch: java.lang.Throwable -> L59
                    goto Lc4
                Lbc:
                    r0.printStackTrace()
                Lbf:
                    r0 = 4599075939470750515(0x3fd3333333333333, double:0.3)
                Lc4:
                    java.lang.Double r0 = java.lang.Double.valueOf(r0)
                    return r0
                Lc9:
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage r0 = new com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47757a
                    kotlin.Lazy r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47759c
                    java.lang.Object r1 = r1.getValue()
                    java.lang.Number r1 = (java.lang.Number) r1
                    double r1 = r1.doubleValue()
                    r0.<init>(r1)
                    return r0
                Ldd:
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage r0 = new com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator$ExponentialGeometricAverage
                    com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47757a
                    kotlin.Lazy r1 = com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator.f47759c
                    java.lang.Object r1 = r1.getValue()
                    java.lang.Number r1 = (java.lang.Number) r1
                    double r1 = r1.doubleValue()
                    r0.<init>(r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.performancemode.performanceClasses.a.invoke():java.lang.Object");
            }
        });
        SystemClock.elapsedRealtime();
        f47765i = SystemClock.elapsedRealtime();
    }

    public static int b(long j2) {
        long j3 = j2 - 300000;
        if (f47765i >= j3) {
            return 0;
        }
        ArrayList arrayList = f47758b;
        Iterator it = arrayList.iterator();
        double d2 = 0.0d;
        int i2 = 0;
        while (it.hasNext()) {
            BandwidthSample bandwidthSample = (BandwidthSample) it.next();
            if (bandwidthSample.f47768b < j3) {
                it.remove();
                d2 += bandwidthSample.f47767a;
                i2++;
            }
        }
        if (i2 > 0) {
            Lazy lazy = f47761e;
            ExponentialGeometricAverage exponentialGeometricAverage = (ExponentialGeometricAverage) lazy.getValue();
            exponentialGeometricAverage.f47771b = -1.0d;
            exponentialGeometricAverage.f47773d = 0;
            f47764h -= d2;
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((ExponentialGeometricAverage) lazy.getValue()).a(((BandwidthSample) it2.next()).f47767a);
            }
        }
        f47765i = j2;
        return i2;
    }

    public final synchronized void a(double d2, long j2) {
        if (d2 < 1.0d) {
            return;
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        BandwidthSample bandwidthSample = new BandwidthSample(d2, jElapsedRealtime, j2);
        int iB = b(jElapsedRealtime);
        ArrayList arrayList = f47758b;
        arrayList.add(bandwidthSample);
        ((ExponentialGeometricAverage) f47760d.getValue()).a(d2);
        ((ExponentialGeometricAverage) f47761e.getValue()).a(d2);
        f47762f += d2;
        f47763g++;
        f47764h += d2;
        BandwidthAverages bandwidthAveragesC = c();
        Timber.d("PSP").d("Added sample: %.2f kbps, exp cumulative: %.2f kbps, exp recent: %.2f kbps, arith cumulative: %.2f kbps, arith recent: %.2f kbps, sample count: %d, removed: %d", Double.valueOf(d2), Double.valueOf(bandwidthAveragesC.f47749a), Double.valueOf(bandwidthAveragesC.f47750b), Double.valueOf(bandwidthAveragesC.f47751c), Double.valueOf(bandwidthAveragesC.f47752d), Integer.valueOf(arrayList.size()), Integer.valueOf(iB));
        com.zeptoconsumerapp.performancemode.a aVar = f47766j;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    public final synchronized BandwidthAverages c() {
        double d2;
        ArrayList arrayList;
        double d3;
        int i2;
        try {
            d2 = ((ExponentialGeometricAverage) f47760d.getValue()).f47771b;
            arrayList = f47758b;
            d3 = arrayList.size() >= 3 ? ((ExponentialGeometricAverage) f47761e.getValue()).f47771b : -1.0d;
            i2 = f47763g;
        } catch (Throwable th) {
            throw th;
        }
        return new BandwidthAverages(d2, d3, i2 > 0 ? f47762f / i2 : -1.0d, arrayList.size() >= 3 ? f47764h / arrayList.size() : -1.0d);
    }
}
