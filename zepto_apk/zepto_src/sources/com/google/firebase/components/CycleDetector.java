package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
class CycleDetector {

    public static class ComponentNode {

        /* renamed from: a, reason: collision with root package name */
        public final Component f43583a;

        /* renamed from: b, reason: collision with root package name */
        public final HashSet f43584b = new HashSet();

        /* renamed from: c, reason: collision with root package name */
        public final HashSet f43585c = new HashSet();

        public ComponentNode(Component component) {
            this.f43583a = component;
        }
    }

    public static class Dep {

        /* renamed from: a, reason: collision with root package name */
        public final Qualified f43586a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f43587b;

        public Dep(Qualified qualified, boolean z) {
            this.f43586a = qualified;
            this.f43587b = z;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof Dep) {
                Dep dep = (Dep) obj;
                if (dep.f43586a.equals(this.f43586a) && dep.f43587b == this.f43587b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ((this.f43586a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f43587b).hashCode();
        }
    }

    public static void a(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (ComponentNode componentNode : (Set) it2.next()) {
                        for (Dependency dependency : componentNode.f43583a.f43558c) {
                            if (dependency.f43590c == 0) {
                                Set<ComponentNode> set = (Set) map.get(new Dep(dependency.f43588a, dependency.f43589b == 2));
                                if (set != null) {
                                    for (ComponentNode componentNode2 : set) {
                                        componentNode.f43584b.add(componentNode2);
                                        componentNode2.f43585c.add(componentNode);
                                    }
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                HashSet hashSet2 = new HashSet();
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    ComponentNode componentNode3 = (ComponentNode) it4.next();
                    if (componentNode3.f43585c.isEmpty()) {
                        hashSet2.add(componentNode3);
                    }
                }
                while (!hashSet2.isEmpty()) {
                    ComponentNode componentNode4 = (ComponentNode) hashSet2.iterator().next();
                    hashSet2.remove(componentNode4);
                    i2++;
                    Iterator it5 = componentNode4.f43584b.iterator();
                    while (it5.hasNext()) {
                        ComponentNode componentNode5 = (ComponentNode) it5.next();
                        componentNode5.f43585c.remove(componentNode4);
                        if (componentNode5.f43585c.isEmpty()) {
                            hashSet2.add(componentNode5);
                        }
                    }
                }
                if (i2 == arrayList.size()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it6 = hashSet.iterator();
                while (it6.hasNext()) {
                    ComponentNode componentNode6 = (ComponentNode) it6.next();
                    if (!componentNode6.f43585c.isEmpty() && !componentNode6.f43584b.isEmpty()) {
                        arrayList2.add(componentNode6.f43583a);
                    }
                }
                throw new DependencyCycleException(arrayList2);
            }
            Component component = (Component) it.next();
            ComponentNode componentNode7 = new ComponentNode(component);
            for (Qualified qualified : component.f43557b) {
                boolean z = component.f43560e == 0;
                Dep dep = new Dep(qualified, !z);
                if (!map.containsKey(dep)) {
                    map.put(dep, new HashSet());
                }
                Set set2 = (Set) map.get(dep);
                if (!set2.isEmpty() && z) {
                    throw new IllegalArgumentException("Multiple components provide " + qualified + CLConstants.DOT_SALT_DELIMETER);
                }
                set2.add(componentNode7);
            }
        }
    }
}
