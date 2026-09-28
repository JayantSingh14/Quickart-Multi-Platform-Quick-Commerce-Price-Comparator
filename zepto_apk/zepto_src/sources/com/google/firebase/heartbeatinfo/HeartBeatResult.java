package com.google.firebase.heartbeatinfo;

import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.List;

@AutoValue
/* loaded from: classes4.dex */
public abstract class HeartBeatResult {
    public static HeartBeatResult a(String str, ArrayList arrayList) {
        return new AutoValue_HeartBeatResult(str, arrayList);
    }

    public abstract List b();

    public abstract String c();
}
