package com.facebook.react.fabric.mounting.mountitems;

import android.os.Trace;
import android.support.v4.media.b;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.events.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.SurfaceMountingManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.systrace.Systrace;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@DoNotStrip
@Nullsafe
/* loaded from: classes3.dex */
final class IntBufferBatchMountItem implements BatchMountItem {
    static final int INSTRUCTION_CREATE = 2;
    static final int INSTRUCTION_DELETE = 4;
    static final int INSTRUCTION_FLAG_MULTIPLE = 1;
    static final int INSTRUCTION_INSERT = 8;
    static final int INSTRUCTION_REMOVE = 16;
    static final int INSTRUCTION_UPDATE_EVENT_EMITTER = 256;
    static final int INSTRUCTION_UPDATE_LAYOUT = 128;
    static final int INSTRUCTION_UPDATE_OVERFLOW_INSET = 1024;
    static final int INSTRUCTION_UPDATE_PADDING = 512;
    static final int INSTRUCTION_UPDATE_PROPS = 32;
    static final int INSTRUCTION_UPDATE_STATE = 64;
    static final String TAG = "IntBufferBatchMountItem";
    private final int mCommitNumber;
    private final int[] mIntBuffer;
    private final int mIntBufferLen;
    private final Object[] mObjBuffer;
    private final int mObjBufferLen;
    private final int mSurfaceId;

    public IntBufferBatchMountItem(int i2, int[] iArr, Object[] objArr, int i3) {
        this.mSurfaceId = i2;
        this.mCommitNumber = i3;
        this.mIntBuffer = iArr;
        this.mObjBuffer = objArr;
        this.mIntBufferLen = iArr.length;
        this.mObjBufferLen = objArr.length;
    }

    private void beginMarkers(String str) {
        Systrace.a("IntBufferBatchMountItem::" + str);
        int i2 = this.mCommitNumber;
        if (i2 > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_START, null, i2);
        }
    }

    private void endMarkers() {
        int i2 = this.mCommitNumber;
        if (i2 > 0) {
            ReactMarker.logFabricMarker(ReactMarkerConstants.FABRIC_BATCH_EXECUTION_END, null, i2);
        }
        Trace.endSection();
    }

    private static String nameForInstructionString(int i2) {
        return i2 == 2 ? "CREATE" : i2 == 4 ? "DELETE" : i2 == 8 ? "INSERT" : i2 == 16 ? "REMOVE" : i2 == 32 ? "UPDATE_PROPS" : i2 == 64 ? "UPDATE_STATE" : i2 == 128 ? "UPDATE_LAYOUT" : i2 == 512 ? "UPDATE_PADDING" : i2 == 1024 ? "UPDATE_OVERFLOW_INSET" : i2 == 256 ? "UPDATE_EVENT_EMITTER" : "UNKNOWN";
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public void execute(MountingManager mountingManager) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        SurfaceMountingManager surfaceManager = mountingManager.getSurfaceManager(this.mSurfaceId);
        if (surfaceManager == null) {
            FLog.i(TAG, "Skipping batch of MountItems; no SurfaceMountingManager found for [%d].", Integer.valueOf(this.mSurfaceId));
            return;
        }
        if (surfaceManager.isStopped()) {
            FLog.i(TAG, "Skipping batch of MountItems; was stopped [%d].", Integer.valueOf(this.mSurfaceId));
            return;
        }
        if (ReactNativeFeatureFlags.f18968a.enableFabricLogs()) {
            FLog.c(TAG, "Executing IntBufferBatchMountItem on surface [%d]", Integer.valueOf(this.mSurfaceId));
        }
        beginMarkers("mountViews");
        int i7 = 0;
        int i8 = 0;
        while (i7 < this.mIntBufferLen) {
            int[] iArr = this.mIntBuffer;
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            int i11 = i10 & (-2);
            if ((i10 & 1) != 0) {
                int i12 = iArr[i9];
                i9 = i7 + 2;
                i2 = i12;
            } else {
                i2 = 1;
            }
            String[] args = {"numInstructions", String.valueOf(i2)};
            String sectionName = "IntBufferBatchMountItem::mountInstructions::" + nameForInstructionString(i11);
            Intrinsics.checkNotNullParameter(sectionName, "sectionName");
            Intrinsics.checkNotNullParameter(args, "args");
            StringBuilder sb = new StringBuilder();
            String str = args[0];
            String str2 = args[1];
            sb.append(str);
            sb.append('=');
            sb.append(str2);
            String string = sb.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            androidx.tracing.Trace.b(sectionName + CLConstants.SALT_DELIMETER + string);
            int i13 = i8;
            int i14 = i9;
            for (int i15 = 0; i15 < i2; i15++) {
                if (i11 == 2) {
                    String fabricComponentName = FabricNameComponentMapping.getFabricComponentName((String) this.mObjBuffer[i13]);
                    int[] iArr2 = this.mIntBuffer;
                    int i16 = i14;
                    int i17 = iArr2[i16];
                    Object[] objArr = this.mObjBuffer;
                    ReadableMap readableMap = (ReadableMap) objArr[i13 + 1];
                    int i18 = i13 + 3;
                    StateWrapper stateWrapper = (StateWrapper) objArr[i13 + 2];
                    i13 += 4;
                    EventEmitterWrapper eventEmitterWrapper = (EventEmitterWrapper) objArr[i18];
                    int i19 = i16 + 2;
                    surfaceManager.createView(fabricComponentName, i17, readableMap, stateWrapper, eventEmitterWrapper, iArr2[i14 + 1] == 1);
                    i14 = i19;
                } else {
                    int i20 = i14;
                    if (i11 == 4) {
                        surfaceManager.deleteView(this.mIntBuffer[i20]);
                        i14 = i20 + 1;
                    } else {
                        if (i11 == 8) {
                            int[] iArr3 = this.mIntBuffer;
                            i6 = i20 + 3;
                            surfaceManager.addViewAt(iArr3[i20 + 1], iArr3[i20], iArr3[i20 + 2]);
                        } else if (i11 == 16) {
                            int[] iArr4 = this.mIntBuffer;
                            i6 = i20 + 3;
                            surfaceManager.removeViewAt(iArr4[i20], iArr4[i20 + 1], iArr4[i20 + 2]);
                        } else {
                            if (i11 == 32) {
                                i3 = i20 + 1;
                                i4 = i13 + 1;
                                surfaceManager.updateProps(this.mIntBuffer[i20], (ReadableMap) this.mObjBuffer[i13]);
                            } else if (i11 == 64) {
                                i3 = i20 + 1;
                                i4 = i13 + 1;
                                surfaceManager.updateState(this.mIntBuffer[i20], (StateWrapper) this.mObjBuffer[i13]);
                            } else if (i11 == 128) {
                                int[] iArr5 = this.mIntBuffer;
                                surfaceManager.updateLayout(iArr5[i20], iArr5[i20 + 1], iArr5[i20 + 2], iArr5[i20 + 3], iArr5[i20 + 4], iArr5[i20 + 5], iArr5[i20 + 6], iArr5[i20 + 7]);
                                i14 = i20 + 8;
                            } else {
                                if (i11 == 512) {
                                    int[] iArr6 = this.mIntBuffer;
                                    int i21 = iArr6[i20];
                                    int i22 = iArr6[i20 + 1];
                                    int i23 = iArr6[i20 + 2];
                                    int i24 = i20 + 4;
                                    int i25 = iArr6[i20 + 3];
                                    i5 = i20 + 5;
                                    surfaceManager.updatePadding(i21, i22, i23, i25, iArr6[i24]);
                                } else if (i11 == 1024) {
                                    int[] iArr7 = this.mIntBuffer;
                                    int i26 = iArr7[i20];
                                    int i27 = iArr7[i20 + 1];
                                    int i28 = iArr7[i20 + 2];
                                    int i29 = i20 + 4;
                                    int i30 = iArr7[i20 + 3];
                                    i5 = i20 + 5;
                                    surfaceManager.updateOverflowInset(i26, i27, i28, i30, iArr7[i29]);
                                } else {
                                    if (i11 != 256) {
                                        throw new IllegalArgumentException(b.d(i11, i20, "Invalid type argument to IntBufferBatchMountItem: ", " at index: "));
                                    }
                                    i3 = i20 + 1;
                                    i4 = i13 + 1;
                                    surfaceManager.updateEventEmitter(this.mIntBuffer[i20], (EventEmitterWrapper) this.mObjBuffer[i13]);
                                }
                                i14 = i5;
                            }
                            i14 = i3;
                            i13 = i4;
                        }
                        i14 = i6;
                    }
                }
            }
            Trace.endSection();
            i7 = i14;
            i8 = i13;
        }
        endMarkers();
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.MountItem
    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    @Override // com.facebook.react.fabric.mounting.mountitems.BatchMountItem
    public boolean isBatchEmpty() {
        return this.mIntBufferLen == 0;
    }

    public String toString() {
        int i2;
        int i3;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("IntBufferBatchMountItem [surface:%d]:\n", Integer.valueOf(this.mSurfaceId)));
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.mIntBufferLen) {
                int[] iArr = this.mIntBuffer;
                int i6 = i4 + 1;
                int i7 = iArr[i4];
                int i8 = i7 & (-2);
                int i9 = 1;
                if ((i7 & 1) != 0) {
                    i9 = iArr[i6];
                    i6 = i4 + 2;
                }
                i4 = i6;
                for (int i10 = 0; i10 < i9; i10++) {
                    if (i8 == 2) {
                        String fabricComponentName = FabricNameComponentMapping.getFabricComponentName((String) this.mObjBuffer[i5]);
                        i5 += 4;
                        int i11 = i4 + 1;
                        Integer numValueOf = Integer.valueOf(this.mIntBuffer[i4]);
                        i4 += 2;
                        sb.append(String.format("CREATE [%d] - layoutable:%d - %s\n", numValueOf, Integer.valueOf(this.mIntBuffer[i11]), fabricComponentName));
                    } else if (i8 == 4) {
                        sb.append(String.format("DELETE [%d]\n", Integer.valueOf(this.mIntBuffer[i4])));
                        i4++;
                    } else if (i8 == 8) {
                        Integer numValueOf2 = Integer.valueOf(this.mIntBuffer[i4]);
                        int i12 = i4 + 2;
                        Integer numValueOf3 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                        i4 += 3;
                        sb.append(String.format("INSERT [%d]->[%d] @%d\n", numValueOf2, numValueOf3, Integer.valueOf(this.mIntBuffer[i12])));
                    } else if (i8 == 16) {
                        Integer numValueOf4 = Integer.valueOf(this.mIntBuffer[i4]);
                        int i13 = i4 + 2;
                        Integer numValueOf5 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                        i4 += 3;
                        sb.append(String.format("REMOVE [%d]->[%d] @%d\n", numValueOf4, numValueOf5, Integer.valueOf(this.mIntBuffer[i13])));
                    } else {
                        if (i8 == 32) {
                            i2 = i5 + 1;
                            Object obj = this.mObjBuffer[i5];
                            i3 = i4 + 1;
                            sb.append(String.format("UPDATE PROPS [%d]: %s\n", Integer.valueOf(this.mIntBuffer[i4]), FabricUIManager.IS_DEVELOPMENT_ENVIRONMENT ? obj != null ? obj.toString() : "<null>" : "<hidden>"));
                        } else if (i8 == 64) {
                            i2 = i5 + 1;
                            StateWrapper stateWrapper = (StateWrapper) this.mObjBuffer[i5];
                            i3 = i4 + 1;
                            sb.append(String.format("UPDATE STATE [%d]: %s\n", Integer.valueOf(this.mIntBuffer[i4]), FabricUIManager.IS_DEVELOPMENT_ENVIRONMENT ? stateWrapper != null ? stateWrapper.toString() : "<null>" : "<hidden>"));
                        } else if (i8 == 128) {
                            int[] iArr2 = this.mIntBuffer;
                            int i14 = iArr2[i4];
                            int i15 = iArr2[i4 + 1];
                            int i16 = iArr2[i4 + 2];
                            int i17 = iArr2[i4 + 3];
                            int i18 = iArr2[i4 + 4];
                            int i19 = iArr2[i4 + 5];
                            int i20 = i4 + 7;
                            int i21 = iArr2[i4 + 6];
                            i4 += 8;
                            sb.append(String.format("UPDATE LAYOUT [%d]->[%d]: x:%d y:%d w:%d h:%d displayType:%d layoutDirection: %d\n", Integer.valueOf(i15), Integer.valueOf(i14), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i21), Integer.valueOf(iArr2[i20])));
                        } else if (i8 == 512) {
                            Integer numValueOf6 = Integer.valueOf(this.mIntBuffer[i4]);
                            Integer numValueOf7 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                            Integer numValueOf8 = Integer.valueOf(this.mIntBuffer[i4 + 2]);
                            int i22 = i4 + 4;
                            Integer numValueOf9 = Integer.valueOf(this.mIntBuffer[i4 + 3]);
                            i4 += 5;
                            sb.append(String.format("UPDATE PADDING [%d]: top:%d right:%d bottom:%d left:%d\n", numValueOf6, numValueOf7, numValueOf8, numValueOf9, Integer.valueOf(this.mIntBuffer[i22])));
                        } else if (i8 == 1024) {
                            Integer numValueOf10 = Integer.valueOf(this.mIntBuffer[i4]);
                            Integer numValueOf11 = Integer.valueOf(this.mIntBuffer[i4 + 1]);
                            Integer numValueOf12 = Integer.valueOf(this.mIntBuffer[i4 + 2]);
                            int i23 = i4 + 4;
                            Integer numValueOf13 = Integer.valueOf(this.mIntBuffer[i4 + 3]);
                            i4 += 5;
                            sb.append(String.format("UPDATE OVERFLOWINSET [%d]: left:%d top:%d right:%d bottom:%d\n", numValueOf10, numValueOf11, numValueOf12, numValueOf13, Integer.valueOf(this.mIntBuffer[i23])));
                        } else {
                            if (i8 != 256) {
                                FLog.g(TAG, "String so far: " + sb.toString());
                                throw new IllegalArgumentException("Invalid type argument to IntBufferBatchMountItem: " + i8 + " at index: " + i4);
                            }
                            i5++;
                            sb.append(String.format("UPDATE EVENTEMITTER [%d]\n", Integer.valueOf(this.mIntBuffer[i4])));
                            i4++;
                        }
                        i4 = i3;
                        i5 = i2;
                    }
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            FLog.h(TAG, "Caught exception trying to print", e2);
            StringBuilder sb2 = new StringBuilder();
            for (int i24 = 0; i24 < this.mIntBufferLen; i24++) {
                sb2.append(this.mIntBuffer[i24]);
                sb2.append(", ");
            }
            FLog.g(TAG, sb2.toString());
            for (int i25 = 0; i25 < this.mObjBufferLen; i25++) {
                String str = TAG;
                Object obj2 = this.mObjBuffer[i25];
                FLog.g(str, obj2 != null ? obj2.toString() : "null");
            }
            return "";
        }
    }
}
