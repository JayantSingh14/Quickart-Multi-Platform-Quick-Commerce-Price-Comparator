package io.sentry.android.replay.util;

import android.graphics.Rect;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntSize;
import java.lang.reflect.Field;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class NodesKt {
    public static final Rect a(LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "<this>");
        if (layoutCoordinates2 == null) {
            layoutCoordinates2 = LayoutCoordinatesKt.findRootCoordinates(layoutCoordinates);
        }
        float f2 = IntSize.getWidth-impl(layoutCoordinates2.getSize-YbymL2g());
        float f3 = IntSize.getHeight-impl(layoutCoordinates2.getSize-YbymL2g());
        androidx.compose.ui.geometry.Rect rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(layoutCoordinates2, layoutCoordinates, false, 2, (Object) null);
        float left = rectLocalBoundingBoxOf$default.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > f2) {
            left = f2;
        }
        float top = rectLocalBoundingBoxOf$default.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > f3) {
            top = f3;
        }
        float right = rectLocalBoundingBoxOf$default.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= f2) {
            f2 = right;
        }
        float bottom = rectLocalBoundingBoxOf$default.getBottom();
        float f4 = bottom >= 0.0f ? bottom : 0.0f;
        if (f4 <= f3) {
            f3 = f4;
        }
        if (left == f2 || top == f3) {
            return new Rect();
        }
        long j2 = layoutCoordinates2.localToWindow-MK-Hz9U(OffsetKt.Offset(left, top));
        long j3 = layoutCoordinates2.localToWindow-MK-Hz9U(OffsetKt.Offset(f2, top));
        long j4 = layoutCoordinates2.localToWindow-MK-Hz9U(OffsetKt.Offset(f2, f3));
        long j5 = layoutCoordinates2.localToWindow-MK-Hz9U(OffsetKt.Offset(left, f3));
        float f5 = Offset.getX-impl(j2);
        float f6 = Offset.getX-impl(j3);
        float f7 = Offset.getX-impl(j5);
        float f8 = Offset.getX-impl(j4);
        float fMin = Math.min(f5, Math.min(f6, Math.min(f7, f8)));
        float fMax = Math.max(f5, Math.max(f6, Math.max(f7, f8)));
        float f9 = Offset.getY-impl(j2);
        float f10 = Offset.getY-impl(j3);
        float f11 = Offset.getY-impl(j5);
        float f12 = Offset.getY-impl(j4);
        return new Rect((int) fMin, (int) Math.min(f9, Math.min(f10, Math.min(f11, f12))), (int) fMax, (int) Math.max(f9, Math.max(f10, Math.max(f11, f12))));
    }

    public static final Painter b(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        List modifierInfo = layoutNode.getModifierInfo();
        int size = modifierInfo.size();
        for (int i2 = 0; i2 < size; i2++) {
            Modifier modifier = ((ModifierInfo) modifierInfo.get(i2)).getModifier();
            String name = modifier.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(name, "modifier::class.java.name");
            if (StringsKt.n(name, "Painter", false)) {
                try {
                    Field declaredField = modifier.getClass().getDeclaredField("painter");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(modifier);
                    if (obj instanceof Painter) {
                        return (Painter) obj;
                    }
                    return null;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }
        return null;
    }

    public static final TextAttributes c(LayoutNode layoutNode) {
        ColorProducer colorProducer;
        Intrinsics.checkNotNullParameter(layoutNode, "<this>");
        List modifierInfo = layoutNode.getModifierInfo();
        int size = modifierInfo.size();
        Color color = null;
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            Modifier modifier = ((ModifierInfo) modifierInfo.get(i2)).getModifier();
            String modifierClassName = modifier.getClass().getName();
            Intrinsics.checkNotNullExpressionValue(modifierClassName, "modifierClassName");
            if (StringsKt.n(modifierClassName, "Text", false)) {
                try {
                    Field declaredField = modifier.getClass().getDeclaredField("color");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(modifier);
                    colorProducer = obj instanceof ColorProducer ? (ColorProducer) obj : null;
                } catch (Throwable unused) {
                }
                color = colorProducer != null ? Color.box-impl(colorProducer.invoke-0d7_KjU()) : null;
            } else if (StringsKt.n(modifierClassName, "Fill", false)) {
                z = true;
            }
        }
        return new TextAttributes(color, z);
    }
}
