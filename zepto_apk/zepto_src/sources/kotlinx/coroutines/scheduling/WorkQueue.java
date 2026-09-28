package kotlinx.coroutines.scheduling;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.xbill.DNS.WKSRecord;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class WorkQueue {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f55165b = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask$volatile");

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f55166c = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex$volatile");

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f55167d = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex$volatile");

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f55168e = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer$volatile");

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReferenceArray f55169a = new AtomicReferenceArray(128);
    private volatile /* synthetic */ int blockingTasksInBuffer$volatile;
    private volatile /* synthetic */ int consumerIndex$volatile;
    private volatile /* synthetic */ Object lastScheduledTask$volatile;
    private volatile /* synthetic */ int producerIndex$volatile;

    public final Task a(Task task) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f55166c;
        if (atomicIntegerFieldUpdater.get(this) - f55167d.get(this) == 127) {
            return task;
        }
        if (task.f55156b) {
            f55168e.incrementAndGet(this);
        }
        int i2 = atomicIntegerFieldUpdater.get(this) & WKSRecord.Service.LOCUS_CON;
        while (true) {
            AtomicReferenceArray atomicReferenceArray = this.f55169a;
            if (atomicReferenceArray.get(i2) == null) {
                atomicReferenceArray.lazySet(i2, task);
                atomicIntegerFieldUpdater.incrementAndGet(this);
                return null;
            }
            Thread.yield();
        }
    }

    public final Task b() {
        Task task;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f55167d;
            int i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 - f55166c.get(this) == 0) {
                return null;
            }
            int i3 = i2 & WKSRecord.Service.LOCUS_CON;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i2, i2 + 1) && (task = (Task) this.f55169a.getAndSet(i3, null)) != null) {
                if (task.f55156b) {
                    f55168e.decrementAndGet(this);
                }
                return task;
            }
        }
    }

    public final Task c(int i2, boolean z) {
        int i3 = i2 & WKSRecord.Service.LOCUS_CON;
        AtomicReferenceArray atomicReferenceArray = this.f55169a;
        Task task = (Task) atomicReferenceArray.get(i3);
        if (task != null && task.f55156b == z) {
            while (!atomicReferenceArray.compareAndSet(i3, task, null)) {
                if (atomicReferenceArray.get(i3) != task) {
                }
            }
            if (z) {
                f55168e.decrementAndGet(this);
            }
            return task;
        }
        return null;
    }
}
