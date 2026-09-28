package com.facebook.react.modules.core;

import android.util.SparseArray;
import androidx.activity.g;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.jstasks.HeadlessJsTaskRetryPolicy;
import com.facebook.react.module.annotations.ReactModule;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = NativeHeadlessJsTaskSupportSpec.NAME)
@Metadata
/* loaded from: classes.dex */
public class HeadlessJsTaskSupportModule extends NativeHeadlessJsTaskSupportSpec {
    public HeadlessJsTaskSupportModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec
    public void notifyTaskFinished(double d2) {
        boolean zContains;
        int i2 = (int) d2;
        WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        HeadlessJsTaskContext headlessJsTaskContextA = HeadlessJsTaskContext.Companion.a(reactApplicationContext);
        synchronized (headlessJsTaskContextA) {
            zContains = headlessJsTaskContextA.f19013d.contains(Integer.valueOf(i2));
        }
        if (zContains) {
            headlessJsTaskContextA.b(i2);
        } else {
            FLog.p(HeadlessJsTaskSupportModule.class, "Tried to finish non-active task with id %d. Did it time out?", Integer.valueOf(i2));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeHeadlessJsTaskSupportSpec
    public void notifyTaskRetry(double d2, @NotNull Promise promise) {
        boolean zContains;
        boolean z;
        Intrinsics.checkNotNullParameter(promise, "promise");
        int i2 = (int) d2;
        WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "getReactApplicationContext(...)");
        HeadlessJsTaskContext headlessJsTaskContextA = HeadlessJsTaskContext.Companion.a(reactApplicationContext);
        synchronized (headlessJsTaskContextA) {
            zContains = headlessJsTaskContextA.f19013d.contains(Integer.valueOf(i2));
        }
        if (!zContains) {
            FLog.p(HeadlessJsTaskSupportModule.class, "Tried to retry non-active task with id %d. Did it time out?", Integer.valueOf(i2));
            promise.resolve(Boolean.FALSE);
            return;
        }
        synchronized (headlessJsTaskContextA) {
            HeadlessJsTaskConfig headlessJsTaskConfig = (HeadlessJsTaskConfig) headlessJsTaskContextA.f19014e.get(Integer.valueOf(i2));
            if (headlessJsTaskConfig == null) {
                throw new IllegalStateException(("Tried to retrieve non-existent task config with id " + i2 + CLConstants.DOT_SALT_DELIMETER).toString());
            }
            HeadlessJsTaskRetryPolicy headlessJsTaskRetryPolicyB = headlessJsTaskConfig.b();
            if (headlessJsTaskRetryPolicyB == null || !headlessJsTaskRetryPolicyB.a()) {
                z = false;
            } else {
                SparseArray sparseArray = headlessJsTaskContextA.f19015f;
                Runnable runnable = (Runnable) sparseArray.get(i2);
                if (runnable != null) {
                    UiThreadUtil.removeOnUiThread(runnable);
                    sparseArray.remove(i2);
                }
                UiThreadUtil.runOnUiThread(new g(headlessJsTaskContextA, new HeadlessJsTaskConfig(headlessJsTaskConfig.c(), headlessJsTaskConfig.a(), headlessJsTaskConfig.d(), headlessJsTaskConfig.e(), headlessJsTaskRetryPolicyB.c()), i2, 5), headlessJsTaskRetryPolicyB.b());
                z = true;
            }
        }
        promise.resolve(Boolean.valueOf(z));
    }
}
