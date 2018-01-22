import scala.reflect.runtime.universe._

object Total {

  sealed trait CommissionDisplay {
    def totalDisplayCommission: String
  }

  def calculateSum[T <: Commission: TypeTag](list: List[T]): Int = {

    def innerSum[T <: Commission: TypeTag](list: List[T], sum: Int): Int = {
      list match {
        case head :: tail => head match {
          case StreetSideCommission(value) => innerSum(tail, value + sum)
          case ClientSideCommission(value) => innerSum(tail, value + sum)
        }
        case Nil => sum
      }
    }

    innerSum(list, 0)
  }

  implicit def calculateCommission[T <: Commission: TypeTag](list: List[T]): String = {
    val sum = calculateSum(list)
    typeOf[List[T]] match {
      case listType if listType =:= typeOf[List[ClientSideCommission]] => s"The total client commission is: $sum"
      case listType if listType =:= typeOf[List[StreetSideCommission]] => s"The total street commission is: $sum"
    }
  }

  implicit class SubClass[T <: Commission: TypeTag](list: List[T]) extends CommissionDisplay {

    def totalDisplayCommission: String = {
      list
    }

  }
}
