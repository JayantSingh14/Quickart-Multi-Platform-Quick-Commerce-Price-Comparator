package androidx.media3.exoplayer.offline;

import android.os.Handler;
import android.os.Message;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.Downloader;
import java.util.ArrayList;

@UnstableApi
/* loaded from: classes3.dex */
public final class DownloadManager {

    /* renamed from: a, reason: collision with root package name */
    public int f7369a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7370b;

    public static final class DownloadUpdate {
    }

    public static final class InternalHandler extends Handler {
        /* JADX WARN: Finally extract failed */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    try {
                        throw null;
                    } catch (Throwable th) {
                        int i2 = Util.f5744a;
                        throw th;
                    }
                case 2:
                    throw null;
                case 3:
                    throw null;
                case 4:
                    ((String) message.obj).getClass();
                    throw null;
                case 5:
                    throw null;
                case 6:
                    throw null;
                case 7:
                    String str = ((DownloadRequest) message.obj).f7371a;
                    throw null;
                case 8:
                    throw null;
                case 9:
                    new ArrayList();
                    throw null;
                case 10:
                    ((Task) message.obj).getClass();
                    throw null;
                case 11:
                    Task task = (Task) message.obj;
                    int i3 = Util.f5744a;
                    task.getClass();
                    throw null;
                case 12:
                    throw null;
                case 13:
                    throw null;
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public interface Listener {
    }

    public static class Task extends Thread implements Downloader.ProgressListener {
        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            try {
                throw null;
            } catch (Exception unused) {
            }
        }
    }

    public final void a(boolean z) {
        if (this.f7370b == z) {
            return;
        }
        this.f7370b = z;
        this.f7369a++;
        throw null;
    }
}
