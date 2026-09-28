package kotlin.reflect;

import com.amazon.identity.auth.device.authorization.RegionUtil;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin
@Metadata
/* loaded from: classes3.dex */
public final class KVariance {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KVariance[] f53878a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f53879b;

    static {
        KVariance[] kVarianceArr = {new KVariance("INVARIANT", 0), new KVariance(RegionUtil.SubRegionUtil.SUB_REGION_STRING_IN, 1), new KVariance("OUT", 2)};
        f53878a = kVarianceArr;
        f53879b = EnumEntriesKt.a(kVarianceArr);
    }

    public static KVariance valueOf(String str) {
        return (KVariance) Enum.valueOf(KVariance.class, str);
    }

    public static KVariance[] values() {
        return (KVariance[]) f53878a.clone();
    }
}
