package com.google.android.play.core.splitinstall.internal;

import com.google.android.play.core.listener.StateUpdatedListener;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzt {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f41997a = new HashSet();

    public final synchronized void a(Object obj) {
        Iterator it = this.f41997a.iterator();
        while (it.hasNext()) {
            ((StateUpdatedListener) it.next()).onStateUpdate(obj);
        }
    }
}
