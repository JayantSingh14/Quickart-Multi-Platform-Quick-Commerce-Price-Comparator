import { useState, useEffect, useCallback } from 'react';

const CART_KEY = 'quickart_cart_v1';

function loadCart() {
  try {
    const raw = localStorage.getItem(CART_KEY);
    return raw ? JSON.parse(raw) : [];
  } catch {
    return [];
  }
}

export function useCart() {
  const [items, setItems] = useState(loadCart);

  useEffect(() => {
    try {
      localStorage.setItem(CART_KEY, JSON.stringify(items));
    } catch {
      // localStorage quota exceeded — ignore
    }
  }, [items]);

  const addItem = useCallback((sku) => {
    setItems((prev) => {
      const idx = prev.findIndex(
        (i) => i.platform === sku.platform && i.platformId === sku.platformId
      );
      if (idx !== -1) {
        return prev.map((item, i) =>
          i === idx ? { ...item, quantity: item.quantity + 1 } : item
        );
      }
      return [
        ...prev,
        {
          platform: sku.platform,
          platformId: sku.platformId,
          name: sku.rawName,
          brand: sku.brand,
          displayQuantity: sku.displayQuantity,
          quantity: 1,
          unitPrice: sku.price,
          mrp: sku.mrp,
          imageUrl: sku.imageUrl,
          deepLink: sku.deepLink,
          groupId: sku.groupId,
        },
      ];
    });
  }, []);

  const removeItem = useCallback((platform, platformId) => {
    setItems((prev) =>
      prev.filter((i) => !(i.platform === platform && i.platformId === platformId))
    );
  }, []);

  const updateQty = useCallback((platform, platformId, quantity) => {
    if (quantity <= 0) {
      removeItem(platform, platformId);
      return;
    }
    setItems((prev) =>
      prev.map((i) =>
        i.platform === platform && i.platformId === platformId
          ? { ...i, quantity }
          : i
      )
    );
  }, [removeItem]);

  const clearCart = useCallback(() => setItems([]), []);

  const isInCart = useCallback(
    (platform, platformId) =>
      items.some((i) => i.platform === platform && i.platformId === platformId),
    [items]
  );

  const getQty = useCallback(
    (platform, platformId) =>
      items.find((i) => i.platform === platform && i.platformId === platformId)
        ?.quantity ?? 0,
    [items]
  );

  // Group by platform for cart drawer
  const byPlatform = items.reduce((acc, item) => {
    if (!acc[item.platform]) acc[item.platform] = [];
    acc[item.platform].push(item);
    return acc;
  }, {});

  const totalItems = items.reduce((s, i) => s + i.quantity, 0);
  const totalPrice = items.reduce((s, i) => s + i.quantity * i.unitPrice, 0);

  return {
    items,
    byPlatform,
    totalItems,
    totalPrice,
    addItem,
    removeItem,
    updateQty,
    clearCart,
    isInCart,
    getQty,
  };
}
