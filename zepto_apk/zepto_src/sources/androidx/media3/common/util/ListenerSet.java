package androidx.media3.common.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.common.FlagSet;
import androidx.media3.common.util.ListenerSet;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

@UnstableApi
/* loaded from: classes3.dex */
public final class ListenerSet<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Clock f5687a;

    /* renamed from: b, reason: collision with root package name */
    public final HandlerWrapper f5688b;

    /* renamed from: c, reason: collision with root package name */
    public final IterationFinishedEvent f5689c;

    /* renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArraySet f5690d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayDeque f5691e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayDeque f5692f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f5693g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f5694h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f5695i;

    public interface Event<T> {
        void invoke(Object obj);
    }

    public interface IterationFinishedEvent<T> {
        void c(Object obj, FlagSet flagSet);
    }

    public static final class ListenerHolder<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f5696a;

        /* renamed from: b, reason: collision with root package name */
        public FlagSet.Builder f5697b = new FlagSet.Builder();

        /* renamed from: c, reason: collision with root package name */
        public boolean f5698c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f5699d;

        public ListenerHolder(Object obj) {
            this.f5696a = obj;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ListenerHolder.class != obj.getClass()) {
                return false;
            }
            return this.f5696a.equals(((ListenerHolder) obj).f5696a);
        }

        public final int hashCode() {
            return this.f5696a.hashCode();
        }
    }

    public ListenerSet(Looper looper, Clock clock, IterationFinishedEvent iterationFinishedEvent) {
        this(new CopyOnWriteArraySet(), looper, clock, iterationFinishedEvent, true);
    }

    public final void a(Object obj) {
        obj.getClass();
        synchronized (this.f5693g) {
            try {
                if (this.f5694h) {
                    return;
                }
                this.f5690d.add(new ListenerHolder(obj));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        g();
        ArrayDeque arrayDeque = this.f5692f;
        if (arrayDeque.isEmpty()) {
            return;
        }
        HandlerWrapper handlerWrapper = this.f5688b;
        if (!handlerWrapper.a()) {
            handlerWrapper.h(handlerWrapper.c(1));
        }
        ArrayDeque arrayDeque2 = this.f5691e;
        boolean zIsEmpty = arrayDeque2.isEmpty();
        arrayDeque2.addAll(arrayDeque);
        arrayDeque.clear();
        if (zIsEmpty) {
            while (!arrayDeque2.isEmpty()) {
                ((Runnable) arrayDeque2.peekFirst()).run();
                arrayDeque2.removeFirst();
            }
        }
    }

    public final void c(final int i2, final Event event) {
        g();
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f5690d);
        this.f5692f.add(new Runnable() { // from class: androidx.media3.common.util.a
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it = copyOnWriteArraySet.iterator();
                while (it.hasNext()) {
                    ListenerSet.ListenerHolder listenerHolder = (ListenerSet.ListenerHolder) it.next();
                    if (!listenerHolder.f5699d) {
                        int i3 = i2;
                        if (i3 != -1) {
                            listenerHolder.f5697b.a(i3);
                        }
                        listenerHolder.f5698c = true;
                        event.invoke(listenerHolder.f5696a);
                    }
                }
            }
        });
    }

    public final void d() {
        g();
        synchronized (this.f5693g) {
            this.f5694h = true;
        }
        Iterator it = this.f5690d.iterator();
        while (it.hasNext()) {
            ListenerHolder listenerHolder = (ListenerHolder) it.next();
            IterationFinishedEvent iterationFinishedEvent = this.f5689c;
            listenerHolder.f5699d = true;
            if (listenerHolder.f5698c) {
                listenerHolder.f5698c = false;
                iterationFinishedEvent.c(listenerHolder.f5696a, listenerHolder.f5697b.c());
            }
        }
        this.f5690d.clear();
    }

    public final void e(Object obj) {
        g();
        CopyOnWriteArraySet copyOnWriteArraySet = this.f5690d;
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ListenerHolder listenerHolder = (ListenerHolder) it.next();
            if (listenerHolder.f5696a.equals(obj)) {
                listenerHolder.f5699d = true;
                if (listenerHolder.f5698c) {
                    listenerHolder.f5698c = false;
                    FlagSet flagSetC = listenerHolder.f5697b.c();
                    this.f5689c.c(listenerHolder.f5696a, flagSetC);
                }
                copyOnWriteArraySet.remove(listenerHolder);
            }
        }
    }

    public final void f(int i2, Event event) {
        c(i2, event);
        b();
    }

    public final void g() {
        if (this.f5695i) {
            Assertions.g(Thread.currentThread() == this.f5688b.f().getThread());
        }
    }

    public ListenerSet(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, Clock clock, IterationFinishedEvent iterationFinishedEvent, boolean z) {
        this.f5687a = clock;
        this.f5690d = copyOnWriteArraySet;
        this.f5689c = iterationFinishedEvent;
        this.f5693g = new Object();
        this.f5691e = new ArrayDeque();
        this.f5692f = new ArrayDeque();
        this.f5688b = clock.a(looper, new Handler.Callback() { // from class: androidx.media3.common.util.b
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                ListenerSet listenerSet = this.f5760a;
                Iterator it = listenerSet.f5690d.iterator();
                while (it.hasNext()) {
                    ListenerSet.ListenerHolder listenerHolder = (ListenerSet.ListenerHolder) it.next();
                    if (!listenerHolder.f5699d && listenerHolder.f5698c) {
                        FlagSet flagSetC = listenerHolder.f5697b.c();
                        listenerHolder.f5697b = new FlagSet.Builder();
                        listenerHolder.f5698c = false;
                        listenerSet.f5689c.c(listenerHolder.f5696a, flagSetC);
                    }
                    if (listenerSet.f5688b.a()) {
                        return true;
                    }
                }
                return true;
            }
        });
        this.f5695i = z;
    }
}
