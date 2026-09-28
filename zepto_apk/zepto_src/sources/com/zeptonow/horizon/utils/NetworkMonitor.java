package com.zeptonow.horizon.utils;

import kotlin.Metadata;
import kotlinx.coroutines.flow.StateFlow;

@Metadata
/* loaded from: classes.dex */
public interface NetworkMonitor {
    StateFlow isConnected();
}
