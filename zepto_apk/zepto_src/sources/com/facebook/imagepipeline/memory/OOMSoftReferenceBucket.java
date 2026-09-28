package com.facebook.imagepipeline.memory;

import com.facebook.common.references.OOMSoftReference;
import com.facebook.infer.annotation.Nullsafe;
import java.lang.ref.SoftReference;
import java.util.LinkedList;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
class OOMSoftReferenceBucket<V> extends Bucket<V> {

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f18038e;

    @Override // com.facebook.imagepipeline.memory.Bucket
    public final void a(Object obj) {
        OOMSoftReference oOMSoftReference = (OOMSoftReference) this.f18038e.poll();
        if (oOMSoftReference == null) {
            oOMSoftReference = new OOMSoftReference();
        }
        oOMSoftReference.f17113a = new SoftReference(obj);
        oOMSoftReference.f17114b = new SoftReference(obj);
        oOMSoftReference.f17115c = new SoftReference(obj);
        this.f18004c.add(oOMSoftReference);
    }

    @Override // com.facebook.imagepipeline.memory.Bucket
    public final Object b() {
        OOMSoftReference oOMSoftReference = (OOMSoftReference) this.f18004c.poll();
        oOMSoftReference.getClass();
        SoftReference softReference = oOMSoftReference.f17113a;
        Object obj = softReference == null ? null : softReference.get();
        SoftReference softReference2 = oOMSoftReference.f17113a;
        if (softReference2 != null) {
            softReference2.clear();
            oOMSoftReference.f17113a = null;
        }
        SoftReference softReference3 = oOMSoftReference.f17114b;
        if (softReference3 != null) {
            softReference3.clear();
            oOMSoftReference.f17114b = null;
        }
        SoftReference softReference4 = oOMSoftReference.f17115c;
        if (softReference4 != null) {
            softReference4.clear();
            oOMSoftReference.f17115c = null;
        }
        this.f18038e.add(oOMSoftReference);
        return obj;
    }
}
