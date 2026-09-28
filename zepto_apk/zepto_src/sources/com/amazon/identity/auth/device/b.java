package com.amazon.identity.auth.device;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.authorization.AuthorizationActivity;
import com.amazon.identity.auth.device.authorization.AuthorizationResponseParser;
import com.amazon.identity.auth.device.workflow.WorkflowActivity;
import com.amazon.identity.auth.internal.BrowsingExperienceManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static b f15200c;

    /* renamed from: a, reason: collision with root package name */
    public final Map f15201a = Collections.synchronizedMap(new LinkedHashMap(10));

    /* renamed from: b, reason: collision with root package name */
    public final BrowsingExperienceManager f15202b;

    public b(BrowsingExperienceManager browsingExperienceManager) {
        this.f15202b = browsingExperienceManager;
    }

    public static String a(Uri uri) {
        String queryParameter = uri.getQueryParameter("state");
        if (queryParameter == null) {
            throw new AuthError(android.support.v4.media.b.C("Response does not have a state parameter: ", uri.toString()), AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        HashMap map = new HashMap();
        for (String str : TextUtils.split(queryParameter, "&")) {
            String[] strArrSplit = TextUtils.split(str, "=");
            if (strArrSplit != null && strArrSplit.length == 2) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        String str2 = (String) map.get(AuthorizationResponseParser.CLIENT_REQUEST_ID_STATE);
        if (str2 != null) {
            return str2;
        }
        uri.toString();
        throw new AuthError("Response does not have a requestId", AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
    }

    public static boolean c(Uri uri) throws AuthError {
        String queryParameter = uri.getQueryParameter("state");
        if (queryParameter == null) {
            throw new AuthError(android.support.v4.media.b.C("Response does not have a state parameter: ", uri.toString()), AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        HashMap map = new HashMap();
        for (String str : TextUtils.split(queryParameter, "&")) {
            String[] strArrSplit = TextUtils.split(str, "=");
            if (strArrSplit != null && strArrSplit.length == 2) {
                map.put(strArrSplit[0], strArrSplit[1]);
            }
        }
        return ((String) map.get("InteractiveRequestType")) != null;
    }

    public final void b(a aVar, Context context) {
        aVar.getRequestId();
        if (!aVar.canAttempt()) {
            throw new AuthError(android.support.v4.media.b.C("Reached maximum attempts for the request: ", aVar.getRequestId()), AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
        }
        aVar.incrementAttemptCount();
        while (this.f15201a.size() >= 10) {
            synchronized (this.f15201a) {
                String str = (String) this.f15201a.keySet().iterator().next();
                this.f15201a.remove(str);
                ResponseManager responseManagerA = ResponseManager.a();
                synchronized (responseManagerA) {
                }
            }
        }
        this.f15201a.put(aVar.getRequestId(), aVar);
        b.a aVar2 = b.b.f13174a;
        if (aVar2.f13172a == null) {
            aVar2.f13172a = Boolean.valueOf(!context.getPackageManager().queryIntentActivities(new Intent(context, (Class<?>) AuthorizationActivity.class), 65536).isEmpty());
        }
        boolean zBooleanValue = aVar2.f13172a.booleanValue();
        if (aVar2.f13173b == null) {
            aVar2.f13173b = Boolean.valueOf(!context.getPackageManager().queryIntentActivities(new Intent(context, (Class<?>) WorkflowActivity.class), 65536).isEmpty());
        }
        boolean zBooleanValue2 = aVar2.f13173b.booleanValue();
        if (zBooleanValue && zBooleanValue2) {
            throw new RuntimeException("Both AuthorizationActivity and WorkflowActivity are declared in your AndroidManifest.xml. This will cause your users to have to pick from the Android activity chooser when they are redirected back from the browser, and the SDK may not behave as expected. Please remove the deprecated AuthorizationActivity from the manifest.");
        }
        if (!zBooleanValue && !zBooleanValue2) {
            throw new RuntimeException("WorkflowActivity is not declared in your app's AndroidManifest.xml Enable manifest merging or refer to the integration guide to manually add WorkflowActivity to your manifest.");
        }
        aVar.onStart();
        this.f15202b.openUrl(aVar.getOriginalRequest().getRequestContext(), aVar.getUrl(context));
    }
}
