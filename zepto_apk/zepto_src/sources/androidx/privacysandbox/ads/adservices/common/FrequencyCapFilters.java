package androidx.privacysandbox.ads.adservices.common;

import androidx.annotation.RestrictTo;
import androidx.fragment.app.e;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

@Metadata
@ExperimentalFeatures.Ext8OptIn
/* loaded from: classes3.dex */
public final class FrequencyCapFilters {

    /* renamed from: a, reason: collision with root package name */
    public final List f11193a;

    /* renamed from: b, reason: collision with root package name */
    public final List f11194b;

    /* renamed from: c, reason: collision with root package name */
    public final List f11195c;

    /* renamed from: d, reason: collision with root package name */
    public final List f11196d;

    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    @RestrictTo
    public @interface AdEventType {
    }

    @Metadata
    public static final class Companion {
    }

    @JvmOverloads
    public FrequencyCapFilters() {
        EmptyList keyedFrequencyCapsForClickEvents = EmptyList.f53609a;
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForClickEvents, "keyedFrequencyCapsForWinEvents");
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForClickEvents, "keyedFrequencyCapsForImpressionEvents");
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForClickEvents, "keyedFrequencyCapsForViewEvents");
        Intrinsics.checkNotNullParameter(keyedFrequencyCapsForClickEvents, "keyedFrequencyCapsForClickEvents");
        this.f11193a = keyedFrequencyCapsForClickEvents;
        this.f11194b = keyedFrequencyCapsForClickEvents;
        this.f11195c = keyedFrequencyCapsForClickEvents;
        this.f11196d = keyedFrequencyCapsForClickEvents;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrequencyCapFilters)) {
            return false;
        }
        FrequencyCapFilters frequencyCapFilters = (FrequencyCapFilters) obj;
        return Intrinsics.b(this.f11193a, frequencyCapFilters.f11193a) && Intrinsics.b(this.f11194b, frequencyCapFilters.f11194b) && Intrinsics.b(this.f11195c, frequencyCapFilters.f11195c) && Intrinsics.b(this.f11196d, frequencyCapFilters.f11196d);
    }

    public final int hashCode() {
        return this.f11196d.hashCode() + e.f(e.f(this.f11193a.hashCode() * 31, 31, this.f11194b), 31, this.f11195c);
    }

    public final String toString() {
        return "FrequencyCapFilters: keyedFrequencyCapsForWinEvents=" + this.f11193a + ", keyedFrequencyCapsForImpressionEvents=" + this.f11194b + ", keyedFrequencyCapsForViewEvents=" + this.f11195c + ", keyedFrequencyCapsForClickEvents=" + this.f11196d;
    }
}
