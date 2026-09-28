package androidx.work;

import android.content.Context;
import androidx.startup.Initializer;
import androidx.work.Configuration;
import androidx.work.impl.WorkManagerImpl;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class WorkManagerInitializer implements Initializer<WorkManager> {

    /* renamed from: a, reason: collision with root package name */
    public static final String f12574a = Logger.g("WrkMgrInitializer");

    @Override // androidx.startup.Initializer
    public final List a() {
        return Collections.EMPTY_LIST;
    }

    @Override // androidx.startup.Initializer
    public final Object b(Context context) {
        Logger.e().a(f12574a, "Initializing WorkManager with default configuration.");
        WorkManagerImpl.g(context, new Configuration(new Configuration.Builder()));
        return WorkManagerImpl.f(context);
    }
}
