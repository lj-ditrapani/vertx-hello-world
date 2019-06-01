package info.ditrapani

import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    @Test fun testAppHasAGreeting() {
        val classUnderTest = Main()
        assertEquals("Hello world!", classUnderTest.greeting())
    }
}
