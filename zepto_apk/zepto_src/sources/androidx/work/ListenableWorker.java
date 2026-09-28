package androidx.work;

import android.content.Context;
import android.net.Network;
import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.WorkForegroundUpdater;
import androidx.work.impl.utils.WorkProgressUpdater;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class ListenableWorker {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12527a;

    /* renamed from: b, reason: collision with root package name */
    public final WorkerParameters f12528b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f12529c = -256;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12530d;

    /* loaded from: classes3.dex */
    public static abstract class Result {

        @RestrictTo
        public static final class Failure extends Result {

            /* renamed from: a, reason: collision with root package name */
            public final Data f12531a = Data.f12509c;

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Failure.class != obj.getClass()) {
                    return false;
                }
                return this.f12531a.equals(((Failure) obj).f12531a);
            }

            public final int hashCode() {
                return this.f12531a.hashCode() + 846803280;
            }

            public final String toString() {
                return "Failure {mOutputData=" + this.f12531a + '}';
            }
        }

        @RestrictTo
        public static final class Retry extends Result {
            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && Retry.class == obj.getClass();
            }

            public final int hashCode() {
                return 25945934;
            }

            public final String toString() {
                return "Retry";
            }
        }

        public static Failure a() {
            return new Failure();
        }

        public static Success b() {
            return new Success();
        }

        @RestrictTo
        public static final class Success extends Result {

            /* renamed from: a, reason: collision with root package name */
            public final Data f12532a;

            public Success(Data data) {
                this.f12532a = data;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || Success.class != obj.getClass()) {
                    return false;
                }
                return this.f12532a.equals(((Success) obj).f12532a);
            }

            public final int hashCode() {
                return this.f12532a.hashCode() - 1876823561;
            }

            public final String toString() {
                return "Success {mOutputData=" + this.f12532a + '}';
            }

            public Success() {
                this(Data.f12509c);
            }
        }
    }

    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        }
        if (workerParameters == null) {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
        this.f12527a = context;
        this.f12528b = workerParameters;
    }

    @NonNull
    public final Context getApplicationContext() {
        return this.f12527a;
    }

    @NonNull
    @RestrictTo
    public Executor getBackgroundExecutor() {
        return this.f12528b.a();
    }

    public ListenableFuture getForegroundInfoAsync() {
        SettableFuture settableFuture = new SettableFuture();
        settableFuture.j(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return settableFuture;
    }

    @NonNull
    public final UUID getId() {
        return this.f12528b.c();
    }

    @NonNull
    public final Data getInputData() {
        return this.f12528b.d();
    }

    @Nullable
    @RequiresApi
    public final Network getNetwork() {
        return this.f12528b.e();
    }

    @IntRange
    public final int getRunAttemptCount() {
        return this.f12528b.g();
    }

    @RequiresApi
    public final int getStopReason() {
        return this.f12529c;
    }

    @NonNull
    public final Set<String> getTags() {
        return this.f12528b.h();
    }

    @NonNull
    @RestrictTo
    public TaskExecutor getTaskExecutor() {
        return this.f12528b.i();
    }

    @NonNull
    @RequiresApi
    public final List<String> getTriggeredContentAuthorities() {
        return this.f12528b.j();
    }

    @NonNull
    @RequiresApi
    public final List<Uri> getTriggeredContentUris() {
        return this.f12528b.k();
    }

    @NonNull
    @RestrictTo
    public WorkerFactory getWorkerFactory() {
        return this.f12528b.l();
    }

    public final boolean isStopped() {
        return this.f12529c != -256;
    }

    @RestrictTo
    public final boolean isUsed() {
        return this.f12530d;
    }

    public void onStopped() {
    }

    @NonNull
    public final ListenableFuture<Void> setForegroundAsync(@NonNull ForegroundInfo foregroundInfo) {
        return ((WorkForegroundUpdater) this.f12528b.b()).a(getApplicationContext(), getId(), foregroundInfo);
    }

    @NonNull
    public ListenableFuture<Void> setProgressAsync(@NonNull Data data) {
        ProgressUpdater progressUpdaterF = this.f12528b.f();
        getApplicationContext();
        return ((WorkProgressUpdater) progressUpdaterF).a(getId(), data);
    }

    @RestrictTo
    public final void setUsed() {
        this.f12530d = true;
    }

    public abstract ListenableFuture startWork();

    @RestrictTo
    public final void stop(int i2) {
        this.f12529c = i2;
        onStopped();
    }
}
