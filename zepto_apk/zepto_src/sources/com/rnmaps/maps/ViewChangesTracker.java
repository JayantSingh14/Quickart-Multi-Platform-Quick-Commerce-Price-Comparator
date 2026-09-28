package com.rnmaps.maps;

import android.os.Handler;
import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes4.dex */
public class ViewChangesTracker {

    /* renamed from: f, reason: collision with root package name */
    public static ViewChangesTracker f46666f;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedList f46668b = new LinkedList();

    /* renamed from: c, reason: collision with root package name */
    public boolean f46669c = false;

    /* renamed from: e, reason: collision with root package name */
    public final LinkedList f46671e = new LinkedList();

    /* renamed from: a, reason: collision with root package name */
    public final Handler f46667a = new Handler(Looper.myLooper());

    /* renamed from: d, reason: collision with root package name */
    public final Runnable f46670d = new Runnable() { // from class: com.rnmaps.maps.ViewChangesTracker.1
        @Override // java.lang.Runnable
        public final void run() {
            LinkedList linkedList;
            ViewChangesTracker viewChangesTracker = ViewChangesTracker.this;
            LinkedList linkedList2 = viewChangesTracker.f46668b;
            Iterator it = linkedList2.iterator();
            while (true) {
                boolean zHasNext = it.hasNext();
                linkedList = viewChangesTracker.f46671e;
                if (!zHasNext) {
                    break;
                }
                MapMarker mapMarker = (MapMarker) it.next();
                if (mapMarker.A) {
                    mapMarker.m();
                } else {
                    linkedList.add(mapMarker);
                }
            }
            if (linkedList.size() > 0) {
                linkedList2.removeAll(linkedList);
                linkedList.clear();
            }
            if (viewChangesTracker.f46668b.size() > 0) {
                viewChangesTracker.f46667a.postDelayed(viewChangesTracker.f46670d, 40L);
            } else {
                viewChangesTracker.f46669c = false;
            }
        }
    };

    public static ViewChangesTracker b() {
        if (f46666f == null) {
            synchronized (ViewChangesTracker.class) {
                f46666f = new ViewChangesTracker();
            }
        }
        return f46666f;
    }

    public final void a(MapMarker mapMarker) {
        this.f46668b.add(mapMarker);
        if (this.f46669c) {
            return;
        }
        this.f46669c = true;
        this.f46667a.postDelayed(this.f46670d, 40L);
    }

    public final void c(MapMarker mapMarker) {
        this.f46668b.remove(mapMarker);
    }
}
