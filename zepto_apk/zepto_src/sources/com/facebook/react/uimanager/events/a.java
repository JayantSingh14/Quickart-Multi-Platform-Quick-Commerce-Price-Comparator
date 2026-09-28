package com.facebook.react.uimanager.events;

import android.os.Handler;
import androidx.tracing.Trace;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.uimanager.events.FabricEventDispatcher;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19786a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19787b;

    public /* synthetic */ a(Object obj, int i2) {
        this.f19786a = i2;
        this.f19787b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19786a) {
            case 0:
                Handler handler = FabricEventDispatcher.f19729h;
                ((FabricEventDispatcher) this.f19787b).k();
                return;
            case 1:
                FabricEventDispatcher fabricEventDispatcher = (FabricEventDispatcher) this.f19787b;
                fabricEventDispatcher.f19735f = false;
                Intrinsics.checkNotNullParameter("BatchEventDispatchedListeners", "sectionName");
                Trace.b("BatchEventDispatchedListeners");
                try {
                    Iterator it = fabricEventDispatcher.f19733d.iterator();
                    Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                    while (it.hasNext()) {
                        ((BatchEventDispatchedListener) it.next()).onBatchEventDispatched();
                    }
                    return;
                } finally {
                    android.os.Trace.endSection();
                }
            default:
                FabricEventDispatcher.ScheduleDispatchFrameCallback scheduleDispatchFrameCallback = (FabricEventDispatcher.ScheduleDispatchFrameCallback) this.f19787b;
                if (scheduleDispatchFrameCallback.f19737a) {
                    return;
                }
                scheduleDispatchFrameCallback.f19737a = true;
                ReactChoreographer.Companion.a().b(ReactChoreographer.CallbackType.f19071d, scheduleDispatchFrameCallback.f19739c.f19734e);
                return;
        }
    }
}
