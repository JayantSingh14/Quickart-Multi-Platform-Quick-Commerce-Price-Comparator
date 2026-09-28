package com.zeptoconsumerapp.AutoLogin;

import android.content.Context;
import androidx.datastore.core.CorruptionException;
import com.phoenix.Phoenix;
import com.zeptoconsumerapp.Startup.AppPhoenixManager;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.notification.silentPush.SilentPushRegistry;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import timber.log.Timber;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f47394a;

    public /* synthetic */ a(int i2) {
        this.f47394a = i2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i2 = 1;
        switch (this.f47394a) {
            case 0:
                return AutoBackupManager.dataStore_delegate$lambda$0((CorruptionException) obj);
            case 1:
                Map map = (Map) obj;
                SilentPushRegistry silentPushRegistry = SilentPushRegistry.f47702a;
                try {
                    Timber.d("SilentPush").i("Executing REFRESH_CONFIG with data=%s", map);
                    Context context = SilentPushRegistry.f47705d;
                    if (context != null) {
                        AppPhoenixManager.f47553b = new AppPhoenixManager.EventContext(true);
                        String str = Utils.f47559a;
                        try {
                            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                            executorServiceNewSingleThreadExecutor.execute(new com.amazon.android.amazonpay.api.a(context, i2));
                            executorServiceNewSingleThreadExecutor.shutdown();
                        } catch (Throwable th) {
                            Utils.i(th);
                        }
                    } else {
                        Timber.d("SilentPush").e("Context is null, cannot refresh config", new Object[0]);
                    }
                } catch (Throwable th2) {
                    Timber.d("SilentPush").e(th2, "Error in REFRESH_CONFIG handler", new Object[0]);
                }
                return Unit.f53572a;
            case 2:
                Map map2 = (Map) obj;
                SilentPushRegistry silentPushRegistry2 = SilentPushRegistry.f47702a;
                try {
                    AppPhoenixManager.f47553b = new AppPhoenixManager.EventContext(true);
                    Timber.d("SilentPush").i("Executing CHECK_PHOENIX_UPDATE with data=%s", map2);
                    Phoenix.Companion.a();
                } catch (Throwable th3) {
                    Timber.d("SilentPush").e(th3, "Error in CHECK_PHOENIX_UPDATE handler", new Object[0]);
                }
                return Unit.f53572a;
            case 3:
                return Boolean.valueOf(obj == null);
            case 4:
                CoroutineContext.Element element = (CoroutineContext.Element) obj;
                if (element instanceof CoroutineDispatcher) {
                    return (CoroutineDispatcher) element;
                }
                return null;
            case 5:
                CoroutineContext.Element element2 = (CoroutineContext.Element) obj;
                if (element2 instanceof ExecutorCoroutineDispatcher) {
                    return (ExecutorCoroutineDispatcher) element2;
                }
                return null;
            default:
                return obj;
        }
    }
}
