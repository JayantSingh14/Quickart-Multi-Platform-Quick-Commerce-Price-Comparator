package com.bumptech.glide.manager;

import com.bumptech.glide.request.Request;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class RequestTracker {

    /* renamed from: a, reason: collision with root package name */
    public final Set f16419a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f16420b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f16421c;

    public final boolean a(Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean zRemove = this.f16419a.remove(request);
        if (!this.f16420b.remove(request) && !zRemove) {
            z = false;
        }
        if (z) {
            request.clear();
        }
        return z;
    }

    public final String toString() {
        return super.toString() + "{numRequests=" + this.f16419a.size() + ", isPaused=" + this.f16421c + "}";
    }
}
