package io.ktor.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
final class ConcurrentSafeAttributes extends AttributesJvmBase {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap f50446a = new ConcurrentHashMap();

    @Override // io.ktor.util.Attributes
    public final Object g(AttributeKey key, Function0 block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        ConcurrentHashMap concurrentHashMap = this.f50446a;
        Object obj = concurrentHashMap.get(key);
        if (obj != null) {
            return obj;
        }
        Object objInvoke = block.invoke();
        Object objPutIfAbsent = concurrentHashMap.putIfAbsent(key, objInvoke);
        if (objPutIfAbsent != null) {
            objInvoke = objPutIfAbsent;
        }
        Intrinsics.d(objInvoke, "null cannot be cast to non-null type T of io.ktor.util.ConcurrentSafeAttributes.computeIfAbsent");
        return objInvoke;
    }

    @Override // io.ktor.util.AttributesJvmBase
    public final Map h() {
        return this.f50446a;
    }
}
