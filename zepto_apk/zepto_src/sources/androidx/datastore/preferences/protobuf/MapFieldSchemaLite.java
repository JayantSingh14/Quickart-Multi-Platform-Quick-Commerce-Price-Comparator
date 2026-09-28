package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.MapEntryLite;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes3.dex */
final class MapFieldSchemaLite implements MapFieldSchema {
    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public final MapFieldLite a(Object obj, Object obj2) {
        MapFieldLite mapFieldLiteC = (MapFieldLite) obj;
        MapFieldLite mapFieldLite = (MapFieldLite) obj2;
        if (!mapFieldLite.isEmpty()) {
            if (!mapFieldLiteC.f4077a) {
                mapFieldLiteC = mapFieldLiteC.c();
            }
            mapFieldLiteC.b();
            if (!mapFieldLite.isEmpty()) {
                mapFieldLiteC.putAll(mapFieldLite);
            }
        }
        return mapFieldLiteC;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public final MapEntryLite.Metadata b(Object obj) {
        return ((MapEntryLite) obj).f4071a;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public final MapFieldLite c(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public final MapFieldLite d(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public final Object e(Object obj) {
        ((MapFieldLite) obj).f4077a = false;
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public final MapFieldLite f() {
        return MapFieldLite.f4076b.c();
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public final int g(int i2, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapEntryLite mapEntryLite = (MapEntryLite) obj2;
        int iZ = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            mapEntryLite.getClass();
            int iY = CodedOutputStream.Y(i2);
            int iA = MapEntryLite.a(mapEntryLite.f4071a, key, value);
            iZ += CodedOutputStream.Z(iA) + iA + iY;
        }
        return iZ;
    }

    @Override // androidx.datastore.preferences.protobuf.MapFieldSchema
    public final boolean h(Object obj) {
        return !((MapFieldLite) obj).f4077a;
    }
}
