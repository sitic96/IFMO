#include "aduc812.h"
#include "led.h"

#define DIP_ON 0x55


unsigned char shr(unsigned char num) {
    return (num >> 1);
}

unsigned char shl(unsigned char num) {
    return (num << 1);
}

unsigned char calculateRightImage(unsigned char currentImage) {
    return shr(currentImage) | 0x80;
}

unsigned char calculateLeftImage(unsigned char currentImage) {
    return shl(currentImage) & 0xFE;
}

void delay(unsigned long ms) {
    volatile unsigned long i, j;

    for (j = 0; j < ms; j++) {
        for (i = 0; i < 50; i++);
    }
}


void main(void) {
    unsigned char led = 0x80;
    while (1) {
        unsigned char dipPosition = readdip();
        if (dipPosition == DIP_ON)
            leds(led);

        {
            while (led < 0xFF) {
                led = calculateRightImage(led);
                leds(led);
                delay(200);
            }
            while (led > 0x80) {
                led = calculateLeftImage(led);
                leds(led);
                delay(200);
            }

        }
        else
        {
            leds(~dipPosition);
            delay(200);
        }
    }
}