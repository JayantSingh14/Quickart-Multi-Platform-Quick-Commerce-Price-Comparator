package com.amazon.identity.auth.device.api.workflow;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.fragment.app.FragmentActivity;
import com.amazon.identity.auth.device.AuthError;
import com.amazon.identity.auth.device.b;
import com.amazon.identity.auth.device.interactive.InteractiveAPI;
import com.amazon.identity.auth.device.interactive.InteractiveListener;
import com.amazon.identity.auth.device.interactive.InteractiveRequest;
import com.amazon.identity.auth.device.interactive.InteractiveRequestRecord;
import com.amazon.identity.auth.internal.BrowsingExperienceManager;
import i.c;
import i.f;
import i.g;
import i.h;
import i.i;
import i.j;
import i.k;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class RequestContext {

    /* renamed from: b, reason: collision with root package name */
    public final g f15123b;

    /* renamed from: d, reason: collision with root package name */
    public final Intent f15125d;

    /* renamed from: e, reason: collision with root package name */
    public final CustomTabsIntent f15126e;

    /* renamed from: a, reason: collision with root package name */
    public final UUID f15122a = UUID.randomUUID();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f15124c = new HashMap();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f15127a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f15128b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ InteractiveRequestRecord f15129c;

        public a(Context context, Uri uri, InteractiveRequestRecord interactiveRequestRecord) {
            this.f15127a = context;
            this.f15128b = uri;
            this.f15129c = interactiveRequestRecord;
        }

        @Override // java.lang.Runnable
        public final void run() throws AuthError {
            b bVar;
            try {
                Context context = this.f15127a;
                synchronized (b.class) {
                    try {
                        if (b.f15200c == null) {
                            b.f15200c = new b(BrowsingExperienceManager.getInstance(context));
                        }
                        bVar = b.f15200c;
                    } finally {
                    }
                }
                Uri uri = this.f15128b;
                Context context2 = this.f15127a;
                RequestContext requestContext = RequestContext.this;
                bVar.getClass();
                String strA = b.a(uri);
                uri.toString();
                com.amazon.identity.auth.device.a aVar = (com.amazon.identity.auth.device.a) bVar.f15201a.remove(strA);
                if (aVar != null) {
                    if (requestContext != null) {
                        aVar.getOriginalRequest().setRequestContext(requestContext);
                    }
                    if (aVar.handleResponse(uri, context2)) {
                        return;
                    }
                    bVar.b(aVar, context2);
                    return;
                }
                Uri uri2 = this.f15128b;
                String queryParameter = uri2.getQueryParameter("state");
                if (queryParameter == null) {
                    throw new AuthError("Response does not have a state parameter: " + uri2.toString(), AuthError.ERROR_TYPE.ERROR_SERVER_REPSONSE);
                }
                HashMap map = new HashMap();
                for (String str : TextUtils.split(queryParameter, "&")) {
                    String[] strArrSplit = TextUtils.split(str, "=");
                    if (strArrSplit != null && strArrSplit.length == 2) {
                        map.put(strArrSplit[0], strArrSplit[1]);
                    }
                }
                Iterator it = RequestContext.this.a((String) map.get("InteractiveRequestType"), f.class).iterator();
                while (it.hasNext()) {
                    ((f) it.next()).onRequestCompletion(this.f15127a, this.f15129c, this.f15128b);
                }
            } catch (Exception unused) {
                Objects.toString(RequestContext.this.f15122a);
            }
        }
    }

    public RequestContext(g gVar, Intent intent, CustomTabsIntent customTabsIntent) {
        this.f15123b = gVar;
        this.f15125d = intent;
        this.f15126e = customTabsIntent;
    }

    public static RequestContext a(g gVar, Intent intent, CustomTabsIntent customTabsIntent) {
        Object objB = gVar.b();
        RequestContext requestContext = (RequestContext) c.a().f48445a.get(objB);
        if (requestContext != null) {
            Objects.toString(requestContext.f15122a);
            Objects.toString(gVar.b());
            return requestContext;
        }
        RequestContext requestContext2 = new RequestContext(gVar, intent, customTabsIntent);
        c.a().f48445a.put(objB, requestContext2);
        Objects.toString(requestContext2.f15122a);
        Objects.toString(gVar.b());
        return requestContext2;
    }

    public static RequestContext create(Activity activity, Intent intent, CustomTabsIntent customTabsIntent) {
        return a(new h(activity), intent, customTabsIntent);
    }

    public void assertListenerPresent(InteractiveAPI interactiveAPI) throws ListenerNotFoundException {
        if (interactiveAPI == null) {
            throw new IllegalArgumentException("api must be non-null");
        }
        a(interactiveAPI.getRequestType(), null);
    }

    public <T extends InteractiveListener<S, U, V>, S, U, V> InteractiveListener<S, U, V> getAggregateListener(InteractiveRequest<T, S, U, V> interactiveRequest) throws ListenerNotFoundException {
        return new i.a(interactiveRequest.getRequestType(), getListeners(interactiveRequest, interactiveRequest.getListenerClass()));
    }

    public Context getContext() {
        return this.f15123b.a();
    }

    public CustomTabsIntent getCustomTabsIntent() {
        return this.f15126e;
    }

    public Intent getInvokingIntent() {
        return this.f15125d;
    }

    public <T> Set<T> getListeners(InteractiveAPI interactiveAPI, Class<T> cls) {
        if (interactiveAPI == null) {
            throw new IllegalArgumentException("api must be non-null");
        }
        if (cls != null) {
            return a(interactiveAPI.getRequestType(), cls);
        }
        throw new IllegalArgumentException("listenerClass must be non-null");
    }

    public void onResume() {
        Objects.toString(this.f15122a);
        i.b bVarC = this.f15123b.c();
        if (bVarC == null) {
            Objects.toString(this.f15122a);
            return;
        }
        synchronized (bVarC) {
            try {
                boolean z = bVarC.f48441c.size() > 0;
                boolean z2 = bVarC.f48440b.f15086a.size() > 0;
                if (z && z2) {
                    bVarC.a(this);
                } else {
                    Objects.toString(bVarC.f48443e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void onStartRequest(InteractiveRequestRecord interactiveRequestRecord) {
        if (interactiveRequestRecord == null) {
            throw new IllegalArgumentException("request must be non-null");
        }
        Objects.toString(this.f15122a);
        interactiveRequestRecord.getRequestId();
        this.f15123b.a(interactiveRequestRecord);
    }

    public void processResponse(InteractiveRequestRecord interactiveRequestRecord, Uri uri) {
        if (interactiveRequestRecord == null) {
            throw new IllegalArgumentException("request must be non-null");
        }
        if (uri == null) {
            throw new IllegalArgumentException("uri must be non-null");
        }
        Objects.toString(this.f15122a);
        uri.toString();
        j.a.f53504b.execute(new a(this.f15123b.a(), uri, interactiveRequestRecord));
    }

    public void registerListener(InteractiveListener<?, ?, ?> interactiveListener) {
        if (interactiveListener == null) {
            throw new IllegalArgumentException("listener must be non-null");
        }
        String requestType = interactiveListener.getRequestType();
        Objects.toString(this.f15122a);
        interactiveListener.toString();
        synchronized (this.f15124c) {
            try {
                Set hashSet = (Set) this.f15124c.get(requestType);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    this.f15124c.put(requestType, hashSet);
                }
                hashSet.add(interactiveListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean unregisterListener(InteractiveListener<?, ?, ?> interactiveListener) {
        if (interactiveListener == null) {
            throw new IllegalArgumentException("listener must be non-null");
        }
        String requestType = interactiveListener.getRequestType();
        Objects.toString(this.f15122a);
        interactiveListener.toString();
        synchronized (this.f15124c) {
            try {
                Set set = (Set) this.f15124c.get(requestType);
                if (set == null) {
                    return false;
                }
                return set.remove(interactiveListener);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static RequestContext create(Activity activity) {
        return a(new h(activity), null, null);
    }

    @SuppressLint({"NewApi"})
    public static RequestContext create(Fragment fragment, Intent intent, CustomTabsIntent customTabsIntent) {
        return a(new j(fragment), intent, customTabsIntent);
    }

    @SuppressLint({"NewApi"})
    public static RequestContext create(Fragment fragment) {
        return a(new j(fragment), null, null);
    }

    public static RequestContext create(FragmentActivity fragmentActivity, Intent intent, CustomTabsIntent customTabsIntent) {
        return a(new i(fragmentActivity), intent, customTabsIntent);
    }

    public static RequestContext create(FragmentActivity fragmentActivity) {
        return a(new i(fragmentActivity), null, null);
    }

    public static RequestContext create(androidx.fragment.app.Fragment fragment, Intent intent, CustomTabsIntent customTabsIntent) {
        return a(new k(fragment), intent, customTabsIntent);
    }

    public static RequestContext create(androidx.fragment.app.Fragment fragment) {
        return a(new k(fragment), null, null);
    }

    public final HashSet a(String str, Class cls) throws ListenerNotFoundException {
        Set set;
        if (str != null) {
            synchronized (this.f15124c) {
                set = (Set) this.f15124c.get(str);
            }
            if (set == null || set.isEmpty()) {
                StringBuilder sbY = android.support.v4.media.b.y("No listeners were registered with type \"", str, "\" for RequestContext ");
                sbY.append(this.f15122a);
                sbY.append(". Listener types present: ");
                sbY.append(this.f15124c.keySet());
                throw new ListenerNotFoundException(sbY.toString());
            }
            if (cls == null) {
                return null;
            }
            HashSet hashSet = new HashSet(set.size());
            Iterator it = set.iterator();
            while (it.hasNext()) {
                try {
                    hashSet.add(cls.cast((InteractiveListener) it.next()));
                } catch (ClassCastException e2) {
                    throw new ListenerNotFoundException("Failed to retrieve listener of class type \"" + cls.toString() + "\" for request type \"" + str + "\"", e2);
                }
            }
            return hashSet;
        }
        throw new IllegalArgumentException("requestType must be non-null");
    }
}
