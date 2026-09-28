package androidx.media3.session;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.session.MediaController;
import com.google.common.util.concurrent.AbstractFuture;

/* loaded from: classes3.dex */
class MediaControllerHolder<T extends MediaController> extends AbstractFuture<T> implements MediaController.ConnectionCallback {

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f9966k = 0;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f9967h;

    /* renamed from: i, reason: collision with root package name */
    public MediaController f9968i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9969j;

    public MediaControllerHolder(Looper looper) {
        this.f9967h = new Handler(looper);
    }
}
