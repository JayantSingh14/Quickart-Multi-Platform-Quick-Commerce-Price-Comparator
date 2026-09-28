package com.facebook.react.uimanager.events;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

@Nullsafe
/* loaded from: classes.dex */
public abstract class Event<T extends Event> {
    private static int sUniqueID;

    @Nullable
    private EventAnimationDriverMatchSpec mEventAnimationDriverMatchSpec;
    private boolean mInitialized;
    private int mSurfaceId;
    private long mTimestampMs;
    private int mUniqueID;
    private int mViewTag;

    /* loaded from: classes3.dex */
    public interface EventAnimationDriverMatchSpec {
        boolean a(int i2, String str);
    }

    public Event() {
        int i2 = sUniqueID;
        sUniqueID = i2 + 1;
        this.mUniqueID = i2;
    }

    public boolean canCoalesce() {
        return true;
    }

    public T coalesce(T t) {
        return getTimestampMs() >= t.getTimestampMs() ? this : t;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), getEventData());
    }

    public void dispatchModern(RCTModernEventEmitter rCTModernEventEmitter) {
        if (getSurfaceId() != -1) {
            rCTModernEventEmitter.receiveEvent(getSurfaceId(), getViewTag(), getEventName(), canCoalesce(), getCoalescingKey(), getEventData(), getEventCategory());
        } else {
            dispatch(rCTModernEventEmitter);
        }
    }

    public final void dispose() {
        this.mInitialized = false;
        onDispose();
    }

    public boolean experimental_isSynchronous() {
        return false;
    }

    public short getCoalescingKey() {
        return (short) 0;
    }

    public EventAnimationDriverMatchSpec getEventAnimationDriverMatchSpec() {
        if (this.mEventAnimationDriverMatchSpec == null) {
            this.mEventAnimationDriverMatchSpec = new EventAnimationDriverMatchSpec() { // from class: com.facebook.react.uimanager.events.Event.1
                @Override // com.facebook.react.uimanager.events.Event.EventAnimationDriverMatchSpec
                public final boolean a(int i2, String str) {
                    Event event = Event.this;
                    return i2 == event.getViewTag() && str.equals(event.getEventName());
                }
            };
        }
        return this.mEventAnimationDriverMatchSpec;
    }

    public int getEventCategory() {
        return 2;
    }

    public WritableMap getEventData() {
        return null;
    }

    public abstract String getEventName();

    public final int getSurfaceId() {
        return this.mSurfaceId;
    }

    public final long getTimestampMs() {
        return this.mTimestampMs;
    }

    public int getUniqueID() {
        return this.mUniqueID;
    }

    public final int getViewTag() {
        return this.mViewTag;
    }

    public void init(int i2, int i3) {
        init(i2, i3, SystemClock.uptimeMillis());
    }

    public boolean isInitialized() {
        return this.mInitialized;
    }

    public void onDispose() {
    }

    public Event(int i2) {
        int i3 = sUniqueID;
        sUniqueID = i3 + 1;
        this.mUniqueID = i3;
        init(i2);
    }

    @Deprecated
    public void init(int i2) {
        init(-1, i2);
    }

    public void init(int i2, int i3, long j2) {
        this.mSurfaceId = i2;
        this.mViewTag = i3;
        this.mTimestampMs = j2;
        this.mInitialized = true;
    }

    public Event(int i2, int i3) {
        int i4 = sUniqueID;
        sUniqueID = i4 + 1;
        this.mUniqueID = i4;
        init(i2, i3);
    }
}
