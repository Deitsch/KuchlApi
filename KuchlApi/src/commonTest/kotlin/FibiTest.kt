package io.github.kotlin.fibonacci

import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

class FibiTest {

    @Test
    fun `test 3rd element`() {
        assertEquals(firstElement + secondElement, generateFibi().take(3).last())
    }

    @Test
    fun `test pokeapi`() = runTest {
        val pokeApi = RemotePokeApi()
        val response = pokeApi.getPokemon()

        // Check the count of pokemon from the response
        assertEquals(1302, response.count)

        // Optionally check the first pokemon name
        assertEquals("bulbasaur", response.results.first().name)
    }
}