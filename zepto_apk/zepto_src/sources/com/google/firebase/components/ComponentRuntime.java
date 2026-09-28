package com.google.firebase.components;

import android.util.Log;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class ComponentRuntime implements ComponentContainer, ComponentLoader {

    /* renamed from: h, reason: collision with root package name */
    public static final b f43571h = new b(0);

    /* renamed from: e, reason: collision with root package name */
    public final EventBus f43576e;

    /* renamed from: g, reason: collision with root package name */
    public final ComponentRegistrarProcessor f43578g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f43572a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f43573b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f43574c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f43575d = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public final AtomicReference f43577f = new AtomicReference();

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        public final UiExecutor f43579a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList f43580b;

        /* renamed from: c, reason: collision with root package name */
        public final ArrayList f43581c;

        /* renamed from: d, reason: collision with root package name */
        public ComponentRegistrarProcessor f43582d;

        public Builder() {
            UiExecutor uiExecutor = UiExecutor.f43653a;
            this.f43580b = new ArrayList();
            this.f43581c = new ArrayList();
            this.f43582d = ComponentRegistrarProcessor.w0;
            this.f43579a = uiExecutor;
        }
    }

    public ComponentRuntime(UiExecutor uiExecutor, List list, List list2, ComponentRegistrarProcessor componentRegistrarProcessor) {
        EventBus eventBus = new EventBus(uiExecutor);
        this.f43576e = eventBus;
        this.f43578g = componentRegistrarProcessor;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.c(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        arrayList.add(Component.c(this, ComponentLoader.class, new Class[0]));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component != null) {
                arrayList.add(component);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(it2.next());
        }
        ArrayList arrayList3 = new ArrayList();
        synchronized (this) {
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = (ComponentRegistrar) ((Provider) it3.next()).get();
                    if (componentRegistrar != null) {
                        arrayList.addAll(this.f43578g.b(componentRegistrar));
                        it3.remove();
                    }
                } catch (InvalidRegistrarException e2) {
                    it3.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e2);
                }
            }
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                Object[] array = ((Component) it4.next()).f43557b.toArray();
                int length = array.length;
                int i2 = 0;
                while (true) {
                    if (i2 < length) {
                        Object obj = array[i2];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f43575d.contains(obj.toString())) {
                                it4.remove();
                                break;
                            }
                            this.f43575d.add(obj.toString());
                        }
                        i2++;
                    }
                }
            }
            if (this.f43572a.isEmpty()) {
                CycleDetector.a(arrayList);
            } else {
                ArrayList arrayList4 = new ArrayList(this.f43572a.keySet());
                arrayList4.addAll(arrayList);
                CycleDetector.a(arrayList4);
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                final Component component2 = (Component) it5.next();
                this.f43572a.put(component2, new Lazy(new Provider() { // from class: com.google.firebase.components.c
                    @Override // com.google.firebase.inject.Provider
                    public final Object get() {
                        ComponentRuntime componentRuntime = this.f43617a;
                        componentRuntime.getClass();
                        Component component3 = component2;
                        return component3.f43561f.c(new RestrictedComponentContainer(component3, componentRuntime));
                    }
                }));
            }
            arrayList3.addAll(l(arrayList));
            arrayList3.addAll(m());
            k();
        }
        Iterator it6 = arrayList3.iterator();
        while (it6.hasNext()) {
            ((Runnable) it6.next()).run();
        }
        Boolean bool = (Boolean) this.f43577f.get();
        if (bool != null) {
            j(this.f43572a, bool.booleanValue());
        }
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final synchronized Provider b(Qualified qualified) {
        Preconditions.a(qualified, "Null interface requested.");
        return (Provider) this.f43573b.get(qualified);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final synchronized Provider d(Qualified qualified) {
        LazySet lazySet = (LazySet) this.f43574c.get(qualified);
        if (lazySet != null) {
            return lazySet;
        }
        return f43571h;
    }

    @Override // com.google.firebase.components.ComponentContainer
    public final Deferred h(Qualified qualified) {
        Provider providerB = b(qualified);
        return providerB == null ? new OptionalProvider(OptionalProvider.f43599c, OptionalProvider.f43600d) : providerB instanceof OptionalProvider ? (OptionalProvider) providerB : new OptionalProvider(null, providerB);
    }

    public final void j(HashMap map, boolean z) {
        ArrayDeque arrayDeque;
        for (Map.Entry entry : map.entrySet()) {
            Component component = (Component) entry.getKey();
            Provider provider = (Provider) entry.getValue();
            int i2 = component.f43559d;
            if (i2 == 1 || (i2 == 2 && z)) {
                provider.get();
            }
        }
        EventBus eventBus = this.f43576e;
        synchronized (eventBus) {
            arrayDeque = eventBus.f43592b;
            if (arrayDeque != null) {
                eventBus.f43592b = null;
            } else {
                arrayDeque = null;
            }
        }
        if (arrayDeque != null) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                eventBus.c((Event) it.next());
            }
        }
    }

    public final void k() {
        for (Component component : this.f43572a.keySet()) {
            for (Dependency dependency : component.f43558c) {
                boolean z = dependency.f43589b == 2;
                Qualified qualified = dependency.f43588a;
                if (z) {
                    HashMap map = this.f43574c;
                    if (!map.containsKey(qualified)) {
                        Set set = Collections.EMPTY_SET;
                        LazySet lazySet = new LazySet();
                        lazySet.f43598b = null;
                        lazySet.f43597a = Collections.newSetFromMap(new ConcurrentHashMap());
                        lazySet.f43597a.addAll(set);
                        map.put(qualified, lazySet);
                    }
                }
                HashMap map2 = this.f43573b;
                if (map2.containsKey(qualified)) {
                    continue;
                } else {
                    int i2 = dependency.f43589b;
                    if (i2 == 1) {
                        throw new MissingDependencyException("Unsatisfied dependency for component " + component + ": " + qualified);
                    }
                    if (i2 != 2) {
                        map2.put(qualified, new OptionalProvider(OptionalProvider.f43599c, OptionalProvider.f43600d));
                    }
                }
            }
        }
    }

    public final ArrayList l(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Component component = (Component) it.next();
            if (component.f43560e == 0) {
                Provider provider = (Provider) this.f43572a.get(component);
                for (Qualified qualified : component.f43557b) {
                    HashMap map = this.f43573b;
                    if (map.containsKey(qualified)) {
                        arrayList2.add(new d((OptionalProvider) ((Provider) map.get(qualified)), provider, 0));
                    } else {
                        map.put(qualified, provider);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final ArrayList m() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f43572a.entrySet()) {
            Component component = (Component) entry.getKey();
            if (component.f43560e != 0) {
                Provider provider = (Provider) entry.getValue();
                for (Qualified qualified : component.f43557b) {
                    if (!map.containsKey(qualified)) {
                        map.put(qualified, new HashSet());
                    }
                    ((Set) map.get(qualified)).add(provider);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            Object key = entry2.getKey();
            HashMap map2 = this.f43574c;
            if (map2.containsKey(key)) {
                LazySet lazySet = (LazySet) map2.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(new d(lazySet, (Provider) it.next(), 1));
                }
            } else {
                Qualified qualified2 = (Qualified) entry2.getKey();
                Set set = (Set) ((Collection) entry2.getValue());
                LazySet lazySet2 = new LazySet();
                lazySet2.f43598b = null;
                lazySet2.f43597a = Collections.newSetFromMap(new ConcurrentHashMap());
                lazySet2.f43597a.addAll(set);
                map2.put(qualified2, lazySet2);
            }
        }
        return arrayList;
    }
}
