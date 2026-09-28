package com.zeptoconsumerapp.otpVerify;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zeptoconsumerapp.otpVerify.constants.OtpListenerType;
import com.zeptoconsumerapp.otpVerify.implementations.SmsOtpListener;
import com.zeptoconsumerapp.otpVerify.implementations.WhatsappOtpListener;
import com.zeptoconsumerapp.otpVerify.interfaces.OtpListener;
import com.zeptoconsumerapp.otpVerify.utils.AppSignature;
import com.zeptoconsumerapp.otpVerify.utils.OtpDataPayload;
import com.zeptoconsumerapp.otpVerify.utils.OtpVerifyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = OtpVerifyModule.NAME)
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class OtpVerifyModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "ZeptoOtpVerify";

    @Nullable
    private List<OtpListener> otpVerifyListeners;

    @NotNull
    private final ReactApplicationContext reactAppContext;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[OtpListenerType.values().length];
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                OtpListenerType[] otpListenerTypeArr = OtpListenerType.f47710a;
                iArr[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OtpVerifyModule(@NotNull ReactApplicationContext reactAppContext) {
        super(reactAppContext);
        Intrinsics.checkNotNullParameter(reactAppContext, "reactAppContext");
        this.reactAppContext = reactAppContext;
        this.otpVerifyListeners = new ArrayList();
        reactAppContext.addLifecycleEventListener(this);
    }

    private final OtpListener createOtpListener(OtpListenerType otpListenerType) {
        a aVar = new a(this, otpListenerType, 0);
        a aVar2 = new a(this, otpListenerType, 1);
        int iOrdinal = otpListenerType.ordinal();
        if (iOrdinal == 0) {
            return new WhatsappOtpListener(this.reactAppContext, otpListenerType, aVar2, aVar);
        }
        if (iOrdinal == 1) {
            return new SmsOtpListener(this.reactAppContext, otpListenerType, aVar2, aVar);
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createOtpListener$lambda$0(OtpVerifyModule otpVerifyModule, OtpListenerType otpListenerType, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        otpVerifyModule.emitOtpEvent(false, errorMessage, otpListenerType);
        return Unit.f53572a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createOtpListener$lambda$1(OtpVerifyModule otpVerifyModule, OtpListenerType otpListenerType, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        otpVerifyModule.emitOtpEvent(true, message, otpListenerType);
        return Unit.f53572a;
    }

    private final void emitEvent(String str, WritableMap writableMap) {
        try {
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactAppContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, writableMap);
        } catch (Exception unused) {
        }
    }

    private final void emitOtpEvent(boolean z, String str, OtpListenerType otpListenerType) {
        emitEvent(OtpVerifyHelper.b(otpListenerType), OtpVerifyHelper.a(new OtpDataPayload(z, str, otpListenerType)));
    }

    private final void registerReceiver() {
        List<OtpListener> list = this.otpVerifyListeners;
        if (list == null) {
            return;
        }
        Iterator<OtpListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private final void unregisterReceiver() {
        List<OtpListener> list = this.otpVerifyListeners;
        if (list == null) {
            return;
        }
        Iterator<OtpListener> it = list.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @ReactMethod
    public final void addListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @ReactMethod
    public final void getHash(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            ArrayList arrayListA = new AppSignature(this.reactAppContext).a();
            WritableArray writableArrayCreateArray = Arguments.createArray();
            Iterator it = arrayListA.iterator();
            Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                writableArrayCreateArray.pushString((String) next);
            }
            promise.resolve(writableArrayCreateArray);
        } catch (Exception e2) {
            promise.reject(e2);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        try {
            unregisterReceiver();
            List<OtpListener> list = this.otpVerifyListeners;
            if (list != null) {
                list.clear();
            }
            this.reactAppContext.removeLifecycleEventListener(this);
        } catch (Exception unused) {
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        unregisterReceiver();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        unregisterReceiver();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        registerReceiver();
    }

    @ReactMethod
    public final void removeListeners(int i2) {
    }

    @ReactMethod
    public final void startRetriever(@NotNull String otpListenerType, @NotNull Promise promise) {
        OtpListener otpListener;
        Object next;
        Intrinsics.checkNotNullParameter(otpListenerType, "otpListenerType");
        Intrinsics.checkNotNullParameter(promise, "promise");
        List<OtpListener> list = this.otpVerifyListeners;
        OtpListener otpListenerCreateOtpListener = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.b(((OtpListener) next).a().name(), otpListenerType)) {
                        break;
                    }
                }
            }
            otpListener = (OtpListener) next;
        } else {
            otpListener = null;
        }
        if (otpListener != null) {
            otpListener.c(promise);
            return;
        }
        try {
            otpListenerCreateOtpListener = createOtpListener(OtpListenerType.valueOf(otpListenerType));
        } catch (Exception e2) {
            promise.reject("Listener Creation Failed", e2.getMessage());
        }
        if (otpListenerCreateOtpListener == null) {
            promise.reject("Invalid Listener Type", "Unsupported otpListenerType: " + otpListenerType);
        } else {
            List<OtpListener> list2 = this.otpVerifyListeners;
            if (list2 != null) {
                list2.add(otpListenerCreateOtpListener);
            }
            otpListenerCreateOtpListener.c(promise);
        }
    }
}
