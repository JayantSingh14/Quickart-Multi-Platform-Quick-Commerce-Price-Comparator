package com.google.firebase.crashlytics.internal.persistence;

import android.graphics.PointF;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerOrchestrator;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f44391a;

    public /* synthetic */ a(int i2) {
        this.f44391a = i2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        boolean z;
        switch (this.f44391a) {
            case 0:
                Charset charset = CrashlyticsReportPersistence.f44375e;
                return ((File) obj2).getName().compareTo(((File) obj).getName());
            default:
                GestureHandler gestureHandler = (GestureHandler) obj;
                GestureHandler gestureHandler2 = (GestureHandler) obj2;
                PointF pointF = GestureHandlerOrchestrator.f46732m;
                boolean z2 = gestureHandler.G;
                if ((z2 && gestureHandler2.G) || ((z = gestureHandler.H) && gestureHandler2.H)) {
                    return Integer.signum(gestureHandler2.F - gestureHandler.F);
                }
                if (!z2) {
                    if (!gestureHandler2.G) {
                        if (!z) {
                            if (!gestureHandler2.H) {
                                return 0;
                            }
                        }
                    }
                    return 1;
                }
                return -1;
        }
    }
}
