package com.expeditors.adopter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AdopterImplTest {

    @Test
    @DisplayName("Constructor 3 Args")
    void testThreeArgsConstructor(){
        Adopter person1 = new AdopterImpl("Edwin Soto", "843-111-1111", "edwin@soto");
        assertInstanceOf(Adopter.class, person1);
    }

    @Test
    @DisplayName("Constructor can't have an null name")
    void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, null, "843-111-1111", "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor can't have an empty string name")
    void testNameEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, "", "843-111-1111", "edwin@soto.com", true));
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, " ", "843-111-1111", "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor can't have an null phoneNumber")
    void testPhoneNumberNull(){
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, "Edwin Soto", null, "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor can't have an empty string name")
    void testPhoneNumberEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, "Edwin Soto", "", "edwin@soto.com", true));
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, "Edwin Soto", " ", "edwin@soto.com", true));
    }
    @Test
    @DisplayName("Constructor has invalid characters in phoneNumber")
    void testInvalidPhoneNumberChar() {
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, "Edwin Soto", "abc-111-1111", "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor has invalid phoneNumber format")
    void testInvalidPhoneNumberFormat() {
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, "Edwin Soto", "8-436-1111-111", "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor has a Valid PhoneNumber")
    void testValidPhoneNumber(){
        Adopter person2 = new AdopterImpl(2,"Liam Soto", "843-111-1111", "liam@soto.com", true);
        assertEquals(person2.getPhoneNumber(), "843-111-1111");
    }

    @Test
    @DisplayName("Constructor has null email")
    void testNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, "Edwin Soto", "8431111111", null, true));
    }

    @Test
    @DisplayName("Constructor has empty string in email")
    void TestEmptyStringEmail(){
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, "Edwin Soto", "843111111", "", true));
        assertThrows(IllegalArgumentException.class, () -> new AdopterImpl(1, "Edwin Soto", "8431111111", " ", true));
    }
}