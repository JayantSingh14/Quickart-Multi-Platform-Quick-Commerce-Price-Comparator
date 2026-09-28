package com.facebook.imagepipeline.memory;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.infer.annotation.Nullsafe;
import java.util.LinkedList;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public class FlexByteArrayPool {

    /* renamed from: com.facebook.imagepipeline.memory.FlexByteArrayPool$1, reason: invalid class name */
    class AnonymousClass1 implements ResourceReleaser<byte[]> {
        @Override // com.facebook.common.references.ResourceReleaser
        public final void a(Object obj) {
            throw null;
        }
    }

    @VisibleForTesting
    public static class SoftRefByteArrayPool extends GenericByteArrayPool {
        @Override // com.facebook.imagepipeline.memory.BasePool
        public final Bucket p(int i2) {
            OOMSoftReferenceBucket oOMSoftReferenceBucket = new OOMSoftReferenceBucket(i2, this.f17984c.f18060d, 0);
            oOMSoftReferenceBucket.f18038e = new LinkedList();
            return oOMSoftReferenceBucket;
        }
    }
}
