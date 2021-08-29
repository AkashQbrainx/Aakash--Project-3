package com.qbrainx.main

import scala.io.StdIn
import com.qbrainx.util.JsonHelper.{jsArray, list1, toJson}
import spray.json.{JsArray, JsValue}
object Main extends App {
  def read(): Any = {

       val input = StdIn.readLine()
    val list: List[String] = input.split("->").toList
    if (input.startsWith("A") ) {
      toJson(list(1))
      read()
    }
    else if(input.charAt(0)=='R'){
      println(jsArray.prettyPrint)
      jsArray=JsArray.empty
      list1=Vector.empty
      read()
    }
    else{
      println("enter valid input")
      read()
    }
  }
  read()
}