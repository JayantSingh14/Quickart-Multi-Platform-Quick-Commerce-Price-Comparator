package coil3.request;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata
@JvmInline
/* loaded from: classes3.dex */
public final class BaseRequestDelegate implements RequestDelegate {

    @NotNull
    private final Job job;

    private /* synthetic */ BaseRequestDelegate(Job job) {
        this.job = job;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ BaseRequestDelegate m28boximpl(Job job) {
        return new BaseRequestDelegate(job);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static Job m29constructorimpl(@NotNull Job job) {
        return job;
    }

    /* renamed from: dispose-impl, reason: not valid java name */
    public static void m30disposeimpl(Job job) {
        job.e(null);
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m31equalsimpl(Job job, Object obj) {
        return (obj instanceof BaseRequestDelegate) && Intrinsics.b(job, ((BaseRequestDelegate) obj).m35unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m32equalsimpl0(Job job, Job job2) {
        return Intrinsics.b(job, job2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m33hashCodeimpl(Job job) {
        return job.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m34toStringimpl(Job job) {
        return "BaseRequestDelegate(job=" + job + ')';
    }

    @Override // coil3.request.RequestDelegate
    public void dispose() {
        m30disposeimpl(this.job);
    }

    public boolean equals(Object obj) {
        return m31equalsimpl(this.job, obj);
    }

    public int hashCode() {
        return m33hashCodeimpl(this.job);
    }

    public String toString() {
        return m34toStringimpl(this.job);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Job m35unboximpl() {
        return this.job;
    }
}
