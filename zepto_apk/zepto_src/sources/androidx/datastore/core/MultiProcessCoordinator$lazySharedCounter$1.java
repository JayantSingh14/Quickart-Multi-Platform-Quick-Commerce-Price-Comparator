package androidx.datastore.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class MultiProcessCoordinator$lazySharedCounter$1 extends Lambda implements Function0<SharedCounter> {

    @Metadata
    /* renamed from: androidx.datastore.core.MultiProcessCoordinator$lazySharedCounter$1$1, reason: invalid class name */
    final class AnonymousClass1 extends Lambda implements Function0<File> {
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            throw null;
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i2 = SharedCounter.f3613a;
        System.loadLibrary("datastore_shared_counter");
        throw null;
    }
}
