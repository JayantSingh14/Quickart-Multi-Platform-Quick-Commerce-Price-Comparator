package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import androidx.annotation.VisibleForTesting;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Nullsafe
/* loaded from: classes3.dex */
public class JobScheduler {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f18186a;

    /* renamed from: b, reason: collision with root package name */
    public final JobRunnable f18187b;

    /* renamed from: c, reason: collision with root package name */
    public final Runnable f18188c = new Runnable() { // from class: com.facebook.imagepipeline.producers.JobScheduler.1
        @Override // java.lang.Runnable
        public final void run() {
            EncodedImage encodedImage;
            int i2;
            JobScheduler jobScheduler = JobScheduler.this;
            jobScheduler.getClass();
            long jUptimeMillis = SystemClock.uptimeMillis();
            synchronized (jobScheduler) {
                encodedImage = jobScheduler.f18190e;
                i2 = jobScheduler.f18191f;
                jobScheduler.f18190e = null;
                jobScheduler.f18191f = 0;
                jobScheduler.f18192g = JobState.f18201c;
                jobScheduler.f18194i = jUptimeMillis;
            }
            try {
                if (JobScheduler.e(encodedImage, i2)) {
                    jobScheduler.f18187b.a(encodedImage, i2);
                }
            } finally {
                EncodedImage.b(encodedImage);
                jobScheduler.c();
            }
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f18189d = new AnonymousClass2();

    /* renamed from: e, reason: collision with root package name */
    public EncodedImage f18190e = null;

    /* renamed from: f, reason: collision with root package name */
    public int f18191f = 0;

    /* renamed from: g, reason: collision with root package name */
    public JobState f18192g = JobState.f18199a;

    /* renamed from: h, reason: collision with root package name */
    public long f18193h = 0;

    /* renamed from: i, reason: collision with root package name */
    public long f18194i = 0;

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$2, reason: invalid class name */
    class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            JobScheduler jobScheduler = JobScheduler.this;
            jobScheduler.f18186a.execute(jobScheduler.f18188c);
        }
    }

    /* renamed from: com.facebook.imagepipeline.producers.JobScheduler$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18197a;

        static {
            int[] iArr = new int[JobState.values().length];
            f18197a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18197a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18197a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18197a[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public interface JobRunnable {
        void a(EncodedImage encodedImage, int i2);
    }

    @VisibleForTesting
    public static class JobStartExecutorSupplier {

        /* renamed from: a, reason: collision with root package name */
        public static ScheduledExecutorService f18198a;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @VisibleForTesting
    public static final class JobState {

        /* renamed from: a, reason: collision with root package name */
        public static final JobState f18199a;

        /* renamed from: b, reason: collision with root package name */
        public static final JobState f18200b;

        /* renamed from: c, reason: collision with root package name */
        public static final JobState f18201c;

        /* renamed from: d, reason: collision with root package name */
        public static final JobState f18202d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ JobState[] f18203e;

        static {
            JobState jobState = new JobState("IDLE", 0);
            f18199a = jobState;
            JobState jobState2 = new JobState("QUEUED", 1);
            f18200b = jobState2;
            JobState jobState3 = new JobState("RUNNING", 2);
            f18201c = jobState3;
            JobState jobState4 = new JobState("RUNNING_AND_PENDING", 3);
            f18202d = jobState4;
            f18203e = new JobState[]{jobState, jobState2, jobState3, jobState4};
        }

        public static JobState valueOf(String str) {
            return (JobState) Enum.valueOf(JobState.class, str);
        }

        public static JobState[] values() {
            return (JobState[]) f18203e.clone();
        }
    }

    public JobScheduler(Executor executor, JobRunnable jobRunnable) {
        this.f18186a = executor;
        this.f18187b = jobRunnable;
    }

    public static boolean e(EncodedImage encodedImage, int i2) {
        return BaseConsumer.d(i2) || BaseConsumer.k(i2, 4) || EncodedImage.V(encodedImage);
    }

    public final void a() {
        EncodedImage encodedImage;
        synchronized (this) {
            encodedImage = this.f18190e;
            this.f18190e = null;
            this.f18191f = 0;
        }
        EncodedImage.b(encodedImage);
    }

    public final void b(long j2) {
        Runnable runnable = this.f18189d;
        if (j2 <= 0) {
            ((AnonymousClass2) runnable).run();
            return;
        }
        if (JobStartExecutorSupplier.f18198a == null) {
            JobStartExecutorSupplier.f18198a = Executors.newSingleThreadScheduledExecutor();
        }
        JobStartExecutorSupplier.f18198a.schedule(runnable, j2, TimeUnit.MILLISECONDS);
    }

    public final void c() {
        long jMax;
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            try {
                if (this.f18192g == JobState.f18202d) {
                    jMax = Math.max(this.f18194i + 100, jUptimeMillis);
                    this.f18193h = jUptimeMillis;
                    this.f18192g = JobState.f18200b;
                    z = true;
                } else {
                    this.f18192g = JobState.f18199a;
                    jMax = 0;
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            b(jMax - jUptimeMillis);
        }
    }

    public final void d() {
        long jMax;
        boolean z;
        long jUptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            try {
                if (e(this.f18190e, this.f18191f)) {
                    int iOrdinal = this.f18192g.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal == 2) {
                            this.f18192g = JobState.f18202d;
                        }
                        z = false;
                        jMax = 0;
                    } else {
                        jMax = Math.max(this.f18194i + 100, jUptimeMillis);
                        this.f18193h = jUptimeMillis;
                        this.f18192g = JobState.f18200b;
                        z = true;
                    }
                    if (z) {
                        b(jMax - jUptimeMillis);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean f(EncodedImage encodedImage, int i2) {
        EncodedImage encodedImage2;
        if (!e(encodedImage, i2)) {
            return false;
        }
        synchronized (this) {
            encodedImage2 = this.f18190e;
            this.f18190e = EncodedImage.a(encodedImage);
            this.f18191f = i2;
        }
        EncodedImage.b(encodedImage2);
        return true;
    }
}
