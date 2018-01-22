import org.apache.log4j.Logger

object Application extends App {

  val log = Logger.getLogger(getClass)
  //scalastyle:off
  val clientObject1 = ClientSideCommission(4)
  val clientObject2 = ClientSideCommission(5)
  val clientObject3 = ClientSideCommission(1)
  //scalstyle:on
  val listOfClient = List(clientObject1, clientObject2, clientObject3)

  //scalastyle:off
  val streetObject1 = StreetSideCommission(3)
  val streetObject2 = StreetSideCommission(3)
  val streetObject3 = StreetSideCommission(4)
  //scalstyle:on
  val listOfStreet = List(streetObject1, streetObject2, streetObject3)

  val obj = new TotalCommission
  val clientSideCommission = obj.getTotalCommission(listOfClient)
  val streetSideCommission = obj.getTotalCommission(listOfStreet)

  log.info(s"$clientSideCommission \n")
  log.info(streetSideCommission)

}
