package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.upstream.Allocator;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class DefaultAllocator implements Allocator {

    /* renamed from: d, reason: collision with root package name */
    public int f8133d;

    /* renamed from: e, reason: collision with root package name */
    public int f8134e;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f8130a = true;

    /* renamed from: b, reason: collision with root package name */
    public final int f8131b = 65536;

    /* renamed from: f, reason: collision with root package name */
    public int f8135f = 0;

    /* renamed from: g, reason: collision with root package name */
    public Allocation[] f8136g = new Allocation[100];

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f8132c = null;

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public final synchronized void a(Allocator.AllocationNode allocationNode) {
        while (allocationNode != null) {
            try {
                Allocation[] allocationArr = this.f8136g;
                int i2 = this.f8135f;
                this.f8135f = i2 + 1;
                allocationArr[i2] = allocationNode.a();
                this.f8134e--;
                allocationNode = allocationNode.next();
            } catch (Throwable th) {
                throw th;
            }
        }
        notifyAll();
    }

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public final synchronized Allocation b() {
        Allocation allocation;
        try {
            int i2 = this.f8134e + 1;
            this.f8134e = i2;
            int i3 = this.f8135f;
            if (i3 > 0) {
                Allocation[] allocationArr = this.f8136g;
                int i4 = i3 - 1;
                this.f8135f = i4;
                allocation = allocationArr[i4];
                allocation.getClass();
                this.f8136g[this.f8135f] = null;
            } else {
                Allocation allocation2 = new Allocation(new byte[this.f8131b], 0);
                Allocation[] allocationArr2 = this.f8136g;
                if (i2 > allocationArr2.length) {
                    this.f8136g = (Allocation[]) Arrays.copyOf(allocationArr2, allocationArr2.length * 2);
                }
                allocation = allocation2;
            }
        } catch (Throwable th) {
            throw th;
        }
        return allocation;
    }

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public final synchronized void c(Allocation allocation) {
        Allocation[] allocationArr = this.f8136g;
        int i2 = this.f8135f;
        this.f8135f = i2 + 1;
        allocationArr[i2] = allocation;
        this.f8134e--;
        notifyAll();
    }

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public final synchronized void d() {
        try {
            int i2 = 0;
            int iMax = Math.max(0, Util.g(this.f8133d, this.f8131b) - this.f8134e);
            int i3 = this.f8135f;
            if (iMax >= i3) {
                return;
            }
            if (this.f8132c != null) {
                int i4 = i3 - 1;
                while (i2 <= i4) {
                    Allocation allocation = this.f8136g[i2];
                    allocation.getClass();
                    if (allocation.f8059a == this.f8132c) {
                        i2++;
                    } else {
                        Allocation allocation2 = this.f8136g[i4];
                        allocation2.getClass();
                        if (allocation2.f8059a != this.f8132c) {
                            i4--;
                        } else {
                            Allocation[] allocationArr = this.f8136g;
                            allocationArr[i2] = allocation2;
                            allocationArr[i4] = allocation;
                            i4--;
                            i2++;
                        }
                    }
                }
                iMax = Math.max(iMax, i2);
                if (iMax >= this.f8135f) {
                    return;
                }
            }
            Arrays.fill(this.f8136g, iMax, this.f8135f, (Object) null);
            this.f8135f = iMax;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.upstream.Allocator
    public final int e() {
        return this.f8131b;
    }

    public final synchronized int f() {
        return this.f8134e * this.f8131b;
    }

    public final synchronized void g(int i2) {
        boolean z = i2 < this.f8133d;
        this.f8133d = i2;
        if (z) {
            d();
        }
    }
}
