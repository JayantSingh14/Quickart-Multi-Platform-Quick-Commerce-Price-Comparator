package com.zeptoconsumerapp.Startup;

import android.content.Context;
import coil3.disk.a;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.phoenix.IPhoenixDelegate;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.event.domain.LogEventUseCase;
import com.zeptoconsumerapp.modules.event.model.entity.Event;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import okhttp3.OkHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import timber.log.Timber;

@Metadata
/* loaded from: classes.dex */
public final class AppPhoenixManager implements IPhoenixDelegate {

    /* renamed from: b, reason: collision with root package name */
    public static EventContext f47553b = new EventContext(false);

    /* renamed from: a, reason: collision with root package name */
    public final Context f47554a;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    public static final class EventContext {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f47555a;

        public EventContext() {
            this(false);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof EventContext) && this.f47555a == ((EventContext) obj).f47555a;
        }

        public final int hashCode() {
            return Boolean.hashCode(this.f47555a);
        }

        public final String toString() {
            return "EventContext(isFromSilentPush=" + this.f47555a + ")";
        }

        public EventContext(boolean z) {
            this.f47555a = z;
        }
    }

    public AppPhoenixManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f47554a = context;
    }

    @Override // com.phoenix.IPhoenixDelegate
    public final void a(String eventName, JSONObject params) throws JSONException {
        Context context = this.f47554a;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(params, "params");
        try {
            params.put("is_app_in_foreground", AppLifecycleManager.f47550a);
            params.put("is_from_silent_push", f47553b.f47555a);
            params.remove("fetch_url");
            params.put("event_name", eventName);
            String strF = Utils.f(context);
            params.put("is_anonymous", Utils.g(context));
            params.put("userId", strF);
            Iterator<String> itKeys = params.keys();
            Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
            Map mapM = MapsKt.m(SequencesKt.n(SequencesKt.c(itKeys), new a(params, 3)));
            Timber.d("AppInitializer").d("Logging event: eventType=app_generic_events_v1, data=" + mapM, new Object[0]);
            if (PhoenixEventNames.a().contains(eventName)) {
                Event event = new Event("app_generic_events_v1", mapM);
                Object obj = LogEventUseCase.f47644a;
                LogEventUseCase.Companion.a(event.b(), event.a());
            }
        } catch (Exception e2) {
            Timber.d("AppInitializer").e(e2, "Error occurred in onEventOccurred", new Object[0]);
        }
    }

    public final OkHttpClient b() {
        OkHttpClient okHttpClientB = OkHttpClientProvider.b();
        Intrinsics.checkNotNullExpressionValue(okHttpClientB, "getOkHttpClient(...)");
        return okHttpClientB;
    }
}
