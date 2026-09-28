package androidx.profileinstaller;

import android.content.Context;
import android.content.SharedPreferences;
import bridges.CommsModule;
import com.zeptoconsumerapp.PhoenixBackgroundWorker.PhoenixWorker;
import com.zeptoconsumerapp.Utils;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11336a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f11337b;

    public /* synthetic */ b(Context context, int i2) {
        this.f11336a = i2;
        this.f11337b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11336a) {
            case 0:
                new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new b(this.f11337b, 1));
                break;
            case 1:
                ProfileInstaller.b(this.f11337b, new androidx.arch.core.executor.a(1), ProfileInstaller.f11313a, false);
                break;
            default:
                String strH = Utils.h();
                Context context = this.f11337b;
                if (strH != null) {
                    SharedPreferences.Editor editorEdit = context.getSharedPreferences(CommsModule.SHARED_PREFERENCE_NAME, 0).edit();
                    editorEdit.putString("PhoenixBackgroundWorkerConfig", strH);
                    editorEdit.apply();
                }
                try {
                    PhoenixWorker.b(context);
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
        }
    }
}
