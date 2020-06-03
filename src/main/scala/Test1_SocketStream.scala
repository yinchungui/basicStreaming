import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

object Test1_SocketStream {
  def main(args: Array[String]): Unit = {
    Logger.getLogger("org").setLevel(Level.ERROR) //配置日志
    //  为什么这个线程不能少于2????
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    val ssc = new StreamingContext(conf, Seconds(2))

    // 实时流监听的是  localhost,  9999端口
    val lines: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)

  }
}
