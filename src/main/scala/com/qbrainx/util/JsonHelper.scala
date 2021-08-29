package com.qbrainx.util
import com.qbrainx.model.Student
import spray.json.DefaultJsonProtocol.{IntJsonFormat, StringJsonFormat, jsonFormat2}
import spray.json._

object JsonHelper {

      var jsArray: JsArray = JsArray.empty
      var list1: Vector[JsValue] = Vector.empty

  def toJson(input: String) = {
        implicit val a: RootJsonFormat[Student] = jsonFormat2(Student)

        val add: JsValue = (dataConverter(input).toJson)
            list1 = list1.appended(add)
            jsArray = JsArray.apply(list1)
            jsArray.prettyPrint
     }
     def dataConverter(input: String) = input.split(",") match {
      case Array(a, b) => Student(a.replace("(", ""), b.replace(")", "").toInt)
    }
  }
