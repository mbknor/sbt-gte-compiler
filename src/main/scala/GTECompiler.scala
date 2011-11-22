package com_kjetland

class GTECompilerPlugin extends sbt.Plugin {
  import sbt._
  import Keys._

  val newTask = TaskKey[Unit]("xxxx")

  sourceGenerators in Compile <+= (sourceDirectory in Compile, sourceManaged in Compile) map lookForFilesAndCompile

  def lookForFilesAndCompile(sourceDirectory: File, generatedDir: File) = {
    System.out.println("lookForFilesAndCompile: " + sourceDirectory + " " + generatedDir);

    (generatedDir ** "*.template.scalaXXXX").get.map(_.getAbsoluteFile)
  }
}


object GTECompiler {
  import java.io.File
  /**
   * Finds all template files under sourceDirectory, checks if it need to be regenerated, then do it
   */
  def findAndCompile(sourceDirectory: File, generatedDir: File) = {
    // look for view-folder
    val viewFolder = new File(sourceDirectory, "view");
    
    val templateFiles = findTemplateFiles(viewFolder)
    
  }

  def findTemplateFiles( folder : File) : List[File] = {
    val l = folder.listFiles().toList map {file : File => {
      val f :List[File] = if ( file.isDirectory) {
        findTemplateFiles( file )
      } else {
        List(file)
      }
      f
    }}

    l.flatten
  }
}

