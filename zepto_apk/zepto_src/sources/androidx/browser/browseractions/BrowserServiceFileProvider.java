package androidx.browser.browseractions;

import android.os.AsyncTask;
import androidx.annotation.RestrictTo;
import androidx.core.content.FileProvider;
import java.util.concurrent.TimeUnit;

@RestrictTo
@Deprecated
/* loaded from: classes3.dex */
public final class BrowserServiceFileProvider extends FileProvider {

    /* renamed from: g, reason: collision with root package name */
    public static final Object f1298g = new Object();

    /* renamed from: androidx.browser.browseractions.BrowserServiceFileProvider$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    public static class FileCleanupTask extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public static final long f1299a;

        /* renamed from: b, reason: collision with root package name */
        public static final long f1300b;

        /* renamed from: c, reason: collision with root package name */
        public static final long f1301c;

        static {
            TimeUnit timeUnit = TimeUnit.DAYS;
            f1299a = timeUnit.toMillis(7L);
            f1300b = timeUnit.toMillis(7L);
            f1301c = timeUnit.toMillis(1L);
        }

        @Override // android.os.AsyncTask
        public final Void doInBackground(Void[] voidArr) {
            throw null;
        }
    }

    public static class FileSaveTask extends AsyncTask<String, Void, Void> {
        @Override // android.os.AsyncTask
        public final Void doInBackground(String[] strArr) {
            throw null;
        }

        @Override // android.os.AsyncTask
        public final void onPostExecute(Void r1) {
            new FileCleanupTask();
            throw null;
        }
    }
}
