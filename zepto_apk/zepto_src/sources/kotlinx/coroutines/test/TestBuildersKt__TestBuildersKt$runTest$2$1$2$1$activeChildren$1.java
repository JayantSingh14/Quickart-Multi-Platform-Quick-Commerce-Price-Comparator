package kotlinx.coroutines.test;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: classes3.dex */
final /* synthetic */ class TestBuildersKt__TestBuildersKt$runTest$2$1$2$1$activeChildren$1 extends PropertyReference1Impl {
    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
    public final Object get(Object obj) {
        return Boolean.valueOf(((Job) obj).a());
    }
}
