import Total._

import scala.reflect.runtime.universe._

abstract class Commission(value: Int)

case class StreetSideCommission(value: Int) extends Commission(value: Int)

case class ClientSideCommission(value: Int) extends Commission(value: Int)

class TotalCommission {

  def getTotalCommission[T <: Commission: TypeTag](list: List[T]): String ={
    list.totalDisplayCommission
  }

}
