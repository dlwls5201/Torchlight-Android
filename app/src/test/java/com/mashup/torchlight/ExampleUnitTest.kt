package com.mashup.torchlight

import org.junit.*

import org.junit.Assert.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @BeforeClass
    fun login() {
        val a = "login";
    }
    @Before
    fun before() {
        val a = "login";
    }
    @Test
    fun some1() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun some2() {
        assertEquals(3, 2 + 2)
    }
    @After
    fun after() {
        val a = "login out";
    }
    @AfterClass
    fun logout() {
        val a = "login out";
    }
}




