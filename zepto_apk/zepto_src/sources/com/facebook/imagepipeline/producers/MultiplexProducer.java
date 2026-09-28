package com.facebook.imagepipeline.producers;

import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import com.facebook.common.util.TriState;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.infer.annotation.Nullsafe;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.concurrent.ThreadSafe;
import kotlin.jvm.internal.Intrinsics;

@ThreadSafe
@Nullsafe
/* loaded from: classes3.dex */
public abstract class MultiplexProducer<K, T extends Closeable> implements Producer<T> {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f18240a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final Producer f18241b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18242c;

    /* renamed from: d, reason: collision with root package name */
    public final String f18243d;

    @VisibleForTesting
    public class Multiplexer {

        /* renamed from: a, reason: collision with root package name */
        public final Object f18244a;

        /* renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArraySet f18245b = new CopyOnWriteArraySet();

        /* renamed from: c, reason: collision with root package name */
        public Closeable f18246c;

        /* renamed from: d, reason: collision with root package name */
        public float f18247d;

        /* renamed from: e, reason: collision with root package name */
        public int f18248e;

        /* renamed from: f, reason: collision with root package name */
        public BaseProducerContext f18249f;

        /* renamed from: g, reason: collision with root package name */
        public ForwardingConsumer f18250g;

        public class ForwardingConsumer extends BaseConsumer<T> {
            public ForwardingConsumer() {
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void f() {
                try {
                    FrescoSystrace.a();
                    Multiplexer multiplexer = Multiplexer.this;
                    synchronized (multiplexer) {
                        try {
                            if (multiplexer.f18250g == this) {
                                multiplexer.f18250g = null;
                                multiplexer.f18249f = null;
                                Multiplexer.b(multiplexer.f18246c);
                                multiplexer.f18246c = null;
                                multiplexer.i(TriState.f17145c);
                            }
                        } finally {
                        }
                    }
                } finally {
                    FrescoSystrace.a();
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void g(Throwable th) {
                try {
                    FrescoSystrace.a();
                    Multiplexer.this.f(this, th);
                } finally {
                    FrescoSystrace.a();
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void h(int i2, Object obj) {
                Closeable closeable = (Closeable) obj;
                try {
                    FrescoSystrace.a();
                    Multiplexer.this.g(this, closeable, i2);
                } finally {
                    FrescoSystrace.a();
                }
            }

            @Override // com.facebook.imagepipeline.producers.BaseConsumer
            public final void i(float f2) {
                try {
                    FrescoSystrace.a();
                    Multiplexer.this.h(this, f2);
                } finally {
                    FrescoSystrace.a();
                }
            }
        }

        public Multiplexer(Object obj) {
            this.f18244a = obj;
        }

        public static void b(Closeable closeable) throws IOException {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                }
            }
        }

        public final boolean a(Consumer consumer, ProducerContext producerContext) {
            Multiplexer multiplexer;
            final Pair pairCreate = Pair.create(consumer, producerContext);
            synchronized (this) {
                try {
                    MultiplexProducer multiplexProducer = MultiplexProducer.this;
                    Object obj = this.f18244a;
                    synchronized (multiplexProducer) {
                        multiplexer = (Multiplexer) multiplexProducer.f18240a.get(obj);
                    }
                    if (multiplexer != this) {
                        return false;
                    }
                    this.f18245b.add(pairCreate);
                    ArrayList arrayListK = k();
                    ArrayList arrayListL = l();
                    ArrayList arrayListJ = j();
                    Closeable closeableC = this.f18246c;
                    float f2 = this.f18247d;
                    int i2 = this.f18248e;
                    BaseProducerContext.f(arrayListK);
                    BaseProducerContext.g(arrayListL);
                    BaseProducerContext.d(arrayListJ);
                    synchronized (pairCreate) {
                        try {
                            synchronized (this) {
                                if (closeableC != this.f18246c) {
                                    closeableC = null;
                                } else if (closeableC != null) {
                                    closeableC = MultiplexProducer.this.c(closeableC);
                                }
                            }
                            if (closeableC != null) {
                                if (f2 > 0.0f) {
                                    consumer.c(f2);
                                }
                                consumer.b(i2, closeableC);
                                b(closeableC);
                            }
                        } catch (Throwable th) {
                            throw th;
                        } finally {
                        }
                    }
                    producerContext.b(new BaseProducerContextCallbacks() { // from class: com.facebook.imagepipeline.producers.MultiplexProducer.Multiplexer.1
                        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                        public final void a() {
                            BaseProducerContext.d(Multiplexer.this.j());
                        }

                        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                        public final void b() {
                            boolean zRemove;
                            ArrayList arrayList;
                            BaseProducerContext baseProducerContext;
                            ArrayList arrayListL2;
                            ArrayList arrayListJ2;
                            synchronized (Multiplexer.this) {
                                try {
                                    zRemove = Multiplexer.this.f18245b.remove(pairCreate);
                                    arrayList = null;
                                    if (!zRemove) {
                                        baseProducerContext = null;
                                        arrayListL2 = null;
                                    } else if (Multiplexer.this.f18245b.isEmpty()) {
                                        baseProducerContext = Multiplexer.this.f18249f;
                                        arrayListL2 = null;
                                    } else {
                                        ArrayList arrayListK2 = Multiplexer.this.k();
                                        arrayListL2 = Multiplexer.this.l();
                                        arrayListJ2 = Multiplexer.this.j();
                                        baseProducerContext = null;
                                        arrayList = arrayListK2;
                                    }
                                    arrayListJ2 = arrayListL2;
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                            BaseProducerContext.f(arrayList);
                            BaseProducerContext.g(arrayListL2);
                            BaseProducerContext.d(arrayListJ2);
                            if (baseProducerContext != null) {
                                MultiplexProducer.this.getClass();
                                baseProducerContext.h();
                            }
                            if (zRemove) {
                                ((Consumer) pairCreate.first).a();
                            }
                        }

                        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                        public final void c() {
                            BaseProducerContext.g(Multiplexer.this.l());
                        }

                        @Override // com.facebook.imagepipeline.producers.BaseProducerContextCallbacks, com.facebook.imagepipeline.producers.ProducerContextCallbacks
                        public final void d() {
                            BaseProducerContext.f(Multiplexer.this.k());
                        }
                    });
                    return true;
                } finally {
                }
            }
        }

        public final synchronized boolean c() {
            Iterator it = this.f18245b.iterator();
            while (it.hasNext()) {
                if (((ProducerContext) ((Pair) it.next()).second).x()) {
                    return true;
                }
            }
            return false;
        }

        public final synchronized boolean d() {
            Iterator it = this.f18245b.iterator();
            while (it.hasNext()) {
                if (!((ProducerContext) ((Pair) it.next()).second).O()) {
                    return false;
                }
            }
            return true;
        }

        public final synchronized Priority e() {
            Priority priority1;
            priority1 = Priority.f17782b;
            Iterator it = this.f18245b.iterator();
            while (it.hasNext()) {
                Priority priority2 = ((ProducerContext) ((Pair) it.next()).second).A();
                Priority.f17781a.getClass();
                Intrinsics.checkNotNullParameter(priority1, "priority1");
                Intrinsics.checkNotNullParameter(priority2, "priority2");
                if (priority1.ordinal() <= priority2.ordinal()) {
                    priority1 = priority2;
                }
            }
            return priority1;
        }

        public final void f(ForwardingConsumer forwardingConsumer, Throwable th) {
            synchronized (this) {
                try {
                    if (this.f18250g != forwardingConsumer) {
                        return;
                    }
                    Iterator it = this.f18245b.iterator();
                    this.f18245b.clear();
                    MultiplexProducer.this.e(this.f18244a, this);
                    b(this.f18246c);
                    this.f18246c = null;
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        synchronized (pair) {
                            try {
                                ((ProducerContext) pair.second).s().k((ProducerContext) pair.second, MultiplexProducer.this.f18242c, th, null);
                                BaseProducerContext baseProducerContext = this.f18249f;
                                if (baseProducerContext != null) {
                                    ((ProducerContext) pair.second).N(baseProducerContext.f18096g);
                                }
                                ((Consumer) pair.first).onFailure(th);
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public final void g(ForwardingConsumer forwardingConsumer, Closeable closeable, int i2) {
            synchronized (this) {
                try {
                    if (this.f18250g != forwardingConsumer) {
                        return;
                    }
                    b(this.f18246c);
                    this.f18246c = null;
                    Iterator it = this.f18245b.iterator();
                    int size = this.f18245b.size();
                    if (BaseConsumer.e(i2)) {
                        this.f18246c = MultiplexProducer.this.c(closeable);
                        this.f18248e = i2;
                    } else {
                        this.f18245b.clear();
                        MultiplexProducer.this.e(this.f18244a, this);
                    }
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        synchronized (pair) {
                            try {
                                if (BaseConsumer.d(i2)) {
                                    ((ProducerContext) pair.second).s().i((ProducerContext) pair.second, MultiplexProducer.this.f18242c, null);
                                    BaseProducerContext baseProducerContext = this.f18249f;
                                    if (baseProducerContext != null) {
                                        ((ProducerContext) pair.second).N(baseProducerContext.f18096g);
                                    }
                                    ((ProducerContext) pair.second).V(Integer.valueOf(size), MultiplexProducer.this.f18243d);
                                }
                                ((Consumer) pair.first).b(i2, closeable);
                            } finally {
                            }
                        }
                    }
                } finally {
                }
            }
        }

        public final void h(ForwardingConsumer forwardingConsumer, float f2) {
            synchronized (this) {
                try {
                    if (this.f18250g != forwardingConsumer) {
                        return;
                    }
                    this.f18247d = f2;
                    Iterator it = this.f18245b.iterator();
                    while (it.hasNext()) {
                        Pair pair = (Pair) it.next();
                        synchronized (pair) {
                            ((Consumer) pair.first).c(f2);
                        }
                    }
                } finally {
                }
            }
        }

        public final void i(TriState triState) {
            synchronized (this) {
                try {
                    boolean z = false;
                    if (!(this.f18249f == null)) {
                        throw new IllegalArgumentException();
                    }
                    if (!(this.f18250g == null)) {
                        throw new IllegalArgumentException();
                    }
                    if (this.f18245b.isEmpty()) {
                        MultiplexProducer.this.e(this.f18244a, this);
                        return;
                    }
                    ProducerContext producerContext = (ProducerContext) ((Pair) this.f18245b.iterator().next()).second;
                    BaseProducerContext baseProducerContext = new BaseProducerContext(producerContext.D(), producerContext.getId(), null, producerContext.s(), producerContext.a(), producerContext.Z(), d(), c(), e(), producerContext.c());
                    this.f18249f = baseProducerContext;
                    baseProducerContext.N(producerContext.getExtras());
                    if (triState != TriState.f17145c) {
                        BaseProducerContext baseProducerContext2 = this.f18249f;
                        int iOrdinal = triState.ordinal();
                        if (iOrdinal == 0) {
                            z = true;
                        } else if (iOrdinal != 1) {
                            if (iOrdinal == 2) {
                                throw new IllegalStateException("No boolean equivalent for UNSET");
                            }
                            throw new IllegalStateException("Unrecognized TriState value: " + triState);
                        }
                        baseProducerContext2.V(Boolean.valueOf(z), "started_as_prefetch");
                    }
                    ForwardingConsumer forwardingConsumer = new ForwardingConsumer();
                    this.f18250g = forwardingConsumer;
                    MultiplexProducer.this.f18241b.b(forwardingConsumer, this.f18249f);
                } finally {
                }
            }
        }

        public final synchronized ArrayList j() {
            BaseProducerContext baseProducerContext = this.f18249f;
            ArrayList arrayList = null;
            if (baseProducerContext == null) {
                return null;
            }
            boolean zC = c();
            synchronized (baseProducerContext) {
                if (zC != baseProducerContext.f18099j) {
                    baseProducerContext.f18099j = zC;
                    arrayList = new ArrayList(baseProducerContext.f18101l);
                }
            }
            return arrayList;
        }

        public final synchronized ArrayList k() {
            BaseProducerContext baseProducerContext = this.f18249f;
            ArrayList arrayList = null;
            if (baseProducerContext == null) {
                return null;
            }
            boolean zD = d();
            synchronized (baseProducerContext) {
                if (zD != baseProducerContext.f18097h) {
                    baseProducerContext.f18097h = zD;
                    arrayList = new ArrayList(baseProducerContext.f18101l);
                }
            }
            return arrayList;
        }

        public final synchronized ArrayList l() {
            ArrayList arrayList;
            BaseProducerContext baseProducerContext = this.f18249f;
            if (baseProducerContext == null) {
                return null;
            }
            Priority priorityE = e();
            synchronized (baseProducerContext) {
                if (priorityE == baseProducerContext.f18098i) {
                    arrayList = null;
                } else {
                    baseProducerContext.f18098i = priorityE;
                    arrayList = new ArrayList(baseProducerContext.f18101l);
                }
            }
            return arrayList;
        }
    }

    public MultiplexProducer(Producer producer, String str, String str2) {
        this.f18241b = producer;
        this.f18242c = str;
        this.f18243d = str2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public final void b(Consumer consumer, ProducerContext producerContext) {
        Multiplexer multiplexer;
        boolean z;
        try {
            FrescoSystrace.a();
            producerContext.s().c(producerContext, this.f18242c);
            Pair pairD = d(producerContext);
            do {
                synchronized (this) {
                    synchronized (this) {
                        multiplexer = (Multiplexer) this.f18240a.get(pairD);
                    }
                }
                if (multiplexer == null) {
                    synchronized (this) {
                        multiplexer = new Multiplexer(pairD);
                        this.f18240a.put(pairD, multiplexer);
                        z = true;
                    }
                } else {
                    z = false;
                }
            } while (!multiplexer.a(consumer, producerContext));
            if (z) {
                multiplexer.i(producerContext.O() ? TriState.f17143a : TriState.f17144b);
            }
        } finally {
            FrescoSystrace.a();
        }
    }

    public abstract Closeable c(Closeable closeable);

    public abstract Pair d(ProducerContext producerContext);

    public final synchronized void e(Object obj, Multiplexer multiplexer) {
        if (this.f18240a.get(obj) == multiplexer) {
            this.f18240a.remove(obj);
        }
    }
}
