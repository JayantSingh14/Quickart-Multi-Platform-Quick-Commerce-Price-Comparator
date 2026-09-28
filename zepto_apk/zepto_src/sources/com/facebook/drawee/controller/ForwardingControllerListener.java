package com.facebook.drawee.controller;

import android.graphics.drawable.Animatable;
import android.util.Log;
import com.facebook.fresco.ui.common.OnDrawControllerListener;
import java.util.ArrayList;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* loaded from: classes3.dex */
public class ForwardingControllerListener<INFO> implements ControllerListener<INFO>, OnDrawControllerListener<INFO> {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f17280a = new ArrayList(2);

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void a(Object obj, String str) {
        ArrayList arrayList = this.f17280a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = (ControllerListener) arrayList.get(i2);
                if (controllerListener != null) {
                    controllerListener.a(obj, str);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onIntermediateImageSet", e2);
            }
        }
    }

    public final synchronized void b(ControllerListener controllerListener) {
        this.f17280a.add(controllerListener);
    }

    public final synchronized void c(String str, Exception exc) {
        Log.e("FdingControllerListener", str, exc);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final synchronized void e(String str, Throwable th) {
        int size = this.f17280a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.f17280a.get(i2);
                if (controllerListener != null) {
                    controllerListener.e(str, th);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onFailure", e2);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final synchronized void f(String str) {
        int size = this.f17280a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.f17280a.get(i2);
                if (controllerListener != null) {
                    controllerListener.f(str);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onRelease", e2);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final synchronized void l(String str, Object obj, Animatable animatable) {
        int size = this.f17280a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.f17280a.get(i2);
                if (controllerListener != null) {
                    controllerListener.l(str, obj, animatable);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onFinalImageSet", e2);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final synchronized void n(Object obj, String str) {
        int size = this.f17280a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = (ControllerListener) this.f17280a.get(i2);
                if (controllerListener != null) {
                    controllerListener.n(obj, str);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onSubmit", e2);
            }
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public final void q(String str, Throwable th) {
        ArrayList arrayList = this.f17280a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ControllerListener controllerListener = (ControllerListener) arrayList.get(i2);
                if (controllerListener != null) {
                    controllerListener.q(str, th);
                }
            } catch (Exception e2) {
                c("InternalListener exception in onIntermediateImageFailed", e2);
            }
        }
    }
}
