package com.bumptech.glide.load;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes3.dex */
public final class DataSource {

    /* renamed from: a, reason: collision with root package name */
    public static final DataSource f15788a;

    /* renamed from: b, reason: collision with root package name */
    public static final DataSource f15789b;

    /* renamed from: c, reason: collision with root package name */
    public static final DataSource f15790c;

    /* renamed from: d, reason: collision with root package name */
    public static final DataSource f15791d;

    /* renamed from: e, reason: collision with root package name */
    public static final DataSource f15792e;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ DataSource[] f15793f;

    static {
        DataSource dataSource = new DataSource("LOCAL", 0);
        f15788a = dataSource;
        DataSource dataSource2 = new DataSource("REMOTE", 1);
        f15789b = dataSource2;
        DataSource dataSource3 = new DataSource("DATA_DISK_CACHE", 2);
        f15790c = dataSource3;
        DataSource dataSource4 = new DataSource("RESOURCE_DISK_CACHE", 3);
        f15791d = dataSource4;
        DataSource dataSource5 = new DataSource("MEMORY_CACHE", 4);
        f15792e = dataSource5;
        f15793f = new DataSource[]{dataSource, dataSource2, dataSource3, dataSource4, dataSource5};
    }

    public static DataSource valueOf(String str) {
        return (DataSource) Enum.valueOf(DataSource.class, str);
    }

    public static DataSource[] values() {
        return (DataSource[]) f15793f.clone();
    }
}
