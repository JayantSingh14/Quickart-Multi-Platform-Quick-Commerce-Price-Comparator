package com.amazonaws.mobileconnectors.remoteconfiguration.internal.net;

import com.amazonaws.mobileconnectors.remoteconfiguration.Attributes;
import com.amazonaws.mobileconnectors.remoteconfiguration.internal.model.RemoteConfiguration;

@FunctionalInterface
/* loaded from: classes3.dex */
public interface RemoteConfigurationFetcher {
    RemoteConfiguration fetch(String str, Attributes attributes, String str2, String str3);
}
