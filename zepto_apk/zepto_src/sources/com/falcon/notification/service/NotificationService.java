package com.falcon.notification.service;

import android.support.v4.media.b;
import com.falcon.event.domain.LogEventUseCase;
import com.falcon.event.model.entity.Event;
import com.falcon.event.model.repository.BaseRepository;
import com.falcon.event.model.repository.EventRepository;
import com.falcon.event.model.repository.MixpanelRepository;
import com.falcon.event.type.NotificationEventType;
import com.falcon.falconModule.StorageHelper;
import com.falcon.notification.constants.NotificationConfig;
import com.falcon.notification.utils.JsonUtils;
import com.falcon.notification.utils.NotificationUtils;
import com.google.gson.reflect.TypeToken;
import io.sentry.Sentry;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class NotificationService {

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(com.zeptoconsumerapp.services.ZMessageListenerService r9, com.google.firebase.messaging.RemoteMessage r10) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.falcon.notification.service.NotificationService.a(com.zeptoconsumerapp.services.ZMessageListenerService, com.google.firebase.messaging.RemoteMessage):void");
    }

    public static void b(String data) {
        Intrinsics.checkNotNullParameter(data, "data");
        try {
            c("STATUS_CLICKED", JsonUtils.a(data));
        } catch (Exception e2) {
            Sentry.a(e2);
        }
    }

    public static void c(String str, Map map) {
        Object objE;
        Object objE2;
        Object objE3;
        Object objC;
        Map mapC;
        Object objC2;
        StorageHelper.Companion companion = StorageHelper.f20452a;
        companion.a();
        try {
            objE = NotificationUtils.Companion.c().e(StorageHelper.a("tenant"), new TypeToken<String>() { // from class: com.falcon.notification.service.NotificationService$getGenericNotificationData$$inlined$get$1
            }.f45460b);
        } catch (Exception unused) {
            objE = (String) MapsKt.c();
        }
        String str2 = (String) objE;
        companion.a();
        try {
            objE2 = NotificationUtils.Companion.c().e(StorageHelper.a("userId"), new TypeToken<String>() { // from class: com.falcon.notification.service.NotificationService$getGenericNotificationData$$inlined$get$2
            }.f45460b);
        } catch (Exception unused2) {
            objE2 = (String) MapsKt.c();
        }
        Object obj = (String) objE2;
        companion.a();
        try {
            objE3 = NotificationUtils.Companion.c().e(StorageHelper.a(CLConstants.SALT_FIELD_DEVICE_ID), new TypeToken<String>() { // from class: com.falcon.notification.service.NotificationService$getGenericNotificationData$$inlined$get$3
            }.f45460b);
        } catch (Exception unused3) {
            objE3 = (String) MapsKt.c();
        }
        String str3 = (String) objE3;
        companion.a();
        try {
            objC = NotificationUtils.Companion.c().e(StorageHelper.a("deviceMeta"), new TypeToken<Map<String, ? extends Object>>() { // from class: com.falcon.notification.service.NotificationService$getGenericNotificationData$$inlined$get$4
            }.f45460b);
        } catch (Exception unused4) {
            objC = MapsKt.c();
        }
        Map map2 = (Map) objC;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str4 = (String) entry.getKey();
            Object value = entry.getValue();
            if (StringsKt.O(str4, "comms-", false)) {
                String strF = StringsKt.F(str4, "comms-");
                Intrinsics.d(value, "null cannot be cast to non-null type kotlin.Any");
                linkedHashMap.put(strF, value);
            }
        }
        if (map2 != null) {
            for (Map.Entry entry2 : map2.entrySet()) {
                linkedHashMap.put((String) entry2.getKey(), entry2.getValue());
            }
        }
        Object obj2 = map.get("communication_id");
        if (obj2 == null) {
            obj2 = "communication_id not found";
        }
        if (str3 == null) {
            str3 = "device id not found";
        }
        Pair pair = new Pair("device_id", str3);
        if (obj == null) {
            obj = obj2;
        }
        Pair pair2 = new Pair("user_id", obj);
        if (str2 == null) {
            str2 = "tenant not found";
        }
        LinkedHashMap linkedHashMapJ = MapsKt.j(MapsKt.h(new Pair("communication_id", map.get("communication_id")), new Pair(CLConstants.OTP_STATUS, str)), MapsKt.j(MapsKt.h(pair, pair2, new Pair("tenant", str2)), linkedHashMap));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry3 : linkedHashMapJ.entrySet()) {
            if (entry3.getValue() != null) {
                linkedHashMap2.put(entry3.getKey(), entry3.getValue());
            }
        }
        NotificationEventType[] notificationEventTypeArr = NotificationEventType.f20445a;
        Event event = new Event("comms_status_updates", linkedHashMap2);
        String eventName = event.b();
        Map properties = event.a();
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(properties, "properties");
        try {
            companion.a();
            try {
                objC2 = NotificationUtils.Companion.c().e(StorageHelper.a("experimentData"), new TypeToken<Map<String, ? extends Object>>() { // from class: com.falcon.event.domain.LogEventUseCase$Companion$getCommonProperties$$inlined$get$1
                }.f45460b);
            } catch (Exception unused5) {
                objC2 = MapsKt.c();
            }
            Map map3 = (Map) objC2;
            mapC = map3 != null ? MapsKt.g(new Pair("experimentData", map3)) : MapsKt.c();
        } catch (Exception unused6) {
            mapC = MapsKt.c();
        }
        LinkedHashMap linkedHashMapJ2 = MapsKt.j(mapC, properties);
        BaseRepository baseRepository = (BaseRepository) LogEventUseCase.Companion.a().get(EventRepository.class);
        if (baseRepository != null) {
            baseRepository.a(eventName, linkedHashMapJ2);
        }
        NotificationConfig[] notificationConfigArr = NotificationConfig.f20458a;
        Object obj3 = map.get("z_mix_sync");
        if (Intrinsics.b(obj3 instanceof String ? (String) obj3 : null, "ENABLED")) {
            String eventName2 = b.k(event.b(), "_app");
            Map properties2 = event.a();
            Intrinsics.checkNotNullParameter(eventName2, "eventName");
            Intrinsics.checkNotNullParameter(properties2, "properties");
            BaseRepository baseRepository2 = (BaseRepository) LogEventUseCase.Companion.a().get(MixpanelRepository.class);
            if (baseRepository2 != null) {
                baseRepository2.a(eventName2, properties2);
            }
        }
    }
}
