package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;

@Nullsafe
/* loaded from: classes.dex */
class DeferredReleaserConcurrentImpl extends DeferredReleaser {

    /* renamed from: b, reason: collision with root package name */
    public final Object f17224b = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final Runnable f17228f = new Runnable() { // from class: com.facebook.drawee.components.DeferredReleaserConcurrentImpl.1
        @Override // java.lang.Runnable
        public final void run() {
            ArrayList arrayList;
            synchronized (DeferredReleaserConcurrentImpl.this.f17224b) {
                DeferredReleaserConcurrentImpl deferredReleaserConcurrentImpl = DeferredReleaserConcurrentImpl.this;
                ArrayList arrayList2 = deferredReleaserConcurrentImpl.f17227e;
                arrayList = deferredReleaserConcurrentImpl.f17226d;
                deferredReleaserConcurrentImpl.f17227e = arrayList;
                deferredReleaserConcurrentImpl.f17226d = arrayList2;
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((DeferredReleaser.Releasable) DeferredReleaserConcurrentImpl.this.f17227e.get(i2)).release();
            }
            DeferredReleaserConcurrentImpl.this.f17227e.clear();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f17226d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f17227e = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Handler f17225c = new Handler(Looper.getMainLooper());

    @Override // com.facebook.drawee.components.DeferredReleaser
    public final void a(AbstractDraweeController abstractDraweeController) {
        synchronized (this.f17224b) {
            this.f17226d.remove(abstractDraweeController);
        }
    }

    @Override // com.facebook.drawee.components.DeferredReleaser
    public final void c(AbstractDraweeController abstractDraweeController) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            abstractDraweeController.release();
            return;
        }
        synchronized (this.f17224b) {
            try {
                if (this.f17226d.contains(abstractDraweeController)) {
                    return;
                }
                this.f17226d.add(abstractDraweeController);
                boolean z = true;
                if (this.f17226d.size() != 1) {
                    z = false;
                }
                if (z) {
                    this.f17225c.post(this.f17228f);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
