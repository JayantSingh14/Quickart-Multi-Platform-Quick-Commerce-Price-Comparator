package com.facebook.react.runtime;

import androidx.tracing.Trace;
import com.facebook.react.internal.turbomodule.core.TurboModuleManager;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19355a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19356b;

    public /* synthetic */ q(Object obj, int i2) {
        this.f19355a = i2;
        this.f19356b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19355a) {
            case 0:
                boolean z = ReactInstance.f19261h;
                ReactInstance reactInstance = (ReactInstance) this.f19356b;
                reactInstance.getClass();
                Intrinsics.checkNotNullParameter("initializeEagerTurboModules", "sectionName");
                Trace.b("initializeEagerTurboModules");
                TurboModuleManager turboModuleManager = reactInstance.f19264c;
                Iterator<String> it = turboModuleManager.getEagerInitModuleNames().iterator();
                while (it.hasNext()) {
                    turboModuleManager.getModule(it.next());
                }
                android.os.Trace.endSection();
                break;
            default:
                ReactSurfaceView reactSurfaceView = (ReactSurfaceView) ((ReactSurfaceImpl) this.f19356b).getView();
                if (reactSurfaceView != null) {
                    reactSurfaceView.removeAllViews();
                    reactSurfaceView.setId(-1);
                    break;
                }
                break;
        }
    }
}
