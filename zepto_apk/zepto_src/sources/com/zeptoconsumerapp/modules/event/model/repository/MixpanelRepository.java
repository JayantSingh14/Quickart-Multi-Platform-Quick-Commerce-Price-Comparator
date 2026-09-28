package com.zeptoconsumerapp.modules.event.model.repository;

import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.zeptoconsumerapp.BuildConfig;
import com.zeptoconsumerapp.modules.base.ContextProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: classes.dex */
public final class MixpanelRepository implements BaseRepository {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f47648b = new Companion();

    /* renamed from: c, reason: collision with root package name */
    public static volatile MixpanelRepository f47649c;

    /* renamed from: a, reason: collision with root package name */
    public MixpanelAPI f47650a;

    @Metadata
    public static final class Companion {
    }

    @Override // com.zeptoconsumerapp.modules.event.model.repository.BaseRepository
    public final void a(String eventName, Map properties) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(properties, "properties");
        MixpanelAPI mixpanelAPIL = this.f47650a;
        if (mixpanelAPIL == null) {
            mixpanelAPIL = MixpanelAPI.l(ContextProvider.f47615b.a().a(), BuildConfig.MIXPANEL_KEY, null, false);
            this.f47650a = mixpanelAPIL;
            if (mixpanelAPIL == null) {
                Intrinsics.h("mixpanelInstance");
                throw null;
            }
        }
        mixpanelAPIL.y(eventName, new JSONObject(properties));
    }
}
