package com.swmansion.reanimated.keyboard;

import com.facebook.react.bridge.ReactApplicationContext;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class KeyboardAnimationManager {
    private final Keyboard mKeyboard;
    private final WindowsInsetsManager mWindowsInsetsManager;
    private int mNextListenerId = 0;
    private final ConcurrentHashMap<Integer, KeyboardWorkletWrapper> mListeners = new ConcurrentHashMap<>();

    public KeyboardAnimationManager(WeakReference<ReactApplicationContext> weakReference) {
        Keyboard keyboard = new Keyboard();
        this.mKeyboard = keyboard;
        this.mWindowsInsetsManager = new WindowsInsetsManager(weakReference, keyboard, new a(this));
    }

    public void notifyAboutKeyboardChange() {
        Iterator<KeyboardWorkletWrapper> it = this.mListeners.values().iterator();
        while (it.hasNext()) {
            it.next().invoke(this.mKeyboard.getState().asInt(), this.mKeyboard.getHeight());
        }
    }

    public int subscribeForKeyboardUpdates(KeyboardWorkletWrapper keyboardWorkletWrapper, boolean z, boolean z2) {
        int i2 = this.mNextListenerId;
        this.mNextListenerId = i2 + 1;
        if (this.mListeners.isEmpty()) {
            this.mWindowsInsetsManager.startObservingChanges(new KeyboardAnimationCallback(this.mKeyboard, new a(this), z2), z, z2);
        }
        this.mListeners.put(Integer.valueOf(i2), keyboardWorkletWrapper);
        return i2;
    }

    public void unsubscribeFromKeyboardUpdates(int i2) {
        this.mListeners.remove(Integer.valueOf(i2));
        if (this.mListeners.isEmpty()) {
            this.mWindowsInsetsManager.stopObservingChanges();
        }
    }
}
