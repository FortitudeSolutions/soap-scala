package com.fortitude

import javax.xml.bind.annotation.{XmlElement, XmlType, XmlAccessorType, XmlAccessType}
import scala.reflect.BeanProperty
import javax.jws.{WebParam, WebService}
import javax.ejb.Stateless

@XmlAccessorType(XmlAccessType.FIELD)
case class Request(msg: String) { def this() { this("") }}

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "output")
case class Response (msg: String){ def this() {this("") }}

@XmlAccessorType(XmlAccessType.FIELD)
case class ResponseException(why : String){  def this(){this("")}}

@XmlAccessorType(XmlAccessType.FIELD)
case class FaultResponse(@BeanProperty faultInfo : ResponseException) extends Exception { def this(){this(ResponseException(""))}}


@WebService(serviceName="TestWS", targetNamespace="http://sc.fortitude-solutions.com/ws")
@Stateless()
class Service {

  def sayHello(@WebParam(name="name") @XmlElement(required=true, nillable=false) req: Request): Response = {
    req match {
      case Request("") => Response("Please log in!")
      case Request(n) => Response(s"Hello, $n")
    }
  }
}

