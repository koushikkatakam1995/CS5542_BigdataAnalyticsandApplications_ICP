import org.apache.spark.{SparkConf, SparkContext}

object Group{
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir","C:\\Users\\kiree\\Desktop\\hadoop-2.7.7-src.tar\\hadoop-2.7.7-src")
    val conf = new SparkConf().setAppName("group").setMaster("local").set("spark.driver.host","localhost")
    val sc = new SparkContext(conf)
    val input = sc.textFile("C:\\Users\\kiree\\Desktop\\UMKC\\2nd Semester\\Big Data Analytics and Applications\\ICP\\ICP2\\CS5542-Tutorial2-SparkSourceCode\\Spark WordCount\\input")
    val wc = input.flatMap(line=>{line.split(" ")})
    val out=wc.groupBy(word=>word.charAt(0))
    out.foreach(println)
  }
}