package com.amazon.identity.auth.device;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.api.authorization.AuthorizeRequest;
import com.amazon.identity.auth.device.interactive.InteractiveRequest;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class a {
    protected final InteractiveRequest<?, ?, ?, ?> originalRequest;
    protected final String requestId = UUID.randomUUID().toString();

    /* renamed from: a, reason: collision with root package name */
    public int f15087a = 0;

    public a(AuthorizeRequest authorizeRequest) {
        this.originalRequest = authorizeRequest;
    }

    public boolean canAttempt() {
        return this.f15087a < getMaxAttemptCount();
    }

    public InteractiveRequestRecord getInteractiveRequestRecord() {
        return new InteractiveRequestRecord(this.requestId, this.originalRequest.getRequestExtras());
    }

    public int getMaxAttemptCount() {
        return 1;
    }

    public InteractiveRequest<?, ?, ?, ?> getOriginalRequest() {
        return this.originalRequest;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public abstract String getUrl(Context context);

    public abstract boolean handleResponse(Uri uri, Context context);

    public void incrementAttemptCount() {
        this.f15087a++;
    }

    public void onStart() {
        InteractiveRequest<?, ?, ?, ?> interactiveRequest = this.originalRequest;
        if (interactiveRequest != null) {
            interactiveRequest.getRequestContext().onStartRequest(getInteractiveRequestRecord());
        }
    }
}
