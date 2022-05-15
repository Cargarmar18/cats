package com.endava.cats.fuzzer.fields;

import com.endava.cats.model.FuzzingData;
import io.quarkus.test.junit.QuarkusTest;
import io.swagger.v3.oas.models.media.NumberSchema;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

@QuarkusTest
class ExtremeNegativeValueDecimalFieldsFuzzerTest {
    private ExtremeNegativeValueDecimalFieldsFuzzer extremeNegativeValueDecimalFieldsFuzzer;

    @BeforeEach
    void setup() {
        extremeNegativeValueDecimalFieldsFuzzer = new ExtremeNegativeValueDecimalFieldsFuzzer(null, null, null, null);
    }

    @Test
    void givenANewExtremeNegativeValueDecimalFieldsFuzzer_whenCreatingANewInstance_thenTheMethodsBeingOverriddenAreMatchingTheDecimalFuzzer() {
        NumberSchema nrSchema = new NumberSchema();
        Assertions.assertThat(extremeNegativeValueDecimalFieldsFuzzer.getSchemasThatTheFuzzerWillApplyTo().stream().anyMatch(schema -> schema.isAssignableFrom(NumberSchema.class))).isTrue();
        Assertions.assertThat(extremeNegativeValueDecimalFieldsFuzzer.hasBoundaryDefined("test", FuzzingData.builder().build())).isTrue();
        Assertions.assertThat(extremeNegativeValueDecimalFieldsFuzzer.description()).isNotNull();
        Assertions.assertThat(extremeNegativeValueDecimalFieldsFuzzer.typeOfDataSentToTheService()).isNotNull();
        Assertions.assertThat(extremeNegativeValueDecimalFieldsFuzzer.getBoundaryValue(nrSchema)).isInstanceOf(BigDecimal.class);
    }
}

