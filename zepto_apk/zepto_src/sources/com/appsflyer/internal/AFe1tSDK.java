package com.appsflyer.internal;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes3.dex */
public abstract class AFe1tSDK {

    @NotNull
    public static final AFa1zSDK AFa1zSDK = new AFa1zSDK(null);

    @NotNull
    private static final List<String> getRevenue = CollectionsKt.I(AFInAppEventType.ACHIEVEMENT_UNLOCKED, AFInAppEventType.AD_CLICK, AFInAppEventType.AD_VIEW, AFInAppEventType.ADD_PAYMENT_INFO, AFInAppEventType.ADD_TO_CART, AFInAppEventType.ADD_TO_WISH_LIST, AFInAppEventType.COMPLETE_REGISTRATION, AFInAppEventType.CONTENT_VIEW, AFInAppEventType.INITIATED_CHECKOUT, AFInAppEventType.INVITE, AFInAppEventType.LEVEL_ACHIEVED, AFInAppEventType.LIST_VIEW, AFInAppEventType.LOGIN, AFInAppEventType.OPENED_FROM_PUSH_NOTIFICATION, AFInAppEventType.PURCHASE, AFInAppEventType.RATE, AFInAppEventType.RE_ENGAGE, AFInAppEventType.SEARCH, AFInAppEventType.SHARE, AFInAppEventType.SPENT_CREDIT, AFInAppEventType.START_TRIAL, AFInAppEventType.SUBSCRIBE, AFInAppEventType.TRAVEL_BOOKING, AFInAppEventType.TUTORIAL_COMPLETION, AFInAppEventType.UPDATE);

    @NotNull
    public final String getMediationNetwork;

    @Metadata
    public static final class AFa1tSDK extends AFe1tSDK {

        @NotNull
        public static final AFa1tSDK INSTANCE = new AFa1tSDK();

        private AFa1tSDK() {
            super("install");
        }
    }

    @Metadata
    public static final class AFa1uSDK extends AFe1tSDK {

        @NotNull
        public static final AFa1uSDK INSTANCE = new AFa1uSDK();

        private AFa1uSDK() {
            super("af_sandbox_revenue");
        }
    }

    public static final class AFa1vSDK extends AFe1tSDK {

        @Nullable
        public final Integer getCurrencyIso4217Code;

        @NotNull
        private final String getMonetizationNetwork;

        @Nullable
        public final Float getRevenue;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AFa1vSDK(@NotNull String str, @Nullable Float f2, @Nullable Integer num) {
            super(str);
            Intrinsics.checkNotNullParameter(str, "");
            this.getMonetizationNetwork = str;
            this.getRevenue = f2;
            this.getCurrencyIso4217Code = num;
        }

        public final boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AFa1vSDK)) {
                return false;
            }
            AFa1vSDK aFa1vSDK = (AFa1vSDK) obj;
            return Intrinsics.b(this.getMonetizationNetwork, aFa1vSDK.getMonetizationNetwork) && Intrinsics.b(this.getRevenue, aFa1vSDK.getRevenue) && Intrinsics.b(this.getCurrencyIso4217Code, aFa1vSDK.getCurrencyIso4217Code);
        }

        public final int hashCode() {
            int iHashCode = this.getMonetizationNetwork.hashCode() * 31;
            Float f2 = this.getRevenue;
            int iHashCode2 = (iHashCode + (f2 == null ? 0 : f2.hashCode())) * 31;
            Integer num = this.getCurrencyIso4217Code;
            return iHashCode2 + (num != null ? num.hashCode() : 0);
        }

        @NotNull
        public final String toString() {
            return "PredefinedInAppEvent(name=" + this.getMonetizationNetwork + ", eventRevenue=" + this.getRevenue + ", eventCounter=" + this.getCurrencyIso4217Code + ")";
        }
    }

    @Metadata
    public static final class AFa1zSDK {
        private AFa1zSDK() {
        }

        @Nullable
        public static AFe1tSDK getRevenue(@NotNull AFh1rSDK aFh1rSDK) {
            String string;
            Object obj;
            String string2;
            Intrinsics.checkNotNullParameter(aFh1rSDK, "");
            if (aFh1rSDK.getCurrencyIso4217Code() == AFe1mSDK.CONVERSION) {
                return AFa1tSDK.INSTANCE;
            }
            Integer intOrNull = null;
            if (aFh1rSDK.getCurrencyIso4217Code() != AFe1mSDK.INAPP || !AFe1tSDK.getRevenue.contains(aFh1rSDK.areAllFieldsValid)) {
                return null;
            }
            Map<String, Object> map = aFh1rSDK.getMonetizationNetwork;
            Float fZ = (map == null || (obj = map.get(AFInAppEventParameterName.REVENUE)) == null || (string2 = obj.toString()) == null) ? null : StringsKt.Z(string2);
            Object obj2 = aFh1rSDK.AFAdRevenueData.get("iaecounter");
            if (obj2 != null && (string = obj2.toString()) != null) {
                intOrNull = StringsKt.toIntOrNull(string);
            }
            String str = aFh1rSDK.areAllFieldsValid;
            Intrinsics.checkNotNullExpressionValue(str, "");
            return new AFa1vSDK(str, fZ, intOrNull);
        }

        public /* synthetic */ AFa1zSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public AFe1tSDK(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.getMediationNetwork = str;
    }
}
