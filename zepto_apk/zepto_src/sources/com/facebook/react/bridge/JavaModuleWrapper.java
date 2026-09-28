package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import androidx.tracing.Trace;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.systrace.SystraceMessage;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

@DoNotStrip
/* loaded from: classes.dex */
class JavaModuleWrapper {
    private final JSInstance mJSInstance;
    private final ModuleHolder mModuleHolder;
    private final ArrayList<NativeMethod> mMethods = new ArrayList<>();
    private final ArrayList<MethodDescriptor> mDescs = new ArrayList<>();

    @DoNotStrip
    public static class MethodDescriptor {

        @DoNotStrip
        Method method;

        @DoNotStrip
        String name;

        @DoNotStrip
        String signature;

        @DoNotStrip
        String type;
    }

    public interface NativeMethod {
        String getType();

        void invoke(JSInstance jSInstance, ReadableArray readableArray);
    }

    public JavaModuleWrapper(JSInstance jSInstance, ModuleHolder moduleHolder) {
        this.mJSInstance = jSInstance;
        this.mModuleHolder = moduleHolder;
    }

    @DoNotStrip
    private void findMethods() throws SecurityException {
        Intrinsics.checkNotNullParameter("findMethods", "sectionName");
        Trace.b("findMethods");
        Class<?> cls = this.mModuleHolder.getModule().getClass();
        Class<? super Object> superclass = cls.getSuperclass();
        if (TurboModule.class.isAssignableFrom(superclass)) {
            cls = superclass;
        }
        for (Method method : cls.getDeclaredMethods()) {
            ReactMethod reactMethod = (ReactMethod) method.getAnnotation(ReactMethod.class);
            if (reactMethod != null) {
                String name = method.getName();
                MethodDescriptor methodDescriptor = new MethodDescriptor();
                JavaMethodWrapper javaMethodWrapper = new JavaMethodWrapper(this, method, reactMethod.isBlockingSynchronousMethod());
                methodDescriptor.name = name;
                String type = javaMethodWrapper.getType();
                methodDescriptor.type = type;
                if (BaseJavaModule.METHOD_TYPE_SYNC.equals(type)) {
                    methodDescriptor.signature = javaMethodWrapper.getSignature();
                    methodDescriptor.method = method;
                }
                this.mMethods.add(javaMethodWrapper);
                this.mDescs.add(methodDescriptor);
            }
        }
        android.os.Trace.endSection();
    }

    @Nullable
    @DoNotStrip
    public NativeMap getConstants() {
        String name = getName();
        SystraceMessage.Builder builderA = SystraceMessage.a("JavaModuleWrapper.getConstants");
        builderA.b(name, "moduleName");
        builderA.c();
        ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_START, name);
        BaseJavaModule module = getModule();
        Intrinsics.checkNotNullParameter("module.getConstants", "sectionName");
        android.os.Trace.beginSection(Trace.g("module.getConstants"));
        Map<String, Object> constants = module.getConstants();
        android.os.Trace.endSection();
        Intrinsics.checkNotNullParameter("create WritableNativeMap", "sectionName");
        android.os.Trace.beginSection(Trace.g("create WritableNativeMap"));
        ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_START, name);
        try {
            return Arguments.makeNativeMap(constants);
        } finally {
            ReactMarker.logMarker(ReactMarkerConstants.CONVERT_CONSTANTS_END, name);
            android.os.Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.GET_CONSTANTS_END, name);
            SystraceMessage.b().c();
        }
    }

    @DoNotStrip
    public List<MethodDescriptor> getMethodDescriptors() throws SecurityException {
        if (this.mDescs.isEmpty()) {
            findMethods();
        }
        return this.mDescs;
    }

    @DoNotStrip
    public BaseJavaModule getModule() {
        return (BaseJavaModule) this.mModuleHolder.getModule();
    }

    @DoNotStrip
    public String getName() {
        return this.mModuleHolder.getName();
    }

    @DoNotStrip
    public void invoke(int i2, ReadableNativeArray readableNativeArray) {
        if (i2 >= this.mMethods.size()) {
            return;
        }
        this.mMethods.get(i2).invoke(this.mJSInstance, readableNativeArray);
    }
}
