package androidx.media3.exoplayer.offline;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.scheduler.Requirements;
import java.util.HashMap;

@UnstableApi
/* loaded from: classes3.dex */
public abstract class DownloadService extends Service {

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap f7378d = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public DownloadManagerHelper f7379a;

    /* renamed from: b, reason: collision with root package name */
    public int f7380b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7381c;

    public static final class DownloadManagerHelper implements DownloadManager.Listener {

        /* renamed from: a, reason: collision with root package name */
        public final DownloadManager f7382a;

        /* renamed from: b, reason: collision with root package name */
        public DownloadService f7383b;

        public DownloadManagerHelper(Context context, DownloadManager downloadManager, Class cls) {
            this.f7382a = downloadManager;
            throw null;
        }
    }

    public final class ForegroundNotificationUpdater {
    }

    public abstract DownloadManager a();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public final void onCreate() {
        Class<?> cls = getClass();
        DownloadManagerHelper downloadManagerHelper = (DownloadManagerHelper) f7378d.get(cls);
        if (downloadManagerHelper != null) {
            this.f7379a = downloadManagerHelper;
            Assertions.g(downloadManagerHelper.f7383b == null);
            downloadManagerHelper.f7383b = this;
        } else {
            int i2 = Util.f5744a;
            DownloadManager downloadManagerA = a();
            downloadManagerA.a(false);
            new DownloadManagerHelper(getApplicationContext(), downloadManagerA, cls);
            throw null;
        }
    }

    @Override // android.app.Service
    public final void onDestroy() {
        DownloadManagerHelper downloadManagerHelper = this.f7379a;
        downloadManagerHelper.getClass();
        Assertions.g(downloadManagerHelper.f7383b == this);
        downloadManagerHelper.f7383b = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        String action;
        String stringExtra;
        DownloadManager downloadManager;
        this.f7380b = i3;
        this.f7381c = false;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra("content_id");
            if (!intent.getBooleanExtra("foreground", false)) {
                "androidx.media3.exoplayer.downloadService.action.RESTART".equals(action);
            }
        } else {
            action = null;
            stringExtra = null;
        }
        if (action == null) {
            action = "androidx.media3.exoplayer.downloadService.action.INIT";
        }
        downloadManager = this.f7379a.f7382a;
        switch (action) {
            case "androidx.media3.exoplayer.downloadService.action.SET_STOP_REASON":
                intent.getClass();
                if (!intent.hasExtra("stop_reason")) {
                    Log.d("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    intent.getIntExtra("stop_reason", 0);
                    downloadManager.f7369a++;
                    throw null;
                }
            case "androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (stringExtra != null) {
                    downloadManager.f7369a++;
                    throw null;
                }
                Log.d("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                break;
            case "androidx.media3.exoplayer.downloadService.action.RESTART":
            case "androidx.media3.exoplayer.downloadService.action.INIT":
                break;
            case "androidx.media3.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                downloadManager.a(false);
                break;
            case "androidx.media3.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                downloadManager.f7369a++;
                throw null;
            case "androidx.media3.exoplayer.downloadService.action.ADD_DOWNLOAD":
                intent.getClass();
                if (((DownloadRequest) intent.getParcelableExtra("download_request")) != null) {
                    intent.getIntExtra("stop_reason", 0);
                    downloadManager.f7369a++;
                    throw null;
                }
                Log.d("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                break;
            case "androidx.media3.exoplayer.downloadService.action.SET_REQUIREMENTS":
                intent.getClass();
                if (((Requirements) intent.getParcelableExtra("requirements")) != null) {
                    throw null;
                }
                Log.d("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                break;
            case "androidx.media3.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                downloadManager.a(true);
                break;
            default:
                Log.d("DownloadService", "Ignored unrecognized action: ".concat(action));
                break;
        }
        int i4 = Util.f5744a;
        if (downloadManager.f7369a == 0) {
            if (i4 < 28 && this.f7381c) {
                stopSelf();
                return 1;
            }
            stopSelfResult(this.f7380b);
        }
        return 1;
    }

    @Override // android.app.Service
    public final void onTaskRemoved(Intent intent) {
        this.f7381c = true;
    }
}
