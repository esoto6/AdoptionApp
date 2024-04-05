package com.expeditors.adopter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractPersonTest {

    @Test
    @DisplayName("Constructor can't have an id of 0.")
    void testZeroID() {
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(0, "edwin Soto", "8436937981", "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor can't have an null name")
    void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, null, "84363931111", "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor can't have an empty string name")
    void testNameEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, "", "84363931111", "edwin@soto.com", true));
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, " ", "84363931111", "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor can't have an null phoneNumber")
    void testPhoneNumberNull(){
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, "Edwin Soto", null, "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor can't have an empty string name")
    void testPhoneNumberEmptyString() {
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, "Edwin Soto", "", "edwin@soto.com", true));
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, "Edwin Soto", " ", "edwin@soto.com", true));
    }
    @Test
    @DisplayName("Constructor has invalid characters in phoneNumber")
    void testInvalidPhoneNumberChar() {
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, "Edwin Soto", "abc-693-7981", "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor has invalid phoneNumber format")
    void testInvalidPhoneNumberFormat() {
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, "Edwin Soto", "8436937981", "edwin@soto.com", true));
    }

    @Test
    @DisplayName("Constructor has a Valid PhoneNumber")
    void testValidPhoneNumber(){
        Person person2 = new AbstractPerson(2,"Liam Soto", "843-693-7981", "liam@soto.com", true);
        assertEquals(person2.getPhoneNumber(), "843-693-7981");
    }

    @Test
    @DisplayName("Constructor has null email")
    void testNullEmail() {
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, "Edwin Soto", "8436937981", null, true));
    }

    @Test
    @DisplayName("Constructor has empty string in email")
    void TestEmptyStringEmail(){
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, "Edwin Soto", "8436937981", "", true));
        assertThrows(IllegalArgumentException.class, () -> new AbstractPerson(1, "Edwin Soto", "8436937981", " ", true));
    }
}