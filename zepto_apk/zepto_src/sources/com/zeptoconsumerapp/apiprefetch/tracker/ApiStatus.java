package com.zeptoconsumerapp.apiprefetch.tracker;

import androidx.annotation.Keep;
import com.amazon.android.apay.commonlibrary.interfaces.external.MerchantConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Keep
@Metadata
/* loaded from: classes4.dex */
public final class ApiStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ApiStatus[] $VALUES;
    public static final ApiStatus NOT_STARTED = new ApiStatus("NOT_STARTED", 0);
    public static final ApiStatus IN_PROGRESS = new ApiStatus("IN_PROGRESS", 1);
    public static final ApiStatus SUCCESS = new ApiStatus(MerchantConstants.SUCCESS, 2);
    public static final ApiStatus ERROR = new ApiStatus(MerchantConstants.ERROR, 3);

    private static final /* synthetic */ ApiStatus[] $values() {
        return new ApiStatus[]{NOT_STARTED, IN_PROGRESS, SUCCESS, ERROR};
    }

    static {
        ApiStatus[] apiStatusArr$values = $values();
        $VALUES = apiStatusArr$values;
        $ENTRIES = EnumEntriesKt.a(apiStatusArr$values);
    }

    private ApiStatus(String str, int i2) {
    }

    @NotNull
    public static EnumEntries<ApiStatus> getEntries() {
        return $ENTRIES;
    }

    public static ApiStatus valueOf(String str) {
        return (ApiStatus) Enum.valueOf(ApiStatus.class, str);
    }

    public static ApiStatus[] values() {
        return (ApiStatus[]) $VALUES.clone();
    }
}
