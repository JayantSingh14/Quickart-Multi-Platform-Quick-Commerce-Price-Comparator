package androidx.lifecycle;

import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

@Deprecated
/* loaded from: classes3.dex */
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {

    /* renamed from: a, reason: collision with root package name */
    public final LifecycleObserver f4866a;

    /* renamed from: b, reason: collision with root package name */
    public final ClassesInfoCache.CallbackInfo f4867b;

    public ReflectiveGenericLifecycleObserver(LifecycleObserver lifecycleObserver) {
        this.f4866a = lifecycleObserver;
        ClassesInfoCache classesInfoCache = ClassesInfoCache.f4761c;
        Class<?> cls = lifecycleObserver.getClass();
        ClassesInfoCache.CallbackInfo callbackInfo = (ClassesInfoCache.CallbackInfo) classesInfoCache.f4762a.get(cls);
        this.f4867b = callbackInfo == null ? classesInfoCache.a(cls, null) : callbackInfo;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        HashMap map = this.f4867b.f4764a;
        List list = (List) map.get(event);
        LifecycleObserver lifecycleObserver = this.f4866a;
        ClassesInfoCache.CallbackInfo.a(list, lifecycleOwner, event, lifecycleObserver);
        ClassesInfoCache.CallbackInfo.a((List) map.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, lifecycleObserver);
    }
}
