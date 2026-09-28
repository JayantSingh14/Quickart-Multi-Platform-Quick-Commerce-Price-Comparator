package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.arch.core.executor.ArchTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@RestrictTo
/* loaded from: classes3.dex */
public abstract class ComputableLiveData<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f4769a;

    /* renamed from: b, reason: collision with root package name */
    public final ComputableLiveData$_liveData$1 f4770b;

    /* renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f4771c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f4772d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.constraintlayout.helper.widget.a f4773e;

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.ComputableLiveData$_liveData$1] */
    @JvmOverloads
    public ComputableLiveData() {
        androidx.arch.core.executor.a executor = ArchTaskExecutor.f1275c;
        Intrinsics.checkNotNullExpressionValue(executor, "getIOThreadExecutor()");
        Intrinsics.checkNotNullParameter(executor, "executor");
        this.f4769a = executor;
        this.f4770b = new LiveData<Object>() { // from class: androidx.lifecycle.ComputableLiveData$_liveData$1
            @Override // androidx.lifecycle.LiveData
            public final void g() {
                ComputableLiveData computableLiveData = this.f4774l;
                computableLiveData.f4769a.execute(computableLiveData.f4773e);
            }
        };
        this.f4771c = new AtomicBoolean(true);
        this.f4772d = new AtomicBoolean(false);
        this.f4773e = new androidx.constraintlayout.helper.widget.a(this, 1);
    }

    public abstract Object a();
}
