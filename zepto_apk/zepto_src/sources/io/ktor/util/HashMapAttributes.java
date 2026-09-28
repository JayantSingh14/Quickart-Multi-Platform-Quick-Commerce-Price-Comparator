package io.ktor.util;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class HashMapAttributes extends AttributesJvmBase {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f50484a = new HashMap();

    @Override // io.ktor.util.Attributes
    public final Object g(AttributeKey key, Function0 block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        HashMap map = this.f50484a;
        Object obj = map.get(key);
        if (obj != null) {
            return obj;
        }
        Object objInvoke = block.invoke();
        Object objPut = map.put(key, objInvoke);
        if (objPut != null) {
            objInvoke = objPut;
        }
        Intrinsics.d(objInvoke, "null cannot be cast to non-null type T of io.ktor.util.HashMapAttributes.computeIfAbsent");
        return objInvoke;
    }

    @Override // io.ktor.util.AttributesJvmBase
    public final Map h() {
        return this.f50484a;
    }
}
