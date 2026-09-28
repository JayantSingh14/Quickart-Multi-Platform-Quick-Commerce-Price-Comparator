package com.google.firebase.tracing;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRegistrarProcessor;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ComponentMonitor implements ComponentRegistrarProcessor {
    @Override // com.google.firebase.components.ComponentRegistrarProcessor
    public final List b(ComponentRegistrar componentRegistrar) {
        ArrayList arrayList = new ArrayList();
        for (Component component : componentRegistrar.getComponents()) {
            String str = component.f43556a;
            if (str != null) {
                a aVar = new a(str, component);
                component = new Component(str, component.f43557b, component.f43558c, component.f43559d, component.f43560e, aVar, component.f43562g);
            }
            arrayList.add(component);
        }
        return arrayList;
    }
}
