import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import algolia.AlgoliaDsl._
import algolia.AlgoliaClient
import scala.concurrent.ExecutionContext.Implicits.global

object AlgoliaClient {
  def main(args: Array[String]) {
    
    val conf = new SparkConf().setAppName("AlgoliaClient")
    val sc = new SparkContext(conf)

    val client = new AlgoliaClient("MY_APP_ID", "MY_SECRET")

    //case class of your objects
    case class Contact(firstname: String,
                       lastname: String,
                       followers: Int,
                       compagny: String)

    client.execute {
        index into "contacts" `object` Contact("Jimmie", "Barninger", 93, "California Paint")
    }

    client.execute {
        index into "contacts" `object` Contact("Warren", "Speach", 42, "Norwalk Crmc")
    }

    sc.stop()
  }
}
