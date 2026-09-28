package com.facebook.react.bridge;

import androidx.annotation.Nullable;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JavaModuleWrapper;
import com.facebook.systrace.SystraceMessage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
class JavaMethodWrapper implements JavaModuleWrapper.NativeMethod {
    private static final boolean DEBUG;

    @Nullable
    private ArgumentExtractor[] mArgumentExtractors;

    @Nullable
    private Object[] mArguments;
    private boolean mArgumentsProcessed = false;

    @Nullable
    private int mJSArgumentsNeeded;
    private final Method mMethod;
    private final JavaModuleWrapper mModuleWrapper;
    private final int mParamLength;
    private final Class[] mParameterTypes;

    @Nullable
    private String mSignature;
    private String mType;
    private static final ArgumentExtractor<Boolean> ARGUMENT_EXTRACTOR_BOOLEAN = new ArgumentExtractor<Boolean>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Boolean extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return Boolean.valueOf(readableArray.getBoolean(i2));
        }
    };
    private static final ArgumentExtractor<Double> ARGUMENT_EXTRACTOR_DOUBLE = new ArgumentExtractor<Double>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Double extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return Double.valueOf(readableArray.getDouble(i2));
        }
    };
    private static final ArgumentExtractor<Float> ARGUMENT_EXTRACTOR_FLOAT = new ArgumentExtractor<Float>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Float extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return Float.valueOf((float) readableArray.getDouble(i2));
        }
    };
    private static final ArgumentExtractor<Integer> ARGUMENT_EXTRACTOR_INTEGER = new ArgumentExtractor<Integer>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.4
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Integer extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return Integer.valueOf((int) readableArray.getDouble(i2));
        }
    };
    private static final ArgumentExtractor<String> ARGUMENT_EXTRACTOR_STRING = new ArgumentExtractor<String>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.5
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public String extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return readableArray.getString(i2);
        }
    };
    private static final ArgumentExtractor<ReadableArray> ARGUMENT_EXTRACTOR_ARRAY = new ArgumentExtractor<ReadableArray>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.6
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public ReadableArray extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return readableArray.getArray(i2);
        }
    };
    private static final ArgumentExtractor<Dynamic> ARGUMENT_EXTRACTOR_DYNAMIC = new ArgumentExtractor<Dynamic>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.7
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Dynamic extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return DynamicFromArray.create(readableArray, i2);
        }
    };
    private static final ArgumentExtractor<ReadableMap> ARGUMENT_EXTRACTOR_MAP = new ArgumentExtractor<ReadableMap>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.8
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public ReadableMap extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return readableArray.getMap(i2);
        }
    };
    private static final ArgumentExtractor<Callback> ARGUMENT_EXTRACTOR_CALLBACK = new ArgumentExtractor<Callback>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.9
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        @Nullable
        public Callback extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            if (readableArray.isNull(i2)) {
                return null;
            }
            return new CallbackImpl(jSInstance, (int) readableArray.getDouble(i2));
        }
    };
    private static final ArgumentExtractor<Promise> ARGUMENT_EXTRACTOR_PROMISE = new ArgumentExtractor<Promise>() { // from class: com.facebook.react.bridge.JavaMethodWrapper.10
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public int getJSArgumentsNeeded() {
            return 2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.facebook.react.bridge.JavaMethodWrapper.ArgumentExtractor
        public Promise extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2) {
            return new PromiseImpl((Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableArray, i2), (Callback) JavaMethodWrapper.ARGUMENT_EXTRACTOR_CALLBACK.extractArgument(jSInstance, readableArray, i2 + 1));
        }
    };

    public static abstract class ArgumentExtractor<T> {
        public /* synthetic */ ArgumentExtractor(int i2) {
            this();
        }

        @Nullable
        public abstract T extractArgument(JSInstance jSInstance, ReadableArray readableArray, int i2);

        public int getJSArgumentsNeeded() {
            return 1;
        }

        private ArgumentExtractor() {
        }
    }

    static {
        DebugOverlayTag tag = ReactDebugOverlayTags.f17191b;
        Intrinsics.checkNotNullParameter(tag, "tag");
        DEBUG = false;
    }

    public JavaMethodWrapper(JavaModuleWrapper javaModuleWrapper, Method method, boolean z) throws SecurityException {
        this.mType = BaseJavaModule.METHOD_TYPE_ASYNC;
        this.mModuleWrapper = javaModuleWrapper;
        this.mMethod = method;
        method.setAccessible(true);
        Class<?>[] parameterTypes = method.getParameterTypes();
        this.mParameterTypes = parameterTypes;
        int length = parameterTypes.length;
        this.mParamLength = length;
        if (z) {
            this.mType = BaseJavaModule.METHOD_TYPE_SYNC;
        } else {
            if (length <= 0 || parameterTypes[length - 1] != Promise.class) {
                return;
            }
            this.mType = BaseJavaModule.METHOD_TYPE_PROMISE;
        }
    }

    private ArgumentExtractor[] buildArgumentExtractors(Class[] clsArr) {
        ArgumentExtractor[] argumentExtractorArr = new ArgumentExtractor[clsArr.length];
        int jSArgumentsNeeded = 0;
        while (jSArgumentsNeeded < clsArr.length) {
            Class cls = clsArr[jSArgumentsNeeded];
            if (cls == Boolean.class || cls == Boolean.TYPE) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_BOOLEAN;
            } else if (cls == Integer.class || cls == Integer.TYPE) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_INTEGER;
            } else if (cls == Double.class || cls == Double.TYPE) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_DOUBLE;
            } else if (cls == Float.class || cls == Float.TYPE) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_FLOAT;
            } else if (cls == String.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_STRING;
            } else if (cls == Callback.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_CALLBACK;
            } else if (cls == Promise.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_PROMISE;
                Assertions.b(jSArgumentsNeeded == clsArr.length - 1, "Promise must be used as last parameter only");
            } else if (cls == ReadableMap.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_MAP;
            } else if (cls == ReadableArray.class) {
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_ARRAY;
            } else {
                if (cls != Dynamic.class) {
                    throw new RuntimeException("Got unknown argument class: ".concat(cls.getSimpleName()));
                }
                argumentExtractorArr[jSArgumentsNeeded] = ARGUMENT_EXTRACTOR_DYNAMIC;
            }
            jSArgumentsNeeded += argumentExtractorArr[jSArgumentsNeeded].getJSArgumentsNeeded();
        }
        return argumentExtractorArr;
    }

    private String buildSignature(Method method, Class[] clsArr, boolean z) {
        StringBuilder sb = new StringBuilder(clsArr.length + 2);
        if (z) {
            sb.append(returnTypeToChar(method.getReturnType()));
            sb.append(ClassUtils.PACKAGE_SEPARATOR_CHAR);
        } else {
            sb.append("v.");
        }
        int i2 = 0;
        while (i2 < clsArr.length) {
            Class cls = clsArr[i2];
            if (cls == Promise.class) {
                Assertions.b(i2 == clsArr.length - 1, "Promise must be used as last parameter only");
            }
            sb.append(paramTypeToChar(cls));
            i2++;
        }
        return sb.toString();
    }

    private int calculateJSArgumentsNeeded() {
        ArgumentExtractor[] argumentExtractorArr = this.mArgumentExtractors;
        Assertions.c(argumentExtractorArr);
        int jSArgumentsNeeded = 0;
        for (ArgumentExtractor argumentExtractor : argumentExtractorArr) {
            jSArgumentsNeeded += argumentExtractor.getJSArgumentsNeeded();
        }
        return jSArgumentsNeeded;
    }

    private static char commonTypeToChar(Class cls) {
        if (cls == Boolean.TYPE) {
            return 'z';
        }
        if (cls == Boolean.class) {
            return 'Z';
        }
        if (cls == Integer.TYPE) {
            return 'i';
        }
        if (cls == Integer.class) {
            return 'I';
        }
        if (cls == Double.TYPE) {
            return 'd';
        }
        if (cls == Double.class) {
            return 'D';
        }
        if (cls == Float.TYPE) {
            return 'f';
        }
        if (cls == Float.class) {
            return 'F';
        }
        return cls == String.class ? 'S' : (char) 0;
    }

    private static String createInvokeExceptionMessage(String str) {
        return android.support.v4.media.b.C("Could not invoke ", str);
    }

    private String getAffectedRange(int i2, int i3) {
        if (i3 <= 1) {
            return android.support.v4.media.b.f(i2, "");
        }
        StringBuilder sbU = android.support.v4.media.b.u(i2, "", "-");
        sbU.append((i2 + i3) - 1);
        return sbU.toString();
    }

    private static char paramTypeToChar(Class cls) {
        char cCommonTypeToChar = commonTypeToChar(cls);
        if (cCommonTypeToChar != 0) {
            return cCommonTypeToChar;
        }
        if (cls == Callback.class) {
            return 'X';
        }
        if (cls == Promise.class) {
            return 'P';
        }
        if (cls == ReadableMap.class) {
            return 'M';
        }
        if (cls == ReadableArray.class) {
            return 'A';
        }
        if (cls == Dynamic.class) {
            return 'Y';
        }
        throw new RuntimeException("Got unknown param class: ".concat(cls.getSimpleName()));
    }

    private void processArguments() {
        if (this.mArgumentsProcessed) {
            return;
        }
        SystraceMessage.Builder builderA = SystraceMessage.a("processArguments");
        builderA.b(this.mModuleWrapper.getName() + CLConstants.DOT_SALT_DELIMETER + this.mMethod.getName(), "method");
        builderA.c();
        try {
            this.mArgumentsProcessed = true;
            this.mArgumentExtractors = buildArgumentExtractors(this.mParameterTypes);
            this.mSignature = buildSignature(this.mMethod, this.mParameterTypes, this.mType.equals(BaseJavaModule.METHOD_TYPE_SYNC));
            this.mArguments = new Object[this.mParameterTypes.length];
            this.mJSArgumentsNeeded = calculateJSArgumentsNeeded();
        } finally {
            SystraceMessage.b().c();
        }
    }

    private static char returnTypeToChar(Class cls) {
        char cCommonTypeToChar = commonTypeToChar(cls);
        if (cCommonTypeToChar != 0) {
            return cCommonTypeToChar;
        }
        if (cls == Void.TYPE) {
            return 'v';
        }
        if (cls == WritableMap.class) {
            return 'M';
        }
        if (cls == WritableArray.class) {
            return 'A';
        }
        throw new RuntimeException("Got unknown return class: ".concat(cls.getSimpleName()));
    }

    public Method getMethod() {
        return this.mMethod;
    }

    public String getSignature() {
        if (!this.mArgumentsProcessed) {
            processArguments();
        }
        String str = this.mSignature;
        Assertions.c(str);
        return str;
    }

    @Override // com.facebook.react.bridge.JavaModuleWrapper.NativeMethod
    public String getType() {
        return this.mType;
    }

    @Override // com.facebook.react.bridge.JavaModuleWrapper.NativeMethod
    public void invoke(JSInstance jSInstance, ReadableArray readableArray) {
        String str = this.mModuleWrapper.getName() + CLConstants.DOT_SALT_DELIMETER + this.mMethod.getName();
        SystraceMessage.Builder builderA = SystraceMessage.a("callJavaModuleMethod");
        builderA.b(str, "method");
        builderA.c();
        if (DEBUG) {
            DebugOverlayTag tag = ReactDebugOverlayTags.f17191b;
            Object[] args = {this.mModuleWrapper.getName(), this.mMethod.getName()};
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter("JS->Java: %s.%s()", APayConstants.Error.MESSAGE);
            Intrinsics.checkNotNullParameter(args, "args");
        }
        try {
            if (!this.mArgumentsProcessed) {
                processArguments();
            }
            if (this.mArguments == null || this.mArgumentExtractors == null) {
                throw new Error("processArguments failed");
            }
            if (this.mJSArgumentsNeeded != readableArray.size()) {
                throw new NativeArgumentsParseException(str + " got " + readableArray.size() + " arguments, expected " + this.mJSArgumentsNeeded);
            }
            int i2 = 0;
            int jSArgumentsNeeded = 0;
            while (true) {
                try {
                    ArgumentExtractor[] argumentExtractorArr = this.mArgumentExtractors;
                    if (i2 >= argumentExtractorArr.length) {
                        try {
                            this.mMethod.invoke(this.mModuleWrapper.getModule(), this.mArguments);
                            SystraceMessage.b().c();
                            return;
                        } catch (IllegalAccessException e2) {
                            e = e2;
                            throw new RuntimeException(createInvokeExceptionMessage(str), e);
                        } catch (IllegalArgumentException e3) {
                            e = e3;
                            throw new RuntimeException(createInvokeExceptionMessage(str), e);
                        } catch (InvocationTargetException e4) {
                            if (!(e4.getCause() instanceof RuntimeException)) {
                                throw new RuntimeException(createInvokeExceptionMessage(str), e4);
                            }
                            throw ((RuntimeException) e4.getCause());
                        }
                    }
                    this.mArguments[i2] = argumentExtractorArr[i2].extractArgument(jSInstance, readableArray, jSArgumentsNeeded);
                    jSArgumentsNeeded += this.mArgumentExtractors[i2].getJSArgumentsNeeded();
                    i2++;
                } catch (UnexpectedNativeTypeException | NullPointerException e5) {
                    throw new NativeArgumentsParseException(e5.getMessage() + " (constructing arguments for " + str + " at argument index " + getAffectedRange(jSArgumentsNeeded, this.mArgumentExtractors[i2].getJSArgumentsNeeded()) + ")", e5);
                }
            }
        } catch (Throwable th) {
            SystraceMessage.b().c();
            throw th;
        }
    }
}
