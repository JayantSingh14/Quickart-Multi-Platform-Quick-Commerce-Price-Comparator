/**
 * Verifies Flipkart Rome ETA parsing (no browser).
 * Run: node scripts/verify-flipkart-eta.js
 */
'use strict';

const path = require('path');
require('dotenv').config({ path: path.join(__dirname, '..', '.env') });

const { parseFlipkartEta } = require('../flipkart.js');

function assert(cond, msg) {
  if (!cond) throw new Error(msg || 'assertion failed');
}

// Shape from user (12 min in label_0.value.text)
const sampleRomeEta = {
  RESPONSE: {
    pageData: { pageTitle: 'Flipkart Minutes' },
    slots: [
      {
        slotData: {
          widget: {
            data: {
              default_fk_address_bar_sub_layouts_sla_callout_minutes_1: {
                value: {
                  row_0: { visible: true },
                  label_1: {
                    value: {
                      type: 'com.flipkart.rome.datatypes.response.dls.components.LabelProps',
                      text: 'min',
                    },
                    visible: true,
                  },
                  label_0: {
                    value: {
                      type: 'com.flipkart.rome.datatypes.response.dls.components.LabelProps',
                      text: 12,
                    },
                    visible: true,
                  },
                },
                visible: true,
              },
            },
          },
        },
      },
    ],
  },
};

const unserviceable = {
  RESPONSE: { pageData: { pageTitle: 'Unserviceable area' } },
};

console.log('1) parseFlipkartEta (12 min nested widget)...');
const r1 = parseFlipkartEta(sampleRomeEta);
assert(r1 && r1.eta === 12 && r1.label === '12 min', `expected 12 min, got ${JSON.stringify(r1)}`);
console.log('   OK', r1);

console.log('2) parseFlipkartEta (unserviceable)...');
const r2 = parseFlipkartEta(unserviceable);
assert(r2 && r2.unavailable === true, `expected unavailable, got ${JSON.stringify(r2)}`);
console.log('   OK', r2);

console.log('All parser checks passed.');
