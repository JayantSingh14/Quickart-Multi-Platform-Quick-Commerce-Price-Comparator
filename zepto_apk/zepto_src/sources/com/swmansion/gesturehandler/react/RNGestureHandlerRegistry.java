package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.GestureHandlerRegistry;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class RNGestureHandlerRegistry implements GestureHandlerRegistry {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f46842a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f46843b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f46844c = new SparseArray();

    public final synchronized boolean a(int i2, int i3, int i4) {
        boolean z;
        GestureHandler gestureHandler = (GestureHandler) this.f46842a.get(i2);
        if (gestureHandler != null) {
            b(gestureHandler);
            gestureHandler.f46724k = i4;
            g(i3, gestureHandler);
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    public final synchronized void b(GestureHandler gestureHandler) {
        try {
            Integer num = (Integer) this.f46843b.get(gestureHandler.f46717d);
            if (num != null) {
                this.f46843b.remove(gestureHandler.f46717d);
                ArrayList arrayList = (ArrayList) this.f46844c.get(num.intValue());
                if (arrayList != null) {
                    synchronized (arrayList) {
                        arrayList.remove(gestureHandler);
                    }
                    if (arrayList.size() == 0) {
                        this.f46844c.remove(num.intValue());
                    }
                }
            }
            if (gestureHandler.f46718e != null) {
                UiThreadUtil.runOnUiThread(new com.swmansion.gesturehandler.core.a(1, gestureHandler));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void c(int i2) {
        GestureHandler gestureHandler = (GestureHandler) this.f46842a.get(i2);
        if (gestureHandler != null) {
            b(gestureHandler);
            this.f46842a.remove(i2);
        }
    }

    public final synchronized GestureHandler d(int i2) {
        return (GestureHandler) this.f46842a.get(i2);
    }

    public final synchronized ArrayList e(View view) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        synchronized (this) {
            arrayList = (ArrayList) this.f46844c.get(id);
        }
        return arrayList;
        return arrayList;
    }

    public final synchronized void f(GestureHandler handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f46842a.put(handler.f46717d, handler);
    }

    public final synchronized void g(int i2, GestureHandler gestureHandler) {
        try {
            if (this.f46843b.get(gestureHandler.f46717d) != null) {
                throw new IllegalStateException(("Handler " + gestureHandler + " already attached").toString());
            }
            this.f46843b.put(gestureHandler.f46717d, Integer.valueOf(i2));
            Object obj = this.f46844c.get(i2);
            if (obj == null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(gestureHandler);
                this.f46844c.put(i2, arrayList);
            } else {
                synchronized (obj) {
                    ((ArrayList) obj).add(gestureHandler);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
