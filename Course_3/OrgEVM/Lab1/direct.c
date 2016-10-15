//
// Created by Sitora on 10.10.16.
//

int main() {
    char number_to_convert[] = "15";
    char hex[15];
    int int_number, mod;
    int index_in_hex_array = 0;


    for (int i = 0; i < (int) (sizeof(number_to_convert) / sizeof(number_to_convert[0])) - 1; i++) {
        int_number = int_number * 10 + (number_to_convert[i] - '0');
    }


    mod = int_number - (int_number / 16) * 16;


    do {
        int_number = int_number / 16;
        if (mod < 10) {
            hex[index_in_hex_array] = mod + 48;
        } else {
            hex[index_in_hex_array] = mod + 55;
        }
        index_in_hex_array++;
        mod = int_number - (int_number / 16) * 16;
    } while (int_number > 0);


    index_in_hex_array--;


    for (int i = 0; i < index_in_hex_array / 2; i++) {
        char temp = hex[index_in_hex_array];
        hex[index_in_hex_array] = hex[i];
        hex[i] = temp;
    }
}