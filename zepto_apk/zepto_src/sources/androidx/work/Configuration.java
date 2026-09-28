package androidx.work;

import androidx.work.WorkerFactory;
import androidx.work.impl.DefaultRunnableScheduler;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class Configuration {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f12474a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f12475b;

    /* renamed from: c, reason: collision with root package name */
    public final SystemClock f12476c;

    /* renamed from: d, reason: collision with root package name */
    public final WorkerFactory f12477d;

    /* renamed from: e, reason: collision with root package name */
    public final NoOpInputMergerFactory f12478e;

    /* renamed from: f, reason: collision with root package name */
    public final DefaultRunnableScheduler f12479f;

    /* renamed from: g, reason: collision with root package name */
    public final int f12480g;

    /* renamed from: h, reason: collision with root package name */
    public final int f12481h;

    /* renamed from: i, reason: collision with root package name */
    public final int f12482i;

    /* renamed from: j, reason: collision with root package name */
    public final int f12483j;

    @Metadata
    public static final class Builder {
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public interface Provider {
        Configuration a();
    }

    public Configuration(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.f12474a = ConfigurationKt.a(false);
        this.f12475b = ConfigurationKt.a(true);
        this.f12476c = new SystemClock();
        String str = WorkerFactory.f12586a;
        WorkerFactory.AnonymousClass1 anonymousClass1 = new WorkerFactory.AnonymousClass1();
        Intrinsics.checkNotNullExpressionValue(anonymousClass1, "getDefaultWorkerFactory()");
        this.f12477d = anonymousClass1;
        this.f12478e = NoOpInputMergerFactory.f12543a;
        this.f12479f = new DefaultRunnableScheduler();
        this.f12480g = 4;
        this.f12481h = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f12483j = 20;
        this.f12482i = 8;
    }
}
