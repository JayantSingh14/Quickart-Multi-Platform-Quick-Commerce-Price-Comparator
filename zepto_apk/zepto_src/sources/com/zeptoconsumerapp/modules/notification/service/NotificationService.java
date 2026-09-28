package com.zeptoconsumerapp.modules.notification.service;

import android.support.v4.media.b;
import com.google.gson.reflect.TypeToken;
import com.zeptoconsumerapp.Startup.AppLifecycleManager;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.event.domain.LogEventUseCase;
import com.zeptoconsumerapp.modules.event.model.entity.Event;
import com.zeptoconsumerapp.modules.event.type.NotificationEventType;
import com.zeptoconsumerapp.modules.helper.StorageHelper;
import com.zeptoconsumerapp.modules.notification.constants.NotificationConfig;
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
/* loaded from: classes4.dex */
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
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zeptoconsumerapp.modules.notification.service.NotificationService.a(com.zeptoconsumerapp.services.ZMessageListenerService, com.google.firebase.messaging.RemoteMessage):void");
    }

    public static void b(String str, Map map) {
        Object objE;
        Object objE2;
        Object objE3;
        Object objC;
        StorageHelper.Companion companion = StorageHelper.f47656a;
        companion.a();
        try {
            objE = Utils.c().e(StorageHelper.a("tenant"), new TypeToken<String>() { // from class: com.zeptoconsumerapp.modules.notification.service.NotificationService$getGenericNotificationData$$inlined$get$1
            }.f45460b);
        } catch (Exception unused) {
            objE = (String) MapsKt.c();
        }
        String str2 = (String) objE;
        companion.a();
        try {
            objE2 = Utils.c().e(StorageHelper.a("userId"), new TypeToken<String>() { // from class: com.zeptoconsumerapp.modules.notification.service.NotificationService$getGenericNotificationData$$inlined$get$2
            }.f45460b);
        } catch (Exception unused2) {
            objE2 = (String) MapsKt.c();
        }
        String str3 = (String) objE2;
        companion.a();
        try {
            objE3 = Utils.c().e(StorageHelper.a(CLConstants.SALT_FIELD_DEVICE_ID), new TypeToken<String>() { // from class: com.zeptoconsumerapp.modules.notification.service.NotificationService$getGenericNotificationData$$inlined$get$3
            }.f45460b);
        } catch (Exception unused3) {
            objE3 = (String) MapsKt.c();
        }
        String str4 = (String) objE3;
        companion.a();
        try {
            objC = Utils.c().e(StorageHelper.a("deviceMeta"), new TypeToken<Map<String, ? extends Object>>() { // from class: com.zeptoconsumerapp.modules.notification.service.NotificationService$getGenericNotificationData$$inlined$get$4
            }.f45460b);
        } catch (Exception unused4) {
            objC = MapsKt.c();
        }
        Map map2 = (Map) objC;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str5 = AppLifecycleManager.f47551b;
        for (Map.Entry entry : map.entrySet()) {
            String str6 = (String) entry.getKey();
            Object value = entry.getValue();
            if (StringsKt.O(str6, "comms-", false)) {
                String strF = StringsKt.F(str6, "comms-");
                Intrinsics.d(value, "null cannot be cast to non-null type kotlin.Any");
                linkedHashMap.put(strF, value);
            }
        }
        if (map2 != null) {
            for (Map.Entry entry2 : map2.entrySet()) {
                linkedHashMap.put((String) entry2.getKey(), entry2.getValue());
            }
        }
        if (str4 == null) {
            str4 = "device id not found";
        }
        Pair pair = new Pair("device_id", str4);
        if (str3 == null) {
            str3 = "user id not found";
        }
        Pair pair2 = new Pair("user_id", str3);
        if (str2 == null) {
            str2 = "tenant not found";
        }
        Pair pair3 = new Pair("tenant", str2);
        if (str5 == null) {
            str5 = "app state not found";
        }
        LinkedHashMap linkedHashMapJ = MapsKt.j(MapsKt.h(new Pair("communication_id", map.get("communication_id")), new Pair(CLConstants.OTP_STATUS, str)), MapsKt.j(MapsKt.h(pair, pair2, pair3, new Pair("app_state", str5)), linkedHashMap));
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry3 : linkedHashMapJ.entrySet()) {
            if (entry3.getValue() != null) {
                linkedHashMap2.put(entry3.getKey(), entry3.getValue());
            }
        }
        NotificationEventType notificationEventType = NotificationEventType.f47651b;
        Event event = new Event("comms_status_updates", linkedHashMap2);
        Object obj = LogEventUseCase.f47644a;
        LogEventUseCase.Companion.a(event.b(), event.a());
        NotificationConfig[] notificationConfigArr = NotificationConfig.f47662a;
        Object obj2 = map.get("z_mix_sync");
        if (Intrinsics.b(obj2 instanceof String ? (String) obj2 : null, "ENABLED")) {
            LogEventUseCase.Companion.b(b.k(event.b(), "_app"), event.a());
        }
    }
}
