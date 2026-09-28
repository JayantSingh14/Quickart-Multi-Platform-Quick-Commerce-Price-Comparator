package i;

import android.net.Uri;
import android.os.Bundle;
import com.amazon.identity.auth.device.ResponseManager;
import com.amazon.identity.auth.device.api.workflow.RequestContext;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.UUID;

/* loaded from: classes4.dex */
public final class b implements d {

    /* renamed from: f, reason: collision with root package name */
    public static final String f48438f = d.class.getName().concat(".instanceState");

    /* renamed from: a, reason: collision with root package name */
    public final c f48439a;

    /* renamed from: b, reason: collision with root package name */
    public final ResponseManager f48440b;

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f48441c;

    /* renamed from: d, reason: collision with root package name */
    public final WeakReference f48442d;

    /* renamed from: e, reason: collision with root package name */
    public UUID f48443e;

    public b(e eVar) {
        ResponseManager responseManagerA = ResponseManager.a();
        c cVarA = c.a();
        this.f48442d = new WeakReference(eVar);
        this.f48440b = responseManagerA;
        this.f48439a = cVarA;
        this.f48441c = new HashSet();
        this.f48443e = UUID.randomUUID();
    }

    public final void a(RequestContext requestContext) {
        boolean zContainsKey;
        Uri uri;
        LinkedList linkedList = new LinkedList();
        Iterator it = this.f48441c.iterator();
        while (it.hasNext()) {
            InteractiveRequestRecord interactiveRequestRecord = (InteractiveRequestRecord) it.next();
            String requestId = interactiveRequestRecord.getRequestId();
            ResponseManager responseManager = this.f48440b;
            synchronized (responseManager) {
                zContainsKey = responseManager.f15086a.containsKey(requestId);
            }
            if (zContainsKey) {
                Bundle bundle = interactiveRequestRecord.f15241c;
                Object objA = bundle != null ? ((e) this.f48442d.get()).a(bundle) : null;
                if (objA == null) {
                    objA = ((e) this.f48442d.get()).b();
                }
                RequestContext requestContext2 = (RequestContext) this.f48439a.f48445a.get(objA);
                if (requestContext2 == requestContext) {
                    Objects.toString(this.f48443e);
                    ResponseManager responseManager2 = this.f48440b;
                    synchronized (responseManager2) {
                        uri = (Uri) responseManager2.f15086a.remove(requestId);
                    }
                    requestContext2.processResponse(interactiveRequestRecord, uri);
                    linkedList.add(interactiveRequestRecord);
                } else {
                    continue;
                }
            }
        }
        this.f48441c.removeAll(linkedList);
    }
}
