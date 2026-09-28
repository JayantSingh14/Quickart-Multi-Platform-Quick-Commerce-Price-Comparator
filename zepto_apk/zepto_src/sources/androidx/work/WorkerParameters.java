package androidx.work;

import android.net.Network;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public final class WorkerParameters {

    /* renamed from: a, reason: collision with root package name */
    public UUID f12587a;

    /* renamed from: b, reason: collision with root package name */
    public Data f12588b;

    /* renamed from: c, reason: collision with root package name */
    public HashSet f12589c;

    /* renamed from: d, reason: collision with root package name */
    public RuntimeExtras f12590d;

    /* renamed from: e, reason: collision with root package name */
    public int f12591e;

    /* renamed from: f, reason: collision with root package name */
    public ExecutorService f12592f;

    /* renamed from: g, reason: collision with root package name */
    public WorkManagerTaskExecutor f12593g;

    /* renamed from: h, reason: collision with root package name */
    public WorkerFactory f12594h;

    /* renamed from: i, reason: collision with root package name */
    public WorkProgressUpdater f12595i;

    /* renamed from: j, reason: collision with root package name */
    public WorkForegroundUpdater f12596j;

    @RestrictTo
    public static class RuntimeExtras {

        /* renamed from: a, reason: collision with root package name */
        public List f12597a;

        /* renamed from: b, reason: collision with root package name */
        public List f12598b;

        /* renamed from: c, reason: collision with root package name */
        public Network f12599c;

        public RuntimeExtras() {
            List list = Collections.EMPTY_LIST;
            this.f12597a = list;
            this.f12598b = list;
        }
    }

    public final Executor a() {
        return this.f12592f;
    }

    public final ForegroundUpdater b() {
        return this.f12596j;
    }

    public final UUID c() {
        return this.f12587a;
    }

    public final Data d() {
        return this.f12588b;
    }

    public final Network e() {
        return this.f12590d.f12599c;
    }

    public final ProgressUpdater f() {
        return this.f12595i;
    }

    public final int g() {
        return this.f12591e;
    }

    public final HashSet h() {
        return this.f12589c;
    }

    public final TaskExecutor i() {
        return this.f12593g;
    }

    public final List j() {
        return this.f12590d.f12597a;
    }

    public final List k() {
        return this.f12590d.f12598b;
    }

    public final WorkerFactory l() {
        return this.f12594h;
    }
}
