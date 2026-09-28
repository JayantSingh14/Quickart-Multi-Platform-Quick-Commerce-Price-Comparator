package kotlinx.coroutines.test;

import androidx.fragment.app.e;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;

@Metadata
/* loaded from: classes3.dex */
final class TestDispatchEvent<T> implements Comparable<TestDispatchEvent<?>>, ThreadSafeHeapNode {

    /* renamed from: a, reason: collision with root package name */
    public final TestDispatcher f55311a;

    /* renamed from: b, reason: collision with root package name */
    public final long f55312b;

    /* renamed from: c, reason: collision with root package name */
    public final long f55313c;

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f55314d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f55315e;

    /* renamed from: f, reason: collision with root package name */
    public ThreadSafeHeap f55316f;

    /* renamed from: g, reason: collision with root package name */
    public int f55317g;

    @Metadata
    /* renamed from: kotlinx.coroutines.test.TestDispatchEvent$compareTo$1, reason: invalid class name */
    final /* synthetic */ class AnonymousClass1 extends PropertyReference1Impl {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass1 f55318c = new AnonymousClass1("time", "getTime()J", TestDispatchEvent.class);

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public final Object get(Object obj) {
            return Long.valueOf(((TestDispatchEvent) obj).f55313c);
        }
    }

    @Metadata
    /* renamed from: kotlinx.coroutines.test.TestDispatchEvent$compareTo$2, reason: invalid class name */
    final /* synthetic */ class AnonymousClass2 extends PropertyReference1Impl {

        /* renamed from: c, reason: collision with root package name */
        public static final AnonymousClass2 f55319c = new AnonymousClass2("count", "getCount()J", TestDispatchEvent.class);

        @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
        public final Object get(Object obj) {
            return Long.valueOf(((TestDispatchEvent) obj).f55312b);
        }
    }

    public TestDispatchEvent(TestDispatcher testDispatcher, long j2, long j3, Runnable runnable, boolean z, b bVar) {
        this.f55311a = testDispatcher;
        this.f55312b = j2;
        this.f55313c = j3;
        this.f55314d = runnable;
        this.f55315e = z;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public final void a(ThreadSafeHeap threadSafeHeap) {
        this.f55316f = threadSafeHeap;
    }

    @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
    public final void c(int i2) {
        this.f55317g = i2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(TestDispatchEvent<?> testDispatchEvent) {
        return ComparisonsKt.b(this, testDispatchEvent, AnonymousClass1.f55318c, AnonymousClass2.f55319c);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("TestDispatchEvent(time=");
        sb.append(this.f55313c);
        sb.append(", dispatcher=");
        sb.append(this.f55311a);
        return e.t(sb, this.f55315e ? "" : ", background", ')');
    }
}
