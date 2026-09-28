package io.invertase.firebase.messaging;

import android.content.Intent;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.HeadlessJsTaskService;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.jstasks.HeadlessJsTaskConfig;
import com.facebook.react.jstasks.NoRetryPolicy;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.time.DateUtils;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class ReactNativeFirebaseMessagingHeadlessService extends HeadlessJsTaskService {
    @Override // com.facebook.react.HeadlessJsTaskService
    public final HeadlessJsTaskConfig e(Intent intent) throws NumberFormatException {
        if (intent.getExtras() == null) {
            return null;
        }
        WritableMap data = ReactNativeFirebaseMessagingSerializer.c((RemoteMessage) intent.getParcelableExtra(APayConstants.Error.MESSAGE));
        JSONObject jSONObject = ReactNativeFirebaseJSON.f49237b.f49238a;
        long jOptLong = DateUtils.MILLIS_PER_MINUTE;
        if (jSONObject != null) {
            jOptLong = jSONObject.optLong("messaging_android_headless_task_timeout", DateUtils.MILLIS_PER_MINUTE);
        }
        Intrinsics.checkNotNullParameter("ReactNativeFirebaseMessagingHeadlessTask", "taskKey");
        Intrinsics.checkNotNullParameter(data, "data");
        return new HeadlessJsTaskConfig("ReactNativeFirebaseMessagingHeadlessTask", data, jOptLong, true, NoRetryPolicy.f19016a);
    }
}
