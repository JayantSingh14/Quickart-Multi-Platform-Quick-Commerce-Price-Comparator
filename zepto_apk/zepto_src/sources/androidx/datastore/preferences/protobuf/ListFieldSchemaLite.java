package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.UnsafeUtil;

/* loaded from: classes3.dex */
final class ListFieldSchemaLite implements ListFieldSchema {
    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public final void a(Object obj, long j2, Object obj2) {
        UnsafeUtil.MemoryAccessor memoryAccessor = UnsafeUtil.f4183c;
        Internal.ProtobufList protobufListA = (Internal.ProtobufList) memoryAccessor.m(j2, obj);
        Internal.ProtobufList protobufList = (Internal.ProtobufList) memoryAccessor.m(j2, obj2);
        int size = protobufListA.size();
        int size2 = protobufList.size();
        if (size > 0 && size2 > 0) {
            if (!protobufListA.r0()) {
                protobufListA = protobufListA.a(size2 + size);
            }
            protobufListA.addAll(protobufList);
        }
        if (size > 0) {
            protobufList = protobufListA;
        }
        UnsafeUtil.r(obj, j2, protobufList);
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public final Internal.ProtobufList b(long j2, Object obj) {
        Internal.ProtobufList protobufList = (Internal.ProtobufList) UnsafeUtil.f4183c.m(j2, obj);
        if (protobufList.r0()) {
            return protobufList;
        }
        int size = protobufList.size();
        Internal.ProtobufList protobufListA = protobufList.a(size == 0 ? 10 : size * 2);
        UnsafeUtil.r(obj, j2, protobufListA);
        return protobufListA;
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public final void c(long j2, Object obj) {
        ((Internal.ProtobufList) UnsafeUtil.f4183c.m(j2, obj)).D();
    }
}
