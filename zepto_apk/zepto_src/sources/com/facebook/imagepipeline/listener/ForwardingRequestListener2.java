package com.facebook.imagepipeline.listener;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ForwardingRequestListener2 implements RequestListener2 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f17976a;

    @Metadata
    public static final class Companion {
    }

    public ForwardingRequestListener2(Set set) {
        if (set == null) {
            this.f17976a = new ArrayList();
            return;
        }
        ArrayList destination = new ArrayList(set.size());
        this.f17976a = destination;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        for (Object obj : set) {
            if (obj != null) {
                destination.add(obj);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void a(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter("NetworkFetchProducer", "producerName");
        Intrinsics.checkNotNullParameter("intermediate_result", "producerEventName");
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).a(producerContext);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onIntermediateChunkStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void b(ProducerContext producerContext, String producerName, boolean z) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).b(producerContext, producerName, z);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void c(ProducerContext producerContext, String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).c(producerContext, producerName);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onProducerStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void d(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).d(producerContext);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onRequestSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final boolean e(ProducerContext producerContext, String producerName) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(producerName, "producerName");
        ArrayList arrayList = this.f17976a;
        if (arrayList != null && arrayList.isEmpty()) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (((RequestListener2) it.next()).e(producerContext, producerName)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void f(ProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).f(producerContext);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onRequestCancellation", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void g(ProducerContext producerContext, String str) {
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).g(producerContext, str);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithCancellation", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void h(ProducerContext producerContext, Throwable throwable) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).h(producerContext, throwable);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onRequestFailure", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void i(ProducerContext producerContext, String str, Map map) {
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).i(producerContext, str, map);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithSuccess", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.listener.RequestListener2
    public final void j(SettableProducerContext producerContext) {
        Intrinsics.checkNotNullParameter(producerContext, "producerContext");
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).j(producerContext);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onRequestStart", e2);
            }
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerListener2
    public final void k(ProducerContext producerContext, String str, Throwable th, Map map) {
        Iterator it = this.f17976a.iterator();
        while (it.hasNext()) {
            try {
                ((RequestListener2) it.next()).k(producerContext, str, th, map);
            } catch (Exception e2) {
                FLog.h("ForwardingRequestListener2", "InternalListener exception in onProducerFinishWithFailure", e2);
            }
        }
    }
}
