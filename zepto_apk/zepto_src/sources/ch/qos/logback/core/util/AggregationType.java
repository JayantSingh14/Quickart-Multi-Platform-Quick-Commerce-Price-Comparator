package ch.qos.logback.core.util;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class AggregationType {

    /* renamed from: a, reason: collision with root package name */
    public static final AggregationType f13790a;

    /* renamed from: b, reason: collision with root package name */
    public static final AggregationType f13791b;

    /* renamed from: c, reason: collision with root package name */
    public static final AggregationType f13792c;

    /* renamed from: d, reason: collision with root package name */
    public static final AggregationType f13793d;

    /* renamed from: e, reason: collision with root package name */
    public static final AggregationType f13794e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AggregationType[] f13795f;

    static {
        AggregationType aggregationType = new AggregationType("NOT_FOUND", 0);
        f13790a = aggregationType;
        AggregationType aggregationType2 = new AggregationType("AS_BASIC_PROPERTY", 1);
        f13791b = aggregationType2;
        AggregationType aggregationType3 = new AggregationType("AS_COMPLEX_PROPERTY", 2);
        f13792c = aggregationType3;
        AggregationType aggregationType4 = new AggregationType("AS_BASIC_PROPERTY_COLLECTION", 3);
        f13793d = aggregationType4;
        AggregationType aggregationType5 = new AggregationType("AS_COMPLEX_PROPERTY_COLLECTION", 4);
        f13794e = aggregationType5;
        f13795f = new AggregationType[]{aggregationType, aggregationType2, aggregationType3, aggregationType4, aggregationType5};
    }

    public static AggregationType valueOf(String str) {
        return (AggregationType) Enum.valueOf(AggregationType.class, str);
    }

    public static AggregationType[] values() {
        return (AggregationType[]) f13795f.clone();
    }
}
