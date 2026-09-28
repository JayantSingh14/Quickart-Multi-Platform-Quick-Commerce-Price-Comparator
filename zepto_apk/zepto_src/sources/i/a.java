package i;

import android.content.Context;
import android.net.Uri;
import com.amazon.identity.auth.device.interactive.InteractiveListener;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public final class a<T extends InteractiveListener<S, U, V>, S, U, V> implements InteractiveListener<S, U, V> {

    /* renamed from: a, reason: collision with root package name */
    public final String f48436a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f48437b;

    public a(String str, Set set) {
        this.f48436a = str;
        set = set == null ? Collections.EMPTY_SET : set;
        this.f48437b = set;
        for (InteractiveListener interactiveListener : set) {
            if (!str.equals(interactiveListener.getRequestType())) {
                StringBuilder sbY = android.support.v4.media.b.y("AggregateInteractiveListener created for request type \"", str, "\" but received listener with request type \"");
                sbY.append(interactiveListener.getRequestType());
                sbY.append("\"");
                throw new IllegalStateException(sbY.toString());
            }
        }
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveAPI
    public final String getRequestType() {
        return this.f48436a;
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener
    public final void onCancel(Object obj) {
        Iterator it = this.f48437b.iterator();
        while (it.hasNext()) {
            ((InteractiveListener) it.next()).onCancel(obj);
        }
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
    public final void onError(Object obj) {
        Iterator it = this.f48437b.iterator();
        while (it.hasNext()) {
            ((InteractiveListener) it.next()).onError(obj);
        }
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener
    public final void onRequestCancel(Context context, InteractiveRequestRecord interactiveRequestRecord, l.a aVar) {
        Iterator it = this.f48437b.iterator();
        while (it.hasNext()) {
            ((InteractiveListener) it.next()).onRequestCancel(context, interactiveRequestRecord, null);
        }
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, i.f
    public final void onRequestCompletion(Context context, InteractiveRequestRecord interactiveRequestRecord, Uri uri) {
        Iterator it = this.f48437b.iterator();
        while (it.hasNext()) {
            ((InteractiveListener) it.next()).onRequestCompletion(context, interactiveRequestRecord, uri);
        }
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener
    public final void onRequestError(Context context, InteractiveRequestRecord interactiveRequestRecord, Exception exc) {
        Iterator it = this.f48437b.iterator();
        while (it.hasNext()) {
            ((InteractiveListener) it.next()).onRequestError(context, interactiveRequestRecord, exc);
        }
    }

    @Override // com.amazon.identity.auth.device.interactive.InteractiveListener, com.amazon.identity.auth.device.api.CancellableListener, com.amazon.identity.auth.device.api.Listener
    public final void onSuccess(Object obj) {
        Iterator it = this.f48437b.iterator();
        while (it.hasNext()) {
            ((InteractiveListener) it.next()).onSuccess(obj);
        }
    }
}
