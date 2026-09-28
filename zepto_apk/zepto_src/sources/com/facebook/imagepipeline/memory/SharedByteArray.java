package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.infer.annotation.Nullsafe;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class SharedByteArray implements MemoryTrimmable {

    /* renamed from: com.facebook.imagepipeline.memory.SharedByteArray$1, reason: invalid class name */
    class AnonymousClass1 implements ResourceReleaser<byte[]> {
        @Override // com.facebook.common.references.ResourceReleaser
        public final void a(Object obj) {
            throw null;
        }
    }
}
