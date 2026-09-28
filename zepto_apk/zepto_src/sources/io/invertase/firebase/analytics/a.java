package io.invertase.firebase.analytics;

import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.EnumMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public final /* synthetic */ class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f49217a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UniversalFirebaseAnalyticsModule f49218b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bundle f49219c;

    public /* synthetic */ a(UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule, Bundle bundle, int i2) {
        this.f49217a = i2;
        this.f49218b = universalFirebaseAnalyticsModule;
        this.f49219c = bundle;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f49217a) {
            case 0:
                UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule = this.f49218b;
                universalFirebaseAnalyticsModule.getClass();
                Bundle bundle = this.f49219c;
                Set<String> setKeySet = bundle.keySet();
                FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(universalFirebaseAnalyticsModule.f49247a);
                for (String str : setKeySet) {
                    firebaseAnalytics.f43527a.p(null, str, (String) bundle.get(str), false);
                }
                break;
            case 1:
                UniversalFirebaseAnalyticsModule universalFirebaseAnalyticsModule2 = this.f49218b;
                universalFirebaseAnalyticsModule2.getClass();
                Bundle bundle2 = this.f49219c;
                boolean z = bundle2.getBoolean("analytics_storage");
                boolean z2 = bundle2.getBoolean("ad_storage");
                boolean z3 = bundle2.getBoolean("ad_user_data");
                boolean z4 = bundle2.getBoolean("ad_personalization");
                EnumMap enumMap = new EnumMap(FirebaseAnalytics.ConsentType.class);
                FirebaseAnalytics.ConsentType consentType = FirebaseAnalytics.ConsentType.f43533b;
                FirebaseAnalytics.ConsentStatus consentStatus = FirebaseAnalytics.ConsentStatus.f43530b;
                FirebaseAnalytics.ConsentStatus consentStatus2 = FirebaseAnalytics.ConsentStatus.f43529a;
                enumMap.put((EnumMap) consentType, (FirebaseAnalytics.ConsentType) (z ? consentStatus2 : consentStatus));
                FirebaseAnalytics.ConsentType consentType2 = FirebaseAnalytics.ConsentType.f43532a;
                enumMap.put((EnumMap) consentType2, (FirebaseAnalytics.ConsentType) (z2 ? consentStatus2 : consentStatus));
                FirebaseAnalytics.ConsentType consentType3 = FirebaseAnalytics.ConsentType.f43534c;
                enumMap.put((EnumMap) consentType3, (FirebaseAnalytics.ConsentType) (z3 ? consentStatus2 : consentStatus));
                FirebaseAnalytics.ConsentType consentType4 = FirebaseAnalytics.ConsentType.f43535d;
                if (z4) {
                    consentStatus = consentStatus2;
                }
                enumMap.put((EnumMap) consentType4, (FirebaseAnalytics.ConsentType) consentStatus);
                FirebaseAnalytics firebaseAnalytics2 = FirebaseAnalytics.getInstance(universalFirebaseAnalyticsModule2.f49247a);
                firebaseAnalytics2.getClass();
                Bundle bundle3 = new Bundle();
                FirebaseAnalytics.ConsentStatus consentStatus3 = (FirebaseAnalytics.ConsentStatus) enumMap.get(consentType2);
                if (consentStatus3 != null) {
                    int iOrdinal = consentStatus3.ordinal();
                    if (iOrdinal == 0) {
                        bundle3.putString("ad_storage", "granted");
                    } else if (iOrdinal == 1) {
                        bundle3.putString("ad_storage", "denied");
                    }
                }
                FirebaseAnalytics.ConsentStatus consentStatus4 = (FirebaseAnalytics.ConsentStatus) enumMap.get(consentType);
                if (consentStatus4 != null) {
                    int iOrdinal2 = consentStatus4.ordinal();
                    if (iOrdinal2 == 0) {
                        bundle3.putString("analytics_storage", "granted");
                    } else if (iOrdinal2 == 1) {
                        bundle3.putString("analytics_storage", "denied");
                    }
                }
                FirebaseAnalytics.ConsentStatus consentStatus5 = (FirebaseAnalytics.ConsentStatus) enumMap.get(consentType3);
                if (consentStatus5 != null) {
                    int iOrdinal3 = consentStatus5.ordinal();
                    if (iOrdinal3 == 0) {
                        bundle3.putString("ad_user_data", "granted");
                    } else if (iOrdinal3 == 1) {
                        bundle3.putString("ad_user_data", "denied");
                    }
                }
                FirebaseAnalytics.ConsentStatus consentStatus6 = (FirebaseAnalytics.ConsentStatus) enumMap.get(consentType4);
                if (consentStatus6 != null) {
                    int iOrdinal4 = consentStatus6.ordinal();
                    if (iOrdinal4 == 0) {
                        bundle3.putString("ad_personalization", "granted");
                    } else if (iOrdinal4 == 1) {
                        bundle3.putString("ad_personalization", "denied");
                    }
                }
                firebaseAnalytics2.f43527a.w(bundle3);
                break;
            default:
                FirebaseAnalytics firebaseAnalytics3 = FirebaseAnalytics.getInstance(this.f49218b.f49247a);
                Bundle bundle4 = this.f49219c;
                if (bundle4 != null) {
                    firebaseAnalytics3.getClass();
                    bundle4 = new Bundle(bundle4);
                }
                firebaseAnalytics3.f43527a.i(bundle4);
                break;
        }
        return null;
    }
}
