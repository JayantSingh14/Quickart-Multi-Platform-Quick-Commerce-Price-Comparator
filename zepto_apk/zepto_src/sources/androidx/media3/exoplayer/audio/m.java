package androidx.media3.exoplayer.audio;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Handler f6667a;

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f6667a.post(runnable);
    }
}
