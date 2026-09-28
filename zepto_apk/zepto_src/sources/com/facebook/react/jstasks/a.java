package com.facebook.react.jstasks;

import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19017a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HeadlessJsTaskContext f19018b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f19019c;

    public /* synthetic */ a(HeadlessJsTaskContext headlessJsTaskContext, int i2, int i3) {
        this.f19017a = i3;
        this.f19018b = headlessJsTaskContext;
        this.f19019c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f19019c;
        HeadlessJsTaskContext headlessJsTaskContext = this.f19018b;
        switch (this.f19017a) {
            case 0:
                Iterator it = headlessJsTaskContext.f19011b.iterator();
                while (it.hasNext()) {
                    ((HeadlessJsTaskEventListener) it.next()).b(i2);
                }
                break;
            default:
                WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
                headlessJsTaskContext.b(i2);
                break;
        }
    }
}
