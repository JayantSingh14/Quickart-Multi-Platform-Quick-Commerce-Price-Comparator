package kotlinx.datetime.internal.format.parser;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public abstract class NumberConsumer<Receiver> {

    /* renamed from: a, reason: collision with root package name */
    public final Integer f55586a;

    /* renamed from: b, reason: collision with root package name */
    public final String f55587b;

    public NumberConsumer(Integer num, String str) {
        this.f55586a = num;
        this.f55587b = str;
    }

    public abstract NumberConsumptionError a(Copyable copyable, String str, int i2, int i3);

    public Integer b() {
        return this.f55586a;
    }
}
