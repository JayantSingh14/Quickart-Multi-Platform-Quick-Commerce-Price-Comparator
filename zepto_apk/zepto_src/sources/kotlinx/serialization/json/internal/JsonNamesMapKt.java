package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonNames;
import kotlinx.serialization.json.JsonNamingStrategy;
import kotlinx.serialization.json.JsonSchemaCacheKt;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class JsonNamesMapKt {

    /* renamed from: a, reason: collision with root package name */
    public static final DescriptorSchemaCache.Key f56045a = new DescriptorSchemaCache.Key();

    static {
        new DescriptorSchemaCache.Key();
    }

    public static final Map a(final SerialDescriptor descriptor, final Json json) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        DescriptorSchemaCache descriptorSchemaCacheA = JsonSchemaCacheKt.a(json);
        Function0<Map<String, ? extends Integer>> defaultValue = new Function0<Map<String, ? extends Integer>>() { // from class: kotlinx.serialization.json.internal.JsonNamesMapKt$deserializationNamesMap$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                DescriptorSchemaCache.Key key = JsonNamesMapKt.f56045a;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Json json2 = json;
                JsonConfiguration jsonConfiguration = json2.f55945a;
                SerialDescriptor serialDescriptor = descriptor;
                JsonNamesMapKt.e(serialDescriptor, json2);
                int iE = serialDescriptor.e();
                for (int i2 = 0; i2 < iE; i2++) {
                    List listG = serialDescriptor.g(i2);
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listG) {
                        if (obj instanceof JsonNames) {
                            arrayList.add(obj);
                        }
                    }
                }
                return linkedHashMap.isEmpty() ? MapsKt.c() : linkedHashMap;
            }
        };
        DescriptorSchemaCache.Key key = f56045a;
        descriptorSchemaCacheA.getClass();
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        Object value = descriptorSchemaCacheA.a(descriptor, key);
        if (value == null) {
            value = defaultValue.invoke();
            Intrinsics.checkNotNullParameter(descriptor, "descriptor");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            ConcurrentHashMap concurrentHashMap = descriptorSchemaCacheA.f56038a;
            Object concurrentHashMap2 = concurrentHashMap.get(descriptor);
            if (concurrentHashMap2 == null) {
                concurrentHashMap2 = new ConcurrentHashMap(2);
                concurrentHashMap.put(descriptor, concurrentHashMap2);
            }
            ((Map) concurrentHashMap2).put(key, value);
        }
        return (Map) value;
    }

    public static final String b(SerialDescriptor serialDescriptor, Json json, int i2) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        e(serialDescriptor, json);
        return serialDescriptor.f(i2);
    }

    public static final int c(SerialDescriptor serialDescriptor, Json json, String name) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        JsonConfiguration jsonConfiguration = json.f55945a;
        e(serialDescriptor, json);
        int iC = serialDescriptor.c(name);
        if (iC != -3 || !json.f55945a.f55975j) {
            return iC;
        }
        Integer num = (Integer) a(serialDescriptor, json).get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final int d(SerialDescriptor serialDescriptor, Json json, String name, String suffix) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        int iC = c(serialDescriptor, json, name);
        if (iC != -3) {
            return iC;
        }
        throw new SerializationException(serialDescriptor.i() + " does not contain element with name '" + name + '\'' + suffix);
    }

    public static final JsonNamingStrategy e(SerialDescriptor serialDescriptor, Json json) {
        Intrinsics.checkNotNullParameter(serialDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (Intrinsics.b(serialDescriptor.d(), StructureKind.CLASS.f55765a)) {
            JsonConfiguration jsonConfiguration = json.f55945a;
        }
        return null;
    }
}
