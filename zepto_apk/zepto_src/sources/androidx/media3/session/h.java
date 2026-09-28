package androidx.media3.session;

import android.os.Handler;
import androidx.media3.common.util.Util;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10379a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10380b;

    public /* synthetic */ h(Object obj, int i2) {
        this.f10379a = i2;
        this.f10380b = obj;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        switch (this.f10379a) {
            case 0:
                Util.X(((MediaControllerHolder) this.f10380b).f9967h, runnable);
                break;
            case 1:
                MediaLibrarySessionImpl.x((MediaLibrarySessionImpl) this.f10380b, runnable);
                break;
            case 2:
                Util.X(((MediaSessionImpl) this.f10380b).f10102l, runnable);
                break;
            default:
                Util.X((Handler) this.f10380b, runnable);
                break;
        }
    }
}
