package com.zeptoconsumerapp.modules.configservice;

import coil3.d;
import com.google.gson.Gson;
import com.phoenix.Phoenix;
import com.zeptoconsumerapp.modules.configservice.entity.ConfigResponse;
import com.zeptoconsumerapp.modules.configservice.entity.FeatureConfig;
import com.zeptoconsumerapp.modules.configservice.entity.ResolvedConfig;
import com.zeptoconsumerapp.modules.configservice.entity.ResolvedConfigData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class ConfigService {

    /* renamed from: a, reason: collision with root package name */
    public final Lazy f47630a = LazyKt.b(new d(11));

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f47631b = LazyKt.b(new d(12));

    /* renamed from: c, reason: collision with root package name */
    public final Lazy f47632c = LazyKt.b(new Function0() { // from class: com.zeptoconsumerapp.modules.configservice.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int iA;
            ConfigService configService = this.f47643a;
            try {
                iA = ((PhoenixManifest) configService.a().d(PhoenixManifest.class, Phoenix.Companion.f())).a();
            } catch (Throwable th) {
                th.printStackTrace();
                iA = 0;
            }
            return Integer.valueOf(iA);
        }
    });

    /* renamed from: d, reason: collision with root package name */
    public final Lazy f47633d = LazyKt.b(new d(13));

    /* renamed from: e, reason: collision with root package name */
    public final Lazy f47634e = LazyKt.b(new d(14));

    /* renamed from: f, reason: collision with root package name */
    public final Lazy f47635f = LazyKt.b(new d(15));

    @Metadata
    public static final class Companion {
    }

    public final Gson a() {
        Object value = this.f47630a.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (Gson) value;
    }

    public final ResolvedConfigData b(ConfigResponse configResponse) {
        Intrinsics.checkNotNullParameter(configResponse, "configResponse");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map mapA = configResponse.a().a();
        for (String str : mapA.keySet()) {
            FeatureConfig featureConfig = (FeatureConfig) mapA.get(str);
            String currentAppVersion = (String) this.f47631b.getValue();
            int iIntValue = ((Number) this.f47632c.getValue()).intValue();
            int iIntValue2 = ((Number) this.f47633d.getValue()).intValue();
            Intrinsics.checkNotNullParameter(currentAppVersion, "currentAppVersion");
            Object resolvedConfig = null;
            if (featureConfig != null) {
                Ref.BooleanRef booleanRef = new Ref.BooleanRef();
                boolean zB = featureConfig.b();
                booleanRef.f53798a = zB;
                boolean z = false;
                if (!zB || iIntValue2 > featureConfig.d()) {
                    resolvedConfig = new ResolvedConfig(false, featureConfig.a());
                } else {
                    Map mapC = featureConfig.c();
                    if (mapC != null) {
                        Integer num = (Integer) mapC.get(currentAppVersion);
                        SemVer semVer = new SemVer(currentAppVersion);
                        if (num == null || num.intValue() <= iIntValue) {
                            ArrayList arrayList = new ArrayList(mapC.size());
                            for (Map.Entry entry : mapC.entrySet()) {
                                arrayList.add(new Pair(new SemVer((String) entry.getKey()), entry.getValue()));
                            }
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                Object next = it.next();
                                if (((Number) ((Pair) next).f53534b).intValue() == 0) {
                                    arrayList2.add(next);
                                }
                            }
                            ArrayList arrayList3 = new ArrayList(CollectionsKt.r(arrayList2, 10));
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                arrayList3.add((SemVer) ((Pair) it2.next()).f53533a);
                            }
                            Iterator it3 = arrayList3.iterator();
                            while (true) {
                                if (!it3.hasNext()) {
                                    break;
                                }
                                Object next2 = it3.next();
                                if (((SemVer) next2).compareTo(semVer) <= 0) {
                                    resolvedConfig = next2;
                                    break;
                                }
                            }
                            if (((SemVer) resolvedConfig) != null) {
                                z = true;
                            }
                        }
                        booleanRef.f53798a = z;
                    }
                    resolvedConfig = new ResolvedConfig(booleanRef.f53798a, featureConfig.a());
                }
            }
            linkedHashMap.put(str, resolvedConfig);
        }
        return new ResolvedConfigData(configResponse.a().b(), linkedHashMap);
    }
}
