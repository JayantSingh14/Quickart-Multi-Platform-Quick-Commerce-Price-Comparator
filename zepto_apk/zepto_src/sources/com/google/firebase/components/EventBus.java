package com.google.firebase.components;

import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.messaging.n;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class EventBus implements Subscriber, Publisher {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f43591a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public ArrayDeque f43592b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public final UiExecutor f43593c;

    public EventBus(UiExecutor uiExecutor) {
        this.f43593c = uiExecutor;
    }

    @Override // com.google.firebase.events.Subscriber
    public final synchronized void a(n nVar) {
        nVar.getClass();
        if (this.f43591a.containsKey(DataCollectionDefaultChange.class)) {
            ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f43591a.get(DataCollectionDefaultChange.class);
            concurrentHashMap.remove(nVar);
            if (concurrentHashMap.isEmpty()) {
                this.f43591a.remove(DataCollectionDefaultChange.class);
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public final void b(n nVar) {
        d(this.f43593c, nVar);
    }

    @Override // com.google.firebase.events.Publisher
    public final void c(Event event) {
        Set<Map.Entry> setEntrySet;
        event.getClass();
        synchronized (this) {
            try {
                ArrayDeque arrayDeque = this.f43592b;
                if (arrayDeque != null) {
                    arrayDeque.add(event);
                    return;
                }
                synchronized (this) {
                    try {
                        Map map = (Map) this.f43591a.get(DataCollectionDefaultChange.class);
                        setEntrySet = map == null ? Collections.EMPTY_SET : map.entrySet();
                    } finally {
                    }
                }
                for (Map.Entry entry : setEntrySet) {
                    ((Executor) entry.getValue()).execute(new androidx.constraintlayout.motion.widget.a(25, entry, event));
                }
            } finally {
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    public final synchronized void d(Executor executor, EventHandler eventHandler) {
        try {
            executor.getClass();
            if (!this.f43591a.containsKey(DataCollectionDefaultChange.class)) {
                this.f43591a.put(DataCollectionDefaultChange.class, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.f43591a.get(DataCollectionDefaultChange.class)).put(eventHandler, executor);
        } catch (Throwable th) {
            throw th;
        }
    }
}
