package com.appsflyer;

import androidx.annotation.WorkerThread;

@Deprecated
/* loaded from: classes3.dex */
public final class CreateOneLinkHttpTask {

    @Deprecated
    public interface ResponseListener {
        @WorkerThread
        void onResponse(String str);

        @WorkerThread
        void onResponseError(String str);
    }
}
