package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Nullsafe
/* loaded from: classes.dex */
public class ForwardingRequestListener implements RequestListener {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f17975a;

    public ForwardingRequestListener(Set set) {
        this.f17975a = new ArrayList(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            RequestListener requestListener = (RequestListener) it.next();
            if (requestListener != null) {
                this.f17975a.add(requestListener);
            }
        }
    }

    public static void l(String str, Exception exc) {
        FLog.h("ForwardingRequestListener", str, exc);
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final void a(ImageRequest imageRequest, Object obj, String str, boolean z) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).a(imageRequest, obj, str, z);
            } catch (Exception e2) {
                l("InternalListener exception in onRequestStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void b(String str, String str2) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).b(str, str2);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final void c(ImageRequest imageRequest, String str, boolean z) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).c(imageRequest, str, z);
            } catch (Exception e2) {
                l("InternalListener exception in onRequestSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final boolean d(String str) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((RequestListener) arrayList.get(i2)).d(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void e(String str, String str2, Map map) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).e(str, str2, map);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void f(String str, String str2, Throwable th, Map map) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).f(str, str2, th, map);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerFinishWithFailure", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void g(String str, String str2) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).g(str, str2);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerFinishWithCancellation", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void h(String str, String str2, boolean z) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).h(str, str2, z);
            } catch (Exception e2) {
                l("InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener
    public final void i(String str) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).i(str);
            } catch (Exception e2) {
                l("InternalListener exception in onIntermediateChunkStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final void j(ImageRequest imageRequest, String str, Throwable th, boolean z) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).j(imageRequest, str, th, z);
            } catch (Exception e2) {
                l("InternalListener exception in onRequestFailure", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener
    public final void k(String str) {
        ArrayList arrayList = this.f17975a;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                ((RequestListener) arrayList.get(i2)).k(str);
            } catch (Exception e2) {
                l("InternalListener exception in onRequestCancellation", e2);
            }
        }
    }

    public ForwardingRequestListener(RequestListener... requestListenerArr) {
        this.f17975a = new ArrayList(requestListenerArr.length);
        for (RequestListener requestListener : requestListenerArr) {
            if (requestListener != null) {
                this.f17975a.add(requestListener);
            }
        }
    }
}
