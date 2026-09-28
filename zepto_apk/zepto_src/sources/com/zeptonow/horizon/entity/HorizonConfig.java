package com.zeptonow.horizon.entity;

import android.support.v4.media.a;
import androidx.fragment.app.e;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.EnumSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata
@Serializable
/* loaded from: classes.dex */
public final class HorizonConfig {

    @NotNull
    public static final Companion Companion = new Companion();

    /* renamed from: k, reason: collision with root package name */
    public static final KSerializer[] f48080k;

    /* renamed from: a, reason: collision with root package name */
    public final int f48081a;

    /* renamed from: b, reason: collision with root package name */
    public final int f48082b;

    /* renamed from: c, reason: collision with root package name */
    public final int f48083c;

    /* renamed from: d, reason: collision with root package name */
    public final long f48084d;

    /* renamed from: e, reason: collision with root package name */
    public final long f48085e;

    /* renamed from: f, reason: collision with root package name */
    public final int f48086f;

    /* renamed from: g, reason: collision with root package name */
    public final String f48087g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f48088h;

    /* renamed from: i, reason: collision with root package name */
    public final Map f48089i;

    /* renamed from: j, reason: collision with root package name */
    public final Map f48090j;

    @Metadata
    public static final class Companion {
        @NotNull
        public final KSerializer<HorizonConfig> serializer() {
            return HorizonConfig$$serializer.f48091a;
        }
    }

    static {
        EventType[] values = EventType.values();
        Intrinsics.checkNotNullParameter("com.zeptonow.horizon.entity.EventType", "serialName");
        Intrinsics.checkNotNullParameter(values, "values");
        LinkedHashMapSerializer linkedHashMapSerializer = new LinkedHashMapSerializer(new EnumSerializer("com.zeptonow.horizon.entity.EventType", values), EventNetworkConfig$$serializer.f48069a);
        StringSerializer stringSerializer = StringSerializer.f55902a;
        f48080k = new KSerializer[]{null, null, null, null, null, null, null, null, linkedHashMapSerializer, new LinkedHashMapSerializer(stringSerializer, new ArrayListSerializer(stringSerializer))};
    }

    public HorizonConfig(int i2, int i3, int i4, int i5, long j2, long j3, int i6, String str, boolean z, Map map, Map map2) {
        if (255 != (i2 & 255)) {
            PluginExceptionsKt.a(i2, 255, HorizonConfig$$serializer.f48092b);
            throw null;
        }
        this.f48081a = i3;
        this.f48082b = i4;
        this.f48083c = i5;
        this.f48084d = j2;
        this.f48085e = j3;
        this.f48086f = i6;
        this.f48087g = str;
        this.f48088h = z;
        if ((i2 & 256) == 0) {
            this.f48089i = new LinkedHashMap();
        } else {
            this.f48089i = map;
        }
        if ((i2 & 512) == 0) {
            this.f48090j = new LinkedHashMap();
        } else {
            this.f48090j = map2;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HorizonConfig)) {
            return false;
        }
        HorizonConfig horizonConfig = (HorizonConfig) obj;
        return this.f48081a == horizonConfig.f48081a && this.f48082b == horizonConfig.f48082b && this.f48083c == horizonConfig.f48083c && this.f48084d == horizonConfig.f48084d && this.f48085e == horizonConfig.f48085e && this.f48086f == horizonConfig.f48086f && Intrinsics.b(this.f48087g, horizonConfig.f48087g) && this.f48088h == horizonConfig.f48088h && Intrinsics.b(this.f48089i, horizonConfig.f48089i) && Intrinsics.b(this.f48090j, horizonConfig.f48090j);
    }

    public final int hashCode() {
        return this.f48090j.hashCode() + ((this.f48089i.hashCode() + ((Boolean.hashCode(this.f48088h) + e.e(a.b(this.f48086f, a.d(a.d(a.b(this.f48083c, a.b(this.f48082b, Integer.hashCode(this.f48081a) * 31, 31), 31), 31, this.f48084d), 31, this.f48085e), 31), 31, this.f48087g)) * 31)) * 31);
    }

    public final String toString() {
        return "HorizonConfig(maxParallelRequests=" + this.f48081a + ", batchSize=" + this.f48082b + ", maxBatchSize=" + this.f48083c + ", batchIntervalInMs=" + this.f48084d + ", retryIntervalInMs=" + this.f48085e + ", retryCount=" + this.f48086f + ", defaultUrl=" + this.f48087g + ", compressionEnabled=" + this.f48088h + ", eventNetworkConfigs=" + this.f48089i + ", blackListedEventPropertiesMap=" + this.f48090j + ')';
    }
}
