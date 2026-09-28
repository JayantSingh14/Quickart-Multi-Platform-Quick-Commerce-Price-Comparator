package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableSet;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.core.ImagePipelineConfigInterface;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.infer.annotation.Nullsafe;
import in.juspay.hypersdk.analytics.LogConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Nullsafe
/* loaded from: classes3.dex */
public class BaseProducerContext implements ProducerContext {
    public static final ImmutableSet n;
    public static final Object o;

    /* renamed from: a, reason: collision with root package name */
    public final ImageRequest f18090a;

    /* renamed from: b, reason: collision with root package name */
    public final String f18091b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18092c;

    /* renamed from: d, reason: collision with root package name */
    public final ProducerListener2 f18093d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f18094e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageRequest.RequestLevel f18095f;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap f18096g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f18097h;

    /* renamed from: i, reason: collision with root package name */
    public Priority f18098i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f18099j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f18100k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f18101l;

    /* renamed from: m, reason: collision with root package name */
    public final ImagePipelineConfigInterface f18102m;

    static {
        String[] strArr = {CLConstants.SHARED_PREFERENCE_ITEM_ID, "uri_source"};
        int i2 = ImmutableSet.f17077a;
        HashSet hashSet = new HashSet(2);
        Collections.addAll(hashSet, strArr);
        n = new ImmutableSet(hashSet);
        o = new Object();
    }

    public BaseProducerContext(ImageRequest imageRequest, String str, String str2, ProducerListener2 producerListener2, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority, ImagePipelineConfigInterface imagePipelineConfigInterface) {
        this.f18090a = imageRequest;
        this.f18091b = str;
        HashMap map = new HashMap();
        this.f18096g = map;
        map.put(CLConstants.SHARED_PREFERENCE_ITEM_ID, str);
        map.put("uri_source", imageRequest == null ? "null-request" : imageRequest.f18348b);
        this.f18092c = str2;
        this.f18093d = producerListener2;
        this.f18094e = obj == null ? o : obj;
        this.f18095f = requestLevel;
        this.f18097h = z;
        this.f18098i = priority;
        this.f18099j = z2;
        this.f18100k = false;
        this.f18101l = new ArrayList();
        this.f18102m = imagePipelineConfigInterface;
    }

    public static void d(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ProducerContextCallbacks) it.next()).a();
        }
    }

    public static void f(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ProducerContextCallbacks) it.next()).d();
        }
    }

    public static void g(ArrayList arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ProducerContextCallbacks) it.next()).c();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final synchronized Priority A() {
        return this.f18098i;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final ImageRequest D() {
        return this.f18090a;
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public final void N(Map map) {
        if (map == null) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            V(entry.getValue(), (String) entry.getKey());
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final synchronized boolean O() {
        return this.f18097h;
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public final Object T(String str) {
        return this.f18096g.get(str);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public final void V(Object obj, String str) {
        if (n.contains(str)) {
            return;
        }
        this.f18096g.put(str, obj);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final ImageRequest.RequestLevel Z() {
        return this.f18095f;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final Object a() {
        return this.f18094e;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final void b(BaseProducerContextCallbacks baseProducerContextCallbacks) {
        boolean z;
        synchronized (this) {
            this.f18101l.add(baseProducerContextCallbacks);
            z = this.f18100k;
        }
        if (z) {
            baseProducerContextCallbacks.b();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final ImagePipelineConfigInterface c() {
        return this.f18102m;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final void e(String str, String str2) {
        HashMap map = this.f18096g;
        map.put("origin", str);
        map.put("origin_sub", str2);
    }

    @Override // com.facebook.fresco.middleware.HasExtraData
    public final Map getExtras() {
        return this.f18096g;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final String getId() {
        return this.f18091b;
    }

    public final void h() {
        ArrayList arrayList;
        synchronized (this) {
            if (this.f18100k) {
                arrayList = null;
            } else {
                this.f18100k = true;
                arrayList = new ArrayList(this.f18101l);
            }
        }
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((ProducerContextCallbacks) it.next()).b();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final String l() {
        return this.f18092c;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final void r(String str) {
        e(str, LogConstants.DEFAULT_CHANNEL);
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final ProducerListener2 s() {
        return this.f18093d;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public final synchronized boolean x() {
        return this.f18099j;
    }
}
