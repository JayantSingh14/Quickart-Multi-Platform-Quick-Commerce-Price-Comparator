package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public interface Allocator {

    public interface AllocationNode {
        Allocation a();

        AllocationNode next();
    }

    void a(AllocationNode allocationNode);

    Allocation b();

    void c(Allocation allocation);

    void d();

    int e();
}
