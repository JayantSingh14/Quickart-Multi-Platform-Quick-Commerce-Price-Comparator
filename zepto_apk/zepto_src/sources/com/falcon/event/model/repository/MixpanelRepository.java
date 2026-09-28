package com.falcon.event.model.repository;

import android.content.Context;
import com.falcon.FalconConfig;
import com.falcon.FalconContextContainer;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.zeptoconsumerapp.BuildConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata
/* loaded from: classes3.dex */
public final class MixpanelRepository implements BaseRepository {

    /* renamed from: b, reason: collision with root package name */
    public static final Companion f20442b = new Companion();

    /* renamed from: c, reason: collision with root package name */
    public static volatile MixpanelRepository f20443c;

    /* renamed from: a, reason: collision with root package name */
    public MixpanelAPI f20444a;

    @Metadata
    public static final class Companion {
    }

    @Override // com.falcon.event.model.repository.BaseRepository
    public final void a(String eventName, Map properties) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(properties, "properties");
        MixpanelAPI mixpanelAPIL = this.f20444a;
        if (mixpanelAPIL == null) {
            if (FalconConfig.f20434b == null) {
                throw new IllegalStateException("FalconConfig is not initialized. Call FalconConfig.init() first.");
            }
            Context context = FalconContextContainer.f20435a;
            if (context == null) {
                throw new IllegalStateException("Application context is null in FalconContextContainer");
            }
            mixpanelAPIL = MixpanelAPI.l(context, BuildConfig.MIXPANEL_KEY, null, false);
            this.f20444a = mixpanelAPIL;
            if (mixpanelAPIL == null) {
                Intrinsics.h("mixpanelInstance");
                throw null;
            }
        }
        mixpanelAPIL.y(eventName, new JSONObject(properties));
    }
}
