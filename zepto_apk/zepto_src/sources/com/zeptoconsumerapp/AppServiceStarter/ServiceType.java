package com.zeptoconsumerapp.AppServiceStarter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata
/* loaded from: classes4.dex */
public final class ServiceType {

    /* renamed from: a, reason: collision with root package name */
    public static final ServiceType f47323a;

    /* renamed from: b, reason: collision with root package name */
    public static final ServiceType f47324b;

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ ServiceType[] f47325c;

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f47326d;

    static {
        ServiceType serviceType = new ServiceType("ORDER_CLEANUP", 0);
        f47323a = serviceType;
        ServiceType serviceType2 = new ServiceType("POIA", 1);
        f47324b = serviceType2;
        ServiceType[] serviceTypeArr = {serviceType, serviceType2};
        f47325c = serviceTypeArr;
        f47326d = EnumEntriesKt.a(serviceTypeArr);
    }

    public static ServiceType valueOf(String str) {
        return (ServiceType) Enum.valueOf(ServiceType.class, str);
    }

    public static ServiceType[] values() {
        return (ServiceType[]) f47325c.clone();
    }
}
