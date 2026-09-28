package androidx.activity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class FullyDrawnReporter {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f141a;

    /* renamed from: b, reason: collision with root package name */
    public final Function0 f142b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f143c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f144d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f145e;

    public FullyDrawnReporter(Executor executor, Function0 reportFullyDrawn) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(reportFullyDrawn, "reportFullyDrawn");
        this.f141a = executor;
        this.f142b = reportFullyDrawn;
        this.f143c = new Object();
        this.f145e = new ArrayList();
        new f(this, 1);
    }

    public final void a() {
        synchronized (this.f143c) {
            try {
                this.f144d = true;
                Iterator it = this.f145e.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f145e.clear();
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f143c) {
            z = this.f144d;
        }
        return z;
    }
}
