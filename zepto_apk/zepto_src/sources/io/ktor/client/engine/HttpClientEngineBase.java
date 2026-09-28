package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.util.CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public abstract class HttpClientEngineBase implements HttpClientEngine {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f49349c = AtomicIntegerFieldUpdater.newUpdater(HttpClientEngineBase.class, "closed");

    /* renamed from: a, reason: collision with root package name */
    public final DefaultIoScheduler f49350a;

    /* renamed from: b, reason: collision with root package name */
    public final Lazy f49351b;

    @NotNull
    private volatile /* synthetic */ int closed;

    public HttpClientEngineBase() {
        Intrinsics.checkNotNullParameter("ktor-okhttp", "engineName");
        this.closed = 0;
        DefaultScheduler defaultScheduler = Dispatchers.f54091a;
        this.f49350a = DefaultIoScheduler.f55150b;
        this.f49351b = LazyKt.b(new Function0<CoroutineContext>() { // from class: io.ktor.client.engine.HttpClientEngineBase$coroutineContext$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CoroutineContext.Element.DefaultImpls.c((JobSupport) SupervisorKt.a(null), new CoroutinesUtilsKt$SilentSupervisor$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key.f54075a)).plus(this.f49352c.f49350a).plus(new CoroutineName("ktor-okhttp-context"));
            }
        });
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public final void K1(HttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        client.f49264g.g(HttpSendPipeline.f50033j, new HttpClientEngine$install$1(client, this, null));
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public Set Z0() {
        return EmptySet.f53611a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (f49349c.compareAndSet(this, 0, 1)) {
            CoroutineContext.Element element = r().get(Job.Key.f54121a);
            CompletableJob completableJob = element instanceof CompletableJob ? (CompletableJob) element : null;
            if (completableJob == null) {
                return;
            }
            completableJob.complete();
        }
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext r() {
        return (CoroutineContext) this.f49351b.getValue();
    }
}
