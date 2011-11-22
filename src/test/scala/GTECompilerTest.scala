package com_kjetland

import org.junit.Test
import java.io.File


class GTECompilerTest {

  @Test
  def testFindTemplateFiles {
    val files = GTECompiler.findTemplateFiles( new File("src/test/resources"))
    files foreach {println(_)}
  }
}