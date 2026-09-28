package com.amazonaws.mobileconnectors.remoteconfiguration.internal.model;

import com.amazonaws.mobileconnectors.remoteconfiguration.Configuration;

/* loaded from: classes3.dex */
public class RemoteConfigurationImpl implements RemoteConfiguration {

    /* renamed from: a, reason: collision with root package name */
    public final Configuration f15283a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15284b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15285c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15286d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f15287e;

    public RemoteConfigurationImpl(Configuration configuration, String str, int i2, String str2, boolean z) {
        if (str == null) {
            throw new NullPointerException("The Application Configuration ID may not be null");
        }
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("Invalid configuration origin.");
        }
        this.f15283a = configuration;
        this.f15284b = str;
        this.f15285c = i2;
        this.f15286d = str2;
        this.f15287e = z;
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration
    public String getAppConfigurationId() {
        return this.f15284b;
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration
    public Configuration getConfiguration() {
        return this.f15283a;
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration
    public String getEntityTag() {
        return this.f15286d;
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration
    public int getOrigin() {
        return this.f15285c;
    }

    @Override // com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration
    public boolean isUpdate() {
        return this.f15287e;
    }
}
