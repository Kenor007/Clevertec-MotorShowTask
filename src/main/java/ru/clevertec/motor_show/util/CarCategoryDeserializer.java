package ru.clevertec.motor_show.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import ru.clevertec.motor_show.enums.category.CarCategory;

import java.io.IOException;
import java.util.Arrays;

public class CarCategoryDeserializer extends JsonDeserializer<CarCategory> {

    @Override
    public CarCategory deserialize(JsonParser parser, DeserializationContext context) throws IOException {
        String value = parser.getText().trim().toUpperCase();
        try {
            return CarCategory.valueOf(value);
        } catch (IllegalArgumentException e) {
            throw new InvalidFormatException(
                    parser,
                    "Invalid value for CarCategory. Must be one of: " + Arrays.toString(CarCategory.values()),
                    value,
                    CarCategory.class
            );
        }
    }
}
