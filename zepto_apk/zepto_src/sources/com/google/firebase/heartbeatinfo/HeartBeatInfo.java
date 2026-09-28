package com.google.firebase.heartbeatinfo;

/* loaded from: classes.dex */
public interface HeartBeatInfo {

    public enum HeartBeat {
        NONE(0),
        /* JADX INFO: Fake field, exist only in values array */
        SDK(1),
        GLOBAL(2),
        /* JADX INFO: Fake field, exist only in values array */
        COMBINED(3);


        /* renamed from: a, reason: collision with root package name */
        public final int f44553a;

        HeartBeat(int i2) {
            this.f44553a = i2;
        }
    }

    HeartBeat b();
}
