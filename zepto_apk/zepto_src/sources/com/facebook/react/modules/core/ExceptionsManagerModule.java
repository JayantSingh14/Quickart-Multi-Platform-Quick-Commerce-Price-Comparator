package com.facebook.react.modules.core;

import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.JavascriptException;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.util.ExceptionDataHelper;
import com.facebook.react.util.JSStackTrace;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = NativeExceptionsManagerSpec.NAME)
@Metadata
/* loaded from: classes.dex */
public class ExceptionsManagerModule extends NativeExceptionsManagerSpec {

    @NotNull
    private final DevSupportManager devSupportManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExceptionsManagerModule(@NotNull DevSupportManager devSupportManager) {
        super(null);
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void dismissRedbox() {
        if (this.devSupportManager.g()) {
            this.devSupportManager.j();
        }
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportException(@NotNull ReadableMap data) throws IOException {
        Intrinsics.checkNotNullParameter(data, "data");
        String string = data.getString(APayConstants.Error.MESSAGE);
        if (string == null) {
            string = "";
        }
        ReadableArray array = data.getArray("stack");
        if (array == null) {
            array = Arguments.createArray();
        }
        boolean z = data.hasKey("isFatal") ? data.getBoolean("isFatal") : false;
        String strA = ExceptionDataHelper.a(data);
        if (z) {
            Intrinsics.c(array);
            throw new JavascriptException(JSStackTrace.a(string, array));
        }
        Intrinsics.c(array);
        FLog.g("ReactNative", JSStackTrace.a(string, array));
        if (strA != null) {
            FLog.c("ReactNative", "extraData: %s", strA);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportFatalException(@Nullable String str, @Nullable ReadableArray readableArray, double d2) throws IOException {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString(APayConstants.Error.MESSAGE, str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, (int) d2);
        javaOnlyMap.putBoolean("isFatal", true);
        reportException(javaOnlyMap);
    }

    @Override // com.facebook.fbreact.specs.NativeExceptionsManagerSpec
    public void reportSoftException(@Nullable String str, @Nullable ReadableArray readableArray, double d2) throws IOException {
        JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
        javaOnlyMap.putString(APayConstants.Error.MESSAGE, str);
        javaOnlyMap.putArray("stack", readableArray);
        javaOnlyMap.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, (int) d2);
        javaOnlyMap.putBoolean("isFatal", false);
        reportException(javaOnlyMap);
    }
}
