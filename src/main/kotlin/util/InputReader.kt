package main.kotlin.util

import java.io.File
const val INPUT_DIR = "src/main/resources/input."

class InputReader {

    fun readToString(fileName: String): String {
        return File(INPUT_DIR + fileName).readText()
    }
}