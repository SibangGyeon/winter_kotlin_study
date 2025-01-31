package org.example.day16.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day16.repository_exam.data_source.image.ImageDataSourceImpl
import org.example.day16.repository_exam.repository.image.ImageRepositoryImpl
import java.io.File

fun main(): Unit = runBlocking {
    val imageRepository = ImageRepositoryImpl(ImageDataSourceImpl())
    val url = "https://i.pinimg.com/474x/87/a1/a3/87a1a3111c93a554bc768df6e225238c.jpg"
    val urls = File("image_urls.txt").readLines()
    val directory = "image_test_directory"


    val downloadInfo = imageRepository.saveImage(url, "$directory/도지18.txt")
    val downloadInfoList = imageRepository.saveImages(urls, directory)

    println(downloadInfo.startTime)
    println(downloadInfo.endTime)
    println("=========")
    println(downloadInfo.elapsedTime)
    println(downloadInfo.fileSize)

    downloadInfoList.forEach{
        println(it.startTime)
        println(it.endTime)
        println("=========")
        println(it.elapsedTime)
        println(it.fileSize)
    }

    File("${directory}/도지18.txt").delete()
    File("${directory}/도지11.txt").delete()
    File("${directory}/도지12.txt").delete()
    File("${directory}/도지13.txt").delete()
    File("${directory}/도지14.txt").delete()
    File("${directory}/도지15.txt").delete()
}